\# 📚 Library Search Engine



A console-based Java application that demonstrates practical \*\*Object-Oriented Programming, file I/O, searching, sorting algorithms, activity logging, and object serialization\*\*.



The application loads a collection of books from a text file, allows users to search and sort the collection, records user activity, and supports saving and restoring the library using Java serialization.



\---



\## 🚀 Features



\* 📖 Load books from a text file

\* 🔎 Search books by:



&#x20; \* Title

&#x20; \* Author

&#x20; \* Publication year

\* 🔤 Case-insensitive searching

\* 📊 Sort books using Bubble Sort



&#x20; \* By title

&#x20; \* By author

&#x20; \* By publication year

\* 💾 Serialize and save the library

\* 📂 Deserialize and load the library

\* 📝 Log user activity

\* 🖥️ Interactive command-line menu

\* ⚠️ Input validation and exception handling

\* ▶️ Windows batch launcher

\* 📦 Runnable JAR application



\---



\## 🛠️ Technologies Used



| Technology         | Purpose                                |

| ------------------ | -------------------------------------- |

| Java 21            | Application development                |

| Java Collections   | Store and manage books                 |

| ArrayList          | Library data structure                 |

| File I/O           | Reading book data                      |

| Serialization      | Persisting library objects             |

| Bubble Sort        | Sorting algorithms                     |

| Exception Handling | Managing invalid input and file errors |

| Git                | Version control                        |

| GitHub             | Source-code hosting                    |



\---



\## 🧠 Concepts Demonstrated



This project brings together several important Java programming concepts:



\### Object-Oriented Programming



The application uses classes and objects to represent the library and individual books.



\### Encapsulation



Book properties are private and accessed through getter methods.



```java

private String title;

private String author;

private int publicationYear;

```



\### Interfaces and Abstraction



The project focuses on applying reusable Java design principles and separating application responsibilities across classes.



\### Collections



An `ArrayList<Book>` is used to store and manage the library collection.



\### Searching



The application performs case-insensitive searches against book titles, authors, and publication years.



\### Sorting



A Bubble Sort implementation is used to organize books according to different attributes.



\### File I/O



Book information is loaded from:



```text

data/books.txt

```



\### Serialization



The complete library can be serialized to:



```text

data/library.ser

```



This allows the application to preserve the library state between program runs.



\### Logging



User actions are recorded in:



```text

logs/library\_activity.log

```



\---



\## 📁 Project Structure



```text

Library-Search-Engine/

│

├── data/

│   ├── books.txt

│   └── library.ser

│

├── logs/

│   └── library\_activity.log

│

├── src/

│   ├── ActivityLogger.java

│   ├── Book.java

│   ├── Library.java

│   ├── LibraryMenu.java

│   ├── LibrarySerializer.java

│   ├── Main.java

│   └── SortUtil.java

│

├── dist/

│   └── Library-Search-Engine.jar

│

├── out/

│   └── Compiled Java classes

│

├── .gitignore

├── README.md

└── run-library.bat

```



\---



\## 📚 Application Classes



\### `Book.java`



Represents a book in the library.



Stores:



\* Title

\* Author

\* Publication year



The class implements `Serializable` so that book objects can be persisted.



\---



\### `Library.java`



Manages the collection of books.



Responsibilities include:



\* Loading books from a text file

\* Storing books in an `ArrayList`

\* Displaying books

\* Searching the collection



\---



\### `SortUtil.java`



Contains the Bubble Sort implementations.



Books can be sorted by:



1\. Title

2\. Author

3\. Publication year



\---



\### `LibraryMenu.java`



Provides the interactive command-line interface.



The menu allows users to:



```text

1\. View All Books

2\. Search Books

3\. Sort Books

4\. Save Library

5\. Load Library

6\. Exit

```



\---



\### `LibrarySerializer.java`



Handles serialization and deserialization of the `Library` object.



It provides functionality to:



\* Save the library to a file

\* Load the library from a file



\---



\### `ActivityLogger.java`



Records important user actions performed within the application.



Examples include:



```text

VIEW\_ALL\_BOOKS

SEARCH: Tolkien

SORT: TITLE

SORT: AUTHOR

SORT: PUBLICATION\_YEAR

SAVE\_LIBRARY

LOAD\_LIBRARY

EXIT

```



\---



\### `Main.java`



The application's entry point.



It:



1\. Creates the library

2\. Loads the initial book dataset

3\. Creates the menu

4\. Starts the application



\---



\## 📄 Book Data Format



The initial dataset is stored in:



```text

data/books.txt

```



Each record follows this format:



```text

title|author|publicationYear

```



Example:



```text

1984|George Orwell|1949

Animal Farm|George Orwell|1945

The Hobbit|J.R.R. Tolkien|1937

```



\---



\## 🔎 Searching



Select:



```text

2\. Search Books

```



The application prompts:



```text

Enter title, author, or publication year:

```



For example:



```text

Enter title, author, or publication year: Tolkien

```



The application returns matching books.



Searches are case-insensitive.



\---



\## 📊 Sorting



Select:



```text

3\. Sort Books

```



The application provides:



```text

===== SORT BOOKS =====

1\. Sort by Title

2\. Sort by Author

3\. Sort by Publication Year

```



The project uses the \*\*Bubble Sort algorithm\*\* to arrange the books.



\---



\## 💾 Saving the Library



Select:



```text

4\. Save Library

```



The application serializes the library and stores it in:



```text

data/library.ser

```



Example output:



```text

===== SAVING LIBRARY =====

Library saved successfully to data/library.ser

```



\---



\## 📂 Loading the Library



Select:



```text

5\. Load Library

```



The serialized library is restored from:



```text

data/library.ser

```



Example output:



```text

===== LOADING LIBRARY =====

Library loaded successfully from data/library.ser



Library data has been loaded successfully.

```



\---



\## 📝 Activity Logging



User actions are recorded in:



```text

logs/library\_activity.log

```



This provides a simple audit trail of application activity and is also useful for debugging.



Runtime-generated log files are excluded from version control.



\---



\## ▶️ Running the Application



\### Option 1 — Windows Batch Launcher



The easiest method on Windows is:



```text

run-library.bat

```



Double-click the file or run:



```powershell

.\\run-library.bat

```



\---



\### Option 2 — Run the JAR



The application can also be started directly with:



```powershell

java -jar dist\\Library-Search-Engine.jar

```



\---



\### Option 3 — Compile from Source



Compile the project:



```powershell

javac -d out src\\\*.java

```



Run the application:



```powershell

java -cp out Main

```



\---



\## 🧪 Example Session



```text

========================================

&#x20;       LIBRARY SEARCH ENGINE

========================================

1\. View All Books

2\. Search Books

3\. Sort Books

4\. Save Library

5\. Load Library

6\. Exit

========================================

Choose an option: 2



Enter title, author, or publication year: 1954



===== SEARCH RESULTS =====

Book{title='The Lord of the Rings', author='J.R.R. Tolkien', publicationYear=1954}



Found 1 book(s).

```



Sorting example:



```text

===== SORT BOOKS =====

1\. Sort by Title

2\. Sort by Author

3\. Sort by Publication Year

Choose a sorting option: 3



Books sorted by publication year.

```



\---



\## 🔐 Data Persistence



The project demonstrates persistent application state using Java serialization.



The process is:



```text

Library Object

&#x20;     │

&#x20;     ▼

Serialization

&#x20;     │

&#x20;     ▼

library.ser

&#x20;     │

&#x20;     ▼

Deserialization

&#x20;     │

&#x20;     ▼

Library Object

```



This allows the application to save and restore the library without rebuilding the object collection from scratch.



\---



\## 🎯 Learning Outcomes



Through this project, I applied and strengthened my understanding of:



\* Java classes and objects

\* Encapsulation

\* Collections

\* ArrayLists

\* File I/O

\* Exception handling

\* Searching algorithms

\* Bubble Sort

\* Serialization

\* Deserialization

\* Menu-driven applications

\* Logging

\* Git and GitHub

\* Application packaging



\---



\## 🔮 Possible Future Improvements



Potential future enhancements include:



\* Add books through the menu

\* Remove books

\* Edit existing books

\* Advanced multi-field searching

\* More efficient sorting algorithms

\* Search result ranking

\* Book categories and genres

\* Persistent user preferences

\* Automated unit tests

\* GUI version

\* Database integration

\* Cross-platform executable packaging



\---



\## 📌 Project Status



\*\*Version:\*\* `1.0.0`



\*\*Status:\*\* Completed and functional



The application has been compiled, tested, serialized/deserialized successfully, and packaged as a runnable JAR.



\---



\## 👨‍💻 Author



\*\*Percy Ngobeni\*\*



This project was developed as part of a Java software development learning journey, with an emphasis on practical Object-Oriented Programming and application development.



\---



\## 📄 License



This project is intended primarily for educational and portfolio purposes.



