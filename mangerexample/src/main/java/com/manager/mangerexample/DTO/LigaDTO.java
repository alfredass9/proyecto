package com.manager.mangerexample.DTO;

import javax.validation.constraints.NotBlank;

public class LigaDTO {
    @NotBlank
    private String nombreLiga;
    @NotBlank
    private String logo;
    @NotBlank
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;

    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

}
