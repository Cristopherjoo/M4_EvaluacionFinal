package com.cristopher.controlador;

import com.cristopher.servicios.AlumnoServicio;
import com.cristopher.servicios.MateriaServicio;
import com.cristopher.modelos.Alumno;
import com.cristopher.modelos.Materia;
import com.cristopher.excepciones.AlumnoNoEncontrado;
import com.cristopher.excepciones.MateriaNoEncontrada;
import com.cristopher.modelos.MateriaEnum;
import java.util.List;

public class MenuController {
    private AlumnoServicio alumnoServicio;
    private MateriaServicio materiaServicio;

    public MenuController() {
        alumnoServicio = new AlumnoServicio();
        materiaServicio = new MateriaServicio();
    }

    public void agregarAlumno(String nombre, int edad) {
        Alumno alumno = new Alumno("rut-" + nombre, nombre, "Apellido", "Direccion");
        alumnoServicio.agregarAlumno(alumno);
    }

    public void agregarMateria(String nombre, int creditos) {
        Materia materia = new Materia(MateriaEnum.valueOf(nombre.toUpperCase()), List.of(5.0, 6.0, 7.0));
        materiaServicio.agregarMateria(materia);
    }

    public void buscarAlumno(String nombre) {
        try {
            Alumno alumno = alumnoServicio.buscarAlumno(nombre);
            System.out.println(alumno);
        } catch (AlumnoNoEncontrado e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarMateria(String nombre) {
        try {
            Materia materia = materiaServicio.buscarMateria(nombre);
            System.out.println(materia);
        } catch (MateriaNoEncontrada e) {
            System.out.println(e.getMessage());
        }
    }
}
