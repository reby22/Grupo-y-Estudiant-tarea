import java.util.Objects;

class Student {
    private final String name;
    private final String lastName;
    private final String code;


    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }


    public String getName(){
        return name;
    }

    public  String getLastName(){
        return lastName;
    }

    public  String getCode(){
        return code;
    }
}

class Group {

    private final String code;
    private final Student[] students;
    private int enrolled;
    private int rejected;

    public Group(String code,int capacity){
        this.code = code;
        students = new Student[capacity];
    }

    public boolean addStudent(Student student){
        if(enrolled < students.length){
            students[enrolled] = student;
            enrolled++;
            xaccepted(student);
            return true;
        }
        else{
            rejected++;
            xrejected(student);
            return false;
        }
    }

    public void xaccepted(Student student){
        System.out.println("Estudiante Aceptado: "+ student.getCode() + " -> " + student.getName() + " " + student.getLastName());
    }

    public void xrejected(Student student){
        System.out.println("Estudiante Rechazado: "+ student.getCode() + " -> " + student.getName() + " " + student.getLastName());
    }

    public int getEnrolled(){
        return enrolled;
    }

    public String getCode(){
        return code;
    }

    public int getRejected(){
        return rejected;
    }

    public void removeStudent(String code) {
        int i;

        for(i=0; i<enrolled && !Objects.equals(students[i].getCode(), code); i++);

        if(i != enrolled){
            if (enrolled - 1 - i >= 0) System.arraycopy(students, i + 1, students, i, enrolled - 1 - i);
            enrolled--;
        }
        else
            System.out.println("No se encontró el código: "+code);
    }

    public void printGroup(){
        int i;
        System.out.println("Estudiantes del grupo: "+this.code);
        for(i=0; i<enrolled; i++)
            System.out.println(students[i].getCode()+" "+students[i].getName()+" "+students[i].getLastName());
    }
}

public class Main {

    public static void main(String[] args) {

        Student student1; // Referencia a un Alumno
        Student student2 = new Student("Ivan", "Uresti", "972196");
        student1 = new Student("José", "González", "456789"); // Creando un objeto alumno

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);


        if (!group.addStudent(student1)) {
            System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastName());
        }

        if (!group.addStudent(student2)) {
            System.out.println("Estudiante no fue añadido: " + student2.getName() + " " + student2.getLastName());
        }

        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group2.addStudent(new Student("Misael", "Cabrera", "5"));
        group2.addStudent(new Student("Roberto", "Cisneros", "6"));
        group.addStudent(new Student("Juan", "Coronado", "7"));
        group.addStudent(new Student("José", "González", "8"));
        group.addStudent(new Student("Jesús", "Lara", "9"));
        group.addStudent(new Student("José", "Limón", "10"));
        System.out.println();

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        System.out.println();
        group.printGroup();
        System.out.println();
        group2.printGroup();
        System.out.println();
    }
}