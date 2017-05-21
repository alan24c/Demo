package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by alan on 17-5-17.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class classz){

        // 通过构造子类来实现方法的增强
        enhancer.setSuperclass(classz);
        // 设置回调函数
        enhancer.setCallback(this);

        //创建实例
        return enhancer.create();
    }

    // 方法的切入点
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {

        Object result = proxy.invokeSuper(obj,args);

        return result;
    }
}
