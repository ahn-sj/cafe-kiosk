# cafe-kiosk

This project demonstrates the application of Domain-Driven Design (DDD) principles in a cafe kiosk system. 
It focuses on key DDD building blocks, including:

- Entities
- Aggregate Root
- Value Object
- Repository

---

## Domain Model

### Order

- Order (Aggregate Root)
  - OrderItem
  - Customer
  - Payment
  - Staff

### Product

- Product (Aggregate Root)
  - ProductOption
  - ProductOptionGroup
  - ProductCategory

### Payment

- Payment (Aggregate Root)
  - Transaction
  - PaymentMethod
  - Refund

### Promotion

- Promotion (Aggregate Root)
  - DiscountPolicy

### Kiosk

- Kiosk (Aggregate Root)
  - KioskLocation
  - KioskStatus
