package com.cnfwsy.spider.htmlparser.buss.doctorjob;

import com.cnfwsy.spider.htmlparser.buss.doctorjob.helper.ReadDjJobHelper;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-03.
 */
public class ReadDjJob2OfMedical implements Runnable {

    private int noStart, noEnd;


    public ReadDjJob2OfMedical() {
    }


    public ReadDjJob2OfMedical(int noStart, int noEnd) {
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

    Logger logger = Logger.getLogger(ReadDjJob2OfMedical.class.getName());

    @Override
    public void run() {
        for (int no = noStart; no < noEnd; no++) {
            String url = ReadDjJobHelper.PREFIX_JOB + no + ReadDjJobHelper.SUFFIX_JOB;
            ReadDjJobHelper.SINGLETONE.readurl(url);
        }

    }


}