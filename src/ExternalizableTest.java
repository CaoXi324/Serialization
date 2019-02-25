import java.io.*;

public class ExternalizableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student();
        student.setAge(27);
        student.setName("Tom");

        try (ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(new File("./Student.txt")))) {
            outputFile.writeObject(student); // write person to file
        }

        // deserializable
        // read file
        Student studentDeserializable;
        try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(new File("./Student.txt")))) {
            studentDeserializable = (Student) inputFile.readObject();
        }
        System.out.println(studentDeserializable.getName());


    }
}
