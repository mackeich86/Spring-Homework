package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel INSTANCE = new PetModel();

    private final Map<Integer, Pet> model;


    private PetModel() {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance() {
        return INSTANCE;
    }

    public void add(Pet pet, int id) {
        model.put(id, pet);
    }

    public Pet getFromList(int id) {
        return model.get(id);
    }

    public void deletePet(int id) {
        model.remove(id);
    }

    public Map<Integer, Pet> getAll() {
        return model;
    }
}
