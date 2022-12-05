package com.gb.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart = context.getBean(Cart.class);
        System.out.println("Here's the list of our products:");
        cart.getList();
        System.out.println("Please, type 'add', space and the number of a product you want to add to your cart.");
        System.out.println("To remove a product you can type 'remove' followed by space and the number of the product you want to remove for the cart.");
        System.out.println("Type 'view' to view the contents of your cart.");
        System.out.println("Type 'exit' to leave.");

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String[] token = input.split(" ");
            try {
                switch (token[0]) {
                    case "add" -> cart.addToCart(Integer.valueOf(token[1]));
                    case "remove" -> cart.removeFromCart(Integer.valueOf(token[1]));
                    case "view" -> cart.getCart();
                }
            } catch (NumberFormatException n) {
                cart.getCart();
            }
            if (token[0].equals("break")) break;
        }

        sc.close();
        context.close();
    }
}