package com.jeff.mybatisplus;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Jeff
 * @createTime 2019-06-04 22:35
 */
public class DataSourceTest {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring.xml");

    @Test
    public void getConnection() throws Exception {
        DataSource ds = ac.getBean("dataSource", DataSource.class);
        System.out.println("ds-->" + ds);
        Connection conn = ds.getConnection();
        System.out.println("conn-->" + conn);
    }

}
