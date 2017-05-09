package org.dadabhagwan.service.converter;

import org.dadabhagwan.dao.Category;
import org.dadabhagwan.model.CategoryModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<CategoryModel, Category> {

    @Override
    public Category convert(CategoryModel categoryModel) {
        Category category = new Category();
        category.setCategoryName(categoryModel.getName());
        return category;
    }
}
