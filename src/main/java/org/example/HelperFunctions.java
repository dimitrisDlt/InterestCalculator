package org.example;

public class HelperFunctions {

    public HelperFunctions() {}

    public double parseGreekDouble(String input) {

        String newInput = input.replace(',', '.');

        return Double.parseDouble(newInput);
    }
}
