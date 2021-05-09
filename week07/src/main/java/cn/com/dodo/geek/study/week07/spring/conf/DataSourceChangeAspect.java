package cn.com.dodo.geek.study.week07.spring.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import cn.com.dodo.geek.study.week07.spring.DSType;
import cn.com.dodo.geek.study.week07.spring.DataSourceContextHolder;

@Aspect
public class DataSourceChangeAspect {

	@Around("@annotation(cn.com.dodo.geek.study.week07.spring.DSType)")
	public Object datasourceChange(ProceedingJoinPoint pj) throws Throwable {
		MethodSignature ms = (MethodSignature) pj.getSignature();
		String dsType = ms.getMethod().getDeclaredAnnotation(DSType.class).value();
		try {
			DataSourceContextHolder.setDataSourceType(dsType);
			return pj.proceed();
		} finally {
			DataSourceContextHolder.clearDataSourceType();
		}
	}
}
