package com.basonur;


import java.sql.*;

public class JdbcUpdatePostgreSql {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/musteriDB";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "123456789";
    static final String QUERY_SELECT_MUSTERI_ALL = "SELECT * FROM tblmusteri";

    static final String QUERY_UPDATE_MUSTERI_BY_ID = "UPDATE public.tblmusteri " +
            "SET ad='Onur '," +
            "    soyadi='Baş '," +
            "    aciklama='onur123@gmail.com '" +
            "where id=1;";

 static final String QUERY_INSERT_MUSTERI_BY_ID = "" +
         "INSERT INTO  public.tblmusteri (ad, soyadi, aciklama) " +
         "VALUES ('Burak','Delice','burak@gmail.com');";
 static final String QUERY_INSERT_MUSTERI_BY_ID2 = "" +
         "INSERT INTO  public.tblmusteri (ad, soyadi, aciklama) " +
         "VALUES ('Unal','Gani','burak@gmail.com');";
 static final String QUERY_INSERT_MUSTERI_BY_ID3 = "" +
         "INSERT INTO  public.tblmusteri (ad, soyadi, aciklama) " +
         "VALUES ('abcd','Delice','burak@gmail.com');";



    public static void main(String[] args) throws SQLException {

        try (
                Connection  connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();

        ) {
            // konsolda sonuclari gormek icin kullandik
           // statement.executeUpdate(QUERY_UPDATE_MUSTERI_BY_ID);
          //  statement.executeUpdate(QUERY_INSERT_MUSTERI_BY_ID);
            statement.executeUpdate(QUERY_INSERT_MUSTERI_BY_ID3);
            statement.executeUpdate(QUERY_INSERT_MUSTERI_BY_ID2);
            ResultSet resultSet = statement.executeQuery(QUERY_SELECT_MUSTERI_ALL);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("ad") + " " + resultSet.getString("soyadi"));
            }


        } catch (Exception e) {
            System.out.println("Hata: " + e);
        } finally {

/*
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null)
                statement.close();

            if (connection != null) connection.close();
            */

        }
    }
}