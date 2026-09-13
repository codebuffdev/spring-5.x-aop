package in.spdev.ss.aop.methodbeforeadvice.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AuditAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Applying before advice");
        //  doing security check
        System.out.println(method.getName());
        Arrays.stream(args).forEach(System.out::println);

        //modifying args value
        args[0] = 12212L;
        System.out.println(target.getClass());

        // aborting control going to target class (We can throw an exception)
        // throw new RuntimeException("I won't let it move further");
    }
}
