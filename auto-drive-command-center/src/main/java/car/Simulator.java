package car;

import car.enums.Command;
import car.enums.Direction;
import car.model.Car;
import car.model.Field;

import java.util.*;
import java.util.stream.Collectors;

public class Simulator {

    private static Properties properties;

    public static void main(String[] args) {

        properties = PropertyLoader.getInstance().loadProperties("en");
        System.out.println(properties.getProperty("WELCOME"));
        Scanner scanner = new Scanner(System.in);

        System.out.println(properties.getProperty("XY_FORMAT"));
        String x_y = scanner.nextLine();
        String[] widthAndHeightValues = x_y.split(" ");

        if (widthAndHeightValues.length != 2) {
            System.out.println(properties.getProperty("INCORRECT_XY_FORMAT") + " " + properties.getProperty("XY_FORMAT"));
            x_y = scanner.nextLine();
        }
        widthAndHeightValues = x_y.split(" ");
        int width = Integer.parseInt(widthAndHeightValues[0]);
        int height = Integer.parseInt(widthAndHeightValues[1]);

        Field field = new Field(width, height);

        System.out.println("Field created with width: " + width + " and height: " + height);

        while (true) {
            System.out.println("Please choose the following options:");
            System.out.println(properties.getProperty("ADD_CAR"));
            System.out.println(properties.get("RUN_SIMULATOR"));

            String selection = scanner.next();

            if (selection.equals("1")) {
                selection = addCarToTheField(field, selection);

            }
            if (selection.equals("2")) {
                selection = runSimulator(field);
            }

            if (selection.equals("3")) {
                System.out.println(properties.getProperty("START_OVER"));
                System.out.println(properties.get("EXIT"));
                selection = scanner.next();
                if (selection.equals("2")) {
                    exitOver();
                }
                if (selection.equals("1")) {
                    System.out.println(properties.getProperty("WELCOME"));
                    scanner = new Scanner(System.in);

                    System.out.println(properties.getProperty("XY_FORMAT"));
                    x_y = scanner.nextLine();
                    widthAndHeightValues = x_y.split(" ");

                    if (widthAndHeightValues.length != 2) {
                        System.out.println(properties.getProperty("INCORRECT_XY_FORMAT") + " " + properties.getProperty("XY_FORMAT"));
                        x_y = scanner.nextLine();
                    }
                    widthAndHeightValues = x_y.split(" ");
                    width = Integer.parseInt(widthAndHeightValues[0]);
                    height = Integer.parseInt(widthAndHeightValues[1]);

                    field = new Field(width, height);

                    System.out.println("Field created with width: " + width + " and height: " + height);
                }

            }

        }

    }

    private static void exitOver() {
        System.out.println(properties.getProperty("EXIT_MESSAGE"));
        System.exit(0);
    }

    public static String addCarToTheField(Field field, String selectionParam) {
        String selection = null;
        if (selectionParam.equals("2")) {
            return "2";
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(properties.getProperty("CAR_NAME"));
        String carName = scanner.next();

        String inputs = scanner.nextLine();
        if (inputs.equals("")) {
            System.out.println(properties.getProperty("INITIAL_POSITION") + " " + carName + " " + properties.getProperty("XY_DIRECTION"));

            inputs = scanner.nextLine();
        }
        String[] x_y_d = inputs.split(" ");
        if (x_y_d.length != 3) {
            System.out.println(properties.getProperty("INCORRECT_XY_FORMAT") + " " + properties.getProperty("INITIAL_POSITION") + " " + carName + " " + properties.getProperty("XY_DIRECTION"));

            inputs = scanner.nextLine();
        }
        int startX = Integer.parseInt(x_y_d[0]);
        int startY = Integer.parseInt(x_y_d[1]);

        Direction direction = Direction.valueOf(x_y_d[2].toUpperCase());

        System.out.println(properties.getProperty("CAR_COMMANDS") + " " + carName);
        String commands = scanner.next();

        Car car = new Car(carName, startX, startY, direction, commands);
        field.addCar(car);

        System.out.println(properties.getProperty("LIST_OF_CARS"));

        field.getCars().values().stream().forEach(car1 -> {
            System.out.println(car1 + " " + car1.getCommands());
        });
        return "1";

    }

    public static String runSimulator(Field field) {
        System.out.println(properties.getProperty("LIST_OF_CARS"));
        field.getCars().values().stream().forEach(car -> {
            System.out.println(car + " " + car.getCommands());
        });


        Set<Car> setOfCars = field.getCars().values().stream().collect(Collectors.toSet());
        List<String> commands = setOfCars.stream().map(Car::getCommands).collect(Collectors.toList());
        long highestTurns = getHighestCommandLength(commands);

        for (int i = 0; i < highestTurns ; i++) {

            for (Car eachCar : setOfCars) {
                if (eachCar.getCommands().toCharArray().length > 0) {
                    field.issueCommand(eachCar.getName(), Command.valueOf(String.valueOf(eachCar.getCommands().toCharArray()[0]).toUpperCase()));
                }
            }
            List<Car> collidedCars = checkCollisions(field.getCars().values().stream().collect(Collectors.toList()));

            if (collidedCars != null) {
                System.out.println(properties.getProperty("AFTER_SIMULATION"));
                int finalI = i + 1;
                collidedCars.stream().forEach(car -> {
                    System.out.println(car.getName()
                            + " Collides with "
                            + collidedCars.stream()
                            .filter(car1 -> !car1.getName().equals(car.getName()))
                            .map(Car::getName)
                            .collect(Collectors.joining()) + " (" + car.getX() + "," + car.getY() + ") at step " + finalI);
                });
                return "3";
            }

        }

        System.out.println(properties.getProperty("AFTER_SIMULATION"));
        field.getCars().values().stream().forEach(System.out::println);
        return "3";

    }

    private static long getHighestCommandLength(List<String> commands) {
         OptionalLong optionalLong = commands.stream().mapToLong(String::length).max();
         if (optionalLong.isPresent()) {
             return optionalLong.getAsLong();
         }
         return Long.MAX_VALUE;
    }

    public static List<Car> checkCollisions(List<Car> cars) {
        Car collidedCar = null;
        Set<String> positions = new HashSet<>();

        for (Car car : cars) {
            String positionKey = car.getX() + "," + car.getY();
            if (!positions.add(positionKey)) {
                collidedCar = car;
            }

        }
        Car finalCollidedCar = collidedCar;
        if (finalCollidedCar != null) {
            return cars.stream().filter(car -> car.getX() == finalCollidedCar.getX() && car.getY() == finalCollidedCar.getY()).collect(Collectors.toList());
        }
        return null;
    }
}
