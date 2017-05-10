package org.dadabhagwan.service.converter;

import org.dadabhagwan.dao.Provider;
import org.dadabhagwan.dao.ServiceDetail;
import org.dadabhagwan.model.ProviderModel;
import org.dadabhagwan.model.ServiceDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProviderModelConverter implements Converter<Provider, ProviderModel> {

    @Autowired
    private ServiceDetailModelConverter serviceDetailModelConverter;

    @Override
    public ProviderModel convert(Provider provider) {
        ServiceDetailModel service = ServiceDetailModel.builder().id(provider.getServiceDetail().getId()).build();
        return ProviderModel.builder().id(provider.getId()).contact(provider.getContact())
                .providerName(provider.getProviderName()).reference(provider.getReference())
                .serviceDetail(service)
                .build();
    }
}
