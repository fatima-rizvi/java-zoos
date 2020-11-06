package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The entry point for clients to access zoo data
 */
@RestController
@RequestMapping("/zoos")
public class ZooController
{
    /**
     * Using the Zoo service to process zoo data
     */
    @Autowired
    private ZooService zooService;

    /**
     * Returns a list of all zoo

     */
    @GetMapping(value = "/zoos",
            produces = "application/json")
    public ResponseEntity<?> findAllZoos()
    {
//        List<Zoo> allZoos = zooService.findAllZoos();
//        return new ResponseEntity<>(allZoos,
//                                    HttpStatus.OK);
        return new ResponseEntity<>(zooService.findAllZoos(),
                HttpStatus.OK);

    }

    /**
     * Returns a single user based off a user id number

     */
    @GetMapping(value = "/zoo/{id}",
            produces = "application/json")
    public ResponseEntity<?> findZooById(
            @PathVariable
                    long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z,
                                    HttpStatus.OK);
    }



}