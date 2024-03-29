package ra.business.implement;

import ra.business.design.IProduct;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductImplement implements IProduct {
    private List<Product> productList;

    public ProductImplement() {
        productList = new ArrayList<>();
    }

    @Override
    public void create(Product entity) {
        productList.add(entity);
    }

    @Override
    public Product read(int id) {
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product entity) {
        for (Product product : productList) {
            if (product.getProductId().equals(entity.getProductId())) {
                product.setProductName(entity.getProductName());
                product.setPrice(entity.getPrice());
                product.setDescription(entity.getDescription());
                product.setCreated(entity.getCreated());
                product.setCatalogId(entity.getCatalogId());
                product.setProductStatus(entity.getProductStatus());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(id)) {
                iterator.remove();
                System.out.println("Đã xóa sản phẩm có mã " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + id);
    }

    @Override
    public void sortProductsByPrice() {
        productList.sort((p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
    }

    @Override
    public void updateProductInfo(String productId) {
        Scanner scanner = new Scanner(System.in);
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Nhập tên sản phẩm mới: ");
                String newName = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm mới: ");
                float newPrice = scanner.nextFloat();
                System.out.println("Nhập mô tả sản phẩm mới: ");
                scanner.nextLine();
                String newDescription = scanner.nextLine();
                System.out.println("Nhập trạng thái sản phẩm mới (ACTIVE/BLOCK/INACTIVE): ");
                String newStatus = scanner.nextLine();
                product.setProductName(newName);
                product.setPrice(newPrice);
                product.setDescription(newDescription);
                product.setProductStatus(newStatus);
                System.out.println("Thông tin sản phẩm đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }

    @Override
    public void deleteProductById(String productId) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(productId)) {
                iterator.remove();
                System.out.println("Đã xóa sản phẩm có mã " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + productId);
    }

    @Override
    public void searchProductByName(String productName) {
        boolean check = false;
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println(product);
                check = true;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy sản phẩm có tên " + productName);
        }
    }

    @Override
    public void searchProductByPrice(float minPrice, float maxPrice) {
        boolean check = false;
        for (Product product : productList) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
                check = true;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy sản phẩm trong khoảng giá từ " + minPrice + " đến " + maxPrice);
        }
    }

    @Override
    public void displayAll() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}