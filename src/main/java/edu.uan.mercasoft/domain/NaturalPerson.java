package edu.uan.mercasoft.domain;

public class NaturalPerson {
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public NaturalPerson(String name, String lastName, String documentNumber) {
        this.name = name;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return name+ " "+ lastName;
    }
}
