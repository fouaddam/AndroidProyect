package org.fouad.appandroid.Clases;

public class User {
    private int id;
    private String name;
    private String Apellido;
    private String Email;

    public User(String name, String apellido,String Email) {
        this.id = id;
        this.name = name;
        this.Apellido = apellido;
        this.Email=Email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
