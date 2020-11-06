package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

/**
 * The entity allowing interaction with the useremails table
 * <p>
 * requires each combination of zoo and telephone to be unique. The same email cannot be assigned to the same user more than once.
 */
@Entity
@Table(name = "telephones")
public class Telephone
        extends Auditable
{
    /**
     * The primary key (long) of the telephones table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    /**
     * Email (String) for this user. Cannot be nullable.
     * Must be in the format userid@domain.upperLevelDomain
     */
    @Column(nullable = false)
    @Email
    private String phonetype;

    @Column(nullable = false)
    private String phonenumber;



    /**
     * The zoo of the user assigned to this telephone is what is stored in the database.
     * This is the entire user object!
     * <p>
     * Forms a Many to One relationship between telephones and zoos.
     * A zoo can have many telephone numbers.
     */
    @ManyToOne
    @JoinColumn(name = "zooid",
            nullable = false)
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoo zoo;

    /**
     * The default controller is required by JPA
     */
    public Telephone()
    {
    }

    /**
     * Given the parameters, create a new useremail object
     *
//     * @param zoo      the user (User) assigned to the email
//     * @param useremail useremail (String) for the given user
     */

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
