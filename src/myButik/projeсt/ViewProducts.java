package myButik.projeсt;

import java.util.ArrayList;

/*Правило DRY — при выборе продуктов и в корзине один метод вывода на экран*/
public class ViewProducts {
    public static void print(ArrayList<Product> products) {
        for (Product s : products) {
            System.out.println(s);
        }
    }

}
