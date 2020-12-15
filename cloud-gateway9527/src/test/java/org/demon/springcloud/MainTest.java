package org.demon.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author demon
 * @create 2020-12-15 10:37
 */
public class MainTest {

    @Test
    public void test(){
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
