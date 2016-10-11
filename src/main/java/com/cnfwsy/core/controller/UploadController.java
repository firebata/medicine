package com.cnfwsy.core.controller;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.core.model.file.ISysFileRecordSrv;
import com.cnfwsy.core.utils.UuidGeneratorUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 说明: Created by zhangjh on 2016-06-14.
 */
@Controller
public class UploadController extends BaseController<SysFileRecord> {
    @Autowired
    private ISysFileRecordSrv sysFileRecordSrvImpl;

    @RequestMapping(value = "/uploadapi")
    @IgnoreSecurity
    @ResponseBody
    public Response<SysFileRecord> uploadApk(@RequestParam(value = "myfiles") MultipartFile myfiles,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysFileRecord record = null;
        if (myfiles != null) {
            // 获取保存的路径，

            if (myfiles.isEmpty()) {
                // 未选择文件
            } else {
                // 文件原名称
                String originFileName = myfiles.getOriginalFilename();
                String realPath = request.getSession().getServletContext().getRealPath("/images");
                try {
                    String fileId = UuidGeneratorUtils.getRandomUUID();
                    String suffix = originFileName.substring(originFileName.lastIndexOf("."));
                    String newFileName = fileId + suffix;

                    // 这里使用Apache的FileUtils方法来进行保存
                    FileUtils.copyInputStreamToFile(myfiles.getInputStream(), new File(realPath, newFileName));

                    record = sysFileRecordSrvImpl.saveFileRecord("/images", originFileName, fileId, suffix, newFileName);
                } catch (IOException e) {
                    System.out.println("文件上传失败");
                }
            }
        }
        Response<SysFileRecord> resp = buildResponse(record);
        return resp;
    }
}
