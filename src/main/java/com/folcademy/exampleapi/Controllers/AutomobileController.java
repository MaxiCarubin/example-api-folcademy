package com.folcademy.exampleapi.Controllers;

import com.folcademy.exampleapi.Models.Dtos.AutomobileAddDTO;
import com.folcademy.exampleapi.Models.Dtos.AutomobileEditDTO;
import com.folcademy.exampleapi.Models.Dtos.AutomobileReadDTO;
import com.folcademy.exampleapi.Services.AutomobileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automobiles")
public class AutomobileController {
    private final AutomobileService automobileService;

    public AutomobileController(AutomobileService automobileService) {
        this.automobileService = automobileService;
    }

    @GetMapping
    public ResponseEntity<List<AutomobileReadDTO>> findAll(
    ){
        return ResponseEntity.ok(automobileService.findAll());
    }
    @PostMapping
    public ResponseEntity<AutomobileReadDTO> add(@RequestBody AutomobileAddDTO automobileAddDTO){
        return ResponseEntity.ok(automobileService.add(automobileAddDTO));
    }
    @GetMapping("/{automobileId}")
    public ResponseEntity<AutomobileReadDTO> findById(@PathVariable Integer automobileId){
        return ResponseEntity.ok(automobileService.findById(automobileId));
    }
    @PutMapping("/{automobileId}")
    public ResponseEntity<AutomobileReadDTO> edit(
            @PathVariable Integer automobileId,
            @RequestBody AutomobileEditDTO automobile){
        return ResponseEntity.ok(automobileService.edit(automobileId, automobile));
    }
    @DeleteMapping("/{automobileId}")
    public ResponseEntity<AutomobileReadDTO> deleteById(@PathVariable Integer automobileId){
        return ResponseEntity.ok(automobileService.deleteById(automobileId));
    }
}
