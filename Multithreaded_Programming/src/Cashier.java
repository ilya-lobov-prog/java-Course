public class Cashier extends Thread {
    private final int id;
    private final Bank bank;
    private volatile boolean active = true;

    public Cashier(int id, Bank bank) {
        this.id = id;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (active) {
            try {
                Transaction tx = bank.getTransactionQueue().take();
                processTransaction(tx);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                bank.notifyObservers("Ошибка в кассе #" + id + ": " + e.getMessage());
            }
        }
    }

    private void processTransaction(Transaction tx) {
        Client sender = bank.getClient(tx.clientId);
        Client receiver = bank.getClient(tx.receiverId);

        switch (tx.type) {
            case DEPOSIT -> {
                sender.addMoney(tx.amount);
                bank.notifyObservers("Касса #" + id + ": Пополнение " + sender);
            }
            case WITHDRAW -> {
                sender.withdrawMoney(tx.amount);
                bank.notifyObservers("Касса #" + id + ": Снятие " + sender);
            }
            case TRANSFER -> {
                if (sender.withdrawMoney(tx.amount)) {
                    receiver.addMoney(tx.amount);
                    bank.notifyObservers("Касса #" + id + ": Перевод " + tx.amount + " от " + sender + " к " + receiver);
                } else {
                    bank.notifyObservers("Недостаточно средств у клиента " + sender.getId());
                }
            }
            case EXCHANGE -> {
                double rateFrom = bank.getExchangeRate(tx.fromCurrency);
                double rateTo = bank.getExchangeRate(tx.toCurrency);
                double converted = tx.amount * rateFrom / rateTo;
                sender.withdrawMoney(tx.amount);
                sender.addMoney(converted);
                sender.setCurrency(tx.toCurrency);
                bank.notifyObservers("Касса #" + id + ": Обмен " + tx.amount + " " + tx.fromCurrency + " -> " + converted + " " + tx.toCurrency);
            }
        }
    }

    public void shutdown() {
        active = false; interrupt();
    }
}