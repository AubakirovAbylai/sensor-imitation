# 🤖 Sensor Emulator Microservice

Микросервис на Spring Boot, имитирующий работу физического сенсора.  
Периодически отправляет погодные данные (температура, дождь/не дождь) на указанный REST API сервер.

---

## 🔧 Технологии

- Java 17+
- Spring Boot
- REST Client (`RestTemplate` или `WebClient`)
- DTO для передачи данных

## 🚀 Что делает этот сервис?

- Имя сенсора задаётся при запуске (или через конфиг)
- Каждые 1 секунд отправляется замер:
  - температура (случайное значение в заданном диапазоне)
  - `raining` — случайно `true` или `false`
  - `timestamp` (автоматически)
- Замер отправляется на целевой **REST API сервер** (обычно `sensor-weather-logger`)

##Пример запроса

POST /measurements
Content-Type: application/json

{
  "temperature": 23.5,
  "raining": false,
  "sensor": {
    "name": "Sensor-1"
  }
}
