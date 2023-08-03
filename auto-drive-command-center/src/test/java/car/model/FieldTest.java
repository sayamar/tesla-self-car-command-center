package car.model;

import car.enums.Command;
import car.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    @Test
    public void testCarByName() {
        // Given
        Field field = null;
        field = new Field(10, 10);
        Car car = new Car("TESLA", 1, 2, Direction.N, "FFRFFL");

        //When
        field.addCar(car);
        Map<String, Car> listOfCars = field.getCars();
        Car actualCar = listOfCars.values().stream().collect(Collectors.toList()).get(0);

        // Then
        assertNotNull(listOfCars);
        assertEquals(1, listOfCars.size());
        assertEquals("TESLA",actualCar.getName());

    }

    @Test
    public void testAddCarToTheField(){
        // Given
        Field field = null;
        field = new Field(10, 10);
        Car car = new Car("BENZ",1,2, Direction.N,"FFRFFL");


        //When
        field.addCar(car);

        //then
        Map<String, Car> listOfCars = field.getCars();
        assertNotNull(listOfCars);
        assertEquals(1, listOfCars.size());
        assertEquals("FFRFFL",listOfCars.get("BENZ").getCommands());
        assertEquals(1,listOfCars.get("BENZ").getX());
        assertEquals(2,listOfCars.get("BENZ").getY());
        assertEquals("N",listOfCars.get("BENZ").getDirection().name());



    }

    @Test
    public void testAddCarsToTheField(){
        // Given
        Field field = null;
        field = new Field(10, 10);
        Car car1 = new Car("BENZ",1,2, Direction.N,"FFFRRFFFFF");
        Car car2 = new Car("AUDI",1,2, Direction.N,"FFRRFFLLFF");

        //When
        field.addCar(car1);
        field.addCar(car2);

        //then
        Map<String, Car> listOfCars = field.getCars();
        assertNotNull(listOfCars);
        assertEquals(2, listOfCars.size());

    }

    @Test
    public void testIssueCommandMoveForward(){
        // Given
        Field field = null;
        field = new Field(10, 10);
        Car car1 = new Car("BENZ",1,2, Direction.N,"FFFRRFFFFF");

        //When
        field.addCar(car1);
        String carName = field.getCars().get("BENZ").getName();
        Character character = field.getCars().get("BENZ").getCommands().charAt(0);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character)));

        //then
        Map<String, Car> listOfCars = field.getCars();
        assertNotNull(listOfCars);
        assertEquals(1, listOfCars.size());
        assertEquals(1,listOfCars.get("BENZ").getX());
        assertEquals(3,listOfCars.get("BENZ").getY());
        assertEquals("N",listOfCars.get("BENZ").getDirection().name());

    }

    @Test
    public void testIssueCommandRotateRight(){
        // Given
        Field field = null;
        field =   new Field(10, 10);
        Car car1 = new Car("BENZ",1,2, Direction.N,"FRFFFL");

        //When
        field.addCar(car1);
        String carName = field.getCars().get("BENZ").getName();
        Character character = field.getCars().get("BENZ").getCommands().charAt(0);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character)));
        Character character1 = field.getCars().get("BENZ").getCommands().charAt(1);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character1)));
        Character character2 = field.getCars().get("BENZ").getCommands().charAt(2);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character2)));

        //then
        Map<String, Car> listOfCars = field.getCars();
        assertNotNull(listOfCars);
        assertEquals(1, listOfCars.size());
        assertEquals(1,listOfCars.get("BENZ").getX());
        assertEquals(5,listOfCars.get("BENZ").getY());
        assertEquals("N",listOfCars.get("BENZ").getDirection().name());

    }

    @Test
    public void testIssueCommandRotateLeft(){
        // Given
        Field field = null;
        field =   new Field(10, 10);
        Car car1 = new Car("BENZ",4,4, Direction.N,"FFLFFF");

        //When
        field.addCar(car1);
        String carName = field.getCars().get("BENZ").getName();
        Character character = field.getCars().get("BENZ").getCommands().charAt(0);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character)));
        Character character1 = field.getCars().get("BENZ").getCommands().charAt(1);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character1)));
        Character character2 = field.getCars().get("BENZ").getCommands().charAt(2);
        field.issueCommand(carName,Command.valueOf(String.valueOf(character2)));

        //then
        Map<String, Car> listOfCars = field.getCars();
        assertNotNull(listOfCars);
        assertEquals(1, listOfCars.size());
        assertEquals(3,listOfCars.get("BENZ").getX());
        assertEquals(5,listOfCars.get("BENZ").getY());
        assertEquals("W",listOfCars.get("BENZ").getDirection().name());

    }


}
