package by.ryabchikov.motogarage;

import by.ryabchikov.motogarage.exceptions.ToSmallParam;
import by.ryabchikov.motogarage.externalSources.*;
import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sergey on 22.1.17.
 */
public abstract class Main {
    private static int maxPower;
    private static int minPower;

    private static final String URL = "jdbc:mysql://localhost:3306/motodb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static String pathToReadJSON = "src\\main\\resources\\JSONwithmoto.json";

    private static String pathToReadXML = "src\\main\\resources\\XMLwithmoto.xml";
    private static String pathToWriteXML = "src\\main\\resources\\XMLwithmotoOutput.xml";

    private static String pathToReadTXT = "src\\main\\resources\\TXTwithmoto.txt";
    private static String pathToWriteTXT = "src\\main\\resources\\TXTwithmotoOutput.txt";

    public static void main(String[] args) throws IOException, ToSmallParam {
        ArrayList<Mototechnics> motoList = new ArrayList<>();

        JDBCReader jdbcReader = new JDBCReader();
        JDBCWriter jdbcWriter = new JDBCWriter();

        JSONReader jsonReader = new JSONReader();
        JSONWriter jsonWriter = new JSONWriter();

        XMLReader xmlReader = new XMLReader();
        XMLWriter xmlWriter = new XMLWriter();

        TXTReader txtReader = new TXTReader();
        TXTWriter txtWriter = new TXTWriter();


        //read data
        jdbcReader.read(motoList, URL, USERNAME, PASSWORD);
        jsonReader.read(motoList, pathToReadJSON);
        xmlReader.read(motoList, pathToReadXML);
        txtReader.read(motoList, pathToReadTXT);

        //write data to file
        jdbcWriter.write(motoList, URL, USERNAME, PASSWORD);
        String pathToWriteJSON = "src\\main\\resources\\JSONwithmotoOutput.json";
        jsonWriter.write(motoList, pathToWriteJSON);
        xmlWriter.write(motoList, pathToWriteXML);
        txtWriter.write(motoList, pathToWriteTXT);

        printArrayList(motoList);
//
//        calculateCostGarage(motoList);
//
//        System.out.println("\nSort by weight");
//
//        //sort by weight
//        Collections.sort(motoList, new CustomComparatorArrayList());
//
//        printArrayList(motoList);
//
//        enterPower();
//
//        findPower(motoList);
    }


    private static void printArrayList(ArrayList<Mototechnics> list) throws ArrayIndexOutOfBoundsException {

        for (Mototechnics m : list) {
            System.out.println(m.getInfo());
        }
    }

    private static void calculateCostGarage(ArrayList<Mototechnics> list) throws ArithmeticException {
        double garagePrice = 0.0;
        for (Mototechnics moto : list) {
            garagePrice += moto.getCost();
        }
        System.out.println("Cost of all motorcycle in garage: " + garagePrice);
    }

    private static void enterPower() {
        System.out.println("Find motorcycle by your choose of Power");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter min Power ");
        minPower = scanner.nextInt();
        System.out.println("Enter max Power ");
        maxPower = scanner.nextInt();
        scanner.close();
    }

    private static void findPower(ArrayList<Mototechnics> list) {
        for (Mototechnics m : list) {
            if (m.getPower() >= minPower && m.getPower() <= maxPower) {
                System.out.printf("Power of %s: %s", m.getModel(), m.getPower());
                System.out.println();
            }
        }
    }
}