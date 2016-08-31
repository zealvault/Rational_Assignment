package com.ee.rational;

/**
 * Created by vishal on 31-08-2016.
 *@version 1.0
 * @since 31-08-2016
 * @author vishal
 */
public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     *
     * @param secondRationalNumber
     * @return object of type Rational
     * Adds the current object to secondRationalNumber and returns the sum object
     */
    public Rational add(Rational secondRationalNumber) {
        long numerator;
        long denominator = this.denominator * secondRationalNumber.denominator;
        numerator = (this.numerator * secondRationalNumber.denominator)+(this.denominator * secondRationalNumber.numerator);
        Rational rationalNumber = new Rational(numerator,denominator);
        rationalNumber = rationalNumber.reduceToLowestForm(rationalNumber);
        return rationalNumber;
    }

    /**
     *
     * @param secondRationalNumber
     * @return object of type Rational
     * Subtracts the current object with secondRationalNumber and returns the new object
     */
    public Rational subtract(Rational secondRationalNumber) {
        long numerator;
        long denominator = this.denominator * secondRationalNumber.denominator;
        numerator = (this.numerator * secondRationalNumber.denominator)-(this.denominator * secondRationalNumber.numerator);
        Rational rationalNumber = new Rational(numerator,denominator);
        rationalNumber = rationalNumber.reduceToLowestForm(rationalNumber);
        return rationalNumber;
    }
    /**
     *
     * @param secondRationalNumber
     * @return object of type Rational
     * multiplies the current object with secondRationalNumber and returns the new object
     */
    public Rational multiply(Rational secondRationalNumber) {
        long numerator = this.numerator * secondRationalNumber.numerator;
        long denominator = this.denominator * secondRationalNumber.denominator;
        Rational rationalNumber = new Rational(numerator,denominator);
        rationalNumber = rationalNumber.reduceToLowestForm(rationalNumber);
        return rationalNumber;
    }
    /**
     *
     * @param secondRationalNumber
     * @return object of type Rational
     * divides the current object with secondRationalNumber and returns the new object
     * @throws ArithmeticException
     */
    public Rational divide(Rational secondRationalNumber) {
        long numerator;
        long denominator;
        if(secondRationalNumber.numerator == 0){
            throw new ArithmeticException();
        }else{
            numerator = this.numerator * secondRationalNumber.denominator;
            denominator = this.denominator * secondRationalNumber.numerator;
            Rational rationalNumber = new Rational(numerator,denominator);
            rationalNumber = rationalNumber.reduceToLowestForm(rationalNumber);
            return rationalNumber;
        }
    }

    /**
     *
     * @param a :Integer of type long
     * @param b :Integer of type long
     * @return Integer of type long
     */
    @TestMe
    private long gcd(long a, long b) {
        long gcd = 1;
        for (long i = 1;i <= Math.abs(a) && i <= Math.abs(b);++i) {

            if (a%i == 0 && b%i == 0)
                gcd = i;
        }
        return gcd;
    }

    public Rational reduceToLowestForm(Rational rationalNumber){
        long gcd = gcd(rationalNumber.numerator,rationalNumber.denominator);
        rationalNumber.numerator = rationalNumber.numerator/gcd;
        rationalNumber.denominator = rationalNumber.denominator/gcd;
        return rationalNumber;

    }
    @Override
    public int intValue() {
        int valueInInt;
        valueInInt = (int) (this.getNumerator() / this.getDenominator());
        return valueInInt;
    }

    @Override
    public long longValue() {
        long valueInLong;
        valueInLong =  this.getNumerator() / this.getDenominator();
        return valueInLong;
    }

    @Override
    public float floatValue() {
        float valueInFloat;
        valueInFloat = (float) (this.getNumerator() / this.getDenominator());
        return valueInFloat;
    }

    @Override
    public double doubleValue() {
        double valueInDouble;
        valueInDouble = (int) (this.getNumerator() / this.getDenominator());
        return valueInDouble;
    }

    @Override
    @TestMe
    public int compareTo(Rational o) {
        if(o.getNumerator() == this.getNumerator() && o.getDenominator() == this.getDenominator()){
            return 0;
        }else if(this.getNumerator() * o.getDenominator() > this.getDenominator() * o.getNumerator()){
            return 1;
        }else{
            return -1;
        }
    }
    @Override
    public String toString(){
        return this.getNumerator()+"/"+this.getDenominator();
    }
}
