package com.assigmentOne;

import java.util.ArrayList;
public class Student {
	private String name;
	private int studentId;
	private int age;
	private ArrayList<Double> marks;

	public Student(String name, int studentId, int age) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.age = age;
		this.marks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Double> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Double> marks) {
		this.marks = marks;
	}

	public void addMark(double mark) {
		if (mark >= 0 && mark <= 100) {
			marks.add(mark);
		} else {
			System.out.println("Invalid mark re enter number between 0-100");
		}

	}

	public double calculateAverage() {
		if (marks.isEmpty()) {
			return 0.0;
		}
		double sum = 0;
		for (Double m : marks) {
			sum += m;
		}
		return sum / marks.size();
	}

	public String calculateGrade() {
		double avg = calculateAverage();

		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

}
