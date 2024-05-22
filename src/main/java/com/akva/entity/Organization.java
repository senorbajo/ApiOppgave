package com.akva.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import java.time.LocalDate;


@Entity
public class Organization {

    @Id
    private String orgNumber;
    private String name;
    private LocalDate registrationDate;
    private String businessType;

    // Getters and Setters
    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
