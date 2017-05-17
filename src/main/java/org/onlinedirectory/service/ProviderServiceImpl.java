package org.onlinedirectory.service;

import org.onlinedirectory.dao.Provider;
import org.onlinedirectory.dao.ProviderDao;
import org.onlinedirectory.model.ProviderModel;
import org.onlinedirectory.service.converter.ProviderConverter;
import org.onlinedirectory.service.converter.ProviderModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl {

    @Autowired
    private ProviderDao providerDao;
    @Autowired
    private ProviderModelConverter providerModelConverter;
    @Autowired
    private ProviderConverter providerConverter;

    public List<ProviderModel> findAll() {
        Iterable<Provider> providers = providerDao.findAllProviderWithService();
        List<ProviderModel> providerModels = new ArrayList<>();
        providers.forEach(provider -> {
            providerModels.add(providerModelConverter.convert(provider));
        });
        return providerModels;
    }

    public ProviderModel save(ProviderModel providerModel) {
        Provider provider = providerConverter.convert(providerModel);
        Provider savedProvider = providerDao.save(provider);
        providerModel.setId(savedProvider.getId());
        return providerModel;
    }

    public ProviderModel findOne(Long id) {
        return providerModelConverter.convert(providerDao.findOne(id));
    }
}
