package org.onlinedirectory.service.converter;

import org.onlinedirectory.dao.Provider;
import org.onlinedirectory.dao.ServiceDetail;
import org.onlinedirectory.model.ProviderModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter implements Converter<ProviderModel, Provider> {

    @Override
    public Provider convert(ProviderModel providerModel) {
        Provider provider = new Provider();
        provider.setProviderName(providerModel.getProviderName());
        provider.setReference(providerModel.getReference());
        provider.setContact(providerModel.getContact());
        ServiceDetail serviceDetail = new ServiceDetail();
        serviceDetail.setId(providerModel.getServiceDetail().getId());
        provider.setServiceDetail(serviceDetail);
        return provider;
    }
}
