public class Student {
    private String name;
    private int grade;
    private String className;
    Student(String name,String className,int grade){
    this.name=name;
    this.className=className;
    this.grade=grade;
}

    public String getClassName() {
        return className;
    }
    public String getName(){
        return name;
    }

    public int getGrade() {
        return grade;
    }
    @Override
    public String toString(){return "name: "+name+" className: "+className+" grade: "+grade+"\n";}
}
