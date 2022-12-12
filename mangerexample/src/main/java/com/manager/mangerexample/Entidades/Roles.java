package com.manager.mangerexample.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "roles")
@Data

public class Roles implements Serializable {


    private static final long serialVersionUID = -3137534668435410885L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id-permisos")
    private List<Permisos> ListaPermisos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Permisos> getListaPermisos() {
        return ListaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        ListaPermisos = listaPermisos;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ListaPermisos=" + ListaPermisos +
                '}';
    }
}
