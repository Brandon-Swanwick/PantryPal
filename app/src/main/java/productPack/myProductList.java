package productPack;
import java.util.ArrayList;
import java.util.List;

import productPack.myProduct;
public class myProductList implements myProductListInterface{
    List<myProduct> products;
    public myProductList() {
        List<myProduct> products = new ArrayList<myProduct>();
    }

    @Override
    public void addProduct(myProduct product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(int index) {
        products.remove(index);

    }
}
