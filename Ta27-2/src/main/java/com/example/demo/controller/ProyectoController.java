package com.example.demo.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.IProyectoService;


@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable("id") Integer id) {
        Proyecto proyecto = proyectoService.getProyectoById(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Proyecto> createProyecto(@RequestBody Proyecto proyecto) {
    System.out.println("Nombre before setting: " + proyecto.getNombre());
    Proyecto createdProyecto = proyectoService.addProyecto(proyecto);
    System.out.println("Nombre after setting: " + createdProyecto.getNombre());
    return ResponseEntity.created(URI.create("/proyectos/" + createdProyecto.getId())).body(createdProyecto);
    }

    @PutMapping("/{id}")
    public Proyecto updateProyecto(@PathVariable int id, @RequestBody Proyecto proyecto) {
    System.out.println("IDTest: " + proyecto.getId());
    System.out.println("NameTest: " + proyecto.getNombre());
    return proyectoService.updateProyecto(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable("id") Integer id) {
        boolean deleted = proyectoService.deleteProyecto(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}