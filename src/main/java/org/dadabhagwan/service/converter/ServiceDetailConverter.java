package org.dadabhagwan.service.converter;

import org.dadabhagwan.dao.Category;
import org.dadabhagwan.dao.ServiceDetail;
import org.dadabhagwan.model.ServiceDetailModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServiceDetailConverter implements Converter<ServiceDetailModel, ServiceDetail> {

    @Override
    public ServiceDetail convert(ServiceDetailModel serviceDetailModel) {
        ServiceDetail serviceDetail = new ServiceDetail();
        serviceDetail.setServiceName(serviceDetailModel.getServiceName());
        Category category = new Category();
        category.setId(serviceDetailModel.getCategory().getId());
        serviceDetail.setCategory(category);
        return serviceDetail;
    }
}