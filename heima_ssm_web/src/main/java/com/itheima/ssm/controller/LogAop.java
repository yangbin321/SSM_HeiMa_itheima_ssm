package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-05-16 10:13
 * @Description 日志信息
 */

@Component
@Aspect //切面
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class clazz;//访问的类
    private Method method;//访问的方法


    //前置通知，拦截所有控制器下面的所有方法，主要是获取执行的开始时间，执行的类是哪一个，执行的是那一个方法
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        visitTime = new Date();//开始时间就是当前的访问时间
        clazz = jp.getTarget().getClass();//获取当前访问的类

        String methodName = jp.getSignature().getName();//获取访问方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数
        //获取具体执行的方法的method对象
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName);//访问无参数的方法
        }else {
            //访问有参数的方法时候，先获取参数，再进行访问
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }


    }

    //后置通知，拦截所有控制器下面的所有方法，获取执行的开始时间
    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        long time = new Date().getTime() - visitTime.getTime();//获取访问的时长

        //获取url，通过反射来完成操作
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class){//如果访问的类和方法不为空，并且不是访问当前自己的类

            //1、获取类上的@RequestMapping("/product")
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);//强转
            if (clazzAnnotation != null){//如果获取到的不为空
                String[] classValue = clazzAnnotation.value();

                //2、获取方法上的@RequestMapping("/findAll.do")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){//如果获取到的不为空
                    String[] methodValue = methodAnnotation.value();

                    //url等于类上面的第一个value()加上方法上面的第一个value()
                    url = classValue[0] + methodValue[0];


                    //获取访问的ip地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);//执行的时长
                    sysLog.setIp(ip);//访问的ip
                    sysLog.setMethod("[类名] " + clazz.getName() + " [方法名] " + method.getName());//访问的方法
                    sysLog.setUsername(username);//访问的用户名
                    sysLog.setVisitTime(visitTime);//访问的开始时间
                    sysLog.setUrl(url);//访问的url

                    //调用service完成数据的操作
                    sysLogService.save(sysLog);
                }
            }

        }


    }
}
