public class Student{
    private String name;
    private String id;
    private int age;
    private double gpa;

    // cons
    public Student(String name, String id, int age, double gpa){
        this.name=name;
        this.id=id;
        this.age=age;
        this.gpa=gpa;
    }

    //getset


    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

}