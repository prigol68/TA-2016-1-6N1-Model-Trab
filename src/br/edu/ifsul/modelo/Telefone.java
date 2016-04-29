/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author DanielPrigol
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 14, message = "O numero não deve ter mais que {max} caracteres")
    @Column(name = "numero", length = 14, nullable = false)
    private String numero;
    
    @NotBlank(message = "O descricao deve ser informado")
    @Length(max = 20, message = "O descricao não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 20)
    private String descricao;
    
    
    @Length(max = 2, message = "A operadora não deve ter mais que {max} caracteres")
    @Column(name = "operadora", length = 2)
    private String operadora;
    
    @NotNull(message = "O funcionario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    public Telefone() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", numero=" + numero + ", descricao=" + descricao + ", operadora=" + operadora + ", funcionario=" + funcionario + '}';
    }
    
}