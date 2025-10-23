public class Transaction {
    public enum Type {
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXCHANGE
    }

    public final Type type;
    public final int clientId;
    public final int receiverId;
    public final String fromCurrency;
    public final String toCurrency;
    public final double amount;

    public Transaction(Type type, int clientId, int receiverId, String fromCurrency, String toCurrency, double amount) {
        this.type = type;
        this.clientId = clientId;
        this.receiverId = receiverId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }
}
