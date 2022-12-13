package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
public class Equipo implements Serializable {
    @Serial
    private static final long serialVersionUID = -6146328753404273703L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreEquipo;
    private String logoEquipo;

    private int misPuntos;
    private int partidosJugados;
    private int partidosGanados;
    private  int partidosPerdidos;
    private int partidosEmpatados;
    private int golesAfavor;
    private int golesEncontra;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
    private List<Usuario> listaJugadores;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquiposLiga-id")
    private Liga miLiga;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaEquiposTorneo-id")
    private Torneo miTorneo;
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getLogoEquipo() {
        return logoEquipo;
    }

    public void setLogoEquipo(String logoEquipo) {
        this.logoEquipo = logoEquipo;
    }

    public List<Usuario> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Usuario> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Liga getMiLiga() {
        return miLiga;
    }

    public void setMiLiga(Liga miLiga) {
        this.miLiga = miLiga;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public int getMisPuntos() {
        return misPuntos;
    }

    public void setMisPuntos(int misPuntos) {
        this.misPuntos = misPuntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getGolesAfavor() {
        return golesAfavor;
    }

    public void setGolesAfavor(int golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    public int getGolesEncontra() {
        return golesEncontra;
    }

    public void setGolesEncontra(int golesEncontra) {
        this.golesEncontra = golesEncontra;
    }

    public Torneo getMiTorneo() {
        return miTorneo;
    }

    public void setMiTorneo(Torneo miTorneo) {
        this.miTorneo = miTorneo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", logoEquipo='" + logoEquipo + '\'' +
                ", misPuntos=" + misPuntos +
                ", partidosJugados=" + partidosJugados +
                ", partidosGanados=" + partidosGanados +
                ", partidosPerdidos=" + partidosPerdidos +
                ", partidosEmpatados=" + partidosEmpatados +
                ", golesAfavor=" + golesAfavor +
                ", golesEncontra=" + golesEncontra +
                ", listaJugadores=" + listaJugadores +
                ", miLiga=" + miLiga +
                ", miTorneo=" + miTorneo +
                '}';
    }
}
