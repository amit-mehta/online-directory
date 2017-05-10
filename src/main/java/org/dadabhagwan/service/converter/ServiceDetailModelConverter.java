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
        CategoryModel categoryModel = CategoryModel.builder().id(serviceDetail.getCategory().getId()).build();

        List<Provider> providers = serviceDetail.getProviders();
        List<ProviderModel> providerModels = providers.stream().map(provider -> providerModelConverter.convert(provider))
                .collect(Collectors.toList());

        return ServiceDetailModel.builder().id(serviceDetail.getId()).serviceName(serviceDetail.getServiceName())
                .category(categoryModel).providers(providerModels).build();
    }
}
