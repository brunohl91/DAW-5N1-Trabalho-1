
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "operadora")
public class Operadora implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_operadora", sequenceName = "seq_operadora_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_operadora", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 20, message = "O tipo não deve ultrapassar {max} caracteres")
    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;
    @Length(max = 20, message = "O código de discagem não deve ultrapassar {max} caracteres")
    @Column(name = "codigo_discagem", length = 20, nullable = false)
    private String codigoDiscagem;

    public Operadora() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoDiscagem() {
        return codigoDiscagem;
    }

    public void setCodigoDiscagem(String codigoDiscagem) {
        this.codigoDiscagem = codigoDiscagem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operadora other = (Operadora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
