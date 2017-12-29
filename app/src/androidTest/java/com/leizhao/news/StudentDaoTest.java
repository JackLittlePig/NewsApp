package com.leizhao.news;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import news.leizhao.com.library.model.dao.IStudentDAO;
import news.leizhao.com.library.model.dao.ITeacherDAO;
import news.leizhao.com.library.model.dao.impl.StudentDaoImpl;
import news.leizhao.com.library.model.dao.impl.TeacherDaoImpl;
import news.leizhao.com.library.model.entity.Student;
import news.leizhao.com.library.model.entity.Teacher;

import static org.junit.Assert.assertEquals;

/**
 * Title:StudentDaoTest
 * <p>
 * Description:
 * </p>
 * Author 雷钊
 * Date 2017/12/29 11:13
 */
public class StudentDaoTest {

    private static final String TAG = StudentDaoTest.class.getSimpleName();


    private long startTime = 0;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.leizhao.news", appContext.getPackageName());
//        testAddStudent(appContext);
//        testQueryStudentFromAge(appContext, 100);
//        testUpdateStudentFromName(appContext);

//        testAddStudent(appContext);
        testQueryAllStudent(appContext);

        testAddTeacher();
    }



    /**
     * 测试-添加教师
     */
    @Test
    public void testAddTeacher() {
        Log.d(TAG, "testAddTeacher");

        Context appContext = InstrumentationRegistry.getTargetContext();

        ITeacherDAO dao = new TeacherDaoImpl(appContext);
        dao.insertTeacher(new Teacher("王老师", 1, 25));
        dao.insertTeacher(new Teacher("李老师", 0, 35));
        dao.insertTeacher(new Teacher("周老师", 1, 20));
        dao.insertTeacher(new Teacher("赵老师", 0, 22));
        dao.insertTeacher(new Teacher("钱老师", 1, 32));

    }

    /**
     * 测试 根据姓名,修改班级
     *
     * @param appContext
     */
    private void testUpdateStudentFromName(Context appContext) {
        Log.d(TAG, "=====================================================");

        startTime = new Date().getTime();
        IStudentDAO studentDao = new StudentDaoImpl(appContext);
        studentDao.updateStudentFromName("张三", "牛逼一班");
        // 计算查询时间
        countRunTime("修改学生信息");
        Log.d(TAG, "=====================================================");
    }


    /**
     * 根据年龄查询学生信息
     *
     * @param appContext
     * @param age
     */
    private void testQueryStudentFromAge(Context appContext, int age) {
        Log.d(TAG, "=====================================================");

        startTime = new Date().getTime();
        IStudentDAO studentDao = new StudentDaoImpl(appContext);
        List<Student> students = studentDao.queryStudentFromAge(age);
        // 计算查询时间
        countRunTime("查询指定年龄学生 " + students.size() + " 个");
        Log.d(TAG, "=====================================================");
    }


    /**
     * 测试  根据姓名,删除学生
     */
    private void testDeleteStudentFromAge(Context appContext, String name) {
        Log.d(TAG, "=====================================================");

        startTime = new Date().getTime();
        IStudentDAO studentDao = new StudentDaoImpl(appContext);
        studentDao.deleteStudentFromName(name);
        // 计算查询时间
        countRunTime(" 根据姓名,删除学生 ");
        Log.d(TAG, "=====================================================");
    }

    /**
     * 查询所有学生列表
     *
     * @param appContext
     */
    private void testQueryAllStudent(Context appContext) {
        Log.d(TAG, "=====================================================");

        startTime = new Date().getTime();
        StudentDaoImpl studentDao = new StudentDaoImpl(appContext);
        List<Student> students = studentDao.queryAllStudent();
        // 计算查询时间
        countRunTime("查询全部学生 " + students.size() + " 个");
        Log.d(TAG, "=====================================================");
    }

    /**
     * 测试 SQLite 数据库 ,添加学生
     *
     * @param appContext
     */
    private void testAddStudent(Context appContext) {
        Log.d(TAG, "=====================================================");
        startTime = new Date().getTime();
        int insertCount = 100;
        // 开始插入数据
        IStudentDAO studentDao = new StudentDaoImpl(appContext);
        for (int i = 0; i < insertCount; i++) {
//            studentDao.addStudent(new Student("张三", i, "大一(" + i + ")班"));
        }
        countRunTime("插入");
        Log.d(TAG, "=====================================================");
    }

    private void countRunTime(String tiemType) {
        long between = new Date().getTime() - startTime;
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
                - min * 60 * 1000 - s * 1000);


        String runTime = min + "分" + s + "秒" + ms + "毫秒";
        Log.d(TAG, "执行完成 "
                + tiemType
                + " 耗时:"
                + runTime);

//        System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒" + ms
//                + "毫秒");
    }


}
