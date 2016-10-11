<#import "../../ftl/select.ftl" as sl/>
<!DOCTYPE HTML>
<html>
<head>
    <script src="/resources/thirdparty/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <link media="handheld" rel="alternate">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>基本信息-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <meta content="招徕网(www.zzlinks.cn)专业医疗卫生生物人才网,提供最新医生招聘,护士招聘,医药英才,医院招聘,生物招聘,中国医疗卫生生物人才网,中国卫生人才网,医学人才网招聘首选招徕网"
          name="description">
    <meta name="keywords"  content="医院招聘,医药招聘,医生招聘,护士招聘,找工作,招聘网,招徕网人才网,医学人才网,普壳软件"/>
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
    <link href="/resources/libs/css/umeditor.css" type="text/css" rel="stylesheet">
    <meta name="baidu-site-verification" content="VNd3omYEXT" />
    <meta name="360-site-verification" content="4c5799282a4e8cc7d3be0659b4929ffe" />
    <meta name="sogou_site_verification" content="iMnW8j9mcI"/>
    <!--[if lt IE 9]>
    <script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?f61dede1be943187f04e7cc6a63b299e";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body>
<div id="body">
<#assign headerName="企业信息">
<#include "../../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">
    <#include "../../ftl/ent_sidebar.ftl">
        <div class="content">
            <dl class="company_center_content">
                <dt>
                <h1><em></em>填写企业信息</h1>
                </dt>
                <dd>
                    <div class="ccc_tr">*字段信息为必填项，是求职者了解企业的窗口！</div>
                    <form id="jobForm">
                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">企业名称</td>
                                <td>
                                    <input type="text" placeholder="请输入企业名称" value="${entCompany.companyName!}"
                                           name="company_name" id="company_name">
                                    <input type="hidden" id="company_id" name="company_id"
                                           value="${entCompany.companyId!}">
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>企业类型</td>
                                <td>
                                <@sl.genSelect id="company_type_id" datas=entCompany.companyTypeMap key="id" text="name" headKey="-1" headText="--请选择--" defaultValue=entCompany.companyTypeId/>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>企业规模</td>
                                <td>
                                <@sl.genSelect id="company_size_id" datas=entCompany.companySizeMap key="id" text="name" headKey="-1" headText="--请选择--" defaultValue=entCompany.companySizeId/>

                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>行业类别1</td>
                                <td>
                                <@sl.genSelect id="industry_id" datas=entCompany.industryMap key="id" text="name" headKey="-1" headText="--请选择--" defaultValue=entCompany.industryId/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>行业类别2</td>
                                <td>
                                <@sl.genSelect id="industry_id2" datas=entCompany.industryMap key="id" text="name" headKey="-1" headText="--请选择--" defaultValue=entCompany.industryId2/>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>省&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份</td>
                                <td>
                                    <div>
                                    <@sl.genSelect id="province_id" datas=entCompany.provinceMap key="id" text="name" headKey="-1" headText="--请选择--"  defaultValue=entCompany.provinceId/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市</td>
                                <td>
                                    <div>
                                    <@sl.genSelect id="city_id" datas=entCompany.cityMap key="id" text="name" headKey="-1" headText="--请选择--"  defaultValue=entCompany.cityId/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</td>
                                <td>
                                    <input type="text" placeholder="请输入企业所在地址" value="${entCompany.companyAddress!}"
                                           name="company_address" id="company_address">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>企业邮箱</td>
                                <td>
                                    <input type="text" placeholder="请输入企业邮箱" value="${entCompany.email!}" name="email"
                                           id="email">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>企业官网</td>
                                <td>
                                    <input type="text" placeholder="请输入企业官网" value="${entCompany.url!}" name="url"
                                           id="url">
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">企业简介</td>
                                <td style="line-height:100%">
                                    <script type="text/plain" id="myEditor" style="width:500px;height:200px;">
                                        <p>${entCompany.summary!}</p>


                                    </script
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>企业logo</td>
                                <td>
                                    <div class="c_logo c_logo_pos">
                                        <div id="logoNo" <#if entCompany.companyLogoUrl??>class="dn"</#if>
                                             style="margin-top: 23px; background-color: rgb(147, 183, 187);margin:0 auto">
                                            <span>上传企业LOGO</span> <br>
                                            尺寸：190*190px <br>
                                            大小：小于2M
                                        </div>
                                        <div id="logoShow">
                                            <img width="190" height="190" alt="企业logo"
                                                 src="${entCompany.companyLogoUrl!}">
                                            <span>更换企业LOGO<br>190px*190px 小于2M</span>
                                        </div>
                                        <input type="file" title="支持jpg、gif、png、jpeg格式，文件小于2M"
                                               onchange="$.img_check_com_log(this);" name="myfiles" id="myfiles">
                                        <input type="hidden" name="company_logo_url" id="company_logo_url">
                                        <input type="hidden" name="file_id" id="file_id">
                                    </div>
                                    <span class="error" id="logo_error" style="display:none;"></span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table>
                            <tbody>
                            <tr>
                                <td width="25"></td>
                                <td colspan="2">
                                <#--   <input type="button" value="预览" id="jobPreview" class="btn_32">-->
                                    <input type="button" value="保存" id="formSubmit" class="btn_32">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </dd>
            </dl>
        </div>
        <div class="clear"></div>
        <a rel="nofollow" title="回到顶部" id="backtop" style="display: none;"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>
</body>
</html>
<script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
<script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="/resources/libs/js/ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/resources/libs/js/ueditor/umeditor.min.js"></script>
<script src="/resources/libs/js/jquery/ajaxfileupload.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>

<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/hr/company/com-edit.js" type="text/javascript"></script>