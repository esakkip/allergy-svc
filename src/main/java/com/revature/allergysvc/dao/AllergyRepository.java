package com.revature.allergysvc.dao;

import com.revature.allergysvc.model.Allergy;
import org.springframework.data.repository.CrudRepository;

interface AllergyRepository extends CrudRepository<Allergy, Integer> {

}
