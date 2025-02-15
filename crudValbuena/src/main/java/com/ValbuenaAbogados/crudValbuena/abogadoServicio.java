package com.ValbuenaAbogados.crudValbuena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class abogadoServicio {
    HashMap<String, Object> datos;
    private final abogadoRepositorio abogadoRepositorio;
    @Autowired
    private abogadoServicio(abogadoRepositorio abogadoRepositorio){
        this.abogadoRepositorio= abogadoRepositorio;
    }

    public List<Abogado> getAbogado(){
        return this.abogadoRepositorio.findAll();
    }

    public ResponseEntity<Object> nuevoAbogado(Abogado abogado){

        datos = new HashMap<>();

        if (abogado.getId()==null){
            datos.put("Error",true);
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message","se guardó con exito");
        if (abogado.getId()!=null){
            datos.put("message","se actualizo con exito");
        }
        abogadoRepositorio.save(abogado);
        datos.put("data",abogado);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    public ResponseEntity<Object> borrarAbogado(Integer idAbogado){
        datos = new HashMap<>();
        boolean existe = this.abogadoRepositorio.existsById(idAbogado);
        if (!existe){
            datos.put("Error",true);
            datos.put("message","No existe este abogado con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        abogadoRepositorio.deleteById(idAbogado);
        datos.put("message","abogado eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
