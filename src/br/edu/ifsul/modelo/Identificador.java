
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "identificador")
public class Identificador implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_identificador", sequenceName = "seq_identificador_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_identificador", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data inicial de validade do identificador deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicial", nullable = false)
    private Calendar dataInicial;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_final")
    private Calendar dataFinal;
    
    public Identificador() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Identificador other = (Identificador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "";
    }
    
}
