package Interfaces;

public interface IVehicle {
    String getBrand();
    String getModel();
    Enum<?> getFuelType();
    boolean start();
}
