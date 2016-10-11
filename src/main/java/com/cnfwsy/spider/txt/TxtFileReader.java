package com.cnfwsy.spider.txt;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.txt.bean.Jc_pantone;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-08-16.
 */
public class TxtFileReader {
    public void t1() {
        try {
            System.out.println("------------------------------->解析文件开始");
            String encoding = "utf-8";
            InputStreamReader read = new InputStreamReader(
                    TxtFileReader.class.getResourceAsStream("/pantone"), encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            List<Jc_pantone> pantones = new ArrayList<>();
            int idx = 1929;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                String[] ps = lineTxt.split("\t");
                Jc_pantone pantone = new Jc_pantone();
                pantone.setEn_name(ps[0]);
                pantone.setZh_name(ps[1]);
                pantone.setColor_no(ps[2]);
                pantone.setKind(1);
                pantone.setPantone_id(idx++ + "");
                System.out.println(pantone);
                pantones.add(pantone);
            }
            read.close();
            System.out.println("------------------------------->解析文件结束");
            System.out.println("------------------------------->保存pantone开始");
            for (Jc_pantone pantone : pantones) {
                DbUtils.updatePantone(pantone);
            }

            System.out.println("------------------------------->保存pantone结束");


        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
