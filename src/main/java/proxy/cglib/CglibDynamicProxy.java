package proxy.cglib;

import proxy.jdk.impl.SayHello;

/**
 * Created by alan on 17-5-17.
 */
/*
    与 jdk 通过反射来实现动态代理不同,jdk 的反射是通过增强接口来实现代理的;
    cglib 通过继承,构造一个增强的子类来实现代理,所以不要求被代理的类实现特定的接口。

*/
public class CglibDynamicProxy {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();

        SayHello sayHello = (SayHello) proxy.getProxy(SayHello.class);

        sayHello.sayHello();
    }
}
