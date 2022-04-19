package com.kreitek.pets.domain;

public class Cat {

    private final String ownerName;
    private final String telephone;
    private final String petName;

    public Cat(String ownerName, String telephone, String petName) {

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

        return "CAT{" +

                ", ownerName='" + ownerName + '\'' +

                ", telephone='" + telephone + '\'' +

                "petName='" + petName + '\'' +

                '}';
    }
}
