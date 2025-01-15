package model;

public class Produkt implements Comparable {
    String name;
    int preis;
    String jahreszeit;

    public Produkt(String name, int preis, String jahreszeit) {
        this.name = name;
        this.preis = preis;
        this.jahreszeit = jahreszeit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getJahreszeit() {
        return jahreszeit;
    }

    public void setJahreszeit(String jahreszeit) {
        this.jahreszeit = jahreszeit;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", jahreszeit='" + jahreszeit + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getPreis() - ((Produkt) o).getPreis();
    }
}
