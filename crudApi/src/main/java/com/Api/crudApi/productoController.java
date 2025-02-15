package com.Api.crudApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/productos")
public class productoController {

    private final  productoServicio productoServicio;

    @Autowired
    public productoController(productoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping
    public List<Producto> getProductos(){
        return this.productoServicio.getProductos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto){
        return this.productoServicio.nuevoProducto(producto);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto){
        return this.productoServicio.nuevoProducto(producto);
    }

    @DeleteMapping(path = "{productoId}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable("productoId") Integer id){
        return this.productoServicio.borrarProducto(id);
    }

}
