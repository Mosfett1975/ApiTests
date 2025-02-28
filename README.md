Тестовое задание

При первом запуске необходимо выполнить mvn allure:install из командной строки
либо запустить в среде разработки - Maven->Plugins->allure->allure:install

Для запуска тестов выполнить mvn clean test
Для получения отчета выполнить mvn allure:serve

Пример Allure отчета:
![alt text](https://github.com/Mosfett1975/ApiTests/blob/master/img/reportexample.jpg?raw=true)

При создании использовался JDK-17.0.7 и Maven 3.9.9