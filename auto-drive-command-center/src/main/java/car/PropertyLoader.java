package car;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final PropertyLoader instance = new PropertyLoader();

    public static PropertyLoader getInstance() {
        return instance;
    }

    public Properties loadProperties(String language) {
        Properties properties = new Properties();
        try {
            if (language.equals("en")) {
                properties.load(new FileInputStream("src/main/resources/application.properties"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Please ensure to copy application.properties file under src/main/resources/");
        }
        return properties;
    }


}
