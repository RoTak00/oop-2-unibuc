package lab2;

import java.util.Objects;

public class Angajat {
    private String nume;
    private String prenume;
    private int anulAngajarii;
    private int salary;
    private Departament departament;

    public Angajat(String nume, String prenume, int anulAngajarii, int salary, Departament departament) {
        this.nume = nume;
        this.prenume = prenume;
        this.anulAngajarii = anulAngajarii;
        this.salary = salary;
        this.departament = departament;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getAnulAngajarii() {
        return anulAngajarii;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament.stergeAngajat(this);
        this.departament = departament;
        departament.adaugaAngajat(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Angajat angajat = (Angajat) obj;
        return anulAngajarii == angajat.anulAngajarii && salary == angajat.salary &&
                Objects.equals(nume, angajat.nume) && Objects.equals(prenume, angajat.prenume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, anulAngajarii, salary);
    }
}
