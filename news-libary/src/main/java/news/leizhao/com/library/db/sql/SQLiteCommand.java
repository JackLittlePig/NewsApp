package news.leizhao.com.library.db.sql;

/**
 * Title:SQLiteCommand
 * <p>
 * Description: SQL 语句集
 * </p>
 * Author 雷钊
 * Date 2017/12/28 16:59
 */
public interface SQLiteCommand {

    String STUDUENT_TABLE_NAME = "student";        //学生表名

    String CREATE_STUDENT_TABLE = "create table "
            + STUDUENT_TABLE_NAME
            + "("
            + "id integer primary key autoincrement "
            + ","
            + "name varchar(20)"
            + ","
            + "age integer"
            + ","
            + "classname varchar(20)"
            + ")";


    String QUERY_STUDENT_FROM_AGE = "SELECT * FROM "
            + STUDUENT_TABLE_NAME
            + " WHERE "
            + "age = "
            + "?";


}