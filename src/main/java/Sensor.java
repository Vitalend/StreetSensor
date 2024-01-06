import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Sensor {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        Measurements measurements = new Measurements();

        String postUrl = "http://localhost:6060/weather/new";
        String newSensorUrl = "http://localhost:6060/sensors/new";

        Map<String, String> newSensor = new HashMap<>();
        newSensor.put("name", "sensor7");

        HttpEntity<Map<String, String>> sensorRequest = new HttpEntity<>(newSensor);

        String stringToSendSensor = restTemplate.postForObject(
                newSensorUrl, sensorRequest, String.class);

        System.out.println(stringToSendSensor);

        for (int i = 0; i < 1000; i++) {
            Map<String, String> toSend = new HashMap<>();
            toSend.put("value", measurements.value());
            toSend.put("raining", measurements.raining());
            toSend.put("sensor", measurements.sensor());

            HttpEntity<Map<String, String>> request = new HttpEntity<>(toSend);

            String stringToSend = restTemplate.postForObject(postUrl, request, String.class);

            System.out.println(stringToSend);
        }

        String url = "http://localhost:6060/weather/all";
        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);
    }
}
