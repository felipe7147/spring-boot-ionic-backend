package com.felipealmeida.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipealmeida.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer> {

}
