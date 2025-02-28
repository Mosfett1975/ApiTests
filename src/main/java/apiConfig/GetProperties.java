package apiConfig;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;


public class GetProperties {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = GetProperties.class.getClassLoader().getResourceAsStream("api.properties")) {
            if (input == null) {
                throw new RuntimeException("Отсутствует файл api.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка загрузки файла api.properties", ex);
        }
    }

    /**
     * Получение базового URL API
     */
    public static String getBaseUrl() {
        return properties.getProperty("api.base.url");
    }
}
