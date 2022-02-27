package matcher;

import model.Product;
import org.testng.Assert;
import utils.comparator.ProductTitleComparator;

import java.util.*;

public class ProductMatchers {

    public static void validateSortedProducts(
            List<Product> sortedProductList, List<Product> savedBeforeSortProductList
    ) {
        Assert.assertFalse(sortedProductList.equals(savedBeforeSortProductList),
                String.format(
                        "Сохраненные до сортировки продукты не отличаются: \nОжидаемый результат: %s\nАктуальный результат: %s",
                        savedBeforeSortProductList, sortedProductList
                )
        );
        Comparator<Product> productComparator = new ProductTitleComparator();
        savedBeforeSortProductList.sort((p1, p2) -> productComparator.compare(p1, p2));
        Collections.reverse(savedBeforeSortProductList);
        Assert.assertTrue(sortedProductList.equals(savedBeforeSortProductList),
                String.format(
                        "Сортировка отличается: \nОжидаемый результат: %s\nАктуальный результат: %s",
                        savedBeforeSortProductList, sortedProductList
                )
        );
    }

}
