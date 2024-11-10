package com.cristopher.servicios;

import com.cristopher.modelos.Alumno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicio {

    public void exportarDatos(List<Alumno> alumnos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alumnos.txt"))) {
            for (Alumno alumno : alumnos) {
                writer.write(alumno.toString());
                writer.newLine();
            }
            System.out.println("Datos exportados con exito.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos.");
        }
    }
}
