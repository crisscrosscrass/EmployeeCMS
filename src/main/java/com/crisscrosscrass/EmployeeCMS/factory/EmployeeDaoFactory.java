package com.crisscrosscrass.EmployeeCMS.factory;

import java.sql.Connection;

import com.crisscrosscrass.EmployeeCMS.models.EmployeeDao;
import com.crisscrosscrass.EmployeeCMS.service.DatabaseConnection;

public class EmployeeDaoFactory {

    // Methode zur Erstellung des DAO-Objekts mit Datenbankverbindung
    public static EmployeeDao createUserDao() {
        Connection connection = DatabaseConnection.getConnection(); // Datenbankverbindung herstellen
        return new JdbcEmployeeDao(connection); // JdbcUserDao-Objekt mit der Verbindung erstellen
    }


}