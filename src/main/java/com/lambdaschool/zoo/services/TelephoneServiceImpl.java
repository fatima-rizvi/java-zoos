package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the UseremailService Interface
 */
@Transactional
@Service(value = "useremailService")
public class TelephoneServiceImpl
        implements TelephoneService
{
    /**
     * Connects this service to the Useremail model
     */
    @Autowired
    private TelephoneRepository useremailrepos;

    /**
     * Connects this servive to the User Service
     */
    @Autowired
    private ZooService zooService;

}
