package com.letchic;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double...coeffs) {
        this.coeffs = coeffs;
    }
    public int getDegree (){
        return coeffs.length-1;
    }

    @Override
    public String toString(){
        String poly = new String();
        for (int i =  getDegree(); i >= 0; i--) {


            double coeff = coeffs[i];
            if (coeff != 0) {
                if (coeff < 0) {
                    poly+=" - ";
                    if (coeff != -1.0) poly+=-coeff;
                } else {
                    if (i != getDegree()) poly+=" + ";
                    if (coeff != 1.0) poly+=coeff;
                }
                if (i > 1) {
                    poly+="x^"+(i);
                } else if (i == 1) {
                    poly+="x";
                }
            }
        }
        return poly;
    }

    public MyPolynomial add (MyPolynomial right)
    {
        int resLength = Math.max(this.coeffs.length, right.coeffs.length);
        double result [] = new double[resLength];
        for (int i =0;i<resLength;i++){
            double thisCoeff = this.coeffs.length>i?this.coeffs[i]:0.0;
            double rightCoeff = right.coeffs.length>i?right.coeffs[i]:0.0;
            result[i] = thisCoeff+rightCoeff;
        }
        return new MyPolynomial(result);
    }

    public MyPolynomial multiple (MyPolynomial right)
    {
        int resLength = this.coeffs.length+right.coeffs.length-1;
        double result [] = new double[resLength];
        for (int i=0;i<this.coeffs.length;i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                result[i+j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPolynomial that = (MyPolynomial) o;

        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
