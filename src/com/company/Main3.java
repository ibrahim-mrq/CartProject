package com.company;

import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) {

        Cloth cloth = new Cloth(1, "A", "R", 10.0, 11, Size.small);
        System.out.println(cloth.totalPrice(cloth.price, cloth.quantity));
    }

    static class Cloth {
        int id;
        String model;
        String color;
        double price;
        int quantity;
        Size size;

        public Cloth(int id, String model, String color, double price, int quantity, Size size) {
            this.id = id;
            this.model = model;
            this.color = color;
            this.price = price;
            this.quantity = quantity;
            this.size = size;
        }

        double totalPrice(Double price, int quantity) {
            if (quantity > 10) {
                return price * quantity / (2.0);
            } else
                return price * quantity;
        }
    }

    enum Size {
        small, medium, large, xl, xxl, xxxl
    }
}
