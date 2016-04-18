
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "servico_conta")
public class ServicoConta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_servico_conta", sequenceName = "seq_servico_conta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_servico_conta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 140, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 140, nullable = false)
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(name = "data")
    private Calendar data;
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", columnDefinition = "numeric(12,2)")
    private Double quantidade;
    @NotNull(message = "O custo deve ser informado")
    @Column(name = "custo", columnDefinition = "numeric(12,2)", nullable = false)
    private Double custo;
    @NotNull(message = "O custo real deve ser informado")
    @Column(name = "custo_real", columnDefinition = "numeric(12,2)", nullable = false)
    private Double custoReal;
    @NotNull(message = "A conta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id", nullable = false)
    private Conta conta;

    public ServicoConta() {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getCustoReal() {
        return custoReal;
    }

    public void setCustoReal(Double custoReal) {
        this.custoReal = custoReal;
    }
    
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
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
        final ServicoConta other = (ServicoConta) obj;
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
