package ra.run;

import ra.business.entity.Categories;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("******************SHOP MENU******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát\n" +
                    "Vui lòng lựa chọn: \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCategoriesMenu(scanner);
                    break;
                case 2:
                    displayProductMenu(scanner);
                    break;
                case 3:
                    System.err.println("Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                    break;
            }
        }
    }

    private static void displayCategoriesMenu(Scanner scanner) {
        while (true) {
            System.out.println("******************CATEGORIES MENU******************\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Quay lại" +
                    "Vui lòng lựa chọn: \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputCategoriesInfo();
                    break;
                case 2:
                    displayCategoriesInfo();
                    break;
                case 3:
                    updateCategoriesInfo();
                    break;
                case 4:
                    deleteCategoriesInfo();
                    break;
                case 5:
                    updateCategoriesStatus();
                    break;
                case 6:
                    System.err.println("Quay lại");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                    break;
            }
        }
    }

    private static void inputCategoriesInfo(Scanner scanner) {
        System.out.println("Nhập số lượng danh mục: ");
        int numCategories = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCategories; i++) {
            System.out.println("Nhập thông tin cho danh mục thứ " + (i + 1) + ":");
            System.out.println("Tên danh mục:");
            String categoryName = scanner.nextLine();
            System.out.println("Mã danh mục:");
            int categoryId = Integer.parseInt(scanner.nextLine());
            categoriesList.add(new Categories(categoryId, categoryName));
        }
        System.out.println("Nhập thông tin các danh mục thành công.");
    }

    private static void displayCategoriesInfo() {
        if (categoriesList.isEmpty()) {
            System.out.println("Danh sách danh mục rỗng.");
        } else {
            System.out.println("Danh sách danh mục sản phẩm:");
            for (Categories category : categoriesList) {
                System.out.println(category);
            }
        }
    }

    private static void updateCategoriesInfo(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần cập nhật thông tin:");
        int categoryId = Integer.parseInt(scanner.nextLine());
        booleancheck = false;
        for (Categories category : categoriesList) {
            if (category.getId() == categoryId) {
                System.out.println("Nhập thông tin mới cho danh mục " + category.getName() + ":");
                System.out.println("Tên mới:");
                String newName = scanner.nextLine();
                category.setName(newName);
                System.out.println("Thông tin danh mục đã được cập nhật.");check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private static void updateCategoriesInfo(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần cập nhật thông tin:");
        int categoryId = Integer.parseInt(scanner.nextLine());
        booleancheck = false;
        for (Categories category : categoriesList) {
            if (category.getId() == categoryId) {
                System.out.println("Nhập thông tin mới cho danh mục " + category.getName() + ":");
                System.out.println("Tên mới:");
                String newName = scanner.nextLine();
                category.setName(newName);
                System.out.println("Thông tin danh mục đã được cập nhật.");check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private static void deleteCategoriesInfo(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần xóa:");
        int categoryId = Integer.parseInt(scanner.nextLine());
        booleancheck = false;
        for (Categories category : categoriesList) {
            if (category.getId() == categoryId) {
                categoriesList.remove(category);
                System.out.println("Danh mục đã được xóa.");check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }

    private static void updateCategoriesStatus(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần cập nhật trạng thái:");
        int categoryId = Integer.parseInt(scanner.nextLine());
        booleancheck = false;
        for (Categories category : categoriesList) {
            if (category.getId() == categoryId) {
                category.setActive(!category.isActive());
                System.out.println("Trạng thái của danh mục đã được cập nhật.");check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy danh mục có mã " + categoryId);
        }
    }


    private static void displayProductMenu(Scanner scanner) {
        while (true) {
            System.out.println("******************PRODUCT MANAGEMENT******************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn\n" +
                    "phím)\n" +
                    "8. Quay lại" +
                    "Vui lòng lựa chọn: \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProductInfo();
                    break;
                case 2:
                    displayProductInfo();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    updateProductInfoById();
                    break;
                case 5:
                    deleteProductById();
                    break;
                case 6:
                    searchProductByName();
                    break;
                case 7:
                    searchProductByPriceRange();
                    break;
                case 8:
                    System.err.println("Quay lại");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                    break;
            }
        }
    }

    private static void inputProductInfo() {

    }

    private static void displayProductInfo() {

    }

    private static void sortProductByPrice() {

    }

    private static void updateProductInfoById() {

    }

    private static void deleteProductById() {

    }

    private static void searchProductByName() {

    }

    private static void searchProductByPriceRange() {

    }
}