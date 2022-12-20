package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @Size(max=1)
    private Equipo homeEquipo;

    @ManyToOne
    @Size(max=1)
    private Equipo awayEquipo;
    @ManyToOne
    @JoinColumn(name = "Partido_jornada_id")
    private Jornada jornadas;

    public Partidos() {
    }

    public Partidos(Equipo homeEquipo, Equipo awayEquipo) {
        this.homeEquipo = homeEquipo;
        this.awayEquipo = awayEquipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Partidos{}";
    }

    public Equipo getHomeEquipo() {
        return homeEquipo;
    }

    public void setHomeEquipo(Equipo homeEquipo) {
        this.homeEquipo = homeEquipo;
    }

    public Equipo getAwayEquipo() {
        return awayEquipo;
    }

    public void setAwayEquipo(Equipo awayEquipo) {
        this.awayEquipo = awayEquipo;
    }

    public Jornada getJornadas() {
        return jornadas;
    }

    public void setJornadas(Jornada jornadas) {
        this.jornadas = jornadas;
    }
}
