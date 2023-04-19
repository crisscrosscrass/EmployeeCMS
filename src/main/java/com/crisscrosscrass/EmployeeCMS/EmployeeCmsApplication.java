package com.crisscrosscrass.EmployeeCMS;

import com.crisscrosscrass.EmployeeCMS.controller.IndexController;
import com.crisscrosscrass.EmployeeCMS.service.DatabaseConnection;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeCmsApplication {
	final static Logger logger = Logger.getLogger(String.valueOf(EmployeeCmsApplication.class));
	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();

        // Prüfen, ob die Verbindung zur Datenbank erfolgreich ist
        if (dbConnection.getConnection() != null) {
            System.out.println("Datenbankverbindung hergestellt.");
            // Hier können Sie weitere Aktionen ausführen, z.B. CRUD-Operationen
        } else {
            System.out.println("Fehler bei der Herstellung der Datenbankverbindung.");
        }
		SpringApplication.run(EmployeeCmsApplication.class, args);
	}
}
