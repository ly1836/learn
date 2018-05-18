package aop.api;

import org.springframework.stereotype.Service;

/**
 *  Created by ly on 2018/2/7.
 */
@Service
public class BizLogicImpl implements BizLogic {
    public String  save() {
        System.out.println("BizLogicImpl save..");
        return "BizLogicImpl save";
        //throw new RuntimeException();
    }
}
