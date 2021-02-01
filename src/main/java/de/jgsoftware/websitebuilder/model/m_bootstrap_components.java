package de.jgsoftware.websitebuilder.model;


import javax.persistence.*;
import java.sql.Clob;


@Entity
@Table(name = "bootstrap_components")
public class m_bootstrap_components
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    private String compname;
    private String bootstrapcompname;

    private String svgname;


    public String getSvgname() {
        return svgname;
    }

    public void setSvgname(String svgname) {
        this.svgname = svgname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getBootstrapcompname() {
        return bootstrapcompname;
    }

    public void setBootstrapcompname(String bootstrapcompname) {
        this.bootstrapcompname = bootstrapcompname;
    }
}
