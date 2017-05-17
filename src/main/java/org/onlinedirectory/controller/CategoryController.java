package org.onlinedirectory.controller;

import org.onlinedirectory.dao.CategoryDao;
import org.onlinedirectory.model.CategoryModel;
import org.onlinedirectory.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CategoryModel> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CategoryModel findOne(@PathVariable Long id) {
        return categoryService.findOne(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public CategoryModel createCategory(@RequestBody CategoryModel category) {
        return categoryService.save(category);
    }


}
