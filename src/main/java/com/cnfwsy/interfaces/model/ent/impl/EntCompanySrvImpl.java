package com.cnfwsy.interfaces.model.ent.impl;

import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.core.cache.DictionaryInfoCachedMap;
import com.cnfwsy.core.cache.SystemBaseInfoCachedMap;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.model.file.ISysFileRecordSrv;
import com.cnfwsy.core.model.file.helper.SysFileRecordHelper;
import com.cnfwsy.interfaces.bean.ent.EntCompany;
import com.cnfwsy.interfaces.constant.BusinessConstant;
import com.cnfwsy.interfaces.mapper.ent.EntCompanyMapper;
import com.cnfwsy.interfaces.model.ent.IEntCompanySrv;
import com.cnfwsy.interfaces.model.ent.helper.IEntCompanySrvHelper;
import com.cnfwsy.interfaces.model.sys.ISysCitySrv;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cnfwsy.core.api.UserSessionUtils.getUserFromSession;

/**
 * 类说明:
 * Created by zhangjh on 2016-7-20 15:21:09
 */
@Service("entCompanySrvImpl")
public class EntCompanySrvImpl extends CommonSrvImpl<EntCompany> implements IEntCompanySrv, InitializingBean {

    @Resource(name = "companyNoGenerator")
    INoGenerator companyNoGenerator;

    @Resource(name = "entCompanyMapper")
    private EntCompanyMapper entCompanyMapper;

    @Resource(name = "sysCitySrvImpl")
    private ISysCitySrv sysCitySrvImpl;


    @Autowired
    private ISysFileRecordSrv sysFileRecordSrvImpl;

    @Override
    public void afterPropertiesSet() {
        commonMapper = entCompanyMapper;
    }

    @Override
    public List<EntCompany> searchInfos(BaseForm info) {
        List<EntCompany> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }


    @Override
    public void add(EntCompany info) {
        info.setCompanyId(companyNoGenerator.offer());
        super.add(info);
    }

    @Override
    public void edit(EntCompany info) {

        info.setSummary(info.getEditorValue());
        EntCompany company = super.queryInfoByNatrualKey(info.getCompanyId().toString().toString());
        if (null == company) {
            info.setStep(BusinessConstant.STEP_FINISH);
            info.setThirdId(new BigInteger(info.getCompanyId().toString()));
            info.setThirdKind(BusinessConstant.ZHAOLAI);
            super.add(info);
        } else {
            super.edit(info);
        }

        //回写文件状态
        String busId = info.getCompanyId();//业务id
        String fileId = info.getFileId();
        SysFileRecord record = SysFileRecordHelper.getInstance(busId, fileId);
        sysFileRecordSrvImpl.updateStatus(record);

    }

    @Override
    public EntCompany queryInfoByNatrualKey(String businessKey) {
        EntCompany company = null;
        if (StringUtils.isNoneBlank(businessKey) && !"undefined".equals(businessKey.trim())) {
            company = super.queryInfoByNatrualKey(businessKey);
        }
        if (null == company) {
            company = new EntCompany();
        }
        company.setCompanyId(businessKey);
        Map<String, String> companyTypeMap = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.COMPANY_TYPE);
        Map<String, String> companySizeMap = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.COMPANY_SIZE);
        Map<String, String> industryMap = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.INDUSTRY);
        Map<String, String> hospLevelMap = DictionaryInfoCachedMap.SINGLETONE.getValueMapByTypeKey(BusinessConstant.HOSP_LEVEL);
        Map<String, String> provinceMap = SystemBaseInfoCachedMap.SINGLETONE.getProvinceMap();

        String provinceId = company.getProvinceId();
        Map<String, String> cityMap = new HashMap<>();

        if (StringUtils.isNotBlank(provinceId)) {
            cityMap = sysCitySrvImpl.options(provinceId);
        }

        company.setCompanyTypeMap(companyTypeMap);
        company.setCompanySizeMap(companySizeMap);
        company.setIndustryMap(industryMap);
        company.setHospLevelMap(hospLevelMap);
        company.setCityMap(cityMap);
        company.setProvinceMap(provinceMap);
        return company;
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

    @Override
    public void isHrSelf(String companyId) {

        //必须是企业账号
        UserSessionUtils.judgeIsEntAccount();

        //必须是查看企业自己的信息
//        UserSessionUtils.judgeIsSelf(companyId);
    }

    @Override
    public void isHrSelf() {
        //必须是企业账号
        UserSessionUtils.judgeIsEntAccount();
    }

    @Override
    public boolean isComInfoCompleted() {


        SysAccount account = getUserFromSession();
        String bussId = account.getBussId();

        EntCompany entCompany = super.queryInfoByNatrualKey(bussId.toString());
        boolean result = IEntCompanySrvHelper.SINGLETONE.isComInfoCompleted(entCompany);


        return result;
    }

    @Override
    public void toAuth(EntCompany entCompany) {
        SysAccount account = getUserFromSession();
        String bussId = account.getBussId();
        if (null == entCompany) {
            entCompany = new EntCompany();
        }
        entCompany.setStatus(BusinessConstant.COMPANY_STATUS_TEMP);
        entCompany.setCompanyId(bussId);
        entCompanyMapper.toAuth(entCompany);

        //回写文件状态
        String busId = entCompany.getCompanyId();//业务id
        String fileId = entCompany.getFileId();
        SysFileRecord record = SysFileRecordHelper.getInstance(busId, fileId);
        sysFileRecordSrvImpl.updateStatus(record);


    }
}