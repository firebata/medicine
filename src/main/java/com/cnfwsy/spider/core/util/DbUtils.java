package com.cnfwsy.spider.core.util;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.txt.bean.Jc_pantone;
import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支持单主键的表，建议主键设置在
 *
 * @author zhangjh
 */
public class DbUtils {
    private static Logger logger = Logger.getLogger(DbUtils.class.getName());
    private static DbUtils dbUtils = new DbUtils();
    public static final int INSERTSQL = 1;
    public static final int UPDATESQL = 2;

    private DbUtils() {
        super();
    }

    /**
     * @return
     */
    public static DbUtils getInstance() {
        return dbUtils;
    }

    /**
     * @param o
     */
    public static void insert(Object o) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DruidUtil.getConnection();
            statement = conn.createStatement();
            String r1 = getInsertSQL(o);//
            statement.executeUpdate(r1);
            logger.info("执行成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            DruidUtil.release(conn, statement);
        }
    }

    /**
     * @param o
     */
    public static void update(Object o) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DruidUtil.getConnection();
            statement = conn.createStatement();
            String r1 = getUpdateSQL(o);//
            statement.executeUpdate(r1);
            logger.info("执行成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            DruidUtil.release(conn, statement);
        }
    }

    /**
     * 获取InsertSQL
     *
     * @param model
     * @return
     */
    public static String getInsertSQL(Object model) {
        if (model == null) {
            logger.info("传入参数为空");
            throw new NullPointerException();
        }
        return getInsertOrUpdateSQL(INSERTSQL, model);
    }

    /**
     * 获取InsertSQL
     *
     * @param model
     * @return
     */
    public static String getUpdateSQL(Object model) {
        if (model == null) {
            logger.info("传入参数为空");
            throw new NullPointerException();
        }
        return getInsertOrUpdateSQL(UPDATESQL, model);
    }

    /**
     * 选择Insert或者Update语句,如果是UPDATE，则是可传参的根据ID更新
     *
     * @param type
     * @param model
     * @return
     */
    private static String getInsertOrUpdateSQL(int type, Object model) {
        String sql = null;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Class<?> cl = model.getClass();
        Field[] fields = cl.getDeclaredFields();
        String table = "t_" + cl.getSimpleName().toLowerCase();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (type == 1) {
                    sb1.append(",");
                    sb1.append(field.getName());
                    if (field.getType().equals(String.class)) {
                        Object o = field.get(model);
                        String value = (String) o;
                        sb2.append(",");
                        if (null != value) {
                            sb2.append("'");
                            sb2.append(value);
                            sb2.append("'");
                        } else {
                            sb2.append(o);
                        }

                    } else if (field.getType().equals(int.class)) {
                        int value = field.getInt(model);
                        sb2.append(",");
                        sb2.append(value);
                    } else if (field.getType().equals(BigInteger.class)) {
                        BigInteger value = (BigInteger) field.get(model);
                        sb2.append(",");
                        sb2.append(value);
                    }
                } else if (type == 2) {
                    if (field.getType().equals(String.class)) {
                        Object o = field.get(model);
                        String value = (String) o;
                        sb1.append(",");
                        sb1.append(field.getName());
                        if (null != value) {
                            sb1.append("='");
                            sb1.append(value);
                            sb1.append("'");
                        } else {
                            sb1.append("=");
                            sb1.append(o);
                        }

                    } else if (field.getType().equals(int.class)) {
                        int value = field.getInt(model);
                        sb1.append(",");
                        sb1.append(field.getName());
                        sb1.append("=");
                        sb1.append(value);
                    }
                    if (field.getType().equals(BigInteger.class)) {
                        BigInteger value = (BigInteger) field.get(model);
                        sb1.append(",");
                        sb1.append(field.getName());
                        sb1.append("=");
                        sb1.append(value);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (type == 1) {
            sql = String.format("insert into %s (%s) values(%s)", table, sb1.substring(1), sb2.substring(1));
        } else if (type == 2) {
            sql = String.format("update %s set %s where %s=?", table, sb1.substring(1), fields[0].getName());
        }
        logger.info("新增数据：" + table);
        return sql;
    }

    /**
     * @param querySql
     * @param type
     * @return
     */
    public static List queryList(String querySql, Class type) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            conn = DruidUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(querySql);

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(md.getColumnName(i), rs.getObject(i));
                }
                Object object = convertMap(type, map);
                list.add(object);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            DruidUtil.release(conn, stmt, rs);
        }

        return list;
    }

    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param type 要转化的类型
     * @param map  包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InstantiationException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings("rawtypes")
    public static Object convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * @param job
     */
    public static void updateJob(Ent_jobinfo job) {
        String sql = "update t_ent_jobinfo set city_name=?,area_name=?,quantity=?,education_name=?,experience_name=?,job_desc=?,address=?,job_type_name=?,job_type_sub_name=?,title_requr=?,age_requr=?,pro_requr=?,job_nature_name=?,step=? where job_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String jobId = job.getJob_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, job.getCity_name());
            ps.setString(2, job.getArea_name());
            ps.setInt(3, job.getQuantity());
            ps.setString(4, job.getEducation_name());
            ps.setString(5, job.getExperience_name());
            ps.setString(6, job.getJob_desc());
            ps.setString(7, job.getAddress());
            ps.setString(8, job.getJob_type_name());
            ps.setString(9, job.getJob_type_sub_name());
            ps.setString(10, job.getTitle_requr());
            ps.setString(11, job.getAge_requr());
            ps.setString(12, job.getPro_requr());
            ps.setString(13, job.getJob_nature_name());
            ps.setInt(14, AppConstant.step_2);
            ps.setString(15, jobId);
            ps.setString(16, job.getThird_kind());

            int i = ps.executeUpdate();
            if (i == 1) {
                logger.info("职位id为：" + jobId + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    /**
     * @param company
     */
    public static void updateCom(Ent_company company) {
        String sql = "update t_ent_company set industry_name=?,company_address=?,url=?,summary=?,company_type_name=?,company_size_name=?,step=?,industry_name2=? where company_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getIndustry_name());
            ps.setString(2, company.getCompany_address());
            ps.setString(3, company.getUrl());
            ps.setString(4, company.getSummary());
            ps.setString(5, company.getCompany_type_name());
            ps.setString(6, company.getCompany_size_name());
            ps.setInt(7, AppConstant.step_2);
            ps.setString(8, company.getIndustry_name2());
            ps.setString(9, company_id);
            ps.setString(10, company.getThird_kind());
            int i = ps.executeUpdate();
            if (i == 1) {
                logger.info("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    /**
     * 如果是从数据库中查询出来的记录，需要更改step
     *
     * @param company
     */
    public static void updateComDxy1(Ent_company company) {
        String sql = "update t_ent_company set industry_name=?,province_name=?,company_type_name=?,hosp_level_name=?,company_size_name=?,scale_name=? ,step=2 where company_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getIndustry_name());
            ps.setString(2, company.getProvince_name());
            ps.setString(3, company.getCompany_type_name());
            ps.setString(4, company.getHosp_level_name());
            ps.setString(5, company.getCompany_size_name());
            ps.setString(6, company.getScale_name());
            ps.setString(7, company_id);
            ps.setString(8, company.getThird_kind());
            int i = ps.executeUpdate();
            if (i == 1) {
                logger.info("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }


    public static int update(String sql) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int i = 0;
        try {
            conn = DruidUtil.getConnection();
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, pstmt);
        }

        return i;
    }

    /**
     * 如果是查询职位的时候，不需要更新step
     *
     * @param company
     */
    public static void updateComDxy2(Ent_company company) {
        String sql = "update t_ent_company set email=?,contact_man=?,mobile=?,telephone=?,company_address=?,summary=? where company_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getEmail());
            ps.setString(2, company.getContact_man());
            ps.setString(3, company.getMobile());
            ps.setString(4, company.getTelephone());
            ps.setString(5, company.getCompany_address());
            ps.setString(6, company.getSummary());
            ps.setString(7, company_id);
            ps.setString(8, company.getThird_kind());
            int i = ps.executeUpdate();
            if (i == 1) {
                logger.error("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    /**
     * @param company
     */
    public static void updateCompanyStep(Ent_company company) {
        String sql = "update t_ent_company set step=? where company_id=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, company.getStep());
            ps.setString(2, company_id);
            int i = ps.executeUpdate();
            if (i > 1) {
                logger.error("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    /**
     * @param job
     */
    public static void updateJobStep(Ent_jobinfo job) {
        String sql = "update t_ent_jobinfo set step=? where job_id=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = job.getJob_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, job.getStep());
            ps.setString(2, company_id);
            int i = ps.executeUpdate();
            if (i > 1) {
                logger.error("职位id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    public static void updateDjCom(Ent_company company) {
        String sql = "update t_ent_company set company_name=?,url=?,summary=?,com_url=?,company_size_name=?,company_address=?,hosp_type_name=? where company_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getCompany_name());
            ps.setString(2, company.getUrl());
            ps.setString(3, company.getSummary());
            ps.setString(4, company.getCom_url());
            ps.setString(5, company.getCompany_size_name());
            ps.setString(6, company.getCompany_address());
            ps.setString(7, company.getHosp_type_name());
            ps.setString(8, company_id);
            ps.setString(9, company.getThird_kind());
            int i = ps.executeUpdate();
            if (i == 1) {
                logger.error("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    public static void updatePantone(Jc_pantone pantone) {
        String sql = "update t_jc_pantone set en_name=?,zh_name=?,kind=1 where color_no=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pantone.getEn_name());
            ps.setString(2, pantone.getZh_name());
            ps.setString(3, pantone.getColor_no());
            int i = ps.executeUpdate();
            if (i == 0) {
                insert(pantone);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }

    public static void updateComEcaihr(Ent_company company) {
        String sql = "update t_ent_company set company_name=?,url=?,company_address=?,contact_man=? ,telephone=?,email=?, step=2 where company_id=? and third_kind=?";
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            String company_id = company.getCompany_id().toString();
            conn = DruidUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, company.getCompany_name());
            ps.setString(2, company.getUrl());
            ps.setString(3, company.getCompany_address());
            ps.setString(4, company.getContact_man());
            ps.setString(5, company.getTelephone());
            ps.setString(6, company.getEmail());
            ps.setString(7, company_id);
            ps.setString(8, company.getThird_kind());
            int i = ps.executeUpdate();
            if (i == 1) {
                logger.error("公司id为：" + company_id + "的更新记录为" + i);
            }
        } catch (SQLException e) {
            logger.error("更新异常:", e);
        } finally {
            DruidUtil.release(conn, ps);
        }
    }
}
