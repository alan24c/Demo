package effectiveJava.concurrent;

/**
 * Created by alan on 17-6-8.
 */
public class NormalInitialization {

    // 利用 final 变量的内存模型
    private final FileTypeC fileTypeC = new FileTypeC();

    public FileTypeC getFileTypeC(){
        return fileTypeC;
    }
}

class FileTypeC {

}
