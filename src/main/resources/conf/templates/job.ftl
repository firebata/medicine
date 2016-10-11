<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>${entJobinfo.jobName!}-${entJobinfo.entCompany.companyName!}招聘-${entJobinfo.jobName!}-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <meta name="description" content="${entJobinfo.entCompany.companyName!}招聘,${entJobinfo.jobName!}">
    <meta name="keywords" content="${entJobinfo.entCompany.companyName!}招聘,${entJobinfo.jobName!}">
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
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
    <div id="header">
        <div class="wrapper">
            <a href="/index.html" class="logo">
                <img src="/resources/zlstatic/images/logo.png" width="229" height="43" alt="招徕网招聘-专注医学生物行业招聘"/>
            </a>
            <ul class="reset" id="navheader">
                <li><a href="/index.html">首页</a></li>
                <!--<li><a href="#">毕业，遇见你</a></li>-->
                <li class="current"><a href="#" rel="nofollow">职位信息</a></li>
                <li><a href="/feedback.html" rel="nofollow">联系我们</a></li>
            </ul>
            <ul class="loginTop" id="loginTopId">
                <li><a href="/login.html" rel="nofollow">登录</a></li>
                <li>|</li>
                <li><a href="/register.html" rel="nofollow">注册</a></li>
            </ul>
            <dl class="collapsible_menu" id="collapsible_menu_0" style="display:none;">
                <dt>
                    <!-- todo -->
                    <span>&nbsp;</span>
                    <span class="red dn" id="noticeDot-0"></span>
                    <i></i>
                </dt>
                <dd><a rel="nofollow" href="/jianli">我的简历</a></dd>
                <dd><a href="/acmg">帐号管理</a></dd>
                <dd class="logout"><a rel="nofollow">退出</a></dd>
            </dl>
            <dl class="collapsible_menu" id="collapsible_menu_1" style="display:none;">
                <dt>
                    <span>&nbsp;</span>
                    <span class="red dn" id="noticeDot-1"></span>
                    <i></i>
                </dt>
                <dd style="display: none;"><a href="/myresumes/0">简历管理</a></dd>
                <dd style="display: none;"><a href="/mypositions/1">职位管理</a></dd>
                <dd class="btm" style="display: none;"><a href="/company_edit">公司主页</a></dd>
                <dd style="display: none;"><a href="/acmg">帐号管理</a></dd>
                <dd class="logout" style="display: none;"><a rel="nofollow">退出</a></dd>
            </dl>
        </div>
    </div><!-- end #header -->
    <div id="container">
        <div class="clearfix">
            <div class="content_l">
                <dl class="job_detail">
                    <dt>
                    <h1 title=${entJobinfo.jobName!}<>
                        <em></em>
                        <div>${entJobinfo.jobTypeName!entJobinfo.jobTypeSubName!}招聘</div>
                    ${entJobinfo.jobName!}
                    </h1>

                    <!--
                                        <div class="jd_collection" id="jobCollection">
                                            <div class="jd_collection_success">
                                                <span>已成功收藏该职位，</span>
                                                <a class="jd_collection_page" href="mycenter/collections.html">查看全部</a>
                                                <a class="jd_collection_x" href="javascript:;"></a>
                                            </div>
                                        </div>
                                        -->
                    </dt>
                    <dd class="job_request">
                    <#if entJobinfo.payroll?exists><span class="btn_job_detail_item">${entJobinfo.payroll!}</span></#if>
                        <input type="button" value="申请职位" id="applyPosition" class="btn_job_detail">
                        <br/>
                    <#if entJobinfo.cityName?exists><span>${entJobinfo.cityName!}</span></#if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${entJobinfo.publishDate!}<br/>
                    <#if entJobinfo.experienceName?exists><span
                            class="btn_job_detail_desc">${entJobinfo.experienceName!}</span></#if>
                    <#if entJobinfo.educationName?exists><span class="btn_job_detail_desc">${entJobinfo.educationName!}
                        及以上</span></#if>
                    <#if entJobinfo.payroll?exists> <span span
                                                          class="btn_job_detail_desc">${(entJobinfo.jobNatureName!?length>0)?string((entJobinfo.jobNatureName!),"全职")}</span></#if>
                        <span span class="btn_job_detail_desc">招聘人数: <#if entJobinfo.quantity == 0>
                            1<#else> ${entJobinfo.quantity} </#if></span>
                        <br>
                    <#--职位诱惑 : ${(entJobinfo.jobWelfare!?length>0)?string((entJobinfo.jobWelfare!),"福利好！")}-->

                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">职位描述</h3>
                    <#if entJobinfo.payroll?exists>
                    ${entJobinfo.jobDesc!}
                    <#else>
                    ${entJobinfo.jobName!}
                    </#if>
                    </dd>

                </dl>
                <div id="weibolist"></div>
            </div>
            <div class="content_r">
                <dl class="job_company">
                <#assign tmp = entJobinfo.entCompany!>
                    <dt>
                        <a target="_blank" href="/ent/${entJobinfo.companyId!}">
                            <img width="80" height="80" alt="${entJobinfo.entCompany.companyName!}"
                                 src="<#if (tmp.companyLogoUrl?exists) && (tmp.companyLogoUrl?index_of('.')!=-1)>${tmp.companyLogoUrl!}</#if>"
                                 class="b2">
                            <div>
                                <a rel="nofollow" title="/ent/${entJobinfo.companyId!}" target="_blank"
                                   href="/ent/${entJobinfo.companyId!}">
                                    <h2 class="fl">
                                    ${entJobinfo.entCompany.companyName!}
                                    </h2>
                                </a>
                            </div>
                        </a>
                    </dt>
                    <dd>
                        <ul class="c_feature reset">
                            <li><span>领域</span> ${tmp.industryName!}</li>
                            <li><span>规模</span> ${tmp.companySizeName!}</li>
                        <#if (tmp.url!?length>0)>
                            <li>
                                <span>主页</span>
                                <a rel="nofollow" title=${tmp.url!tmp.comUrl!}target="_blank"
                                   href="${tmp.url!tmp.comUrl!}">${tmp.url!tmp.comUrl!}</a>
                            </li>
                        </#if>
                        </ul>

                        <h4>工作地址</h4>
                        <div>${entJobinfo.address!}</div>
                        <div class="item_con_map" id="addr_map"></div>
                    </dd>
                </dl>
            </div>
        </div>

        <div id="tipOverlay"></div>
    </div><!-- end #body -->
    <div id="footer">
        <div class="wrapper">
            <a rel="nofollow" target="_blank" href="/feedback.html">联系我们</a>
            <a rel="nofollow" target="_blank" href="http://e.weibo.com/zzlinks617">招徕网微博</a>
            <a rel="nofollow" href="javascript:void(0)" class="footer_qr">招徕网微信<i></i></a>
            <div class="copyright">© 2015-2016 版权所有：广州普壳软件有限公司<a
                    href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">粤ICP备16030873号-1</a>
            </div>
        </div>
    </div>

</body>
</html>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6605604a7755e5d4f1216b19d8dda1b1"></script>
<script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
<script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("addr_map");
    var point = new BMap.Point(116.331398, 39.897445);
    map.centerAndZoom(point, 12);
    // 创建地址解析器实例
    var myGeo = new BMap.Geocoder();
    // 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("${entJobinfo.address!}", function (point) {
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        } else {
            console.info("您选择地址没有解析到结果!");
        }
    }, "${entJobinfo.cityName!}");

    $(function () {
        $("#applyPosition").bind("click", function () {
            applyJob();
        });

        function applyJob() {
            $("#applyPosition").attr("disabled", "disabled");
            $("#applyPosition").css("background-color", "#888080");
            var applyInfo = {
                company_id: '${entJobinfo.companyId!}',
                job_id: '${entJobinfo.jobId!}',
                job_name: '${entJobinfo.jobName!}'
            };
            addApplyInfo(applyInfo);
            setTimeout(function () {
                $("#applyPosition").removeAttrs("disabled");
                $("#applyPosition").css("background-color", "#fa9200");
            }, 1500);
        }
    });

    function addApplyInfo(applyInfo) {
        $.addCnfwsy(empJobApply, applyInfo, _done, _fail);
    }

    function _done(data) {
        showmsg("成功申请职位！");
    }

    function _fail(rtn_msg) {
        showmsg(rtn_msg);
    }

    function showmsg(msg) {
        var c = $(".showmsg").attr("class");
        if (c == 'showmsg') {
            $(".showmsg").fadeIn(100);
            $(".showmsg>span").text(msg);
        } else {
            var htm = '<div class="showmsg"><span>' + msg + '</span></div>';
            $("body").append(htm);
            $(".showmsg").fadeIn(100);
        }
        setTimeout(function () {
            $(".showmsg").fadeOut(100);
        }, 1500);
    }
</script>