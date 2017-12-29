package news.leizhao.com.library.model.db.sql;

/**
 * Title:SQLiteCommand
 * <p>
 * Description: SQL 语句集
 * </p>
 * Author 雷钊
 * Date 2017/12/28 16:59
 */
public interface SQLiteCommand {

    String STUDUENT_TABLE_NAME = "student";              //学生表名
    String TEACHER_TABLE_NAME = "teacher";               //教师表名
    String CLASS_AND_GRADE_TABLE = "classAndGrade";      //班级表名


    //创建 学生表
    String CREATE_STUDENT_TABLE = "create table "
            + STUDUENT_TABLE_NAME
            + "("
            + "studentId integer primary key autoincrement "
            + ","
            + "name varchar(20)"
            + ","
            + "age integer"
            + ","
            + "classname varchar(20)"
            + ")";

    //创建 教师表
    String CREATE_TEACHER_TABLE = "create table "
            + TEACHER_TABLE_NAME
            + "("
            + "teacherId integer primary key autoincrement "
            + ","
            + "name varchar(20)"
            + ","
            + "age integer"
            + ","
            + "gender integer"
            + ")";

    //创建 班级表
    String CREATE_CLASS_TABLE = "create table "
            + CLASS_AND_GRADE_TABLE
            + "("
            + "teacherId integer primary key autoincrement "
            + ","
            + "name varchar(20)"
            + ","
            + "age integer"
            + ","
            + "gender integer"
            + ")";


    //根据年龄查询学生
    String QUERY_STUDENT_FROM_AGE = "SELECT * FROM "
            + STUDUENT_TABLE_NAME
            + " WHERE "
            + "age = "
            + "?";


}