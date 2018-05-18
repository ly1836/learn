package aop;

import org.springframework.stereotype.Service;

/**
 *  Created by ly on 2018/2/6.
 */

public class AspectBiz {

    public void biz() {
        System.out.println("AspectBiz ..");
        throw new RuntimeException();
    }

    public void init(String name, int times) {
        System.out.println("AspectBiz .." + name + ";" + times);
    }
}
