package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.ListDTO;
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
    public ResponseEntity<ListDTO<DogDTO>> getAllDogs()
    {
        return ResponseEntity.ok(dogService.findAll());
    }

    @PostMapping
    public void addDog(@RequestBody DogDTO dogDto)
    {
        dogService.addDog(dogDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DogDTO> getDogByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(dogService.findDog(name));
    }
}
