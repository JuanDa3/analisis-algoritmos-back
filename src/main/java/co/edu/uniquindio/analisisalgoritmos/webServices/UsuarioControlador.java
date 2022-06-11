package co.edu.uniquindio.analisisalgoritmos.webServices;

import co.edu.uniquindio.analisisalgoritmos.entidades.Formulario;
import co.edu.uniquindio.analisisalgoritmos.entidades.PreguntaTest;
import co.edu.uniquindio.analisisalgoritmos.entidades.Usuario;
import co.edu.uniquindio.analisisalgoritmos.service.FormularioServicio;
import co.edu.uniquindio.analisisalgoritmos.service.PreguntaTestServicio;
import co.edu.uniquindio.analisisalgoritmos.service.UsuarioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    private final FormularioServicio formularioServicio;
    private final PreguntaTestServicio preguntaTestServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio, FormularioServicio formularioServicio, PreguntaTestServicio preguntaTestServicio) {
        this.usuarioServicio = usuarioServicio;
        this.formularioServicio = formularioServicio;
        this.preguntaTestServicio = preguntaTestServicio;
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody DatosJuego datosJuego){

        try {
            Usuario usuarioGuardar = new Usuario();
            usuarioGuardar.setNombre(datosJuego.getNombreJugador());
            guardarPreguntas(usuarioGuardar, datosJuego.getEncuesta(), datosJuego.getCalificacion());
            return ResponseEntity.status(200).body(new Mensaje("Calificacion guardada"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    public void guardarPreguntas(Usuario usuario, List<Integer>calificacionFormulario, List<Integer>calificacionTest){
        try {
            usuarioServicio.registrarUsuario(usuario);

        for (int i = 0; i < calificacionTest.size(); i++){
            PreguntaTest preguntaTest = new PreguntaTest("test"+i, calificacionTest.get(i), usuario);
            preguntaTestServicio.registrarPregunta(preguntaTest);
        }

        for (int i = 0; i < calificacionFormulario.size(); i++){
            Formulario formularioGuardar = new Formulario("pregunta"+i, calificacionFormulario.get(i), usuario);
            formularioServicio.guardarPreguntaFormulario(formularioGuardar);
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
