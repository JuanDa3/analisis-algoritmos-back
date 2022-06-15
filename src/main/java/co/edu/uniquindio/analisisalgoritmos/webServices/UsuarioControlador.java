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
@CrossOrigin(origins = {"http://localhost:4200","https://analisis-algoritmos.herokuapp.com"})
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    private final FormularioServicio formularioServicio;
    private final PreguntaTestServicio preguntaTestServicio;

    private List<Integer> x;
    private List<Integer> y;

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

    @GetMapping("/coeficiente")
    public ResponseEntity<?>calcularCoeficienteCorrelacion(){
        try{
            x = usuarioServicio.hallarX();
            y = usuarioServicio.hallarY();

            double xm=0 , ym=0, numerador = 0,denominador = 0,xs=0 , ys=0;
            for (int i = 0; i < y.size(); i++) {
                xm = xm + x.get(i);
                ym = ym + y.get(i);
            }
            xm = xm/x.size();
            ym = ym/y.size();
            for (int i = 0; i < y.size(); i++) {

                numerador = numerador+(x.get(i) - xm)*(y.get(i) - ym);
            }

            for (int i = 0; i < y.size(); i++) {

                xs = xs+Math.pow(x.get(i) - xm,2);
                ys = ys+Math.pow(y.get(i) - ym,2);
            }
            denominador = Math.sqrt(xs * ys);



            double coeficiente = numerador/denominador;

            return ResponseEntity.status(200).body(coeficiente);
        }catch (Exception e){
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
