package by.ryabchikov.motogarage;

import by.ryabchikov.motogarage.mototechnictype.Mototechnics;

import java.util.Comparator;

/**
 * Created by sergey on 22.1.17.
 */
public class CustomComparatorArrayList implements Comparator<Mototechnics> {
    @Override
    public int compare(Mototechnics object1, Mototechnics object2) {
        return (object2.getWeight() - object1.getWeight());
    }
}