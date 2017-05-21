package proxy.jdk;

import proxy.jdk.impl.SayHello;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by alan on 17-5-17.
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {

        // 获取将要被动态代理的类(被动态代理的类,只能是接口)
        // 通过 Proxy 为 Interface(接口) 动态创建代理类对象
        Class proxyClass = Proxy.getProxyClass(ISayHello.class.getClassLoader(),ISayHello.class);

        // 打印 proxyClass 的构造函数
        Constructor[] proxyConstructs =  proxyClass.getConstructors();
        for (Constructor constructor:
             proxyConstructs) {
            System.out.println(constructor.toString());
        }

        // 获得被代理类的参数类型为 InvaocationHandler.class 的构造函数
        Constructor constructor = null;
        try {
            // ISayHello 没有函数参数为 InvocationHandler 的构造函数,但是通过 Proxy 创建的 class 对象,已经有了这个这个构造函数
            constructor = proxyClass.getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ISayHello sayHello = null;

        try {
            // 实例化生成的动态代理类,入参为 InvocationHandler.class
            sayHello = (ISayHello) constructor.newInstance(new SayHelloInvocationHandler(new SayHello()));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 代理类的使用
        sayHello.sayHello();
    }
}
