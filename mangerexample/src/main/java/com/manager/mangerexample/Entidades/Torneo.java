package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private int capacidad;
    private String Direccion;
    private Date inicio;
    private Date fin;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ListaEquipos-id")
    private List<Equipo> ListaEquipos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaPartidos-id")
    private  List<Partidos> ListaPartidos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
