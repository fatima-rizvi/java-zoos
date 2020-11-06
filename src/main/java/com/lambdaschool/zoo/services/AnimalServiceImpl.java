package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.Views.AnimalCount;
import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Implements the RoleService Interface
 */
@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl
        implements AnimalService
{
    /**
     * Connects this service to the Role Model
     */
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<AnimalCount> animalCount() {
        return animalrepos.animalCount();
    }
}
