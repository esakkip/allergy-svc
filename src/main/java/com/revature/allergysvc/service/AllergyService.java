package com.revature.allergysvc.service;

import com.revature.allergysvc.dao.AllergyDao;
import com.revature.allergysvc.dao.AllergyDaoException;
import com.revature.allergysvc.model.Allergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AllergyService {

    Logger logger = Logger.getLogger(AllergyService.class.getName());

    private AllergyDao allergyDao;

    @Autowired
    public AllergyService(AllergyDao allergyDao) {
        this.allergyDao = allergyDao;
    }

    public List<Allergy> getAllAllergies() throws AllergyServiceException {
        List<Allergy> allergies;
        try {
            allergies = this.allergyDao.listAllAllergies();
        } catch (AllergyDaoException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            throw new AllergyServiceException("Allergy details retrieval failed.", exception);
        }
        return allergies;
    }


    public Allergy getAllergyById(int id) throws AllergyServiceException {
        Allergy allergy = null;
        try {
            Optional<Allergy> retrievedAllergy = this.allergyDao.listAllergyById(id);
            if (retrievedAllergy.isPresent()) {
                allergy = retrievedAllergy.get();
            }
        } catch (AllergyDaoException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            throw new AllergyServiceException(String.format("Allergy of id %d retrieval failed.", id), exception);
        }
        return allergy;
    }
}
