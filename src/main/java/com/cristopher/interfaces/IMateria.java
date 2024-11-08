package com.cristopher.interfaces;

import com.cristopher.modelos.Materia;
import com.cristopher.excepciones.MateriaNoEncontrada;
import java.util.List;

public interface IMateria {
    void agregarMateria(Materia materia);
    Materia buscarMateria(String nombre) throws MateriaNoEncontrada;  
    List<Materia> listarMaterias();
}
