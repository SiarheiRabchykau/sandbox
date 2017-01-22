package by.ryabchikov.motogarage.mototechnictype.motorcycle;

import by.ryabchikov.motogarage.exceptions.ToSmallParam;
import by.ryabchikov.motogarage.mototechnictype.Mototechnics;
import by.ryabchikov.motogarage.mototechnictype.interfaces.Tuning;

/**
 * Created by sergey on 22.1.17.
 */
public class SportBikes extends Mototechnics implements Tuning {
    public SportBikes(String brand, String model,
                      int maxSpeed, int weight, int power,
                      double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(2);
        this.setCaseCapacity(0);
    }

    public void doWheelie() {
        if (this.getWeight() > 300 | this.getPower() < 120) {
            System.out.println("Sorry, but your motorcycle is not powerful");
        } else {
            System.out.println("Hey! Be careful!");
        }
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
        } catch (ToSmallParam ex) {
            System.out.println("Unable to increase power, because power <= 0");
        }
    }
}