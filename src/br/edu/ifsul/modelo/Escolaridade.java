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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Table(name="escolaridade")
public class Escolaridade implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_escolaridade", sequenceName = "seq_escolaridade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_escolaridade", strategy = GenerationType.SEQUENCE)
    private Integer Id;
    
    @NotBlank(message = "A escolaridade deve ser informada")
    @Length(max = 50, message = "A escolaridade não deve ter mais que {max} caracteres")
    @Column(name = "escolaridade", length = 50, nullable = false)
    private String escolaridade;
    
    @NotBlank(message = "A instituição deve ser informada")
    @Length(max = 50, message = "A instituição não deve ter mais que {max} caracteres")
    @Column(name = "instituicao", length = 50, nullable = false)
    private String Instituicao;
    
    @NotBlank(message = "A descrição deve ser informada")
    @Length(max = 50, message = "A descrição não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    public Escolaridade() {
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getInstituicao() {
        return Instituicao;
    }

    public void setInstituicao(String Instituicao) {
        this.Instituicao = Instituicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.Id);
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
        final Escolaridade other = (Escolaridade) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Escolaridade{" + "Id=" + Id + ", escolaridade=" + escolaridade + ", Instituicao=" + Instituicao + ", descricao=" + descricao + '}';
    }

    
    
    
}
