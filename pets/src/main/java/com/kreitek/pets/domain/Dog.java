package com.kreitek.pets.domain;

public class Dog {

    private final String ownerName;
    private final String telephone;
    private final String petName;

    public Dog(String ownerName, String telephone, String petName) {

        this.ownerName = ownerName;

        this.telephone = telephone;

        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPetName() {
        return petName;
    }

    @Override
    public String toString() {

        return "DOG{" +

                ", ownerName='" + ownerName + '\'' +

                ", telephone='" + telephone + '\'' +

                "petName='" + petName + '\'' +

                '}';
    }
}
