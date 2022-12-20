package com.manager.mangerexample.DTO;

import javax.validation.constraints.NotBlank;

public class EquipoDTO {
    @NotBlank
private String nombreEquipo;
    @NotBlank
    private String logo;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
