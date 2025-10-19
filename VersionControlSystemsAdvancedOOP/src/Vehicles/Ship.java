package Vehicles;

import FuelTypes.FuelTypeForShip;
import Utils.EnumUtils;

// корабль
public class Ship extends BaseVehicle {
    public Ship(String brand, String model, FuelTypeForShip fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public FuelTypeForShip getFuelType() {
        return (FuelTypeForShip)EnumUtils.castToEnum(super.getFuelType(), FuelTypeForShip.class);
    }

    @Override
    public boolean move() {
        System.out.println("Моряк с причала шагает, как царь —\n" +
                "Весь день бухал, а теперь ему — драйв.\n" +
                "Матросская удаль, пузо — как флаг,\n" +
                "На суше — ноль, но орёт, будто маг.");
        return false;
    }
}
