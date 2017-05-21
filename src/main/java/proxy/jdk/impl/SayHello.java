package proxy.jdk.impl;

import proxy.jdk.ISayHello;

/**
 * Created by alan on 17-5-17.
 */
public class SayHello implements ISayHello {

    public void sayHello(){
        System.out.println("hello,word");
    }
}
