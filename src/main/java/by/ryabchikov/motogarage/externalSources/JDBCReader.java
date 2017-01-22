package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.ATV;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.SportBikes;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.TouristBike;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class JDBCReader {

    public ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto, String url, String username, String password) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mototest");

            while (resultSet.next()) {

                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int maxSpeed = resultSet.getInt("max_speed");
                int weight = resultSet.getInt("weight");
                int power = resultSet.getInt("power");
                int wheels = resultSet.getInt("wheel");
                int case_cap = resultSet.getInt("case_cap");
                int cost = resultSet.getInt("cost");

                Mototechnics newMotoFromDB;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromDB = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromDB = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromDB = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                }
                arrayMoto.add(newMotoFromDB);
            }
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB");
            e.printStackTrace();
        }
        return arrayMoto;
    }
}