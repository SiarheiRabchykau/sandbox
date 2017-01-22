package by.ryabchikov.motogarage.mototechnictype.motorcycle;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

/**
 * Created by sergey on 22.1.17.
 */
public class ATV extends Mototechnics {
    public ATV(String brand, String model,
               int maxSpeed, int weight, int power,
               int caseCapacity,
               double cost) {
        super(brand, model, maxSpeed, weight, power, cost);
        this.setWheels(4);
        this.setCaseCapacity(caseCapacity);
    }
}