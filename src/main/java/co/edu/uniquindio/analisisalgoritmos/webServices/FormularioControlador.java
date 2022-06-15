package co.edu.uniquindio.analisisalgoritmos.webServices;

import co.edu.uniquindio.analisisalgoritmos.service.FormularioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/formulario")
@CrossOrigin(origins = {"http://localhost:4200","https://analisis-algoritmos.herokuapp.com"})
public class FormularioControlador {

    private final FormularioServicio formularioServicio;

    public FormularioControlador(FormularioServicio formularioServicio) {
        this.formularioServicio = formularioServicio;
    }

    @GetMapping
    public ResponseEntity<?>promedioPreguntaOpinion(){
        try{
            return ResponseEntity.status(200).body(formularioServicio.promedioCadaPregunta());
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
