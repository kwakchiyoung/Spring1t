package hello.hellospring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))") //AOP대상 선정 지금은 hellospinrg패키지하위 전부
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toLongString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start ;
            System.out.println("END: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }

    }
}


