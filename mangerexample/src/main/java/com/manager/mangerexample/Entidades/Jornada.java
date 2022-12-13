package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Jornada implements Serializable {
    private static final long serialVersionUID = -3839039434114450150L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date dia;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Partidos> misPartidos;

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public List<Partidos> getMisPartidos() {
        return misPartidos;
    }

    public void setMisPartidos(List<Partidos> misPartidos) {
        this.misPartidos = misPartidos;
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "id=" + id +
                ", dia=" + dia +
                ", misPartidos=" + misPartidos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
