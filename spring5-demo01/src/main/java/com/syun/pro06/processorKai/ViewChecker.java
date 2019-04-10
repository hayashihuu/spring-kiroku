package com.syun.pro06.processorKai;

import java.util.Calendar;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 22:07
 */
public class ViewChecker  implements ProcessedBean{

    public void get(){
        System.out.println("dsalkfhsdi");
    }

    /**
     * 若是大于这个月的第8天泽为 true
     * @return
     */
    @Override
    public boolean isValid() {
        // visitors can watch movies freely between the 1st and 7th day of every month
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) < 8);
        return calendar.get(Calendar.DAY_OF_MONTH) < 8;
    }
}
