package com.crisscrosscrass.EmployeeCMS.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Methode zur Herstellung einer JDBC-Datenbankverbindung
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/exampledb"; // Verbindungs-URL zur Datenbank
        String username = "root"; // Benutzername
        String password = "examplepassword"; // Passwort
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Treiberklasse laden (abhängig von Ihrer Datenbank)
            Connection connection = DriverManager.getConnection(url, username, password); // Verbindung herstellen
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
