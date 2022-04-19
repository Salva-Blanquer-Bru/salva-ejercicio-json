package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.Logger;
import com.kreitek.pets.PetApp;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class DogController implements Controller {

    // TODO Logger declaration
    Logger logger = Logger.getInstance();
    public String executePut(String ownerName, String telephone, String petName) {

        logger.debug("DogController.executePut " + ownerName + "," + telephone + "," + petName);

        Dog dog = new Dog(ownerName, telephone, petName);

        DbService dbService = DbService.getInstance();

        dbService.addNewDog(dog);

        return "The dog has been added correctly";
    }

    @Override
    public String executeGet() {

         logger.debug("DogController.executeGet DOGS");

        DbService dbService = DbService.getInstance();

        List<Dog> dogs = dbService.getDogs();

        String response = "";

        for (Dog dog:dogs) {

            response += dog.toString() + "\r\n";
        }
        return response;
    }
}
