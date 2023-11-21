/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directorio.modelo;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class Personas {
    
    private LocalDate birthDate;
    private String identification;
    private String name;
    private String lastname;
    private String adressOne;
    private String adressTwo;
    private String personType;
    private String contactNumberOne;
    private String typeContactNumberOne;
    private String contactNumberTwo;
    private String typeContactNumberTwo;

    public Personas() {
    }
    
    public Personas(LocalDate birthDate, String identification, String name, String lastname, String adressOne, String adressTwo, String personType, String contactNumberOne, String typeContactNumberOne, String contactNumberTwo, String typeContactNumberTwo) {
        this.birthDate = birthDate;
        this.identification = identification;
        this.name = name;
        this.lastname = lastname;
        this.adressOne = adressOne;
        this.adressTwo = adressTwo;
        this.personType = personType;
        this.contactNumberOne = contactNumberOne;
        this.typeContactNumberOne = typeContactNumberOne;
        this.contactNumberTwo = contactNumberTwo;
        this.typeContactNumberTwo = typeContactNumberTwo;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAdressOne() {
        return adressOne;
    }

    public String getAdressTwo() {
        return adressTwo;
    }

    public String getPersonType() {
        return personType;
    }

    public String getContactNumberOne() {
        return contactNumberOne;
    }

    public String getTypeContactNumberOne() {
        return typeContactNumberOne;
    }

    public String getContactNumberTwo() {
        return contactNumberTwo;
    }

    public String getTypeContactNumberTwo() {
        return typeContactNumberTwo;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAdressOne(String adressOne) {
        this.adressOne = adressOne;
    }

    public void setAdressTwo(String adressTwo) {
        this.adressTwo = adressTwo;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setContactNumberOne(String contactNumberOne) {
        this.contactNumberOne = contactNumberOne;
    }

    public void setTypeContactNumberOne(String typeContactNumberOne) {
        this.typeContactNumberOne = typeContactNumberOne;
    }

    public void setContactNumberTwo(String contactNumberTwo) {
        this.contactNumberTwo = contactNumberTwo;
    }

    public void setTypeContactNumberTwo(String typeContactNumberTwo) {
        this.typeContactNumberTwo = typeContactNumberTwo;
    }

    
}
