package com.bxw.aop;

import com.bxw.annotation.DB;
import com.bxw.configuration.DatasourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class BeforeSwitchDB {
    @Before("@annotation(com.bxw.annotation.DB)")
    public void beforeSwitchDB(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数及类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DatasourceContextHolder.primary_DB;//默认数据库
        try{
            //得到访问的方法对象
            Method method = className.getMethod(methodName,argClass);
            if(method.isAnnotationPresent(DB.class)){
                DB annotation = method.getAnnotation(DB.class);
                dataSource = annotation.value();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DatasourceContextHolder.setDB(dataSource);//切换数据源
    }

    @After("@annotation(com.bxw.annotation.DB)")
    public void afterSwitchDB(JoinPoint point){
        DatasourceContextHolder.clearDB();
    }
}
