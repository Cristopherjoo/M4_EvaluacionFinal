package com.cristopher.servicios;

import com.cristopher.interfaces.IMateria;
import com.cristopher.modelos.Materia;
import com.cristopher.excepciones.MateriaNoEncontrada;

import java.util.ArrayList;
import java.util.List;

public class MateriaServicio implements IMateria {

    private List<Materia> materias;

    public MateriaServicio() {
        materias = new ArrayList<>();
    }

    @Override
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    @Override
    public Materia buscarMateria(String nombre) throws MateriaNoEncontrada {
        for (Materia materia : materias) {
            if (materia.getNombre().name().equalsIgnoreCase(nombre)) {
                return materia;
            }
        }
        throw new MateriaNoEncontrada("Materia no encontrada: " + nombre);
    }

    @Override
    public List<Materia> listarMaterias() {
        return materias;
    }

    public void agregarNota(String nombreMateria, Double nota) throws MateriaNoEncontrada {
        Materia materia = buscarMateria(nombreMateria);
        materia.agregarNota(nota);
    }
}