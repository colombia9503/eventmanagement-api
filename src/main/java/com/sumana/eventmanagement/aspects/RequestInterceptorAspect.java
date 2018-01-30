package com.sumana.eventmanagement.aspects;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RequestInterceptorAspect {

	private final Log LOG = LogFactory.getLog(RequestInterceptorAspect.class);

	@Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public Object logDataRest(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		HttpServletRequest reqHandler = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		long start = System.currentTimeMillis();
		Object value;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (RuntimeException ex) {
			LOG.error("Method: " + reqHandler.getMethod() + " URI: [" + reqHandler.getRequestURI().toString()
					+ "] Error: " + ex.getClass());
			throw ex;
		} finally {
			long duration = System.currentTimeMillis() - start;
			LOG.info("Method: " + reqHandler.getMethod() + " URI: [" + reqHandler.getRequestURI().toString()
					+ "] Time: " + duration + " ms");
		}
		return null;
	}
}
