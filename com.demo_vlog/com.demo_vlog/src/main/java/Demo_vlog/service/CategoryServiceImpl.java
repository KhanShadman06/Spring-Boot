package Demo_vlog.service;

import Demo_vlog.Model.Category;
import Demo_vlog.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
