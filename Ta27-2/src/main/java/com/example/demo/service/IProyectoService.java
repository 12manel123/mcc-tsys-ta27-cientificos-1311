package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {
    Proyecto getProyectoById(int id);
    List<Proyecto> getAllProyectos();
    Proyecto addProyecto(Proyecto proyecto);
    Proyecto updateProyecto(int id,Proyecto proyecto);
    boolean deleteProyecto(int id);
}
