/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario extends Funcionario implements Serializable {

    @NotNull(message = "O apelido não pode ser nulo")
    @NotBlank(message = "O apelido deve ser informado")
    @Length(max = 20, message = "O apelido não pode ter mais de {max} caracteres")
    @Column(name = "apelido", length = 20, nullable = false, unique = true)
    private String apelido;
    
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha deve ser informado")
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @NotNull(message = "Administrador não pode ser nulo")
    @Column(name = "administrador", nullable = false)
    private Boolean administrador;
    
    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    public Usuario() {
    }      
    
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    
    

    

    

    

}
