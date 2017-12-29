package news.leizhao.com.library.model.entity;

import java.io.Serializable;

/**
 * Title:Student
 * <p>
 * Description:学生实体
 * </p>
 * Author 雷钊
 * Date 2017/12/28 17:12
 */
public class Student implements Serializable {


    public Student() {
    }

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public int studentId;
    public String name;
    public int age;
    public String className;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
