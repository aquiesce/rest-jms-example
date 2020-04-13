package com.aquiesce.restexample.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Instrument implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    public Instrument() {
    }

    public Instrument(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private long id;
    private String name;

    @XmlElement
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
