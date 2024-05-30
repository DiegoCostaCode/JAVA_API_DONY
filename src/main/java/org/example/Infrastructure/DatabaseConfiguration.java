package org.example.Infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfiguration implements Loggable<String> {

    private static final String PROPERTIES_FILE = "src/main/resources/database.properties";
    private static Properties props = new Properties();

    static {
        try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            props.load(input);
        } catch (IOException e) {
            Loggable.logInfo("Erro ao carregar arquivo" + e.getMessage());
        }
    }

    public static String getUrl() {
        return (String) props.get("url");
    }

    public static String getUser() {
        return (String) props.get("user");
    }

    public static String getPassword() {
        return (String) props.get("password");
    }

    public static Connection getConnection() {
        String url = getUrl();
        String user = getUser();
        String password = getPassword();

        if (url == null || user == null || password == null) {
            throw new RuntimeException("Propriedades de conexão não foram carregadas corretamente");
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn.isValid(5)) {
                Loggable.logInfo("A conexão foi bem sucedida!");
                return conn;
            } else {
                Loggable.logInfo("A conexão falhou!");
            }
        } catch (SQLException e) {
            Loggable.logError("Erro nos parâmetros de conexão com o banco de dados~!" + e.getMessage());
        }

        return null;
    }
}