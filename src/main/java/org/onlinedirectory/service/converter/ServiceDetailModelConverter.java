package org.onlinedirectory.service.converter;


import org.onlinedirectory.dao.Provider;
import org.onlinedirectory.dao.ServiceDetail;
import org.onlinedirectory.model.CategoryModel;
import org.onlinedirectory.model.ProviderModel;
import org.onlinedirectory.model.ServiceDetailModel;
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
