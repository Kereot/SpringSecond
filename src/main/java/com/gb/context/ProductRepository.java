package com.gb.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    private final int MAX_PROD = 5;
    public int getMAX_PROD() {
        return MAX_PROD;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        for (int i = 0; i < MAX_PROD; i++) {
            products.add(new Product(
                    i + 1,
                    "Product #" + (i + 1),
                    (float) Math.random() * (1000 - 10 + 1) + 10));
        }
    }

    public Product getById(int id) {
        return products.stream().filter(p -> p.id().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public void getList() {
        products.forEach(System.out::println);
    }
}
