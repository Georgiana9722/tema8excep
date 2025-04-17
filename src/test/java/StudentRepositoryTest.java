package test;

import tema8.Student;
import repository.StudentRepository;

import java.time.LocalDate;

public class StudentRepositoryTest {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();

        Student s1 = new Student("Ana", "Ionescu", LocalDate.of(2001, 12, 06), "f", "120");
        Student s2 = new Student("Iulian", "Petru", LocalDate.of(1997, 4, 23), "M", "121");
        Student s3 = new Student("Mariana", "Georgica", LocalDate.of(2001, 12, 06), "Female", "122");

        repo.add(s1);
        repo.add(s2);
        repo.add(s3);

        System.out.println("Studenți cu vârsta 24:");
        repo.getStudentsAge("24").forEach(System.out::println);

        System.out.println(" \n Studenți sortați după nume:");
        repo.listStudentsSorted("lastName").forEach(System.out::println);

        System.out.println(" \n Șterg studentul cu ID 122...");
        repo.delete("122");
    }
}