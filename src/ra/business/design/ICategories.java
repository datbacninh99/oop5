package ra.business.design;

import ra.business.entity.Categories;

public interface ICategories extends IGenericDesign<Categories> {
    void displayAll();

    void updateCategoryInfo(int categoryId);
    void deleteCategoryById(int categoryId);
    void updateCategoryStatus(int categoryId);
}