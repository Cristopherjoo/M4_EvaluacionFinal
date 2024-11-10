package com.cristopher.modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias;

    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Materia materia) {
        if (materias == null) {
            materias = new ArrayList<>();
        }
        materias.add(materia);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        String materiasInfo = "No tiene materias asociadas.";
        if (materias != null && !materias.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Materia materia : materias) {
                sb.append(materia).append("\n");
            }
            materiasInfo = sb.toString();
        }

        return "Alumno -> Rut: " + rut + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Dirección: " + direccion + "\nMaterias:\n" + materiasInfo;
    }

}
