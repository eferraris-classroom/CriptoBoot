package ar.edu.undef.fie.criptoboot.entities;

import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

}
