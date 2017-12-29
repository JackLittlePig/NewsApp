package com.leizhao.news;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import java.util.List;

import news.leizhao.com.library.model.dao.ITeacherDAO;
import news.leizhao.com.library.model.dao.impl.TeacherDaoImpl;
import news.leizhao.com.library.model.entity.Teacher;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author 雷钊
 * Date 2017/12/29 14:25
 */
public class TeacherDaoTest {


    private static final String TAG = "TeacherDao";

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
     * 测试-教师列表查询
     */
    @Test
    public void testQueryTeacher() {
        Log.d(TAG, "testQueryTeacher()");


        Context appContext = InstrumentationRegistry.getTargetContext();

        ITeacherDAO dao = new TeacherDaoImpl(appContext);
        List<Teacher> teachers = dao.queryAllTeacher();

    }
}
