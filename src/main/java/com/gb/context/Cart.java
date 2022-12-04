package com.gb.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> MY_CART = new ArrayList<>();

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCart(Integer id) {
        if (id > 0 && id <= productRepository.getMAX_PROD()) MY_CART.add(productRepository.getById(id));
    }

    public void removeFromCart(Integer id) {
//        MY_CART.removeIf(x -> (x.id().equals(id)));
        MY_CART.stream()
                .filter(x -> x.id().equals(id))
                .findFirst()
                .ifPresent(MY_CART::remove);
    }

    public void getList() {
        productRepository.getList();
    }

    public void getCart() {
        if (MY_CART.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            MY_CART.forEach(System.out::println);
        }
    }
}
