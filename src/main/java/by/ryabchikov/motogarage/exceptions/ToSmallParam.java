package by.ryabchikov.motogarage.exceptions;

/**
 * @uathor sergey on 22.1.17.
 */
public class ToSmallParam extends Exception{
    public ToSmallParam(String strEr) {
        super(strEr);
        System.out.println("I'M A SUPER EXCEPTION!");
    }
}