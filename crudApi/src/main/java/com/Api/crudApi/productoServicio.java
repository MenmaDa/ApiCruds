package com.Api.crudApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class productoServicio {

    HashMap<String, Object> datos;

    private final productoRepositorio productoRepositorio;
    @Autowired
    private productoServicio(productoRepositorio productoRepositorio){
        this.productoRepositorio= productoRepositorio;
    }

    public List<Producto> getProductos(){
        return this.productoRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoProducto(Producto producto){
        Optional<Producto> res = productoRepositorio.findProductoByNombre(producto.getNombre());
        datos = new HashMap<>();

        if (res.isPresent() && producto.getId()==null){
            datos.put("Error",true);
            datos.put("message","Ya existe este producto con este nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message","se guardó con exito");
        if (producto.getId()!=null){
            datos.put("message","se actualizo con exito");
        }
        productoRepositorio.save(producto);
        datos.put("data",producto);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    public ResponseEntity<Object> borrarProducto(Integer idProducto){
        datos = new HashMap<>();
        boolean existe = this.productoRepositorio.existsById(idProducto);
        if (!existe){
            datos.put("Error",true);
            datos.put("message","No existe este producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productoRepositorio.deleteById(idProducto);
        datos.put("message","producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
