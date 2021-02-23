package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static ArrayList<Product> list = new ArrayList();
    public static Scanner s = new Scanner(System.in);
    public static int choice;
    public static boolean bool = false;

    public static void main(String[] args) {

        try {
            do {

                String userName = "h";
                String password = "1";

                System.out.println("Enter Your Name :");
                String user = s.nextLine();
                System.out.println("Enter Your Password : ");
                String pass = s.nextLine();

                if (user.equals(userName) && pass.equals(password)) {
                    bool = true;
                    System.out.println("********************************************************************* \n");
                    System.out.println("Welcome the System is Ready Now.\n");
                    System.out.println("*********************************************************************\n");
                    showChoose();
                } else {
                    bool = false;
                    System.out.println("Incorrect UserName Or Password");
                }

            }
            while (bool == false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void showChoose() {
        try {
            do {
                System.out.println("1_ Show All Product");
                System.out.println("2_ Add Product");
                System.out.println("3_ Delete Product");
                System.out.println("4_ Edit Product");
                System.out.println("5_ Calculate Total Price ");
                System.out.println("6_ Exit");
                System.out.println("Enter Your Choice");
                choice = s.nextInt();

                if (choice == 1) {
                    ShowProduct();
                } else if (choice == 2) {
                    AddProduct();
                } else if (choice == 3) {
                    DeleteProduct();
                } else if (choice == 4) {
                    EditProduct();
                } else if (choice == 5) {
                    CalculateProduct();
                } else if (choice == 6) {
                    System.out.println("Successfully logged out!");
                    break;
                }
            }
            while (choice != 6);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void ShowProduct() {
        if (list.size() > 0) {
            for (Product product : list) {
                System.out.println("Product { " + "Id = " + product.getProductId() + " , Name = " + product.getProductName()
                        + " , Price = " + product.getProductPrice()
                        + " , Quantity = " + product.getProductQuantity() + " } ");
                System.out.println("");
            }
            System.out.println("******************************************************************");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("There are no Product to show.");
            System.out.println("");
            System.out.println("******************************************************************");
            System.out.println("");
        }
    }

    private static void AddProduct() {
        System.out.println("Enter {ProductId , ProductName , ProductPrice , ProductQuantity}");
        System.out.println("");
        System.out.println("1- ProductId.");
        int productId = s.nextInt();
        System.out.println("2- ProductName.");
        String productName = s.next();
        System.out.println("3- ProductPrice.");
        double productPrice = s.nextDouble();
        System.out.println("4- ProductQuantity.");
        int productQuantity = s.nextInt();
        list.add(new Product(productId, productName, productPrice, productQuantity));
        System.out.println("");
        System.out.println("******************************************************************");
        System.out.println("");
    }

    private static void DeleteProduct() {
        System.out.println("Enter Product Id.");
        int productId = s.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId() == productId) {
                list.remove(i);
            }
        }
        System.out.println(" Deleted successful. { productId : " + productId + " } ");
        System.out.println("");
        System.out.println("******************************************************************");
        System.out.println("");
    }

    private static void EditProduct() {
        System.out.println("Enter Product Id.");
        int productId = s.nextInt();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId() == productId) {
                System.out.println("");
                System.out.println("Product { " + "Id = " + list.get(i).getProductId()
                        + " , Name = " + list.get(i).getProductName()
                        + " , Price = " + list.get(i).getProductPrice()
                        + " , Quantity = " + list.get(i).getProductQuantity() + " } ");
                System.out.println("");
                System.out.println("1- Enter new Product Id :");
                int productIds = s.nextInt();
                System.out.println("2- Enter new Product Name : ");
                String productName = s.next();
                System.out.println("3- Enter new Product Price : ");
                double productPrice = s.nextDouble();
                System.out.println("4- Enter new Product Quantity : ");
                int productQuantity = s.nextInt();
                list.set(i, new Product(productIds, productName, productPrice, productQuantity));
                System.out.println("");
                System.out.println("******************************************************************");
                System.out.println("");
            }
        }
    }

    private static void CalculateProduct() {
        double price;
        int Quantity;
        double Total = 0;
        for (Product product : list) {
            price = product.getProductPrice();
            Quantity = product.getProductQuantity();
            Total = Total + price * Quantity;
        }

        System.out.println("Total Price : " + Total);
        System.out.println("");
        System.out.println("******************************************************************");
        System.out.println("");
    }



}

