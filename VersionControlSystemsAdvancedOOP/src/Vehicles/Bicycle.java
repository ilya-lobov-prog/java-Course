package Vehicles;
import FuelTypes.FuelTypeForBicycle;
import Utils.EnumUtils;

// Велосипед
public class Bicycle extends BaseVehicle {

    public Bicycle(String brand, String model, FuelTypeForBicycle fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public FuelTypeForBicycle getFuelType() {
        return  (FuelTypeForBicycle) EnumUtils.castToEnum(super.getFuelType(), FuelTypeForBicycle.class);
    }

    @Override
    public boolean move() {
        System.out.println("Прут, как угорелые, крутят педаль —\n" +
                "Плевать на ПДД, им закон — не деталь.\n" +
                "В ушах наушники, в башке сквозняк,\n" +
                "А потом орут: «Это ты был не так!»");
        return false;
    }
}
