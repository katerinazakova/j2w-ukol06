package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
   private String psc;
   private String email;
   private String telefon;
   private String web;


   public String getCelaAdresa() {
      return ulice + psc + obec;
   }
}
