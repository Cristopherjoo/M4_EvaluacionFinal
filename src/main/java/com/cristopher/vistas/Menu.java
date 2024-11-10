package com.cristopher.vistas;

import com.cristopher.excepciones.AlumnoNoEncontrado;
import com.cristopher.modelos.Alumno;
import com.cristopher.modelos.Materia;
import com.cristopher.modelos.MateriaEnum;
import com.cristopher.servicios.AlumnoServicio;
import com.cristopher.servicios.ArchivoServicio;
import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuTemplate {

    private AlumnoServicio alumnoServicio;    
    private ArchivoServicio archivoServicio;

    public Menu() {
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    @Override
    public void exportarDatos() {
        archivoServicio.exportarDatos(alumnoServicio.getAlumnos());
    }

    @Override
    public void crearAlumno() {
        System.out.print("Ingrese RUT del alumno: ");
        String rut = scanner.next();
        System.out.print("Ingrese nombre del alumno: ");
        String nombre = scanner.next();
        System.out.print("Ingrese apellido del alumno: ");
        String apellido = scanner.next();
        System.out.print("Ingrese dirección del alumno: ");
        String direccion = scanner.next();

        alumnoServicio.agregarAlumno(new Alumno(rut, nombre, apellido, direccion));
    }

    @Override
    public void agregarMateria() {
        System.out.print("Ingrese nombre de la materia (Matematicas, Lenguaje, Ciencia, Historia): ");
        String nombreMateria = scanner.next().toUpperCase();

        try {
            MateriaEnum materiaEnum = MateriaEnum.valueOf(nombreMateria);
            Materia materia = new Materia(materiaEnum, new ArrayList<>());
            System.out.print("Ingrese nombre del alumno para agregar la materia: ");
            String nombreAlumno = scanner.next();

            try {
                Alumno alumno = alumnoServicio.buscarAlumno(nombreAlumno);
                alumno.agregarMateria(materia);
                System.out.println("Materia agregada exitosamente.");
            } catch (AlumnoNoEncontrado e) {
                System.out.println(e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Materia no válida.");
        }
    }

    @Override
    public void agregarNota() {
        System.out.print("Ingrese nombre del alumno: ");
        String nombreAlumno = scanner.next();

        Alumno alumno = null;
        try {
            alumno = alumnoServicio.buscarAlumno(nombreAlumno);
        } catch (AlumnoNoEncontrado e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Materias del alumno " + nombreAlumno + ": ");
        for (Materia materia : alumno.getMaterias()) {
            System.out.println("- " + materia.getNombre());
        }

        System.out.print("Ingrese nombre de la materia para agregar la nota: ");
        String nombreMateria = scanner.next().toUpperCase();

        Materia materia = null;
        for (Materia m : alumno.getMaterias()) {
            if (m.getNombre().name().equalsIgnoreCase(nombreMateria)) {
                materia = m;
                break;
            }
        }

        if (materia == null) {
            System.out.println("La materia no está asociada al alumno.");
            return;
        }

        System.out.print("Agregar la nota: ");
        Double nota = scanner.nextDouble();

        materia.agregarNota(nota);
        System.out.println("Nota agregada exitosamente.");
    }

    @Override
    public void listarAlumnos() {
        List<Alumno> alumnos = alumnoServicio.listarAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno alumno : alumnos) {
                System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());

                if (alumno.getMaterias() == null || alumno.getMaterias().isEmpty()) {
                    System.out.println("El alumno no tiene materias.");
                } else {
                    System.out.println("Materias del alumno: ");
                    for (Materia materia : alumno.getMaterias()) {
                        System.out.println(materia);
                    }
                }
                System.out.println();
            }
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("******* FIN DEL PROGRAMA ********.");
        System.exit(0);
    }

    public void mostrarMenu() {
        iniciarMenu();
    }
}