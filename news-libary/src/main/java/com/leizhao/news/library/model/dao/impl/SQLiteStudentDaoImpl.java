package com.leizhao.news.library.model.dao.impl;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.leizhao.news.library.model.db.sql.SQLiteCommand;
import com.leizhao.news.library.model.entity.Student;

/**
 * Title:SQLiteStudentDaoImpl
 * <p>
 * Description: 学生数据Dao 实现类 (全部用SQLite Command 实现)
 * </p>
 * Author 雷钊
 * Date 2017/12/29 10:38
 */
public class SQLiteStudentDaoImpl extends StudentDaoImpl {


    private static final String TAG = SQLiteStudentDaoImpl.class.getSimpleName();

    public SQLiteStudentDaoImpl(Context context) {
        super(context);
    }

    @Override
    public List<Student> queryStudentFromAge(int age) {
        Log.d(TAG, "queryStudentFromAge");
        if (age == -1) {
            return null;
        }

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(SQLiteCommand.QUERY_STUDENT_FROM_AGE
                , new String[]{String.valueOf(age)}

        );
        List<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.studentId = cursor.getInt(cursor.getColumnIndex("id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
//            student.classId = cursor.getString(cursor.getColumnIndex("classname"));
//            student.teacherId = cursor.getString(cursor.getColumnIndex("classname"));
            students.add(student);
        }
        return students;
    }
}
