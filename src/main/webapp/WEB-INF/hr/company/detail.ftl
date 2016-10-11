<html>
<head>
    <script src="/resources/thirdparty/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>${entCompany.companyName!}招聘-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <meta name="description" content="${entCompany.companyName!}招聘,${entCompany.companyName!}">
    <meta name="keywords" content="${entCompany.companyName!}招聘,${entCompany.companyName!}">
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
    <link href="/resources/zlstatic/css/company.detail.css" type="text/css" rel="stylesheet">
    <script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
    <script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
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
    <script>
        (function(){
            var bp = document.createElement('script');
            var curProtocol = window.location.protocol.split(':')[0];
            if (curProtocol === 'https'){
                bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
            }
            else{
                bp.src = 'http://push.zhanzhang.baidu.com/push.js';
            }
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(bp, s);
        })();
    </script>
</head>
<body>
<div id="body">
<#assign headerName="企业信息">
<#include "../../ftl/header.ftl">
    <input type="hidden" value="${entCompany.companyId!}" id="company_id" name="company_id" >
    <div class="top_info">
        <div class="top_info_wrap">
            <img src=${entCompany.companyLogoUrl!"/resources/thirdparty/images/logo_default.png"} alt="${entCompany.companyName!"公司"}Logo" width="164" heihgt="164" />
            <div class="company_info">
                <div class="company_main">
                    <h1>
                        <a  href="${entCompany.comUrl!}" class="hovertips" target="_blank" rel="nofollow" title="${entCompany.companyName!}">
                        ${entCompany.companyName!}
                        </a>
                    </h1>
                    <div class="company_word">
                    ${entCompany.industryName!}
                    </div>
                </div>
                <div class="company_data">
                    <ul>
                        <li>
                            <strong>
                                <dev id="list_count">0</dev>个
                            </strong>
                            <br />
                        <span class="tipsys" original-title="公司的在招职位数量">
                            <span>招聘职位</span>
                        </span>
                        </li>
                        <!--
                        <li>
                            <strong>
                                81%
                            </strong>
                        <span class="tipsys" original-title="公司在投递后7天内处理完成的简历所占比例">
                            <span>简历及时处理率</span>
                        </span>
                        </li>
                        <li>
                            <strong>
                                3天
                            </strong>
                            <br />
                        <span class="tipsys" original-title="公司处理简历平均用时">
                            <span>简历处理用时</span>
                        </span>
                        </li>
                        -->
                        <li>
                            <strong>今天</strong><br />
                        <span class="tipsys" original-title="HR最近一次登录时间">
                            <span>企业最近登录</span>
                        </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div id="company_navs" class="company_navs">
        <div class="company_navs_wrap">
            <ul>
                <li id="navsCpyLi" class="current" >
                    <a onclick="navsCpyLi();">公司主页</a>
                </li>
                <li id="navsPstLi">
                    <a onclick="navsPstLi();">招聘职位（<span class="list_total">0</span>）</a>
                </li>
            </ul>
            <div class="company_share">
                <span>分享</span>
                <a href="javascript:;" class="share_weibo" rel="nofollow" title="分享到微博"></a>
                <a href="javascript:;" class="share_weixin" rel="nofollow" title="分享到微信"></a>
                <div class="share_weixin_success">
                    <img alt="移动端公司主页二维码" />
                </div>
            </div>
        </div>
    </div>


    <div id="main_container">

        <div id="container_left">
            <div id="containerCompanyDetails">
                <div id="company_info">
                    <div class="item_container" id="company_intro">
                        <div class="item_ltitle">公司介绍</div>
                        <div class="item_content">
                            <div class="company_intro_text">
                            ${entCompany.summary!"无"}
                            </div>
                        </div>
                    </div>

                    <div class="address_container item_container" id="location_container">
                        <div class="item_ltitle">公司位置</div>
                        <div class="item_content">
                            <div class="item_con_map" id="addr_map_big"></div>
                            <div class="item_con_mlist">
                                <ul class="con_mlist_ul">
                                    <li class="mlist_ul_li mlist_li_open">
                                        <p class="mlist_li_desc">
                                        ${entCompany.companyAddress!}
                                        </p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="positionlist_info" class="posfilterlist_container item_container" style="display: none">
                    <div class="item_ltitle">
                        共有 <span class="list_total">0</span> 个在招职位
                    </div>
                    <div class="item_content">
                        <!--
                        <div class="item_con_filter">
                            <ul class="con_filter_ul">
                                <li  class="con_filter_li no_select selected">
                                    全部
                                </li>
                                <script id="job_type_template" type="text/x-handlebars-template">
                                    {{#each job_type_list}}
                                    <li  class="con_filter_li no_select">{{job_type_name}}</li>
                                    {{/each}}
                                </script>
                            </ul>
                        </div>
                        -->
                        <div class="item_con_list_container">
                            <div class="item_con_list_container">
                                <div class="list-content">
                                    <ul class="item_con_list">
                                        <script id="job_list_template" type="text/x-handlebars-template">
                                            {{#each job_list}}
                                            <li class="con_list_item" data-positionid={{job_id}} data-salary={{payroll}}
                                                data-company={{company_name}} data-positionname={{job_name}}
                                                onmouseover="this.style.background='whitesmoke';" onmouseout="this.style.background='white'">
                                                <p class="item_title_date">
                                                    <a href="/job/{{job_id}}"
                                                            target="_blank" class="item_title position_link" rel="nofollow">{{job_name}}[ {{city_name}} ]</a>
                                                    <span class="item_date">{{publish_date}} 发布</span>
                                                </p>
                                                <p class="item_detail">
                                                    <span class="item_salary">{{payroll}}</span>
                                                    <span class="item_desc">{{experience_name}} / {{education_name}} / {{job_nature_name}}</span>
                                                </p>
                                                <i class="left_border"></i>
                                            </li>
                                            {{/each}}
                                        </script>
                                    </ul>
                                </div>

                                <div class="pages">
                                    一共<dev class="list_total">0</dev>条记录　共<dev class="page_total">0</dev>页
                                    <span class="first disable">首页</span>
                                    <span class="prev disable">上一页</span>
                                    <span class="next">下一页</span>
                                    <span class="last">尾页</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

        <div id="container_right">
            <div class="item_container" id="basic_container">
                <div class="item_ltitle">公司基本信息</div>
                <div class="item_content">
                    <ul>
                        <li>
                            <i class="type"></i>
                            <span>${entCompany.industryName!"无"}</span>
                        </li>
                        <li>
                            <i class="process"></i>
                            <span>${entCompany.companyTypeName!"无"}</span>
                        </li>
                        <li>
                            <i class="number"></i>
                            <span>${entCompany.companySizeName!"无"}</span>
                        </li>
                        <li>
                            <i class="address"></i>
                            <span>${entCompany.cityName!"无"}</span>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="tags_container item_container">
                <div class="item_ltitle">公司标签</div>
                <div class="tags_warp">
                    <div class="item_content">
                        <ul class="item_con_ul clearfix">
                            <li class="con_ul_li">
                                节日礼物
                            </li>
                            <li class="con_ul_li">
                                技能培训
                            </li>
                            <li class="con_ul_li">
                                绩效奖金
                            </li>
                            <li class="con_ul_li">
                                年度旅游
                            </li>
                            <li class="con_ul_li">
                                岗位晋升
                            </li>
                            <li class="con_ul_li">
                                管理规范
                            </li>
                            <li class="con_ul_li">
                                五险一金
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br><br>
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>
</body>
</html>

<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/zlstatic/js/common.js"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/zlstatic/js/hr/company/com_detail.js"></script>
<script src="/resources/libs/js/handlebars/handlebars-v4.0.5.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6605604a7755e5d4f1216b19d8dda1b1"></script>
<script type="text/javascript">
    function navsPstLi() {
        $('#navsCpyLi').removeClass("current");
        $('#navsCpyLi').removeAttr('style');
        $('#navsPstLi').css('border-bottom', '2px solid #23B6D2');
        $('#company_info').css('display','none');
        $('#positionlist_info').css('display','block');
    }
    function navsCpyLi() {
        $('#navsPstLi').removeAttr('style');
        $('#navsCpyLi').css('border-bottom', '2px solid #23B6D2');
        $('#company_info').css('display','block');
        $('#positionlist_info').css('display','none');
    }

    // 百度地图API功能
    var map = new BMap.Map("addr_map_big");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
    // 创建地址解析器实例
    var myGeo = new BMap.Geocoder();
    // 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("${entCompany.companyAddress!}", function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            console.info("您选择地址没有解析到结果!");
        }
    }, "${entCompany.cityName!}");
</script>