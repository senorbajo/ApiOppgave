package com.akva.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Akvakultur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String id;

    @Column(name = "version_id", nullable = false, length = 32)
    private Long versionId;

    @Column(name = "open_nr", nullable = false, length = 32)
    private String openNr;

    @Column(name = "type_name", nullable = false, length = 32)
    private String typeName;

    @Column(name = "type_value", nullable = false, length = 32)
    private String typeValue;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "official_source_type", nullable = false, length = 32)
    private String officialSourceType;

    @Column(name = "version_valid_from", nullable = false, length = 32)
    private String versionValidFrom;

    @Column(name = "version_valid_until", nullable = false, length = 32)
    private String versionValidUntil;

    @Column(name = "version_registered_time", nullable = false, length = 32)
    private String versionRegisteredTime;

    @Column(name = "version_registered_by", nullable = false, length = 32)
    private String versionRegisteredBy;

    @Column(name = "status", nullable = false, length = 32)
    private String status;

    @ElementCollection
    @CollectionTable(name = "business_type", joinColumns = @JoinColumn(name = "akvakultur_id"))
    private List<BusinessType> businessTypes;

    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "akvakultur_id"))
    private List<Address> addresses;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getOpenNr() {
        return openNr;
    }

    public void setOpenNr(String openNr) {
        this.openNr = openNr;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialSourceType() {
        return officialSourceType;
    }

    public void setOfficialSourceType(String officialSourceType) {
        this.officialSourceType = officialSourceType;
    }

    public String getVersionValidFrom() {
        return versionValidFrom;
    }

    public void setVersionValidFrom(String versionValidFrom) {
        this.versionValidFrom = versionValidFrom;
    }

    public String getVersionValidUntil() {
        return versionValidUntil;
    }

    public void setVersionValidUntil(String versionValidUntil) {
        this.versionValidUntil = versionValidUntil;
    }

    public String getVersionRegisteredTime() {
        return versionRegisteredTime;
    }

    public void setVersionRegisteredTime(String versionRegisteredTime) {
        this.versionRegisteredTime = versionRegisteredTime;
    }

    public String getVersionRegisteredBy() {
        return versionRegisteredBy;
    }

    public void setVersionRegisteredBy(String versionRegisteredBy) {
        this.versionRegisteredBy = versionRegisteredBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Embeddable
    public static class BusinessType {
        private String value;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
// Getters and setters
    }

    @Embeddable
    public static class Address {
        private Long id;
        private String type;
        private String value;
        private String zipCode;
        private String zipName;
        private String countyCode;
        private String countyName;
        private String countryCode;
        private String countryName;
        private String officialSourceType;

        // Getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getZipName() {
            return zipName;
        }

        public void setZipName(String zipName) {
            this.zipName = zipName;
        }

        public String getCountyCode() {
            return countyCode;
        }

        public void setCountyCode(String countyCode) {
            this.countyCode = countyCode;
        }

        public String getCountyName() {
            return countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getOfficialSourceType() {
            return officialSourceType;
        }

        public void setOfficialSourceType(String officialSourceType) {
            this.officialSourceType = officialSourceType;
        }
    }
}
