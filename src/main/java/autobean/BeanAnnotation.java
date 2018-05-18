package autobean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *  Created by ly on 2018/1/20.
 */
//@Component("bean")
@Component()
@Scope("prototype")
class BeanAnnotation {

    public void say(String str){
        System.out.println("BeanAnnotation : " + str + ";" + this.hashCode());
    }
}
