package entities;

import java.util.Objects;

public class Teacher {


    private String firstName;
    private String lastName;
    private String subject;
    private String position;
    private String degree;

    public Teacher() {
    }

    public void printTeacherInfo() {
        System.out.println(firstName + " " + lastName + ", subject: " + subject + " position: " + position + " degree: " + degree);
    }

    public Teacher(String firstName, String lastName, String subject, String position, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.position = position;
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, subject, position, degree);
    }
}
