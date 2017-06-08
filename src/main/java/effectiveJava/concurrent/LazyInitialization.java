package effectiveJava.concurrent;

/**
 * Created by alan on 17-6-6.
 */
/*
    多线程环境下对象的延迟初始化
 */
public class LazyInitialization {

    // 双重加锁
    private volatile FileTypeB lazyInitFiledType;

    public FileTypeB getLazyInitFiledType(){
        if( null == lazyInitFiledType){
            synchronized(this){

                // volatile 变量保证了变量的可见性
                if(null == lazyInitFiledType){
                    lazyInitFiledType = new FileTypeB();
                }
            }
        }

        return lazyInitFiledType;
    }
}

// 待初始化的对象
class FileTypeB{

}
