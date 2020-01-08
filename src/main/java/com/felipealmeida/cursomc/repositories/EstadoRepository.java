package com.felipealmeida.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipealmeida.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado,Integer> {

}
