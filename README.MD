# 🍕 PIZZIO Shop POS System

## Project Demo Video

Watch the demo here:  
https://yearuptemp-my.sharepoint.com/:v:/g/personal/amyint_my_yearupunited_org/IQC0YWhmNn0mQpm3nthNCfhtAUnCoBCrC9DB_30u_Yh-MzU?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=WRMg0Z

## Overview
PIZZIO Shop is a Java-based Point of Sale (POS) application for a custom pizza restaurant.  
This console application allows customers to fully customize pizza orders, add drinks and garlic knots, review their order, and generate receipt files automatically.

The project was built using Object-Oriented Programming (OOP) principles and demonstrates:
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- File I/O
- Collections

---

# Features

## Home Screen
- Start a new order
- Exit the application

## Order Management
- Add one or more pizzas
- Add drinks
- Add garlic knots
- Checkout
- Cancel order

## Pizza Customization
Customers can customize:
- Pizza size
    - Personal (8")
    - Medium (12")
    - Large (16")
- Crust type
    - Thin
    - Regular
    - Thick
    - Cauliflower
- Toppings
    - Meats
    - Cheeses
    - Vegetables
    - Sauces
- Extra toppings
- Stuffed crust option

## Checkout
- View complete order summary
- Display total price
- Confirm order
- Generate receipt file automatically

## Receipt Generation
- Receipts are saved in a `/files` folder
- Receipt filename format:

```text
order-detail : yyyyMMdd-hhmmss.txt
orders       : yyyyMMdd.txt