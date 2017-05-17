package org.onlinedirectory.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ServiceDetailDao extends CrudRepository<ServiceDetail, Long> {

    @Query("SELECT DISTINCT sd from ServiceDetail sd left join fetch sd.providers Provider join fetch sd.category Category")
    Iterable<ServiceDetail> findAllServiceWithCategoryAndProvider();
}
