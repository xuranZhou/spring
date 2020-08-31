package com.itheima.proxy.cglib;

import com.itheima.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//返回值是动态生成的代理对象
public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        final Target target = new Target();
        //获得增强对象
        final Advice advice =new Advice();
        //返回值，就是动态生成的代理对象，基于cglib
        //1、创建增强器
        Enhancer enhancer= new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke =method.invoke(target,args);//执行目标
                advice.afterReturning();//执行后置
                return null;
            }
        });
        //4、创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();

//        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),//目标对象加载器
//                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象数组
//                new InvocationHandler() {
//                    //调用代理对象的任何方法，实质执行的都是invoke方法
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                       advice.before();//前置增强
//                        Object invoke = method.invoke(target, args);//执行目标方法
//                        advice.afterRunning();//猴子增强
//                        return invoke;
//                    }
//                }
//        );
        //        Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),//目标对象加载器
//                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象数组
//                new InvocationHandler() {
//                    //调用代理对象的任何方法，实质执行的都是invoke方法
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        method.invoke(target,args);//执行目标方法
//                        return null;
//                    }
//                }
//        )
//    }；
//        proxy.save();//调用代理对象的方法
    }
}
