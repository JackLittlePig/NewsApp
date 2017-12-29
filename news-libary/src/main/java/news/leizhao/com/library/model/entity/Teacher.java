package news.leizhao.com.library.model.entity;

import java.io.Serializable;

/**
 * Title:Teacher
 * <p>
 * Description: 教师实体
 * </p>
 * Author 雷钊
 * Date 2017/12/29 11:51
 */
public class Teacher implements Serializable {


    public String name;
    public int gender;
    public int age;
    public int teacherId;

    public Teacher( ) {
    }

    public Teacher(String name, int gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", teacherId=" + teacherId +
                '}';
    }
}
