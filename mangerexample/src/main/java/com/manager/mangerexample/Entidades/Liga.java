package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Liga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreLiga;
    private String Direccion;
    private int codPostal;
    private Date inicio;
    private Date fin;
    private int jornadas;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ListaEquipos-id")
    private List<Equipo> ListaEquipos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaPartidos-id")
    private  List<Partidos> ListaPartidos;

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
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

    public int getJornadas() {
        return jornadas;
    }

    public void setJornadas(int jornadas) {
        this.jornadas = jornadas;
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

    @Override
    public String toString() {
        return "Liga{" +
                "id=" + id +
                ", nombreLiga='" + nombreLiga + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", codPostal=" + codPostal +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", jornadas=" + jornadas +
                ", ListaEquipos=" + ListaEquipos +
                ", ListaPartidos=" + ListaPartidos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
