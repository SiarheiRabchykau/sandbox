package by.ryabchikov.motogarage;
import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.util.ArrayList;

/**
 * Created by sergey on 22.1.17.
 */
public class Garage {
    public ArrayList<Mototechnics> motoList;

    public ArrayList<Mototechnics> getMotoList() {
        return motoList;
    }

    public void setMotoList(ArrayList<Mototechnics> motoList) {
        this.motoList = motoList;
    }
}