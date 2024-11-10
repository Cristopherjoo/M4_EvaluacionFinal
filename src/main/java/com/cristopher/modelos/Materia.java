
package com.cristopher.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private MateriaEnum nombre;
    private List<Double> notas;

    public Materia(MateriaEnum nombre, List<Double> notas) {
        this.nombre = nombre;

        this.notas = new ArrayList<>(notas);
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void agregarNota(Double nota) {
        this.notas.add(nota);
    }

    @Override
    public String toString() {
        String notasStr = notas.isEmpty() ? "No hay notas" : String.join(", ", notas.stream().map(String::valueOf).toArray(String[]::new));
        return "Materia: " + nombre + ", Notas: " + notasStr;
    }

}