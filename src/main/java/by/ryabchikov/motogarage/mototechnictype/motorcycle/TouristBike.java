package by.ryabchikov.motogarage.mototechnictype.motorcycle;

import by.ryabchikov.motogarage.exceptions.ToSmallParam;
import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.interfaces.Tuning;

/**
 * Created by sergey on 22.1.17.
 */
public class TouristBike extends Mototechnics implements Tuning {
    public TouristBike(String brand, String model,
                       int maxSpeed, int weight, int power,
                       int wheels, int caseCapacity,
                       double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(wheels);
        this.setCaseCapacity(caseCapacity);
    }

    //override from interfaces
    @Override
    public void reduceWeight() {
        int raceWeight = (int) (this.getWeight()/1.02);
        try {
            this.setWeight(raceWeight);
        } catch (ToSmallParam ex) {
            System.out.println("Unable to reduce weight, because weight <= 0");
        }
    }

    //override from interfaces
    @Override
    public void increasePower() {
        int racePower = (int) (this.getPower()*1.15);
        try {
            this.setPower(racePower);
        } catch (ToSmallParam exception1) {
            System.out.println("Unable to increase power, because power <= 0");
        }
    }
}