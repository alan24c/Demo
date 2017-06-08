package effectiveJava.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by alan on 17-6-9.
 */
public class SerializaObject implements Serializable {
    // 序列化的版本号
    
    private int x;

    private int y;

    private float z;

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();

        z = stream.readFloat();
        y = stream.readInt();
        x = stream.readInt();

    }

    // 自定义序列化的格式
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

        stream.writeFloat(z);
        stream.writeInt(y);
        stream.writeInt(x);

    }
}
