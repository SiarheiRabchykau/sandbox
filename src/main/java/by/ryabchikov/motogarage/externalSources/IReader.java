package by.ryabchikov.motogarage.externalSources;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public interface IReader {
    ArrayList<Mototechnics> read(ArrayList<Mototechnics> mototechnicsArrayList, String pathToFile);
}