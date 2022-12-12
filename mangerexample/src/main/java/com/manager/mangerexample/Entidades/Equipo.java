package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreEquipo;
    private String logoEquipo;
    private int puntos;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listajugadores")
    private List<Usuario> listaJugadores;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquiposLiga-id")
    private Liga miLiga;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquiposTorneo-id")
    private Torneo miTorneo;
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

    public Liga getMiLiga() {
        return miLiga;
    }

    public void setMiLiga(Liga miLiga) {
        this.miLiga = miLiga;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", logoEquipo='" + logoEquipo + '\'' +
                ", puntos=" + puntos +
                ", listaJugadores=" + listaJugadores +
                ", miLiga=" + miLiga +
                '}';
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
