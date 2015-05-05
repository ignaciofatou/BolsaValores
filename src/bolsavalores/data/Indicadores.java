/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsavalores.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ignacio
 */
@Entity
@Table(name = "INDICADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicadores.findAll", query = "SELECT i FROM Indicadores i"),
    @NamedQuery(name = "Indicadores.findByNombre", query = "SELECT i FROM Indicadores i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Indicadores.findByDescripcion", query = "SELECT i FROM Indicadores i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Indicadores.findByFormula", query = "SELECT i FROM Indicadores i WHERE i.formula = :formula")})
public class Indicadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FORMULA")
    private String formula;

    public Indicadores() {
    }

    public Indicadores(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicadores)) {
            return false;
        }
        Indicadores other = (Indicadores) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bolsavalores.data.Indicadores[ nombre=" + nombre + " ]";
    }
    
}
