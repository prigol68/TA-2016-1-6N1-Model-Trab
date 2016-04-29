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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public abstract class Funcionario implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço não deve ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @Email(message = "Informe um email valido")
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 50, message = "O email não deve ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;
    
    @Length(max = 100, message = "O complemento não deve ter mais que {max} caracteres")
    @Column(name = "complemento", length = 100, nullable = false)
    private String complemento;
    
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "atua",
            joinColumns = 
            @JoinColumn(name = "funcionario", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "setor", referencedColumnName = "id", 
                    nullable = false))    
    private List<Setor> atuado = new ArrayList<>();
     
    @ManyToMany
    @JoinTable(name = "carga_hora",
            joinColumns = 
            @JoinColumn(name = "funcionario", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "carga_horaria", referencedColumnName = "id", 
                    nullable = false))    
    private List<CargaHoraria> ch = new ArrayList<>();
    
    public Funcionario() {
    }
    
    
    
    public void adicionarTelefone(Telefone obj){
        obj.setFuncionario(this);
        this.telefones.add(obj);
    }
    
    public void removertelefone(int index){
        this.telefones.remove(index);
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Setor> getAtuado() {
        return atuado;
    }

    public void setAtuado(List<Setor> atuado) {
        this.atuado = atuado;
    }

    public List<CargaHoraria> getCh() {
        return ch;
    }

    public void setCh(List<CargaHoraria> ch) {
        this.ch = ch;
    }

    
    

}
