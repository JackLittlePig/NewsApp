package news.leizhao.com.library.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import news.leizhao.com.library.db.sql.SQLiteCommand;

/**
 * Title:SysDBHelper
 * <p>
 * Description: 数据库 系统 helper
 * </p>
 * Author 雷钊
 * Date 2017/12/28 16:43
 */
public class SysDBHelper extends SQLiteOpenHelper {


    public SysDBHelper(Context context) {
        super(context, "defult_test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteCommand.CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
