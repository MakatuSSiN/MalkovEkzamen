import java.util.ArrayList;
import java.util.List;


//разработать класс для хранения данных об автомобилях, находящихся в таксопарке. Использую созданный класс, смоделировать работу приложения.
public class Main {
    public static class Car {
        private String licensePlate;
        private String model;
        private int year;

        public Car(String licensePlate, String model, int year) {
            this.licensePlate = licensePlate;
            this.model = model;
            this.year = year;
        }

        @Override
        public String toString() {
            return year + " " + model + " (Номерной знак: " + licensePlate + ")";
        }

        public String getLicensePlate() {
            return licensePlate;
        }
    }

    public static class TaxiFleet {
        private List<Car> cars;

        public TaxiFleet() {
            cars = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public void removeCar(String licensePlate) {
            cars.removeIf(car -> car.getLicensePlate().equals(licensePlate));
        }

        public void showFleet() {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public static void main(String[] args) {
        TaxiFleet fleet = new TaxiFleet();

        // Добавляем автомобили
        fleet.addCar(new Car("AAA777", "Mercedes-Benz S-klasse S63 AMG", 2023));
        fleet.addCar(new Car("ABC789", "BMW M5 F90 cs", 2018));
        fleet.addCar(new Car("KKK888", "Mercedes-Benz C-klasse C43 AMG", 2017));

        System.out.println("Таксопарк по состоянию на сегодня:");
        fleet.showFleet();

        // Удаляем автомобиль
        fleet.removeCar("ABC789");

        System.out.println("\nОбновленный таксопарк:");
        fleet.showFleet();
    }
}
