package com.vet.vetgroup.dtos.creation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PatientCreationDto {

    @NotNull
    private String owner;
    @NotNull
    private String name;
    @NotNull
    @Max(11)
    private String ownerContact;
    @NotNull
    private String breed;
    @NotNull
    private Date birthDate;
    private String avatarUrl;
    @NotNull
    private String kind;
    @NotNull
    private String sex;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public void setOwnerContact(String ownerContact) {
        this.ownerContact = ownerContact;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
