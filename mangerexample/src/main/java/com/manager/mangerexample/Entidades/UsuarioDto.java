package com.manager.mangerexample.Entidades;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Usuario} entity
 */
@Data
public class UsuarioDto implements Serializable {
    private final String name;
    private final String posicion;
    private final String email;
    private final String imageUrl;
}