package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The entity allowing interaction with the zoos table
 */
@Entity
@Table(name = "zoos")
public class Zoo
        extends Auditable {
    /**
     * The primary key (long) of the zoos table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    /**
     * The zoo name (String). Cannot be null and must be unique
     */
    @Column(nullable = false,
            unique = true)
    private String zooname;


    /**
     * Part of the join relationship between zoos and telephones
     * connects users to the zoo telephone combination
     */

    @OneToMany(mappedBy = "zoo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> telephones = new ArrayList<>();

    /**
     * Part of the join relationship between zoos and animals
     * connects users to the zoo animal combination
     */
    @OneToMany(mappedBy = "zoo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    /**
     * Default constructor used primarily by the JPA.
     */
    public Zoo()
    {
    }

    public Zoo(long zooid, String zooname, List<Telephone> telephones, Set<ZooAnimals> animals) {
        this.zooid = zooid;
        this.zooname = zooname;
        this.telephones = telephones;
        this.animals = animals;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<ZooAnimals> animals) {
        this.animals = animals;
    }
}
