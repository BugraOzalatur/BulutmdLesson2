import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*bildiğin e-okul sonrasında sırala
*
*
*
* */
public class Main {
    public static void main(String[] args) {

        List<Student> studentList=new ArrayList<>();
        studentList.add((new Student("selami","bse",39)));

        studentList.add((new Student("hera3","bbsyor",120)));
        studentList.add((new Student("hera","bbsyor",110)));
        studentList.add((new Student("hera2","bbsyor",120)));
        studentList.add((new Student("hera4","bbsyor",25)));

        studentList.add((new Student("ra3","besyor",39)));
        studentList.add((new Student("ra","besyor",39)));
        studentList.add((new Student("ra2","besyor",99)));

        studentList.add((new Student("athena2","aalsyor",36)));
        studentList.add((new Student("athena","aalsyor",10)));

        studentList.add((new Student("zeus3","ffsyor",49)));
        studentList.add((new Student("zeus","ffsyor",89)));
        studentList.add((new Student("zeus21","ffsyor",69)));



        //a şıkkı
        var forClassname=studentList.stream()
                .sorted(Comparator.comparing(Student::getClassName)).toList();
        System.out.println("A)sınıf adına göre gruplanmış: "+forClassname

        +"\n");

        //burada
      /*  System.out.println("A)sınıf adına göre gruplanmış: "+studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getClassName
                ))

                +"\n");
                böylede olabilir
                 ffsyor=[name: zeus className: ffsyor grade: 59
                  ], absyor=[name: loki className: absyor grade: 88
                    , name: lok3i className: absyor grade: 78
],
                */

        //b  şıkkı

        var forGradeClass=studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getClassName,
                        Collectors.maxBy(Comparator.comparing(Student::getGrade))
                ));
        System.out.println("b şıkkı : "+forGradeClass



        );


        //c şıkkı

         var selam=studentList.stream()
                 .map(Student::getGrade)
                         .max(Integer::compare);


        System.out.println("C) en yüksek notu alan kişi(ler):"+studentList.stream()
                .filter(student->student.getGrade() == selam.get()).toList() );

        //.get() value alıyor ctrl+sağ tık
        //d şıkkı
        var aboveSeventy=studentList.stream()
                .filter(student->student.getGrade()>=70)
                .sorted(Comparator.comparing(Student::getGrade).reversed()).toList()
        ;
        System.out.println("D)notları 70in üzerinde olan öğrenciler:\n "
        +aboveSeventy);

        //e şıkkı
        var forGrade=studentList.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed()).toList()
;
        System.out.println("E)notlara adına göre sıralanmış: "+studentList.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed()).toList()

                +"\n");

    }

}


