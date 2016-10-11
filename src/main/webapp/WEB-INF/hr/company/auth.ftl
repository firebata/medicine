<!DOCTYPE HTML>
<html>
<head>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <link media="handheld" rel="alternate">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>申请认证-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <meta name="description" content="招徕网是普壳旗下的医学领域垂直招聘网站,医学职业机会尽在招徕网">
    <meta name="keywords"
          content="招徕网,招徕网,招徕网招聘,招徕网, 招徕网 ,医学行业招聘,招徕网医学行业招聘, 移动医学行业招聘, 垂直医学行业招聘, 微信招聘, 微博招聘, 招徕网官网, 招徕网百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
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
<#assign headerName="企业认证">
<#include "../../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">
    <#include "../../ftl/ent_sidebar.ftl">
        <div class="content">
            <dl class="company_center_content">
                <dt>
                <h1><em></em>申请企业/机构认证</h1>
                </dt>
                <dd>
                    <h4>申请企业/机构认证的标准</h4>
                    <ul class="c_certify_list">
                        <li class="list1">
                            公司的营业执照<span style="color:red; font-weight:bold;">*</span>
                            <div class="list1_child">

                                <div>
                                    1.1请提供有效年检期内的《企业法人营业执照》副本<br>
                                    1.2为保证信息安全，审核执照不提供预览功能，请谅解<br>
                                    1.3该营业执照招徕网只用作公司认证使用，请放心上传
                                </div>
                            </div>
                        </li>
                    </ul>
                    <div class="business_license">
                        <div class="license_upload">
                            <div id="licenceNo" style="background-color: #23B6D2;">
                                <span>上传公司营业执照副本</span>
                                <br>
                                支持jpg、png、gif、pdf格式，文件不超过10M
                            </div>
                        </div>
                        <input type="file" title="支持jpg、gif、png、jpeg格式，文件小于2M" onchange="$.auth_img_check(this);"
                               name="myfiles" id="myfiles">
                        <input type="hidden" name="company_licence_url" id="company_licence_url">
                        <input type="hidden" name="file_id" id="file_id">
                    </div>
                    <span class="error" id="licence_error" style="display:none;"></span>
                </dd>
            </dl>
        </div>
        <div class="clear"></div>
        <input type="hidden" value="" id="resubmitToken">
        <a rel="nofollow" title="回到顶部" id="backtop" style="display: none;"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>

<!--  -->


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
<script type="text/javascript" charset="utf-8" src="/resources/libs/js/ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/resources/libs/js/ueditor/umeditor.min.js"></script>
<script src="/resources/libs/js/jquery/ajaxfileupload.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/hr/company/auth.js" type="text/javascript"></script>