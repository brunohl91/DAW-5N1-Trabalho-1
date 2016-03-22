
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "localidade")
public class Localidade implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_localidade", sequenceName = "seq_localidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_localidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 120, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 120, nullable = false)
    private String descricao;
    @NotNull(message = "A UF deve ser informado")
    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id", nullable = false)
    private UF uf;

    public Localidade() {
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

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Localidade other = (Localidade) obj;
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
