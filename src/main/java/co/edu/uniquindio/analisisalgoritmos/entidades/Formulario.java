package co.edu.uniquindio.analisisalgoritmos.entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Formulario implements Serializable {

    @Id
    @Column(name = "id_formulario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormulario;

    @Column(nullable = false)
    private String pregunta;
    private int calificacion;
    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;


    public Formulario(String pregunta, int calificacion, Usuario usuario) {
        this.pregunta = pregunta;
        this.calificacion = calificacion;
        this.usuario = usuario;
    }
}
