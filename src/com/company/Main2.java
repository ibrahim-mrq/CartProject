package com.company;


import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {


        System.out.println("Asd() = " + Asd(888.1, 888.05));

        ArrayList<Toy> list = new ArrayList<>();
        list.add(new Toy("A", "red", 15.0, Quality.Low));
        list.add(new Toy("B", "green", 12.0, Quality.High));
        list.add(new Toy("C", "blue", 20.0, Quality.Medium));

        System.out.println(list.get(0).discount(list.get(0).price));
        for (Toy toy : list) {
            System.out.println(toy.display());
        }
        System.out.println(list.size());
    }


    private static double Asd(double a, double b) {
        return Math.min(a, b);
    }

    public interface Toyface {
        String display();

        double discount(double price);
    }

    public enum Quality {

        High("High"),
        Medium("Medium"),
        Low("Low");

        String value;

        Quality(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    static class Toy implements Toyface {
        String name;
        String color;
        double price;
        Quality quality;

        public Toy(String name, String color, double price, Quality quality) {
            this.name = name;
            this.color = color;
            this.price = price;
            this.quality = quality;
        }

        public String display() {
            return "name = " + name + " , color = " + color + " , price = " + price + " , quality = " + quality;
        }

        @Override
        public double discount(double price) {
            return price / 2;
        }

    }

}

