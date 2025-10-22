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
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public static Vector[] generateVectors(int n) {
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
        double cx = this.y * other.z - this.z * other.y;
        double cy = this.z * other.x - this.x * other.z;
        double cz = this.x * other.y - this.y * other.x;
        return new Vector(cx, cy, cz);
    }

    public double getCos(Vector other) {
        double dotProduct = this.multiplyScalar(other);
        double lengths = this.length() * other.length();
        return dotProduct / lengths;
    }

    public Vector sum(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector sub(Vector other) {
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