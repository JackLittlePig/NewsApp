package news.leizhao.com.library.db.dao;

import java.util.List;

import news.leizhao.com.library.db.model.Student;

/**
 * Title:IStudentDAO
 * <p>
 * Description: 学生数据Dao
 * </p>
 * Author 雷钊
 * Date 2017/12/28 17:08
 */
public interface IStudentDAO {

    /**
     * 添加学生
     *
     * @param student 学生信息
     */
    public void addStudent(Student student);


    /**
     * 查询全部学生基本信息
     *
     * @return 学生信息列表
     */
    public List<Student> queryAllStudent();


    /**
     * 根据年龄查询学生信息
     *
     * @param age 年龄
     * @return 学生信息列表
     */
    public List<Student> queryStudentFromAge(int age);

    /**
     * 根据姓名,修改班级
     *
     * @param name      学生姓名
     * @param className 班级名称
     * @return
     */
    public void updateStudentFromName(String name, String className);

    /**
     * 根据姓名,删除学生
     *
     * @param name 学生姓名
     */
    public void deleteStudentFromName(String name);

}
