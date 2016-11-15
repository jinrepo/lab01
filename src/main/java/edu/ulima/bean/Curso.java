package edu.ulima.bean;

public class Curso {
    private int id ;
    private int creditos;
    private int nivel;
    private String nombre;
    private int facultadID;

    public Curso() {
    }

    public Curso(int id, int creditos, int nivel, String nombre, int facultadID) {
        this.id = id;
        this.creditos = creditos;
        this.nivel = nivel;
        this.nombre = nombre;
        this.facultadID = facultadID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFacultadID() {
        return facultadID;
    }

    public void setFacultadID(int facultadID) {
        this.facultadID = facultadID;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", creditos=" + creditos + ", nivel=" + nivel + ", nombre=" + nombre + ", facultadID=" + facultadID + '}';
    }
    
    
}
