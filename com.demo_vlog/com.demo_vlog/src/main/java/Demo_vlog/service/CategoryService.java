package Demo_vlog.service;

import Demo_vlog.Model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void deleteCategory(Long id);
}
