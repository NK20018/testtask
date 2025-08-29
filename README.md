# Інструкція з запуску тестів з Allure

##  Попередні вимоги
- Встановлений **JDK 21** 
- Встановлений **Maven**

---

## Кроки для запуску тестів

1. Клонувати репозиторій:
   ```bash
   git clone git@github.com:NK20018/testtask.git
2. Запустити всі тести
   ```bash
   mvn clean test
3. Згенерувати Allure-звіт:
   ```bash
   mvn allure:report
4. Відкрити Allure-звіт у браузері
   ```bash
   mvn allure:serve