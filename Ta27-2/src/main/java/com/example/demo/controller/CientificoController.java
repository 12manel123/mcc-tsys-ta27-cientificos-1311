package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.ICientificoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cientificos")
public class CientificoController {

    @Autowired
    private ICientificoService cientificosService;
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Cientifico>> getAllCientificos() {
        List<Cientifico> cientificos = cientificosService.getAllCientificos();
        return ResponseEntity.ok(cientificos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cientifico> getCientificosById(@PathVariable int id) {
        Cientifico cientificos = cientificosService.getCientificoById(id);
        return ResponseEntity.ok(cientificos);
    }
    @PostMapping("/add")
    public Cientifico crearCientifico(@RequestBody Cientifico cientifico) {
        return cientificosService.createCientifico(cientifico);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Cientifico> updateCientificos(@PathVariable Integer id, @RequestBody Cientifico cientificos) {
        Cientifico updatedCientificos = cientificosService.updateCientifico(id, cientificos);
        return ResponseEntity.ok(updatedCientificos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCientificos(@PathVariable Integer id) {
        cientificosService.deleteCientifico(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/proyectos")
    public ResponseEntity<List<Proyecto>> getAllProyectosByCientificosId(@PathVariable Long id) {
        List<Proyecto> proyectos = cientificosService.getAllProyectosByCientificosId(id);
        return ResponseEntity.ok(proyectos);
    }
}