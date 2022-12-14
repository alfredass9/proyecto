package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Liga implements Serializable {

    private static final long serialVersionUID = -713591734105301111L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombreLiga;
    @Column(nullable = false)
    private String Direccion;
    @Column(nullable = false)
    private int codPostal;
    @Column(nullable = false)
    private Date inicio;
    @Column(nullable = false)
    private Date fin;
    @Column(nullable = false)
    private int jornadas;
    @Column(nullable = false)
    private int maxEquipos;
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "id")
    private List<Equipo> ListaEquipos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaJornadas-id")
    private  List<Jornada> ListaJornadas;

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


    public List<Jornada> getListaJornadas() {
        return ListaJornadas;
    }

    public void setListaJornadas(List<Jornada> listaJornadas) {
        ListaJornadas = listaJornadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxEquipos() {
        return maxEquipos;
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
                ", maxEquipos=" + maxEquipos +
                ", ListaEquipos=" + ListaEquipos +
                ", ListaJornadas=" + ListaJornadas +
                '}';
    }

    public void setMaxEquipos(int maxEquipos) {
        this.maxEquipos = maxEquipos;
    }
}

