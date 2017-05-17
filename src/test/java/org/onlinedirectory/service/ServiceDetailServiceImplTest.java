package org.onlinedirectory.service;

import org.onlinedirectory.model.CategoryModel;
import org.onlinedirectory.model.ServiceDetailModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ServiceDetailServiceImplTest extends AbstractTest{

    @Autowired
    private ServiceDetailServiceImpl serviceDetailService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findAll() throws Exception {

        CategoryModel category1 = CategoryModel.builder().name("CategoryOne").build();
        CategoryModel category2 = CategoryModel.builder().name("CategoryTwo").build();
        category1 = categoryService.save(category1);
        category2 = categoryService.save(category2);

        ServiceDetailModel service1 = ServiceDetailModel.builder().serviceName("Service1")
                .category(category1).build();
        ServiceDetailModel service2 = ServiceDetailModel.builder().serviceName("Service2")
                .category(category1).build();
        ServiceDetailModel service3 = ServiceDetailModel.builder().serviceName("Service3")
                .category(category2).build();
        ServiceDetailModel service4 = ServiceDetailModel.builder().serviceName("Service4")
                .category(category2).build();
        serviceDetailService.save(service1);
        serviceDetailService.save(service2);
        serviceDetailService.save(service3);
        serviceDetailService.save(service4);

        List<ServiceDetailModel> serviceModels = serviceDetailService.findAll();

        assertThat(serviceModels.size(), is(4));
    }

}