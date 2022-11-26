package com.manager.mangerexample.Entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Usuario implements Serializable {
    private static final long serialVersionUID = 2534509645224858885L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String posicion;
    @Column( unique = true)
    private String email;
    private String password;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String codigoUsuario;
    public Usuario(){}
    public Usuario(String name, String email, String password, String imageUrl, String codigoUsuario, String posicion){
        this.name=name;
        this.email=email;
        this.password=password;
        this.imageUrl=imageUrl;
        this.codigoUsuario=codigoUsuario;
        this.posicion=posicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posicion='" + posicion + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", codigoUsuario='" + codigoUsuario + '\'' +
                '}';
    }
}
