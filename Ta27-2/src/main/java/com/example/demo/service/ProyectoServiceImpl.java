package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService {

    @Autowired
    private IProyectoDAO proyectoDAO;

    @Override
    public List<Proyecto> getAllProyectos() {
        return proyectoDAO.findAll();
    }

    @Override
    public Proyecto getProyectoById(int id) {
        Optional<Proyecto> proyecto = proyectoDAO.findById(id);
        return proyecto.orElse(null);
    }

    @Override
    public Proyecto addProyecto(Proyecto proyecto) {
        return proyectoDAO.save(proyecto);
    }

    @Override
    public Proyecto updateProyecto(int id, Proyecto proyectoDetails) {

        Proyecto proyecto = getProyectoById(id);
    	proyecto.setNombre(proyectoDetails.getNombre());
        return proyectoDAO.saveAndFlush(proyecto);

    }

    @Override
    public boolean deleteProyecto(int id) {
        Proyecto proyecto = getProyectoById(id);

        if (proyecto != null) {
        	proyectoDAO.delete(proyecto);
            return true;
        }

        return false;
    }
}