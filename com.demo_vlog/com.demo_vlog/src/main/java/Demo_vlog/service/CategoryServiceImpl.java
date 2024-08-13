package Demo_vlog.service;

import Demo_vlog.Model.Category;
import Demo_vlog.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            // Add any other fields that need to be updated
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
