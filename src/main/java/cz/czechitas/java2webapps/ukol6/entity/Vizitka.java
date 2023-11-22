package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String celeJmeno;
   private String firma;
   private String ulice;
   private String obec;
   private String psc;
   private String email;
   private String telefon;
   private String web;


   public String getCelaAdresa() {
      return ulice + psc + obec;
   }
}
