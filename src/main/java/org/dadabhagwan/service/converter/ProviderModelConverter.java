package org.dadabhagwan.service.converter;

import org.dadabhagwan.dao.Provider;
import org.dadabhagwan.dao.ServiceDetail;
import org.dadabhagwan.model.ProviderModel;
import org.dadabhagwan.model.ServiceDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProviderModelConverter implements Converter<Provider, ProviderModel>{

    @Autowired
    private ServiceDetailModelConverter serviceDetailModelConverter;

    @Override
    public ProviderModel convert(Provider provider) {
        ProviderModel providerModel = new ProviderModel();
        providerModel.setId(provider.getId());
        providerModel.setContact(provider.getContact());
        providerModel.setProviderName(provider.getProviderName());
        providerModel.setReference(provider.getReference());

        ServiceDetail serviceDetail = provider.getServiceDetail();
        providerModel.setServiceDetail(ServiceDetailModel.builder().id(serviceDetail.getId()).build());
        return providerModel;
    }
}
