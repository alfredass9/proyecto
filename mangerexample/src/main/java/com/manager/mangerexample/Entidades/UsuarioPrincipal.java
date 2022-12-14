package com.manager.mangerexample.Entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

    private String name;
    private String userName;
    private String posicion;
    private String email;
    private String password;
    private String imageUrl;
    private String codigoUsuario;
    private Collection<? extends GrantedAuthority> authorities;
    private Equipo miequipo;

    public UsuarioPrincipal(String name, String userName, String posicion, String email, String password, String imageUrl, String codigoUsuario, Collection<? extends GrantedAuthority> authorities, Equipo miequipo) {
        this.name = name;
        this.userName = userName;
        this.posicion = posicion;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.codigoUsuario = codigoUsuario;
        this.authorities = authorities;
        this.miequipo = miequipo;
    }
    public static UsuarioPrincipal build(Usuario usuario){

        List<GrantedAuthority> authorities=
                usuario.getRole().stream().map(rol->new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getName(), usuario.getnombreUsuario(), usuario.getPosicion(),
                usuario.getEmail(), usuario.getPassword(), usuario.getImageUrl(), usuario.getCodigoUsuario(),
                authorities, usuario.getMiequipo() );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Equipo getMiequipo() {
        return miequipo;
    }

    public void setMiequipo(Equipo miequipo) {
        this.miequipo = miequipo;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
