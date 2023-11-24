package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String celeJmeno;
    @NotBlank
    private String firma;
    @NotBlank
    private String ulice;
    @NotBlank
    private String obec;
    @NotBlank
    @Pattern(regexp = "\\d{5}")
    private String psc;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefon;
    @NotBlank
    private String web;


    public String getCelaAdresa() {
        return ulice + psc + obec;
    }
}
