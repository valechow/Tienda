
package com.tienda.domain;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    
    private Long idRol;
    
    @NotEmpty
    private String nombre;
       

   
}
