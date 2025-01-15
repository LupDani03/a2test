import model.Kunde;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Kunde CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleKundenAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Kunde hinzufugen
                            2. Alle Kunden sehen
                            3. Einen bestimmten Kunden finden
                            4. Einen Kunden aktualisieren
                            5. Einen Kunden loschen
                            6. Kunden nach Ort filtrieren
                            7. Kunden finden, die ein Produkt in einer gegebenen Jahreszeit gekauft haben
                            8. Sortiere Produkte eines Kunden nach Preis
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createKunde(); break;}
                        case 2: {controller.alleKundenAnschreiben(); break;}
                        case 3: {controller.showKunde(); break;}
                        case 4: {controller.updateKundeValidate(); break;}
                        case 5: {controller.deleteKunde(); break;}
                        case 6: {controller.kundenNachOrtFiltrieren(); break;}
                        case 7: {controller.kundenNachProduktjahreszeitFiltrieren(); break;}
                        case 8: {controller.produkteEinesKundenNachPreisSortieren(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Kunde> kundeRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(kundeRepository,produktRepository);

        Service service = new Service(kundeRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Kunde> kundeRepository, Repository<Produkt> produktRepository) {
        Produkt produkt1 = new Produkt("50kg Dumbbell",400,"Fruhling");
        Produkt produkt2 = new Produkt("25kg Dumbbell",200,"Fruhling");
        Produkt produkt3 = new Produkt("10kg Dumbbell",100,"Sommer");
        Produkt produkt4 = new Produkt("Handtuch",70,"Sommer");
        Produkt produkt5 = new Produkt("Proteindose",150,"Herbst");
        Produkt produkt6 = new Produkt("Carbohydratpaket",200,"Winter");
        Produkt produkt7 = new Produkt("Wasserflasche",100,"Winter");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);
        produktRepository.addElement(produkt6);
        produktRepository.addElement(produkt7);

        List<Produkt> listeKunde1 = new ArrayList<>();
        listeKunde1.add(produkt1); listeKunde1.add(produkt3); listeKunde1.add(produkt4);
        Kunde kunde1 = new Kunde(1,"Kevin","Lituanien",listeKunde1);

        List<Produkt> listeKunde2 = new ArrayList<>();
        listeKunde2.add(produkt2); listeKunde2.add(produkt6);
        Kunde kunde2 = new Kunde(2,"Maria","Polen",listeKunde2);

        List<Produkt> listeKunde3 = new ArrayList<>();
        listeKunde3.add(produkt3); listeKunde3.add(produkt5);
        Kunde kunde3 = new Kunde(3,"Markus","Amerika",listeKunde3);

        List<Produkt> listeKunde4 = new ArrayList<>();
        listeKunde3.add(produkt1); listeKunde3.add(produkt5);
        Kunde kunde4 = new Kunde(3,"Aurelius","Amerika",listeKunde4);

        kundeRepository.addElement(kunde1);
        kundeRepository.addElement(kunde2);
        kundeRepository.addElement(kunde3);
        kundeRepository.addElement(kunde4);
    }
}
