package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date diaPartido;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquipo_id")
    private List<Equipo> equipoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
