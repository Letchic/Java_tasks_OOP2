package com.letchic;

import com.letchic.ball.Ball;
import com.letchic.ball.Container;

public class Main {
    public static void main(String[] args) {
        //MyComplex
        MyComplex myComplex1 = new MyComplex();
        System.out.println("myComplex1 " + myComplex1);
        myComplex1.setValue(2,3);
        System.out.println("myComplex1 " + myComplex1);
        MyComplex myComplex2 = new MyComplex(4,5);
        System.out.println("myComplex2 " + myComplex2);
        System.out.println("magnitude " + myComplex2.magnitude());
        System.out.println("argument " + myComplex2.argument());
        System.out.println("addNew " + myComplex1.addNew(myComplex2));
        System.out.println("subtractNew " + myComplex1.subtractNew(myComplex2));
        System.out.println("conjugate " + myComplex1.conjugate());
        System.out.println("multiply " + myComplex1.multiply(myComplex2));
        System.out.println("divide " + myComplex1.divide(myComplex2));
        System.out.println("equals " + myComplex1.equals(myComplex2));

        //MyPolynomial
        MyPolynomial polynom1 = new MyPolynomial(2,3);
        MyPolynomial polynom2 = new MyPolynomial(4,5,6);
        System.out.println(polynom1);
        System.out.println(polynom2);
        System.out.println("getDegree " + polynom2.getDegree());
        System.out.println("add " + polynom1.add(polynom2));
        System.out.println("multiple " + polynom1.multiple(polynom2));

        //Ball
        Container container = new Container(0,0,100,100);
        Ball ball = new Ball(95,50,4,1,0);
        System.out.println(ball.toString());
        System.out.println("collides " + container.collidesWidth(ball));
        ball.move();
        System.out.println("collides " + container.collidesWidth(ball));
    }
}
