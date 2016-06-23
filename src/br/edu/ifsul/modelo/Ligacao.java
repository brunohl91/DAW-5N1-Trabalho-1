
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/*
 Ideias p/ o futuro
    - Ligação poderia ter outras duas ligações
 de propriedade, que seriam a ligação que transferiu
 para ela e a ligação para a qual ela transferiu
    - Onde determinar fluxo da ligação?
*/

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "ligacao")
public class Ligacao implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_ligacao", sequenceName = "seq_ligacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ligacao", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "A duração deve ser informada")
    @Min(value = 0, message = "O valor mínimo para a duração é de {value} segundos")
    @Column(name = "duracao", nullable = false)
    private int duracao;
    @Length(max = 40, message = "O número de caracteres do número discado não deve ultrapassar {max}")
    @Column(name = "discado", length = 40)
    private String discado;
    @Length(max = 8, message = "O número de caracteres do ramal não deve ultrapassar {max}")
    @Column(name = "ramal", length = 8)
    private String ramal; // necessário para caso de erro
    @Length(max = 8, message = "O número de caracteres da senha não deve ultrapassar {max}")
    @Column(name = "senha", length = 8)
    private String senha; // necessário para caso de erro
    @Length(max = 140, message = "O número de caracteres do erro não deve ultrapassar {max}")
    @Column(name = "erro", length = 140)
    private String erro;
    @Column(name = "custo", columnDefinition = "numeric(12,2)")
    private Double custo;
    @NotNull(message = "A tarifa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "tarifa", referencedColumnName = "id", nullable = false)
    private Tarifa tarifa;
    @NotNull(message = "O serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false)
    private Servico servico;
    @ManyToMany
    @JoinTable(name = "ramal_ligacao", 
        joinColumns = @JoinColumn(name = "ligacao", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "ramal_ligacao", referencedColumnName = "id", nullable = false)
    )
    private List<Ramal> ramaisLigacao = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "senha_ligacao", referencedColumnName = "id")
    private Senha senhaLigacao;
    @NotNull(message = "O prefixo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "prefixo", referencedColumnName = "id", nullable = false)
    private Prefixo prefixo;
    @ManyToOne
    @JoinColumn(name = "conta", referencedColumnName = "id")
    private Conta conta;
    
    public Ligacao () {
    }
    
    public void adicionarRamal (Ramal r) {
        this.getRamaisLigacao().add(r);
    }
    
    public void removerRamal (int index) {
        Ramal r = this.getRamaisLigacao().get(index);
        this.getRamaisLigacao().remove(index);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiscado() {
        return discado;
    }

    public void setDiscado(String discado) {
        this.discado = discado;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Ramal> getRamaisLigacao() {
        return ramaisLigacao;
    }

    public void setRamaisLigacao(List<Ramal> ramaisLigacao) {
        this.ramaisLigacao = ramaisLigacao;
    }

    public Senha getSenhaLigacao() {
        return senhaLigacao;
    }

    public void setSenhaLigacao(Senha senhaLigacao) {
        this.senhaLigacao = senhaLigacao;
    }

    public Prefixo getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Prefixo prefixo) {
        this.prefixo = prefixo;
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
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Ligacao other = (Ligacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ligacao{" + "data=" + data + ", discado=" + discado + '}';
    }
    
}
