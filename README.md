


# 📚 LibraNet

LibraNet is an **library management system** that supports **Books, AudioBooks, and E-Magazines**.  
It provides borrowing, returning, fine calculation, and specialized behaviors (like playing audiobooks and archiving e-magazines).

---

## 🚀 Features
- Borrow & return library items
- Fine calculation (`₹10/day` overdue)
- Specialized behaviors:
  - 📖 **Books** → page count
  - 🎧 **Audiobooks** → playable
  - 📰 **E-Magazines** → archivable
- Custom exception handling
- Menu-based user interaction

---

## 📂 Project Structure
```

LibraNet/
├── src/
│   ├── Main.java
│   ├── Book/
│   │   └── Book.java
│   ├── AudioBook/
│   │   └── AudioBook.java
│   ├── Emagazine/
│   │   └── EMagazine.java
│   ├── LibraNetItem/
│   │   └── LibraryItem.java
│   └── com/CustomException/
│       └── CustomException.java
└── README.md

````



## ▶️ Running the Program

1. **Clone the repository**
   ```bash
   git clone https://github.com/username/LibraNet.git
   cd LibraNet
    ````

2. **Open the project** in IntelliJ IDEA / Eclipse / VS Code.

3. **Run the program**

   ```bash
   src/Main.java
   ```

---

## 🧪 Example Interaction

```
Welcome to LibraNet!
1. Admin Menu
2. Customer Menu
Enter your choice: 1

--- Admin Menu ---
1. Add Book
2. Add AudioBook
3. Add E-Magazine
4. Exit
```


---

## 🔮 Future Scope

- **Database Integration**:  
  Maintain a database to track the exact number of items available and manage their quantities efficiently.

- **Efficient Searching**:  
  - Sort products by ID to enable binary search for faster lookup.  
  - Alternatively, maintain a `Map` for O(1) search time complexity.

- **Authentication & Authorization**:  
  Implement user authentication to differentiate between **Admin** (can add/remove items) and **Customer** (can borrow/return items).

---

## 👨‍💻 Author

Anshumaan Rath





