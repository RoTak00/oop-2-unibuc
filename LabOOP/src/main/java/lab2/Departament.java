package lab2;

import java.util.ArrayList;
import java.util.List;

public class Departament {
    private final String numeDepartament;
    private int numarAngajati;
    private List<Angajat> membri = new ArrayList<>();

    public Departament(String numeDepartament) {
        this.numeDepartament = numeDepartament;
        this.numarAngajati = 0;
        Departamente.lista.add(this);
    }

    public String getNumeDepartament() {
        return numeDepartament;
    }

    public int getNumarAngajati()
    {
        return numarAngajati;
    }

    public void afiseazaAngajati() {

        System.out.println("--- ANGAJATI - " + numeDepartament + " ---");
        for (Angajat angajat : membri) {
            System.out.println(angajat.getNume() + " " + angajat.getPrenume());
        }
    }

    public void adaugaAngajat(Angajat angajat) {
        numarAngajati++;
        membri.add(angajat);
    }

    public void stergeAngajat(Angajat angajat) {
        membri.removeIf(a -> a.equals(angajat));
        numarAngajati = membri.size();
    }

    public List<Angajat> getMembri() {
        return membri;
    }

    public double getSalariuMediu() {
        if (membri.isEmpty()) return 0;
        int totalSalarii = 0;
        for (Angajat angajat : membri) {
            totalSalarii += angajat.getSalary();
        }
        return (double) totalSalarii / membri.size();
    }

}
