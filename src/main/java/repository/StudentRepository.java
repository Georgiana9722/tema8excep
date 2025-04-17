package repository;

import exception.StudentNotFoundException;
import exception.ValidationException;
import tema8.Student;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StudentRepository {
    private final Map<String, Student> students = new HashMap<>();
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public void add(Student student) {
        if(students.containsKey(student.getId())){
            throw new ValidationException("Student with id " + student.getId() + " already exists");
        }
        students.put(student.getId(), student);
        logger.info("Added student " + student.getId() + " to repository");
    }

    public void delete(String id) {
        if(!students.containsKey(id)){
            throw new StudentNotFoundException("Student with id " + id + " does not exist");
        }
        if(id ==null || id.trim().isEmpty()){
            throw new ValidationException("ID cannot be null or empty");
        }
        students.remove(id);
        logger.info("Removed student " + id + " from repository");
    }

    public List<Student> getStudentsAge(String age1) {
        int age;
        try {
            int age = Integer.parseInt(age1);
        } catch (NumberFormatException e){
            throw new ValidationException("Age must be an integer");
        }
        if(age<0)
            throw new ValidationException("Age must be a positive integer");

        return students.values().stream().filter(student -> student.getAge() > age1).collect(Collectors.toList());
    }


    public List<Student> listStudentsSorted (String sort) {
        if (sort == null || sort.trim().isEmpty())
            throw new ValidationException("Sort cannot be null or empty");

        return students.values().stream().sorted((s1, s2) -> {
                    if (sort.equalsIgnoreCase("lastname"))
                        return s1.getLastName().compareTo(s2.getLastName());
                    else if (sort.equalsIgnoreCase("birthDate"))
                        return s1.getBirthDate().compareTo(s2.getBirthDate());
                    else
                        throw new ValidationException("Sort must be either 'lastname' or 'birthDate'");
                }
        ).collect(Collectors.toList());
    }
}
