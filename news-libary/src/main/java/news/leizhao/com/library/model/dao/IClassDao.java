package news.leizhao.com.library.model.dao;

import java.util.List;

import news.leizhao.com.library.model.entity.ClassAndGrade;

/**
 * Title:IClassDao
 * <p>
 * Description: 班级DAO
 * </p>
 * Author 雷钊
 * Date 2017/12/29 15:55
 */
public interface IClassDao {

    /**
     *
     * @param classAndGrade
     */
    public void insertClass(ClassAndGrade classAndGrade);



    public List<ClassAndGrade> queryAllClass();
}
