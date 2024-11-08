package com.cristopher.vistas;

import com.cristopher.modelos.Alumno;
import com.cristopher.modelos.Materia;
import com.cristopher.modelos.MateriaEnum;
import com.cristopher.servicios.AlumnoServicio;
import com.cristopher.servicios.MateriaServicio;
import com.cristopher.servicios.ArchivoServicio;
import java.util.List;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio;
    private MateriaServicio materiaServicio;
    private ArchivoServicio archivoServicio;

    public Menu() {
        this.alumnoServicio = new AlumnoServicio();
        this.materiaServicio = new MateriaServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    @Override
    public void exportarDatos() {
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
    }

    @Override
    public void crearAlumno() {
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.next();
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la dirección del alumno: ");
        String direccion = scanner.next();

        alumnoServicio.agregarAlumno(new Alumno(rut, nombre, apellido, direccion));
    }

    @Override
public void agregarMateria() {  
    System.out.print("Ingrese el nombre de la materia (Matematicas, Lenguaje, Ciencia, Historia): ");
    String nombreMateria = scanner.next().toUpperCase();  
  
    if (MateriaEnum.contains(nombreMateria)) {             
        materiaServicio.agregarMateria(new Materia(MateriaEnum.valueOf(nombreMateria), List.of(2.0, 6.0, 7.0)));
        System.out.println("Materia agregada exitosamente.");
    } else {       
        System.out.println("Materia no válida.");
    }
}

    @Override
    public void agregarNota() {
        // pendiente en futuras necesidades
    }

    @Override
    public void listarAlumnos() {
        System.out.println(alumnoServicio.listarAlumnos());
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Programa finalizado.");
        System.exit(0);
    }

    public void mostrarMenu() {
        iniciarMenu();
    }
}
