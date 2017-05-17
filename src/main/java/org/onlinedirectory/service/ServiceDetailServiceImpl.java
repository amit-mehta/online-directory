package org.onlinedirectory.service;

import org.onlinedirectory.dao.ServiceDetail;
import org.onlinedirectory.dao.ServiceDetailDao;
import org.onlinedirectory.model.ServiceDetailModel;
import org.onlinedirectory.service.converter.ServiceDetailConverter;
import org.onlinedirectory.service.converter.ServiceDetailModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
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
        Iterable<ServiceDetail> serviceDetails = serviceDetailDao.findAllServiceWithCategoryAndProvider();
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


    public ServiceDetailModel findOne(Long id) {
        return modelConverter.convert(serviceDetailDao.findOne(id));
    }
}
