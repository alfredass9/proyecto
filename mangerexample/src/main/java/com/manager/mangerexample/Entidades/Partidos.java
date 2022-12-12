package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date diaPartido;
    private Arrays resultado[];

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquipo_id")
    private List<Equipo> equipoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDiaPartido() {
        return diaPartido;
    }

    public void setDiaPartido(Date diaPartido) {
        this.diaPartido = diaPartido;
    }


    public Arrays[] getResultado() {
        return resultado;
    }

    public void setResultado(Arrays[] resultado) {
        this.resultado = resultado;
    }

    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }
}
