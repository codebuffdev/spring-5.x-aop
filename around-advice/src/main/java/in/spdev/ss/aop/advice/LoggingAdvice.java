package in.spdev.ss.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

// AroundAdvice
// MethodInterceptor
// invoke(MethodInvocation)
public class LoggingAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        Object[] args = invocation.getArguments();
        Object targetClass = invocation.getClass();

        // console logging before forwarding the control
        System.out.println("Target Class: " + targetClass + " & the method called is " + methodName);
        Arrays.stream(args).forEach(System.out::println);

        //modifying args
        for (int i = 0; i < args.length; i++) {
            args[i] = 100 + i;
        }

        // forwarding to control to Target class
        Integer returnValue = (Integer) invocation.proceed();
        System.out.println("add methods return original value " + returnValue);

        // we are modifying the result & returning
        return returnValue + 100;
    }
}
