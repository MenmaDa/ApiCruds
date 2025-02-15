package com.Api.crudApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface productoRepositorio extends JpaRepository <Producto, Integer>{

    Optional<Producto> findProductoByNombre(String nombre);
}
