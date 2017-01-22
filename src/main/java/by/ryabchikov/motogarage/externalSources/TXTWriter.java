package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class TXTWriter implements IWriter {

    @Override
    public void write(ArrayList<Mototechnics> motoList, String pathToWriteTXT) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWriteTXT));

            for (Mototechnics list : motoList) {
                writer.write(list.getInfo() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write data to file!");
            e.printStackTrace();
        }
    }
}