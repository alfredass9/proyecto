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
    private int codPostal;
    private Date inicio;
    private Date fin;
    @OneToMany(fetch=FetchType.LAZY)
    private List<Equipo> ListaEquipos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaPartidos-id")
    private  List<Partidos> ListaPartidos;

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", Direccion='" + Direccion + '\'' +
                ", codPostal=" + codPostal +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", ListaEquipos=" + ListaEquipos +
                ", ListaPartidos=" + ListaPartidos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public List<Equipo> getListaEquipos() {
        return ListaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        ListaEquipos = listaEquipos;
    }

    public List<Partidos> getListaPartidos() {
        return ListaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartidos) {
        ListaPartidos = listaPartidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
