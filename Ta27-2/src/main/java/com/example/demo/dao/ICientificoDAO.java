package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, Integer>  {

}
