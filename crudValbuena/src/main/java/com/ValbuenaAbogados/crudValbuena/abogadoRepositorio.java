package com.ValbuenaAbogados.crudValbuena;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface abogadoRepositorio extends JpaRepository<Abogado, Integer> {

}
