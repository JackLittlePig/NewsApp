package com.leizhao.news.library.model.entity;

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

    public Student(String name, int age, int teacherId, int classId) {
        this.name = name;
        this.age = age;
        this.teacherId = teacherId;
        this.classId = classId;
    }

    public int studentId;           // 学生id
    public String name;             // 学生姓名
    public int age;                 // 学生年龄
    public int teacherId;           // 教师id
    public int classId;             // 班级id

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacherId=" + teacherId +
                ", classId=" + classId +
                '}';
    }
}
