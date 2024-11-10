package pruebasPersonalizadas;

import com.cristopher.modelos.Alumno;
import com.cristopher.excepciones.AlumnoNoEncontrado;
import com.cristopher.servicios.AlumnoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlumnoServicioTest {
    private AlumnoServicio alumnoServicio;

    @BeforeEach
    public void setUp() {
        alumnoServicio = new AlumnoServicio();
    }

    @Test
    public void testAgregarAlumno() {
        Alumno alumno = new Alumno("rut: 123", "Luis", "Miguel", "Calle Fama");
        alumnoServicio.agregarAlumno(alumno);

        assertEquals(1, alumnoServicio.listarAlumnos().size(), "El número de alumnos debe ser 1");

        assertEquals("Luis", alumnoServicio.listarAlumnos().get(0).getNombre(), "El nombre del alumno debe ser Luis");
    }

    @Test
    public void testBuscarAlumnoExistente() throws AlumnoNoEncontrado {
        Alumno alumno = new Alumno("rut: 123", "Luis", "Miguel", "Calle La Fama");
        alumnoServicio.agregarAlumno(alumno);

        Alumno alumnoBuscado = alumnoServicio.buscarAlumno("Luis");
        assertNotNull(alumnoBuscado, "El alumno debe ser encontrado.");
        assertEquals("Luis", alumnoBuscado.getNombre(), "El nombre del alumno debe ser Luis");
    }

    @Test
    public void testBuscarAlumnoNoExistente() {
        assertThrows(AlumnoNoEncontrado.class, () -> {
            alumnoServicio.buscarAlumno("NoExisten");
        }, "Se debe lanzar la excepción AlumnoNoEncontrado");
    }

    @Test
    public void testAgregarAlumnoConRUTUnico() {
        Alumno alumno1 = new Alumno("rut: 123", "Luis", "Miguel", "Calle La Fama");
        Alumno alumno2 = new Alumno("rut: 124", "Ana", "Martínez", "Avenida Central");

        alumnoServicio.agregarAlumno(alumno1);
        alumnoServicio.agregarAlumno(alumno2);

        assertEquals(2, alumnoServicio.listarAlumnos().size(), "El número de alumnos debe ser 2");
    }
}
