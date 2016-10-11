<!DOCTYPE HTML>
<html>
<head>
    <script src="/resources/thirdparty/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>职位管理-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/resources/thirdparty/js/jquery.1.10.1.min.js"></script>
    <script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="/resources/zlstatic/js/hr/position/position.js"></script>
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
    <!-- end #header -->
    <input type="hidden" value="${company_id!}" id="company_id">
    <input type="hidden" value="${online!}" id="online">
    <div id="container">
    <#include "../../ftl/ent_sidebar.ftl">
    <!-- end .sidebar -->
        <div class="content">
            <dl class="company_center_content">
                <dt>
                <h1>
                    <div id="statusName">
                    <em></em>有效职位<span>（共<i style="color:#fff;font-style:normal" id="positionNumber">0</i>个)</span>
                    </div>
                </h1>
                </dt>
                <dd>
                    <form id="searchForm">
                        <input type="hidden" value="Publish" name="type">
                        <ul id=""class="reset my_jobs">

                        </ul>
                    </form>
                </dd>
                <div class="pages">
                    一共<dev class="list_total">0</dev>条记录　共<dev class="page_total">0</dev>页
                    <span class="first disable">首页</span>
                    <span class="prev disable">上一页</span>
                    <span class="next">下一页</span>
                    <span class="last">尾页</span>
                </div>
            </dl>
        </div><!-- end .content -->
        <script src="/resources/thirdparty/js/job_list.min.js" type="text/javascript"></script>
        <div class="clear"></div>
        <a rel="nofollow" title="回到顶部" id="backtop"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>

<div id="cboxOverlay" style="display: none;"></div>
<div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
    <div id="cboxWrapper">
        <div>
            <div id="cboxTopLeft" style="float: left;"></div>
            <div id="cboxTopCenter" style="float: left;"></div>
            <div id="cboxTopRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxMiddleLeft" style="float: left;"></div>
            <div id="cboxContent" style="float: left;">
                <div id="cboxTitle" style="float: left;"></div>
                <div id="cboxCurrent" style="float: left;"></div>
                <button type="button" id="cboxPrevious"></button>
                <button type="button" id="cboxNext"></button>
                <button id="cboxSlideshow"></button>
                <div id="cboxLoadingOverlay" style="float: left;"></div>
                <div id="cboxLoadingGraphic" style="float: left;"></div>
            </div>
            <div id="cboxMiddleRight" style="float: left;"></div>
        </div>
        <div style="clear: left;">
            <div id="cboxBottomLeft" style="float: left;"></div>
            <div id="cboxBottomCenter" style="float: left;"></div>
            <div id="cboxBottomRight" style="float: left;"></div>
        </div>
    </div>
    <div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div>
</div>
</body>
</html>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/popup.min.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>