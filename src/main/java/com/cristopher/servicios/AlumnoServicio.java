package com.cristopher.servicios;

import com.cristopher.interfaces.IAlumno;
import com.cristopher.modelos.Alumno;
import com.cristopher.excepciones.AlumnoNoEncontrado;

import java.util.ArrayList;
import java.util.List;

public class AlumnoServicio implements IAlumno {

    private List<Alumno> alumnos;

    public AlumnoServicio() {
        alumnos = new ArrayList<>();
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    @Override
    public Alumno buscarAlumno(String nombre) throws AlumnoNoEncontrado {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                return alumno;
            }
        }
        throw new AlumnoNoEncontrado("Alumno no encontrado: " + nombre);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnos;
    }

}