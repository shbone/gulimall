import com.demoutils.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: SunHB
 * @createTime: 2023/05/10 上午9:09
 * @description:
 */
public class streamArrayList {
    public List<Student> studentList = new ArrayList<Student>();
    public List<Student> addStudent(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"name",10,"1","sss"));
        return studentList;
    }

    public static void main(String[] args) {
        streamArrayList streamArrayList = new streamArrayList();
        List<?> list=streamArrayList.addStudent();
        list.forEach(item -> System.out.println(item));

    }
}
