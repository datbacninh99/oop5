package ra.business.implement;

import ra.business.design.ICategories;
import ra.business.entity.Categories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CategoriesImplement implements ICategories {
    private List<Categories> categoriesList;

    public CategoriesImplement() {
        categoriesList = new ArrayList<>();
    }

    @Override
    public void create(Categories entity) {
        categoriesList.add(entity);
    }

    @Override
    public Categories read(int id) {
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void update(Categories entity) {
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == entity.getCatalogId()) {
                category.setCatalogName(entity.getCatalogName());
                category.setDescriptions(entity.getDescriptions());
                category.setCatalogStatus(entity.isCatalogStatus());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Categories categoryRemove = null;
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == id) {
                categoryRemove = category;
                break;
            }
        }
        if (categoryRemove != null) {
            categoriesList.remove(categoryRemove);
        }
    }

    @Override
    public void updateCategoryInfo(int categoryId) {
         Scanner scanner = new Scanner(System.in);
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == categoryId) {
                System.out.println("Nhập tên danh mục mới: ");
                String newName = scanner.nextLine();
                System.out.println("Nhập mô tả danh mục mới:");
                String newDescription = scanner.nextLine();
                category.setCatalogName(newName);
                category.setDescriptions(newDescription);
                System.out.println("Thông tin danh mục đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã " + categoryId);
    }

    @Override
    public void deleteCategoryById(int categoryId) {
        Iterator<Categories> iterator = categoriesList.iterator();
        while (iterator.hasNext()) {
            Categories category = iterator.next();
            if (category.getCatalogId() == categoryId) {
                iterator.remove();
                System.out.println("Đã xóa danh mục có mã " + categoryId);
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã " + categoryId);
    }

    @Override
    public void updateCategoryStatus(int categoryId) {
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == categoryId) {
                category.setCatalogStatus(!category.isCatalogStatus());
                System.out.println("Trạng thái danh mục đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã " + categoryId);
    }

    @Override
    public void displayAll() {
        for (Categories categories : categoriesList) {
            System.out.println(categories);
        }
    }
}