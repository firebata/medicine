<html>
<head>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>${entJobinfo.entCompany.companyName!}招聘-${entJobinfo.jobName!}-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
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
</head>
<body>
<div id="body">
<#assign headerName="职位管理">
<#include "../../ftl/header.ftl">
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
                    <div style="float:right">
                        <a href="/edit/${entJobinfo.jobId!}" target="_self"><input type="button" value="修改"
                                                                                   class="btn_33"></a>
                    </div>

                    </dt>
                    <dd class="job_request">
                        <span class="red">${entJobinfo.payroll!}</span>
                        <span>${entJobinfo.cityName!}</span>
                        <span>${entJobinfo.experienceName!}</span>
                        <span>${entJobinfo.educationName!}及以上</span><br>
                        <span>${(entJobinfo.jobNatureName!?length>0)?string((entJobinfo.jobNatureName!),"全职")}</span>
                        <span>招聘人数: ${entJobinfo.quantity!0}</span><br>
                        职位诱惑 : ${(entJobinfo.jobWelfare!?length>0)?string((entJobinfo.jobWelfare!),"福利好！")}
                        <div>发布时间：${entJobinfo.publishDate!}</div>
                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">职位描述</h3>
                    ${entJobinfo.jobDesc!}
                    </dd>

                </dl>
                <div id="weibolist"></div>
            </div>
            <div class="content_r">
                <dl class="job_company">
                <#assign tmp = entJobinfo.entCompany!>
                    <dt>
                        <a target="_blank" href="/ent/${tmp.companyId!}">
                            <img width="80" height="80" alt=${tmp.companyName!}
                                    src="${tmp.companyLogoUrl!}" class="b2">
                            <div>
                                <a rel="nofollow" title="/ent/${tmp.companyId!}" target="_blank"
                                   href="/ent/${tmp.companyId!}">
                                    <h2 class="fl">
                                    ${tmp.companyName!}
                                    </h2>
                                </a>
                            </div>
                        </a>
                    </dt>
                    <dd>
                        <ul class="c_feature reset">
                            <li><span>领域</span> ${tmp.industryName!}</li>
                            <li><span>规模</span> ${tmp.companySizeName!}</li>
                        <#if (tmp.url!?exists)>
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
    <#include "../../ftl/footer.ftl">
    </div>

</body>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=6605604a7755e5d4f1216b19d8dda1b1"></script>
<script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
<script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
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
</script>
</html>