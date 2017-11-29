package com.framework.utils;

import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-framework.xml")
public class TestClass {

    @Test
    public void testEhcache() {

        CacheManager cacheManager = SpringContext.getBean(CacheManager.class);
        assert cacheManager != null;
        //CacheUtils.get("userCache","user");
    }
}
