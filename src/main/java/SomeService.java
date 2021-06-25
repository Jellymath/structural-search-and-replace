import java.util.Random;

public class SomeService {
    public static final Random RANDOM = new Random();

    public int foo() {
        return RANDOM.nextInt();
    }
}
