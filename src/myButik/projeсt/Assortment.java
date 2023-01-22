package myButik.projeсt;


import java.util.ArrayList;
import java.util.List;

public class Assortment {
    List<Product> assortment = new ArrayList<>();

    void addAssortment(Product product) {
        assortment.add(product);
    }
}

