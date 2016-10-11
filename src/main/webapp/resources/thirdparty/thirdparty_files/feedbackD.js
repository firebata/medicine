//反馈通D期
var strsourceid = $("#tt_sourceid").val();
var strcompid = $("#dda_companyid").val();

var iHBody = ($(document).height() <= $(window).height()) ? $(window).height() : $(document).height();
var isClickFD = ($('#labeltype').attr('value') == 0 || $('#labeltype').attr('value') == 1);
var isBlacklist = /5/.test($('#ApplyResume').val());

//判断是否是单份简历，如果是，则刷新页面，以加载右侧导航
function refresh() {
    //var extId = $("#extId").val();
    //var ver = $("#resume_version").val();
    //var lang = $("#language").val();
    //if (extId && ver && lang) {
    //    var actionUrl = "http://rd.zhaopin.com/resumepreview/resume/_detail?extId=" + extId + "&version=" + ver + "&language=" + lang;
    //    var posi = $('#positionid').val();
    //    if (posi) {
    //        actionUrl += '&positionId=' + posi;
    //    }
    //    $("#frmResumeDetail").attr("action", actionUrl).submit();
    //}
    if ($("#frmResumeDetail").is(':visible')) {$("#frmResumeDetail").submit();}else{location.reload();}
    return false;
}

//表单提示信息
var tipsMsg = {
    time_isRight: "请正确选择面试时间！",
    place_isRight: "请输入正确面试地点！",
    place_is100figure: "超出最大100字符限制",
    linkPerson_isRight: "请正确输入联系人名称！",
    linkPerson_is16figure: "超出最大16字符限制",
    mobile_isRight: "请正确输入手机号码！",
    code_isRight: "请输入正确联系方式！",
    noMatch_isRight: '请正确输入不匹配原因',
    isNoMatch_20figure: '您已超出20个汉字。',
    noMatch_check: '请选择拒绝的原因'
};

//验证规则
var positionCheck = {
    isEmail: function (str) {
        //和c端保持一致的邮箱验证
        var strSuffix = "cc|com|edu|gov|int|net|org|biz|info|pro|name|coop|al|dz|af|ar|ae|aw|om|az|eg|et|ie|ee|ad|ao|ai|ag|at|au|mo|bb|pg|bs|pk|py|ps|bh|pa|br|by|bm|bg|mp|bj|be|is|pr|ba|pl|bo|bz|bw|bt|bf|bi|bv|kp|gq|dk|de|tl|tp|tg|dm|do|ru|ec|er|fr|fo|pf|gf|tf|va|ph|fj|fi|cv|fk|gm|cg|cd|co|cr|gg|gd|gl|ge|cu|gp|gu|gy|kz|ht|kr|nl|an|hm|hn|ki|dj|kg|gn|gw|ca|gh|ga|kh|cz|zw|cm|qa|ky|km|ci|kw|cc|hr|ke|ck|lv|ls|la|lb|lt|lr|ly|li|re|lu|rw|ro|mg|im|mv|mt|mw|my|ml|mk|mh|mq|yt|mu|mr|us|um|as|vi|mn|ms|bd|pe|fm|mm|md|ma|mc|mz|mx|nr|np|ni|ne|ng|nu|no|nf|na|za|aq|gs|eu|pw|pn|pt|jp|se|ch|sv|ws|yu|sl|sn|cy|sc|sa|cx|st|sh|kn|lc|sm|pm|vc|lk|sk|si|sj|sz|sd|sr|sb|so|tj|tw|th|tz|to|tc|tt|tn|tv|tr|tm|tk|wf|vu|gt|ve|bn|ug|ua|uy|uz|es|eh|gr|hk|sg|nc|nz|hu|sy|jm|am|ac|ye|iq|ir|il|it|in|id|uk|vg|io|jo|vn|zm|je|td|gi|cl|cf|cn";
        var regu = "^[a-z0-9][_a-z0-9\-]*([\.][_a-z0-9\-]+)*@([a-z0-9\-_]+[\.])+(" + strSuffix + ")$";
        var re = new RegExp(regu,'i');
        return re.test(str);
        //return /^([a-zA-Z0-9]+[_|\_|\.|\-]*)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.|\-]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(str);
    },
    isPlace_60figure: function (str) {				//地址是否是100个字符&&是否不为空
        var containDigit1 = (str.length == 0) ? false : true;
        var strChange = str.replace(/[\u4e00-\u9fa5]/g, '**');
        var isStrChange_100figure = (strChange.length < 100 || strChange.length == 100) ? true : false;

        if (containDigit1 == false) {
            return tipsMsg.place_isRight;
        } else if (containDigit1 == true && isStrChange_100figure == false) {
            return tipsMsg.place_is100figure;
        } else {
            return true;
        }
    },
    isLinkPeson_16figure: function (str) {			//联系人是否是8个字符（含汉字、英文）
        var containDigit1 = /^[A-Za-z\u4e00-\u9fa5 \,\，\.\。\、]+$/.test(str);
        var strChange = str.replace(/[\u4e00-\u9fa5]/g, '**');
        var isStrChange_16figure = (strChange.length < 16 || strChange.length == 16) ? true : false;

        if (containDigit1 == false) {
            return tipsMsg.linkPerson_isRight;
        } else if (containDigit1 == true && isStrChange_16figure == false) {
            return tipsMsg.linkPerson_is16figure;
        } else {
            return true;
        }
    },
    isMobile_section: function (str) {			   //手机号码是否为正常号段的11位数字
        return /^(1[3|4|5|7|8][0-9])\d{8}$/.test(str);
    },
    isAreaCode: function (str) {				   //区号
        return /^\d{3,5}$/.test(str);
    },
    islandlineCode_8figure: function (str) {	   //电话号码是否是首位非0的8位数字
        return /^\d{6,8}$/.test(str);
    },
    isExtenCode: function (str) {					//分机号
        return /^\d*$/.test(str);
    },
    isNoMatch: function (str) {	   			   		//不合适原因
        var containDigit1 = /^[A-Za-z\u4e00-\u9fa5 \,\，\.\。\、]+$/.test(str);
        var strChange = str.replace(/[\u4e00-\u9fa5]/g, '**');
        var isStrChange_40figure = (strChange.length < 40 || strChange.length == 40) ? true : false;

        if (containDigit1 == false) {
            return tipsMsg.noMatch_isRight;
        } else if (containDigit1 == true && isStrChange_40figure == false) {
            return tipsMsg.isNoMatch_20figure;
        } else {
            return true;
        }
    }
};

$(function () {
    var fbFlag = $('#posttype').attr('value') == 1, robFlag = $("#fromd").val() === '2', flag = fbFlag || robFlag;
    if (flag && isClickFD == true && isBlacklist == false) {   //检测是否是反馈通简历&&是否是点击一次&&是否是黑名单
        //冒泡效果
        function fnBubble(BubbleName) {
            if(fbFlag){//反馈通
                //设置冒泡cookie
                var cookie_name = 'cookieBubbleName';
                var cookie_time = new Date((new Date()).getTime() + 48 * 3600000);

                if ($.cookie(cookie_name) == null  && location.href.indexOf('/1/') != -1) {
                    toBubble();

                    $("#bubble .close").click(function () {
                        $.cookie(cookie_name, 1, { path: '/', expires: cookie_time });
                        $("#bubble").fadeOut(300);
                    });
                }
            }else if(robFlag){
                //设置冒泡cookie
                var cookie_name = 'cookieRobName';
                var cookie_time = new Date((new Date()).getTime() + 48 * 3600000);

                if ($.cookie(cookie_name) == null) {
                    toBubble();
                    $("#bubble .close").click(function () {
                        $.cookie(cookie_name, 1, { path: '/', expires: cookie_time });
                        $("#bubble").fadeOut(300);
                    });
                }
            };
            //创建冒泡            
            function toBubble() {
                // 反馈通简历详情页冒泡
                var htmlBubble = '<div id="bubble"><div class="main_feed_back"></div><div class="feed_back"><p><b>' + BubbleName + '</b>&nbsp;&nbsp;要求您给出反馈后才展示联系方式，请点击下方按钮进行反馈</p><img src="http://img01.zhaopin.cn/2014/rd2/img/backLink.png"><img class="nowNoMatch" src="http://img01.zhaopin.cn/2014/rd2/img/nowNoMatch.png"></div><div class="quick_feed_back"><img src="http://img01.zhaopin.cn/2014/rd2/img/giveBack.png"><img class="close" src="http://img01.zhaopin.cn/2014/rd2/img/backClose.png"></div></div>';
                // 抢人才简历详情页冒泡
                var htmlBubblerob = '<div id="bubble"><div class="main_feed_back"></div><div class="feed_back"><img src="http://img01.zhaopin.cn/2014/rd2/img/backrobLink.png"><img class="nowNoMatch" src="http://img01.zhaopin.cn/2014/rd2/img/nowrobNoMatch.png"><p class="rob_title">抢人才，处理就送<span>5个智联专币！</span></p></div><div class="quick_feed_back"><img src="http://img01.zhaopin.cn/2014/rd2/img/robpcon.png"><img class="close" style="left:445px;" src="http://img01.zhaopin.cn/2014/rd2/img/robpclose.png"></div></div>';
                // 判断反馈通还是抢人才
                if(fbFlag){
                    $('body').append(htmlBubble);
                }
                else if(robFlag)
                {
                    $('body').append(htmlBubblerob);
                }
                // $('body').append(htmlBubble);

                $('.main_feed_back').css({
                    'width': '100%',
                    'height': iHBody
                });

                var leftFeedbackDshow = $('.feedbackD_show').offset().left - 12;
                var topFeedbackDshow = $('.feedbackD_show').offset().top - 5;
                $('.feed_back').css({
                    left: leftFeedbackDshow,
                    top: topFeedbackDshow
                });
                $('.quick_feed_back').css({
                    left: leftFeedbackDshow + $('.feed_back').outerWidth() / 2 + 14,
                    top: topFeedbackDshow + $('.feed_back').outerHeight() + 10
                });

                $(window).scroll(toBubbleChange);
                $(window).resize(toBubbleChange);
            }

            //冒泡滑动

            function toBubbleChange() {
                iHBody = ($(document).height() <= $(window).height()) ? $(window).height() : $(document).height();
                var leftFeedbackDshow = $('.feedbackD_show').offset().left - 12;
                var topFeedbackDshow = $('.feedbackD_show').offset().top - 5;

                $('.main_feed_back').css({
                    'width': '100%',
                    'height': iHBody
                });
                $('.feed_back').css({
                    left: leftFeedbackDshow,
                    top: topFeedbackDshow
                });
                $('.quick_feed_back').css({
                    left: leftFeedbackDshow + $('.feed_back').outerWidth() / 2 + 14,
                    top: topFeedbackDshow + $('.feed_back').outerHeight() + 10
                });
            }
        }
        fnBubble($("#tt_username").val());
    }

    //我要联系TA按钮
    //计算"暂不合适"按钮与"发面试邀请"按钮距左的位置
    var iW2 = $('#feedbackD1 input.link').outerWidth();
    $('#feedbackD1 input.noMatch').css({ 'left': iW2 });

    if (parseInt($('#feedbackD1 div span').outerWidth()) >= 384) {
        $('#feedbackD1 div span').css({ 'width': '348px' });
    }

    var iW = 288;
    $('#feedbackD1 input.invite').css({ 'left': iW });

    //邮箱字符过长时，用*代替
    $('.mail').each(function () {
        var strMail = $(this).text();
        if (positionCheck.isEmail(strMail)) {
            $(this).text(cutStr(strMail, 40));
        } else {
            $(this).text('');
        }
    });

    function cutStr(str, cutLen) {
        var returnStr = '',    			  //返回的字符串
            reCN = /[^\x00-\xff]/,        //双字节字符
            strCNLen = str.replace(/[^\x00-\xff]/g, '**').length,
            signPlace = str.indexOf('@'),
            arrStr = str.split('@'),
            emilSign = arrStr[1],
            emilSignLen = arrStr[1].length;

        if (cutLen >= strCNLen) {
            return str;
        }

        for (var i = 0, len = 0; len < (cutLen - emilSignLen - 4) ; i++) {	//1个@+3个*，所以要减4
            returnStr += str.charAt(i);
            if (reCN.test(str.charAt(i))) {
                len += 2;
            } else {
                len++;
            }
        }
        return returnStr + '***' + '@' + emilSign;
    }

    //点击按钮
    jQuery.extend(jQuery.easing, {
        def: 'easeOutQuad',
        swing: function (x, t, b, c, d) {
            return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
        },
        easeInQuad: function (x, t, b, c, d) {
            return c * (t /= d) * t + b;
        },
        easeOutQuad: function (x, t, b, c, d) {
            return -c * (t /= d) * (t - 2) + b;
        },
        easeInOutQuad: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1) return c / 2 * t * t + b;
            return -c / 2 * ((--t) * (t - 2) - 1) + b;
        },
        easeInCubic: function (x, t, b, c, d) {
            return c * (t /= d) * t * t + b;
        },
        easeOutCubic: function (x, t, b, c, d) {
            return c * ((t = t / d - 1) * t * t + 1) + b;
        },
        easeInOutCubic: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1) return c / 2 * t * t * t + b;
            return c / 2 * ((t -= 2) * t * t + 2) + b;
        },
        easeInQuart: function (x, t, b, c, d) {
            return c * (t /= d) * t * t * t + b;
        },
        easeOutQuart: function (x, t, b, c, d) {
            return -c * ((t = t / d - 1) * t * t * t - 1) + b;
        },
        easeInOutQuart: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1) return c / 2 * t * t * t * t + b;
            return -c / 2 * ((t -= 2) * t * t * t - 2) + b;
        },
        easeInQuint: function (x, t, b, c, d) {
            return c * (t /= d) * t * t * t * t + b;
        },
        easeOutQuint: function (x, t, b, c, d) {
            return c * ((t = t / d - 1) * t * t * t * t + 1) + b;
        },
        easeInOutQuint: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1) return c / 2 * t * t * t * t * t + b;
            return c / 2 * ((t -= 2) * t * t * t * t + 2) + b;
        },
        easeInSine: function (x, t, b, c, d) {
            return -c * Math.cos(t / d * (Math.PI / 2)) + c + b;
        },
        easeOutSine: function (x, t, b, c, d) {
            return c * Math.sin(t / d * (Math.PI / 2)) + b;
        },
        easeInOutSine: function (x, t, b, c, d) {
            return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b;
        },
        easeInExpo: function (x, t, b, c, d) {
            return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b;
        },
        easeOutExpo: function (x, t, b, c, d) {
            return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b;
        },
        easeInOutExpo: function (x, t, b, c, d) {
            if (t == 0) return b;
            if (t == d) return b + c;
            if ((t /= d / 2) < 1) return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
            return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
        },
        easeInCirc: function (x, t, b, c, d) {
            return -c * (Math.sqrt(1 - (t /= d) * t) - 1) + b;
        },
        easeOutCirc: function (x, t, b, c, d) {
            return c * Math.sqrt(1 - (t = t / d - 1) * t) + b;
        },
        easeInOutCirc: function (x, t, b, c, d) {
            if ((t /= d / 2) < 1) return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
            return c / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + b;
        },
        easeInElastic: function (x, t, b, c, d) {
            var s = 1.70158; var p = 0; var a = c;
            if (t == 0) return b;
            if ((t /= d) == 1) return b + c;
            if (!p) p = d * .3;
            if (a < Math.abs(c)) { a = c; var s = p / 4; }
            else var s = p / (2 * Math.PI) * Math.asin(c / a);
            return -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
        },
        easeOutElastic: function (x, t, b, c, d) {
            var s = 1.70158; var p = 0; var a = c;
            if (t == 0) return b;
            if ((t /= d) == 1) return b + c;
            if (!p) p = d * .3;
            if (a < Math.abs(c)) { a = c; var s = p / 4; }
            else var s = p / (2 * Math.PI) * Math.asin(c / a);
            return a * Math.pow(2, -10 * t) * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b;
        },
        easeInOutElastic: function (x, t, b, c, d) {
            var s = 1.70158; var p = 0; var a = c;
            if (t == 0) return b;
            if ((t /= d / 2) == 2) return b + c;
            if (!p) p = d * (.3 * 1.5);
            if (a < Math.abs(c)) { a = c; var s = p / 4; }
            else var s = p / (2 * Math.PI) * Math.asin(c / a);
            if (t < 1) return -.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
            return a * Math.pow(2, -10 * (t -= 1)) * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b;
        },
        easeInOutBounce: function (x, t, b, c, d) {
            if (t < d / 2) return jQuery.easing.easeInBounce(x, t * 2, 0, c, d) * .5 + b;
            return jQuery.easing.easeOutBounce(x, t * 2 - d, 0, c, d) * .5 + c * .5 + b;
        }
    });

    $('#feedbackD1 input.link').live('click', function () {
        var unique_id = GetSelect_unique_id();
        var oldstatus = $("#labeltype").val();

        //请求
        $.ajax({
            type: "POST",
            url: "/resumePreview/resume/_FktLook?oldstatus=" + oldstatus + "&status=2&guid=" + unique_id,
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.Code == 200) {
                    refresh();

                    $('#feedbackD div').css({
                        'backgrund': '#2f9ddf',
                        'width': iW
                    });
                    $('.feedbackD_tips01').fadeOut(600);
                    $('.feedbackD_tips02').fadeIn(600);
                    $('#feedbackD input.noMatch').css({ 'left': iW });

                    $('#feedbackD1 input.link').animate({
                        'marginLeft': iW
                    }, 600, 'easeOutCirc');


                    $('#feedbackD input.noMatch').css({ 'left': iW + 86 });
                    $('#feedbackD input.invite').css({ 'left': 288 });
                    $('#feedbackD input.invite').fadeIn(600, 'easeOutCirc');


                    $('#feedbackD div').css({ 'borderRadius': '4px 0 0 4px' });
                    $('#feedbackD div span').css({ 'display': 'block' });
                    $('#feedbackD div span').animate({
                        'left': 0
                    }, 600, 'easeOutCirc');
                } else if (data.Code == 1004) {
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            },
            error: function (data) {
                //创建加载错误 弹窗 
                createTan({
                    tanStyle: "tan_error tan_small",
                    tanCont: "tanError",
                    tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                });
                toRemove({ closeBtn: ".tan_error input.sure" });
                toRemove({ closeBtn: ".tan_error .close" });
            }
        });
    });

    var inviteMsg = null;
    //发面试邀请按钮
    function fnInvite() {
        var timerDate = null;
        var timerTelTyle = null;
        $.ajax({
            async: true,
            url: '/resumePreview/resume/GetCompanyInvited?companyid=' + strcompid,
            data: $('#formTan').serialize(),
            type: 'post',
            cache: false,
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data != null && data != "") {
                    //地址赋值
                    inviteMsg = eval("(" + data + ")");
                }
                //赠送币为0或erd，ipin用户或普通简历用户
                var _postType = $('#posttype').attr('value');
                var fromdSend = $(".invite").data("fromd");
                var isqiang = $("#fromd").val() === '2';
                //if (strsourceid == 2 || strsourceid == 7 || strsourceid == 8|| strsourceid == 1) {
                if (strsourceid == 2 || strsourceid == 7 || strsourceid == 8 || (_postType != '1' && $("#fromd").val() != '2' )|| isBlacklist) {
                    createTan({
                        tanStyle: "tan_offer tan_big",
                        tanTitle: "面试邀请函",
                        tanTitleClose: "__ga__searchresultTab_msyqguanbi_001",
                        tanCont: "offer",
                        tanContUrl: "/resumePreview/resume/feedbackDalert?labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val() + "&ttposnumber=" + $("#PositionNumber").val() + "&posttype=" + _postType + "&fromd=" + fromdSend,
                        tanBtn: "<input class=\"" + (isqiang?'__ga__rencaiqiang_rencaiqiang10_001':'__ga__searchresultTab_msyqfasong_001') + " send active\" type=\"button\" value=\"发 送\" /><input class=\"" + (isqiang?'__ga__rencaiqiang_rencaiqiang11_001':'__ga__searchresultTab_msyqquxiao_001') + " refuse no_active\" type=\"button\" value=\"取消\" />",
                        fnLoadCallBack: fnOfferCallBack
                    });
                    toRemove({ closeBtn: ".tan_offer .close" });
                } else {
                    //面试邀请函弹窗 添加
                    createTan({
                        tanStyle: "tan_offer tan_big",
                        tanTitle: "面试邀请函",
                        tanTitleTwo: "积极反馈求职者就有",
                        tanTitleThreeName: "fkt_zlb",
                        tanTitleFour: "个智联币赠送哟",
                        tanTitleClose: "__ga__searchresultTab_msyqguanbi_001",
                        tanCont: "offer",
                        tanContUrl: "/resumePreview/resume/feedbackDalert?labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val() + "&ttposnumber=" + $("#PositionNumber").val() + "&posttype=" + _postType + "&fromd=" + fromdSend,
                        tanBtn: "<input class=\"" + (isqiang?'__ga__rencaiqiang_rencaiqiang10_001':'__ga__searchresultTab_msyqfasong_001') + " send active \" type=\"button\" value=\"发 送\" /><input class=\"" + (isqiang?'__ga__rencaiqiang_rencaiqiang11_001':'__ga__searchresultTab_msyqquxiao_001') + " refuse no_active \" type=\"button\" value=\"取消\" />",
                        fnLoadCallBack: fnOfferCallBack
                    });
                    toRemove({ closeBtn: ".tan_offer .close" });
                }
            },
            error: function () {
                //加载错误 弹窗
                createTan({
                    tanStyle: "tan_error tan_small",
                    tanCont: "tanError",
                    tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                });
                toRemove({ closeBtn: ".tan_error input.sure" });
                toRemove({ closeBtn: ".tan_error .close" });
            }
        });
    }
    $('.feedbackD_show input.invite').live('click', function () {
        fnInvite();
    });

    //智联币弹窗
    $('.tan_offer input.send').live('click', function () {
        //避免重复提交
        var btn_self = $(this);
        if(btn_self.css("cursor") == "not-allowed"){
            return;
        }
        //提交前表单验证
        if ($('#start_date').val() == '请选择开始时间') {
            $('#start_date').parents('.form_list').find('.tip').html(tipsMsg.time_isRight);
            $('#start_date').parents('.shadow_bg').addClass('tipColor');
        }

        $('.time-e').hide();
        $('#place').trigger("blur");
        $('#place').trigger("keyup");
        $('#linkPeson').trigger("blur");
        $('#linkPeson').trigger("keyup");

        var isDisplayLandLine = $('.landline').css("display");
        if (isDisplayLandLine == "none") {
            $('#tel_num').trigger("blur");
            $('#tel_num').trigger("keyup");
        } else {
            $('#areaCode').trigger("blur");
            $('#areaCode').trigger("keyup");
            $('#landlineCode').trigger("blur");
            $('#landlineCode').trigger("keyup");
            $('#extenCode').trigger("blur");
        }
        if ($('.tan_offer .tipColor').length != 0) {
            return false;
        }

        //备注--开始
        var els = [];
        if ($('#invite_andsms').hasClass('remarkChoosed')) {
            els.push('<input type="hidden" name="issendsms" value="1"/>');
        }

        $('li.remarkChoosed', '#invite_remarks').each(function (i) {
            var v = $(this).attr('data');
            els.push('<input type="hidden" name="remarks" value="' + v + '"/>');
        });

        var oinput = $('#remarkInput');
        if (oinput.hasClass('elseChoosed')) {
            var v = oinput.attr('data');
            var str = oinput.val();
            if ($.trim(str) != $.trim(remarkTips)) {
                if (isOverLength(str, 40)) {
                    $('div.tipElse').html('最多输入40个字符！').show();
                    return false;
                } else {
                    els.push('<input type="hidden" name="remarks" value="' + v + ':' + escape(str) + '"/>');
                }
            }
        }
        if ($('#invite_andsms').hasClass('remarkChoosed')) {
            var s = $('#invite_sms_license').val();
            els.push('<input type="hidden" name="sms_license" value="' + s + '"/>');
        }

        if (els.length > 0) {
            $('#formTan').append(els.join(''));
        }
        //备注--结束
        //验证完之后 把按钮的属性设置为不可点击
        btn_self.css("cursor","not-allowed");

        //提交表单中信息，需要通过ajax提交。
        var urlPara = [];
        
        //下载简历发面试邀请。
        if ($("#fromd").val() === '1') {
            var $selectedPosi = $("#posi_num");
            urlPara.push('posiid=' + $selectedPosi.data('posi-id'));
            urlPara.push('posinum=' + $selectedPosi.val());
            urlPara.push('posiname=' + $selectedPosi.data('posi-name'));
        } else {
            urlPara.push('posiid=' + $('#positionid').val());
            urlPara.push('posinum=' + $('#PositionNumber').val());
        }

        urlPara.push('candid=' + $('#resumeUserId').val());
        urlPara.push('resuid=' + $('#resume_id').val());
        urlPara = $('#formTan').serialize() + '&' + urlPara.join('&');

        var isUserSubway = $("#fromd").val() === '2';
        $.ajax({
            async: true,
            url: '/resumepreview/resume/' + (isUserSubway ? '_subwayfktoksubmit' : '_fktoksubmit'),
            data: urlPara,
            type: 'post',
            cache: false,
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data.Code == 200) {
                    if (!data.Data) {
                        data.Data = { RechargeValue: 0, RechargeResult: 0, MaxAssetsLimit: 0 };
                    }
                    //智联币弹窗 添加
                    createTan({
                        tanStyle: "coin_offer tan_small",
                        tanTitle: "感谢您的及时反馈",
                        tanCont: "coinOffer",
                        tanContUrl: "/resumePreview/resume/_Fktzszlp?payzlp=" + data.Data.RechargeValue + "&payresult=" + data.Data.RechargeResult + "&&paymax=" + data.Data.MaxAssetsLimit + "&labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val() + "&fromd=" + $("#fromd").val(),
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />",
                        fnLoadCallBack: function () {
                            if (data.Data.RechargeResult == -3012) {
                                $('.coinOffer .coinOffer_num').html(data.Data.MaxAssetsLimit);
                            } else {
                                $('.coinOffer .coinOffer_num').html(data.Data.RechargeValue);
                            }
                        }
                    });

                    //智联币弹窗 → 确认 
                    toRemove({
                        closeBtn: ".coin_offer input.sure",
                        fnToRemoveBefore: function () {
                            $('.feedbackD div,.feedbackE div').css({ "borderRadius": 4 });
                            $('.feedbackD_tips02,.feedbackE_tips02').hide();
                            $('input.invite').hide();
                            $('input.noMatch').hide();
                            $('.sendAfer').fadeIn(300);
                            refresh(); //判断是否是单份简历，如果是，则刷新页面，以加载右侧导航
                        }
                    });

                    //智联币弹窗 → 关闭按钮 
                    toRemove({
                        closeBtn: ".coin_offer .close",
                        fnToRemoveBefore: function () {
                            $('.feedbackD div,.feedbackE div').css({ "borderRadius": 4 });
                            $('.feedbackD_tips02,.feedbackE_tips02').hide();
                            $('input.invite').hide();
                            $('input.noMatch').hide();
                            $('.sendAfer').fadeIn(300);

                            refresh(); //判断是否是单份简历，如果是，则刷新页面，以加载右侧导航
                        }
                    });

                } else if (data.Code == 1004) {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            },
            error: function () {
                //加载错误 弹窗
                createTan({
                    tanStyle: "tan_error tan_small",
                    tanCont: "tanError",
                    tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                });
                toRemove({ closeBtn: ".tan_error input.sure" });
                toRemove({ closeBtn: ".tan_error .close" });
            }
        });
    });

    //暂不合适按钮
    $('.feedbackD input.noMatch,.inappropriate').live('click', function () {
        //不合适弹窗 添加
        createTan({
            tanStyle: "tan_noMatch tan_small",
            tanTitle: "不合适原因",
            tanTitleClose: "__ga__searchresultTab_jjguanbi_001",
            tanCont: "tanNoMatch",
            tanContUrl: "/resumePreview/resume/feedbackDalert?labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val() + "&ttposnumber=" + $("#PositionNumber").val() + "&posttype=" + $('#posttype').val()+"&fromd=" +  $("#fromd").val(),
            tanBtn: "<input class=\"__ga__searchresultTab_jjqueren_001 sure active\" type=\"button\" value=\"确 定\" /><input class=\"__ga__searchresultTab_zanbuheshiBXYY_001 noRightNow no_active\" type=\"button\" value=\"不选原因，直接拒绝\" />",
            fnLoadCallBack: fnTan_noMatchCallBack
        });
        toRemove({ closeBtn: ".tan_noMatch .close" });
    });

    //不合适原因-确定
    $('.tan_noMatch input.sure').live('click', function () {
        //提交前表单验证
        if ($('.tan_noMatch .checkbox_checked').length == 0) {
            $('.reason_tip').css({ "display": "block" });
            $('.reason_tip').html(tipsMsg.noMatch_check);
            $('.tan_noMatch .checkbox').addClass('redBg');
            return false;
        } else if ($('.tanNoMatch li.long .checkbox_checked').length > 0 && $('#others_reason_tip').val() == '') {
            $('.reason_tip').html('');
            $('#others_reason_tip').trigger("blur");
            return false;
        } else if ($('.others_reason_tip').html() != '') {
            return false;
        } else {
			var isUserSubway = $("#fromd").val() === '2';
            $.ajax({                                    //提交表单中信息，需要通过ajax提交，待完成
                async: false,
                // 判断反馈通还是抢人才
                // if(fbFlag){
                //     url: '/resumePreview/resume/_FktRefuse',
                //     data: $('#formTanNoMatch').serialize()
                // }
                // else if(robFlag)
                // {
                //     url: '/resumePreview/resume/_FktRefuse',
                //     data:{subwayid: $('#guid').val()}
                // }
                url: '/resumePreview/resume/' +  (isUserSubway? '_SubwayRefuse' : '_FktRefuse'),
                data: $('#formTanNoMatch').serialize() + "&candid=" +$('#resumeUserId').val() + "&posiid=" + $('#positionid').val(),
                type: 'post',
                beforeSend: function (XMLHttpRequest) {
                    iEndCtreateBtn = false;
                    createTan({
                        tanStyle: "tan_loading tan_small"
                    });
                },
                success: function (data) {
                    if (data.Code == 200) {
                        if (!data.Data) {
                            data.Data = { RechargeValue: 0, RechargeResult: 0, MaxAssetsLimit: 0 };
                        }
                        //不合适弹窗智联币 添加
                        createTan({
                            tanStyle: "coin_noMatch tan_small",
                            tanTitle: "感谢你的及时反馈",
                            tanCont: "coinNoMatch",
                            tanContUrl: "/resumePreview/resume/_Fktzszlp?payzlp=" + data.Data.RechargeValue + "&payresult=" + data.Data.RechargeResult + "&&paymax=" + data.Data.MaxAssetsLimit + "&labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val()+"&fromd=" + $("#fromd").val(),
                            tanBtn: "<input class=\"sure active\" data-click=\"0\" type=\"button\" value=\"确 定\" />",
                            fnLoadCallBack: function () {
                                if (data.Data.RechargeResult == -3012) {
                                    $('.coin_noMatch .coinOffer_num').html(data.Data.MaxAssetsLimit);
                                } else {
                                    $('.coin_noMatch .coinOffer_num').html(data.Data.RechargeValue);
                                }
                            }
                        });

                        //不合适弹窗智联币 确认
                        toRemove({
                            closeBtn: ".coin_noMatch input.sure",
                            fnToRemoveBefore: function () {
                                $('.feedbackD div').css({ "borderRadius": 4 });
                                $('.feedbackD .feedbackD_tips02').hide();
                                $('.feedbackD input.invite').hide();
                                $('.feedbackD input.noMatch').hide();
                                $('.feedbackD input.link').hide();

                                $('.feedbackD div').css({ 'width': 288 });
                                $('.feedbackD div span').css({ "left": 0 });
                                $('#feedbackD1 div span,#feedbackD2 div span').addClass('feedbackD_gray');
                                $('.feedbackD div span').fadeIn(300);
                                $('.feedbackD .refuseAfer').fadeIn(300);
                                $('.feedbackD_tips02').hide();
                            }
                        });

                        //不合适弹窗智联币 关闭
                        toRemove({
                            closeBtn: ".coin_noMatch .close",
                            fnToRemoveBefore: function () {
                                $('.feedbackD div').css({ "borderRadius": 4 });
                                $('.feedbackD .feedbackD_tips02').hide();
                                $('.feedbackD input.invite').hide();
                                $('.feedbackD input.noMatch').hide();
                                $('.feedbackD input.link').hide();

                                $('.feedbackD div').css({ 'width': 288 });
                                $('.feedbackD div span').css({ "left": 0 });
                                $('#feedbackD1 div span,#feedbackD2 div span').addClass('feedbackD_gray');
                                $('.feedbackD div span').fadeIn(300);
                                $('.feedbackD .refuseAfer').fadeIn(300);
                                $('.feedbackD_tips02').hide();
                            }
                        });
                    } else if (data.Code == 1004) {
                        //加载错误 弹窗
                        createTan({
                            tanStyle: "tan_error tan_small",
                            tanCont: "tanError",
                            tanMsg: "操作失败，请刷新后重试",
                            tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                        });
                        toRemove({ closeBtn: ".tan_error input.sure" });
                        toRemove({ closeBtn: ".tan_error .close" });
                    } else {
                        //加载错误 弹窗
                        createTan({
                            tanStyle: "tan_error tan_small",
                            tanCont: "tanError",
                            tanMsg: data.Message,
                            tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                        });
                        toRemove({ closeBtn: ".tan_error input.sure" });
                        toRemove({ closeBtn: ".tan_error .close" });
                    }
                },
                error: function () {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            });
        }
    });

    //不合适原因-暂时不想选原因
    $('.tan_noMatch input.noRightNow').live('click', function () {
        $('#noRightNowMark').val('1');
		var isUserSubway = $("#fromd").val() === '2';
        $.ajax({                                    //提交表单中信息，需要通过ajax提交，待完成
            async: true,
            url: '/resumePreview/resume/' +  (isUserSubway? '_SubwayRefuse' : '_FktRefuse'),
            data: $('#formTanNoMatch').serialize() +  "&candid=" +$('#resumeUserId').val() + "&posiid=" + $('#positionid').val(),
            type: 'post',
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data.Code == 200) {
					if (!data.Data) {
						data.Data = { RechargeValue: 0, RechargeResult: 0, MaxAssetsLimit: 0 };
					}
					//不合适弹窗智联币 添加
					createTan({
						tanStyle: "coin_noMatch tan_small",
						tanTitle: "感谢你的及时反馈",
						tanCont: "coinNoMatch",
						tanContUrl: "/resumePreview/resume/_Fktzszlp?payzlp=" + data.Data.RechargeValue + "&payresult=" + data.Data.RechargeResult + "&&paymax=" + data.Data.MaxAssetsLimit + "&labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val()+"&fromd=" + $("#fromd").val(),
						tanBtn: "<input class=\"sure active\" data-click=\"0\" type=\"button\" value=\"确 定\" />",
						fnLoadCallBack: function () {
							if (data.Data.RechargeResult == -3012) {
								$('.coin_noMatch .coinOffer_num').html(data.Data.MaxAssetsLimit);
							} else {
								$('.coin_noMatch .coinOffer_num').html(data.Data.RechargeValue);
							}
						}
					});

                    //不合适弹窗智联币 确认
                    toRemove({
                        closeBtn: ".coin_noMatch input.sure",
                        fnToRemoveBefore: function () {
                            $('.feedbackD div').css({ "borderRadius": 4 });
                            $('.feedbackD .feedbackD_tips02').hide();
                            $('.feedbackD input.invite').hide();
                            $('.feedbackD input.noMatch').hide();
                            $('.feedbackD input.link').hide();

                            $('.feedbackD div').css({ 'width': 288 });
                            $('.feedbackD div span').css({ "left": 0 });
                            $('#feedbackD1 div span,#feedbackD2 div span').addClass('feedbackD_gray');
                            $('.feedbackD div span').fadeIn(300);
                            $('.feedbackD .refuseAfer').fadeIn(300);
                            $('.feedbackD_tips02').hide();
                        }
                    });

                    //不合适弹窗智联币 关闭
                    toRemove({
                        closeBtn: ".coin_noMatch .close",
                        fnToRemoveBefore: function () {
                            $('.feedbackD div').css({ "borderRadius": 4 });
                            $('.feedbackD .feedbackD_tips02').hide();
                            $('.feedbackD input.invite').hide();
                            $('.feedbackD input.noMatch').hide();
                            $('.feedbackD input.link').hide();

                            $('.feedbackD div').css({ 'width': 288 });
                            $('.feedbackD div span').css({ "left": 0 });
                            $('#feedbackD1 div span,#feedbackD2 div span').addClass('feedbackD_gray');
                            $('.feedbackD div span').fadeIn(300);
                            $('.feedbackD .refuseAfer').fadeIn(300);
                            $('.feedbackD_tips02').hide();
                        }
                    });
                } else if (data.Code == 1004) {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            },
            error: function () {
                //加载错误 弹窗
                createTan({
                    tanStyle: "tan_error tan_small",
                    tanCont: "tanError",
                    tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                });
                toRemove({ closeBtn: ".tan_error input.sure" });
                toRemove({ closeBtn: ".tan_error .close" });
            }
        });
    });

    //面试邀请函弹窗 表单验证及下拉框数据添加
    function fnOfferCallBack() {
        $('.offer .offer_name').html($("#tt_username").val());
        setTimeout(function () {
            $('.offer .coinNum').html($('#fkt_zlb').val());
        }, 300);
        $.getScript("http://img01.zhaopin.cn/2014/common/js/za/ga.js");

        //加载下拉框
        $.getScript("http://img01.zhaopin.cn/2014/rd2/js/zpidc.js", function () {
            showSelect();
            ZPIDC.addJob.InitSelector({
                'selectID': 'contract_date',
                'defOption': '<a def-value="1" href="javascript:void(0);">上午</a>',
                'optionData': [['2', '下午']]
            });
            ZPIDC.addJob.InitSelector({
                'selectID': 'tel',
                'defOption': '<a def-value="1" href="javascript:void(0);">电话</a>',
                'optionData': [['2', '座机']]
            });
            ZPIDC.addJob.InitSelector({
                'selectID': 'contract_time',
                'defOption': '<a def-value="9:00" href="javascript:void(0);">9:00</a>',
                'optionData': [['0:00', '0:00'], ['0:30', '0:30'], ['1:00', '1:00'], ['1:30', '1:30'], ['2:00', '2:00'], ['2:30', '2:30'], ['3:00', '3:00'], ['3:30', '3:30'], ['4:00', '4:00'], ['4:30', '4:30'], ['5:00',

'5:00'], ['5:30', '5:30'], ['6:00', '6:00'], ['6:30', '6:30'], ['7:00', '7:00'], ['7:30', '7:30'], ['8:00', '8:00'], ['8:30', '8:30'], ['9:00', '9:00'],

['9:30', '9:30'], ['10:00', '10:00'], ['10:30', '10:30'], ['11:00', '11:00'], ['11:30', '11:30'], ['12:00', '12:00'], ['12:30', '12:30'], ['13:00',

'13:00'], ['13:30', '13:30'], ['14:00', '14:00'], ['14:30', '14:30'], ['15:00', '15:00'], ['15:30', '15:30'], ['16:00', '16:00'], ['16:30', '16:30'],

['17:00', '17:00'], ['17:30', '17:30'], ['18:00', '18:00'], ['18:30', '18:30'], ['19:00', '19:00'], ['19:30', '19:30'], ['20:00', '20:00'], ['20:30',

'20:30'], ['21:00', '21:00'], ['21:30', '21:30'], ['22:00', '22:00'], ['22:30', '22:30'], ['23:00', '23:00'], ['23:30', '23:30']]
            });

            //下拉框切换——时间段
            $('#contract_time_wrap .select').css({ "width": "89" });
            $('.trueTime .select_txt').css({ "width": "95" });

            var iBtnShowSelectWrap = false;
            $('.trueTime .select_txt').live('click', function () {
                if (iBtnShowSelectWrap == false) {
                    iBtnShowSelectWrap = true;
                    $('#contract_time_wrap').show();
                } else {
                    iBtnShowSelectWrap = false;
                    $('#contract_time_wrap').hide();
                }
            });

            $('.trueTime .select a').live('click', function () {
                iBtnShowSelectWrap = true;
                $('#contract_time_wrap').hide();
            });

            $("body").live('click', function () {
                if (iBtnShowSelectWrap == true) {
                    iBtnShowSelectWrap = false;
                    $('.select').css({ "display": "none" });
                    $('#contract_time_wrap').hide();
                }
            });

            var iNumTimeRang = $('#timeRangeChoose a').length;
            var iNumContractTime = $('#contract_time .select a').length;
            var lenth = 26;

            $('#contract_time .select a:gt(' + (lenth - 1) + ')').css({ 'display': 'none' });
            var $amTimeOne = $('#contract_time .select a').eq(0);
            var $bmTimeOne = $('#contract_time .select a').eq(lenth);

            $('#timeRangeChoose a').live('click', function () {
                var _index = $(this).index();

                if (_index == 0) {
                    $('#contract_time .select_txt h3').html($amTimeOne.html());
                    $('#contract_time .select_txt h3').attr('title', $amTimeOne.html());
                    $('.trueTimes').val($amTimeOne.attr('def-value'));

                    $('#contract_time .select a:gt(' + (lenth - 1) + ')').css({ 'display': 'none' });
                    $('#contract_time .select a:eq(' + (lenth - 1) + ')').css({ 'display': 'block' });
                    $('#contract_time .select a:lt(' + (lenth - 1) + ')').css({ 'display': 'block' });

                } else {
                    $('#contract_time .select_txt h3').html($bmTimeOne.html());
                    $('#contract_time .select_txt h3').attr('title', $bmTimeOne.html());
                    $('.trueTimes').val($bmTimeOne.attr('def-value'));

                    $('#contract_time .select a:eq(' + (lenth - 1) + ')').css({ 'display': 'none' });
                    $('#contract_time .select a:lt(' + (lenth - 1) + ')').css({ 'display': 'none' });
                    $('#contract_time .select a:gt(' + (lenth - 1) + ')').css({ 'display': 'block' });
                }
            });
            //面试职位
            $("#posi_list").toggle(function(){
                $("#posi_choose").show();
            },function(){
                $("#posi_choose").hide();
            });
            $('#posi_choose a').click(function () {
                var txt = $(this).text();
                var posiVal = $(this).attr('def-value');
                $("#posi_list h3").text(txt);
                $("#posi_num").val(posiVal)
                    .attr('data-posi-id', $(this).data('posi-id'))
                    .attr('data-posi-name', $(this).text());

            });

            //下拉框切换——联系方式
            if (inviteMsg !== null) {
                if (inviteMsg.ContactPhoneType === 1) {
                    $('#tel_type').val(1);
                    $('#tel .select_txt h3').text('座机');

                    var arrContPhone = inviteMsg.ContactPhone.split('-');
                    $('.landline').show();
                    $('#tel_num').hide();

                    $('#areaCode').val(arrContPhone[0]);      //从后台获取并显示座机号
                    $('#landlineCode').val(arrContPhone[1]);
                    $('#extenCode').val(arrContPhone[2]);
                } else if (inviteMsg.ContactPhoneType === 0) {
                    $('#tel_type').val(0);
                    $('#tel .select_txt h3').text('手机');

                    $('.landline').hide();
                    $('#tel_num').show();
                    $('#tel_num').val(inviteMsg.ContactPhone);      //从后台获取并显示手机号

                }
            } else {
                $('.landline').hide();
                $('#tel_num').show();

                $('#tel_type').val(0);
                $('#tel .select_txt h3').text('手机');
            }

            $('#tel .select a').live('click', function () {
                var oParentFormList = $(this).parents('.form_list');

                $('.tip', oParentFormList).html('');
                $('input', oParentFormList).removeClass('tipColor');

                if ($(this).index() == 0) {
                    $('.landline').hide();
                    $('#tel_num').show();
                } else {
                    $('.landline').show();
                    $('#tel_num').hide();
                }
            });

            //下拉框验证
            //面试地点
            if (inviteMsg !== null) {
                if (inviteMsg.InterviewAddr !== null || inviteMsg.InterviewAddr !== "") {
                    $('#place').val(inviteMsg.InterviewAddr);
                }
            }
            $('#place').blur(function () {
                if ($(this).val() == '') {
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.place_isRight);
                    $(this).addClass('tipColor');
                }
            });
            $('#place').keyup(function () {
                var strReturn = positionCheck.isPlace_60figure($(this).val());

                if (strReturn == true) {
                    $(this).removeClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html('');
                } else {
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(strReturn);
                }
            });

            //联系人
            if (inviteMsg !== null) {
                if (inviteMsg.Contacts !== null || inviteMsg.Contacts !== "") {
                    $('#linkPeson').val(inviteMsg.Contacts);
                }
            }
            $('#linkPeson').blur(function () {
                if ($(this).val() === '') {
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.linkPerson_isRight);
                }
            });
            $('#linkPeson').keyup(function () {
                var strReturn = positionCheck.isLinkPeson_16figure($(this).val());
                if (strReturn == true) {
                    $(this).removeClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html('');
                } else {
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(strReturn);
                }
            });

            //联系电话
            $('#tel_num').blur(function () {
                if ($(this).val() == '') {
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.mobile_isRight);
                    $(this).addClass('tipColor');
                }
            });
            $('#tel_num').keyup(function () {
                var strReturn = positionCheck.isMobile_section($(this).val());
                if (strReturn == true) {
                    $(this).removeClass('tipColor');
                    $('#tel_num').parents('.form_list').find('.tip').html('');
                } else {
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.mobile_isRight);
                }
            });

            //区号与座机号默认值
            var iAreaCode = true;
            var iLandlineCode = true;
            var iExtenCode = true;

            $('#areaCode').focus(function () {
                if ($(this).val() == '区号') {
                    $(this).val('');
                }
            });
            $('#landlineCode').focus(function () {
                if ($(this).val() == '座机号') {
                    $(this).val('');
                }
            });
            $('#extenCode').focus(function () {
                if ($(this).val() == '分机号') {
                    $(this).val('');
                }
            });

            //区号
            $('#areaCode').blur(function () {
                if ($(this).val() == '区号' || $(this).val() == '') {
                    iAreaCode = false;
                    $(this).addClass('tipColor');
                    $(this).val('区号');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.code_isRight);
                }
            });
            $('#areaCode').keyup(function () {
                var strReturn = positionCheck.isAreaCode($(this).val());

                if (strReturn == true) {
                    iAreaCode = true;
                    $(this).removeClass('tipColor');

                    if (iLandlineCode == true && iExtenCode == true) {
                        $(this).parents('.form_list').find('.tip').html('');
                    }
                } else {
                    iAreaCode = false;
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.code_isRight);
                }
            });

            //座机号
            $('#landlineCode').blur(function () {
                if ($(this).val() == '座机号' || $(this).val() == '') {
                    iLandlineCode = false;
                    $(this).addClass('tipColor');
                    $(this).val('座机号');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.code_isRight);
                }
            });
            $('#landlineCode').keyup(function () {
                var strReturn = positionCheck.islandlineCode_8figure($(this).val());

                if (strReturn == true) {
                    iLandlineCode = true;
                    $(this).removeClass('tipColor');

                    if (iAreaCode == true && iExtenCode == true) {
                        $(this).parents('.form_list').find('.tip').html('');
                    }
                } else {
                    iLandlineCode = false;
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.code_isRight);
                }
            });

            //分机号
            $('#extenCode').blur(function () {
                if ($(this).val() == '分机号' || $(this).val() == '') {
                    iExtenCode = true;
                    $(this).val('分机号');
                    $(this).removeClass('tipColor');

                    if (iAreaCode == true && iLandlineCode == true) {
                        $(this).parents('.form_list').find('.tip').html('');
                    }
                }
            });
            $('#extenCode').keyup(function () {
                var strReturn = positionCheck.isExtenCode($(this).val());
                if (strReturn == true) {
                    iExtenCode = true;
                    $(this).removeClass('tipColor');

                    if (iAreaCode == true && iLandlineCode == true) {
                        $(this).parents('.form_list').find('.tip').html('');
                    }
                } else {
                    iExtenCode = false;
                    $(this).addClass('tipColor');
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.code_isRight);
                }
            });
        });

        //时间控件
        $.getScript("http://img01.zhaopin.cn/2014/rd2/js/timeMain.extend.js", function () {
            //加载时间控件与禁止输入
            var oDate = new Date(), maxDate = '2999/1/1';
            //抢人才最大时间为当前时间加三天
            if($("#fromd").val() === '2'){
                maxDate = new Date(oDate.getTime() + 3*24*60*60*1000);
            }
            _initTimeSelector('start_date', oDate, maxDate);
            $('#start_date').keydown(function () {
                return false;
            });
            $('#start_date').live('focus', function () {
                iEndCtreateBtn = false;
                iremoveBtn = false;
            });
            $('#start_date').live('blur', function () {
                iEndCtreateBtn = true;
                iremoveBtn = true;
            });

            //时间验证
            var timeDefaultValue = $('#start_date').val();
            $('#start_date').focus(function () {
                if ($(this).val() == timeDefaultValue) {
                    $(this).val('');
                }
            });
            $('#start_date').blur(function () {
                if ($(this).val() == '') {
                    $(this).val(timeDefaultValue);
                    $(this).parents('.form_list').find('.tip').html(tipsMsg.time_isRight);
                    $(this).parents('.shadow_bg').addClass('tipColor');
                }
            });
        });
        getsms_num();
    }

    function fnTan_noMatchCallBack() {
        $('.tanNoMatch .tanNoMatch_name').html($("#tt_username").val());
        $('.tanNoMatch .tanNoMatch_num').html($('#fkt_blszlb').val());
        $.getScript("http://img01.zhaopin.cn/2014/common/js/za/ga.js");

        //表单验证
        $('#others_reason_tip').blur(function () {
            if ($(this).val() == '') {
                $(this).addClass('tipColor');
                $(this).parents('li.long').find('.tip').html(tipsMsg.noMatch_isRight);
            }
        });
        $('#others_reason_tip').keyup(function () {
            var strReturn = positionCheck.isNoMatch($(this).val());
            if (strReturn == true) {
                $(this).removeClass('tipColor');
                $(this).parents('.long').find('.tip').html('');
            } else {
                $(this).addClass('tipColor');
                $(this).parents('.long').find('.tip').html(strReturn);
            }
        });
    }

    //反馈通E期
    //待沟通弹窗
    $('#feedbackE_standby').live('click', function () {
        var unique_id = GetSelect_unique_id();
        var oldstatus = $("#labeltype").val();

        //请求
        $.ajax({
            type: "POST",
            url: "/resumePreview/resume/_FktLook?oldstatus=" + oldstatus + "&status=2&guid=" + unique_id,
            dataType: 'json',
            cache: false,
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data.Code == 200) {
                    refresh();
                    fnRemove();
                } else if (data.Code == 1004) {
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            }
        });
    });

    //待沟通弹窗 确定按钮
    /*$('.tan_noMatchECom1 .sure').live('click', function () {
        var unique_id = GetSelect_unique_id();
        var oldstatus = $("#labeltype").val();

        //请求
        $.ajax({
            type: "POST",
            url: "/resumePreview/resume/_FktLook?oldstatus=" + oldstatus + "&status=2&guid=" + unique_id,
            dataType: 'json',
            cache: false,
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data.Code == 200) {
                    refresh();
                    fnRemove();
                } else if (data.Code == 1004) {
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            }
        });
    });*/

    //不合适弹窗
    /*$('.feedbackE .noMatch').live('click', function () {
        var htmlFETanCom = "<div class=\"tanECom\"><p>确定将此份简历标记为&nbsp<b>不合适简历</b>&nbsp吗？<br />确定后你可以到&nbsp<a href='http://rd2.zhaopin.com/rdapply/resumes/apply/index?SF_1_1_50=4' target='_blank'>不合适</a>&nbsp列表下查看这些简历</p></div>";
        createTan({
            tanStyle: "tan_noMatchECom2 tan_small",
            tanTitle: "温馨提示",
            tanCont: htmlFETanCom,
            isLoadTanCont: false,
            tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" /><input class=\"refuse no_active\" type=\"button\" value=\"取消\" />"
        });
        toRemove({ closeBtn: ".tan_noMatchECom2 .close" });
    });*/

    $('#feedbackE_invite').live('click', function () {
        fnInvite();
    });

    if ($('.feedbackE input.noMatch').hasClass('showAskDialog')) {
        //白名单公司显示询问框
        $('.feedbackE .noMatch').live('click', function () {
            var htmlFETanCom = "<div class=\"tanECom\"><p>确定将此份简历标记为&nbsp<b>不合适简历</b>&nbsp吗？<br />确定后你可以到&nbsp<a href='http://rd2.zhaopin.com/rdapply/resumes/apply/index?SF_1_1_50=4' target='_blank'>不合适</a>&nbsp列表下查看这些简历</p></div>";
            createTan({
                tanStyle: "tan_noMatchECom2 tan_small",
                tanTitle: "温馨提示",
                tanCont: htmlFETanCom,
                isLoadTanCont: false,
                tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" /><input class=\"refuse no_active\" type=\"button\" value=\"取消\" />"
            });
            toRemove({ closeBtn: ".tan_noMatchECom2 .close" });
        });
    } else {
        //暂不合适按钮
        $('.feedbackE input.noMatch').live('click', function () {
            //不合适弹窗 添加
            createTan({
                tanStyle: "tan_noMatchECom2 tan_small",
                tanTitle: "不合适原因",
                tanTitleClose: "__ga__searchresultTab_jjguanbi_001",
                tanCont: "tanNoMatch",
                tanContUrl: "/resumePreview/resume/feedbackDalert?labeltype=" + $("#labeltype").val() + "&ttownerid=" + $("#dda_ownerid").val() + "&ttposnumber=" + $("#PositionNumber").val() + "&posttype=" + $('#posttype').val()+"&fromd=" +  $("#fromd").val(),
                tanBtn: "<input class=\"__ga__searchresultTab_jjqueren_001 sure active\" type=\"button\" value=\"确 定\" /><input class=\"__ga__searchresultTab_zanbuheshiBXYY_001 noRightNow no_active\" type=\"button\" value=\"不选原因，直接拒绝\" />",
                fnLoadCallBack: fnTan_noMatchCallBack
            });
            toRemove({ closeBtn: ".tan_noMatchECom2 .close" });
        });
    }

    //不合适弹窗 确定按钮
    $('.tan_noMatchECom2 input.sure,.tan_noMatchECom2 input.noRightNow').live('click', function () {
        var unique_id = GetSelect_unique_id();
        var oldstatus = $("#labeltype").val();

        //投递不合适处理
        $.ajax({
            type: 'post',
            url: '/resumePreview/resume/_TdRefuse?oldstatus=' + oldstatus + '&gid=' + unique_id,
            dataType: 'json',
            cache: false,
            beforeSend: function (XMLHttpRequest) {
                iEndCtreateBtn = false;
                createTan({
                    tanStyle: "tan_loading tan_small"
                });
            },
            success: function (data) {
                if (data.Code == 200) {
                    refresh();
                    fnRemove();
                } else if (data.Code == 1004) {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: "操作失败，请刷新后重试",
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                } else {
                    //加载错误 弹窗
                    createTan({
                        tanStyle: "tan_error tan_small",
                        tanCont: "tanError",
                        tanMsg: data.Message,
                        tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                    });
                    toRemove({ closeBtn: ".tan_error input.sure" });
                    toRemove({ closeBtn: ".tan_error .close" });
                }
            },
            error: function () {
                //加载错误 弹窗
                createTan({
                    tanStyle: "tan_error tan_small",
                    tanCont: "tanError",
                    tanBtn: "<input class=\"sure active\" type=\"button\" value=\"确 定\" />"
                });
                toRemove({ closeBtn: ".tan_error input.sure" });
                toRemove({ closeBtn: ".tan_error .close" });
            }
        });
    });

    $('#remarkInput').live('keyup', function (e) {
        if (isOverLength($(this).val(), 40)) {
            $(".tipElse").text("最多输入40个字符！");
            $(this).addClass("bColorRed");
            $(this).val(cutStr1($(this).val(), 40));
            e.preventDefault();
        } else {
            $(this).removeClass("bColorRed");
            $(".tipElse").html("");
        }

    });

    //拒绝原因
    var data = $('#refuse_reason').attr('data');
    if (data && data.length > 0) {
        $.ajax({
            url: '/resumepreview/resume/GetRefuseDetail',
            data: data,
            success: function (json) {
                var showbox = $('#refuse_reason_box');
                if (json && json.Status == 200) {
                    if (json.Data && json.Data.resufecontent && json.Data.resufecontent.length > 0) {
                        showbox.html(json.Data.resufecontent);
                        $('#refuse_reason').show().hover(function () { showbox.show(); }, function () { showbox.hide(); });
                    }
                }
            },
            error: function (a, b, c) {
            }
        });
    }

    //加载求职信
    if ($('#coverletterPanel').length==1 && $('#coverletterPanel').attr('data').indexOf('=0') == -1) {
        var pdata = $('#coverletterPanel').attr('data');
        $.ajax({
            url: 'http://rd.zhaopin.com/resumepreview/resume/coverletter',
            type: 'post',
            data: pdata,
            success: function(json) {
                if (json && json.Code == 200) {
                    var html = $('#coverletterPanel').html();
                    var newHtml = json.Data.Content + '<input type="hidden" id="coverInfo" value="' + json.Data.ExtNum + '_' + json.Data.Version + '" />';
                    html = html.replace('{$letter_content$}', newHtml);
                    $('#coverletterPanel').html(html).show();
                }
            },
            error: function(a) {
            }
        });
    }

    //在简历预览页面中添加NET考试结果
    var net_pars = $('#neturlparam').val();//从页面的隐藏域中获取请求需要的参数
    if(net_pars){
        $.ajax({
            url : 'http://net.zhaopin.com/Api/Score',
            data : net_pars,
            type : 'get',
            dataType : 'jsonp',
            jsonp : 'jsonpCallback',
            success : function(data) {
                var result = data.Result;
                //请求成功并且NET为显示即IsOpen值为true时才显示NET结果
                if(data.Code == 0 && result.IsOpen){
                    var html = '<div class="resume-preview-all"><h3 class="fc6699cc">NET就业能力认证结果</h3>';
                    var strs = ['<h5>通用能力总分：<span style="font-weight:normal; padding: 0px; font-size: 12px;">@~</span></h5>',
                        '<h5>职业行为特征：<span style="font-weight:normal; padding: 0px; font-size: 12px">@~</span></h5>',
                        '<h5>职业期望：<span style="font-weight:normal; padding: 0px; font-size: 12px">@~</span></h5>'];
                    for(var i = 0, len = result.TestPaperScores.length; i < len; i++){
                        var option = result.TestPaperScores[i];
                        var name = option.TestPaperName, score = option.Score, comm = option.Comment;
                        if(/通用/.test(name)){
                            strs[0] = strs[0].replace(/@~/, (score ? (score + '分') : '') + (score && comm ? '，' : '') + (comm ? comm : ''));
                        }else if(/行为/.test(name)){
                            strs[1] = strs[1].replace(/@~/, comm ? comm : '');
                        }else if(/期望/.test(name)){
                            strs[2] = strs[2].replace(/@~/, comm ? comm : '');
                        }
                    }
                    html += strs.join('').replace(/@~/g, '');
                    //查看NET认证报告
                    html += '<p style="margin: 10px 0 0 22px;"><a href="' + (result.BReport ? result.BReport : 'javascript:void(0);') + '" target="_blank">查看NET认证报告</a></p>';
                    html += '</div>';
                    $('#resumeContentBody > .resume-preview-all h3:contains("教育经历")').parent().after(html);
                }
            }
        });
    }
});

//弹窗控件
var iEndCtreateBtn = false;
var iremoveBtn = true;
$(window).scroll(tochange);
$(window).resize(tochange);

//创建弹窗
function createTan(tanOptions) {
    $('.tan').remove();

    var opts = {
        tanStyle: "tan_small",			    //控制弹窗样式的class
        tanTitle: "提示信息",			    //弹窗标题
        tanTitleTwo: "",			    //弹窗标题2
        tanTitleThreeName: "",			    //弹窗标题3
        tanTitleFour: "",			    //弹窗标题4
        tanTitleClose: "",                          //弹窗关闭按钮的class
        tanCont: "",				    //当外部加载弹窗内容区域时，tanCont代表加载的弹窗内容区域Class，当内容拼接弹窗内容区域时，tanCont代表拼接的内容
        tanContUrl: "",			            //弹窗内容区域加载地址
        isLoadTanCont: true,                        //是否外部加载弹窗内容
        tanMsg: "信息加载错误，请刷新页面重试...",    //加载内容区域提示信息
        tanBtn: "",				    //弹窗底部按钮
        fnLoadCallBack: function () { }		    //弹窗添加完成后回调函数
    };
    $.extend(opts, tanOptions);

    iremoveBtn = false;
    //弹窗头部
    var thisClassArr = opts.tanStyle.split(' '),
        titleTan = '';
    if (thisClassArr[0] == 'tan_error') {           //错误弹窗
        titleTan = "<div class=\"tan " + thisClassArr[0] + ' tan_small' + "\"><h5 class=\"tanTitle\"><span><strong>提示信息</strong></span><a class=\"" + opts.tanTitleClose + " close\"" + " href=\"javascript:;\" target=\"_self\">&nbsp;</a></h5>";                               //加载中弹窗
    } else if (thisClassArr[0] == 'tan_loading') {  //加载中弹窗
        titleTan = "<div class=\"tan " + thisClassArr[0] + ' tan_small' + "\"><h5 class=\"tanTitle\"><span><strong>提示信息</strong></span><a class=\"" + opts.tanTitleClose + " close\"" + " href=\"javascript:;\" target=\"_self\">&nbsp;</a></h5>";
    } else {                                        //自定义弹窗
        if (opts.isLoadTanCont == true) {               //外部加载弹窗内容
            titleTan = "<div class=\"tan " + thisClassArr[0] + ' tan_small' + "\"><h5 class=\"tanTitle\"><span><strong>提示信息</strong><em class='tanTitleTwo'>" + opts.tanTitleTwo + "</em>" + "<b></b>" + "<em class='tanTitleFour'>" + opts.tanTitleFour + "</em>" + "</span><a class=\"" + opts.tanTitleClose + " close\"" + " href=\"javascript:;\" target=\"_self\">&nbsp;</a></h5>";
        } else {                                      //拼接弹窗内容
            titleTan = "<div class=\"tan " + opts.tanStyle + "\"><h5 class=\"tanTitle\"><span><strong>" + opts.tanTitle + "</strong><em class='tanTitleTwo'>" + opts.tanTitleTwo + "</em>" + "<b></b>" + "<em class='tanTitleFour'>" + opts.tanTitleFour + "</em>" + "</span><a class=\"" + opts.tanTitleClose + " close\"" + " href=\"javascript:;\" target=\"_self\">&nbsp;</a></h5>";
        }
    }

    //弹窗中部+底部
    var contTan = '',
        footTan = '',
        htmlTan = '';
    if (thisClassArr[0] == 'tan_error') {		     //错误弹窗
        contTan = "<div class=\"tanCont\"><div class=\"tanShow\"><div class=\"tanError\"><div><p>" + opts.tanMsg + "</p></div></div></div></div>";
        footTan = "<div class=\"tanFoot\">" + opts.tanBtn + "</div></div>";
    } else if (thisClassArr[0] == 'tan_loading') {   //加载中弹窗
        contTan = "<div class=\"tanCont\"><div class=\"tanShow\"><div class=\"tanLoading\"><div><img src=\"http://img01.zhaopin.cn/2014/rd2/img/sysLoading.gif\" /><p>正在加载中...</p></div></div></div></div>";
        footTan = "<div class=\"tanFoot whiteColor\"></div></div>";
    } else {                                        //自定义弹窗
        if (opts.isLoadTanCont == true) {               //外部加载弹窗内容
            contTan = "<div class=\"tanCont\"><div class=\"tanShow\"><div class=\"tanLoading\"><div><img src=\"http://img01.zhaopin.cn/2014/rd2/img/sysLoading.gif\" /><p>正在加载中...</p></div></div></div></div>";
            footTan = "<div class=\"tanFoot whiteColor\">" + opts.tanBtn + "</div></div>";
        } else {                                      //拼接弹窗内容
            contTan = "<div class=\"tanCont\"><div class=\"tanShow\">" + opts.tanCont + "</div></div>";
            footTan = "<div class=\"tanFoot\">" + opts.tanBtn + "</div></div>";
        }
    }
    htmlTan = titleTan + contTan + footTan;

    if ($('body .zheZhao').length == 0) {
        $('body').append('<div class="zheZhao"></div>');
    }
    $('body').append(htmlTan);

    if (thisClassArr[0] != 'tan_error' && thisClassArr[0] != 'tan_loading') {      //非错误弹窗和加载中
        if (opts.isLoadTanCont == true) {             //外部加载弹窗内容
            $('.' + opts.tanCont).appendTo('.tanShow');
        }
        $('.' + opts.tanCont).show(300);          //自定义弹窗显示

    }

    $('.zheZhao').fadeIn(400);

    $('.tan').fadeIn(400, function () {
        iEndCtreateBtn = true;
        iremoveBtn = true;
    });

    $('.zheZhao').css({
        'width': '100%',
        'height': iHBody
    });
    $('.tan').css({
        'left': ($(document).width() - $('.tan').width()) / 2,
        'top': ($(window).height() - $('.tan').height()) / 2 + ($(window).scrollTop() - 20)
    });

    if (thisClassArr[0] == 'tan_error') {                   //错误弹窗
        fnShowCont();
    } else if (thisClassArr[0] == 'tan_loading') {          //加载中弹窗
        toRemove({ closeBtn: "." + thisClassArr[0] + " " + ".close" });
    } else {                                                //自定义弹窗
        if (opts.isLoadTanCont == true) {                       //外部加载弹窗内容
            //加载中间区域
            $(".tanShow").load(opts.tanContUrl + ' .' + opts.tanCont, function () {
                //弹窗头部
                if (opts.tanTitleThreeName != '' && $('[name=' + opts.tanTitleThreeName + ']').val() != 0) {
                    $('.tan h5 span b').text($('[name=' + opts.tanTitleThreeName + ']').val());
                    $('.tanTitle span').children().css({ 'opacity': 1 });
                } else {
                    $('.tanTitle span').children('em,b').css({ 'display': 'none' });
                    $('.tan h5 span strong').css({ 'opacity': 1 });
                }
                $('.tan h5 span strong').text(opts.tanTitle);

                //弹窗中部
                if ($('.tanLoading').length > 0) {
                    $('.tanLoading').css({ "display": "none" });
                }

                //弹窗底部
                $('.' + thisClassArr[0]).removeClass('tan_small').addClass(thisClassArr[1]);
                $('.tanFoot').removeClass('whiteColor');

                //弹窗底部
                fnShowCont();
            });
        } else {                                             //拼接弹窗内容
            //弹窗头部
            if (opts.tanTitleThreeName !== '' && $('[name=' + opts.tanTitleThreeName + ']').val() !== 0) {
                $('.tan h5 span b').text($('[name=' + opts.tanTitleThreeName + ']').val());
                $('.tanTitle span').children().css({ 'opacity': 1 });
            } else {
                $('.tanTitle span').children('em,b').css({ 'display': 'none' });
                $('.tan h5 span strong').css({ 'opacity': 1 });
            }
            $('.tan h5 span strong').text(opts.tanTitle);

            //弹窗底部
            $('.tanFoot input').css({ "display": "block" });

            //弹窗底部
            fnShowCont();
        }

    }

    function fnShowCont() {
        //重新计算弹窗居中位置
        $('.tan').css({
            'left': ($(document).width() - $('.tan').width()) / 2,
            'top': ($(window).height() - $('.tan').height()) / 2 + ($(window).scrollTop() - 20)
        });

        //弹窗底部
        var widthBtns = 0;
        var wtanFoot = $('.tanFoot').outerWidth();
        var footInputMLeft = opts.footInputMLeft ? opts.footInputMLeft : 9;

        $('.' + thisClassArr[0] + ' ' + '.tanFoot input').each(function () {
            widthBtns += (Number($(this).outerWidth()) + footInputMLeft);
        });
        widthBtns -= 10;
        $('.' + thisClassArr[0] + ' ' + '.tanFoot').css({
            'paddingLeft': Math.floor((wtanFoot - widthBtns) / 2)
        });
        var paddtanFoot = $('.' + thisClassArr[0] + ' ' + '.tanFoot').css("paddingLeft");
        $('.' + thisClassArr[0] + ' ' + '.tanFoot').width(wtanFoot - parseInt(paddtanFoot) - 2);
        $('.tanFoot input').css({ "display": "block" });
        $('.' + opts.tanCont).css({ "display": "block" });

        //弹窗中部与底部加载完成后回调
        opts.fnLoadCallBack();
    }

    //关闭弹窗操作
    toRemove({ closeBtn: "." + thisClassArr[0] + " " + ".refuse" });
}
//弹窗滑动
function tochange() {
    iHBody = ($(document).height() <= $(window).height()) ? $(window).height() : $(document).height();
    $('.zheZhao').css({
        'width': '100%',
        'height': iHBody
    });
    if (iEndCtreateBtn == true && iremoveBtn == true) {
        $('.tan').stop().animate({
            'left': ($(document).width() - $('.tan').width()) / 2,
            'top': ($(window).height() - $('.tan').height()) / 2 + ($(window).scrollTop() - 20)
        }, 500, 'easeOutCirc');
    }
}
function toRemove(closeOption) {
    var closeopts = {
        closeBtn: "",
        fnToRemoveBefore: function () { }
    };
    $.extend(closeopts, closeOption);

    $(closeopts.closeBtn).live('click', function () {
        iremoveBtn = false;
        closeopts.fnToRemoveBefore();

        $('.zheZhao').fadeOut(400, function () {
            $('.zheZhao').remove();
            iEndCtreateBtn = false;
            iremoveBtn = true;
        });
        $('.tan').fadeOut(400, function () {
            if($("#fromd").val() === '2' && $('input[data-click]').attr('data-click')=='0'){
                location.reload()
            }
            $('.tan').remove();
            iEndCtreateBtn = false;
            iremoveBtn = true;
        });
    });
}
function fnRemove() {
    iremoveBtn = false;

    $('.zheZhao').fadeOut(300, function () {
        $('.zheZhao').remove();
        iEndCtreateBtn = false;
        iremoveBtn = true;
    });

    $('.tan').fadeOut(300, function () {
        $('.tan').remove();
        iEndCtreateBtn = false;
        iremoveBtn = true;
    });
}

//单选框
function fnCheck(obj) {
    var bindHidden = $(obj).attr('bind_hidden');
    var bindVal = $(obj).data('val');

    if ($(obj).parents('form').find('.reason_tip').html()) {
        $(obj).parents('form').find('.reason_tip').html('');
        $(obj).parents('form').find('.reason_tip').css({ 'display': 'none' });

        $('.tan_noMatch .checkbox').removeClass('redBg');
    }

    if ($(obj).hasClass("checkbox_checked")) {
        $(obj).parents('ul').find('.checkbox').removeClass('checkbox_checked');
        $(obj).parents('ul').find('li [name!=' + bindHidden + ']').val("0");
        $('#others_reason_tip').val('');

        $(obj).removeClass("checkbox_checked");
        $('[name=' + bindHidden + ']').val("0");

        if ($(obj).parents('li').find('.others_reason').length > 0) {   //存在文本框
            $(obj).parents('.tanNoMatch').removeClass('gao');
            $(obj).parents('li').find('.others_reason').hide();

            $(obj).parents('ul').find('.others_reason').removeClass('tipColor');
            $(obj).parents('ul').find('.others_reason_tip').html('');
        }
    } else {
        $(obj).parents('ul').find('.checkbox').removeClass('checkbox_checked');
        $(obj).parents('ul').find('li [name!=' + bindHidden + ']').val("0");
        $('#others_reason_tip').val('');


        $(obj).parents('ul').find('.others_reason').removeClass('tipColor');
        $(obj).parents('ul').find('.others_reason_tip').html('');


        $(obj).addClass("checkbox_checked");
        $('[name=' + bindHidden + ']').val(bindVal);

        if ($(obj).parents('li').find('.others_reason').length > 0) {   //存在文本框
            $(obj).parents('.tanNoMatch').addClass('gao');
            $(obj).parents('li').find('.others_reason').fadeIn(300);
        } else {
            $(obj).parents('.tanNoMatch').removeClass('gao');       //不存在文本框
            $(obj).parents('ul').find('.others_reason').fadeOut(300);
        }
    }
    return false;
}

//时间控件
var cur = 0;
var startGetDate = document.getElementById('startGetDate');
var nowTimeString = new Date();
var endTime1 = new Date(nowTimeString);
var oBackCalTime1 = null;
function _initTimeSelector(selectorIDS, selectorSdate, selectorEdate) {
    var $dateEnd = $("#" + selectorIDS);
    var maxDate = $dateEnd.attr("maxdate");
    var isetSdate = selectorSdate;      //设置开始时间
    var newSdate = new Date(isetSdate);
    var isetEdate = selectorEdate;      //设置结束时间
    var newEdate = new Date(isetEdate);
    var _maxDate = new Date(+new Date() + 90 * 24 * 60 * 60 * 1000);

    //选择日期回调函数
    function fnSelectDateStart(obj) {
        if (obj["data-date"]) {
            switch (this.triggerNode.id) {
                case selectorIDS:
                    oBackCalTime1.endDate = this.endDate = obj["data-date"];
                    oBackCalTime1.render(this.endDate);

                    var arr = obj["data-date"].split('-');

                    //表单验证
                    $('#startGetDate').val(obj["data-date"]);
                    if ($('#startGetDate').val() != '') {
                        $('#start_date').parents('.form_list').find('.tip').html('');
                        $('#start_date').parents('.shadow_bg').removeClass('tipColor');
                    }

                    oBackCalTime1.render();
                    break;
            }
        } else {
            this.oneMonthY(timeMonth);
            oBackCalTime1.endDate = oYear + '-' + lzc.zero(timeMonth) + '-' + oBackCalTime1.r;
        }
    }

    //关闭日历回调函数
    function fnClose() {
        this.hideMessage();
    }
    oBackCalTime1 = new Calendar({
        id: "#" + selectorIDS,          //触发显示日历元素ID
        isPopup: !0,                    //弹出式日历
        isPrevBtn: !0,                  //显示上月按钮
        isNextBtn: !0,                  //显示下月按钮
        isCloseBtn: !0,                 //显示关闭按钮
        isHoliday: !0,                  //节假日特殊显示
        isHolidayTips: !0,              //显示节假日1~3天/后1~3天信息
        isDateInfo: !0,                 //显示日期信息
        isMessage: !0,                  //有日历提示信息
        isCalEnd: !0,                   //标记为结束时间
        dateInfoClass: "date-info-end", //结束时间icon样式
        range: { mindate: newSdate, maxdate: newEdate || _maxDate }, //限制范围（当天——2020-12-31）
        count: 1,                       //日历个数
        monthStep: 1,                   //切换上下月日历步长
        onSelectDate: fnSelectDateStart,    //选择日期回调方法
        onClose: fnClose                //关闭日历回调方法
    });

    oBackCalTime1.eTime(oBackCalTime1);
}

//下拉框
var iBtnSelectDisplay = false;
function showSelect() {
    ZPIDC.ns("ZPIDC.addJob");
    ZPIDC.addJob.InitSelector = function (cfg) {
        var me = new Object();
        me.optionData = null;
        me.selectID = '';
        ZPIDC.copy(me, cfg);
        me.afterInit = function () {
            var ctx = $('#' + me.selectID);
            var jqDoma = $('.select a', ctx);
            var hideDom = $('[name="' + me.hideInputName + '"]');
            if (hideDom.val() != '') {
                var selectTxt = jqDoma.filter('[def-value=' + hideDom.val() + ']').text();
                ctx.find('h3').css({ color: '#333' }).text(selectTxt);
            }
            me.addOptionEvent();
        };
        me.addOptionEvent = function () {
            var ctx = $('#' + me.selectID);
            var jqDoma = $('.select a', ctx);
            var hideDom = $('[name="' + me.hideInputName + '"]');
            var enterflag = true;

            $('.select_txt', ctx).live('click', function () {
                if (ctx.find('.select:hidden').length) {
                    if (jqDoma.length > 0) {
                        ctx.find('.select').show();
                        iBtnSelectDisplay = true;
                    }
                } else {
                    ctx.find('.select').hide();
                }
                return false;
            });

            ctx.filter('.selectBox').live('blur', function () {
                if (enterflag) {
                    $(this).children('.select').hide();
                }
            });

            $('.select', ctx).hover(function () {
                enterflag = false;
            }, function () {
                enterflag = true;
            });

            jqDoma.live('click', function () {
                var _text = $(this).text();
                $(this).parent().hide();
                ctx.find('h3').css({ color: '#333' }).text(_text).attr('title', _text);
                hideDom.val($(this).attr('def-value'));
                if (typeof me.optionCallback == 'function') {
                    me.optionCallback(this);
                }
            });

            $("body").live('click', function () {
                if (iBtnSelectDisplay == true) {
                    $('.select').css({ "display": "none" });
                }
            });
        };
        me.createTpl = function (tpls, val, text) {
            var tpl = '<a def-value="{0}" href="javascript:void(0);" title="{1}">{1}</a>';
            tpls.push(tpl.zformat(val, text));
        };
        me.createOptions = function () {
            var data = me.optionData;
            var tpls = [];
            if (data instanceof Array) {
                for (var step = 0, len = data.length; step < len; step++) {
                    me.createTpl(tpls, data[step][0], data[step][1]);
                }
            } else if (data instanceof Object) {
                for (var key in data) {
                    me.createTpl(tpls, key, data[key]);
                }
            }
            if (me.defOption) {
                tpls.unshift(me.defOption);
            }
            return tpls.join("");
        };
        me.init = function () {
            var jqSelector = $('#' + me.selectID);
            me.hideInputName = jqSelector.attr('bind_hidden');
            me.selector = jqSelector;
            if ($('.select', jqSelector).length == 0) {
                var tpl = me.createOptions();
                var selctorOption = $('<div class="select"></div>').width(jqSelector.width() + 20).append(tpl);
                if (tpl == '') {
                    selctorOption.css({ 'display': 'none' });
                }
                $('#' + me.selectID).append(selctorOption);
            }
            me.afterInit();
        };
        me.init();
    };
}
function getsms_num() {
    //如果同时发送短信通知的选项不可见就不加载短信余额
    if (!$('#invite_andsms').is(':visible')) {
        return;
    }
    $.ajax({
        url: '/resumePreview/resume/_GetSmsNum',
        type: 'post',
        data: 't=3',
        success: function (json) {
            if (!json || json.sms != 1) {
                $('#sms_tips').html('（您的短信服务不可用）');
                $(".SMSPart span").die("click");
                return;
            }
            var tips = '（当前可发送的短信条数 <a href="javascript:;">' + json.num + '</a> 条）';
            if (json.num <= 0) {
                tips = '（需要发送 <a href="#">1</a> 条，短信剩余 <a href="#">' + json.num + '</a> 条。余额不足，请联系销售充值。）';
                $(".SMSPart span").die("click");
            }
            $('#sms_tips').html(tips);
        },
        error: function (a, b, c) {
            $('#sms_tips').html('（您的短信服务不可用）');
            $(".SMSPart span").die("click");
        }
    });
}

/*20150811 新增备注短信通知*/
$(".remarkPart li:not('.remarkElse')").live("click", function () {
    $(this).toggleClass("remarkChoosed");
});
$(".SMSPart span").live("click", SMSclick);
function SMSclick() {
    $(this).toggleClass("remarkChoosed");
}
var remarkTips = "最多输入40字符！";
//input框的操作
function remarkFn1(nowLi) {
    //取消勾选
    if ($(nowLi).hasClass("remarkChoosed")) {
        $(nowLi).removeClass("remarkChoosed");
        $(nowLi).next().removeClass("elseChoosed").attr("disabled", "true").css("color", "#999");
        $(".tipElse").text("");
        $('#remarkInput').removeClass("bColorRed");
        judgeEmpty($(nowLi).next(), false);
    } else {
        //勾选
        $(nowLi).addClass("remarkChoosed");
        if ($(nowLi).next().val() == remarkTips || $(nowLi).next().val() == "") $(nowLi).next().addClass("elseChoosed").val(remarkTips).css("color", "#999");
        else $(nowLi).next().addClass("elseChoosed").css("color", "black");
        $(nowLi).next().removeAttr("disabled");
    }
}
//鼠标在input框的移入移出
function remarkFnc(nowInput) {
    judgeEmpty($(nowInput), false);
}
function remarkFnb(nowInput) {
    judgeEmpty($(nowInput), true);
}
//判断是否输入的子函数
function judgeEmpty(_this, bSignal) {
    if (bSignal) {
        if (_this.val() == "") {
            _this.val(remarkTips);
            $('#remarkInput').css("color", "#999");
        }
    } else {
        if (_this.val() == remarkTips) {
            _this.val("");
            $('#remarkInput').css("color", "black");
        }
    }
}

/*
*判断字符串是否超过指定长度
*str:源字符串
*maxLen:最大字符长度
*/
function isOverLength(str, maxLen) {	//判断中英字符串 双字节字符长度为2 ASCLL字符长度为1
    var strLen = str.replace(/[^\x00-\xff]/g, '**').length;
    return strLen > maxLen;
}
function cutStr1(str, cutLen) {
    var returnStr = '';
    var reCN = /[^\x00-\xff]/;
    var strCNLen = str.replace(/[^\x00-\xff]/g, '**').length;

    if (cutLen >= strCNLen) {
        return str;
    }

    for (var i = 0, len = 0; len < cutLen; i++) {
        returnStr += str.charAt(i);
        if (reCN.test(str.charAt(i))) {
            len += 2;
        } else {
            len++;
        }
    }

    return returnStr;
}
//简历打赏
$(function(){

    if($(".quick_feed_back .close").length == 0){
        showDS();
    }else{
        $(".quick_feed_back .close").live("click",function(){
            showDS();
        })
    }
    function showDS(){
        if($("#rewardhrresult").val()==1){
            var html = '<div class="dashang_box"><span class="xy_coin_img"></span>由于您及时处理了应聘者简历，赠送5个智联币到您的账户，请注意查收！</div>'
            $("body").append(html);
            setTimeout(function(){
                $(".dashang_box").fadeOut();
            },3000)
        }
    }
})

// 抢人才 暂不合适按钮
// $(".inappropriate").click(function(){
//     $.ajax({
//         url:"/resumepreview/resume/rejectusersubway",
//         type:"post",
//         data:{subwayid: $('#guid').val()},
//         success: function(data){
//             //console.log(data)
//             if(data.Code==200){
//                  location.reload();
//             }else{
//                 alert("出错了，请稍后再试");
//             }
//         }
//     })
// })

// 暂不合适增加不同的埋点
$(".noMatch").each(function(){
    if($(this).css('left')=="374px"){
            $(this).removeClass("__ga__searchresultTab_zanbuheshi_001").addClass("__ga__searchresultTab_zanbuheshi_002")    
            }else if($(this).css("left") == "270px"){
            $(this).removeClass("__ga__searchresultTab_zanbuheshi_001").addClass("__ga__searchresultTab_zanbuheshi_001")
            }   
    })







