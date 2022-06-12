package co.edu.uniquindio.analisisalgoritmos.webServices;

import co.edu.uniquindio.analisisalgoritmos.service.PreguntaTestServicio;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/preguntatestcontroller")
@CrossOrigin(origins = "http://localhost:4200")
public class PreguntaTestControlador {

    private final PreguntaTestServicio preguntaTestServicio;

    public PreguntaTestControlador(PreguntaTestServicio preguntaTestServicio) {
        this.preguntaTestServicio = preguntaTestServicio;
    }

    @GetMapping("/promedioglobalpregunta")
    public ResponseEntity<?>promedioGlobalPregunta(){
        try{
            return ResponseEntity.status(200).body(preguntaTestServicio.promedioGlobalPregunta());
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/preguntascorrectas")
    public ResponseEntity<?>numeroPreguntasCorrectas() throws Exception{
        try{
            return ResponseEntity.status(200).body(preguntaTestServicio.numeroRespuestasCorrectasPorPregunta());
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/preguntasincorrectas")
    public ResponseEntity<?>numeroPreguntasIncorrectas() throws Exception{
        try{
            return ResponseEntity.status(200).body(preguntaTestServicio.numeroRespuestasIncorrectasPorPregunta());
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/listadocalificacion")
    public ResponseEntity<?>listadoCalificacionPorEstudianteAsc() throws Exception{
        try{
            return ResponseEntity.status(200).body(preguntaTestServicio.ListadoMayorAMenor());
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
