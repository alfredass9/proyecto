package com.manager.mangerexample.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class Equipo implements Serializable {
    @Serial
    private static final long serialVersionUID = -6146328753404273703L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false,updatable = false)
    private Long id;
    private String nombreEquipo;

    private String logoEquipo;
    @Column( nullable = false,updatable = true)
    private int misPuntos;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="lista_equipos_jugadores",joinColumns = @JoinColumn(name = "equipo_id")
            ,inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Usuario> listaJugadores=new HashSet<>();

    public Equipo() {
    }


    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", logoEquipo='" + logoEquipo + '\'' +
                ", misPuntos=" + misPuntos +
                ", listaJugadores=" + listaJugadores +
                '}';
    }

    public Equipo(String nombreEquipo, String logoEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.logoEquipo = logoEquipo;
    }

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

    public Set<Usuario> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(Set<Usuario> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public int getMisPuntos() {
        return misPuntos;
    }

    public void setMisPuntos(int misPuntos) {
        this.misPuntos = misPuntos;
    }

}
