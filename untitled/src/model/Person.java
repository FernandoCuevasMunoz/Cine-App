package model;
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public void showInformation() {
        System.out.println("Nombre: " + name);
    }
}