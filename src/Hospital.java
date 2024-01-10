import java.util.HashMap;
import java.util.Map;

public class Hospital {
    public Map<Medecin, ListPatients> mapHospital;

    public Hospital(){
        mapHospital = new HashMap<>();
    }
    public void ajoutermedecin(Medecin m ){
        mapHospital.put(m, new ListPatients());
    }
    public void ajouterPatient(Medecin m,Patient p){
        if(mapHospital.containsKey(m)){
            mapHospital.get(m).ajouterPatient(p);
        }else {
            ajoutermedecin(m);
            mapHospital.get(m).ajouterPatient(p);
        }
    }
    public void afficherMap(){
        mapHospital.keySet().forEach(m -> {
            System.out.println(m);
            mapHospital.get(m).afficherPatients();
        });
    }

    public void afficherMedcinPatients (){
        mapHospital.keySet().stream().filter(e -> e.getNom().equals("mohamed")).forEach(o -> {
            System.out.println(o);
            mapHospital.get(o).afficherPatients();
        });
    }
}
