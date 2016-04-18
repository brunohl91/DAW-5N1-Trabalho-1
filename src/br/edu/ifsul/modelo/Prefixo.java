
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "prefixo")
public class Prefixo implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_prefixo", sequenceName = "seq_prefixo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_prefixo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 100, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    @NotBlank(message = "O prefixo deve ser informado")
    @Length(max = 10, message = "O prefixo não deve ultrapassar {max} caracteres")
    @Column(name = "prefixo", length = 10, nullable = false)
    private String prefixo;
    @NotNull(message = "A quantidade de dígitos deve ser informado")
    @Min(value = 1, message = "A quantidade mínima de dígitos é {value}")
    @Max(value = 10, message = "A quantidade máxima de dígitos é {value}")
    @Column(name = "quantidade_digitos", nullable = false)
    private int quantidadeDigitos;
    @NotNull(message = "A Localidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "localidade", referencedColumnName = "id", nullable = false)
    private Localidade localidade;

    public Prefixo() {
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

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public Integer getQuantidadeDigitos() {
        return quantidadeDigitos;
    }

    public void setQuantidadeDigitos(Integer quantidadeDigitos) {
        this.quantidadeDigitos = quantidadeDigitos;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Prefixo other = (Prefixo) obj;
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
