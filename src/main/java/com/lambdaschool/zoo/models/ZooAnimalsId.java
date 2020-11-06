package com.lambdaschool.zoo.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class to represent the complex primary key for UserRoles
 */
@Embeddable
public class ZooAnimalsId
        implements Serializable
{
    /**
     * The id of the user
     */
    private long zoo;

    /**
     * The id of the role
     */
    private long animal;

    /**
     * The default constructor required by JPA
     */
    public ZooAnimalsId()
    {
    }

    /**
     * Getter for the user id
     *
     * @return long the user id
     */
    public long getZoo()
    {
        return zoo;
    }

    /**
     * Setter for the user id
     * //@param user the new user id for this object
     */
    public void setZoo(long zoo)
    {
        this.zoo = zoo;
    }

    /**
     * Getter for the role id
     *
     * @return long the role id
     */
    public long getAnimal()
    {
        return animal;
    }

    /**
     * The setter for the role id
     *
     * //@param role the new role id for this object
     */
    public void setAnimal(long animal)
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
        ZooAnimalsId that = (ZooAnimalsId) o;
        return zoo == that.zoo &&
                animal == that.animal;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
