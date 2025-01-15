package model;

import java.util.List;

public class Kunde {
    int id;
    String name;
    String ort;
    List<Produkt> listeProdukte;

    public Kunde(int id, String name, String ort, List<Produkt> listeProdukte) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.listeProdukte = listeProdukte;
    }

    public Kunde() {}

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

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Produkt> getListeProdukte() {
        return listeProdukte;
    }

    public void setListeProdukte(List<Produkt> listeProdukte) {
        this.listeProdukte = listeProdukte;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                ", listeProdukte=" + listeProdukte +
                '}';
    }

    public boolean richtigeJahreszeit(String jahresZeit){
        for (Produkt p : this.listeProdukte) {
            if (p.getJahreszeit().equals(jahresZeit)) {
                return true;
            }
        }
        return false;
    }

}
