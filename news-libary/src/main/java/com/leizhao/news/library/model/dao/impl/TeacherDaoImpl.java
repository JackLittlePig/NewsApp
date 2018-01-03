package com.leizhao.news.library.model.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.leizhao.news.library.model.dao.ITeacherDAO;
import com.leizhao.news.library.model.db.helper.SysDBHelper;
import com.leizhao.news.library.model.db.sql.SQLiteCommand;
import com.leizhao.news.library.model.entity.Teacher;

/**
 * Title: TeacherDaoImpl
 * <p>
 * Description: 教师 dao 的实现类
 * </p>
 * Author 雷钊
 * Date 2017/12/29 13:56
 */
public class TeacherDaoImpl implements ITeacherDAO {

    private static final String TAG = TeacherDaoImpl.class.getSimpleName();

    protected SysDBHelper mDBHelper;


    public TeacherDaoImpl(Context context) {
        mDBHelper = new SysDBHelper(context);
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        Log.d(TAG, "insertTeacher");
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("name", teacher.name);
            cv.put("age", teacher.age);
            cv.put("gender", teacher.gender);
            db.insert(SQLiteCommand.TEACHER_TABLE_NAME, null, cv);
            db.close();
        } catch (Exception e) {
            db.close();
        }
    }

    @Override
    public List<Teacher> queryAllTeacher() {
        Log.d(TAG,"queryAllTeacher()");

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.query(
                SQLiteCommand.TEACHER_TABLE_NAME
                , new String[]{"teacherId", "name", "age", "gender"}  //查询的列
                , null          //查询条件 如:name = ?
                , null      //查询条件的值  如 张三
                , null
                , null
                , null);

        List<Teacher> teachers = new ArrayList<>();
        while (cursor.moveToNext()) {
            Teacher student = new Teacher();
            student.teacherId = cursor.getInt(cursor.getColumnIndex("teacherId"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.gender = cursor.getInt(cursor.getColumnIndex("gender"));
            teachers.add(student);
        }
        db.close();
        Log.v(TAG, "查询所有教师列表 success students =" + teachers.toString());
        return teachers;
    }
}
