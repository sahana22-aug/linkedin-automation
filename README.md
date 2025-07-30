# 💼 LinkedIn Search Automation

This project is a **LinkedIn automation tool** developed using **Java, Selenium WebDriver, Maven**, and **ChromeDriver**. It is designed to **automatically log in to LinkedIn**, search for a specified keyword (e.g., “Hospitals”), and **scrape profile data from 100+ pages** under the "People" tab.

---

## 🚀 Project Objective

The main goal of this project is to **automate LinkedIn search results** for specific professions, companies, or industries and extract basic profile information like **user names and job titles** for analysis or research purposes.

---

## 🔧 Technologies Used

| Tool | Purpose |
|------|---------|
| **Java (JDK 21)** | Core programming language |
| **Maven** | Project management & dependency tool |
| **Selenium WebDriver** | Web browser automation |
| **ChromeDriver** | Enables Selenium to automate Chrome |
| **Eclipse IDE** | Development environment |

---

## ✨ Features

✅ Logs into LinkedIn automatically using valid credentials  
✅ Searches for user-defined keywords (default: `Hospitals`)  
✅ Navigates to the **People** tab  
✅ Extracts names and job titles from each result  
✅ Iterates through **100+ pages** efficiently  
✅ Saves output to a `CSV` file (`output.csv`)  
✅ Error-handling and wait logic for dynamic content loading

---

## 🧑‍💻 How to Use

### 1️⃣ Prerequisites
- Java installed (recommended: JDK 21)
- Maven installed
- Google Chrome browser (latest version)
- Compatible `chromedriver.exe` (placed inside `/drivers` folder)

### 2️⃣ Steps to Run
1. Clone the repository  
2. Open it in **Eclipse IDE**  
3. Update `LinkedInScraper.java` with your LinkedIn email & password  
4. Set the correct path for `chromedriver.exe`  
5. Run the `main()` method

### 🗂 Output:
- The data is saved in a file called `output.csv` in your root directory.

---

## 📁 Project Structure

linkedin-automation/
│
├── src/main/java/
│ └── LinkedInScraper.java
│
├── drivers/
│ └── chromedriver.exe
│
├── output.csv
├── pom.xml
└── README.md


