
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
@Table(name = "uf")
public class UF implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_uf", sequenceName = "seq_uf_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_uf", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 50, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    @NotBlank(message = "A UF deve ser informada")
    @Length(min = 2, max = 2, message = "A UF deve ter {max} caracteres")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    public UF() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final UF other = (UF) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
