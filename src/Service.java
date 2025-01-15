import model.Kunde;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Service {

    private Repository<Kunde> kundeRepository;
    private Repository<Produkt> produktRepository;

    public Service(Repository<Kunde> kundeRepository, Repository<Produkt> produktRepository) {
        this.kundeRepository = kundeRepository;
        this.produktRepository = produktRepository;
    }

    public List<Kunde> alleKundenZuruckgeben() {
        return kundeRepository.getAllElements();
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    public void createAProdukt(String name,int preis, String jahreszeit){
        produktRepository.addElement(new Produkt(name,preis,jahreszeit));
    }

    public Produkt getProdukt(String name){
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    public void updateProdukt(Produkt produkt){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPreis(produkt.getPreis());
                p.setJahreszeit(produkt.getJahreszeit());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    public void deleteProdukt(String name){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createAKunde(String name, String ort){
        int id = -1;
        for (Kunde k : kundeRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        kundeRepository.addElement(new Kunde(id,name,ort,new ArrayList<>()));
    }

    public Kunde getKunde(int id){
        for (Kunde p : kundeRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Kunde nicht gefunden");
    }

    public void updateKunde(Kunde kunde){
        for (Kunde p : kundeRepository.getAllElements()){
            if (p.getId() == kunde.getId()){
                int index = kundeRepository.getAllElements().indexOf(p);
                p.setName(kunde.getName());
                p.setOrt(kunde.getOrt());
                kundeRepository.updateElement(index,p);
                break;
            }
        }
    }

    public void deleteKunde(int id){
        for (Kunde p : kundeRepository.getAllElements()){
            if (p.getId() == id){
                kundeRepository.remove(p);
                break;
            }
        }
    }


    public List<Kunde> filterNachOrt(String ort){
        List<Kunde> kundeList = new ArrayList<>();
        kundeList = kundeRepository.getAllElements().stream().filter(kunde -> ort.equals(kunde.getOrt())).toList();

        return kundeList;
    }

    public List<Kunde> filterNachProduktJahreszeit(String jahreszeit){
        List<Kunde> kundeList = new ArrayList<>();

        return kundeRepository.getAllElements().stream().filter(kunde -> kunde.richtigeJahreszeit(jahreszeit)).toList();
    }

    public List<Produkt> nachPreissortierteProdukteEinesKunden(int id,String sortierModus){
        Kunde kunde = new Kunde();
        for (Kunde p : kundeRepository.getAllElements()){
            if (p.getId() == id){
                kunde = p;
                break;
            }
        }

        List<Produkt> produktList = kunde.getListeProdukte();

        produktList.sort(Produkt::compareTo);

        if (sortierModus.equals("Steigend"))
            return produktList;
        else
        {
            return produktList;
        }
    }
}
