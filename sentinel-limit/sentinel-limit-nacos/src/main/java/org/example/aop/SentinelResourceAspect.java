//package org.example.aop;
//
//import com.alibaba.csp.sentinel.Entry;
//import com.alibaba.csp.sentinel.EntryType;
//import com.alibaba.csp.sentinel.SphU;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.annotation.aspectj.AbstractSentinelAspectSupport;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//
//import java.lang.reflect.Method;
//
///**
// * Aspect for methods with {@link SentinelResource} annotation.
// *
// * @author Eric Zhao
// */
//@Order
//@Aspect
//public class SentinelResourceAspect extends AbstractSentinelAspectSupport {
//
//    @Pointcut("@annotation(com.alibaba.csp.sentinel.annotation.SentinelResource)")
//    public void sentinelResourceAnnotationPointcut() {
//    }
//
//    @Around("sentinelResourceAnnotationPointcut()")
//    public Object invokeResourceWithSentinel(ProceedingJoinPoint pjp) throws Throwable {
//        Method originMethod = resolveMethod(pjp);
//
//        SentinelResource annotation = originMethod.getAnnotation(SentinelResource.class);
//        if (annotation == null) {
//            // Should not go through here.
//            throw new IllegalStateException("Wrong state for SentinelResource annotation");
//        }
//        String resourceName = getResourceName(annotation.value(), originMethod);
//        EntryType entryType = annotation.entryType();
//        int resourceType = annotation.resourceType();
//        Entry entry = null;
//        try {
//            entry = SphU.entry(resourceName, resourceType, entryType, pjp.getArgs());
//            Object result = pjp.proceed();
//            return result;
//        } catch (BlockException ex) {
//            return handleBlockException(pjp, annotation, ex);
//        } catch (Throwable ex) {
//            Class<? extends Throwable>[] exceptionsToIgnore = annotation.exceptionsToIgnore();
//            // The ignore list will be checked first.
//            if (exceptionsToIgnore.length > 0 && exceptionBelongsTo(ex, exceptionsToIgnore)) {
//                throw ex;
//            }
//            if (exceptionBelongsTo(ex, annotation.exceptionsToTrace())) {
//                traceException(ex);
//                return handleFallback(pjp, annotation, ex);
//            }
//
//            // No fallback function can handle the exception, so throw it out.
//            throw ex;
//        } finally {
//            if (entry != null) {
//                entry.exit(1, pjp.getArgs());
//            }
//        }
//    }
//}
