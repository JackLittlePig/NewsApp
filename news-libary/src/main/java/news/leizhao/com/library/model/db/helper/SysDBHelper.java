package news.leizhao.com.library.model.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import news.leizhao.com.library.model.db.sql.SQLiteCommand;

/**
 * Title:SysDBHelper
 * <p>
 * Description: 数据库 系统 helper
 * </p>
 * Author 雷钊
 * Date 2017/12/28 16:43
 */
public class SysDBHelper extends SQLiteOpenHelper {

    private static final String TAG = SysDBHelper.class.getSimpleName();


    // 初始的版本号
    public static final int DB_VERSION = 6;
    // 数据库文件名称
    public static final String SQL_FILE_NAME = "defult_test.db";


    public SysDBHelper(Context context) {
        super(context, SQL_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteCommand.CREATE_STUDENT_TABLE);
        db.execSQL(SQLiteCommand.CREATE_TEACHER_TABLE);
        db.execSQL(SQLiteCommand.CREATE_CLASS_TABLE);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade oldVersion = " + oldVersion + " , newVersion = " + newVersion);

    }
}
