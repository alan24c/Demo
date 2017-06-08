package effectiveJava.concurrent;

/**
 * Created by alan on 17-6-8.
 */
public class LazyInitHolder {

    // LazyInitHolder 的静态属性
    public static class LazyInitHolderClass{
        private static final FileTypeA filedTypeA = new FileTypeA();
    }

    // LazyInitHolder 的静态方法
    public static FileTypeA getFileTypeA(){
        return LazyInitHolderClass.filedTypeA;
    }

}

class FileTypeA{

}
