package tema8;

import repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();

        Student s1=new Student("Ana", "Ionescu", LocalDate.of(2001,12,06),"f","120");
        repo.add(s1);

        Student s2= new Student("Iulian","Petru", LocalDate.of(1997,04,23),"M","121");
        repo.add(s2);

        Student s3= new Student("Mariana", "Georgica", LocalDate.of(2001,12,06),"Female","122");
        repo.add(s3);

        System.out.println("Students sorted by age 24");
        List<Student> byAge = repo.getStudentsAge("24");
        byAge.forEach(System.out::println);

        System.out.println("Students sorted by name");
        repo.listStudentsSorted("lastname").forEach(System.out::println);

        System.out.println("Students sorted by ID 122");
        repo.delete("122");
    }
}