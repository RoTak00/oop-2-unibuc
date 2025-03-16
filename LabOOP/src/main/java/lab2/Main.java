package lab2;

public class Main {
    public static void main(String[] args) {
        // Creare departamente in companie
        Departament dTehnic = new Departament("Tehnic");
        Departament dHR = new Departament("Resurse Umane");
        Departament dEvenimente = new Departament("Evenimente");

        ManagementService service = ManagementService.getInstance();

        // Inregistrare angajati
        service.inregistreazaAngajat(new Angajat("Popescu", "Mihai", 2018, 6500, dTehnic));
        service.inregistreazaAngajat(new Angajat("Ionescu", "Andreea", 2020, 5000, dHR));
        service.inregistreazaAngajat(new Angajat("Dumitrescu", "George", 2017, 7000, dTehnic));
        service.inregistreazaAngajat(new Angajat("Stan", "Elena", 2019, 4800, dHR));
        service.inregistreazaAngajat(new Angajat("Radu", "Alexandru", 2021, 5500, dEvenimente));
        service.inregistreazaAngajat(new Angajat("Mocanu", "Cristina", 2016, 7300, dTehnic));
        service.inregistreazaAngajat( new Angajat("Voinea", "Daniel", 2015, 7800, dTehnic));
        service.inregistreazaAngajat(new Angajat("Bălan", "Laura", 2022, 4600, dHR));
        service.inregistreazaAngajat(new Angajat("Preda", "Florin", 2023, 5100, dEvenimente));
        service.inregistreazaAngajat(new Angajat("Enache", "Raluca", 2020, 5700, dEvenimente));

         //Modificare Departamente
        service.schimbaDepartament(dTehnic.getMembri().get(1), dHR); // Dumitrescu George
        service.schimbaDepartament(dHR.getMembri().get(0), dTehnic); // Ionescu Andreea


        // Modificare salarii
        service.schimbaSalariu(dTehnic.getMembri().get(0), 7000);  // Popescu Mihai
        service.schimbaSalariu(dEvenimente.getMembri().get(1), 5050); // Preda Florin


        service.afiseazaDepartamenteComplet();

        for(Departament dept : Departamente.lista)
        {
            service.afiseazaSalariuMediu(dept);
        }

    }
}
