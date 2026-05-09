package org.example.model;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    public Person(String personID, String personName) {
        this.PersonID = personID;
        this.PersonName = personName;
    }

    public Person() {
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        this.PersonID = personID;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        this.PersonName = personName;
    }

    public abstract void mainTask();
}
