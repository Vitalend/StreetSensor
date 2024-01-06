import java.util.Random;

public class Measurements {

    public String value() {
        Random random = new Random();

        int value = random.nextInt(201);
        value = value - 100;
        return String.valueOf(value);
    }

    public String raining() {
        Random random = new Random();

        return String.valueOf(random.nextBoolean());
    }

    public String sensor() {
        Random random = new Random();

        int numb = random.nextInt(7);
        numb = numb + 1;
        return "sensor" + String.valueOf(numb);

    }

}
