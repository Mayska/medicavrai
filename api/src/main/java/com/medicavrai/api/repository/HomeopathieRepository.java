package com.medicavrai.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medicavrai.api.model.Homeopathie;

@Repository
public interface HomeopathieRepository extends CrudRepository<Homeopathie, Long> {

}
