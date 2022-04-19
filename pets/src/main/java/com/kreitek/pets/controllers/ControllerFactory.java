package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.PetApp;

public class ControllerFactory{
    public Controller getCatController() {
        return new CatController();
    }
    public Controller getDogController() {
        return new DogController();
    }
}
