package com.cristopher.modelos;

public enum MateriaEnum {
    MATEMATICAS,  
    LENGUAJE,     
    CIENCIA,      
    HISTORIA;     

    public static boolean contains(String nombre) {
        for (MateriaEnum materia : MateriaEnum.values()) {
            if (materia.name().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
