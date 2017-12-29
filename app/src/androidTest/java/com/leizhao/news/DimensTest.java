package com.leizhao.news;

import android.util.Log;

import org.junit.Test;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author 雷钊
 * Date 2017/12/29 17:53
 */
public class DimensTest {


    @Test
    public void autoGenerate() {

        for (int i = 0; i <= 1200; i++) {
            System.out.println("    <dimen name=\"size_" + i + "\">" + i + "dp</dimen>\n");
        }
    }

}
