package matchers;

import model.Product;
import org.testng.Assert;
import utils.comparator.ProductComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMatchers {

    public static void validateListsSortingIsEqual(List<Product> sortedProducts, List<Product> savedBeforeSortProducts) {
        Assert.assertFalse(sortedProducts.equals(savedBeforeSortProducts),
                "Сохраненные до сортировки продукты равны отсортированным"
        );
        Comparator<Product> productComparator = new ProductComparator();
        savedBeforeSortProducts.sort((p1, p2) -> productComparator.compare(p1, p2));
        Collections.reverse(savedBeforeSortProducts);
        Product product3 = savedBeforeSortProducts.get(3);
        savedBeforeSortProducts.set(3, savedBeforeSortProducts.get(4));
        savedBeforeSortProducts.set(4, product3);
        Assert.assertEquals(sortedProducts, savedBeforeSortProducts,
                "Тестовая сортировка не равна сортировке сайта"
        );
    }


}
