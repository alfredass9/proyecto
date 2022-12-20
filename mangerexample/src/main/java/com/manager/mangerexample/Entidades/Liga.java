package com.manager.mangerexample.Entidades;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Liga implements Serializable {

    private static final long serialVersionUID = -713591734105301111L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombreLiga;
    @Column(nullable = false)
    private String Direccion;
    private String logo;

    @OneToMany(orphanRemoval = true)
    @Size(max=8)
    @JoinTable(name="equipos_porLiga",joinColumns = @JoinColumn(name = "liga_id")
            ,inverseJoinColumns = @JoinColumn(name = "equipo_id"))
    private List<Equipo> listaEquipos = new java.util.ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="jornada_porLiga",joinColumns = @JoinColumn(name = "liga_id")
            ,inverseJoinColumns = @JoinColumn(name = "jornada_id"))
    private  List<Jornada> listaJornadas;

    public Liga() {
    }

    public Liga(String nombreLiga, String direccion, String logo) {
        this.nombreLiga = nombreLiga;
        Direccion = direccion;
        this.logo = logo;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public List<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(List<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "id=" + id +
                ", nombreLiga='" + nombreLiga + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", logo='" + logo + '\'' +
                ", listaEquipos=" + listaEquipos +
                ", listaJornadas=" + listaJornadas +
                '}';
    }
}

