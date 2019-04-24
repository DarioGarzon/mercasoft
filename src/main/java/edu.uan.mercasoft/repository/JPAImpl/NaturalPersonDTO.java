package edu.uan.mercasoft.repository.JPAImpl;

import javax.persistence.*;

@Entity
@Table(name = "Natural_Person")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name="NaturalPersonDTO.findAll", query="SELECT c FROM NaturalPersonDTO c")
}
)
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
