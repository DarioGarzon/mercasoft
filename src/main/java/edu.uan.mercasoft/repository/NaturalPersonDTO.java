package edu.uan.mercasoft.repository;

import com.sun.istack.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NaturalPerson")
public class NaturalPersonDTO {

    protected String name;

    protected String lastName;
    protected String documentNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Id
    @Column(name = "DOCUMENT")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public NaturalPersonDTO() {
    }
}
