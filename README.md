mvn clean test

Azure DevOps pipeline:
https://dev.azure.com/YauheniPo/WebTestFramework/_build?definitionId=7

//не выполнял скрол для подгрузки всех остальных динамических элементов результатов поиска, т.к. проверка кейса этого не требует

Patterns:
- Page Object (Test Framework)
- Singleton (Browser)
- Delegate (ResourcePropertiesManager)

По времени:
- ~4 hours - имплементация классов папки framework
- ~1.5 hours - обдумывание имплементации Page Object
- ~2-3 hours - имплементация и корректировка реализации
- ~1 hour - стабилизация тестов и настройка Azure DevOps pipeline