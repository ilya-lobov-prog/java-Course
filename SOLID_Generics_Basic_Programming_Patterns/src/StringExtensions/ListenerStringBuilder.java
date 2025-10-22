package StringExtensions;
import java.util.ArrayList;
import java.util.List;

public class ListenerStringBuilder {
    private final StringBuilder builder = new StringBuilder();
    private final List<StringListener> listeners = new ArrayList<>();

    public void addListener(StringListener listener) {
        if (listener == null) {
            System.out.println("Попытка добавить null-слушателя проигнорирована.");
            return;
        }
        listeners.add(listener);
    }

    public void removeListener(StringListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        String current = builder.toString();
        for (StringListener listener : listeners) {
            try {
                if (listener != null) {
                    listener.onChange(current);
                }
            } catch (Exception e) {
                System.out.println("Ошибка в слушателе: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public ListenerStringBuilder append(String str) {
        try {
            builder.append(str);
            notifyListeners();
        } catch (Exception e) {
            System.out.println("Ошибка при append: " + e.getMessage());
        }
        return this;
    }

    public ListenerStringBuilder insert(int offset, String str) {
        try {
            builder.insert(offset, str);
            notifyListeners();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный offset в insert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при insert: " + e.getMessage());
        }
        return this;
    }

    public ListenerStringBuilder delete(int start, int end) {
        try {
            builder.delete(start, end);
            notifyListeners();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверные индексы в delete: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при delete: " + e.getMessage());
        }
        return this;
    }

    public ListenerStringBuilder replace(int start, int end, String str) {
        try {
            builder.replace(start, end, str);
            notifyListeners();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверные индексы в replace: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при replace: " + e.getMessage());
        }
        return this;
    }

    public int length() {
        return builder.length();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
