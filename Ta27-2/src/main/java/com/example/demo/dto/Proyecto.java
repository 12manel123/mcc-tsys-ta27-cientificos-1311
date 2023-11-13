package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "cientifico_proyecto",
        joinColumns = @JoinColumn(name = "proyecto_id"),
        inverseJoinColumns = @JoinColumn(name = "cientifico_id")
    )
    private List<Cientifico> cientificos;

    
    
	public Proyecto(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Proyecto(int id, String nombre, List<Cientifico> cientificos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cientificos = cientificos;
	}
	
	public Proyecto() {}
    
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

    public List<Cientifico> getCientificos() {
        return cientificos;
    }

    public void setCientificos(List<Cientifico> cientificos) {
        this.cientificos = cientificos;
    }

	

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + "]";
	}
    
    
    
}