package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreEquipo;
    private String logoEquipo;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listajugadores")
    private List<Usuario> listaJugadores;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getLogoEquipo() {
        return logoEquipo;
    }

    public void setLogoEquipo(String logoEquipo) {
        this.logoEquipo = logoEquipo;
    }

    public List<Usuario> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Usuario> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
