package com.manager.mangerexample.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Usuario implements Serializable {
    private static final long serialVersionUID = 2534509645224858885L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    @Column(unique = true)
    private String nombreUsuario;
    private String posicion;
    @Column(unique = true)
    private String email;
    private String password;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String codigoUsuario;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuario_Rol",joinColumns = @JoinColumn(name = "usuario_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> role=new HashSet<>();
    public Usuario(){}

    public Usuario(String name, String nombreUsuario, String posicion, String email, String password, String imageUrl) {
        this.name = name;
        this.nombreUsuario = nombreUsuario;
        this.posicion = posicion;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", posicion='" + posicion + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", codigoUsuario='" + codigoUsuario + '\'' +
                ", role=" + role +
                '}';
    }





    public Long getId() {
        return id;
    }

    public String getnombreUsuario() {
        return nombreUsuario;
    }

    public void setnombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Set<Roles> getRole() {
        return role;
    }

    public void setRole(Set<Roles> role) {
        this.role = role;
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

}
