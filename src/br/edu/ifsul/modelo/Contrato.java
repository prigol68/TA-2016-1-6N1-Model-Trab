/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author DanielPrigol
 */
@Entity
@Table(name = "contrato")
public class Contrato implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_contrato", sequenceName = "seq_contrato_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_contrato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O salario deve ser informado")
    @Column(name = "salario", nullable = false, columnDefinition = "decimal(12,2)")
    private double salario;
    
    @NotNull(message = "Status não pode ser nulo")
    @Column(name = "status", nullable = false)
    private boolean status;
    
    @NotNull(message = "A data de admissão deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataAdm", nullable = false)
    private Calendar dataAdm;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataDemissao", nullable = true)
    private Calendar dataDemissao;
    
    @NotNull(message = "O cargo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cargo", referencedColumnName = "id", nullable = false)
    private Cargo cargo;
    
    @NotNull(message = "O funcionario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    public Contrato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getDataAdm() {
        return dataAdm;
    }

    public void setDataAdm(Calendar dataAdm) {
        this.dataAdm = dataAdm;
    }

    public Calendar getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Calendar dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Contrato other = (Contrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", salario=" + salario + ", status=" + status + ", dataAdm=" + dataAdm + ", dataDemissao=" + dataDemissao + '}';
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
    
}
