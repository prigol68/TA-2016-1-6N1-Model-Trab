
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
@Table(name = "pais")
public class Pais implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_pais",sequenceName = "seq_pais_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_pais",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 40, message = "O nome deve possuir até {max} caracteres")
    @NotBlank(message = "O nome deve ser informado")    
    @Column(name = "nome",length = 40, nullable = false)
    private String nome;
    @Length(max = 4, message = "O ISO deve possuir até {max} caracteres")
    @NotBlank(message = "O ISO deve ser informado")    
    @Column(name = "iso", length = 4, nullable = false)
    private String iso;
    
    public Pais(){
        
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

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
