package org.dadabhagwan.service;

import org.dadabhagwan.dao.Category;
import org.dadabhagwan.dao.ServiceDetail;
import org.dadabhagwan.dao.ServiceDetailDao;
import org.dadabhagwan.model.ServiceDetailModel;
import org.dadabhagwan.service.converter.ServiceDetailConverter;
import org.dadabhagwan.service.converter.ServiceDetailModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDetailServiceImpl {

    @Autowired
    private ServiceDetailDao serviceDetailDao;
    @Autowired
    private ServiceDetailModelConverter modelConverter;
    @Autowired
    protected ServiceDetailConverter serviceDetailConverter;

    @Transactional
    public List<ServiceDetailModel> findAll() {
        Iterable<ServiceDetail> serviceDetails = serviceDetailDao.findAll();
        List<ServiceDetailModel> serviceDetailModels = new ArrayList<>();
        serviceDetails.forEach(service -> {
            serviceDetailModels.add(modelConverter.convert(service));
        });
        return serviceDetailModels;
    }

    @Transactional
    public ServiceDetailModel save(ServiceDetailModel serviceDetailModel) {
        ServiceDetail serviceDetail = serviceDetailConverter.convert(serviceDetailModel);
        ServiceDetail savedServiceDetail = serviceDetailDao.save(serviceDetail);
        serviceDetailModel.setId(savedServiceDetail.getId());
        return serviceDetailModel;
    }


}
