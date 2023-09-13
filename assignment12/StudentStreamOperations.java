package assignment12;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int yearOfEnrollment;
    private double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    // Getters for the fields

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {  //this allow to retrieve info about a student
        return yearOfEnrollment;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getPerTillDate() {
        return perTillDate;
    }
}


public class StudentStreamOperations {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );

    printDepartments(students);

    getStudentsEnrolledAfter2018(students);

    getMaleStudentsInComputerScience(students);
    countMaleAndFemaleStudents(students);
    calculateAverageAgeByGender(students);
    getHighestScoringStudent(students);
    countStudentsInEachDepartment(students);
    calculateAveragePercentageByDepartment(students);
    getYoungestMaleStudentInElectronic(students);
    countMaleAndFemaleStudentsInComputerScience(students);
}

    public static void printDepartments(List<Student> students) {
        Set<String> departments = students.stream()
                .map(Student::getEngDepartment)
                .collect(Collectors.toSet());

        System.out.println("Departments in the college: " + departments);
    }

    public static void getStudentsEnrolledAfter2018(List<Student> students) {
        List<String> namesEnrolledAfter2018 = students.stream()
                .filter(student -> student.getYearOfEnrollment() > 2018)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students enrolled after 2018: " + namesEnrolledAfter2018);
    }

    public static void getMaleStudentsInComputerScience(List<Student> students) {
        List<String> maleComputerScienceStudentNames = students.stream()
                .filter(student -> student.getGender().equals("Male"))
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Male students in Computer Science: " + String.join(", ", maleComputerScienceStudentNames));
    }

    public static void countMaleAndFemaleStudents(List<Student> students) {
        Map<String, Long> genderCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        System.out.println("Number of male students: " + genderCounts.get("Male"));
        System.out.println("Number of female students: " + genderCounts.get("Female"));
    }

    public static void calculateAverageAgeByGender(List<Student> students) {
        Map<String, Double> averageAgeByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        System.out.println("Average age of male students: " + averageAgeByGender.get("Male"));
        System.out.println("Average age of female students: " + averageAgeByGender.get("Female"));
    }

    public static void getHighestScoringStudent(List<Student> students) {
        Optional<Student> highestScoringStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getPerTillDate));

        highestScoringStudent.ifPresent(student ->
                System.out.println("Highest scoring student: " + student.getName() + " with percentage " + student.getPerTillDate()));
    }

    public static void countStudentsInEachDepartment(List<Student> students) {
        Map<String, Long> departmentCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));

        System.out.println("Number of students in each department: " + departmentCounts);
    }

    public static void calculateAveragePercentageByDepartment(List<Student> students) {
        Map<String, Double> averagePercentageByDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));

        System.out.println("Average percentage in each department: " + averagePercentageByDepartment);
    }

    public static void getYoungestMaleStudentInElectronic(List<Student> students) {
        Optional<Student> youngestMaleInElectronic = students.stream()
                .filter(student -> student.getGender().equals("Male"))
                .filter(student -> student.getEngDepartment().equals("Electronic"))
                .min(Comparator.comparingInt(Student::getAge));

        youngestMaleInElectronic.ifPresent(student ->
                System.out.println("Youngest male student in Electronic: " + student.getName() + " with age " + student.getAge()));
    }

    public static void countMaleAndFemaleStudentsInComputerScience(List<Student> students) {
        Map<String, Long> genderCountsInComputerScience = students.stream()
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        System.out.println("Number of male students in Computer Science: " + genderCountsInComputerScience.get("Male"));
        System.out.println("Number of female students in Computer Science: " + genderCountsInComputerScience.get("Female"));
    }
}
