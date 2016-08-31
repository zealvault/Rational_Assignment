package com.ee.rational;

/**
 * Created by Shubham on 31-08-2016.
 */
public class Main {
    public static void main(String[] args){
        Rational rationalNumber;
        Rational newRationalNumber1 = new Rational(1l,2l);
        Rational newRationalNumber2 = new Rational(3l,4l);
        rationalNumber = newRationalNumber1.subtract(newRationalNumber2);
        rationalNumber = rationalNumber.reduceToLowestForm(rationalNumber);
        System.out.println(rationalNumber.getNumerator()+"/"+rationalNumber.getDenominator());
        //System.out.println(rationalNumber.longValue());

    }
}
