package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The entity allowing interaction with the userroles table.
 * The join table between users and roles.
 * <p>
 * Table enforces a unique constraint of the combination of userid and roleid.
 * These two together form the primary key.
 * <p>
 * When you have a compound primary key, you must implement Serializable for Hibernate
 * When you implement Serializable you must implement equals and hash code
 */
@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals
        extends Auditable
        implements Serializable
{
    /**
     * 1/2 of the primary key (long) for userroles.
     * Also is a foreign key into the users table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Zoo zoo;

    /**
     * 1/2 of the primary key (long) for userroles.
     * Also is a foreign key into the roles table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Animal animal;

    /**
     * Default constructor used primarily by the JPA.
     */
    public ZooAnimals()
    {
    }

    /**
     * Given the params, create a new user role combination object
     *
//     * @param user The user object of this relationship
//     * @param role The role object of this relationship
     */
    public ZooAnimals(
            Zoo zoo,
            Animal animal)
    {
        this.zoo = zoo;
        this.animal = animal;
    }

    /**
     * The getter for User
     *
     * @return the complete user object associated with user role combination
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    /**
     * Setter for user
     *
     * //@param user change the user object associated with this user role combination to this one.
     */
    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    /**
     * Getter for role
     *
     * @return the complete role object associated with this user role combination
     */
    public Animal getAnimal()
    {
        return animal;
    }

    /**
     * Setter for role
     *
     * //@param role change role object associated with this user role combination to this one.
     */
    public void setRole(Animal animal)
    {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ZooAnimals that = (ZooAnimals) o;
        return ((this.zoo == null) ? 0 : this.zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ((this.animal == null) ? 0 : this.animal.getAnimalid()) == ((that.animal == null) ? 0 : that.animal.getAnimalid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
