package org.onlinedirectory.service;

import org.onlinedirectory.dao.Category;
import org.onlinedirectory.dao.CategoryDao;
import org.onlinedirectory.model.CategoryModel;
import org.onlinedirectory.service.converter.CategoryConverter;
import org.onlinedirectory.service.converter.CategoryModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryModelConverter modelConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    public List<CategoryModel> findAll() {
        Iterable<Category> categories = categoryDao.findAllCategoriesWithServices();
        List<CategoryModel> categoryModels = new ArrayList<>();
        categories.forEach(category -> {
            categoryModels.add(modelConverter.convert(category));
        });
        return categoryModels;
    }

    @Transactional
    public CategoryModel save(CategoryModel categoryModel) {
        Category category = categoryConverter.convert(categoryModel);
        Category savedCategory = categoryDao.save(category);
        categoryModel.setId(savedCategory.getId());
        return categoryModel;
    }

    public CategoryModel findOne(Long id) {
        return modelConverter.convert(categoryDao.findOne(id));
    }
}
