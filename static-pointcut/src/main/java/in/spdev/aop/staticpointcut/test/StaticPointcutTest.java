package in.spdev.aop.staticpointcut.test;

import in.spdev.aop.staticpointcut.advice.Around;
import in.spdev.aop.staticpointcut.beans.Calculator;
import in.spdev.aop.staticpointcut.pointcut.StaticPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Calculator());
        // pass the pointcut , pass the advice
        proxyFactory.addAdvisors(new DefaultPointcutAdvisor(new StaticPointcut(), new Around()));
        Calculator calculatorProxy = (Calculator) proxyFactory.getProxy();
        double mul = calculatorProxy.add(10, 20);
        System.out.println(mul);
    }
}
