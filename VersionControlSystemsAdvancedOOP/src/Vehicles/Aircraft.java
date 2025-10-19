package Vehicles;
import FuelTypes.FuelTypeForAircraft;
import Utils.EnumUtils;
import Utils.StringUtils;

// самолёт
public class Aircraft extends BaseVehicle {

    public Aircraft(String brand, String model, FuelTypeForAircraft fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public FuelTypeForAircraft getFuelType() {
        return (FuelTypeForAircraft)EnumUtils.castToEnum(super.getFuelType(), FuelTypeForAircraft.class);
    }
    @Override
    public boolean move() {
        if (!StringUtils.isNullOrEmpty(super.getBrand())&&!StringUtils.isNullOrEmpty(super.getModel())) {
            System.out.println("Кар кар,  блин полетел я Курица(ну почти)");
            return true;
        }
        return false;
    }
}
