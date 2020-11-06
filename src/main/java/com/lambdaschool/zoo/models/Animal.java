package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the animals table.
 */
@Entity
@Table(name = "animals")
public class Animal
        extends Auditable
{
    /**
     * The primary key (long) of the animals table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    /**
     * The name (String) of the animal. Cannot be null and must be unique.
     */
    @Column(nullable = false,
            unique = true)
    private String animaltype;


    /**
     * Part of the join relationship between zoos and animals
     * connects animals to the zoo animal combination
     */
    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "animal", allowSetters = true)
    private Set<ZooAnimals> zoos = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Animal()
    {
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<ZooAnimals> getZoos() {
        return zoos;
    }

    public void setZoos(Set<ZooAnimals> zoos) {
        this.zoos = zoos;
    }
}
