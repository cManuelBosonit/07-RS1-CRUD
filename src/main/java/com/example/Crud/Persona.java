package com.example.Crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Persona {

    int id;
    String nombre;
    Integer edad;
    String poblacion;
}
