/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Table(name = "Cartao_ponto")
public class CartaoPonto extends CargaHoraria implements Serializable {
    @EmbeddedId
    private CartaoPontoId cartaoPontoid;
    private String registro;

    public CartaoPonto() {
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getRegistro());
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
        final CartaoPonto other = (CartaoPonto) obj;
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CartaoPonto{" + "registro=" + getRegistro() + '}';
    }

    public CartaoPontoId getCartaoPontoid() {
        return cartaoPontoid;
    }

    public void setCartaoPontoid(CartaoPontoId cartaoPontoid) {
        this.cartaoPontoid = cartaoPontoid;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    
}
