import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListPatients implements InterfacePatient{

    private List<Patient> listP;

    public ListPatients(){
       listP = new ArrayList<>();
    }


    @Override
    public void ajouterPatient(Patient p) {
        listP.add(p);
    }

    @Override
    public void supprimerPatient(Patient p) {
        listP.remove(p);
    }

    @Override
    public boolean rechercherPatient(Patient p) {
        return listP.stream().anyMatch(patient -> patient.equals(p));
    }

    @Override
    public boolean rechercherPatient(int cin) {
        return listP.stream().anyMatch(patient -> patient.getCin()==cin);
    }

    @Override
    public void afficherPatients() {
        listP.forEach(System.out::println);
    }

    @Override
    public void trierPatientsParNom() {
        listP.stream()
                .sorted(Comparator.comparing(Patient::getNom))
                .forEach(System.out::println);
    }

    public void PatientSansRedondance(){
        listP.stream().distinct().forEach(System.out::println);
    }
}
