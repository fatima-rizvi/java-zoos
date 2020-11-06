package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.models.Telephone;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Useremail to the rest of the application
 */
public interface TelephoneRepository
        extends CrudRepository<Telephone, Long>
{
}
