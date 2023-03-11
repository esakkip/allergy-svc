package com.revature.allergysvc.controller;

import com.revature.allergysvc.model.Allergy;
import com.revature.allergysvc.service.AllergyService;
import com.revature.allergysvc.service.AllergyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class AllergyController {

    Logger logger = Logger.getLogger(AllergyController.class.getName());
    AllergyService allergyService;

    @Autowired
    public AllergyController(AllergyService allergyService) {
        this.allergyService = allergyService;
    }

    @GetMapping("/allergies")
    public ResponseEntity<List<Allergy>> fetchAllAllergies() {
        List<Allergy> allergies = null;
        try {
            allergies = this.allergyService.getAllAllergies();
            if (allergies.isEmpty()) {
                return new ResponseEntity<>(allergies, HttpStatus.NO_CONTENT);
            }
        } catch (AllergyServiceException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            return new ResponseEntity<>(allergies, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(allergies, HttpStatus.OK);
    }

    @GetMapping("/allergy/{id}")
    public ResponseEntity<Allergy> fetchAllergyById(@PathVariable("id") int id) {
        Allergy allergy = null;
        try {
            allergy = this.allergyService.getAllergyById(id);
            if (allergy == null) {
                return new ResponseEntity<>(allergy, HttpStatus.NO_CONTENT);
            }
        } catch (AllergyServiceException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            return new ResponseEntity<>(allergy, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(allergy, HttpStatus.OK);
    }
}
