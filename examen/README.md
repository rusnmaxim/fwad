## Для запуска
Java 17
Mvn
Все

## Используемые технологии:
Spring Boot - Для использования Framework Spring и быстрого его настроийки и легкости подключения новых модулей
Spring Rest - Для подключения REST модулей
Spring Jpa - Для быстрой комуникации Классов из спринга и БД
Lombok - Аннотации которую генерируют boilerplate code
H2 in memmory database - база данных (не сохраняет состояние)

## Компоненты:
Controller - Определяет endpoints на которо приложене будет реагировать
Models - там находятся TO/Entity для комуникации с бд/внешним имром
Repositories - Jpa нтерфейс который генерирует класс и помогает для быстрого написания кода на Hibernate

##Валидация, при отправке запросов происходит валидация. В особености при создании нового товара
@NotBlank
private String name; -- Имя должно сдержать хоть какое то значение
@Min(0)
private Double price; -- Минимальная цена товара 0
@NotBlank
private String category; --  должно сдержать хоть какое то значение
@NotBlank
private String description; --  должно сдержать хоть какое то значение

## Обработка ошибок --
Добавлен ControllerAdvice и все ошибки должны быть возвращенны в виде {"error" : "message""}

##Endpoints
POST /api/books HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 110

{
"name": "Name1", //required
"author" : "Author", //required
"pages" : 3, //optional
"description" : "Something" // optinal
}

PUT /api/books/2 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 110

{
"name": "Name1", //required
"author" : "Author", //required
"pages" : 3, //optional
"description" : "Something" // optinal
}

GET /api/books HTTP/1.1
Host: localhost:8080

DELETE /api/books/2 HTTP/1.1
Host: localhost:8080



