package com.assigmentOne;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagemmentApp {

	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Student Management System");

		while (true) {

			System.out.println("1-> Add a new student");
			System.out.println("2-> Add a mark for a student");
			System.out.println("3-> Display all students");
			System.out.println("4-> Search for a student");
			System.out.println("5-> Show the student with highest average");
			System.out.println("6-> Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:

				System.out.println("Adding a student");

				System.out.print("Enter student name: ");
				String name = scanner.nextLine();
				if (name == null || name.isEmpty()) {
					System.out.println("Student name cannot be empty.");
					break;
				}
				System.out.print("Enter student ID: ");
				int studentId = scanner.nextInt();
				scanner.nextLine();

				boolean idExists = false;

				for (Student student : studentList) {
					if (student.getStudentId() == studentId) {
						idExists = true;
						break;
					}
				}

				if (idExists) {
					System.out.println("Student ID already exists!");
					break;
				}

				System.out.print("Enter student age: ");
				int age = scanner.nextInt();
				if (age < 0) {
					System.out.println("Age cannot be negative.");
					break;
				}
				scanner.nextLine();

				studentList.add(new Student(name, studentId, age));

				System.out.println("Student added successfully.");
				break;

			case 2:

				System.out.println("Adding a mark");

				System.out.print("Enter student ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();

				boolean found = false;

				for (Student student : studentList) {

					if (student.getStudentId() == id) {

						System.out.print("Enter mark: ");
						double mark = scanner.nextDouble();
						scanner.nextLine();

						student.addMark(mark);

						System.out.println("Mark added successfully.");
						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("Student not found.");
				}

				break;

			case 3:

				System.out.println("Displaying students");

				if (studentList.isEmpty()) {
					System.out.println("No students available.");
				} else {

					for (Student student : studentList) {

						System.out.println("--------------------------------");
						System.out.println("Name: " + student.getName());
						System.out.println("ID: " + student.getStudentId());
						System.out.println("Age: " + student.getAge());
						System.out.println("Marks: " + student.getMarks());
						System.out.println("Average: " + student.calculateAverage());
						System.out.println("Grade: " + student.calculateGrade());
					}
				}

				break;

			case 4:

				System.out.println("Searching student");

				System.out.print("Enter student ID: ");
				int searchId = scanner.nextInt();
				scanner.nextLine();

				found = false;

				for (Student student : studentList) {

					if (student.getStudentId() == searchId) {

						System.out.println("-----------info----------");
						System.out.println("Name: " + student.getName());
						System.out.println("ID: " + student.getStudentId());
						System.out.println("Age: " + student.getAge());
						System.out.println("Marks: " + student.getMarks());
						System.out.println("Average: " + student.calculateAverage());
						System.out.println("Grade: " + student.calculateGrade());

						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("Student not found.");
				}

				break;

			case 5:

				System.out.println("Student with highest average");

				if (studentList.isEmpty()) {

					System.out.println("No students available.");

				} else {

					Student highestStudent = studentList.get(0);

					for (Student student : studentList) {

						if (student.calculateAverage() > highestStudent.calculateAverage()) {
							highestStudent = student;
						}
					}

					System.out.println("--------------------------------");
					System.out.println("Name: " + highestStudent.getName());
					System.out.println("ID: " + highestStudent.getStudentId());
					System.out.println("Age: " + highestStudent.getAge());
					System.out.println("Marks: " + highestStudent.getMarks());
					System.out.println("Average: " + highestStudent.calculateAverage());
					System.out.println("Grade: " + highestStudent.calculateGrade());
				}

				break;

			case 6:

				System.out.println("Exiting... Thank you.");
				scanner.close();
				return;

			default:

				System.out.println("Invalid choice... please choose a valid number.");
			}
		}
	}
}