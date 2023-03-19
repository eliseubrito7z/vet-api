package com.vet.vetgroup.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cities")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    public String nameAndUF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAndUF() {
        return nameAndUF;
    }

    public void setNameAndUF(String nameAndUF) {
        this.nameAndUF = nameAndUF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!Objects.equals(id, city.id)) return false;
        return Objects.equals(nameAndUF, city.nameAndUF);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameAndUF != null ? nameAndUF.hashCode() : 0);
        return result;
    }
}
