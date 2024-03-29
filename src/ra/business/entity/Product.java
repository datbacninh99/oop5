package ra.business.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private String productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, String productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm (bắt đầu là một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh tố, A: các đồ ăn nhanh)): ");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[CSA]\\w{3}")) {
                this.productId = input;
                break;
            } else {
                System.out.println("Mã sản phẩm không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập tên sản phẩm (từ 10-50 ký tự): ");
        while (true) {
            String nameInput = scanner.nextLine();
            if (nameInput.length() >= 10 && nameInput.length() <= 50) {
                this.productName = nameInput;
                break;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ! Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập giá sản phẩm: ");
        while (true) {
            try {
                float inputPrice = Float.parseFloat(scanner.nextLine());
                if (inputPrice > 0) {
                    this.price = inputPrice;
                    break;
                } else {
                    System.out.println("Giá sản phẩm phải lớn hơn 0! Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá sản phẩm không hợp lệ! Vui lòng nhập lại.");
            }
        }
        System.out.println("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập ngày nhập sản phẩm (dd/MM/yyyy): ");
        while (true) {
            try {
                String dateString = scanner.nextLine();
                this.created = sdf.parse(dateString);
                break;
            } catch (ParseException e) {
                System.out.println("Định dạng ngày không hợp lệ! Vui lòng nhập lại (dd/MM/yyyy).");
            }
        }

        System.out.println("Nhập mã danh mục sản phẩm: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập trạng thái sản phẩm (ACTIVE: Đang bán – BLOCK: Hết hàng – INACTIVE: Không bán): ");
        while (true) {
            String statusInput = scanner.nextLine().toUpperCase();
            if (statusInput.equals("ACTIVE") || statusInput.equals("BLOCK") || statusInput.equals("INACTIVE")) {
                this.productStatus = statusInput;
                break;
            } else {
                System.out.println("Trạng thái sản phẩm không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Thông tin sản phẩm:");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá sản phẩm: " + this.price);
        System.out.println("Mô tả sản phẩm: " + this.description);
        System.out.println("Ngày nhập sản phẩm: " + sdf.format(this.created));
        System.out.println("Mã danh mục sản phẩm: " + this.catalogId);
        System.out.println("Trạng thái sản phẩm: " + this.productStatus);
    }
}
