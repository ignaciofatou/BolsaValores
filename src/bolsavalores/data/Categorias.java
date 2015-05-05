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
@Table(name = "CATEGORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByCodCat", query = "SELECT c FROM Categorias c WHERE c.codCat = :codCat"),
    @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Categorias.findByUrl", query = "SELECT c FROM Categorias c WHERE c.url = :url"),
    @NamedQuery(name = "Categorias.findByFormatofecha", query = "SELECT c FROM Categorias c WHERE c.formatofecha = :formatofecha"),
    @NamedQuery(name = "Categorias.findByComodin", query = "SELECT c FROM Categorias c WHERE c.comodin = :comodin"),
    @NamedQuery(name = "Categorias.findByExtension", query = "SELECT c FROM Categorias c WHERE c.extension = :extension")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CAT")
    private String codCat;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Column(name = "FORMATOFECHA")
    private String formatofecha;
    @Column(name = "COMODIN")
    private String comodin;
    @Column(name = "EXTENSION")
    private String extension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCat")
    private Collection<Valores> valoresCollection;

    public Categorias() {
    }

    public Categorias(String codCat) {
        this.codCat = codCat;
    }

    public Categorias(String codCat, String descripcion, String url, String formatofecha) {
        this.codCat = codCat;
        this.descripcion = descripcion;
        this.url = url;
        this.formatofecha = formatofecha;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormatofecha() {
        return formatofecha;
    }

    public void setFormatofecha(String formatofecha) {
        this.formatofecha = formatofecha;
    }

    public String getComodin() {
        return comodin;
    }

    public void setComodin(String comodin) {
        this.comodin = comodin;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @XmlTransient
    public Collection<Valores> getValoresCollection() {
        return valoresCollection;
    }

    public void setValoresCollection(Collection<Valores> valoresCollection) {
        this.valoresCollection = valoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCat != null ? codCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.codCat == null && other.codCat != null) || (this.codCat != null && !this.codCat.equals(other.codCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bolsavalores.data.Categorias[ codCat=" + codCat + " ]";
    }
    
}
