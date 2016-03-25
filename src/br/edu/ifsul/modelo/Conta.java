
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "conta")
public class Conta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_conta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 120, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 120, nullable = false)
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_ini_periodo")
    private Calendar dataIniPeriodo;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim_periodo")
    private Calendar dataFimPeriodo;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento")
    private Calendar dataVencimento;
    @NotNull(message = "O custo total deve ser informado")
    @Column(name = "custo_total", columnDefinition = "numeric(12,2)")
    private Double custoTotal;
    @NotNull(message = "A operadora deve ser informada")
    @ManyToOne
    @JoinColumn(name = "operadora", referencedColumnName = "id", nullable = false)
    private Operadora operadora;
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ServicoConta> servicos = new ArrayList<>();

    public Conta() {
    }
    
    public void adicionarServico (ServicoConta s) {
        s.setConta(this);
        this.servicos.add(s);
    }
    
    public void removerServico (Integer index) {
        this.servicos.remove(index);
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

    public Calendar getDataIniPeriodo() {
        return dataIniPeriodo;
    }

    public void setDataIniPeriodo(Calendar dataIniPeriodo) {
        this.dataIniPeriodo = dataIniPeriodo;
    }

    public Calendar getDataFimPeriodo() {
        return dataFimPeriodo;
    }

    public void setDataFimPeriodo(Calendar dataFimPeriodo) {
        this.dataFimPeriodo = dataFimPeriodo;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }
    
    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public List<ServicoConta> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoConta> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Conta other = (Conta) obj;
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
