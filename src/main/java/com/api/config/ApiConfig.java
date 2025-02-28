package com.api.config;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

/**
 * Класс для загрузки и хранения конфигурационных параметров API
 */
public class ApiConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ApiConfig.class.getClassLoader().getResourceAsStream("api.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find api.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load api.properties", ex);
        }
    }

    /**
     * Получение базового URL API
     * @return базовый URL API
     */
    public static String getBaseUrl() {
        return properties.getProperty("api.base.url");
    }
}
