<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate" media="handheld"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>账号管理-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>

    <meta content="招徕网是普壳旗下的医学领域垂直招聘网站,医学职业机会尽在招徕网" name="description">
    <meta content="招徕网,护士招聘,招徕网招聘,招徕网, 招徕网 ,医学行业招聘,招徕网医学行业招聘, 移动医学行业招聘, 垂直医学行业招聘, 微信招聘, 微博招聘, 招徕网官网, 招徕网百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招"
          name="keywords">

    <link rel="Shortcut Icon" href="/resources/zlstatic/images/favicon.png">
    <link rel="stylesheet" type="text/css" href="/resources/zlstatic/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/thirdparty/css/external.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/thirdparty/css/popup.css"/>
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
<#assign headerName="修改密码">
<#include "../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">
        <div class="user_bindSidebar">
            <dl id="user_sideBarmenu" class="user_sideBarmenu">
                <dt>
                <h3>帐号设置</h3></dt>
                <dd><a href="/acmg">账号信息</a></dd>
                <dd><a class="hover" href="#">修改密码</a></dd>
            </dl>
        </div>
        <input type="hidden" id="hasSidebar" value="1">
        <div class="user_bindContent">
            <dl class="c_section">
                <dt>
                <h2><em></em>帐号信息</h2>
                </dt>
                <dd id="pad">
                    <ul class="user_noModify">
                        <input type="text" placeholder="请输入旧密码" name="password" id="password"/>
                        <span class="error" style="display:none;" id="beError"></span>
                    </ul>
                    <dl class="user_noModify">
                        <input type="text" placeholder="请输入新密码" name="passwordnew" id="passwordnew"/>
                        <input type="text" placeholder="请再次输入新密码" name="passwordnewrepeat" id="passwordnewrepeat"/>
                    </dl>
                    <input type="button" value="保存" id="uppwd" class="btn_32">
                </dd>
            </dl>
        </div>

        <div class="clear"></div>
        <a rel="nofollow" title="回到顶部" id="backtop"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../ftl/footer.ftl">
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
<script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
<script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/thirdparty/js/core.min.js"></script>
<script type="text/javascript" src="/resources/thirdparty/js/popup.min.js"></script>
<script type="text/javascript" src="/resources/zlstatic/js/router.js"></script>
<script type="text/javascript" src="/resources/zlstatic/js/common.js"></script>
<script type="text/javascript" src="/resources/zlstatic/js/sys/pwd.js"></script>
