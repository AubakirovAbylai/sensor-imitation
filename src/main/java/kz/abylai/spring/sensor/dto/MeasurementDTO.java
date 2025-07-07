package kz.abylai.spring.sensor.dto;


public class MeasurementDTO {
    private Integer temperature;

    private Boolean raining;

    private SensorDTO sensor;

    public MeasurementDTO() {}

    public MeasurementDTO(Integer temperature, Boolean raining, SensorDTO sensor) {
        this.temperature = temperature;
        this.raining = raining;
        this.sensor = sensor;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensorName() {
        return sensor;
    }

    public void setSensorName(SensorDTO sensorName) {
        this.sensor = sensorName;
    }
}
