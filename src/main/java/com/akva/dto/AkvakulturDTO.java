package com.akva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AkvakulturDTO {

    private String id;
    private Long versionId;
    private String openNr;
    private String typeName;
    private String typeValue;
    private String name;
    private List<BusinessTypeDTO> businessTypes;
    private String officialSourceType;
    private List<AddressDTO> addresses;
    private String versionValidFrom;
    private String versionValidUntil;
    private String versionRegisteredTime;
    private String versionRegisteredBy;
    private String status;

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

    public List<BusinessTypeDTO> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessTypeDTO> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getOfficialSourceType() {
        return officialSourceType;
    }

    public void setOfficialSourceType(String officialSourceType) {
        this.officialSourceType = officialSourceType;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BusinessTypeDTO {
        private String value;
        private String name;

        // Getters and setters

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressDTO {
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
