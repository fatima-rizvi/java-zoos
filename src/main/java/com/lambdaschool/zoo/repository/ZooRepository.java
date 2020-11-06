package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD repository connecting User to the rest of the application
 */
public interface ZooRepository
        extends CrudRepository<Zoo, Long>
{

}
