package com.umg.edu.UMGFIFA2022B.entity;
import com.umg.edu.UMGFIFA2022B.security.entity.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombreLiga;

    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFinal;

    @NotNull
    private int cantEquipos;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "liga_Usuario", joinColumns = @JoinColumn(name = "liga_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Usuario> usuarios = new HashSet<>();

    public Liga() {
    }

    public Liga(int id, String nombreLiga, Date fechaInicio, Date fechaFinal, int cantEquipos) {
        this.id = id;
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantEquipos = cantEquipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getCantEquipos() {
        return cantEquipos;
    }

    public void setCantEquipos(int cantEquipos) {
        this.cantEquipos = cantEquipos;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
