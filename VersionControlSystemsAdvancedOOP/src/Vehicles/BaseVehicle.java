package Vehicles;
import Interfaces.IVehicle;
import Utils.StringUtils;

public abstract class BaseVehicle implements IVehicle {
    private final String brand;
    private final String model;
    private final Enum<?> fuelType;

    public BaseVehicle(String brand, String model, Enum<?> fuelType) {
        if (brand == null || model == null || fuelType == null) {
            throw new IllegalArgumentException("Brand, model и fuelType не могут быть null ");
        }
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Enum<?> getFuelType() {
        return this.fuelType;
    }

    @Override
    public boolean start() {
        if (!StringUtils.isNullOrEmpty(this.brand)&&!StringUtils.isNullOrEmpty(this.model)) {
            System.out.println(this.brand +" "+this.model +" : is  started");
            return true;
        }
        return false;
    }

    public boolean move() {
        if (!StringUtils.isNullOrEmpty(this.brand)&&!StringUtils.isNullOrEmpty(this.model)) {
            System.out.println(this.brand +" "+this.model +" : is  moving");
            return true;
        }
        return false;
    }
}
