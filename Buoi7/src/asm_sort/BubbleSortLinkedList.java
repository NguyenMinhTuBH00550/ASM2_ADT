package asm_sort;

import java.util.Scanner;

class Student {
    int id;
    String name;
    double score;
    Student next;

    Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.next = null;
    }
}

public class BubbleSortLinkedList {
    Student head;

    public void addStudent(int id, String name, double score) {
        Student newStudent = new Student(id, name, score);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
    }

    public void bubbleSort() {
        if (head == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Student current = head;
            while (current.next != null) {
                if (current.id > current.next.id) {
                    // Hoán đổi ID, tên và điểm
                    int tempId = current.id;
                    current.id = current.next.id;
                    current.next.id = tempId;

                    String tempName = current.name;
                    current.name = current.next.name;
                    current.next.name = tempName;

                    double tempScore = current.score;
                    current.score = current.next.score;
                    current.next.score = tempScore;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void display() {
        Student current = head;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Tên: " + current.name + ", Điểm: " + current.score);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        BubbleSortLinkedList list = new BubbleSortLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();

        System.out.println("Nhập thông tin các sinh viên (ID, Tên và Điểm):");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập ID của sinh viên " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Nhập tên của sinh viên " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Nhập điểm của sinh viên " + (i + 1) + ": ");
            double score = scanner.nextDouble();
            list.addStudent(id, name, score);
        }

        System.out.println("Danh sách sinh viên trước khi sắp xếp:");
        list.display();

        list.bubbleSort();

        System.out.println("Danh sách sinh viên sau khi sắp xếp theo ID:");
        list.display();
    }
}
