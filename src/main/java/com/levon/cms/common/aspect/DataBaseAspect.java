package com.levon.cms.common.aspect;

import com.levon.cms.common.annotation.DataBase;
import com.levon.cms.configuration.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源注解切面
 */
@Aspect
@Component
public class DataBaseAspect {

    /**
     * @description: 切点的位置 - DataBase
     * @author: levon
     * @createDate: 2019-04-03 22:12
     */
    @Pointcut(value = "@annotation(com.levon.cms.common.annotation.DataBase)")
    public void dbPointCut() {

    }

    /**
     * @description: 切点钱的操作
     * @author: levon
     * @createDate: 2019-04-03 22:11
     */
    @Before("dbPointCut()")
    public void beforeSwitchDS(JoinPoint joinPoint) {

        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        // 获得当前访问的class
        Class<?> clazz = joinPoint.getTarget().getClass();
        // 获取当前访问方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取方法的参数类型
        Class[] paramTypes = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();

        try {
            // 访问方法
            Method method = clazz.getMethod(methodName, paramTypes);
            // 是否注解DataBase
            if (method.isAnnotationPresent(DataBase.class)) {
                DataBase annotation = method.getAnnotation(DataBase.class);
                dataSource = annotation.value();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);

    }

    @After("dbPointCut()")
    public void afterSwitchDS(JoinPoint joinPoint) {
        DataSourceContextHolder.clearDB();
    }
}
