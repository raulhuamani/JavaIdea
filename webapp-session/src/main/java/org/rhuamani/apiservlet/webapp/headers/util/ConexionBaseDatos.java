package org.rhuamani.apiservlet.webapp.headers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static  String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static  String url_pg = "jdbc:postgresql://localhost:5432/java_curso";
    private static  String url_sql = "jdbc:sqlserver://localhost:1433;database=java_curso;encrypt=false";
    private static  String url_ora = "jdbc:oracle:thin:@localhost:1521:xe";

    private static String username = "curso";
    private static String password = "java_curso";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}