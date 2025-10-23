import java.util.*;
import java.util.concurrent.*;

public class Bank {
    private final ConcurrentMap<Integer, Client> clients = new ConcurrentHashMap<>();
    private final BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    private final ConcurrentMap<String, Double> exchangeRates = new ConcurrentHashMap<>();
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final List<Cashier> cashiers = new ArrayList<>();

    public Bank(int cashierCount) {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.9);
        exchangeRates.put("RUB", 100.0);


        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(this::updateRates, 0, 5, TimeUnit.SECONDS);


        for (int i = 0; i < cashierCount; i++) {
            Cashier cashier = new Cashier(i + 1, this);
            cashiers.add(cashier);
            cashier.start();
        }
    }

    public void addClient(Client c) {
        clients.put(c.getId(), c);
        notifyObservers("Добавлен клиент: " + c);
    }

    public Client getClient(int id) {
        return clients.get(id);
    }

    public void addTransaction(Transaction tx) {
        transactionQueue.offer(tx);
    }

    public BlockingQueue<Transaction> getTransactionQueue() {
        return transactionQueue;
    }

    public double getExchangeRate(String currency) {
        return exchangeRates.getOrDefault(currency, 1.0);
    }

    private void updateRates() {
        Random r = new Random();
        exchangeRates.forEach((k, v) -> exchangeRates.put(k, v * (0.99 + r.nextDouble() * 0.02)));
        notifyObservers("Курсы валют обновлены: " + exchangeRates);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}
