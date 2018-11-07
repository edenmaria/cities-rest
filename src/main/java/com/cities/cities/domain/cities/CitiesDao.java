package com.cities.cities.domain.cities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.cities.cities.domain.cities.Cities;

public interface CitiesDao extends CrudRepository<Cities, Long> {
    List<Cities> findByName(String name);
    // List<Cities> findDistinctByCategory(String category);
    // List<Cities> findByTitleAndCategory(String title, String category);

    List<Cities> findById(Long id);
} 
