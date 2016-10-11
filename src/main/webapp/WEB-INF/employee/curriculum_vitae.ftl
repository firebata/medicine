<!DOCTYPE HTML>
<html>
<head>
    <style type="text/css"></style>
    <meta content="no-siteapp" http-equiv="Cache-Control">
    <link media="handheld" rel="alternate">
    <meta charset="utf-8">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <title>我的简历-招徕网-专业的医疗生物职业求职平台-中国卫生人才网</title>
    <meta content="23635710066417756375" property="qc:admins">
    <meta name="description"
          content="招徕网(www.zzlinks.cn)专业医疗卫生生物人才网,提供最新医生招聘,护士招聘,医药英才,医院招聘,生物招聘,中国医疗卫生生物人才网,中国卫生人才网,医学人才网招聘首选招徕网">
    <meta name="keywords"
          content="招徕网,招徕网,招徕网招聘,招徕网, 招徕网 ,医学行业招聘,招徕网医学行业招聘, 移动医学行业招聘, 垂直医学行业招聘, 微信招聘, 微博招聘, 招徕网官网, 招徕网百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
    <meta content="QIQ6KC1oZ6" name="baidu-site-verification">
    <link href="/resources/zlstatic/images/favicon.png" rel="Shortcut Icon">
    <link href="/resources/zlstatic/css/common.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/external.min.css" type="text/css" rel="stylesheet">
    <link href="/resources/thirdparty/css/popup.css" type="text/css" rel="stylesheet">
    <script src="/resources/libs/js/jquery/jquery.1.10.1.min.js" type="text/javascript"></script>
    <script src="/resources/libs/js/jquery/jquery.lib.min.js" type="text/javascript"></script>
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
<#assign headerName="我的简历">
<#include "../ftl/header.ftl">
    <!-- end #header -->
    <div id="container">

        <div class="clearfix">
            <div class="content_l">
                <div class="fl" id="resume_name">
                    <div class="nameShow fl" id="curriculum_title">
                        <!-- <h1 title="韩梅梅的简历">韩梅梅的简历</h1>-->
                        <!--<span class="rename" hidden>重命名</span>-->
                    </div>

                </div><!--end #resume_name-->
                <div class="fr c5" id="lastChangedTime" hidden>最后一次更新：</div>
                <!--end #lastChangedTime-->
                <div id="resumeScore" hidden>
                    <div class="score fl">
                        <canvas height="120" width="120" id="doughnutChartCanvas"
                                style="width: 120px; height: 120px;"></canvas>
                        <div style="" class="scoreVal"><span>80</span>分</div>
                    </div>

                    <div class="which fl">
                        <div>工作经历最能体现自己的工作能力，且完善后才可投递简历哦！</div>
                        <span rel="workExperience"><a>马上去完善</a></span>
                    </div>
                </div><!--end #resumeScore-->

                <div class="profile_box" id="basicInfo">
                    <h2>基本信息</h2>
                    <span class="c_edit"></span>
                    <div class="basicShow">


                    </div><!--end .basicShow-->

                    <div class="basicEdit dn">

                        <form id="profileForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="姓名" name="name" id="name">
                                        <input type="hidden" name="employee_id" id="employee_id" value="${employee_id}">
                                        <input type="hidden" name="account_id" id="account_id">
                                    </td>
                                    <td valign="top"></td>
                                    <td>
                                        <ul class="profile_radio clearfix reset">
                                            <li>
                                                <span>男<em></em></span>
                                                <input type="radio" name="sex_name" value="男">
                                            </li>
                                            <li class="current">
                                                <span>女<em></em></span>
                                                <input type="radio" checked="checked" name="sex_name" value="女">
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="hidden" id="academic_name" value="1" name="academic_name">
                                        <input type="button" value="大专" id="select_topDegree"
                                               class="profile_select_190 profile_select_normal">
                                        <div class="boxUpDown boxUpDown_190 dn" id="box_topDegree"
                                             style="display: none;">
                                            <ul>
                                                <li>大专</li>
                                                <li>本科</li>
                                                <li>硕士</li>
                                                <li>博士</li>
                                                <li>其他</li>
                                            </ul>
                                        </div>
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="hidden" id="seniority_name" value="" name="seniority_name">
                                        <input type="button" value="" id="select_workyear"
                                               class="profile_select_190 profile_select_normal">
                                        <div class="boxUpDown boxUpDown_190 dn" id="box_workyear"
                                             style="display: none;">
                                            <ul>
                                                <li>应届毕业生</li>
                                                <li>1年</li>
                                                <li>2年</li>
                                                <li>3年</li>
                                                <li>4年</li>
                                                <li>5年</li>
                                                <li>6年</li>
                                                <li>7年</li>
                                                <li>8年</li>
                                                <li>9年</li>
                                                <li>10年</li>
                                                <li>10年以上</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td colspan="3">
                                        <input type="text" placeholder="手机号码" value="18644444444" name="phone"
                                               id="phone">
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td colspan="3">
                                        <input type="text" placeholder="接收面试通知的邮箱" value="111" name="mail_box"
                                               id="mail_box">
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top"></td>
                                    <td colspan="3">
                                        <input type="hidden" id="state_name" value="" name="state_name">
                                        <input type="button" value="目前状态" id="select_currentState"
                                               class="profile_select_410 profile_select_normal">
                                        <div class="boxUpDown boxUpDown_410 dn" id="box_currentState"
                                             style="display: none;">
                                            <ul>
                                                <li>我目前已离职，可快速到岗</li>
                                                <li>我目前正在职，正考虑换个新环境</li>
                                                <li>我暂时不想找工作</li>
                                                <li>我是应届毕业生</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="3">
                                        <input type="button" value="保 存" class="btn_profile_save" id="basicFormButton"
                                               onclick="curriculum_vitae.submitBasic();">
                                        <a class="btn_profile_cancel" href="javascript:;" id="basicFormCancel">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form><!--end #profileForm-->
                        <div class="new_portrait">
                            <div class="portrait_upload" id="portraitNo">
                                <span>上传自己的头像</span>
                            </div>
                            <div class="portraitShow dn" id="portraitShow">
                                <img width="120" height="120" src="">
                                <span>更换头像</span>
                            </div>

                            <input type="file" title="支持jpg、gif、png、jpeg格式，文件小于2M" onchange="img_check(this);"
                                   name="myfiles" id="myfiles">
                            <input type="hidden" name="portraitNo_url" id="portraitNo_url">
                            <input type="hidden" name="file_id" id="file_id">
                            <em>
                                尺寸：120*120px <br>
                                大小：小于5M
                            </em>
                            <span style="display:none;" id="headPic_error" class="error"></span>
                        </div><!--end .new_portrait-->
                    </div><!--end .basicEdit-->
                    <input type="hidden" id="nameVal">
                    <input type="hidden" id="genderVal">
                    <input type="hidden" id="topDegreeVal">
                    <input type="hidden" id="workyearVal">
                    <input type="hidden" id="currentStateVal">
                    <input type="hidden" id="emailVal">
                    <input type="hidden" id="telVal">
                    <input type="hidden" id="pageType">
                    <input type="hidden" id="updateType">
                </div><!--end #basicInfo-->

                <div class="profile_box" id="expectJob">
                    <h2>期望工作</h2>
                    <span class="c_edit dn"></span>
                    <div class="expectShow">
                        <span></span>
                    </div><!--end .expectShow-->
                    <!--<div class="expectList">

                    </div>&lt;!&ndash; end expectList&ndash;&gt;-->
                    <div class="expectEdit dn">
                        <form id="expectForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td>
                                        <input type="hidden" id="area_name" value="" name="area_name">
                                        <input type="button" value="期望城市，如：广州" id="select_expectCity"
                                               class="profile_select_287 profile_select_normal">
                                        <div class="boxUpDown boxUpDown_596 dn" id="box_expectCity"
                                             style="display: none;">
                                            <dl>
                                                <dt>热门城市</dt>
                                                <dd>
                                                    <span>北京</span>
                                                    <span>上海</span>
                                                    <span>广州</span>
                                                    <span>深圳</span>
                                                    <span>成都</span>
                                                    <span>杭州</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>ABCDEF</dt>
                                                <dd>
                                                    <span>北京</span>
                                                    <span>长春</span>
                                                    <span>成都</span>
                                                    <span>重庆</span>
                                                    <span>长沙</span>
                                                    <span>常州</span>
                                                    <span>东莞</span>
                                                    <span>大连</span>
                                                    <span>佛山</span>
                                                    <span>福州</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>GHIJ</dt>
                                                <dd>
                                                    <span>贵阳</span>
                                                    <span>广州</span>
                                                    <span>哈尔滨</span>
                                                    <span>合肥</span>
                                                    <span>海口</span>
                                                    <span>杭州</span>
                                                    <span>惠州</span>
                                                    <span>金华</span>
                                                    <span>济南</span>
                                                    <span>嘉兴</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>KLMN</dt>
                                                <dd>
                                                    <span>昆明</span>
                                                    <span>廊坊</span>
                                                    <span>宁波</span>
                                                    <span>南昌</span>
                                                    <span>南京</span>
                                                    <span>南宁</span>
                                                    <span>南通</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>OPQR</dt>
                                                <dd>
                                                    <span>青岛</span>
                                                    <span>泉州</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>STUV</dt>
                                                <dd>
                                                    <span>上海</span>
                                                    <span>石家庄</span>
                                                    <span>绍兴</span>
                                                    <span>沈阳</span>
                                                    <span>深圳</span>
                                                    <span>苏州</span>
                                                    <span>天津</span>
                                                    <span>太原</span>
                                                    <span>台州</span>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>WXYZ</dt>
                                                <dd>
                                                    <span>武汉</span>
                                                    <span>无锡</span>
                                                    <span>温州</span>
                                                    <span>西安</span>
                                                    <span>厦门</span>
                                                    <span>烟台</span>
                                                    <span>珠海</span>
                                                    <span>中山</span>
                                                    <span>郑州</span>
                                                </dd>
                                            </dl>
                                        </div>
                                    </td>
                                    <td>
                                        <ul class="profile_radio clearfix reset">
                                            <li class="current">
                                                全职<em></em>
                                                <input type="radio" checked="" name="type_name" value="全职">
                                            </li>
                                            <li>
                                                兼职<em></em>
                                                <input type="radio" name="type_name" value="兼职">
                                            </li>
                                            <li>
                                                实习<em></em>
                                                <input type="radio" name="type_name" value="实习">
                                            </li>
                                        </ul>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" placeholder="期望职位，如：产品经理" value="" name="position_name"
                                               id="position_name">
                                    </td>
                                    <td>
                                        <input type="hidden" id="salary_name" value="" name="salary_name">
                                        <input type="button" value="期望月薪" id="select_expectSalary"
                                               class="profile_select_287 profile_select_normal">
                                        <div class="boxUpDown boxUpDown_287 dn" id="box_expectSalary"
                                             style="display: none;">
                                            <ul>
                                                <li>2k以下</li>
                                                <li>2k-5k</li>
                                                <li>5k-10k</li>
                                                <li>10k-15k</li>
                                                <li>15k-25k</li>
                                                <li>25k-50k</li>
                                                <li>50k以上</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="保 存" id="expectShowButton" class="btn_profile_save"
                                               onclick="curriculum_vitae.submitExpectForm()">
                                        <a class="btn_profile_cancel" id="empResExpectCancel" href="javascript:;">取
                                            消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form><!--end #expectForm-->
                    </div><!--end .expectEdit-->
                    <div class="expectAdd pAdd dn">
                        填写准确的期望工作能大大提高求职成功率哦…<br>
                        快来添加期望工作吧！
                        <span>添加期望工作</span>
                    </div><!--end .expectAdd-->

                    <input type="hidden" id="expectJobVal" value="">
                    <input type="hidden" id="expectCityVal" value="">
                    <input type="hidden" id="typeVal" value="">
                    <input type="hidden" id="expectPositionVal" value="">
                    <input type="hidden" id="expectSalaryVal" value="">
                    <input type="hidden" id="controllFlag">
                </div><!--end #expectJob-->

                <div class="profile_box" id="workExperience">
                    <h2>工作经历 <span> （投递简历时必填）</span></h2>
                    <span class="c_add dn"></span>
                    <div class="experienceShow dn">
                        <ul class="wlist clearfix">
                        </ul>
                        <form class="experienceForm borderBtm dn">
                            <table id="experienceFormTable">
                                <tbody>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="公司名称" name="company_name" class="company_name">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="职位名称，如：产品经理" name="company_position_name"
                                               class="position_name">
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="companyYearStart" value=""
                                                   name="company_start_year">
                                            <input type="button" value="开始年份"
                                                   class="profile_select_139 profile_select_normal select_companyYearStart">
                                            <div class="box_companyYearStart boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="companyMonthStart" value=""
                                                   name="company_start_month">
                                            <input type="button" value="开始月份"
                                                   class="profile_select_139 profile_select_normal select_companyMonthStart">
                                            <div style="display: none;"
                                                 class="box_companyMonthStart boxUpDown boxUpDown_139 dn">
                                                <ul>
                                                    <li>01</li>
                                                    <li>02</li>
                                                    <li>03</li>
                                                    <li>04</li>
                                                    <li>05</li>
                                                    <li>06</li>
                                                    <li>07</li>
                                                    <li>08</li>
                                                    <li>09</li>
                                                    <li>10</li>
                                                    <li>11</li>
                                                    <li>12</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="companyYearEnd" value=""
                                                   name="company_end_year">
                                            <input type="button" value="结束年份"
                                                   class="profile_select_139 profile_select_normal select_companyYearEnd">
                                            <div class="box_companyYearEnd  boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>至今</li>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="companyMonthEnd" value=""
                                                   name="company_end_month">
                                            <input type="button" value="结束月份"
                                                   class="profile_select_139 profile_select_normal select_companyMonthEnd">
                                            <div style="display: none;"
                                                 class="box_companyMonthEnd boxUpDown boxUpDown_139 dn">
                                                <ul>
                                                    <li>01</li>
                                                    <li>02</li>
                                                    <li>03</li>
                                                    <li>04</li>
                                                    <li>05</li>
                                                    <li>06</li>
                                                    <li>07</li>
                                                    <li>08</li>
                                                    <li>09</li>
                                                    <li>10</li>
                                                    <li>11</li>
                                                    <li>12</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <textarea class="selfDescription s_textarea" name="text"
                                                  id="experienceText"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="3">
                                        <input type="button" value="保 存" class="btn_profile_save"
                                               id="submitExperienceForm"
                                               onclick="curriculum_vitae.submitExperienceForm()">
                                        <a class="btn_profile_cancel" id="cancelExperience" href="javascript:;">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" id="expId" class="expId">

                        </form><!--end .experienceForm-->
                    </div><!--end .experienceShow-->

                    <div class="experienceAdd pAdd">
                        工作经历最能体现自己的工作能力，<br>
                        且完善后才可投递简历哦！
                        <span>添加工作经历</span>
                    </div><!--end .experienceAdd-->
                </div><!--end #workExperience-->

                <div class="profile_box" id="projectExperience" hidden>
                    <h2>项目经验</h2>
                    <span class="c_add dn"></span>
                    <div class="projectShow dn">
                        <ul class="plist clearfix">
                        </ul>
                    </div><!--end .projectShow-->
                    <div class="projectEdit dn">
                        <form class="projectForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="项目名称" name="projectName" class="projectName">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="担任职务，如：产品负责人" name="thePost" class="thePost">
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="projectYearStart" value=""
                                                   name="projectYearStart">
                                            <input type="button" value="开始年份"
                                                   class="profile_select_139 profile_select_normal select_projectYearStart">
                                            <div class="box_projectYearStart  boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="projectMonthStart" value=""
                                                   name="projectMonthStart">
                                            <input type="button" value="开始月份"
                                                   class="profile_select_139 profile_select_normal select_projectMonthStart">
                                            <div style="display: none;"
                                                 class="box_projectMonthStart boxUpDown boxUpDown_139 dn">
                                                <ul>
                                                    <li>01</li>
                                                    <li>02</li>
                                                    <li>03</li>
                                                    <li>04</li>
                                                    <li>05</li>
                                                    <li>06</li>
                                                    <li>07</li>
                                                    <li>08</li>
                                                    <li>09</li>
                                                    <li>10</li>
                                                    <li>11</li>
                                                    <li>12</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="projectYearEnd" value="" name="projectYearEnd">
                                            <input type="button" value="结束年份"
                                                   class="profile_select_139 profile_select_normal select_projectYearEnd">
                                            <div class="box_projectYearEnd  boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>至今</li>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="projectMonthEnd" value=""
                                                   name="projectMonthEnd">
                                            <input type="button" value="结束月份"
                                                   class="profile_select_139 profile_select_normal select_projectMonthEnd">
                                            <div style="display: none;"
                                                 class="box_projectMonthEnd boxUpDown boxUpDown_139 dn">
                                                <ul>
                                                    <li>01</li>
                                                    <li>02</li>
                                                    <li>03</li>
                                                    <li>04</li>
                                                    <li>05</li>
                                                    <li>06</li>
                                                    <li>07</li>
                                                    <li>08</li>
                                                    <li>09</li>
                                                    <li>10</li>
                                                    <li>11</li>
                                                    <li>12</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top"></td>
                                    <td colspan="3">
                                        <textarea class="projectDescription s_textarea" name="projectDescription"
                                                  placeholder="项目描述"></textarea>
                                        <div class="word_count">你还可以输入 <span>500</span> 字</div>
                                    </td>
                                </tr>
                                <!-- <tr>
                                    <td colspan="2">
                                        <textarea placeholder="职责描述" name="ResponsDescription" class="ResponsDescription s_textarea"></textarea>
                                        <div class="word_count">你还可以输入 <span>500</span> 字</div>
                                    </td>
                                </tr> -->
                                <tr>
                                    <td valign="top"></td>
                                    <td colspan="3">
                                        <input type="submit" value="保 存" class="btn_profile_save">
                                        <a class="btn_profile_cancel" href="javascript:;">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" value="" class="projectId">
                        </form><!--end .projectForm-->
                    </div><!--end .projectEdit-->
                    <div class="projectAdd pAdd">
                        项目经验是用人单位衡量人才能力的重要指标哦！<br>
                        来说说让你难忘的项目吧！
                        <span>添加项目经验</span>
                    </div><!--end .projectAdd-->
                </div><!--end #projectExperience-->

                <div class="profile_box" id="educationalBackground">
                    <h2>教育背景<span>（投递简历时必填）</span></h2>
                    <span class="c_add dn"></span>
                    <div class="educationalShow dn">
                        <ul class="elist clearfix">
                        </ul>
                        <form class="educationalForm borderBtm dn">
                            <table>
                                <tbody>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="学校名称" name="schoolName" class="schoolName">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="hidden" class="degree" value="" name="degree">
                                        <input type="button" value="学历"
                                               class="profile_select_287 profile_select_normal select_degree">
                                        <div class="box_degree boxUpDown boxUpDown_287 dn" style="display: none;">
                                            <ul>
                                                <li>大专</li>
                                                <li>本科</li>
                                                <li>硕士</li>
                                                <li>博士</li>
                                                <li>其他</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="专业名称" name="professionalName"
                                               class="professionalName">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="schoolYearStart" value=""
                                                   name="schoolYearStart">
                                            <input type="button" value="开始年份"
                                                   class="profile_select_139 profile_select_normal select_schoolYearStart">
                                            <div class="box_schoolYearStart boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="schoolYearEnd" value="" name="schoolYearEnd">
                                            <input type="button" value="结束年份"
                                                   class="profile_select_139 profile_select_normal select_schoolYearEnd">
                                            <div style="display: none;"
                                                 class="box_schoolYearEnd  boxUpDown boxUpDown_139 dn">
                                                <ul>
                                                    <li>2021</li>
                                                    <li>2020</li>
                                                    <li>2019</li>
                                                    <li>2018</li>
                                                    <li>2017</li>
                                                    <li>2016</li>
                                                    <li>2015</li>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="3">
                                        <input type="submit" value="保 存" class="btn_profile_save">
                                        <a class="btn_profile_cancel" href="javascript:;" id="eduAddCancel">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" class="eduId" value="">
                        </form><!--end .educationalForm-->


                    </div><!--end .educationalShow-->
                    <div class="educationalEdit dn">
                        <form class="educationalForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="学校名称" name="schoolName" class="schoolName">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="hidden" class="degree" value="" name="degree">
                                        <input type="button" value="学历"
                                               class="profile_select_287 profile_select_normal select_degree">
                                        <div class="box_degree boxUpDown boxUpDown_287 dn" style="display: none;">
                                            <ul>
                                                <li>大专</li>
                                                <li>本科</li>
                                                <li>硕士</li>
                                                <li>博士</li>
                                                <li>其他</li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <input type="text" placeholder="专业名称" name="professionalName"
                                               class="professionalName">
                                    </td>
                                    <td valign="top">
                                        <span class="redstar">*</span>
                                    </td>
                                    <td>
                                        <div class="fl">
                                            <input type="hidden" class="schoolYearStart" value=""
                                                   name="schoolYearStart">
                                            <input type="button" value="开始年份"
                                                   class="profile_select_139 profile_select_normal select_schoolYearStart">
                                            <div class="box_schoolYearStart boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="fl">
                                            <input type="hidden" class="schoolYearEnd" value="" name="schoolYearEnd">
                                            <input type="button" value="结束年份"
                                                   class="profile_select_139 profile_select_normal select_schoolYearEnd">
                                            <div class="box_schoolYearEnd  boxUpDown boxUpDown_139 dn"
                                                 style="display: none;">
                                                <ul>
                                                    <li>2014</li>
                                                    <li>2013</li>
                                                    <li>2012</li>
                                                    <li>2011</li>
                                                    <li>2010</li>
                                                    <li>2009</li>
                                                    <li>2008</li>
                                                    <li>2007</li>
                                                    <li>2006</li>
                                                    <li>2005</li>
                                                    <li>2004</li>
                                                    <li>2003</li>
                                                    <li>2002</li>
                                                    <li>2001</li>
                                                    <li>2000</li>
                                                    <li>1999</li>
                                                    <li>1998</li>
                                                    <li>1997</li>
                                                    <li>1996</li>
                                                    <li>1995</li>
                                                    <li>1994</li>
                                                    <li>1993</li>
                                                    <li>1992</li>
                                                    <li>1991</li>
                                                    <li>1990</li>
                                                    <li>1989</li>
                                                    <li>1988</li>
                                                    <li>1987</li>
                                                    <li>1986</li>
                                                    <li>1985</li>
                                                    <li>1984</li>
                                                    <li>1983</li>
                                                    <li>1982</li>
                                                    <li>1981</li>
                                                    <li>1980</li>
                                                    <li>1979</li>
                                                    <li>1978</li>
                                                    <li>1977</li>
                                                    <li>1976</li>
                                                    <li>1975</li>
                                                    <li>1974</li>
                                                    <li>1973</li>
                                                    <li>1972</li>
                                                    <li>1971</li>
                                                    <li>1970</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="3">
                                        <input type="submit" value="保 存" class="btn_profile_save">
                                        <a class="btn_profile_cancel" href="javascript:;" id="eduAddMoreCancel">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" class="eduId" value="">
                        </form><!--end .educationalForm-->
                    </div><!--end .educationalEdit-->

                    <div class="educationalAdd pAdd">
                        教育背景可以充分体现你的学习和专业能力，<br>
                        且完善后才可投递简历哦！
                        <span>添加教育经历</span>
                    </div><!--end .educationalAdd-->
                </div><!--end #educationalBackground-->

                <div class="profile_box" id="selfDescription">
                    <h2>自我描述</h2>
                    <span class="c_edit dn"></span>
                    <div class="descriptionShow dn">

                    </div><!--end .descriptionShow-->
                    <div class="descriptionEdit dn">
                        <form class="descriptionForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td colspan="2">
                                        <!--<textarea class="selfDescription s_textarea" name="selfDescription"
                                                  placeholder=""></textarea>
                                        <div class="wor d_count">你还可以输入 <span>500</span> 字</div>-->
                                        <textarea class="selfDescription s_textarea" name="selfDescription"
                                                  id="selfDescriptionText"></textarea>

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input type="submit" value="保 存" class="btn_profile_save">
                                        <a class="btn_profile_cancel" href="javascript:;">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>

                        </form><!--end .descriptionForm-->
                    </div><!--end .descriptionEdit-->
                    <div class="descriptionAdd pAdd">
                        描述你的性格、爱好以及吸引人的经历等，<br>
                        让企业了解多元化的你！
                        <span>添加自我描述</span>
                    </div><!--end .descriptionAdd-->
                </div><!--end #selfDescription-->

                <div class="profile_box" id="worksShow" hidden>
                    <h2>作品展示</h2>
                    <span class="c_add dn"></span>
                    <div class="workShow dn">
                        <ul class="slist clearfix">
                        </ul>
                    </div><!--end .workShow-->
                    <div class="workEdit dn">
                        <form class="workForm">
                            <table>
                                <tbody>
                                <tr>
                                    <td>
                                        <input type="text" placeholder="请输入作品链接" name="workLink" class="workLink">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <textarea maxlength="100" class="workDescription s_textarea"
                                                  name="workDescription" placeholder="请输入说明文字"></textarea>
                                        <div class="word_count">你还可以输入 <span>100</span> 字</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" value="保 存" class="btn_profile_save">
                                        <a class="btn_profile_cancel" href="javascript:;">取 消</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" class="showId" value="">
                        </form><!--end .workForm-->
                    </div><!--end .workEdit-->
                    <div class="workAdd pAdd">
                        好作品会说话！<br>
                        快来秀出你的作品打动企业吧！
                        <span>添加作品展示</span>
                    </div><!--end .workAdd-->
                </div><!--end #worksShow-->
                <!--<input type="hidden" id="resumeId" value="268472">-->
            </div><!--end .content_l-->
            <div class="content_r">
                <div class="mycenterR" id="myInfo" hidden>
                    <h2>我的信息</h2>
                    <a target="_blank" href="collections.html">我收藏的职位</a>
                    <br>
                    <a target="_blank" href="subscribe.html">我订阅的职位</a>
                </div><!--end #myInfo-->

                <div class="mycenterR" id="myResume">
                    <h2>我的附件简历
                        <a title="上传附件简历" href="#uploadFile" class="inline cboxElement">上传简历</a>
                    </h2>
                    <div class="resumeUploadDiv">
                        暂无附件简历
                    </div>
                </div><!--end #myResume-->

                <div class="mycenterR" id="resumeSet" hidden>
                    <h2>投递简历设置 <span>修改设置</span></h2>
                    <!-- -1 (0=附件， 1=在线， 其他=未设置) -->
                    <div class="noSet set0 dn">默认使用<span>附件简历</span>进行投递</div>
                    <div class="noSet set1 dn">默认使用<span>在线简历</span>进行投递</div>
                    <div class="noSet">暂未设置默认投递简历</div>
                    <input type="hidden" class="defaultResume" value="-1">
                    <form class="dn" id="resumeSetForm">
                        <label><input type="radio" value="1" class="resume1"
                                      name="resume">默认使用<span>在线简历</span>进行投递</label>
                        <label><input type="radio" value="0" class="resume0"
                                      name="resume">默认使用<span>附件简历</span>进行投递</label>
                        <span class="setTip error"></span>
                        <div class="resumeTip">设置后投递简历时将不再提醒</div>
                        <input type="submit" value="保 存" class="btn_profile_save">
                        <a class="btn_profile_cancel" href="javascript:;">取 消</a>
                    </form>
                </div><!--end #resumeSet-->

                <div class="mycenterR" id="myShare">
                    <h2>当前每日投递量：10个</h2>
                    <a target="_blank" href="h/share/invite.html" hidden>邀请好友，提升投递量</a>
                </div><!--end #myShare-->


            </div><!--end .content_r-->
        </div>

        <input type="hidden" id="userid" name="userid" value="314873">

        <!-------------------------------------弹窗lightbox ----------------------------------------->
        <div style="display:none;">
            <!-- 上传简历 -->
            <div class="popup" id="uploadFile">
                <table width="100%">
                    <tbody>
                    <tr>
                        <td align="center">
                            <form>
                                <a class="btn_addPic" href="javascript:void(0);">
                                    <span>选择上传文件</span>
                                    <input type="file"
                                           onchange="file_check(this,'h/nearBy/updateMyResume.json','resumeUpload')"
                                           class="filePrew" id="resumeUpload" name="newResume" size="3"
                                           title="支持word、pdf、ppt、txt、wps格式文件，大小不超过10M" tabindex="3">
                                </a>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">支持word、pdf、ppt、txt、wps格式文件<br>文件大小需小于10M</td>
                    </tr>
                    <tr>
                        <td align="left" style="color:#dd4a38; padding-top:10px;">注：若从其它网站下载的word简历，请将文件另存为.docx格式后上传
                        </td>
                    </tr>
                    <tr>
                        <td align="center"><img width="55" height="16" alt="loading" style="visibility: hidden;"
                                                id="loadingImg" src="/resources/thirdparty/css/img/loading.gif"></td>
                    </tr>
                    </tbody>
                </table>
            </div><!--/#uploadFile-->

            <!-- 简历上传成功 -->
            <div class="popup" id="uploadFileSuccess">
                <h4>简历上传成功！</h4>
                <table width="100%">
                    <tbody>
                    <tr>
                        <td align="center"><p>你可以将简历投给你中意的公司了。</p></td>
                    </tr>
                    <tr>
                        <td align="center"><a class="btn_s" href="javascript:;">确&nbsp;定</a></td>
                    </tr>
                    </tbody>
                </table>
            </div><!--/#uploadFileSuccess-->

            <!-- 没有简历请上传 -->
            <div class="popup" id="deliverResumesNo">
                <table width="100%">
                    <tbody>
                    <tr>
                        <td align="center"><p class="font_16">你在招徕网还没有简历，请先上传一份</p></td>
                    </tr>
                    <tr>
                        <td align="center">
                            <form>
                                <a class="btn_addPic" href="javascript:void(0);">
                                    <span>选择上传文件</span>
                                    <input type="file"
                                           onchange="file_check(this,'h/nearBy/updateMyResume.json','resumeUpload1')"
                                           class="filePrew" id="resumeUpload1" name="newResume" size="3"
                                           title="支持word、pdf、ppt、txt、wps格式文件，大小不超过10M">
                                </a>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">支持word、pdf、ppt、txt、wps格式文件，大小不超过10M</td>
                    </tr>
                    </tbody>
                </table>
            </div><!--/#deliverResumesNo-->

            <!-- 上传附件简历操作说明-重新上传 -->
            <div class="popup" id="fileResumeUpload">
                <table width="100%">
                    <tbody>
                    <tr>
                        <td>
                            <div class="f18 mb10">请上传标准格式的word简历</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="f16">
                                操作说明：<br>
                                打开需要上传的文件 - 点击文件另存为 - 选择.docx - 保存
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <a title="上传附件简历" href="#uploadFile" class="inline btn cboxElement">重新上传</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div><!--/#fileResumeUpload-->

            <!-- 上传附件简历操作说明-重新上传 -->
            <div class="popup" id="fileResumeUploadSize">
                <table width="100%">
                    <tbody>
                    <tr>
                        <td>
                            <div class="f18 mb10">上传文件大小超出限制</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="f16">
                                提示：<br>
                                单个附件不能超过10M，请重新选择附件简历！
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <a title="上传附件简历" href="#uploadFile" class="inline btn cboxElement">重新上传</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div><!--/#deliverResumeConfirm-->

        </div>
        <!------------------------------------- end ----------------------------------------->

        <script src="/resources/thirdparty/js/Chart.min.js" type="text/javascript"></script>
        <script src="/resources/thirdparty/js/profile.min.js" type="text/javascript"></script>
        <!-- <div id="profileOverlay"></div> -->
        <div class="" id="qr_cloud_resume" style="display: none;">
            <div class="cloud">
                <img width="134" height="134" src="">
                <a class="close" href="javascript:;"></a>
            </div>
        </div>

        <div class="clear"></div>
        <input type="hidden" value="97fd449bcb294153a671f8fe6f4ba655" id="resubmitToken">
        <a rel="nofollow" title="回到顶部" id="backtop" style="display: none;"></a>
    </div><!-- end #container -->
</div><!-- end #body -->
<div id="footer">
    <div class="wrapper">
        <a rel="nofollow" target="_blank" href="h/about.html">联系我们</a>
        <a target="_blank" href="h/af/zhaopin.html">互联网公司导航</a>
        <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">招徕网微博</a>
        <a rel="nofollow" href="javascript:void(0)" class="footer_qr">招徕网微信<i></i></a>
        <div class="copyright">&copy;2015-2016 ZzLinks <a
                href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action"
                target="_blank">粤ICP备16030873号-1</a></div>
    </div>
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

<script src="/resources/libs/js/jquery/ajaxfileupload.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/additional-methods.js" type="text/javascript"></script>

<script src='/resources/thirdparty/js/tinymce.min.js'></script>
<!--[if lte IE 8]>
<script type="text/javascript" src="/resources/thirdparty/js/excanvas.js"></script>
<![endif]-->
<script src="/resources/thirdparty/js/core.min.js" type="text/javascript"></script>
<script src="/resources/thirdparty/js/popup.min.js" type="text/javascript"></script>


<script type="text/javascript" src="/resources/zlstatic/js/router.js"></script>
<script type="text/javascript" src="/resources/zlstatic/js/common.js"></script>
<script type="text/javascript" src="/resources/zlstatic/js/employee/curriculum_vitae.js"></script>
<!--  -->
<!--
<script type="text/javascript">
    $(function () {
        $('#noticeDot-1').hide();
        $('#noticeTip a.closeNT').click(function () {
            $(this).parent().hide();
        });
    });
    var index = Math.floor(Math.random() * 2);
    var ipArray = new Array('42.62.79.226', '42.62.79.227');
    var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
    var CallCenter = {
        init: function (url) {
            var _websocket = new WebSocket(url);
            _websocket.onopen = function (evt) {
                console.log("Connected to WebSocket server.");
            };
            _websocket.onclose = function (evt) {
                console.log("Disconnected");
            };
            _websocket.onmessage = function (evt) {
                //alert(evt.data);
                var notice = jQuery.parseJSON(evt.data);
                if (notice.status[0] == 0) {
                    $('#noticeDot-0').hide();
                    $('#noticeTip').hide();
                    $('#noticeNo').text('').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
                    $('#noticeNoPage').text('').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
                } else {
                    $('#noticeDot-0').show();
                    $('#noticeTip strong').text(notice.status[0]);
                    $('#noticeTip').show();
                    $('#noticeNo').text('(' + notice.status[0] + ')').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
                    $('#noticeNoPage').text(' (' + notice.status[0] + ')').show().parent('a').attr('href', ctx + '/mycenter/delivery.html');
                }
                $('#noticeDot-1').hide();
            };
            _websocket.onerror = function (evt) {
                console.log('Error occured: ' + evt);
            };
        }
    };
    CallCenter.init(url);
</script>-->