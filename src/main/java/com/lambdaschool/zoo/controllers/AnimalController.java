package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.Views.AnimalCount;
import com.lambdaschool.zoo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * The entry point for clients to access role data
 * <p>
 * Note: we cannot update a role
 * we cannot update a role
 * working with the "non-owner" object in a many to many relationship is messy
 * we will be fixing that!
 */
@RestController
@RequestMapping("/animals")
public class AnimalController
{
    /**
     * Using the Role service to process Role data
     */
    @Autowired
    private AnimalService animalService;

    /**
     * /animals/count - that returns a JSON object list listing the animals
     * and a count of how many zoos where they can be found.
     * Use a custom query for this.
     **/

    @GetMapping(value = "/count", produces = {"application/json"})
    public ResponseEntity<?> animalCount() {

        return new ResponseEntity<>(animalService.animalCount(), HttpStatus.OK);
    }


}
