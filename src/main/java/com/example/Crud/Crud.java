package com.example.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Crud {

    @Autowired
    List<Persona> personas;

    //POST
    //Añade personas a la lista
    /*localhost:8080/persona
    {
        "id": "2",
            "nombre": "Carlos",
            "edad" : "34",
            "poblacion": "Rivas"
    }
    */
    @PostMapping("/persona")
    public String addPersona(@RequestBody Persona persona){
        personas.add(persona);
        return persona + "añadida";
    }

    //PUT
    //Modifica personas de la lista con su id para buscarla antes de modificar
    /*localhost:8080/persona
    {
        "id": "2",
            "nombre": "Carlos Manuel",
            "edad" : "30",
            "poblacion": "RivasVaciamadrid"
    }
     */
    @PutMapping("/persona/{id}")
    public String editPerson(@PathVariable int id, @RequestBody Persona persona) {
        for (Persona personasEnList : personas) {
            System.out.println(personasEnList.getNombre());

            if (personasEnList.getId()== id){

                if (persona.getNombre() != null){
                    personasEnList.setNombre(persona.getNombre());
                }

                if (persona.getEdad() != null){
                    personasEnList.setEdad(persona.getEdad());
                }
                if (persona.getPoblacion() != null){
                    personasEnList.setPoblacion(persona.getPoblacion());
                }

                return "Lista actualizada" + personas;
            }
        }
        return "Persona = " + persona.getNombre() + " no encontrada";
    }

    //GET
    //Busca personas por id
    //localhost:8080/persona/1
    @GetMapping("/persona/{id}")
    public String getPerson(@PathVariable int id){

        for (Persona persona : personas) {

            if (persona.getId() == id ) {
                return  persona.toString();
            }
        }
        return null;
    }

    //GET
    //Busca personas por nombre
    //localhost:8080/nombre/Manuel
    @GetMapping("/persona/nombre/{nombre}")
    public String getPerson(@PathVariable String nombre){

        for (Persona persona : personas) {

            if (persona.getNombre().equals(nombre)){
                return  persona.toString();
            }
        }
        return null;
    }

    //DELETE
    //Borra personas por id
    //localhost:8080/persona/1
    @DeleteMapping("/persona/{id}")
    public String borrarPersona (@PathVariable int id){

        for (Persona persona : personas) {

            if (persona.getId() == id ) {
                personas.remove(persona);
                return  "Lista actualizada" + personas;
            }
        }
        return null;
    }




}
