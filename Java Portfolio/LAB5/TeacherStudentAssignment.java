public class TeacherStudentAssignment {
    public static void main(String[] args) {
        Student student1 = new Student("Elijah", 20, "Male", 2026);
        Course subject1 = new Course("MATH1A", "Analytic Geometry");
        Course subject2 = new Course("GNED2", "Ethics");
        Course[] teacherCourses = { subject1, subject2 };
        Teacher teacher1 = new Teacher("Sir Justine May", 32, "Male", "Mathematics Department", teacherCourses);

        System.out.println("**** STUDENT DETAILS ****");
        student1.displayStudent();
        System.out.println("");
        System.out.println("**** TEACHER DETAILS ****");
        teacher1.displayTeacher();
        System.out.println("");
        System.out.println("**** COURSE DETAILS ****");
        subject1.displayCourse();
    }
}

class Person {
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void displayInfo() {
        System.out.println("NAME: " + name);
        System.out.println("AGE: " + age);
        System.out.println("GENDER: " + gender);
    }
}

class Student extends Person {
    int studentId;

    Student(String name, int age, String gender, int studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    void displayStudent() {
        displayInfo();
        System.out.println("STUDENT ID: " + studentId);
    }
}

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    void displayCourse() {
        System.out.println("COURSE CODE: " + code);
        System.out.println("COURSE TITLE: " + title);
    }
}

class Teacher extends Person {
    String department;
    Course[] subjects;

    Teacher(String name, int age, String gender, String department, Course[] subjects) {
        super(name, age, gender);
        this.department = department;
        this.subjects = subjects;
    }

    void displayTeacher() {
        displayInfo();
        System.out.println("DEPPARTMENT: " + department);
        System.out.println("SUBJECTS HANDLED:");
        if (subjects != null && subjects.length > 0) {
            for (Course sub : subjects) {
                sub.displayCourse();
            }
        } else {
            System.out.println("No courses assigned.");
        }
    }
}
