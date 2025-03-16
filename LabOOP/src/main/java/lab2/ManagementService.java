package lab2;

public class ManagementService {
    private static ManagementService instance;

    private ManagementService() {}

    public static ManagementService getInstance() {
        if (instance == null) {
            instance = new ManagementService();
        }
        return instance;
    }

    public void inregistreazaAngajat(Angajat angajat) {
        Departament departament = angajat.getDepartament();
        if (!departament.getMembri().contains(angajat)) {
            departament.adaugaAngajat(angajat);
        }
    }

    public void schimbaDepartament(Angajat angajat, Departament departament) {
        angajat.setDepartament(departament);
    }

    public void schimbaSalariu(Angajat angajat, int salariu) {
        angajat.setSalary(salariu);
    }

    public void afiseazaDepartamente() {
        for (Departament dep : Departamente.lista) {
            System.out.println(dep.getNumeDepartament());
        }
    }

    public void afiseazaDepartamenteComplet() {
        for (Departament dep : Departamente.lista) {
            System.out.println(" --- " + dep.getNumeDepartament() + " - " + dep.getNumarAngajati() + " membri ---");
            dep.afiseazaAngajati();
        }
    }

    public void afiseazaSalariuMediu(Departament departament) {
        System.out.println("Salariul mediu in " + departament.getNumeDepartament() + ": " + departament.getSalariuMediu());
    }
}