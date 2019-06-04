package com.jeff.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeff.entity.User;
import com.jeff.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-06-04 23:15
 */
public class PageTest {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-spring.xml");

    /**
     * 测试分页插件
     */
    @Test
    public void page() {
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

        Page<User> page = new Page<>(1, 2);
        IPage<User> selectPage = userMapper.selectPage(page, null);

        System.out.println("总条数：" + selectPage.getTotal());
        System.out.println("当前页码：" + selectPage.getCurrent());
        System.out.println("总页码：" + selectPage.getPages());
        System.out.println("每页显示的条数：" + selectPage.getSize());
        System.out.println("查询的结果：" + selectPage.getRecords());
    }

}
