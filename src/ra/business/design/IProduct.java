package ra.business.design;

import ra.business.entity.Product;

public interface IProduct extends IGenericDesign<Product> {
    void sortProductsByPrice();
    void updateProductInfo(String productId);
    void deleteProductById(String productId);
    void searchProductByName(String productName);
    void searchProductByPrice(float minPrice, float maxPrice);

    void displayAll();
}