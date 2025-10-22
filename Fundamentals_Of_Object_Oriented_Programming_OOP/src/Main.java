public class Main {
    public static void main(String[] args) {
            Vector test1 = new Vector(8, 8, 7);
            Vector test2 = new Vector(10, 12, 11);

            System.out.println("вектор 1 = " + test1);
            System.out.println("вектор 2 = " + test2);

            System.out.println("Длинна вектора 1: " + test1.length());
            System.out.println("Скалярное произведение: " + test1.multiplyScalar(test2));
            System.out.println("Векторное произведение: " + test1.cross(test2));
            System.out.println("Косинус угла между векторами: " + test1.getCos(test2));
            System.out.println("Сумма векторов: " + test1.sum(test2));
            System.out.println("Разность векторов: " + test1.sub(test2));

            Vector[] randomVectors = Vector.generateVectors(10);
            System.out.println("Random vectors:");
            for (Vector v : randomVectors) {
                System.out.println(v);
            }
    }
}

