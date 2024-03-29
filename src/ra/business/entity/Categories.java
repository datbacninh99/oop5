package ra.business.entity;

import java.util.Scanner;

public class Categories {
    private static int id = 1;
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = id++;
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã danh mục: ");
        while (true) {
            System.out.print("Tên danh mục (độ dài tối đa 50 ký tự): ");
            String nameInput = scanner.nextLine();
            if (nameInput.length() <= 50) {
                if (!isCatalogNameExist(nameInput)) {
                    System.out.println("Tên danh mục đã tồn tại! Vui lòng nhập lại.");
                } else {
                    this.catalogName = nameInput;
                    break;
                }
            } else {
                System.out.println("Tên danh mục quá dài! Vui lòng nhập lại.");
            }
            this.catalogName = scanner.nextLine();
            System.out.println("Nhập mô tả danh mục:");
            this.descriptions = scanner.nextLine();
            while (true) {
                System.out.print("Trạng thái danh mục: ");
                String statusInput = scanner.nextLine().toLowerCase();
                if (statusInput.equals("true") || statusInput.equals("false")) {
                    this.catalogStatus = Boolean.parseBoolean(statusInput);
                    break;
                } else {
                    System.out.println("Giá trị không hợp lệ, vui lòng nhập lại");
                }
            }
        }
    }

    public void displayData() {
        System.out.println("Thông tin danh mục:");
        System.out.println("Mã danh mục: " + this.catalogId);
        System.out.println("Tên danh mục: " + this.catalogName);
        System.out.println("Mô tả danh mục: " + this.descriptions);
        System.out.println("Trạng thái danh mục: " + (this.catalogStatus ? "Hoạt động" : "Không hoạt động"));
    }

    private boolean isCatalogNameExist(String nameInput) {
        return true;
    }
}
