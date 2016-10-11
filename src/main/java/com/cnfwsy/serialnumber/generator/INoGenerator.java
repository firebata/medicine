package com.cnfwsy.serialnumber.generator;

/**
 * Created by zhangjh on 16/6/13.
 */
public interface INoGenerator /*extends Runnable*/ {


    /**
     * 长度
     *
     * @param len
     * @return
     */
    String nextNo(int len);


    /**
     * @return 弹出一个编号
     */
    String offer();

    void run();
}
