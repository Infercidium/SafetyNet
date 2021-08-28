package com.infercidium.safetynet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Allergies {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "The allergie cannot be null or empty.")
    @Column(unique = true)
    private String allergy;

    public Allergies() { }

    public Allergies(final String allergyC) {
        this.allergy = allergyC;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long idS) {
        this.id = idS;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(final String allergyS) {
        this.allergy = allergyS;
    }

    @Override
    public String toString() {
        return "Allergies{"
                + " id = " + id
                + "allergy = '" + allergy + '\''
                + '}';
    }
}

