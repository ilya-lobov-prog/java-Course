import StringExtensions.ListenerStringBuilder;
import StringExtensions.StringListener;

public class Main {
    public static void main(String[] args) {
        try {
            ListenerStringBuilder lsb = new ListenerStringBuilder();

            StringListener listener1 = new StringListener() {
                private final String Name = "Слушатель1";
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
                private final String Name = "Слушатель2";
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

            try {
                lsb.append("Hello ")
                        .append("world ")
                        .append("!");
            } catch (Exception e) {
                System.out.println("Ошибка при добавлении текста: " + e.getMessage());
            }

            try {
                lsb.replace(6, 11, "Илья");
            } catch (Exception e) {
                System.out.println("Ошибка при замене текста: " + e.getMessage());
            }

            System.out.println("Удаление первого слушателя");
            lsb.removeListener(listener1);

            try {
                System.out.println("Изменение Ильи на Java");
                lsb.replace(6, 10, "Java");
            } catch (Exception e) {
                System.out.println("Ошибка при повторной замене текста: " + e.getMessage());
            }

            try {
                System.out.println("Вставление восклицательного знака");
                lsb.insert(0, "! ");
            } catch (Exception e) {
                System.out.println("Ошибка при вставке текста: " + e.getMessage());
            }

            try {
                System.out.println("Удаление Java");
                lsb.delete(8, 12);
            } catch (Exception e) {
                System.out.println("Ошибка при удалении текста: " + e.getMessage());
            }

            try {
                System.out.println("Длина строки");
                System.out.println(lsb.length());
            } catch (Exception e) {
                System.out.println("Ошибка при получении длины: " + e.getMessage());
            }

            try {
                System.out.println(lsb);
            } catch (Exception e) {
                System.out.println("Ошибка при выводе строки: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Необработанная ошибка  фиг его фиг его знает чего оно может упасть:" + e.getMessage());
            e.printStackTrace();
        }
    }
}