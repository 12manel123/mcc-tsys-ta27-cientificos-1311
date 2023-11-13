package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;

public interface ICientificoService {
    Cientifico getCientificoById(int id);
    List<Cientifico> getAllCientificos();
    Cientifico createCientifico (Cientifico cientifico);
    Cientifico updateCientifico (int id, Cientifico cientifico);
    Boolean deleteCientifico(int id);
	List<Proyecto> getAllProyectosByCientificosId(Long id);
}