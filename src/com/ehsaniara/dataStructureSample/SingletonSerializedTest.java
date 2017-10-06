package com.ehsaniara.dataStructureSample;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/30/17.
 * From http://www.ehsaniara.com
 */
public class SingletonSerializedTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

        Map<String, String> map = new HashMap<>();
    }

    public static class SerializedSingleton implements Serializable {

        private static final long serialVersionUID = -7604766932017737115L;

        private SerializedSingleton() {
        }

        protected Object readResolve() {
            return getInstance();
        }

        private static class SingletonHelper {
            private static final SerializedSingleton instance = new SerializedSingleton();
        }

        public static SerializedSingleton getInstance() {
            return SingletonHelper.instance;
        }

    }
}
