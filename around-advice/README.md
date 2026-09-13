# AroundAdvice

With `spring-aop` module we can perform aspect programming only in Programmatic approach.

```xml

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aop</artifactId>
	<version>5.3.22</version>
</dependency>
```

AroundAdvice : Aspect class has the control before & after the target class method being executed.

Classes & Interface :

1. MethodInterceptor (I)
2. invoke (MethodInvocation)

```java
public class AspectAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // control before calling the target class

        // forwarding to control to Target class
        Object returnValue = invocation.proceed();

        // return the result to caller 
        return returnValue;
    }
}
```

## working with multiple Aspect 

It will create a interceptor chain. 
```
                  CALL
                   ↓
        proxy.add(10, 20)
                   ↓
          ┌─────────────────┐
          │ OneMoreAdvice   │
          │                 │
          │ before          │
          │                 │
          │ proceed() ─────────────┐
          └─────────────────┘     │
                                  ↓
                         ┌─────────────────┐
                         │ LoggingAdvice   │
                         │                 │
                         │ args: 10, 20    │
                         │                 │
                         │ modifies args   │
                         │ 100, 101        │
                         │                 │
                         │ proceed() ───────────┐
                         └─────────────────┘   │
                                               ↓
                                      ┌─────────────────┐
                                      │ Calculator      │
                                      │                 │
                                      │ add(100,101)    │
                                      │                 │
                                      │ returns 201     │
                                      └────────┬────────┘
                                               │
                                      201       │
                         ┌─────────────────────┘
                         ↓
                  LoggingAdvice
                         │
                         │ returnValue = 201
                         │
                         │ + 100
                         ↓
                        301
                         │
          ┌──────────────┘
          ↓
   OneMoreAdvice
          │
          │ proceed = 301
          │
          │ return proceed
          ↓
         301
          │
          ↓
        caller
          │
          ↓
       add = 301
```
