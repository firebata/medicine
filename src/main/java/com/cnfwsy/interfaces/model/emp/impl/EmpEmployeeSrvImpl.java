package com.cnfwsy.interfaces.model.emp.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.model.file.ISysFileRecordSrv;
import com.cnfwsy.core.model.file.helper.SysFileRecordHelper;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;
import com.cnfwsy.interfaces.mapper.emp.EmpEmployeeMapper;
import com.cnfwsy.interfaces.model.emp.IEmpEmployeeSrv;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明:
 * Created by zhangjh on 2016-6-27 10:05:24
 */
@Service("empEmployeeSrvImpl")
public class EmpEmployeeSrvImpl extends CommonSrvImpl<EmpEmployee> implements IEmpEmployeeSrv, InitializingBean {
    @Resource(name = "empEmployeeMapper")
    private EmpEmployeeMapper empEmployeeMapper;
    @Autowired
    private ISysFileRecordSrv sysFileRecordSrvImpl;

    @Override
    public void afterPropertiesSet() {
        commonMapper = empEmployeeMapper;
    }

    @Override
    public List<EmpEmployee> searchInfos(BaseForm info) {
        List<EmpEmployee> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EmpEmployee info) {
        super.add(info);
    }

    @Override
    public void edit(EmpEmployee info) {

        super.edit(info);
        //回写文件状态
        String busId = info.getEmployeeId();//业务id
        String fileId = info.getFileId();
        SysFileRecord record = SysFileRecordHelper.getInstance(busId, fileId);
        sysFileRecordSrvImpl.updateStatus(record);
    }

    @Override
    public EmpEmployee queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public EmpEmployee queryInfoByAccountId(String natrualKey) {
        return empEmployeeMapper.queryInfoByAccountId(natrualKey);
    }


    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

}