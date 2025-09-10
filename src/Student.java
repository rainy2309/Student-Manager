public class Student{
    private String name;
    private int id;
    private int age;
    private double gpa;

    // cons
    public Student(String name, int id, int age, double gpa){
        this.name=name;
        this.id=id;
        this.age=age;
        this.gpa=gpa;
    }

    public Student(int id, String name, int age) {
        this.id=id;
        this.age=age;
        this.name=name;
        this.age=age;
    }

    //getset


    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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