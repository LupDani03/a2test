import model.Kunde;
import model.Produkt;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleProdukteAnschreiben(){
        for (Produkt produkt: service.alleProdukteZuruckgeben())
            System.out.println(produkt);
    }
    public void alleKundenAnschreiben(){
        for (Kunde kunde: service.alleKundenZuruckgeben())
            System.out.println(kunde);
    }

    public void createProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Jahreszeit");
        String jahr = sc.nextLine();

        service.createAProdukt(name, preis, jahr);
    }

    public void showAProdukt(){
        System.out.println("Gebe den Namen des Produktes ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Produkt produkt = service.getProdukt(name);
        System.out.println(produkt);
    }

    public void updateProduktValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Jahreszeit:");
        String jahreszeit = sc.nextLine();

        service.updateProdukt(new Produkt(name, preis, jahreszeit));
    }

    public void deleteProdukt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Produktes, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteProdukt(name);
    }


    public void createKunde(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Ort: ");
        String ort = sc.nextLine();

        service.createAKunde(name,ort);
    }

    public void showKunde(){
        for (Kunde kunde: service.alleKundenZuruckgeben())
            System.out.println(kunde);

        System.out.println("ID des Kundes:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(service.getKunde(id));
    }

    public void updateKundeValidate(){
        Scanner sc = new Scanner(System.in);

        System.out.println("ID des Kundes, das geandert werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Neuer Name: ");
        String name = sc.nextLine();
        System.out.println("Neuer Ort: ");
        String ort = sc.nextLine();

        Kunde kunde = new Kunde(id,name,ort,new ArrayList<>());
        service.updateKunde(kunde);
    }

    public void deleteKunde(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Kunden, der geloescht werden soll: ");
        int id = sc.nextInt();
        sc.nextLine();
        service.deleteKunde(id);
    }

    public void kundenNachOrtFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ort: ");
        String ort = sc.nextLine();
        for (Kunde kunde: service.filterNachOrt(ort))
            System.out.println(kunde);
    }

    public void kundenNachProduktjahreszeitFiltrieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Jahreszeit: ");
        String jahreszeit = sc.nextLine();

        for (Kunde kunde: service.filterNachProduktJahreszeit(jahreszeit))
            System.out.println(kunde);
    }

    public void produkteEinesKundenNachPreisSortieren(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID des Kunden: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Steigend/Fallend sortieren:");
        String modus = sc.nextLine();

        for (Produkt produkt: service.nachPreissortierteProdukteEinesKunden(id, modus))
            System.out.println(produkt);
    }
}
