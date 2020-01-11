package com.atanas.web.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LogAspect
{
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Before("execution(* com.atanas.web.controllers.*.*(..)) "
          + "|| execution(* com.atanas.web.services.*.*(..))")
  public void methodBegin(JoinPoint joinPoint)
  {
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    log.debug(className + " -> " + methodName + " begin --");
  }

  @After("execution(* com.atanas.web.controllers.*.*(..)) "
          + "|| execution(* com.atanas.web.services.*.*(..))")
  public void methodEnd(JoinPoint joinPoint)
  {
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();
    log.debug(className + " -> " + methodName + " end --");
  }
}
