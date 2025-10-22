package Vehicles;

import FuelTypes.FuelTypeForCar;
import Utils.EnumUtils;
import Utils.StringUtils;

// автомобиль
public class Car extends BaseVehicle {

    private String carModel = "This is a car model";

    public Engine engine;

    public Car(String brand, String model, FuelTypeForCar fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public FuelTypeForCar getFuelType() {
        return (FuelTypeForCar)EnumUtils.castToEnum(super.getFuelType(), FuelTypeForCar.class);
    }

    @Override
    public boolean start() {
        return super.start();
    }

    public void printEngine() {
        if (engine != null) {
            engine.startEngine();
        }
    }

    public sealed class Engine permits ForceEngine {
        public Engine() {
        }
        public boolean startEngine() {
            if (!StringUtils.isNullOrEmpty(getBrand())&&!StringUtils.isNullOrEmpty(getModel()) && !StringUtils.isNullOrEmpty(carModel)) {
                System.out.println(carModel + " ForceEngine " + getBrand() + " " + getModel());
                return true;
            }
            return true;
        }
    }

    public final class ForceEngine extends Engine {
        @Override
        public boolean startEngine() {
            if (!StringUtils.isNullOrEmpty(getBrand())&&!StringUtils.isNullOrEmpty(getModel())) {
                System.out.println(carModel + " ForceEngine " + getBrand() + " " + getModel());
                return true;
            }
            return false;
        }
    }
}
