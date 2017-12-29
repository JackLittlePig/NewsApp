package news.leizhao.com.library.model.dao;

import java.util.List;

import news.leizhao.com.library.model.entity.Teacher;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author 雷钊
 * Date 2017/12/29 13:54
 */
public interface ITeacherDAO {


    /**
     * 插入教师
     *
     * @param teacher 教师实体类
     */
    public void insertTeacher(Teacher teacher);


    /**
     * 查询所有教师列表
     *
     * @return
     */
    public List<Teacher> queryAllTeacher();

}
