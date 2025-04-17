package tema8;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate birthDate, String gender, String id) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if (birthDate == null ||birthDate.getYear()<1900|| birthDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("birthDate must be greater than or equal to 18");
        }
        if (gender == null || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("unknown")) {
            throw new IllegalArgumentException("gender cannot be null or empty");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be null or empty");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getGender() {
        return gender;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @override
    public String toString(){
        return firstName+" "+lastName+" "+id;
    }
}
