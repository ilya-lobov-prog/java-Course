import java.time.LocalDateTime;

public class Logger implements Observer {
    @Override
    public synchronized void update(String message) {
        System.out.printf("[%s] LOG: %s%n", LocalDateTime.now(), message);
    }
}
