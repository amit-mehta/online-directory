package org.dadabhagwan.service.converter;

import org.dadabhagwan.dao.Category;
import org.dadabhagwan.model.CategoryModel;
import org.dadabhagwan.model.ServiceDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryModelConverter implements Converter<Category, CategoryModel> {

    @Autowired
    private ServiceDetailModelConverter serviceDetailModelConverter;

    @Override
    public CategoryModel convert(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setName(category.getCategoryName());
        List<ServiceDetailModel> serviceDetailModels = category.getServiceDetails().stream()
                .map(serviceDetail -> serviceDetailModelConverter.convert(serviceDetail)).collect(Collectors.toList());
        categoryModel.setServiceDetails(serviceDetailModels);
        return categoryModel;
    }
}
