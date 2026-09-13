package in.spdev.aop.staticpointcut.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class StaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println(targetClass.getName());
        System.out.println(method.getName());
        if(method.getName() == "add")
            return true; //apply for this method
        return false;
    }
}
