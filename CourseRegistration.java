import java.util.Scanner;
public class CourseRegistration {
static Scanner sc = new Scanner(System.in);
static String[] courses = {
"Java Programming",
"Database Systems",
"Web Development",
"Data Structures"
};
static String[] days = {
"Monday",
"Monday",
"Tuesday",
"Tuesday"
};
static String[] times = {
"9:00-10:00",
"10:00-11:00",
"9:00-10:00",
"9:00-10:00"
};
static boolean[] registered = new boolean[4];
public static void main(String[] args) {
int choice;
do {
System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
System.out.println("1. View Courses");
System.out.println("2. Register Course");
System.out.println("3. View Timetable");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
if (choice == 1) {
viewCourses();
} 
else if (choice == 2) {
registerCourse();
} 
else if (choice == 3) {
viewTimetable();
} 
else if (choice == 4) {
System.out.println("Thank you!");
} 
else {
System.out.println("Invalid choice!");
}
} while (choice != 4);
}
static void viewCourses() {
System.out.println("\n----- AVAILABLE COURSES -----");
for (int i = 0; i < courses.length; i++) {
System.out.println((i + 1) + ". " + courses[i]);
System.out.println(" Day: " + days[i]);
System.out.println(" Time: " + times[i]);
}
}
static void registerCourse() {
viewCourses();
System.out.print("\nEnter course number: ");
int course = sc.nextInt();
if (course < 1 || course > 4) {
System.out.println("Invalid course number!");
return;
}
int index = course - 1;
if (registered[index]) {
System.out.println("Course already registered!");
return;
}
if (index == 1 && !registered[0]) {
System.out.println(
"Prerequisite required: Java Programming"
);
return;
}
if (index == 3 && !registered[0]) {
System.out.println(
"Prerequisite required: Java Programming"
);
return;
}
for (int i = 0; i < courses.length; i++) {
if (registered[i] &&
days[i].equals(days[index]) &&
times[i].equals(times[index])) {
System.out.println(
"Timetable clash with " + courses[i]
);
return;
}
}
registered[index] = true;
System.out.println(
courses[index] + " registered successfully!"
);
}
static void viewTimetable() {
System.out.println("\n----- MY TIMETABLE -----");
boolean found = false;
for (int i = 0; i < courses.length; i++) {
if (registered[i]) {
System.out.println(
courses[i] + " | " +
days[i] + " | " +
times[i]
);
found = true;}
}
if (!found) {
System.out.println("No courses registered.");
}
}
}
