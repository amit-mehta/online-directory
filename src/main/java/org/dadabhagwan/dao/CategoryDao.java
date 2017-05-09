package org.dadabhagwan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
//    @Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")

    @Query("SELECT c FROM Category c JOIN FETCH c.serviceDetails")
    Iterable<Category> findAllCategoriesWithServices();

}
