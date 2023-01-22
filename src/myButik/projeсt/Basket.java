package myButik.projeсt;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

}
