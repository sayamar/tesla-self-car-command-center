package learn;

public class StringMedals {

    public static void main(String[] args) {
        String commands = "MARUTHI";
        commands = commands.substring(1); // ARUTHI
        System.out.println(commands);
        commands = commands.substring(1,4);  // 1 is inclusice and 4 is exclusive so  RUT
        System.out.println(commands);
    }
}
