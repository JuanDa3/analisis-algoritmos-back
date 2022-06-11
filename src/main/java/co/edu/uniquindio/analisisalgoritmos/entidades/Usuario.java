package co.edu.uniquindio.analisisalgoritmos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(length = 30, unique = true, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "usuario")
    private List<Formulario>formularioList = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<PreguntaTest>preguntaTestList = new ArrayList<>();
}
