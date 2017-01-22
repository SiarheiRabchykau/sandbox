package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.ATV;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.SportBikes;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.TouristBike;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class TXTReader implements IReader {

    @Override
    public ArrayList<Mototechnics> read(ArrayList<Mototechnics> arrayMoto, String pathToReadTXT) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToReadTXT));

            while (reader.ready()) {
                try {
                    String motoValues[] = reader.readLine().split(" ");
                    String brand = motoValues[0];//brand
                    String model = motoValues[1];//model
                    int maxSpeed = Integer.parseInt(motoValues[2]);//max speed
                    int weight = Integer.parseInt(motoValues[3]);//weight
                    int power = Integer.parseInt(motoValues[4]);//power
                    int wheels = Integer.parseInt(motoValues[5]);//number of wheel
                    int case_cap = Integer.parseInt(motoValues[6]);//case capacity
                    double cost = Double.parseDouble(motoValues[7]);//cost

                    Mototechnics newMotoFromFile;
                    if (case_cap > 0) {
                        if (wheels > 3) {
                            newMotoFromFile = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                        } else {
                            newMotoFromFile = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
                        }
                    } else {
                        newMotoFromFile = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                    }

                    arrayMoto.add(newMotoFromFile);
                } catch (NumberFormatException e) {
                    System.out.println("One of the parameters has wrong format");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File with data not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Same error with TXT file");
            e.printStackTrace();
        }
        return arrayMoto;
    }
}