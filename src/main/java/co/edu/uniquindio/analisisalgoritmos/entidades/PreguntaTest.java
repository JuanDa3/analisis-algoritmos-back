package co.edu.uniquindio.analisisalgoritmos.entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;
    @Column(nullable = false)
    private String pregunta;
    @Column(nullable = false)
    private int calificacion;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public PreguntaTest(String pregunta, int calificacion, Usuario usuario) {
        this.pregunta = pregunta;
        this.calificacion = calificacion;
        this.usuario = usuario;
    }
}
