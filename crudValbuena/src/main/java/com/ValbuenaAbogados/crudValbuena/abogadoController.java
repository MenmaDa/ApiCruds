package com.ValbuenaAbogados.crudValbuena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "valbuenaabogados/v1/abogado")
public class abogadoController {

    private final abogadoServicio abogadoServicio;

    @Autowired
    public abogadoController(abogadoServicio abogadoServicio){
        this.abogadoServicio=abogadoServicio;
    }
    @GetMapping
    public List<Abogado> getAbogado(){
        return this.abogadoServicio.getAbogado();
    }
    @PostMapping
    public ResponseEntity<Object> registrarAbogado(@RequestBody Abogado abogado){
        return this.abogadoServicio.nuevoAbogado(abogado);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarAbogado(@RequestBody Abogado abogado){
        return this.abogadoServicio.nuevoAbogado(abogado);
    }

    @DeleteMapping(path = "{abogadoId}")
    public ResponseEntity<Object> eliminarAbogado(@PathVariable("abogadoId") Integer id){
        return this.abogadoServicio.borrarAbogado(id);
    }
}
