package lab1;

public class Person {
    private String firstName;
    private String lastName;
    private final String personalNumericalCode;

    Person(String firstName, String lastName, String personalNumericalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumericalCode = personalNumericalCode;
    }

    // Firstname
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Lastname
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // CNP
    public String getPersonalNumericalCode() {
        return personalNumericalCode;
    }

}
