package news.leizhao.com.library.db.model;

import java.io.Serializable;

/**
 * Title:Student
 * <p>
 * Description:高血压随访记录
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

    public int id;
    public String name;
    public int age;
    public String className;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
