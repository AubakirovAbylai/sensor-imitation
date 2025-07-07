package kz.abylai.spring.sensor;

import kz.abylai.spring.sensor.dto.MeasurementDTO;
import kz.abylai.spring.sensor.dto.SensorDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class SensorSimulator {
    private static final String SERVER_URL_FOR_ADD_SENSOR = "http://localhost:8080/api/sensors/registration";
    private static final String SERVER_URL = "http://localhost:8080/measurements/add";
    private static final String SENSOR_Name="RainSensor";
    private static final RestTemplate restTemplate= new RestTemplate();

    public static void main(String[] args) {
        //registerSensor();

        for (int i = 0; i < 10; i++){
            sendMeasurement();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void registerSensor() {
        SensorDTO sensorDTO = new SensorDTO(SENSOR_Name);
        restTemplate.postForObject(SERVER_URL_FOR_ADD_SENSOR, sensorDTO, SensorDTO.class);
        System.out.println("Сенсор зарегистрирован: " + SENSOR_Name);
    }

    public static void sendMeasurement() {
        Random random = new Random();

        int temperature = random.nextInt(201) - 100;
        boolean rain = random.nextBoolean();
        SensorDTO sensorDTO = new SensorDTO(SENSOR_Name);
        MeasurementDTO  measurementDTO = new MeasurementDTO(temperature, rain, sensorDTO);

        String response = restTemplate.postForObject(SERVER_URL, measurementDTO, String.class);
        System.out.println("Ответ от сервера: " + response);
        System.out.println("Отправлено: " + temperature + "°C, дождь = " + rain);
    }

}
