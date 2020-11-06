package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.Views.AnimalCount;
import com.lambdaschool.zoo.models.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * The CRUD Repository connecting Role to the rest of the application
 */
public interface AnimalRepository
        extends CrudRepository<Animal, Long>
{

    @Query(value = "SELECT a.animaltype, a.animalid, count(z.zooid) as countzoos" +
                    "FROM animals a RIGHT JOIN zooanimals zooanimals a" +
                    "ON a.animalid = z.animalid" +
                    "GROUP BY a.animaltype" +
                    "ORDER BY a.animaltype", nativeQuery = true)
    ArrayList<AnimalCount> animalCount();
}
