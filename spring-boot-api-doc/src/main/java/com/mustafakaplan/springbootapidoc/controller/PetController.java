package com.mustafakaplan.springbootapidoc.controller;

import com.mustafakaplan.springbootapidoc.entity.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@Api(value = "My Pet API Documentation")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 5; i++) {
            petList.add(new Pet(i, "name " + i, new Date()));
        }
    }

    @PostMapping
    @ApiOperation(value = "Save a new pet method", notes = "Use this method carefully!")
    public ResponseEntity<Pet> savePet(@RequestBody @ApiParam(value = "Animal") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Get all pets method", notes = "This method returns all")
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petList);
    }
}
