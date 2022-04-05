package com.match.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @Aspect：告诉Spring当前类是一个切面类
 */
@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1、本类引用
    // 2、其他的切面类引用 com.match.aop.LogAspects.pointCut()
    @Pointcut("execution(public int com.match.aop.MathCalculator.*(..))")
    public void pointCut() {};

    // @Before在目标方法之前切入；切入点表达式（指定在那个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "除法运行……@Before参数列表是: {"+ Arrays.asList(args) +"}");
    }
    // 别的类引用使用全类名
    @After("com.match.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "除法结束……@After");
    }

    // JoinPoint一定要出现在参数列表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法正常返回……@AfterReturning运行结果: {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint.getSignature().getName() + "除法异常……异常信息是: {"+ e.getMessage() +"}");
    }
}
