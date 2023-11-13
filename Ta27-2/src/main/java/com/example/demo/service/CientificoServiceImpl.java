package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;

@Service
public class CientificoServiceImpl implements ICientificoService {

    @Autowired
    private ICientificoDAO cientificoDAO;

    @Override
    public List<Cientifico> getAllCientificos() {
        return cientificoDAO.findAll();
    }

    @Override
    public Cientifico getCientificoById(int id) {
        Optional<Cientifico> cientifico = cientificoDAO.findById(id);
        return cientifico.orElse(null);
    }

    @Override
    public Cientifico createCientifico(Cientifico cientifico) {
        return cientificoDAO.save(cientifico);
    }

    @Override
    public Cientifico updateCientifico(int id, Cientifico cientificoDetails) {
        Cientifico cientifico = getCientificoById(id);
        if (cientifico != null) {
            cientifico.setNombre(cientificoDetails.getNombre());
            cientifico.setProyectos(cientificoDetails.getProyectos());

            return cientificoDAO.save(cientifico);
        }
		return cientifico;
    }

    @Override
    public Boolean deleteCientifico(int id) {
        Cientifico cientifico = getCientificoById(id);

        if (cientifico != null) {
        	cientificoDAO.delete(cientifico);
            return true;
        }

        return false;
    }

	@Override
	public List<Proyecto> getAllProyectosByCientificosId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}