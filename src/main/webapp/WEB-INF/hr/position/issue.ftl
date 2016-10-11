<!DOCTYPE HTML>
<html>
<head>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>发布新职位-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/thirdparty/css/ui.css">
    <link rel="stylesheet" href="/resources/thirdparty/css/window.css">
    <script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
    <script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
    <script src="/resources/zlstatic/js/hr/position/issue.js" type="text/javascript"></script>
    <script src='/resources/thirdparty/js/tinymce.min.js'></script>
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
<#assign headerName="发布职位">
<#include "../../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">

    <#include "../../ftl/ent_sidebar.ftl">
        <!-- end .sidebar -->
        <div id="issue" class="content">
            <dl class="company_center_content">
                <dt>
                <h1>
                    <em></em>
                    发布新职位
                </h1>
                </dt>
                <dd>
                    <div class="ccc_tr">今日已发布 <span>0</span> 个职位</div>
                    <form id="jobForm">
                        <input type="hidden" value="" name="jobId">
                        <input type="hidden" value="${entCompany.companyId!}" name="companyId">
                        <input type="hidden" value="${entCompany.companyName!}" name="companyName">
                        <input type="hidden" value="c29d4a7c35314180bf3be5eb3f00048f" name="resubmitToken">
                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">职位类别</td>
                                <td>
                                    <input type="hidden" id="jobType"
                                           value="<#if entJobinfo?exists>${entJobinfo.jobTypeName!}</#if>"
                                           name="jobType">
                                    <input type="hidden" id="jobTypeId"
                                           value="<#if entJobinfo?exists>${entJobinfo.jobTypeId!}</#if>"
                                           name="jobTypeId">
                                    <input type="button"
                                           value="<#if entJobinfo?exists>${entJobinfo.jobTypeName!'请选择职位类别'}<#else>请选择职位类别</#if>"
                                           id="select_category"
                                           class="selectr selectr_380"
                                           style="<#if entJobinfo?exists> color:#333; </#if> ">
                                    <div class="dn" id="box_job" style="display: none;">
                                    <#list entJobtypes?sort_by("typeId") as key0>
                                        <#if key0.parentId==-1>
                                            <dl>
                                                <dt>${key0.typeName!}<input type="hidden" value="${key0.typeId!}"></dt>
                                                <dd>
                                                    <ul class="reset job_main">
                                                        <#assign x=0/>
                                                        <#list entJobtypes?sort_by("typeId") as key1>
                                                            <#if key1.parentId==key0.typeId>
                                                                <li>
                                                                    <#assign y=x%3/>
                                                                    <span value=${key1.typeId!}>${key1.typeName!}<input
                                                                            type="hidden"
                                                                            value="${key1.typeId!}"></span>
                                                                </li>
                                                                <#assign x++/>
                                                            </#if>
                                                        </#list>
                                                    </ul>
                                                </dd>
                                            </dl>
                                        </#if>
                                    </#list>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>职位名称</td>
                                <td>
                                    <input type="text" placeholder="请输入职位名称，如：心脏外科（主治医师）"
                                           value="<#if entJobinfo?exists>${entJobinfo.jobName!}</#if>" name="jobName"
                                           id="jobName">
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">工作性质</td>
                                <td>
                                    <ul class="profile_radio clearfix reset">
                                    <#list dicts?sort_by("keyName") as dict>
                                        <#if dict.type=='job_nature'>
                                            <li <#if entJobinfo?exists><#if (entJobinfo.jobNatureId! == dict.keyName!)>class="current"</#if></#if>>
                                            ${dict.valueName!}<em></em>
                                                <input type="radio" name="jobNature" value=${dict.keyName!}
                                                    <#if entJobinfo?exists><#if (entJobinfo.jobNatureId! == dict.keyName!)>checked="checked"</#if></#if>>
                                            </li>
                                        </#if>
                                    </#list>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>月薪范围</td>
                                <td>
                                    <div class="salary_range">
                                        <div>
                                            <input type="text" placeholder="最低月薪"
                                                   value="<#if entJobinfo?exists>${entJobinfo.salaryStart!/1000}</#if>"
                                                   id="salaryMin"
                                                   name="salaryMin">
                                            <span>k</span>
                                        </div>
                                        <div>
                                            <input type="text" placeholder="最高月薪"
                                                   value="<#if entJobinfo?exists>${entJobinfo.salaryEnd!/1000}</#if>"
                                                   id="salaryMax"
                                                   name="salaryMax">
                                            <span>k</span>
                                        </div>
                                        <span>只能输入整数，如：9</span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>工作城市</td>
                                <td>
                                    <input type="text" placeholder="请输入工作城市，如：广州"
                                           value="<#if entJobinfo?exists>${entJobinfo.cityName!'广州'}<#else>广州</#if>"
                                           name="workAddress"
                                           id="workAddress">
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">工作经验</td>
                                <td>
                                    <input type="hidden" id="experience"
                                           value="<#if entJobinfo?exists>${entJobinfo.experienceName!}</#if>"
                                           name="workYear">
                                    <input type="hidden" id="experienceId"
                                           value="<#if entJobinfo?exists>${entJobinfo.experienceId!}</#if>"
                                           name="workYearId">
                                    <input type="button"
                                           value="<#if entJobinfo?exists>${entJobinfo.experienceName!'请选择工作经验'}<#else>请选择工作经验</#if>"
                                           id="select_experience"
                                           class="selectr selectr_380"
                                           style="<#if entJobinfo?exists> color:#333; </#if> ">
                                    <div class="boxUpDown boxUpDown_380 dn" id="box_experience" style="display: none;">
                                        <ul>
                                        <#--<li value="-1">不限</li>-->
                                        <#list dicts?sort_by("keyName") as dict>
                                            <#if dict.type=='box_experience'>
                                                <li value=${dict.keyName!}>
                                                ${dict.valueName!}
                                                </li>
                                            </#if>
                                        </#list>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>学历要求</td>
                                <td>
                                    <input type="hidden" id="education"
                                           value="<#if entJobinfo?exists>${entJobinfo.educationName!}</#if>"
                                           name="education">
                                    <input type="hidden" id="educationId"
                                           value="<#if entJobinfo?exists>${entJobinfo.educationId!}</#if>"
                                           name="educationId">
                                    <input type="button"
                                           value="<#if entJobinfo?exists>${entJobinfo.educationName!'请选择学历要求'}<#else>请选择学历要求</#if>"
                                           id="select_education"
                                           class="selectr selectr_380"
                                           style="<#if entJobinfo?exists> color:#333; </#if> ">
                                    <div class="boxUpDown boxUpDown_380 dn" id="box_education" style="display: none;">
                                        <ul>
                                        <#--<li value="-1">不限</li>-->
                                        <#list dicts?sort_by("keyName") as dict>
                                            <#if dict.type=='box_education'>
                                                <li value=${dict.keyName!}>
                                                ${dict.valueName!}
                                                </li>
                                            </#if>
                                        </#list>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <table class="btm">
                            <tbody>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">招聘人数</td>
                                <td>
                                    <input type="text" value="<#if entJobinfo?exists>${entJobinfo.quantity!}<#else>1</#if>"
                                           id="quantity" name="quantity">
                                </td>
                            </tr>
                            <tr>
                                <td width="25"><span class="redstar">*</span></td>
                                <td width="85">职位诱惑</td>
                                <td>
                                    <input type="text" placeholder="20字描述该职位的吸引力，如：福利待遇、发展前景等"
                                           value="<#if entJobinfo?exists>${entJobinfo.jobWelfare!}</#if>"
                                           name="jobAdvantage" class="input_520" id="jobAdvantage">
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>职位描述</td>
                                <td>
                                    <span class="c9 f14">(建议分条描述工作职责等。请勿输入公司邮箱、联系电话及其他外链，否则将自动删除)</span>

                                    <textarea name="jobDetail_parent" id="jobDetail_parent"
                                              style="display: none;" aria-hidden="true">建议分条描述工作职责等。请勿输入公司邮箱、联系电话及其他外链，否则将自动删除</textarea>
                                    <textarea name="jobDetail"
                                              id="jobDetail"><#if entJobinfo?exists>${entJobinfo.jobDesc!}</#if></textarea>
                                    <script>
                                        tinymce.init({
                                            selector: '#jobDetail',
                                            menubar: false,
                                            width: 540,
                                            height: 200,
                                            plugins: [
                                                'advlist autolink lists charmap print preview hr anchor pagebreak spellchecker',
                                                'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
                                                'save table contextmenu directionality emoticons template paste textcolor'
                                            ],
                                            toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | print preview fullpage | forecolor backcolor emoticons'
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td><span class="redstar">*</span></td>
                                <td>工作地址</td>
                                <td>
                                    <input type="text" placeholder="请输入详细的工作地址"
                                           value="<#if entJobinfo?exists>${entJobinfo.address!entCompany.companyAddress!}<#else>${entCompany.companyAddress!}</#if>"
                                           name="jobAddress" class="input_520" id="jobAddress">
                                    <div style="float: left; width: 544px; height: 290px; background-color: #ccc;"
                                         id="addr_map_big"></div>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <table>
                            <tbody>
                            <tr>
                                <td width="25"></td>
                                <td colspan="2">
                                    接收简历邮箱: <input type="text"
                                                   value="<#if entJobinfo?exists>${entJobinfo.hrMail!entCompany.email!}<#else>${entCompany.email!}</#if>"
                                                   id="receiveEmailVal" name="email">
                                </td>
                            </tr>
                            <tr>
                                <td width="25"></td>
                                <td colspan="2">
                                    自动发送邮箱: <input type="text"
                                                   value="<#if entJobinfo?exists>${entJobinfo.jobMail!}</#if>"
                                                   id="forwardEmail" name="forwardEmail">
                                    <span class="error" id="beError" style="display:none"></span>
                                </td>
                            </tr>
                            <tr>
                                <td width="25"></td>
                                <td colspan="2">
                                    <input type="button" value="预览" id="jobPreview" class="btn_32">
                                    <input type="button" value="发布" id="formSubmit" class="btn_32">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </dd>
            </dl>
        </div><!-- end .content -->

        <div id="issue_suc" class="content" style="display: none">
            <dl class="company_center_content">
                <dt>
                <h1>
                    <em></em>
                    发布新职位
                </h1>
                </dt>
                <dd>
                    <div class="ccc_tr">今日已发布 <span>1</span> 个职位</div>
                    <div class="publish_tip">
                        <h2>恭喜你，职位发布成功！</h2>
                        <a class="greylink" href="/issue">继续发布新职位</a><br>
                        <a class="greylink" href="/ent/${entCompany.companyId!}"> 进入我的公司主页</a><br>
                        <div style="float:left;" class="invite_share">
                            <!-- JiaThis Button BEGIN -->
                            <div class="jiathis_style_32x32">
                                <a class="jiathis_button_tsina" title="分享到新浪微博"><span
                                        class="jiathis_txt jiathis_separator jtico jtico_tsina">分享到新浪微博</span></a>
                            </div>
                            <!-- JiaThis Button END -->
                        </div>
                    </div>
                    <div class="weixin weixinSuc">
                        <div class="qr">
                            <img width="110" height="110"
                                 src="/resources/thirdparty/images/d1f91afa15eb451eaef4d14dcb3b54ec_318969.jpg">
                            <div>[仅限本人使用]</div>
                        </div>
                        <div class="qr_text">
                            <h3>关注微信服务号，可随时获取接收简历的通知 </h3>
                            关注方式：<br>
                            <span>打开微信 </span> <img width="30" height="30"
                                                    src="/resources/thirdparty/images/wx1.png"><span> →发现 </span>
                            <img width="31" height="30"
                                 src="/resources/thirdparty/images/wx2.png"><span> →扫一扫左侧二维码</span><img
                                width="78" height="29" src="/resources/thirdparty/images/wx3.png">
                        </div>
                    </div>
                </dd>
            </dl>
        </div><!-- end .content -->

        <div class="clear"></div>
        <input type="hidden" value="c29d4a7c35314180bf3be5eb3f00048f" id="resubmitToken">
        <a rel="nofollow" title="回到顶部" id="backtop" style="display: none;"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>
</body>
</html>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
<script type="text/javascript" src="/resources/thirdparty/js/excanvas.js"></script>
<![endif]-->
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/popup.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6605604a7755e5d4f1216b19d8dda1b1"></script>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("addr_map_big");
    var point = new BMap.Point(116.331398, 39.897445);
    map.centerAndZoom(point, 12);
    // 创建地址解析器实例
    var myGeo = new BMap.Geocoder();
    // 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("${entCompany.companyAddress!}", function (point) {
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        } else {
//            console.info("您选择地址没有解析到结果!");
        }
    }, "${entCompany.cityName!}");
</script>