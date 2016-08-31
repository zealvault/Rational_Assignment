package com.ee.rational;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vishal on 31-08-2016.
 */
public class RationalTest {
    Rational newRationalNumber1;
    Rational newRationalNumber2;
    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Before Running");
         newRationalNumber1 = new Rational(1l,2l);
         newRationalNumber2 = new Rational(3l,4l);

    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("After running");
    }

    @org.junit.Test
    public void add() throws Exception {
        Rational expectedObject = new Rational(5l,4l);
        assertEquals(expectedObject.getNumerator(),newRationalNumber1.add(newRationalNumber2).getNumerator());
        assertEquals(expectedObject.getDenominator(),newRationalNumber1.add(newRationalNumber2).getDenominator());

    }

    @org.junit.Test
    public void subtract() throws Exception {
        Rational expectedObject = new Rational(-1l,4l);
        assertEquals(expectedObject.getNumerator(),newRationalNumber1.subtract(newRationalNumber2).getNumerator());
        assertEquals(expectedObject.getDenominator(),newRationalNumber1.subtract(newRationalNumber2).getDenominator());
    }

    @org.junit.Test
    public void multiply() throws Exception {
        Rational expectedObject = new Rational(3l,8l);
        assertEquals(expectedObject.getNumerator(),newRationalNumber1.multiply(newRationalNumber2).getNumerator());
        assertEquals(expectedObject.getDenominator(),newRationalNumber1.multiply(newRationalNumber2).getDenominator());

    }

    @org.junit.Test
    public void divide() throws Exception {
        Rational expectedObject = new Rational(2l,3l);
        assertEquals(expectedObject.getNumerator(),newRationalNumber1.divide(newRationalNumber2).getNumerator());
        assertEquals(expectedObject.getDenominator(),newRationalNumber1.divide(newRationalNumber2).getDenominator());
    }
    @org.junit.Test
    public void testGcd() throws InvocationTargetException, IllegalAccessException {
        Class<Rational> classRational = Rational.class;
        Method[] methods = classRational.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        Method gcdMethod = null, reductionMethod = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestMe.class)) {
                list.add(method);
            }
        }

        for (Method method : list) {
            if (method.getName().equalsIgnoreCase("gcd")) {
                gcdMethod = method;
            }
            if (method.getName().equalsIgnoreCase("reduce")) {
                reductionMethod = method;
            }
        }

        gcdMethod.setAccessible(true);
        long gcd = (long) gcdMethod.invoke(newRationalNumber1, 4l, 8l);
        assertEquals(gcd, 4l);
    }
}