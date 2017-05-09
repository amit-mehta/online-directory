package org.dadabhagwan.service;

import org.dadabhagwan.dao.CategoryDao;
import org.dadabhagwan.model.CategoryModel;
import org.dadabhagwan.model.ProviderModel;
import org.dadabhagwan.model.ServiceDetailModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CategoryServiceDetailImplTest extends AbstractTest{

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ServiceDetailServiceImpl serviceDetailService;

    @Autowired
    private ProviderServiceImpl providerService;

    @Test
    public void findAllCategoriesWithoutServices() throws Exception {
        CategoryModel automobile = CategoryModel.builder().name("Automobile").build();
        CategoryModel realEstate = CategoryModel.builder().name("RealEstate").build();
        categoryService.save(automobile);
        categoryService.save(realEstate);

        List<CategoryModel> categoryList = categoryService.findAll();
        categoryList.forEach(categoryModel -> {
            System.out.println("category = " + categoryModel.getName());
        });

        assertThat(categoryList.size(), is(2));
        categoryDao.delete(categoryList.get(0).getId());
        categoryDao.delete(categoryList.get(1).getId());
    }

    @Test
    public void findAllCategoriesWithServices() {

        CategoryModel automobile = CategoryModel.builder().name("Automobile").build();
        CategoryModel realEstate = CategoryModel.builder().name("RealEstate").build();
        CategoryModel autoCategoryModel = categoryService.save(automobile);
        CategoryModel estateCategoryModel = categoryService.save(realEstate);

        ServiceDetailModel carService = ServiceDetailModel.builder().serviceName("Car Service")
                .category(autoCategoryModel).build();
        ServiceDetailModel carWashService = ServiceDetailModel.builder().serviceName("Car Wash")
                .category(autoCategoryModel).build();

        ServiceDetailModel rentService = ServiceDetailModel.builder().serviceName("House Rent")
                .category(estateCategoryModel).build();
        ServiceDetailModel buyService = ServiceDetailModel.builder().serviceName("House Buy")
                .category(estateCategoryModel).build();

        serviceDetailService.save(carService);
        serviceDetailService.save(carWashService);
        serviceDetailService.save(rentService);
        serviceDetailService.save(buyService);

        List<CategoryModel> categoryList = categoryService.findAll();
        categoryList.forEach(categoryModel -> {
            System.out.println("category = " + categoryModel.getName());
        });

        assertThat(categoryList.size(), is(2));
        assertThat(categoryList.get(0).getServiceDetails().size(), is(2));
        assertThat(categoryList.get(1).getServiceDetails().size(), is(2));

        categoryDao.delete(categoryList.get(0).getId());
        categoryDao.delete(categoryList.get(1).getId());
    }

    @Test
    public void findAllCategoriesWithServicesAndProviders() {
        CategoryModel automobile = CategoryModel.builder().name("Automobile").build();
        CategoryModel realEstate = CategoryModel.builder().name("RealEstate").build();
        CategoryModel autoCategoryModel = categoryService.save(automobile);
        CategoryModel estateCategoryModel = categoryService.save(realEstate);

        ServiceDetailModel carService = ServiceDetailModel.builder().serviceName("Car Service")
                .category(autoCategoryModel).build();
        ServiceDetailModel carWashService = ServiceDetailModel.builder().serviceName("Car Wash")
                .category(autoCategoryModel).build();

        ServiceDetailModel rentService = ServiceDetailModel.builder().serviceName("House Rent")
                .category(estateCategoryModel).build();
        ServiceDetailModel buyService = ServiceDetailModel.builder().serviceName("House Buy")
                .category(estateCategoryModel).build();

        ServiceDetailModel service1 = serviceDetailService.save(carService);
        ServiceDetailModel service2 = serviceDetailService.save(carWashService);
        ServiceDetailModel service3 =serviceDetailService.save(rentService);
        ServiceDetailModel service4 =serviceDetailService.save(buyService);

        ProviderModel provider1 = ProviderModel.builder().providerName("Car Service Provider")
                .serviceDetail(service1).build();
        ProviderModel provider2 = ProviderModel.builder().providerName("Car Wash Service Provider")
                .serviceDetail(service2).build();
        ProviderModel provider3 = ProviderModel.builder().providerName("House Rent Service Provider")
                .serviceDetail(service3).build();
        ProviderModel provider4 = ProviderModel.builder().providerName("House Buy Service Provider")
                .serviceDetail(service4).build();

        providerService.save(provider1);
        providerService.save(provider2);
        providerService.save(provider3);
        providerService.save(provider4);

        List<CategoryModel> categoryList = categoryService.findAll();
        categoryList.forEach(categoryModel -> {
            System.out.println("category = " + categoryModel.getName());
        });

        assertThat(categoryList.size(), is(2));
        assertThat(categoryList.get(0).getServiceDetails().size(), is(2));
        assertThat(categoryList.get(1).getServiceDetails().size(), is(2));

        ServiceDetailModel serviceModel1 = categoryList.get(0).getServiceDetails().get(0);
        serviceModel1.getProviders().forEach(providerModel -> {
            System.out.println("providerModel = " + providerModel.getProviderName());
        });

    }

}