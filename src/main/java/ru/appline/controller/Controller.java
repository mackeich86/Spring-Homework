package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel model = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "text/html")
    public String createPet(@RequestBody Pet pet) {
        model.add(pet, newId.getAndIncrement());
        return "<html><h3>" + (newId.get() == 2 ? "Добавлен первый питомец." : "Добавлен питомец.") + "</h3></html>";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return model.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return model.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json")
    public void deletePet(@RequestBody Map<String, Integer> id) {
        model.deletePet(id.get("id"));
    }

    @PutMapping(value = "/putPet", consumes = "application/json")
    public void putPet(@RequestBody Map<String, String> requestBody) {
        Pet pet = new Pet(requestBody.get("name"), requestBody.get("type"), Integer.parseInt(requestBody.get("age")));
        model.add(pet, Integer.parseInt(requestBody.get("id")));
    }
}
