package org.example.model;

public abstract class Person {
    private int id;
    private String name;

    public Person (int studID, String studName){
        this.id = studID;
        this.name = studName;
    }

    public Person() {

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void mainTask();
}
