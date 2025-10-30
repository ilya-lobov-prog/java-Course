import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lesson 1!");
        try (Scanner scanner = new Scanner(System.in)) {
            int count = readConsole(scanner,"Введите размер массива: ");
            if (count < 1)
                throw new IllegalArgumentException("Неправильный ввод значения!");

            int max = readConsole(scanner,"Введите максимальное значение:");

            int min = readConsole(scanner,"Введите минимальное значение: ");

            int[] arr = new int[count];
            fillArray(arr, min, max);
            printArray("сгенерированный массив: ", arr);

            int maxValue = getMaxValue(arr);
            int minValue = getMinValue(arr);
            double averageValue = getAverageValue(arr);
            System.out.println("Максимальное значение: " + maxValue + " минимальное значение: " + minValue + " Среднее значение: " + averageValue);


            insertionSortAscending(arr);
            printArray("сортировка массива по возрастанию: ", arr);

            insertionSortDescending(arr);
            printArray("сортировка массива по убыванию: ", arr);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static int getMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static double getAverageValue(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    private static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random() * (max - min + 1)) + min;
        }
    }


    private static int readConsole( Scanner scanner, String inviteMessage) {
        while (true) {
            try {
                System.out.print(inviteMessage);

                if (!scanner.hasNextLine()) {
                    System.out.println("Ввод завершён (EOF получен). Повторный ввод невозможен.");
                    break;
                }

                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Ничего не введено. Попробуйте снова.");
                    continue;
                }

                try {
                    int value = Integer.parseInt(input);

                    if (value <= 0) {
                        System.out.println("Число должно быть положительным и больше 0. Попробуйте снова.");
                        continue;
                    }

                    return value;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: \"" + input + "\" не является целым числом.");
                }

            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                break;
            }
        }
        return -1;
    }




    public static void insertionSortAscending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void insertionSortDescending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void printArray(String message, int[] array) {
        System.out.println(message);
        System.out.println(Arrays.toString(array));
    }

    // double Override
    private static void fillArray(double[] arr, double min, double max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (Math.random() * (max - min + 1)) + min;
        }
    }

    public static void printArray(String message, double[] array) {
        System.out.println(message);
        System.out.println(Arrays.toString(array));
    }

    private static double getMaxValue(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static double getMinValue(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static double getAverageValue(double[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public static void insertionSortAscending(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void insertionSortDescending(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }


}