import java.util.concurrent.atomic.AtomicReference;

public class Client {
    private final int id;
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);
    private final AtomicReference<String> currency = new AtomicReference<>("RUB");

    public Client(int id, double balance, String currency) {
        this.id = id;
        this.balance.set(balance);
        this.currency.set(currency);
    }

    public int getId() { return id; }
    public double getBalance() { return balance.get(); }
    public String getCurrency() { return currency.get(); }

    public void setCurrency(String newCurrency) {
        currency.set(newCurrency);
    }

    public void addMoney(double amount) {
        balance.updateAndGet(b -> b + amount);
    }

    public boolean withdrawMoney(double amount) {
        return balance.updateAndGet(b -> b >= amount ? b - amount : b) != balance.get();
    }

    @Override
    public String toString() {
        return String.format("Client{id=%d, balance=%.2f, currency='%s'}", id, getBalance(), getCurrency());
    }
}
