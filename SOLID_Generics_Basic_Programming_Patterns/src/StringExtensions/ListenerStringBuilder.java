package StringExtensions;
import java.util.ArrayList;
import java.util.List;

public class ListenerStringBuilder {
    private final StringBuilder builder = new StringBuilder();
    private final List<StringListener> listeners = new ArrayList<>();

    public void addListener(StringListener listener) {
        listeners.add(listener);
    }

    public void removeListener(StringListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (StringListener listener : listeners) {
            listener.onChange(builder.toString());
        }
    }

    public ListenerStringBuilder append(String str) {
        builder.append(str);
        notifyListeners();
        return this;
    }

    public ListenerStringBuilder insert(int offset, String str) {
        builder.insert(offset, str);
        notifyListeners();
        return this;
    }

    public ListenerStringBuilder delete(int start, int end) {
        builder.delete(start, end);
        notifyListeners();
        return this;
    }

    public ListenerStringBuilder replace(int start, int end, String str) {
        builder.replace(start, end, str);
        notifyListeners();
        return this;
    }

    public int length() {
        return builder.length();
    }

    public String toString() {
        return builder.toString();
    }
}
