import FuelTypes.FuelTypeForAircraft;
import FuelTypes.FuelTypeForBicycle;
import FuelTypes.FuelTypeForCar;
import FuelTypes.FuelTypeForShip;
import Interfaces.IVehicle;
import Vehicles.*;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.print("Старт : ");
            System.out.println();
            Car car = new Car("Bmw", "M3", FuelTypeForCar.LPG);
            car.engine = car.new ForceEngine();
            car.printEngine();


            Aircraft aircraft = new Aircraft("Boeing", "737", FuelTypeForAircraft.JET_FUEL);
            Bicycle bicycle = new Bicycle("Mongoose", "Switchback", FuelTypeForBicycle.HUMAN_POWER);
            Ship ship = new Ship("Majesty", "111", FuelTypeForShip.MARINE_DIESEL);


            IVehicle[] vehicles = new IVehicle[]{car, aircraft, bicycle, ship};
            System.out.println("перечень транспортных средств: ");

            for (var vehicle : vehicles) {
                System.out.print("транспортное средсво: " + vehicle.getBrand() + " " + vehicle.getModel());
                System.out.println();
                BaseVehicle temp = (BaseVehicle) vehicle;
                boolean isMove = temp.move();
                System.out.println();
            }
        } catch (Exception exception) {
              System.err.println("Завершилась с ошибкой." + exception.getMessage());
        }
    }
}
