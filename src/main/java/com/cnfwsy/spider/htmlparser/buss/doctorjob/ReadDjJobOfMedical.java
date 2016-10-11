package com.cnfwsy.spider.htmlparser.buss.doctorjob;

import com.cnfwsy.spider.htmlparser.buss.doctorjob.helper.ReadDjComDetailHelper;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-03.
 */
public class ReadDjJobOfMedical implements Runnable {

    private int noStart, noEnd;


    public ReadDjJobOfMedical() {
    }


    public ReadDjJobOfMedical(int noStart, int noEnd) {
        this.noStart = noStart;
        this.noEnd = noEnd;
    }

    public int getNoStart() {
        return noStart;
    }

    public void setNoStart(int noStart) {
        this.noStart = noStart;
    }

    public int getNoEnd() {
        return noEnd;
    }

    public void setNoEnd(int noEnd) {
        this.noEnd = noEnd;
    }

    Logger logger = Logger.getLogger(ReadDjJobOfMedical.class.getName());

    @Override
    public void run() {
        for (int no = noStart; no < noEnd; no++) {
            String url = ReadDjComDetailHelper.PREFIX_COM + no + ReadDjComDetailHelper.SUFFIX_COM;
            ReadDjComDetailHelper.SINGLETONE.parse(url, no + "");
        }

    }


}