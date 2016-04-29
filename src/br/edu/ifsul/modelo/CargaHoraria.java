/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Table(name = "carga_horaria")
public class CargaHoraria implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_carga_horaria", sequenceName = "seq_carga_horaria_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_carga_horaria", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O horario deve ser informado")
    @Length(max = 50, message = "O horario não deve ter mais que {max} caracteres")
    @Column(name = "horario", length = 50, nullable = false)
    private String horario;
    
    @ManyToMany
    @JoinTable(name = "carga_hora",
            joinColumns = 
            @JoinColumn(name = "carga_horaria", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "funcionario", referencedColumnName = "id", 
                    nullable = false))    
    private List<Funcionario> chFun = new ArrayList<>();

    public CargaHoraria() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final CargaHoraria other = (CargaHoraria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CargaHoraria{" + "id=" + id + ", horario=" + horario + '}';
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Funcionario> getChFun() {
        return chFun;
    }

    public void setChFun(List<Funcionario> chFun) {
        this.chFun = chFun;
    }
    
    
    
}
