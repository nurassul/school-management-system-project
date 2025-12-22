package entities;

import java.util.Objects;

public class Teacher extends Person{

    // specific fields of class
    private String subject;
    private String position;
    private String degree;

    private Teacher(TeacherBuilder builder) {
        super(builder.id, builder.firstName, builder.lastName, builder.age);
        this.subject = builder.subject;
        this.position = builder.position;
        this.degree = builder.degree;
    }

    @Override
    public String getRoleDetails() {
        return "Teacher: " + subject + ", position: " + position + ", degree: " + degree;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Teacher" + " | Subject: " + subject + " | position: " + position + " | degree: " + degree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subject, teacher.subject) && Objects.equals(position, teacher.position) && Objects.equals(degree, teacher.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, position, degree);
    }

    public static class TeacherBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private int age;

        private String subject;
        private String position;
        private String degree;


        public TeacherBuilder id(int id){
            this.id = id;
            return this;
        }

        public TeacherBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public TeacherBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public TeacherBuilder age(int age){
            this.age = age;
            return this;
        }

        public TeacherBuilder subject(String subject){
            this.subject = subject;
            return this;
        }

        public TeacherBuilder position(String position){
            this.position = position;
            return this;
        }

        public TeacherBuilder degree(String degree){
            this.degree = degree;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
