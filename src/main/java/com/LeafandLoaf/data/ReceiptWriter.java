package com.LeafandLoaf.data;

import com.LeafandLoaf.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    // Static file path variable
    private static final String RECEIPT_FOLDER = "src/main/resources/receipts.txt";

    // Static method that takes an order and writes the receipt
    public static void write(Order order) {

        // Creates the receipt folder
        File folder = new File(RECEIPT_FOLDER);

        // If the file doesn't exist make it using mkdirs()
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Formats the timestamp
        String timestamp = order.getTime().format(DateTimeFormatter.ofPattern("HHmmss"));

        // Formats the date
        String date = order.getDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Create the filename
        String filename = String.format("Order_%d_%s_%s.txt", order.getId(), date, timestamp);

        // Combines the folder and filename
        File receiptfile = new File(folder, filename);

        // Try catch for opening file and writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptfile))){

            // Write order summary
            writer.write(order.summary());

            // Spacing
            writer.newLine();

            // Thank you footer
            writer.write("Thank you for dining at Leaf & Loaf.");




          // If something happens catch the issue and print out error
        } catch (IOException e) {
            System.out.println("Failed to write receipt: " + e.getMessage());
        }
    }

}
