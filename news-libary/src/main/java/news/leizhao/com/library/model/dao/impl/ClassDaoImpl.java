package news.leizhao.com.library.model.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import news.leizhao.com.library.model.dao.IClassDao;
import news.leizhao.com.library.model.db.helper.SysDBHelper;
import news.leizhao.com.library.model.db.sql.SQLiteCommand;
import news.leizhao.com.library.model.entity.ClassAndGrade;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author 雷钊
 * Date 2017/12/29 15:57
 */
public class ClassDaoImpl implements IClassDao {

    private static final String TAG = ClassDaoImpl.class.getSimpleName();

    protected SysDBHelper mDBHelper;

    public ClassDaoImpl(Context context) {
        mDBHelper = new SysDBHelper(context);
    }


    @Override
    public void insertClass(ClassAndGrade classAndGrade) {
        Log.d(TAG, "insertClass");

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("classId", classAndGrade.classId);
            cv.put("className", classAndGrade.className);
            db.insert(SQLiteCommand.CLASS_AND_GRADE_TABLE, null, cv);
            db.close();
        } catch (Exception e) {
            db.close();
        }
    }

    @Override
    public List<ClassAndGrade> queryAllClass() {
        Log.d(TAG, "queryAllClass");

        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor cursor = db.query(
                SQLiteCommand.TEACHER_TABLE_NAME
                , new String[]{"teacherId", "name", "age", "gender"}  //查询的列
                , null          //查询条件 如:name = ?
                , null      //查询条件的值  如 张三
                , null
                , null
                , null);

        List<ClassAndGrade> classAndGrades = new ArrayList<>();
        while (cursor.moveToNext()) {
            ClassAndGrade classAndGrade = new ClassAndGrade();
            classAndGrade.classId = cursor.getInt(cursor.getColumnIndex("classId"));
            classAndGrade.className = cursor.getString(cursor.getColumnIndex("className"));
            classAndGrades.add(classAndGrade);
        }
        db.close();
        Log.v(TAG, "查询所有班级列表 success students =" + classAndGrades.toString());
        return classAndGrades;
    }
}
