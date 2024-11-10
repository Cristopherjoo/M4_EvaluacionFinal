package com.cristopher.interfaces;

import com.cristopher.modelos.Alumno;
import com.cristopher.excepciones.AlumnoNoEncontrado;
import java.util.List;

public interface IAlumno {
    void agregarAlumno(Alumno alumno);
    Alumno buscarAlumno(String nombre) throws AlumnoNoEncontrado;  
    List<Alumno> listarAlumnos();
}