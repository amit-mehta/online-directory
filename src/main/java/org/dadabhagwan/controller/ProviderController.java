package org.dadabhagwan.controller;

import org.dadabhagwan.model.ProviderModel;
import org.dadabhagwan.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "provider")
public class ProviderController {

    @Autowired
    private ProviderServiceImpl providerService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProviderModel> findAll() {
        return providerService.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProviderModel createProvider(@RequestBody ProviderModel providerModel) {
        return providerService.save(providerModel);
    }

}
