# Добавить студента
```curl -d '{"id":1, "name":"Somename", "age":20, "birthdate": "20.12.1990"}' -H "Content-Type: application/json" -X POST http://localhost:8080```

# Изменить
```curl -d '{"id":1, "name":"Changedname", "age":40, "birthdate": "20.12.1980"}' -H "Content-Type: application/json" -X PUT http://localhost:8080/1```

# Удалить
```curl -X DELETE http://localhost:8080/1```

# Собрать проект
```sbt assembly```

# Запустить проект
```java -jar path/to/SprayCrud-assembly-1.0.jar```
