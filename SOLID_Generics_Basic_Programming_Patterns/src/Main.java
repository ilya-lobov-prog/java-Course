import StringExtensions.ListenerStringBuilder;
import StringExtensions.StringListener;

public class Main {
    public static void main(String[] args) {
        ListenerStringBuilder lsb = new ListenerStringBuilder();
        StringListener listener1 = new StringListener() {
            private String Name = "Слушатель1";
            @Override
            public void onChange(String newValue) {
                System.out.println("Новое значение " + Name + ": " + newValue);
            }

            @Override
            public String toString() {
                return "Listener" + Name;
            }
        };

        StringListener listener2 = new StringListener() {
            private String Name = "Слушатель2";
            @Override
            public void onChange(String newValue) {
                System.out.println("Новое значение получено " + Name + ": " + newValue);
            }

            @Override
            public String toString() {
                return "Listener" + Name;
            }
        };
        System.out.println("Регистрация слушателя " + listener1);
        lsb.addListener(listener1);
        System.out.println("Регистрация слушателя " + listener2);
        lsb.addListener(listener2);
        lsb.append("Hello ")
           .append("world ")
           .append("!");

        lsb.replace(6,11,"Илья");
        System.out.println("Удаление первого слушателя");
        lsb.removeListener(listener1);
        System.out.println("Изменение Ильи на Java");
        lsb.replace(6,11,"Java");
        System.out.println("Вставление восклицательного знака");
        lsb.insert(0,"! ");
        System.out.println("Удаление Java");
        lsb.delete(8,12);
        System.out.println("Длинна строки");
        System.out.println(lsb.length());
        System.out.println(lsb);
    }
}