package com.manager.mangerexample.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "permisos")
@Data
public class Permisos implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length =50)
    private String title;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
