package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class JDBCWriter {

    public void write(ArrayList<Mototechnics> arrayMoto, String url, String username, String password) {

        try {
            String dropDB = "DROP TABLE IF EXISTS  moto2";

            String createDB = "CREATE TABLE moto2 (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `brand` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `max_speed` INT(3) NULL,\n" +
                    "  `weight` INT(4)  NULL,\n" +
                    "  `power` INT(4)  NULL,\n" +
                    "  `wheel` INT(2) NULL,\n" +
                    "  `case_cap` INT(3) NULL,\n" +
                    "  `cost` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE INDEX `id_UNIQUE` (`id` ASC))";

            Connection connection = DriverManager.getConnection(url, username, password);
            String SQL = "INSERT INTO moto2 (brand, model, max_speed, weight, power, wheel, case_cap, cost) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(SQL);

            connection.setAutoCommit(false);
            statement.execute(dropDB);
            statement.execute(createDB);

            for (int i = 0; i < arrayMoto.size(); i++) {
                statement.setString(1, arrayMoto.get(i).getBrand());
                statement.setString(2, arrayMoto.get(i).getModel());
                statement.setInt(3, arrayMoto.get(i).getMaxSpeed());
                statement.setInt(4, arrayMoto.get(i).getWeight());
                statement.setInt(5, arrayMoto.get(i).getPower());
                statement.setInt(6, arrayMoto.get(i).getWheels());
                statement.setInt(7, arrayMoto.get(i).getCaseCapacity());
                statement.setDouble(8, arrayMoto.get(i).getCost());
                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB for write");
            e.printStackTrace();
        }
    }
}