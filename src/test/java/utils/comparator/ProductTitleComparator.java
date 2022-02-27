package utils.comparator;

import model.Product;

import java.util.Comparator;

public class ProductTitleComparator implements Comparator<Product> {

    public int compare(Product a, Product b) {
        return a.getTitle().compareTo(b.getTitle());
    }

}
