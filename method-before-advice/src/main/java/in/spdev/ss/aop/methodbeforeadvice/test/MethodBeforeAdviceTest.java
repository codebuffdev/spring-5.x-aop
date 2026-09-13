package in.spdev.ss.aop.methodbeforeadvice.test;

import in.spdev.ss.aop.methodbeforeadvice.advice.AuditAdvice;
import in.spdev.ss.aop.methodbeforeadvice.beans.LoanApprover;
import org.springframework.aop.framework.ProxyFactory;

public class MethodBeforeAdviceTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new LoanApprover());
        proxyFactory.addAdvice(new AuditAdvice());

        // get the proxy of target class
        LoanApprover loanApprover = (LoanApprover) proxyFactory.getProxy();
        boolean approveLoan = loanApprover.approveLoan(1022L);
        System.out.println("is Loan approved = " + approveLoan);
    }
}
