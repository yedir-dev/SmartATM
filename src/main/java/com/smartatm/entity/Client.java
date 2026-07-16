package com.smartatm.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nom;


    private String prenom;


    private String telephone;



    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Account> accounts;



    // Constructeur JPA
    public Client() {

    }



    public Client(
            String nom,
            String prenom,
            String telephone
    ){

        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;

    }



    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getNom() {

        return nom;

    }



    public void setNom(String nom) {

        this.nom = nom;

    }



    public String getPrenom() {

        return prenom;

    }



    public void setPrenom(String prenom) {

        this.prenom = prenom;

    }



    public String getTelephone() {

        return telephone;

    }



    public void setTelephone(String telephone) {

        this.telephone = telephone;

    }



    public List<Account> getAccounts() {

        return accounts;

    }



    public void setAccounts(List<Account> accounts) {

        this.accounts = accounts;

    }



    @Override
    public String toString() {

        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';

    }

}