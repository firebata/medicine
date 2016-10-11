package com.cnfwsy.core.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangjh on 16/6/5.
 */
public class IDGenerator2Test {
    @Test
    public void nextId() throws Exception {
        IDGenerator2 idGenerator2 =IDGenerator2.geIntance();
        for (int idx=0 ;idx<30;idx++){
            System.out.println(idGenerator2.nextId());
        }
    }

}