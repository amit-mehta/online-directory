package org.dadabhagwan.service.converter;


import org.dadabhagwan.dao.Category;
import org.dadabhagwan.dao.Provider;
import org.dadabhagwan.dao.ServiceDetail;
import org.dadabhagwan.model.CategoryModel;
import org.dadabhagwan.model.ProviderModel;
import org.dadabhagwan.model.ServiceDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceDetailModelConverter implements Converter<ServiceDetail, ServiceDetailModel> {

    @Autowired
    private ProviderModelConverter providerModelConverter;

    @Override
    public ServiceDetailModel convert(ServiceDetail serviceDetail) {
        ServiceDetailModel serviceDetailModel = new ServiceDetailModel();
        serviceDetailModel.setId(serviceDetail.getId());
        serviceDetailModel.setServiceName(serviceDetail.getServiceName());

        CategoryModel categoryModel = CategoryModel.builder().id(serviceDetail.getCategory().getId()).build();
        serviceDetailModel.setCategory(categoryModel);

        List<Provider> providers = serviceDetail.getProviders();
        List<ProviderModel> providerModels = providers.stream().map(provider -> providerModelConverter.convert(provider))
                .collect(Collectors.toList());
        serviceDetailModel.setProviders(providerModels);
        return serviceDetailModel;
    }
}
