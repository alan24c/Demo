package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alan on 17-5-17.
 */
public class SayHelloInvocationHandler implements InvocationHandler {

    private Object target;

    public SayHelloInvocationHandler(Object target){
        this.target = target;
    }

    // 方法的切入点
    public Object invoke(Object proxy, Method method,Object[] args){

        Object res = null;
        try {
            res = method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }
}
