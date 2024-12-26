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
  - OrderOptionGroup
  - OrderOption

### Shop

- Shop (Aggregate Root)

### Menu

- Menu (Aggregate Root)
  - MenuOption
  - MenuOptionGroup
  - MenuCategory

### Machine

- Machine (Aggregate Root)
  - Manufacturer

### Settlement

- Settlement (Aggregate Root)

### Receipt

- Receipt (Aggregate Root)

### Staff

- Staff (Aggregate Root)
