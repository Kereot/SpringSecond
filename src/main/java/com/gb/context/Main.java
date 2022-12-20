package com.gb.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        System.out.println("Customer list:");
        System.out.println(customerDao.findAll());
        System.out.println();
        System.out.println("Product list:");
        System.out.println(productDao.findAll());
        System.out.println();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Type 'C', space and a customer number for info");
            System.out.println("Type 'P', space and a product number for info");
            System.out.println("Type 'CP', space and a customer number for this customer purchases");
            System.out.println("Type 'PC', space and a product number for this product buyers");
            String in = sc.nextLine();
            String[] token = in.split(" ");
            try {
                if (token[0].equals("C")) {
                    System.out.println(customerDao.findById(Integer.parseInt(token[1])));
                }
                if (token[0].equals("P")) {
                    System.out.println(productDao.findById(Integer.parseInt(token[1])));
                }
                if (token[0].equals("CP")) {
                    customerDao.getProductsByCustomersId(Integer.parseInt(token[1]));
                }
                if (token[0].equals("PC")) {
                    productDao.getCustomersByProductsId(Integer.parseInt(token[1]));
                }
                } catch (Exception i) {
                System.out.println("No such customer or product");
            }
            if (token[0].equals("break")) break;
        }
        sc.close();
        context.close();
    }
}