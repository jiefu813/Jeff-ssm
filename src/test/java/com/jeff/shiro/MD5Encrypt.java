package com.jeff.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @author Jeff
 * @createTime 2019-06-03 1:16
 */
public class MD5Encrypt {

    @Test
    public void encrypt(){
        //密码、盐值、加密次数
        String result = new Md5Hash("123456","jeff",3).toString();
        System.out.println("加密后的值----->" + result);
    }

}
