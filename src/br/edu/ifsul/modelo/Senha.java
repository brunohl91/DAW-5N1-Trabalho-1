
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "senha")
public class Senha extends Identificador implements Serializable {
    
    @NotBlank
    @Length(max = 8, min = 2, message = "O número deve ter no máximo {max} e no mínimo {min} caracteres")    
    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
