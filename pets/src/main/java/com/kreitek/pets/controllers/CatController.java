package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.Logger;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class CatController implements Controller {
    Logger logger = Logger.getInstance();
    @Override
    public String executePut(String ownerName, String telephone, String petName) {

        logger.debug("CatController.executePut" + ownerName + "," + telephone + "," + petName);

        Cat cat = new Cat(ownerName, telephone, petName);

        DbService dbService = DbService.getInstance();

        dbService.addNewCat(cat);

        return "The cat has been added correctly";
    }
    @Override
    public String executeGet() {

        logger.debug("CatController.executeGet CATS");

        DbService dbService = DbService.getInstance();

        List<Cat> cats = dbService.getCats();

        String response = "";

        for (Cat cat:cats) {

            response += cat.toString() + "\r\n";
        }

        return response;
    }
}
