package com.medicavrai.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medicavrai.api.model.SigneZodiaque;

@Repository
public interface SigneZodiaqueRepository extends CrudRepository<SigneZodiaque, Long> {

}
