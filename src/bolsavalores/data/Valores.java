/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsavalores.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ignacio
 */
@Entity
@Table(name = "VALORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valores.findAll", query = "SELECT v FROM Valores v"),
    @NamedQuery(name = "Valores.findByCodValor", query = "SELECT v FROM Valores v WHERE v.codValor = :codValor"),
    @NamedQuery(name = "Valores.findByDecimales", query = "SELECT v FROM Valores v WHERE v.decimales = :decimales"),
    @NamedQuery(name = "Valores.findByDescripcion", query = "SELECT v FROM Valores v WHERE v.descripcion = :descripcion")})
public class Valores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_VALOR")
    private String codValor;
    @Basic(optional = false)
    @Column(name = "DECIMALES")
    private int decimales;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "COD_CAT", referencedColumnName = "COD_CAT")
    @ManyToOne(optional = false)
    private Categorias codCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valores")
    private Collection<DatosValores> datosValoresCollection;

    public Valores() {
    }

    public Valores(String codValor) {
        this.codValor = codValor;
    }

    public Valores(String codValor, int decimales, String descripcion) {
        this.codValor = codValor;
        this.decimales = decimales;
        this.descripcion = descripcion;
    }

    public String getCodValor() {
        return codValor;
    }

    public void setCodValor(String codValor) {
        this.codValor = codValor;
    }

    public int getDecimales() {
        return decimales;
    }

    public void setDecimales(int decimales) {
        this.decimales = decimales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCodCat() {
        return codCat;
    }

    public void setCodCat(Categorias codCat) {
        this.codCat = codCat;
    }

    @XmlTransient
    public Collection<DatosValores> getDatosValoresCollection() {
        return datosValoresCollection;
    }

    public void setDatosValoresCollection(Collection<DatosValores> datosValoresCollection) {
        this.datosValoresCollection = datosValoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codValor != null ? codValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valores)) {
            return false;
        }
        Valores other = (Valores) object;
        if ((this.codValor == null && other.codValor != null) || (this.codValor != null && !this.codValor.equals(other.codValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bolsavalores.data.Valores[ codValor=" + codValor + " ]";
    }
    
}
