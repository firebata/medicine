package com.cnfwsy.interfaces.model.sys;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * 说明:
 * Created by zhangjh on 2016-08-29.
 */
public interface IRefreshServ {
    void refreshIdx() throws IOException, TemplateException;
}
