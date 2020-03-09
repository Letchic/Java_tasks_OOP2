package com.letchic;

import java.util.Objects;

public class MyComplex {
    private double real =0.0;
    private double image =0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public void setValue(double real, double image) {
        this.real = real;
        this.image = image;
    }

    @Override
    public String toString() {
        return "("+real+"+"+image+"i)";
    }

    public boolean isReal (){
        return real!=0;
    }
    public boolean isImaginary (){
        return image!=0;
    }


    public boolean equals(double real, double image) {
        return this.real==real&&this.image==image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.image, image) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, image);
    }

    public double magnitude (){
        return Math.sqrt(Math.pow(real,2)+Math.pow(image,2));
    }

    public double argument (){
        return Math.atan2(image,real);
    }

    public MyComplex addNew(MyComplex right){
        MyComplex newMyComplex = new MyComplex();
        newMyComplex.setReal(real+right.getReal());
        newMyComplex.setImage(image+right.getImage());
        return newMyComplex;
    }

    public MyComplex subtractNew(MyComplex right){
        MyComplex newMyComplex = new MyComplex();
        newMyComplex.setReal(real-right.getReal());
        newMyComplex.setImage(image-right.getImage());
        return newMyComplex;
    }

    public MyComplex conjugate(){
        MyComplex conjugate = new MyComplex();
        conjugate.setReal(real);
        conjugate.setImage(-image);
        return conjugate;
    }

    public MyComplex multiply(MyComplex right){
        MyComplex multiply = new MyComplex();
        multiply.setReal(real*right.getReal()-image*right.getImage());
        multiply.setImage(real*right.getImage()+image*right.getReal());
        return multiply;
    }

    public MyComplex divide(MyComplex right){
        MyComplex divide = new MyComplex();
        divide.setReal((real*right.getReal()+image*right.getImage())/(Math.pow(right.getReal(),2)+Math.pow(right.getImage(),2)));
        divide.setImage((image*right.getReal()-real*right.getImage())/(Math.pow(right.getReal(),2)+Math.pow(right.getImage(),2)));
        return divide;
    }

}
