package by.ryabchikov.motogarage.mototechnictype;

import by.ryabchikov.motogarage.exceptions.ToSmallParam;

/**
 * Created by sergey on 22.1.17.
 */
public class Mototechnics {
    protected String brand;
    protected String model;

    protected int maxSpeed;
    protected int weight;
    protected int power;
    protected int wheels;
    protected int caseCapacity;

    protected double cost;

    public Mototechnics(String brand, String model,
                        int maxSpeed, int weight, int power,
                        double cost) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.power = power;
        this.cost = cost;

    }

    // getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int newMaxSpeed) {
        this.maxSpeed = newMaxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight) throws ToSmallParam {
        if (newWeight <= 0) {
            throw new ToSmallParam("Too low weight!");
        }
        this.weight = newWeight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int newPower) throws ToSmallParam {
        if (newPower <= 0) {
            throw new ToSmallParam("Too low power!");
        }
        this.power = newPower;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int newNumberOfWheels) {
        this.wheels = newNumberOfWheels;
    }

    public int getCaseCapacity() {
        return caseCapacity;
    }

    public void setCaseCapacity(int newCaseCapacity) {
        this.caseCapacity = newCaseCapacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public String getInfo() {
        return "Brand: " + this.brand + " Model: " + this.model + " Max Speed: " + this.maxSpeed
                + " Weight: " + this.weight + " Power: " + this.power + " Number of wheel: " + this.wheels
                + " Case capacity: " + this.caseCapacity + " Cost: " + this.cost;
    }

    public void doWheelie() {
        System.out.println("Hey!" + this.model + " is not sportbike! It's can't do wheelie!");
    }
}