package com.manager.mangerexample.Entidades;

import com.manager.mangerexample.Enums.RolNombre;
import com.sun.istack.NotNull;
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
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id-permisos")
    private List<Permisos> ListaPermisos;


    public Roles() {
    }

    public Roles(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", rolNombre=" + rolNombre +
                ", ListaPermisos=" + ListaPermisos +
                '}';
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
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


}
