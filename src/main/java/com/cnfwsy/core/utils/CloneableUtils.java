package com.cnfwsy.core.utils;

import java.io.*;

/**
 * 说明:对象克隆
 * Created by zhangjh on 2016-09-13.
 */
public class CloneableUtils {
    /**
     * 深克隆
     *
     * @param o
     * @param <T>
     * @return
     */
    public <T> T deepClone(Object o) {
        T t = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (null != o) {
            try {
                ObjectOutputStream objOutputStream = null;
                objOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objOutputStream.writeObject(o);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                ObjectInputStream objInputStream = new ObjectInputStream(byteArrayInputStream);
                t = (T) objInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return t;
    }


}
