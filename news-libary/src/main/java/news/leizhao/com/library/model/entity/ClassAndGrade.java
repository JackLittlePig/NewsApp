package news.leizhao.com.library.model.entity;

import java.io.Serializable;

/**
 * Title: ClassAndGrade
 * <p>
 * Description: 班级 实体
 * </p>
 * Author 雷钊
 * Date 2017/12/29 12:57
 */
public class ClassAndGrade implements Serializable {


    public String className;
    public int classId;

    public ClassAndGrade() {
    }

    public ClassAndGrade(String className, int classId) {
        this.className = className;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "ClassAndGrade{" +
                "className='" + className + '\'' +
                ", classId='" + classId + '\'' +
                '}';
    }
}
