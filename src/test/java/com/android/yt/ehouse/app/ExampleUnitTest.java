package com.android.yt.ehouse.app;

import com.android.yt.ehouse.app.data.bean.SellHouseFormBean;
import com.android.yt.ehouse.app.data.manager.FormBeanManager;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testFormBean(){
        SellHouseFormBean sellHouseFormBean = new SellHouseFormBean();
        FormBeanManager<SellHouseFormBean> formBeanFormBeanManager = new FormBeanManager<>(sellHouseFormBean);
        sellHouseFormBean.setHouseName("this is house name");
        sellHouseFormBean.setHouseBuilding("this is house building");
        sellHouseFormBean.setHouseNo("this is house no ");
        sellHouseFormBean.setHouseRoom("this is house room");
    }
}