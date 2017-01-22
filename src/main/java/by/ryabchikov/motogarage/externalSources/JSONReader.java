package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.Garage;
import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.ATV;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.SportBikes;
import by.ryabchikov.motogarage.mototechnictype.motorcycle.TouristBike;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class JSONReader implements IReader {

    @Override
    public ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
            Garage garage = gson.fromJson(bufferedReader, Garage.class);

            ArrayList<Mototechnics> newMotoList = new ArrayList<>();
            newMotoList.addAll(garage.getMotoList());

            for (Mototechnics m : newMotoList) {
                String brand = m.getBrand();
                String model = m.getModel();
                int maxSpeed = m.getMaxSpeed();
                int weight = m.getWeight();
                int wheels = m.getWheels();
                int power = m.getPower();
                int case_cap = m.getCaseCapacity();
                double cost = m.getCost();

                Mototechnics newMotoFromJSON;
                if (case_cap > 0) {
                    if (wheels > 3) {
                        newMotoFromJSON = new ATV(brand, model, maxSpeed, weight, power, case_cap, cost);
                    } else {
                        newMotoFromJSON = new TouristBike(brand, model, maxSpeed, weight, power, wheels, case_cap, cost);
                    }
                } else {
                    newMotoFromJSON = new SportBikes(brand, model, maxSpeed, weight, power, cost);
                }
                mototechnicsArrayList.add(newMotoFromJSON);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to read JSON file!");
        }

        return mototechnicsArrayList;
    }
}