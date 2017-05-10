package org.dadabhagwan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

    @Query("SELECT distinct c FROM Category c LEFT JOIN FETCH c.serviceDetails")
    Iterable<Category> findAllCategoriesWithServices();
}
