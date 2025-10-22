import java.util.Random;

public final class Vector {

    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double multiplyScalar(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }

        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public static Vector[] generateVectors(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Количество векторов не может быть отрицательным");
        }
        Random random = new Random();
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble() * 100 - 50;
            double y = random.nextDouble() * 100 - 50;
            double z = random.nextDouble() * 100 - 50;
            vectors[i] = new Vector(x, y, z);
        }
        return vectors;
    }

    public Vector cross(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }
        double cx = this.y * other.z - this.z * other.y;
        double cy = this.z * other.x - this.x * other.z;
        double cz = this.x * other.y - this.y * other.x;
        return new Vector(cx, cy, cz);
    }

    public double getCos(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }

        double length1 = this.length();
        double length2 = other.length();

        if (length1 == 0 || length2 == 0) {
            throw new ArithmeticException("Нельзя вычислить угол с нулевым вектором");
        }

        double dotProduct = this.multiplyScalar(other);
        return dotProduct / (length1 * length2);
    }

    public Vector sum(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }

        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector sub(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}