<!DOCTYPE HTML>
<html>
<head>
    <script src="/resources/thirdparty/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>简历管理-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
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
<#assign headerName="简历管理">
<#include "../../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">
    <#include "../../ftl/ent_sidebar.ftl">
        <!-- end .sidebar -->
        <input type="hidden" value="${company_id!}" id="company_id" name="company_id" >
        <input type="hidden" value="${status!}" id="status">
        <input type="hidden" value="0" name="filterStatus" id="filterStatus">
        <div class="content">
            <dl class="company_center_content">
                <dt>
                <h1>
                    <div>
                        <em></em><span id="statusName">
                        <#switch status>
                            <#case '0'>
                                待处理简历
                                <#break>
                            <#case '1'>
                                待定简历
                                <#break>
                            <#case '2'>
                                已通知面试简历
                                <#break>
                            <#case '3'>
                                不合适简历
                                <#break>
                            <#case '4'>
                                自动过滤简历
                                <#break>
                            <#default>
                        </#switch>
                        </span> <span>（共<span id="recordCount">0</span>份）</span>
                    </div>
                </h1>
                </dt>
                <dd>
                    <form id="filterForm">
                        <div class="filter_actions ">
                            <label class="checkbox">
                                <input type="checkbox">
                                <i></i>
                            </label>
                            <span>全选</span>
                            <a id="resumeCrlAll" href="javascript:;" <#if (status == '1')>style="display: none;" </#if>>待定</a>
                            <a id="resumeNoticeAll" href="javascript:;" <#if (status == '2')>style="display: none;" </#if>>通知面试</a>
                            <a id="resumeRefuseAll" href="javascript:;" <#if (status == '3')>style="display: none;" </#if>>不合适</a>
                            <div id="filter_btn" class="show">筛选简历 <em></em></div>
                        </div><!-- end .filter_actions -->
                        <div class="filter_options  dn " style="display: none;">
                            <dl>
                                <dt>工作经验：</dt>
                                <dd>
                                    <a rel="-1" class="current" href="javascript:;">不限</a>
                                    <div id="wy_lists">
                                    <script id="work_year_template" type="text/x-handlebars-template">
                                        {{#each wy_com}}
                                        {{#ifequal type 'box_experience'}}
                                        <a rel={{key_name}} href="javascript:;">{{value_name}}</a>
                                        {{/ifequal}}
                                        {{/each}}
                                    </script>
                                    </div>
                                    <input type="hidden" value="-1" name="workExp">
                                </dd>
                            </dl>
                            <dl>
                                <dt>最低学历：</dt>
                                <dd id="education">
                                    <a rel="-1" class="current" href="javascript:;">不限</a>
                                    <div id="edu_lists">
                                    <script id="edu_template" type="text/x-handlebars-template">
                                        {{#each edu_com}}
                                        {{#ifequal type 'box_education'}}
                                        <a rel={{key_name}} href="javascript:;">{{value_name}}及以上</a>
                                        {{/ifequal}}
                                        {{/each}}
                                    </script>
                                    </div>
                                    <input type="hidden" value="-1" name="eduExp">
                                </dd>
                            </dl>

                        </div><!-- end .filter_options -->
                        <ul class="reset resumeLists">
                            <script id="resumes_template" type="text/x-handlebars-template">
                            {{#each res_com}}
                            <li data-id="{{employee_id}}" data2-id="{{job_id}}" class="onlineResume">
                                <label class="checkbox">
                                    <input type="checkbox">
                                    <i></i>
                                </label>
                                <div class="resumeShow">
                                    <div class="resumeIntro">
                                        <h3 class="unread">
                                            <a target="_blank" title="预览{{name}}的简历"
                                               href="resumeView.html?resumeId={{resume_id}}">
                                                {{name}}
                                            </a>
                                            <em></em>
                                        </h3>
                                        <span class="fr">投递时间：{{refresh_time}}</span>
                                        <span class="fr">应聘职位：<a title="{{ent_jobinfo.job_name}}" target="_blank" href="/job/{{code_job_id}}">{{job_name}}　　　</a></span>
                                        <div>
                                            {{sex_name}} / {{academic_name}} / {{seniority_name}} / {{area_id}}
                                            <br>
                                        </div>
                                        <div class="links">
                                            <!--
                                            <a data-resumename="{{name}}的简历" data-positionname="{{ent_jobinfo.job_name}}" data-deliverid={{resume_id}}
                                               data-positionid={{position_id}} data-resumekey="1ccca806e13637f7b1a4560f80f08057"
                                               data-forwardcount="1" class="resume_forward" href="javascript:void(0)">
                                                转发
                                                <span>(1人)</span>
                                            </a>
                                            -->
                                            {{#noequal status_id 1}}
                                            <a class="resume_caninterview" href="javascript:void(0)">待定</a>
                                            {{/noequal}}
                                            {{#noequal status_id 2}}
                                            <a class="resume_notice" href="javascript:void(0)">通知面试</a>
                                            {{/noequal}}
                                            {{#noequal status_id 3}}
                                            <a class="resume_refuse" href="javascript:void(0)">不合适</a>
                                            {{/noequal}}
                                        </div>
                                    </div>
                                </div>
                            </li>
                            {{/each}}
                            </script>
                        </ul><!-- end .resumeLists -->
                    </form>
                </dd>
                <div class="pages">
                    一共<dev class="list_total">0</dev>条记录　共<dev class="page_total">0</dev>页
                    <span class="first disable">首页</span>
                    <span class="prev disable">上一页</span>
                    <span class="next">下一页</span>
                    <span class="last">尾页</span>
                </div>
            </dl><!-- end .company_center_content -->
        </div><!-- end .content -->
        <br/>
        <a rel="nofollow" title="回到顶部" id="backtop"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
<#include "../../ftl/footer.ftl">
</div>
</body>
</html>
<script type="text/javascript" src="/resources/thirdparty/js/jquery.1.10.1.min.js"></script>
<script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/thirdparty/js/ajaxfileupload.js"></script>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>
<script src="/resources/libs/js/handlebars/handlebars-v4.0.5.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/zlstatic/js/hr/position/resume.js"></script>
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/popup.min.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/router.js" type="text/javascript"></script>
<script src="/resources/zlstatic/js/common.js" type="text/javascript"></script>