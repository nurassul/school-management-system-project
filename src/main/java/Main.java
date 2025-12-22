import data.DataLoader;
import entities.School;
import entities.SchoolType;
import entities.Student;
import entities.Teacher;
import service.SchoolService;

public class Main {

    public static void main(String[] args) {

        SchoolService service = new SchoolService();

        School schoolHighSchool = School.builder()
                .name("V.Tereshkova Secondary School")
                .address("city Esik, Abai 12")
                .schoolType(SchoolType.HIGH_SCHOOL)
                .rating(3.2)
                .build();
        School liceum = School.builder()
                .name("#1 Liceum Almaty")
                .address("city Almaty, Satpaeva 12")
                .schoolType(SchoolType.LICEUM)
                .rating(4.5)
                .build();
        School gymnasium = School.builder()
                .name("Best Gymnasium of Astana")
                .address("city Astana")
                .schoolType(SchoolType.GYMNASIUM)
                .rating(5)
                .build();

        System.out.println("================");
        DataLoader.loadData(schoolHighSchool, service);
        System.out.println("================");
        DataLoader.loadData(liceum, service);
        System.out.println("================");
        DataLoader.loadData(gymnasium, service);
        System.out.println("================");

        // filter
        System.out.println("Students with gpa >= 2.5 in HighSchool");
        service.showStudentWithFilterGPA(schoolHighSchool, 2.5);
        System.out.println("================");

        System.out.println("Teacher with PHD");
        service.showTeacherWithFilterDegree(liceum, "PHD");
        System.out.println("Teacher with Master");
        service.showTeacherWithFilterDegree(gymnasium, "Master");
        System.out.println("================");

        // sorting
        System.out.println("Sorted students by age");
        service.sortStudentsByAge(schoolHighSchool);
        System.out.println("================");

        // finding
        System.out.println("Finding student with id 5");
        Student s = service.findStudentByIdInSchool(gymnasium, 5);
        System.out.println(s);

        System.out.println("Finding teacher Calculus");
        Teacher t = service.findTeacherBySubject(liceum, "Calculus");
        System.out.println(t);

        service.printFullInfoSchool(gymnasium);

    }

}
