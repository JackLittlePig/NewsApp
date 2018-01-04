package com.leizhao.news;

import com.leizhao.news.dimens.DimenTool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test() throws Exception {
        assertEquals(4, 2 + 2);

        DimenTool.genDimensFolder("values-xxhdpi-" + (1920 / 3) + "x" + (1080 / 3), 3);
    }
}