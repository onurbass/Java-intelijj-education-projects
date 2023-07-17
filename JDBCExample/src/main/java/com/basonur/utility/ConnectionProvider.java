package com.basonur.utility;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
public class ConnectionProvider {
    private final String USERNAME="postgres";
    private final String PASSWORD="123456789";
    private final String DB_NAME="FutbolDb";
    private final String URL="jdbc:postgresql://localhost:5432/"+DB_NAME;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public boolean openConnection()  {

        try {
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Bağlantı başarılı");
            return true;
        } catch (SQLException e) {
            System.out.println("Bağlantı başarısız");
            return false;
        }

    }

    public void closeConnection(){
        try {
            if (!connection.isClosed())
                connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public PreparedStatement getPreparedStatement(String sql){
        openConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
