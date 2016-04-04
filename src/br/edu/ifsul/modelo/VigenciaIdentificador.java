
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "vigencia_identificador")
public class VigenciaIdentificador implements Serializable {
    
    @EmbeddedId
    private VigenciaIdentificadorID vigenciaId;
    @NotNull(message = "A data inicial deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicial", nullable = false)
    private Calendar dataIni;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_final")
    private Calendar dataFim;

    public VigenciaIdentificador () {
    }

    public VigenciaIdentificadorID getVigenciaId() {
        return vigenciaId;
    }

    public void setVigenciaId(VigenciaIdentificadorID vigenciaId) {
        this.vigenciaId = vigenciaId;
    }
    
    public Calendar getDataIni() {
        return dataIni;
    }

    public void setDataIni(Calendar dataIni) {
        this.dataIni = dataIni;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getVigenciaId());
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
        final VigenciaIdentificador other = (VigenciaIdentificador) obj;
        if (!Objects.equals(this.vigenciaId, other.vigenciaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dataIni.toString() + " - " + dataFim.toString();
    }
    
}
