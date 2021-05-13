package com.p5.adoptions.api.controllers;

import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/dogs")
public class DogController
{
    private final DogService dogService;

    public DogController(DogService dogService)
    {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs()
    {
        List<Dog> dogList = dogService.findAll();
        return ResponseEntity.ok(dogList);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog)
    {
        dogService.addDog(dog);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dog> getDogByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(dogService.findDog(name));
    }
}
