# 🥪 Leaf & Loaf - Deli Ordering CLI App

Welcome to **Leaf & Loaf**, a console-based deli ordering system built in Java. Designed as a capstone project, this application offers a full-stack simulation of a real-world deli experience—all within a clean, modular CLI interface.

---

## 📌 Project Overview

**Leaf & Loaf** allows users to:

* Build custom sandwiches (size, bread, toppings, toast)
* Add drinks and chips to complete a meal
* View a formatted order summary
* Generate a receipt saved as a `.txt` file

The app emphasizes **reusability**, **OOP design**, and **user-centered interaction**, making it a strong foundation for future feature expansion.

---

## 📂 Project Structure

```bash
LeafandLoaf/
├── src/
│   └── main/
│       └── java/
│           └── com/LeafandLoaf/
│               ├── models/          # Sandwich, Drink, Chip, Order
│               │   └── enums/       # Size, BreadType, ToppingType
│               ├── data/           # ReceiptWriter, OrderDataManager
│               ├── ui/             # App.java CLI runner
│               └── util/           # InputHelper, UIHelper
└── resources/
    └── receipts/                   # Receipt output directory
```

---

## 🧠 Key Features

### 🔴 Core Functionality

* 🧱 **Modular Structure** – Uses packages like `models`, `data`, `ui`, and `util`
* 🥪 **Custom Sandwich Creation** – Choose bread, size, toppings, and toasting
* 🥤 **Drinks & Chips** – Add optional sides to complete your meal
* 🧾 **Receipt Generation** – Saves order summary with timestamped filename
* 🧮 **Dynamic Pricing** – Premium toppings and extra charges handled with logic

### 🟠 Enhanced UX & Code Design

* 🧭 **UIHelper & InputHelper** – Clean CLI prompts and input validation
* 🧱 **Enums for Consistency** – BreadType, Size, ToppingType, etc.
* 🧼 **Price Calculator** – Toppings and sizes calculate dynamically
* 🧪 **Separation of Concerns** – Each class handles its own responsibility


---

## 🎮 Sample User Flow

```
Welcome to Leaf & Loaf!
1) Start New Order
0) Exit

-> Choose Bread
-> Select Size
-> Add Toppings (with extra option for premium)
-> Toasted? (yes/no)
-> Add Drink
-> Add Chips
-> Checkout

Final Order Summary:
- Sandwich: 8 inch on wheat sandwich (toasted)
  - Toppings: Lettuce, Tomato, Vegan Cheese (Extra)
- Drink: Large - Lemon Iced Tea
- Chips: Pita Chips
Total: $13.75

Receipt saved to: /resources/receipts/Order_002_20250528_105400.txt
```

---

## 🛠️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/yourusername/LeafAndLoaf.git
cd LeafAndLoaf
```

2. Open the project in your favorite Java IDE (IntelliJ, Eclipse, VS Code)

3. Run the `App.java` file (entry point)

---

## 📋 Requirements

* Java 17+
* Console/terminal environment
* No external libraries required

---

## 📜 Credits

Project by **Brian Miller**
Capstone developed for YearUp Software Development Track

---
