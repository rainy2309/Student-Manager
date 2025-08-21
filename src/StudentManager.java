import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }

    //add
    public void addStudent(Student s){
        students.add(s);
    }

    //delete
    public boolean removeStudent(String id){
        return students.removeIf(s -> s.getId().equals(id));
    }

    //find id
    public Student findStudent(String id){
        for(Student s: students){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    //print all
    public void printAll(){
        if(students.isEmpty()){
            System.out.println("Empty!!!");
        }else{
            for(Student s: students){
                System.out.println(s);;
            }
        }
    }

    public void sortByGPA() {
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa).reversed());
    }
}
