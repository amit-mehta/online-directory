package org.dadabhagwan.controller;

import org.dadabhagwan.model.ServiceDetailModel;
import org.dadabhagwan.service.ServiceDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "service")
public class ServiceDetailController {

    @Autowired
    private ServiceDetailServiceImpl serviceDetailService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ServiceDetailModel> findAll() {
        return serviceDetailService.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ServiceDetailModel createService(@Valid @RequestBody ServiceDetailModel serviceDetailModel) {
        return serviceDetailService.save(serviceDetailModel);
    }
}
