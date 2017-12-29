package news.leizhao.com.library.db.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import news.leizhao.com.library.db.dao.IStudentDAO;
import news.leizhao.com.library.db.helper.SysDBHelper;
import news.leizhao.com.library.db.model.Student;
import news.leizhao.com.library.db.sql.SQLiteCommand;
import news.leizhao.com.library.db.utils.StringUtils;

/**
 * Title:StudentDaoImpl
 * <p>
 * Description: 学生数据Dao 实现类
 * </p>
 * Author 雷钊
 * Date 2017/12/28 17:14
 */
public class StudentDaoImpl implements IStudentDAO {

    private static final String TAG = StudentDaoImpl.class.getSimpleName();

    protected SysDBHelper mDBHelper;

    public StudentDaoImpl(Context context) {
        mDBHelper = new SysDBHelper(context);
    }

    @Override
    public void addStudent(Student student) {
        Log.d(TAG, "addStudent()");
        if (student == null) {
            return;
        }

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", student.name);
        contentValues.put("age", student.age);
        contentValues.put("classname", student.className);
        db.insert(SQLiteCommand.STUDUENT_TABLE_NAME, null, contentValues);
        db.close();

        Log.v(TAG, "插入学生 success student =" + student.toString());
    }

    @Override
    public List<Student> queryAllStudent() {
        Log.d(TAG, "queryAllStudent()");


        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.query(
                SQLiteCommand.STUDUENT_TABLE_NAME
                , new String[]{"id", "name", "age", "classname"}  //查询的列
                , null          //查询条件 如:name = ?
                , null      //查询条件的值  如 张三
                , null
                , null
                , null);

        List<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.id = cursor.getInt(cursor.getColumnIndex("id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.className = cursor.getString(cursor.getColumnIndex("classname"));
            students.add(student);
        }
        db.close();
        Log.v(TAG, "查询所有学生列表 success students =" + students.toString());
        return students;
    }

    @Override
    public List<Student> queryStudentFromAge(int age) {
        Log.d(TAG, "queryStudentFromAge");
        if (age == -1) {
            return null;
        }

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.query(SQLiteCommand.STUDUENT_TABLE_NAME
                , new String[]{"id", "name", "age", "classname"}
                , "age = ?"
                , new String[]{String.valueOf(age)}
                , null
                , null
                , null
        );
        List<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.id = cursor.getInt(cursor.getColumnIndex("id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.age = cursor.getInt(cursor.getColumnIndex("age"));
            student.className = cursor.getString(cursor.getColumnIndex("classname"));
            students.add(student);
        }
        db.close();
        Log.v(TAG, "查询指定年龄学生列表 success students =" + students.toString());
        return students;
    }

    @Override
    public void updateStudentFromName(String name, String className) {
        Log.d(TAG, "updateStudentFromNmae()");
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(className)) {
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put("classname", className);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int update = db.update(SQLiteCommand.STUDUENT_TABLE_NAME, contentValues, "name = ?", new String[]{name});
        db.close();
        Log.v(TAG, "根据姓名,修改班级 success updateNums =" + update);
    }

    @Override
    public void deleteStudentFromName(String name) {
        Log.d(TAG, "deleteStudentFromName()");
        if (StringUtils.isEmpty(name)) {
            return;
        }
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        int delete = db.delete(SQLiteCommand.STUDUENT_TABLE_NAME, "name = ?", new String[]{name});
        db.close();
        Log.v(TAG, "根据姓名,删除学生 success deleteNums =" + delete);
    }


}
