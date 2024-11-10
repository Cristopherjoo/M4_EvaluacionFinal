package com.cristopher.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNota();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    public void iniciarMenu() {
        int opcion = 0;
        do {
            System.out.println("******* Menú *******");
            System.out.println("1. Crear Alumno");
            System.out.println("2. Agregar Materia");
            System.out.println("3. Agregar Nota");
            System.out.println("4. Listar Alumnos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Terminar Programa");
            System.out.println("********************");
            System.out.print("\nSelecciona una opción:\n");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    agregarMateria();
                    break;
                case 3:
                    agregarNota();
                    break;
                case 4:
                    listarAlumnos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción inválida\n");
            }
        } while (opcion != 6);
    }
}