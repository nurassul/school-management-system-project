package entities;

import java.util.Objects;

public class Student extends Person{

    // specific fields of class
    private double gpa;
    private String group;

    private Student(StudentBuilder builder) {
        super(builder.id, builder.firstName, builder.lastName, builder.age);
        this.gpa = builder.gpa;
        this.group = builder.group;
    }

    public boolean isExcellent() {
        return gpa >= 3.5;
    }

    @Override
    public String getRoleDetails() {
        return "Student: " + group + ", GPA: " + gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Student" + " | GPA: " + gpa + " | group: " + group;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gpa, group);
    }

    public static class StudentBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private int age;

        private double gpa;
        private String group;

        public StudentBuilder id(int id){
            this.id = id;
            return this;
        }

        public StudentBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }

        public StudentBuilder gpa(double gpa){
            this.gpa = gpa;
            return this;
        }

        public StudentBuilder group(String group){
            this.group = group;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
