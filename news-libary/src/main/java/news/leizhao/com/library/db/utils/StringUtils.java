package news.leizhao.com.library.db.utils;

/**
 * Title:StringUtils
 * <p>
 * Description: 字符串工具类
 * </p>
 * Author 雷钊
 * Date 2017/12/29 11:18
 */
public class StringUtils {

    /**
     * 判断字符串是否是空
     * @param text 判断字符串是否是空
     * @return
     */
    public static boolean isEmpty(String text) {
        if (text == null
                || "".equals(text)
                || "null".equals(text)) {
            return true;
        }

        return false;
    }
}
