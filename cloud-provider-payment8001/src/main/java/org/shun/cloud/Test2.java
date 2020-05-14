package org.shun.cloud;

import java.time.ZonedDateTime;

/**
 * 描述:
 * 时区加时间
 *
 * @author: BK137
 * @create: 2020/05/14 上午 10:54
 */
public class Test2 {
    public static void main(String[] args){
        ZonedDateTime zbj = ZonedDateTime.now();//默认时区
        System.out.println(zbj);
    }
//    2020-05-14T10:58:06.546+08:00[Asia/Shanghai]
}
