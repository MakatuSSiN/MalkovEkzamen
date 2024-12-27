import java.util.ArrayList;
import java.util.List;


//разработать класс для хранения данных об автомобилях, находящихся в таксопарке. Использую созданный класс, смоделировать работу приложения.
public class Main {
    public class Car {
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
            return year + " " + model + " (License Plate: " + licensePlate + ")";
        }

        public String getLicensePlate() {
            return licensePlate;
        }
    }

    public class TaxiFleet {
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

    public void main(String[] args) {
        TaxiFleet fleet = new TaxiFleet();

        // Добавляем автомобили
        fleet.addCar(new Car("ABC123", "Toyota Camry", 2020));
        fleet.addCar(new Car("XYZ789", "Honda Accord", 2019));

        System.out.println("Таксопарк по состоянию на сегодня:");
        fleet.showFleet();

        // Удаляем автомобиль
        fleet.removeCar("ABC123");

        System.out.println("\nОбновленный таксопарк:");
        fleet.showFleet();
    }
}
