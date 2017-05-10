package org.dadabhagwan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderDao extends CrudRepository<Provider, Long> {

    @Query("SELECT DISTINCT p from Provider p LEFT JOIN FETCH p.serviceDetail s LEFT JOIN FETCH s.category")
    Iterable<Provider> findAllProviderWithService();
}
