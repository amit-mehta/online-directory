package org.onlinedirectory.controller;

import org.onlinedirectory.model.ProviderModel;
import org.onlinedirectory.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "provider")
public class ProviderController {

    @Autowired
    private ProviderServiceImpl providerService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProviderModel> findAll() {
        return providerService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProviderModel findOne(@PathVariable Long id) {
        return providerService.findOne(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ProviderModel createProvider(@RequestBody ProviderModel providerModel) {
        return providerService.save(providerModel);
    }

}
