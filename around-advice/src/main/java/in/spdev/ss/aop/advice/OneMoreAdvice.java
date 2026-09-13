package in.spdev.ss.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class OneMoreAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before passing to target class");
        Object proceed = invocation.proceed();
        System.out.println("returned value in One More advice" +  proceed);
        return proceed;
    }
}
