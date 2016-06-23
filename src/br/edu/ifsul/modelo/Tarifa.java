
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "tarifa")
public class Tarifa implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_tarifa", sequenceName = "seq_tarifa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_tarifa", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message = "A data de início da vigência deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio_vigencia", nullable = false)
    private Calendar inicioVigencia;
    @Length(max = 70, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descricao", length = 70)
    private String descricao;
    @NotNull(message = "A data de fim da vigência deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "fim_vigencia", nullable = false)
    private Calendar fimVigencia;
    @NotNull(message = "O custo da tarifa deve ser informado")
    @Column(name = "custo", columnDefinition = "numeric(12,2)", nullable = false)
    private Double custo;
    @NotNull(message = "A regra de tarifação deve ser informada")
    @Column(name = "regra_tarifacao", columnDefinition = "integer", nullable = false)
    private Integer regraTarifacao;
    @NotNull(message = "A operadora deve ser informada")
    @ManyToOne
    @JoinColumn(name = "operadora", referencedColumnName = "id", nullable = false)
    private Operadora operadora;

    public Tarifa() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }
    
    @Transient
    public String getInicioVigenciaString () {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (this.inicioVigencia != null) {
            return sdf.format(this.inicioVigencia.getTime());
        }
        else {
            return "";
        }
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }
    
    @Transient
    public String getFimVigenciaString () {
        if (this.fimVigencia != null) {            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(this.fimVigencia.getTime());
        }
        else {
            return "";
        }
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public Integer getRegraTarifacao() {
        return regraTarifacao;
    }

    public void setRegraTarifacao(Integer regraTarifacao) {
        this.regraTarifacao = regraTarifacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Tarifa other = (Tarifa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
