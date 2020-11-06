package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.models.ZooAnimals;
import com.lambdaschool.zoo.services.ZooService;
import com.lambdaschool.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements UserService Interface
 */
@Transactional
@Service(value = "zooService")
public class ZooServiceImpl
        implements ZooService
{
    /**
     * Connects this service to the Zoo table.
     */
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAllZoos() {
        ArrayList<Zoo> allZoosList = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(allZoosList::add);
        return allZoosList;
    }

    @Override
    public Zoo findZooById(long id) {
        Zoo z = zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " not found"));
        return z;
    }
}
