package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Cientifico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DNI")
    private int id;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "cientificos")
    @JsonIgnoreProperties("cientificos")
    private List<Proyecto> proyectos;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

	@Override
	public String toString() {
		return "Cientifico [id=" + id + ", nombre=" + nombre + "]";
	}

	public Cientifico() {
		super();
	}

	public Cientifico(int id, String nombre, List<Proyecto> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyectos = proyectos;
	}
	
    
}