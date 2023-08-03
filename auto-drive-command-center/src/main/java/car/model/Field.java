package car.model;

import car.enums.Command;

import java.util.HashMap;
import java.util.Map;

public class Field {
    static int width;
    static int height;
    private Map<String, Car> cars;

    public Field(int width, int height) {
        Field.width = width;
        Field.height = height;
        this.cars = new HashMap<>();
    }

    public void addCar(Car car) {
        cars.put(car.getName(), car);
    }

    public void issueCommand(String carName, Command command) {
        Car car = cars.get(carName);
        if (car != null) {
            switch (command) {
                case F:
                    car.moveForward();
                    break;
                case L:
                    car.rotateLeft();
                    break;
                case R:
                    car.rotateRight();
                    break;
            }
        }

    }


    public Car getCarByName(String carName) {
        return this.cars.get(carName);
    }

    public Map<String, Car> getCars() {
        return cars;
    }

}
