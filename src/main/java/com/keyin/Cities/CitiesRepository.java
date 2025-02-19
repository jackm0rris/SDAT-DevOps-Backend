package com.keyin.Cities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends CrudRepository<Cities, Long> {
}