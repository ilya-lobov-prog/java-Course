public class Main {
    public static void main(String[] args) {
        try {
            Bank bank = new Bank(2);
            bank.addObserver(new Logger());

            Client c1 = new Client(1, 1000, "USD");
            Client c2 = new Client(2, 500, "EUR");

            bank.addClient(c1);
            bank.addClient(c2);

            bank.addTransaction(new Transaction(Transaction.Type.DEPOSIT, 1, 0, null, null, 200));
            bank.addTransaction(new Transaction(Transaction.Type.TRANSFER, 1, 2, null, null, 100));
            bank.addTransaction(new Transaction(Transaction.Type.EXCHANGE, 2, 0, "EUR", "USD", 50));

            Thread.sleep(10000);
            System.out.println("Конец симуляции");
            System.exit(0);
        } catch (InterruptedException e) {
            System.err.println("Всё сломалось");
        }

    }
}