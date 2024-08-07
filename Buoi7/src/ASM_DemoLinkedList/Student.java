package ASM_DemoLinkedList;

public class Student {
    int id;
    String name;
    double marks;
    int age;
    String rank;
    Student next; // Add this field to store the address of the next student in the list

    public Student(int id, String name, double marks, int age) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;
        this.rank = calculateRank(marks);
        this.next = null; // Initially there were no follow-up students.
    }

    public String calculateRank(double marks) {
        if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else {
            return "Fail";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Age: " + age + ", Rank: " + rank;
    }

    // Getters and setters (if needed) for next field
    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }
}

