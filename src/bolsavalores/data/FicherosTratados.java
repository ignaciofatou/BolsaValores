/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsavalores.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ignacio
 */
@Entity
@Table(name = "FICHEROS_TRATADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FicherosTratados.findAll", query = "SELECT f FROM FicherosTratados f"),
    @NamedQuery(name = "FicherosTratados.findByFichero", query = "SELECT f FROM FicherosTratados f WHERE f.fichero = :fichero"),
    @NamedQuery(name = "FicherosTratados.findByNumReg", query = "SELECT f FROM FicherosTratados f WHERE f.numReg = :numReg"),
    @NamedQuery(name = "FicherosTratados.findByFecha", query = "SELECT f FROM FicherosTratados f WHERE f.fecha = :fecha")})
public class FicherosTratados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FICHERO")
    private String fichero;
    @Basic(optional = false)
    @Column(name = "NUM_REG")
    private int numReg;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public FicherosTratados() {
    }

    public FicherosTratados(String fichero) {
        this.fichero = fichero;
    }

    public FicherosTratados(String fichero, int numReg) {
        this.fichero = fichero;
        this.numReg = numReg;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public int getNumReg() {
        return numReg;
    }

    public void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichero != null ? fichero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicherosTratados)) {
            return false;
        }
        FicherosTratados other = (FicherosTratados) object;
        if ((this.fichero == null && other.fichero != null) || (this.fichero != null && !this.fichero.equals(other.fichero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bolsavalores.data.FicherosTratados[ fichero=" + fichero + " ]";
    }
    
}
