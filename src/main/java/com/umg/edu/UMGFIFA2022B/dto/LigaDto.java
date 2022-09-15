package com.umg.edu.UMGFIFA2022B.dto;

import javax.validation.constraints.NotBlank;

public class LigaDto {

    @NotBlank
    private String nombreLiga;

    @NotBlank
    private String fechaInicio;

    @NotBlank
    private String fechaFinal;

    @NotBlank
    private int cantEquipos;

    public LigaDto() {
    }

    public LigaDto(@NotBlank String nombreLiga, @NotBlank String fechaInicio, @NotBlank String fechaFinal,@NotBlank int cantEquipos) {
        this.nombreLiga = nombreLiga;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantEquipos = cantEquipos;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getCantEquipos() {
        return cantEquipos;
    }

    public void setCantEquipos(int cantEquipos) {
        this.cantEquipos = cantEquipos;
    }
}
