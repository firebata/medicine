// JavaScript Document

$(document).ready(function () {
    // 关键词高亮功能  
    var key = $('input[name=keyword_search]').val() || '';
    var keyCollege = $('input[name=college_search]').val() || '';
    var keyCompany = $('input[name=company_search]').val() || '';
    key = $.trim(key);
    keyCollege = $.trim(keyCollege);
    keyCompany = $.trim(keyCompany);
    highlight("#resumeContentHead", key);
    highlight("#resumeContentBody", key);
    highlight(".educationContent", keyCollege);
    highlight(".workExperience", keyCompany);
    // 多简历切换
    (function () {
        var curIndex = 0, fstIndex = 0;
        var iw = 115;
        var so = $(".nav-body-main-hidden ul");
        var sw = so.find("li").length * iw;
        var pw = iw * 6;
        so.css("width", sw + "px");
        var listPosition = $("#listPosition").val();
        so.css("margin-left", listPosition);
        curIndex = $(".nav-body-current").prevAll().length;
        if (so.length > 0) {
            var marginLeft = so.css("margin-left");
            fstIndex = parseInt(marginLeft.replace("px", "")) / iw;
            if (fstIndex < 0) {
                fstIndex = -fstIndex;
            }
        }

        function toLeft() {
            $(".left-button-img").unbind('click');
            var ml = parseInt(so.css("margin-left"));
            if (ml < 0 && curIndex - fstIndex <= 0) {
                fstIndex--;
                so.css("margin-left", ml + iw + "px");

            }
            var current = $(".nav-body-current");
            var prev = current.prev();
            if (prev.length) {
                curIndex--;
                submit(prev);
            }
        }
        function toRight() {
            $(".right-button-img").unbind('click');
            var current = $(".nav-body-current");
            var next = current.next();
            if (next.length) {

                curIndex++;

                var ml = parseInt(so.css("margin-left"));
                if (ml - pw > -sw && curIndex - fstIndex > 5) {
                    fstIndex++;
                    so.css("margin-left", ml - iw + "px");
                }

                submit(next);
            }
        }

        $(".left-button-img").click(toLeft);
        $(".right-button-img").click(toRight);

        $(".dev_resume_list_item").click(function () {
            var el = $(this);
            if (!el.hasClass("nav-body-current")) {
                curIndex = el.prevAll().length;
                submit(el);
            }
            if ($(".matching").length > 0) {
                $(".matching").stop(true, true).fadeOut();
            }
            return false;
        });

        function submit(el) {
            //存储当前选中的简历。
            $('#currentExtId').val(el.attr('dev_args'));
            
            //存储当前简历。
            $("#listPosition").val($(".nav-body-main-hidden ul").css("margin-left"));
            
            var args = el.attr("dev_args");
            $("#resume").val(args);
            var current = $(".nav-body-current");
            current.removeClass("nav-body-current");
            current.addClass("nav-body-bg");
            current.find("#loadingResume").hide();
            el.removeClass("nav-body-bg");
            el.addClass("nav-body-current");
            el.find("#loadingResume").show();
            //$("#frmResumeList").submit();
            $('#srListForm')[0].submit();
        }
    })();

    //调用获取相似简历
    getXSJL();

    //显示匹配到多少靠普人才
    countKPJL();

    //调用获取靠普简历
    getKPJL();
});

//提示placeholder设置
function placeholder() {
    var elPlaceHolder = $('input[placeholder]');
    elPlaceHolder.each(function () {
        var el = $(this);
        var valPlaceHolder = el.attr('placeholder');
        if ($.trim(el.val()) == "" || $.trim(el.val()) == valPlaceHolder) {
            el.val(valPlaceHolder).css("color", "#999");
        }
        el.blur(function () {
            if ($.trim(el.val()) == "" || el.val() == valPlaceHolder) {
                el.val(valPlaceHolder).css("color", "#999");
            }
        }).focus(function () {
            if ($.trim(el.val()) == valPlaceHolder) {
                el.val('');
            }
            el.css("color", "#333");
        });
    });
}

//相似简历数
var xsjlCount = 0;

//获取相似简历信息
function getXSJL() {
	//有职位的情况下不取相似简历
    if($('#PositionNumber').val().length>0){
		return;
	}

    var resumeID = $("#resume_id").val();
    var extID = $("#extId").val();
    var version = $("#resume_version").val();
    var source = $("#viewSource").val();
    var userId = $("#resumeUserId").val();
    var company_name = $("#currentCompanyName").val();
    var company_id = $("#dda_companyid").val();
    var rootcompany_id = $("#rootCompanyId").val();
    var simlarresume = 2;
    if (resumeID && extID) {

        $.ajax({
            type: "POST",
            url: "/resumepreview/resume/GetXSResume?resumenumber=" + extID + "&limit=7&CompanyId=" + rootcompany_id + "&DepartmentId=" + company_id + "&UserId=" + userId + "&sexclusivecompany=" + encodeURIComponent(company_name),
            dataType: 'json',
            success: function (data) {
                if (data == null || data == "" || data.numFound == 0) {
                    return;
                }
                var resumeSource = GetQueryString("searchresume");
                var resumeview = GetQueryString("resumeviewfrom");
                var resumeviewfrom = 0;
                var line = "";
                var resumeViewNumbers = [];
                $.each(data.results, function (i, l) {
                    line += "<tr valign='top'>";
                    if (resumeSource) {
                        resumeviewfrom = 1;
                    } else {
                        if (resumeview) {
                            resumeviewfrom = resumeview;
                        } else {
                            resumeviewfrom = 2;
                        }
                    }
                    resumeViewNumbers.push(l.Number);
                    line += "<td><div class='thead-white fc315'><a href='http://rd.zhaopin.com/resumepreview/resume/viewone/2/" + l.Number + "_" + l.Version + "_" + l.Language + "?simlarresume=" + simlarresume + "&resumeviewfrom=" + resumeviewfrom + (l.AuthUrl||"") + "' target='_blank'";
                    line += "title='" + l.Name + "'>"
                    line += (l.Name ? subString(l.Name, 50, true) : "-") + "</a>";
                    line += (l.HavePhoto ? "<img title='有照片' src='http://rd2.zhaopin.com/s/images/erd2/icon_havephoto.gif'></div></td>" : "</div></td>");
                    line += "<td><span title='" + l.JobName + "'>" + (l.JobName ? subString(l.JobName, 40, true) : "-") + "</span></td>";
                    line += "<td>" + (l.Education ? l.Education : "-") + "</td>";
                    line += "<td>" + (l.Sex ? l.Sex : "-") + "</td>";
                    line += "<td>" + (l.Age ? l.Age : "-") + "</td>";
                    line += "<td>" + (l.DesiredSalary ? l.DesiredSalary.replace("元/月", "") : "-") + "</td>";
                    line += "<td>" + (l.Status ? l.Status : "-") + "</td>";
                    line += "<td><span title='" + l.CurrentCity + "'>" + (l.CurrentCity ? subString(l.CurrentCity, 12, true) : "-") + "</span></td>";
                    line += "<td class='similar-td-padding'>" + (l.DateModifed ? l.DateModifed : "-") + "</td></tr>";
                });
                $("#sr_tobdy").html(line);
                $("#sr_tobdy tr:last").addClass("last-bottom");
                $("#smilarresume").show();
                //相似简历曝光度
                //简历曝光统计
                var resumeViewNumbersStr = resumeViewNumbers.join(",");
                if (resumeViewNumbersStr.length > 0) {
                    if (resumeSource) {
                        resumeSource = "rdsearchsource";
                    } else {
                        if (resumeview) {
                            if (resumeview == 1) {
                                resumeSource = "rdsearchsource";
                            } else if (resumeview == 2) {
                                resumeSource = "rdinboxsource";
                            }
                        } else {
                            resumeSource = "rdinboxsource";
                        }
                    }
                    dyweTrackEventExpo(resumeSource, 'expo', resumeViewNumbersStr);
                }

                function dyweTrackEventExpo(category, action, ids) {

                    function ed(d, a) {
                        var c = encodeURIComponent;
                        return c instanceof Function ? (a ? encodeURI(d) : c(d)) : escape(d);
                    }

                    var i = new Image(1, 1);
                    var e = document.location;
                    i.src = "http://l.zhaopin.com/track.gif?dywee=5(" + category + "*"
                        + action + ")&dywehn=" + ed(e.hostname) + "&expo=" + ids;
                }

                var xsjlCount = data.numFound;
                if (xsjlCount > 7) {
                    xsjlCount = 7;
                }
                if (xsjlCount > 7) {
                    var resumeName = encodeURIComponent($("input[name ='resume_Name']").val());
                    $("#sr_all").html("查看全部").attr("href", "http://rdsearch.zhaopin.com/similarresume/seemore?resumeID=" + $("#resume_id").val() + "&resumeName=" + resumeName);
                } else {
                    $("#sr_all").remove();
                }
                setXSJLCount(xsjlCount);
            },
            error: function () {
                setXSJLCount(xsjlCount);
            }
        });
    }

    function GetQueryString(name) {

        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");

        var r = window.location.search.substr(1).match(reg);

        if (r != null) return unescape(r[2]);
        return null;

    }

    function subString(str, len, hasDot) {
        var newLength = 0;
        var newStr = "";
        var chineseRegex = /[^\x00-\xff]/g;
        var singleChar = "";
        var strLength = str.replace(chineseRegex, "**").length;
        for (var i = 0; i < strLength; i++) {
            singleChar = str.charAt(i).toString();
            if (singleChar.match(chineseRegex) != null) {
                newLength += 2;
            } else {
                newLength++;
            }
            if (newLength > len) {
                break;
            }
            newStr += singleChar;
        }

        if (hasDot && strLength > len) {
            newStr += "...";
        }
        return newStr;
    }

}

//显示匹配到多少靠普人才
function countKPJL() {
    if ($('#dgt_bar').is(':visible')) {
        var posi = $('#PositionNumber').val();
        if (!posi || posi.length == 0) {
            return;
        }
        $.ajax({
            url: 'http://jobads.zhaopin.com/Position/RecommendResumes4PositionCount',
            type: 'get',
            data: 'positionNumber=' + posi,
            contentType: "application/json; charset=utf-8",
            dataType: 'jsonp',
            jsonp: 'jsonp',
            success: function (rlt) {
                if (rlt && Number(rlt) > 0) {
                    $('em', '#kp_num').text(rlt);
                    $('#kp_num').show();
                }
            },
            error: function (a, b, c) {
            }
        });
    }
}

//获取靠谱简历
function getKPJL() {
    var posi = $('#PositionNumber').val();
    if (!posi || posi.length == 0) {
        return;
    }
    $.ajax({
        url: 'http://jobads.zhaopin.com/Position/RecommendResumes4PositionV2',
        type: 'get',
        data: 'positionNumber=' + posi,
        contentType: "application/json; charset=utf-8",
        dataType: 'jsonp',
        jsonp: 'jsonp',
        success: function (rlt) {
            outputKPJL(posi, rlt);
        },
        error: function (a, b, c) {
        }
    });
}

function outputKPJL(posi, lst) {
    var clean = function (str) {
        return str && str.replace(/[\'\"\>\<(&lt;)(&gt;)]*/g, '');
    };
    if (lst && lst.length > 0) {
        var currExtId = $('#extId').val();
        var html = [];
        var extIds = [];
        var n = 4;
        html.push('<div class="recomList">');
        for (var i = 0; i < lst.length && i < n; i++) {
            var item = lst[i];
            if (item.ResumeNumber == currExtId) {
                n += 1;
                continue;
            }
            extIds.push(item.ResumeNumber);
            html.push('<dl><dt>');
            html.push('<img width="74" height="106" src="' + (item.ImageUrl ? item.ImageUrl : /*genderYN(item)*/item.Gender == '男' ? 'http://img01.zhaopin.cn/2014/rd2/img/personRecom02.jpg' : 'http://img01.zhaopin.cn/2014/rd2/img/personRecom01.jpg') + '"/></dt>');
            html.push('<dd><p class="new_Olive_p" title="' + clean(item.UserName) + '"><a href="http://rd.zhaopin.com/resumepreview/resume/viewone/4/1_' + posi + '_' + item.ResumeNumber + '" target="_blank" class="__ga__JobInviteLU_clickSentInvite$CV_001">' + clean(item.LatestJobName) + '</a>');

            html.push('</p>');
            if (item.Gender) {
                html.push('<span class="gender">' + clean(item.Gender) + '</span>');
            }

            if (item.ResidentCity || item.YearsOfWorking || item.ExpectedJobTypeName) {
                var arr = [];
                if ($.trim(item.ExpectedJobTypeName)) {
                    arr.push('<p class="new_Olive_p col33"><span>' + item.ExpectedJobTypeName + '</span>');
                }
                if ($.trim(item.YearsOfWorking)) {
                    arr.push('<span>' + item.YearsOfWorking + '</span>');
                }

                if ($.trim(item.ResidentCity)) {
                    arr.push('<span title="' + clean(item.ResidentCity) + '">' + cutStr_new(clean(item.ResidentCity), 14) + '</span></p>');
                }
                if (arr.length > 0) {
                    html.push(arr.join(' | '));
                }
            }
            if (item.LatestCompanyName && item.LatestCompanyName.length > 0) {
                html.push('<p class="new_Olive_p"><span>曾就职于：</span>' + clean(item.LatestCompanyName) + '</p>');
            }
            html.push('<a class="details" href="http://rd.zhaopin.com/resumepreview/resume/viewone/4/1_' + posi + '_' + item.ResumeNumber + '" target="_blank"><i></i>查看简历</a>');
            if (item.BindMobile) {
                html.push('<span class="weixin"><i></i>TA可实时接收微信</span>');
            }
            html.push('<a href="http://rd.zhaopin.com/resumepreview/resume/viewone/4/1_' + posi + '_' + item.ResumeNumber + '" target="_blank" class="invite_btn __ga__JobInviteLU_clickSentInvite$CV_001">发送橄榄枝</a>');

            html.push('</dd></dl>');
        }
        html.push('</div>');
        if (extIds.length > 0) {
            $('.mtChatCon', '#kp_panel').html(html.join(''));
            $('#kp_linkall').attr('href', 'http://jobads.zhaopin.com/Position/RecommendResumes4Position/' + posi + '/');
            $('#kp_panel').show();
            html = null;
        }
        //微信提示框
        $(".weixin i").hover(function () {
            var $msTips = $('<div class="tipsCon"><div class="msTips">TA可实时接收微信消息</div><img src="http://img01.zpin.net.cn/2014/rd2/img/recycle-tips-t.png" alt=""/></div>');
            $(this).parents('.recomList').append($msTips);
            $(".tipsCon").css("top", $(this).position().top + 15);
            $(".tipsCon").css("left", $(this).position().left - 50);
        }, function () {
            $('.tipsCon').remove();
        });
        //曝光统计
        dyweTrackEventExpo('resumeoliveview', 'expo', extIds.join(','));

        //根据数据返回男女的图片地址
        /* function genderYN(item){
 
             if (item.Gender == "男") {
                 return 'http://img01.zhaopin.cn/2014/rd2/img/personRecom02.jpg';
             }else if(item.Gender == "女"){
                 return 'http://img01.zhaopin.cn/2014/rd2/img/personRecom01.jpg';
             }
         }*/
    }
}

function dyweTrackEventExpo(category, action, ids) {
    function ed(d, a) {
        var c = encodeURIComponent;
        return c instanceof Function ? (a ? encodeURI(d) : c(d)) : escape(d);
    }
    var i = new Image(1, 1);
    var e = document.location;
    i.src = "http://l.zhaopin.com/track.gif?dywee=5(" + category + "*" + action + ")&dywehn=" + ed(e.hostname) + "&expo=" + ids;
}

/*截取字符串函数*/
function cutStr_new(str, cutLen) {
    if (!str) {
        return str;
    }
    var strCNLen = str.replace(/[^\x00-\xff]/g, '**').length;
    if (cutLen >= strCNLen) {
        return str;
    }
    var temp = '', returnStr = '', reCN = /[^\x00-\xff]/;
    for (var i = 0, len = 0; len < cutLen; i++) {
        temp = returnStr;
        returnStr += str.charAt(i);
        if (reCN.test(str.charAt(i))) {
            len += 2;
            if (len > cutLen) {
                returnStr = temp;
                break;
            }
        } else {
            len++;
        }
    }
    return returnStr + '...';
}

function setXSJLCount(data) {
    var resumeName = encodeURIComponent($("input[name ='resume_Name']").val());
    $("#xsjl_count").html("相似简历(" + data + ")");
    if (data != 0) {
        $(".previewLayer_xsjl").removeClass("similar-button-gray")
			.addClass("similar-button")
			.attr("href", "http://rdsearch.zhaopin.com/similarresume/seemore?resumeID=" + $("#resume_id").val() + "&resumeName=" + resumeName);
        $(".preview-icon_xsjl").removeClass("preview-icon-similar-gray").addClass("preview-icon-similar");
        $("#xsjl_count").addClass("similar-decoration");
    }
}

function highlight(id, kw) {
    var el = typeof id === "string" ? $(id)[0] : id;
    var html = "";
    kw = kw.replace(/[<>]/g, "");
    kw = $.trim(kw);
    if (el && typeof el === "object" && kw) {
        html = el.innerHTML;
        html = html.replace(/(&[a-zA-Z]*?;)/g, "<$1>");
        html = html.replace(/<&amp;>/g, "&amp;");
        html = replaceKeyWord(html, kw);
        html = html.replace(/<(&[a-zA-Z]*?;)>/g, "$1");
        el.innerHTML = html;
    }
    // 特殊字符替换
    function replaceSpecialChar(kw) {
        var sc = {
            "\\\\": "\\\\",
            "\\+": "\\\+",
            "\\*": "\\\*",
            "\\?": "\\\?",
            "\\^": "\\\^",
            "\\$": "\\\$",
            "\\.": "\\\.",
            "\\{": "\\\{",
            "\\}": "\\\}",
            "\\[": "\\\[",
            "\\]": "\\\]",
            "\\(": "\\\(",
            "\\)": "\\\)",
            "\\|": "\\\|",
            "\\/": "\\\/"
        };
        for (var key in sc) {
            if (sc.hasOwnProperty(key)) {
                kw = kw.replace(new RegExp(key, "gi"), sc[key]);
            }
        }

        var amp = "&amp;";
        if (amp.indexOf(kw) != -1) {
            kw = "";
        }

        return kw;
    }
    // 关键词替换
    function replaceKeyWord(html, kw) {
        var keys = kw.split(/\s+/), keyword = "";
        // 多关键词按长度由大到小排序
        keys.sort(function (a, b) {
            return b.length - a.length;
        });

        for (var i = 0; i < keys.length; i += 1) {
            keyword = keys[i];
            keyword = replaceSpecialChar(keyword);
            if (keyword !== "") {
                html = html.replace(new RegExp('(^|<[^>]*?>)([^<]*?(' + keyword + ')[^>]*?)(?=<|$)', "gi"), function (a, b, c, d) {
                    return b === '<span class="keyword-highlight">' ? a : b + c.replace(new RegExp(keyword, "gi"), '<span class="keyword-highlight">' + d + '</span>');
                });
            }
        }
        return html;
    }
}

//失败提示框
function showCenter(obj) {
    var _top = $(window).height() / 2 - obj.height() / 2;
    _left = $(window).width() / 2 - obj.width() / 2;
    if ($.browser.msie && $.browser.version === "6.0") {
        _top += $(document).scrollTop();
        _left += $(document).scrollLeft();
        obj.css("position", "absolute");
    }
    obj.css({ "left": _left + "px", "top": _top - 100 + "px" });
}

//您可能对一下简历感兴趣
$(".center-right").live("click", function () {
    $.popupDiv({
        title: "您可能对一下简历感兴趣", url: "interestLayer.html", buttons: {
            "关 闭": function () {
                $.popupClose();
            }
        }, width: 560
    });
    return false;
});

//添加标签
$(".tips-id-color,#tagClassHeader,.previewLayer14").live("click", function () {
    var guid = $("#guid").val();
    $.popupDiv({ title: "添加标签", url: "/resumepreview/resume/addtag/" + guid, width: 420 });
    return false;
});

//管理标签
$(".editor-layer-list-weight", $('#divPopup')).live("click", function () {
    var guid = $("#guid").val();
    $.popupDiv({
        title: "编辑标签", url: "/resumepreview/resume/tagmanage/" + guid + "?t=" + (new Date()).getTime(), width: 420, buttons: {
            "确 定": function () {
                if (!validateTag()) {
                    return false;
                }

                $("#frmTagManage").submit();
            }
        }
    });
    return false;
});

//更改标签样式
$(".editor-layer-list-weightadd", $('#divPopup')).live("click", function () {
    var length = $("input[id^='isDeleted'][value='False']").length;
    if (length < 10) {
        var count = parseInt($("#labelCount").val());
        var arrary = [];
        arrary.push("<div class=\"editor-layer-list\" id=\"labelItem" + count + "\">");
        arrary.push(" <div class=\"editor-layer-input\"><input name=\"[" + count + "].LabelText\" type=\"text\" value=\"\" class=\"editor-layer-error\" id=\"labelName" + count + "\"></div>");
        arrary.push(" <div class=\"editor-layer-icon cvLabelColor" + ((length % 12) + 1) + "\" id=\"classItem" + count + "\"></div>");
        arrary.push(" <div class=\"editor-layer-name\"><a href=\"javascript:void(0)\" class=\"dev_change_class\" dev_index=\"" + count + "\" id=\"changeClass" + count + "\">改颜色</a></div>");
        arrary.push(" <div class=\"editor-layer-coles\" dev_index=\"" + count + "\"></div>");
        arrary.push(" <input data-val=\"true\" name=\"[" + count + "].LabelId\" type=\"hidden\" value=\"\">");
        arrary.push(" <input id=\"selectedClass" + count + "\" name=\"[" + count + "].LabelClass\" type=\"hidden\" value=\"cvLabelColor1\">");
        arrary.push(" <input data-val=\"true\" id=\"isDeleted" + count + "\" name=\"[" + count + "].IsDeleted\" type=\"hidden\" value=\"False\">");
        arrary.push("</div>");
        $("#labelList").append(arrary.join(""));

        zlzp.App.showInfo($("#changeClass" + count, $('#divPopup')), $(".editor-layer-add"), false, function (el) {
            var _top = $(el).offset().top, _left = $(el).offset().left;
            $(".editor-layer-add").css({ "z-index": "9999", "left": _left + "px", "top": _top + 20 + "px" }).show();

            var index = $(el).attr("dev_index");

            $(".dev_label_icon_list").die().live("click", function () {
                var className = $(this).attr("dev_className");
                $("#classItem" + index).removeClass();
                $("#classItem" + index).addClass("editor-layer-icon");
                $("#classItem" + index).addClass(className);
                $("#selectedClass" + index).val(className);
                $(".editor-layer-add").hide();
            });

            return false;
        });

        $("#labelCount").val(count + 1);
        var count = 10 - (length + 1);
        if (count > 0) {
            $("#canAddTag").text("【您还可以创建" + count + "个标签】");
            $("#addNewTag").show();
        }
        else {
            $("#canAddTag").text("【您不能再添加标签了】");
            $("#addNewTag").hide();
        }
    }

    return false;
});


//删除标签
$(".editor-layer-coles", $('#divPopup')).live("click", function () {
    if (confirm("所有使用了该标签的简历将变为无标签状态，确定删除吗？") == true) {
        var index = $(this).attr("dev_index");
        $("#labelItem" + index).hide();
        $("#isDeleted" + index).val("True");
        var error = $("#labelItem" + index).next();
        if (error.hasClass("tip-x-validate-error")) {
            error.hide();
        }

        var length = $("input[id^='isDeleted'][value='False']").length;
        var count = 10 - length;
        if (count > 0) {
            $("#canAddTag").text("【您还可以创建" + count + "个标签】");
            $("#addNewTag").show();
        } else {
            $("#canAddTag").text("【您不能再添加标签了】");
            $("#addNewTag").hide();
        }
    }
});

//语言切换操作
$("#changeLanguage").live("click", function () {
    var tmp = $("#language").val();
    $("#changeLanguageImg").show();
    $("#language").val($("#anotherLanguage").val());
    $("#anotherLanguage").val(tmp);

    var gltype = $("#gltype").val();
    var PositionNumber = $("#PositionNumber").val();
    var resume_id = $("#resume_id").val();

    var actionUrl = "http://rd.zhaopin.com/resumepreview/resume/_detail?extId=" + $("#extId").val() + "&version=" + $("#resume_version").val() + "&language=" + $("#language").val(),
        positionId = $('#positionid').val();
    if (positionId) {
        actionUrl += '&positionId=' + positionId;
    }
    actionUrl += '&gltype=' + gltype + '&PositionNumber=' + PositionNumber + '&ResumeId=' + resume_id;
    /* $("#frmResumeDetail").attr("action", actionUrl).submit();*/
    $("#frmResumeDetail").submit();
    return false;
});

function changeLanguageTag() {
    var language = $("#language").val();
    if (language == "Chinese") {
        $("#changeLanguage").text("英文简历");
    } else {
        $("#changeLanguage").text("中文简历");
    }

    $regEventDomReady(initResuadmiModule);
    // 关键词高亮功能  
    var key = $('input[name=keyword_search]').val() || '';
    var keyCollege = $('input[name=college_search]').val() || '';
    var keyCompany = $('input[name=company_search]').val() || '';
    key = $.trim(key);
    keyCollege = $.trim(keyCollege);
    keyCompany = $.trim(keyCompany);
    highlight("#resumeContentHead", key);
    highlight("#resumeContentBody", key);
    highlight(".educationContent", keyCollege);
    highlight(".workExperience", keyCompany);
    $("#changeLanguageImg").hide();
    setXSJLCount();
}

function saveTagChangesComplete(data) {
    $.popupClose();

    var guid = $("#guid").val();
    $.popupDiv({ title: "添加标签", url: "/resumepreview/resume/addtag/" + guid, width: 420 });
}

function saveTagSuccess(data) {
    if (data.deletedCurrentTag) {
        $("#addTagHeader").text("添加标签");
        $("#tagClassHeader").removeClass();
        $("#tagClassHeader").addClass("editor-layer-icon");
        $("#tagClassHeader").addClass("check");
        $("#deleteTagHeader").hide();
    } else {
        $("#addTagHeader").text(data.text);
        $("#tagClassHeader").removeClass();
        $("#tagClassHeader").addClass("editor-layer-icon");
        $("#tagClassHeader").addClass(data.className);
    }
}

//您可能对一下简历感兴趣
$(".dev_select_tag", $('#divPopup')).live("click", function () {
    var params = $(this).attr("dev_params").split(" , ");
    if (params != null && params.length == 4) {
        $.ajax({
            type: "get",
            url: "/resumepreview/resume/AddResumeTag?guid=" + params[0] + "&label=" + params[1],
            beforeSend: function (XMLHttpRequest) {
                //ShowLoading();
            },
            success: function (data, textStatus) {
                if (data == "True") {
                    $("#deleteTagHeader").show();
                    $("#addTagHeader").text(params[3]);
                    $("#tagClassHeader").removeClass();
                    $("#tagClassHeader").addClass("editor-layer-icon");
                    $("#tagClassHeader").addClass(params[2]);
                } else {
                    ShowMsg("265", "标签添加失败");
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
                //HideLoading();
                $.popupClose();
            },
            error: function () {
                //请求出错处理
            }
        });
    }

    return false;
});

$(".check-close").live("click", function () {
    var guid = $(this).attr("dev_guid");
    $("#addTagHeader").text("添加标签");
    $("#tagClassHeader").removeClass();
    $("#tagClassHeader").addClass("editor-layer-icon");
    $("#tagClassHeader").addClass("check");
    $("#deleteTagHeader").hide();
    $.ajax({
        type: "get",
        url: "/resumepreview/resume/DeleteResumeTag/" + guid
    });

    return false;
});

function currentResumeChanged() {
    var currentResume = $(".nav-body-current");
    currentResume.find("#loadingResume").hide();
    setTimeout(function () {
        // 关键词高亮功能  
        var key = $('input[name=keyword_search]').val() || '';
        var keyCollege = $('input[name=college_search]').val() || '';
        var keyCompany = $('input[name=company_search]').val() || '';
        key = $.trim(key);
        keyCollege = $.trim(keyCollege);
        keyCompany = $.trim(keyCompany);
        highlight("#resumeContentHead", key);
        highlight("#resumeContentBody", key);
        highlight(".educationContent", keyCollege);
        highlight(".workExperience", keyCompany);
        $.getScript("http://img01.zhaopin.cn/2012/js/rd/fnresuadmi.js");
    }, 0);
    //调用获取相似简历
    getXSJL();
    //调用靠谱简历
    getKPJL();
    //将列表list的位置存入
    var val = $(".nav-body-main-hidden ul").css("margin-left");
    $("#listPosition").val(val);

    //SMP监控
    smppv.pageView();
    smppv.btnReBind();
}

function validateTag() {
    var flag = true;
    var count = parseInt($("#labelCount").val());
    for (var i = 0; i < count; i++) {
        var textbox = $("#labelName" + i);
        if ($("#isDeleted" + i).val() == "False" &&
            textbox.val() == "") {
            createErrTag(textbox, "请填写标签名称", 2, textbox);
            flag = false;
        }
    }

    return flag;
}
var jobNumber = $(".resume-left-tips-id").html();
//#region 移到暂存夹
$(".previewLayer12").live("click", function () {
    var select_unique_id = GetSelect_unique_id();
    $.popupDiv({
        title: "移到暂存夹", url: "/resumePreview/resume/MoveToTempFavorite?select_unique_id=" + select_unique_id, buttons: {
            "确 定": function () {
                var favorite_id = $('#favorites').val();
                var favorite_name = $('#favorites').find("option:selected").text();
                var str_ext_id = GetExtId();
                var version = Getresume_version();
                myAjax({
                    type: "POST",
                    url: "/resumePreview/resume/_MoveToTempFavorite?str_ext_id=" + str_ext_id + "&favorite_name=" + favorite_id + "&versionNumber=" + version,
                    dataType: 'json',
                    success: function (data) {
                        if (data.isOk == true) {
                            $.popupClose();
                            ShowMsg("265", "简历已保存到“<span>" + favorite_name + "</span>”");
                        }
                        else {
                            $.popupClose();
                            ShowMsg("265", data.Msg);
                        }
                    },
                    error: function (data) {
                        $.popupClose();
                        ShowMsg("265", "简历保存失败");
                    }
                });

            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 520
    });
    return false;
});
//#endregion

//#region 添加评语
//添加评语
$(".previewLayer9").live("click", function () {
    $.popupDiv({ title: "评语", url: "/resumePreview/resume/AddComment", width: 520 });
    return false;
});
$("#firm-btn", $('#divPopup')).live("click", function () {
    var flag = true;
    var jobt = $(".textarea-content");
    if (jobt.val() === "") {
        flag = false;
        createErrTag(jobt, "请填写评语内容", 2, $(".textarea-content"));
        return false;
    }

    var select_unique_id = GetSelect_unique_id();
    var content = $('.textarea-content').val();
    var extId = $("#extId").val();
    var version = $("#resume_version").val();
    var urlParams = "content=" + content + "&unique_id=" + select_unique_id;
    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_AddComment?content=" + encodeURIComponent(content) + "&unique_id=" + select_unique_id,
        dataType: 'json',
        success: function (msg) {
            if (msg.isTrue == true) {
                $.popupClose();
                ShowMsg("265", "发布成功");
                $.ajax({
                    type: "GET",
                    url: "/resumePreview/resume/_ResumeComments?extId=" + extId + "&version=" + version,
                    success: function (html) {
                        $("#commentBlock").html(html);
                    }
                });
            }
            else {
                ShowMsg("300", msg.msg);
            }
        }
    });
    return false;
})
$('.popupCancelBtn', $('#divPopup')).live('click', function () {
    $('#textarea-error').val('');
    $(".count").text('0');
})
//当鼠标放开的时候事件
$(".textarea-content", $('#divPopup')).live("keyup", function () {
    //定义对象
    var area = $(this);
    //定义字数长度，要进行转换，为了将所有类型的字符都按照一种执行
    var length = parseInt(area.val().length, 10);
    //将输入文本的长度数值赋给字数
    $(".count").text(length);
    //当大于250个字数时操作
    if (length > 250) {
        $(".count").text("您已经超过" + (length - 250));
        //按钮变化样式
        $(".popupConfirmBtn").removeClass("popupConfirmBtn").addClass("popupConfirmBtnGray");
    } else if (length <= 250) {
        //可点击时按钮样式
        $(".popupConfirmBtnGray").removeClass("popupConfirmBtnGray").addClass("popupConfirmBtn");
    }
});

//#endregion

//#region 转发简历相关
$(".previewLayer2").live("click", function () {
    var emailFlag = true;
    var emailInput, emailTitle, emailBody;
    var eValid, etValid;
    var errClass = "tip-x-validate-error";
    var count = 0, timer = null;
    var encode = function (str) {
        return encodeURIComponent ? encodeURIComponent(str) : escape(str);
    };
    // 更新邮箱数量
    var upCount = function () {
        emailFlag = true;
        if (count < 4) {
            eValid.html('可添加<span>' + (3 - count) + '</span>个邮箱，多邮件地址用";"分割').removeClass(errClass);
        } else {
            eValid.html('邮件超过3个，无法转发').addClass(errClass);
            emailFlag = false;
        }
    };
    // 进行邮箱输入验证
    var validate = function () {
        var i = 0;
        var txt = emailInput.val() || "";
        var emails = txt.split(";");
        emailFlag = true;
        count = 0
        if (!$.trim(txt.replace(/[;]/g, ''))) {
            eValid.html('请输入邮件地址').addClass(errClass);
            emailFlag = false;
            return;
        }
        count = emails.length;
        for (; i < emails.length; i++) {
            if (emails[i]) {
                if (emails[i].indexOf("@") !== emails[i].lastIndexOf("@")) {
                    eValid.html('多邮件请用";"分隔').addClass(errClass);
                    emailFlag = false;
                } else if (!/^[\w-.]+@([\w-]+\.)+[a-zA-Z]+$/i.test(emails[i])) {
                    eValid.html('邮箱格式有误').addClass(errClass);
                    emailFlag = false;
                }
            } else {
                count -= 1;
            }
        }
        if (emailFlag || count > 3) {
            upCount();
        }
    };

    var args = "";
    args = args + "language=" + $("#resume_language").val();

    var userName = $("#userName");
    if (userName.length > 0) {
        args = args + "&userName=" + encodeURIComponent(userName.text());
    }

    var resumeName = $("#resumeName");
    if (resumeName.length > 0) {
        args = args + "&resumeName=" + encodeURIComponent(resumeName.text());
    }

    $.popupDiv({
        title: "转发简历", url: "/resumePreview/resume/SendResumeToEmail?" + args, buttons: {
            "确 定": function () {
                var flag = true;
                var eVal = $.trim(emailInput.val());
                if (eVal) {
                    validate();
                    flag = emailFlag;
                } else {
                    flag = false;
                    eValid.html('请输入邮件地址').addClass(errClass);
                }
                var etVal = emailTitle.val();
                if (!$.trim(etVal)) {
                    flag = false;
                    etValid.html('请填写邮件标题').addClass(errClass);
                }
                var ebVal = emailBody.val();
                if (ebVal.length > 200) {
                    flag = false;
                }
                var select_unique_id = GetSelect_unique_id();
                var format = $('input[name="forwardingFormat"]:checked').val();
                var extId = $("#extId").val();
                var resumeVersion = $("#resume_version").val();
                var language = GetLanguage();
                var userName = encodeURIComponent($("#userName").text());
                var resumeName = encodeURIComponent($("#resumeName").text());
                var jobTitle = encodeURIComponent($("#JobTitle").text());

                var glstatus = $("#GlStatus").val();
                var jobnumber = $("#PositionNumber").val();


                var data = "extId=" + extId + "&version=" + resumeVersion + "&" + "&forwardingFormat=" + format + "&emailList=" + eVal + "&emailTitle=" + encode(etVal) + "&emailBody=" + encode(ebVal) + "&guid=" + select_unique_id + "&language=" + language + "&userName=" + userName + "&resumeName=" + resumeName + "&jobTitle=" + jobTitle + "&GLStatus=" + glstatus + "&jobnumber=" + jobnumber;
                if (flag) {
                    eVal = eVal.replace(/;/g, ',');
                    if (eVal.slice(-1) === ',') {
                        eVal = eVal.slice(0, -1);
                    }
                    myAjax({
                        type: "POST",
                        url: "/resumePreview/resume/_SendResumeToEmail",
                        dataType: 'json',
                        data: data,
                        success: function (data) {
                            if (data == true) {
                                ShowMsg("265", "转发邮件成功，请等待邮件到达！");
                                $.popupClose();
                            }
                        },
                        error: function (data) {
                            ShowMsg("265", "转发邮件失败，请联系客服！");
                        }
                    });
                }
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 520,
        success: function () {
            var data = $("#forwardingEmailList").val().split(";");
            emailInput = $("#emailLayer");
            emailTitle = $("#emailtitle");
            emailBody = $("#emailBody");
            eValid = $(".email-count");
            etValid = $("#emailTitle_validate");
            // 邮箱自动完成提示
            emailInput.autocomplete({
                data: data,
                filter: function (data, kw) {
                    kw = kw.slice(kw.lastIndexOf(";") + 1);
                    return kw && data.slice(0, kw.length) === kw;
                },
                select: function (txt, el) {
                    var val = el.val();
                    var pos = val.lastIndexOf(";");
                    txt = val.slice(0, pos + 1) + txt + ";";
                    el.val(txt);
                    clearTimeout(timer);
                    validate();
                }
            }).blur(function () {
                timer = setTimeout(validate, 200);
            }).focus(function () {
                upCount();
            });
            // 邮件标题验证
            emailTitle.focus(function () {
                etValid.html('').removeClass(errClass);
            }).blur(function () {
                if (!$.trim(emailTitle.val())) {
                    etValid.html('请填写邮件标题').addClass(errClass);
                }
            });
            var ebUpLen = function () {
                var num = emailBody.val().length;
                var cTag = emailBody.next("div").find(".release-layer-right");
                if (num > 200) {
                    cTag.html('已超过' + (num - 200) + '字').addClass(errClass);
                } else {
                    cTag.html('可输入<span class="count">' + (200 - num) + '</span>字').removeClass(errClass);
                }
            };
            emailBody.keyup(ebUpLen).bind("paste", function () {
                setTimeout(ebUpLen, 0);
            }).trigger("blur");
        }
    });
    return false;
});

//鼠标放入与移出时颜色的变化
$(".email_send").live("focus", function () {
    $(this).css("color", "#333");
});

$(".email_send").live("blur", function () {
    $(this).css("color", "#777");
});

//转发简历
$(".forwarding-layer-select input", $('#divPopup')).live("click", function () {
    $(".forwarding-down").show().mouseleave(function () {
        if (this != null)
            $(this).hide();
    });
});

/*
描述：删除转发邮箱记录
emailid:邮箱的流水号
*/
function ResumeSendEmailDelete(emailid) {
    $.ajax({
        type: "POST",
        url: "/resumePreview/resume/_ResumeSendEmailDelete?send_email_id=" + emailid,
        dataType: 'json',
        success: function (data) {

        }
    });
}

//删除邮箱
$(".forwarding-email-colse", $('.forwarding-list')).live("click", function () {
    $(this).parent().remove();
});

//#region 删除曾经转发的邮箱
//删除邮箱-需要删除数据库
$(".email-colse-add", $('#divPopup')).live("click", function () {
    var a = confirm("是否确认删除？");
    if (a == true) {
        var email = $(this).attr('email');
        var bool = ResumeSendEmailDelete(email);
        if (bool == true)
            $(this).parent().remove();
    }

    //
});
/*
描述：删除转发邮箱记录
emailid:邮箱的流水号
*/
function ResumeSendEmailDelete(email) {
    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_ResumeSendEmailDelete?email=" + email,
        dataType: 'json',
        success: function (data) {
            if (data == true)
                return true;
        }
    });
}

//#endregion

//#region 推荐职位

//推荐职位
$(".previewLayer4").live("click", function () {
    $.popupDiv({
        title: "推荐职位", url: "/resumePreview/resume/MoveToJob", buttons: {
            "确 定": function () {
                var select_unique_id = GetSelect_unique_id();
                var vacancy = $('#ALLJob').find("option:selected").val() + '|' + GetExtId();
                var jobtitle = $('#ALLJob').find("option:selected").attr('title');
                var partment = $("#ALLDept").find("option:selected").attr('title');
                var urlParams = "select_unique_id=" + select_unique_id + "&vacancy=" + vacancy + "&jobtitle=" + jobtitle + "&partment=" + partment;
                myAjax({
                    type: "POST",
                    url: "/resumePreview/resume/_ResumeToPosition",
                    data: urlParams,
                    dataType: 'json',
                    success: function (msg) {
                        if (msg == true) {
                            $.popupClose();
                            ShowMsg("265", "简历已推荐到<span>" + jobtitle + "</span>", 3000, function () { window.location.reload(true); });
                        } else {
                            $.popupClose();
                            ShowMsg("300", "简历推荐失败，请与客服联系！");
                        }
                    }
                });
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 520,
        success: function () {
            InitAllDept();
        }
    });

    return false;
});
//绑定事件。职位变化按部门
$('.ALLDept').live("change", function () {
    InitJobByDept();
});
$('.importType').live("click", function () {
    InitJobByDept();
})
//加载所有部门
function InitAllDept() {
    $.ajax({
        type: "POST",
        url: "/resumePreview/resume/_GetAllDept",
        dataType: 'json',
        data: "",
        success: function (msg) {
            var temp;
            var html = '';
            var selected = "";

            for (var i = 0; i < msg.length; i++) {
                selected = "";
                temp = msg[i];
                if (temp.IsSelected == true)
                    selected = "selected=\"selected\"";
                html += '<option value="' + temp.CompanyId + '" title=\"' + temp.CompanyName + '\" ' + selected + '>' + temp.CompanyName + '</option>';
            }
            if (html == '')
                html = '<option value="">请选择</option>';

            $('#ALLDept').html(html);
            InitJobByDept();
        }
    });
}
//所有职位
var AllJobInfoList = null;
function InitAllJob(deptid, status) {
    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_GetAllJobInfo",
        dataType: 'json',
        data: "",
        success: function (msg) {
            AllJobInfoList = msg;
            var jobList = GetJobList(deptid, status);
            ShowJobList(jobList);
        }
    });
}
//显示列表
function ShowJobList(joblist) {
    var temp;
    var html = '';
    if (joblist != null) {
        for (var i = 0; i < joblist.length; i++) {
            temp = joblist[i];
            html += '<option value="' + temp.JobId + '|' + temp.CityId + '|' + temp.JobPositionNumber + '" title=\"' + temp.JobTitle + '\">' + temp.JobTitle + '</option>';
        }
    }
    if (html == '')
        html = '<option value="">请选择</option>';
    $('#ALLJob').html(html);
}
//得到职位列表
function GetJobList(deptid, status) {
    var jobInfoList = new Array();
    var jobInfo;

    for (var i = 0; i < AllJobInfoList.length; i++) {
        jobInfo = AllJobInfoList[i];
        if (jobInfo.departmentId + '' == deptid && jobInfo.status + '' == status) {
            jobInfoList.push(jobInfo);
        }
    }
    return jobInfoList;
}
//加载公司下所有职位
function InitJobByDept() {
    var deptid = $('#ALLDept').find("option:selected").val();
    var status = $('input[name="jobStatus"]:checked').val();

    if (AllJobInfoList == null) {
        InitAllJob(deptid, status);
    }
    else {
        var jobList = GetJobList(deptid, status);
        ShowJobList(jobList);
    }
}

//#endregion 

//#region 放入回收站i
$(".previewLayer7").live("click", function () {
    //
    var select_unique_id = GetSelect_unique_id();
    //是否彻底删除
    var isDelete = $(this).attr('isdelete');
    if (isDelete == "1") {
        //彻底删除
        $.popupDiv({
            title: "删除简历", msg: "<div class=\"previewLayer-mag\">是否彻底删除选中的简历？</div>"
            , buttons: {
                "确 定": function () {
                    var urlParams = "need_refresh=6&unique_id=" + select_unique_id + "&favoriteId=-1&resumeNum=" + GetExtId();
                    myAjax({
                        type: "POST",
                        url: "/resumePreview/resume/_SaveResumeMove",
                        data: urlParams,
                        dataType: 'json',
                        success: function (msg) {
                            if (msg == true) {
                                $.popupClose();
                                ShowMsg("265", "简历已删除", 3000, function () { location.reload(); });
                                var thisArgs = $(".nav-body-current").attr("dev_args");
                                var next = $(".nav-body-current").next();
                                var prev = $(".nav-body-current").prev();
                                $(".nav-body-current").remove();
                                if (next.length) {
                                    next.addClass("nav-body-current").removeClass("nav-body-bg");
                                    var args = next.attr("dev_args");
                                } else {
                                    prev.addClass("nav-body-current").removeClass("nav-body-bg");
                                    var args = prev.attr("dev_args");
                                }
                                var source = $("#viewSource").val();
                                var frm = document.getElementById("srListForm");
                                var form = $("#srListForm");
                                if ($("#selectedResumeList").length > 0) {
                                    var selectedResumeListValue = $("#selectedResumeList").val();
                                    var re = new RegExp("[^;]*\\|" + thisArgs + "(;|$)", "gi");
                                    $("#selectedResumeList").val(selectedResumeListValue.replace(re, ""));
                                }
                                if ($("#listPosition").length > 0) {
                                    $('#currentExtId').val(args);
                                    form.submit();
                                }
                            } else {
                                $.popupClose();
                                ShowMsg("265", "简历删除失败，请与客服联系！");
                            }
                        }
                    });
                },
                "取 消": function () {
                    $.popupClose();
                }
            }
            , width: 420
        });
    }
    else {
        //放入回收站
        $.popupDiv({
            title: "放入回收箱", msg: "<div class=\"previewLayer-mag\">回收箱的简历，每 <span>7</span> 天清空一次，是否要继续？</div>"
            , buttons: {
                "确 定": function () {
                    var urlParams = "need_refresh=5&unique_id=" + select_unique_id + "&favoriteId=-1&resumeNum=" + GetExtId();
                    myAjax({
                        type: "POST",
                        url: "/resumePreview/resume/_SaveResumeMove",
                        data: urlParams,
                        dataType: 'json',
                        success: function (msg) {
                            if (msg == true) {
                                $.popupClose();
                                ShowMsg("265", "简历已保存到“<span>回收站</span>”", 3000, function () { location.reload(); });
                                var thisArgs = $(".nav-body-current").attr("dev_args");
                                var next = $(".nav-body-current").next();
                                var prev = $(".nav-body-current").prev();
                                $(".nav-body-current").remove();
                                if (next.length) {
                                    next.addClass("nav-body-current").removeClass("nav-body-bg");
                                    var args = next.attr("dev_args");
                                } else {
                                    prev.addClass("nav-body-current").removeClass("nav-body-bg");
                                    var args = prev.attr("dev_args");
                                }
                                var source = $("#viewSource").val();
                                var frm = document.getElementById("srListForm");
                                var form = $("#srListForm");
                                if ($("#selectedResumeList").length > 0) {
                                    var selectedResumeListValue = $("#selectedResumeList").val();
                                    var re = new RegExp("[^;]*\\|" + thisArgs + "(;|$)", "gi");
                                    $("#selectedResumeList").val(selectedResumeListValue.replace(re, ""));
                                }
                                if ($("#listPosition").length > 0) {
                                    $('#currentExtId').val(args);
                                    form.submit();
                                }
                            } else {
                                $.popupClose();
                                ShowMsg("265", "简历删除失败，请与客服联系！");
                            }
                        }
                    });
                },
                "取 消": function () {
                    $.popupClose();
                }
            }
            , width: 420
        });
    }
    return false;
});
//#endregion

//#region 保存到本地
var fileCount = 0;
$(".previewLayer1").live("click", function () {
    fileCount = 0;
    $.popupDiv({
        title: "保存到我的电脑", url: "/resumePreview/resume/ResumeToLocation", buttons: {
            "下一步": function () {
                //如果html下载：直接下载
                ShowMaskDiv();
                var html = "<div id=\"popupTit\" style=\"cursor: auto; \"><div id=\"popupClose\"><span id=\"downfileclose\">close</span></div><div id=\"popupTitle\">保存到我的电脑</div></div><div id=\"popupCon\"><div id=\"popupInnerCon\"><div class=\"save-layer\"><div class=\"save-layer-body\" style=\"text-align:center;\">简历文件已经准备好，请点击“确定”获取文件！</div></div><div class=\"buttons\"><span class=\"popupConfirmBtn\"><a href=\"#\" target=\"_blank\" style=\"color: #9B0101;width:100%;height:100%;display:inline-block\">确 定</a></span></div></div></div>";
                var paras = [];//url参数
                paras.push('jobseekerid=' + $('#resumeUserId').val());
                paras.push('jobid=' + $('#positionid').val());
                paras.push('issubway=' + !!$('#is_user_subway').size());
                paras.push('guid=' + GetSelect_unique_id());
                paras.push('extId=' + GetExtId());
                paras.push('version=' + Getresume_version());
                paras.push('language=' + GetLanguage());
                paras.push('type=' + $('input[name="importType"]:checked').val());
                paras.push('glstatus=' + ($("#GlStatus").val() || ''));
                paras.push('jobnumber=' + ($("#PositionNumber").val() || ''));
                paras.push('jobtitle=' + encodeURIComponent($("#JobTitle").text()));
                paras.push('username=' + encodeURIComponent($("#userName").text()));
                paras.push('resumename=' + encodeURIComponent($("#resumeName").text()));
                paras.push('companyname=' + encodeURIComponent($("#company_name").text()));
                paras.push('worklocation=' + encodeURIComponent($("#work_localtion").text()));
                paras.push('covernumber=' + ($('#coverInfo').val() || ''));
                var exportUrl = "http://rd.zhaopin.com/resumePreview/resume/_ExportResume?" + paras.join('&');

                $("#myMask").remove();
                var divPopup = $("#divPopup"), downfile = $("#downfile");
                divPopup.html(html);
                downfile.html("").append(divPopup);
                $("a", downfile).attr("href", exportUrl);
                downfile.show();
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 420
    });
    return false;
});
//检查文件是否存在
function OpenResumeZipDownLoad(fileurl) {
    if (fileurl.length > 0) {
        if (fileCount > 2) {
            setTimeout("CheckFileExists('" + fileurl + "')", 3000); //等待15秒后再下载
        } else {
            setTimeout("CheckFileExists('" + fileurl + "')", 2000); //等待15秒后再下载
        }
    }
    else {
        HideMaskDiv();
        ShowMsg("300", '文件保存出错！', 2000);
    }
}
function CheckFileExists(fileurl) {
    var html = "<div id=\"popupTit\" style=\"cursor: auto; \"><div id=\"popupClose\"><span id=\"downfileclose\">close</span></div><div id=\"popupTitle\">保存到我的电脑</div></div><div id=\"popupCon\"><div id=\"popupInnerCon\"><div class=\"save-layer\"><div class=\"save-layer-body\" style=\"text-align:center;\">简历文件已经准备好，请点击“确定”获取文件！</div></div><div class=\"buttons\"><span class=\"popupConfirmBtn\"><a href=\"#\" style=\"color: #9B0101;width:100%;height:100%;display:inline-block\">确 定</a></span></div></div></div>";
    $.ajax({
        type: "POST",
        url: "/resumePreview/resume/_CheckFileExists",
        dataType: 'json',
        data: "fileurl=" + fileurl,
        success: function (data) {
            if (data) {
                fileCount = 0;
                ShowMaskDiv();
                $("#myMask").remove();
                var divPopup = $("#divPopup"), downfile = $("#downfile");
                divPopup.html(html);
                downfile.html("").append(divPopup);
                $("a", downfile).attr("href", fileurl);
                downfile.show();
                return;
            }
            else {
                if (fileCount < 5) {
                    OpenResumeZipDownLoad(fileurl);
                    fileCount++;
                }
                else {
                    CheckFileExistsError();
                }
            }
        }
    });
}
//保存简历到本地，取消事件
$("#popupClose").live('click', function () {
    CloseDownFile();
});
function CloseDownFile() {
    $("#downfile").css("display", "none");
    $("#downfile").html("");
    $.popupClose();
    $("#divMask").css("display", "none");
    HideMaskDiv();
}
$("#downfile .popupConfirmBtn").live("click", function () {
    setTimeout(CloseDownFile, 500);
    return true;
});

function CheckFileExistsError() {
    HideMaskDiv();
    $.popupClose();
    ShowMsg("350", '当前导出任务较多,请稍后在<br /> <span><a href="http://rd2.zhaopin.com/s/report/userEventLog.asp" target="new">控制面板->消息管理->系统消息</a></span>获取下载链接', 3000);
}

function ShowMsgOk() {
    var s = ''
        + '<div id="popupInnerCon">'
        + '    <div class="save-layer">'

        + '        <div class="save-layer-body">'
        + '            <div class="save-layer-main">'
        + '                <div class="save-layer-name">'
        + '                    请选择导出格式：</div>'
        + '            </div>'
        + '        </div>'
        + '    </div>'
        + '    <div class="buttons">'
        + '        <span class="popupConfirmBtn">确 定</span>'
        + '        </div>'
        + '</div>';

    ShowMsg("1000", s, "800000");
    $(".popupConfirmBtn").live("click", function () {
        CloseMsg();
    });

}
//#endregion

//#region 保存到人才储备库
$(".previewLayer6").live("click", function () {
    var select_unique_id = GetSelect_unique_id();
    var urlData = "select_unique_id=" + select_unique_id + "&resumeNum=" + GetExtId();
    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_SaveResumeToStore",
        data: urlData,
        dataType: 'json',
        success: function (msg) {
            if (msg == true) {
                ShowMsg("265", "简历已保存到“<span>人才储存</span>”", 3000, function () { window.location.reload(true); });
            } else {
                ShowMsg("265", "简历保存失败，请与客服联系！");
            }
        }
    });
});
//#endregion

//#region 移到简历夹
$(".previewLayer3").live("click", function () {
    var select_unique_id = GetSelect_unique_id();
    $.popupDiv({
        title: "移到简历夹", url: "/resumePreview/resume/MoveToFavorite?select_unique_id=" + select_unique_id, buttons: {
            "确 定": function () {
                var favorite_id = $('#favorites').val();
                var favorite_name = $('#favorites').find("option:selected").text();
                var urldata = "unique_id=" + select_unique_id + "&need_refresh=5&favoriteId=" + favorite_id + "&resumeNum=" + GetExtId();
                myAjax({
                    type: "POST",
                    url: "/resumePreview/resume/_SaveResumeMove",
                    data: urldata,
                    dataType: 'json',
                    success: function (msg) {
                        if (msg == true) {
                            $.popupClose();
                            ShowMsg("265", "简历已保存到“<span>" + favorite_name + "</span>”", 3000, function () { window.location.reload(true); });
                        } else {
                            $.popupClose();
                            ShowMsg("265", "移到简历夹失败，请与客服联系！");
                        }
                    }
                });
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 420
    });
    return false;
});
//#endregion

//#region 其他

//打印简历
$(".previewLayer8").live("click", function () {
    window.focus();
    window.print();
})
//显示信息
function ShowMsg(width, msg, time, callback) {
    if (time == null)
        time = 2000;

    $(".szmr_overts").css({ 'width': width + 'px' });
    $("#subWindowMain")[0].className = "tanchuang_main";
    $("#subWindowMain").html("<div class=\"szmr_sm\">" + msg + "</div>");
    var szmr = $(".szmr_over");
    //showCenter(szmr);
    $.popupBase.init({
        div: szmr,
        posx: "center",
        posy: "center",
        maskClose: false
    });
    szmr.fadeIn().delay(time).fadeOut();
    setTimeout(function () {
        $.popupBase.close(szmr);
        if (callback && typeof callback == 'function') {
            callback();
        }
    }, time);
}

//显示信息
function ShowMsgEx(width, msg, time) {
    if (time == null)
        time = 2000;

    $(".szmr_overts").css({ 'width': width + 'px' });
    $("#subWindowMain")[0].className = "tanchuang_main_complaints";
    $("#subWindowMain").html("<div class=\"szmr_sm_complaints\">" + msg + "</div>");
    var szmr = $(".szmr_over");
    //showCenter(szmr);
    $.popupBase.init({
        div: szmr,
        posx: "center",
        posy: "center",
        maskClose: false
    });
    szmr.fadeIn().delay(time).fadeOut();
    setTimeout(function () {
        $.popupBase.close(szmr);
    }, time);
}

//关闭消息
function CloseMsg() {
    var szmr = $(".szmr_over");
    $.popupBase.init({
        div: szmr,
        posx: "center",
        posy: "center",
        maskClose: false
    });
    $.popupBase.close(szmr);
}

//得到选择的简历id
function GetSelect_unique_id() {
    return ($('#guid').val() || '');
}
//得到语言类型
function GetLanguage() {
    return ($('#resume_language').val() || '');
}
//得版本号
function Getresume_version() {
    return ($('#resume_version').val() || '');
}
//得到扩展编号
function GetExtId() {
    return ($('#extId').val() || '');
}

//得到简历名称
function GetResumeName() {
    return encodeURIComponent(($("#resume_Name").val() || ''));
}

//#endregion

//#region jQuery方法扩展
var myAjax = function (ajaxObj) {

    //显示遮罩
    ShowMaskDiv();

    //请求
    $.ajax({
        type: ajaxObj.type,
        url: ajaxObj.url,
        dataType: ajaxObj.dataType,
        data: ajaxObj.data,
        success: function (data) {
            //成功处理
            ajaxObj.success(data);
            //隐藏遮罩
            HideMaskDiv();
        },
        error: function (data) {
            //成功处理
            if (data != null && ajaxObj.error != null)
                ajaxObj.error(data);

            //隐藏遮罩
            HideMaskDiv();
        }
    });
}

//显示遮罩层
function ShowMaskDiv() {

    var myMask = document.getElementById("myMask");
    if (myMask != null)
        return;

    var divPopup = $('#divPopup');
    var isHasDivPopup = divPopup.css("width") != undefined && divPopup.css("left") != undefined;

    var imgTop;
    var imgLeft;

    var _scrollWidth = Math.max(document.body.scrollWidth, document.documentElement.scrollWidth);
    var _scrollHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
    if (isHasDivPopup) {
        var divPopupWidth = divPopup.css("width").replace("px", "") - 0;
        var divPopupheight = divPopup.css("height").replace("px", "") - 0;
        var divPopupTop = divPopup.css("top").replace("px", "") - 0;
        var divPopupLeft = divPopup.css("left").replace("px", "") - 0;
        imgTop = divPopupTop + divPopupheight / 2;
        imgLeft = divPopupLeft + divPopupWidth / 2;
    }
    else {
        imgTop = window.screen.height / 2 - 50;
        imgLeft = document.body.clientWidth / 2;
    }

    var myMask = document.getElementById("myMask");
    var isHasMyMask = myMask == null;
    var newMask = isHasMyMask ? document.createElement("div") : myMask;

    newMask.innerHTML = '<img style="position:absolute;top:' + imgTop + 'px;left:' + imgLeft + 'px;" src="http://myimg.zhaopin.com/images/new_v3/ani_ajaxload.gif" />';

    newMask.id = "myMask";
    newMask.style.position = "absolute";
    newMask.style.zIndex = "999999";
    newMask.style.width = _scrollWidth + "px";
    newMask.style.height = _scrollHeight + "px";
    newMask.style.top = "0px";
    newMask.style.left = "0px";
    newMask.style.background = "#000";
    newMask.style.filter = "alpha(opacity=30)";
    newMask.style.opacity = "0.3";

    document.body.appendChild(newMask);


}
function HideMaskDiv() {
    var myMask = document.getElementById("myMask");
    if (myMask != null) {
        document.body.removeChild(myMask);
    }
}
//#endregion

//#region 页面加载
$(function () {
    jobTitleInit();
});
//职位信息添加
function jobTitleInit() {
    var jobtitle = $('#JobTitle').html();
    var userinfo = $('#sendNotify').attr('userinfo_forsend');
    if (jobtitle != '' && userinfo && userinfo.indexOf(jobtitle) == -1) {
        $('#sendNotify').attr('userinfo_forsend', userinfo + jobtitle);
    }
}

//#endregion

//下载简历 by jackson
$(".previewLayer11").live("click", function () {

    //简历下载监控 
    //die for new smp by chris.cai 
    //dyweTrackEvent("resumepreview", "download");

    var extID = $("#extId").val();
    var source = $("#viewSource").val();
    var resumeVersion = $("#resume_version").val();
    var dType = $("#Olive_download_btn").data("dtype");


    var language = GetLanguage(); //简历语言
    var resumeName = GetResumeName(); //简历名称
    if ($("#resumeDownloadNum") == null) {
        PopupDownResume(extID, resumeVersion, language, resumeName, source, dType);
    }
    else {
        var resumeDownloadNum = $("#resumeDownloadNum").val();
        if (resumeDownloadNum != "0") {
            PopupDownResume(extID, resumeVersion, language, resumeName, source, dType);
        }
        else {
            $.popupDiv({
                title: "下载简历", url: "/resumepreview/resume/_Download?extID=" + extID + "&resumeVersion=" + resumeVersion + "&language=" + language + "&dType=" + dType
            });
        }
    }

    return false;
});

function PopupDownResume(extID, resumeVersion, language, resumeName, source, dType) {
    $.popupDiv({
        title: "下载简历", url: "/resumepreview/resume/_Download?extID=" + extID + "&resumeVersion=" + resumeVersion + "&language=" + language + "&dType=" + dType, buttons: {
            "下 载": function () {
                $(this).unbind("click");
                var favoriteID = $("#favorite").val();
                var dType = $(".Olive_download_btn").data("dtype");

                var favoriteName = $("#favorite").find("option:selected").text();

                var postdata = { extID: extID, versionNumber: resumeVersion, favoriteID: favoriteID, resumeName: resumeName, dType: dType };
                myAjax({
                    url: "/resumepreview/resume/DownloadResume",
                    dataType: "json",
                    type: "POST",
                    data: postdata,
                    success: function (data) {
                        if (data.ErrorCode === -10001) {
                            document.location.href = "http://rd2.zhaopin.com/s/loginmgr/login.asp";
                            return false;
                        }

                        $.popupClose();
                        $(".szmr_overts").css({ 'width': '265px' });
                        if (data.ErrorCode === 0) {
                            ShowMsg("265", "<div class=\"szmr_sm\">简历下载至“<span>" + favoriteName + "</span>”</div>", 8000);
                            var form = $("#srListForm");
                            if (form.length > 0) {
                                var frm = document.getElementById("srListForm");
                                //var postUrl = "http://rd.zhaopin.com/resumepreview/resume/viewmany?source=" + source + "&currentExtId=" + extID;//
				var postUrl = "http://rd.zhaopin.com/resumepreview/resume/viewmany" + location.search + "&currentExtId=" + extID;//jianguo
                                if ($("#listPosition").length > 0) {
                                    var listPositionVal = $("#listPosition").val();
                                    postUrl = postUrl + "&listPosition=" + listPositionVal;
                                }

                                frm.action = postUrl;
                                form.submit();
                            } else {
                                setTimeout("document.location.href = location.href", 2000);
                            }
                        }
                        else {
                            ShowMsg("265", "<div class=\"szmr_sm\">" + data.Message + "</div>", 4000);
                        }
                    }
                });
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 420,
        success: function () {
            if ($("#productError").val() === "True") {
                var message = $("#productErrorMessage").val();
                message = message ? message : "";
                var download = $("#IsDownloaded").val();
                var ZLBEnough = $("#IsZLBEnough").val();
                $.popupClose();
                //下载简历时如果需要智联币则先判断如果智联币是否充足，不足就显示充值提示窗口
                if (ZLBEnough == 'False') {
                    $.popupDiv({
                        title: "提示",
                        msg: '<b>下载该简历，将消耗<span style="color:#eb6100;">30个</span>智联币！</b><br><br><span>您智联币余额不足，无法下载，请去充值！</span><br><br>',
                        buttons: {
                            "去充值": function () {
                                window.open('http://e.zhaopin.com/zhilianCurrency/5/getform.do', '_blank');
                            },
                            "取消": function () {
                                $.popupClose();
                            }
                        }
                    });
                    return;
                }
                if (download === "True") {
                    //简历已被下载过
                    $.popupDiv({ title: "下载简历", msg: message, buttons: { "确 定": function () { window.location.reload(); } } });
                } else {
                    ShowMsg("400", "<div class=\"szmr_sm\">" + message + "</div>", 4000);
                }
            }
        }
    });
}

//#region 移到暂存夹
$(".previewLayer10").live("click", function () {
    window.scrollTo(0, 0);
    return false;
});

//余额不足暂存
$("#down-move-to-temp").live("click", function () {
    $.popupClose();
    $(".previewLayer12").click();
});

$('.back-to').live("click", function () {
    window.scroll(0, 0);
});

$(".complaints-resume").live("click", function () {
    $.popupDiv({
        title: "举报该简历", url: "/resumePreview/resume/Complaints_Resume?time=" + new Date().getTime(),
        buttons: {
            "提 交": function () {
                var maxNum = $("#is-complaint-to-limit").val();
                if (maxNum == 'True') {
                    ShowMsg("300", "举报已达上限!");
                    $.popupClose();
                    return;
                }

                var flag = true;
                var jobt = $("#emailBody");
                var comin = $("#complaints-input1");
                var cominp = $("#complaints-input2");
                var cominput = $("#complaints-input3");
                var num = jobt.val().length;
                if (jobt.val() === "") {
                    flag = false;
                    createErrTag(jobt, "请填写举报原因", 2, $("#emailBody"));
                }
                if (comin.val() === "") {
                    flag = false;
                    createErrTag(comin, "请填写联系人", 2, $("#complaints-input1"));
                }
                if (cominp.val() === "") {
                    flag = false;
                    createErrTag(cominp, "请填写电子邮箱", 2, $("#complaints-input2"));
                }
                if (cominput.val() === "") {
                    flag = false;
                    createErrTag(cominput, "请填写联系电话", 2, $("#complaints-input3"));
                }
                if (num > 1000) {
                    flag = false;
                }
                if (flag) {
                    var resumeExtId = $("#extId").val(); //简历扩展编号
                    var resumeVersion = $("#resume_version").val(); //简历版本号
                    var language = $("#resume_language").val(); //简历语言
                    var resumeName = $("#resume_Name").val(); //简历名称
                    var resumeUserId = $("#resumeUserId").val(); //简历用户编号
                    var GUId = $("#guid").val(); //GUID
                    var ajData = "strResume=" + resumeExtId + "_" + resumeVersion + "_" + language + "_" + resumeUserId + "_" + GUId + "&resumeName=" + resumeName + "&Phone=" + cominput.val() + "&Email=" + cominp.val() + "&Contacts=" + comin.val() + "&Content=" + jobt.val();
                    $.ajax({
                        type: "POST",
                        url: "/resumePreview/resume/_Complaints_Resume",
                        data: ajData,
                        dataType: "html",
                        success: function (data) {
                            $.popupClose(); //关闭层
                            switch (data) {
                                case "0":
                                    ShowMsg("300", "举报失败，请刷新页面重试！");
                                    break;
                                case "1":
                                    ShowMsgEx("", "<div class=\"complaints-close\"><div class=\"complaints-close-img\"></div></div><div class=\"complaints-content-add\"><span>举报成功!</span><br />您的举报我们会尽快处理，确认为广告或违规的简历将被列入<br />黑名单。再次感谢您的支持！</div>", 10000);
                                    break;
                                case "2":
                                    ShowMsg("300", "举报失败，请刷新页面重试！");
                                    break;
                                case "3":
                                    ShowMsg("300", "举报已达上限!");
                                    break;
                            }
                        },
                        Error: function () {
                            ShowMsg("300", "举报失败，请刷新页面重试！");
                        }
                    });
                }
            },
            "取 消": function () {
                $.popupClose();
            }
        }, width: 520,
        success: function () {
            var emailBody = $("#emailBody");
            var errClass = "tip-x-validate-error";
            var UserName = $("#resume_Name").val(); //取简历名称
            if (UserName.length > 22) {
                UserName = UserName.substring(0, 22) + "...";
            }
            $(".complaints-resume-name").html(UserName);
            var ebUpLen = function () {
                var num = emailBody.val().length;
                var cTag = emailBody.next(".release-layer-right");
                if (num > 1000) {
                    cTag.html('您已超出' + (num - 1000) + '个字').addClass(errClass);
                } else {
                    cTag.html('还可以输入<span class="count">' + (1000 - num) + '</span>字').removeClass(errClass);
                }
            };
            emailBody.focus(function () {
                var cTag = emailBody.next(".release-layer-right");

                if (emailBody.val() == "此简历为广告或违规简历") {
                    emailBody.val("");
                    var num = emailBody.val().length;
                    cTag.html('还可以输入<span class="count">' + (1000 - num) + '</span>字')
                }
            });
            emailBody.keyup(ebUpLen).bind("paste", function () {  //paste粘贴的文字（监控粘贴事件）
                setTimeout(ebUpLen, 0);
            }).trigger("blur");
        }
    });
    return false;
});

var isSatisfactionFeedback = false;

$("#popupClose").live("click", function () {
    if (isSatisfactionFeedback) {
        satisfactionFeedback();
    }

    isSatisfactionFeedback = false;

    return false;
});

function satisfactionFeedback() {
    var source = $("#viewSource").val();
    var extId = $("#extId").val();
    var version = $("#resume_version").val();
    var comment = encodeURIComponent($("#feedbackComment").val());
    if (comment == "undefined") {
        comment = "";
    }

    var data = "source=" + source + "&extId=" + extId + "&version=" + version + "&type=2&comment=" + comment;

    $.ajax({
        url: "http://rd.zhaopin.com/resumepreview/resume/_similarresumefeedback",
        type: 'POST',
        data: data,
        complete: function (date) {
        }
    });
}

$(".satisfaction-yes").live("click", function () {
    var source = $("#viewSource").val();
    var extId = $("#extId").val();
    var version = $("#resume_version").val();

    $.ajax({
        url: "http://rd.zhaopin.com/resumepreview/resume/_similarresumefeedback?source=" + source + "&extId=" + extId + "&version=" + version + "&type=1",
        type: 'POST',
        complete: function (date) {
            $("#smilarResumeFeedback").html("<div class='satisfaction-span'>感谢您的反馈</div>");
            $(".szmr_overts").css({ 'width': '265px' });
            $(".tanchuang_main").html("<div class=\"szmr_sm\">感谢您的反馈</div>");
            var szmr = $(".szmr_over");
            showCenter(szmr);
            szmr.fadeIn().delay(2000).fadeOut();
            $.popupClose();
        }
    });
    return false;
});

$(".satisfaction-no").live("click", function () {
    isSatisfactionFeedback = true;
    $.popupDiv({
        title: "用户反馈", url: "http://rd.zhaopin.com/resumepreview/resume/satisfactionfeedback", buttons: {
            "确 定": function () {
                var comment = $("#feedbackComment");
                if (comment.val()) {
                    if (comment.val().length > 100) {
                        createErrTag(comment, "意见或者建议长度不能超过100字", 0, comment);
                        return false;
                    }
                }

                satisfactionFeedback();
                $("#smilarResumeFeedback").html("<div class='satisfaction-span'>感谢您的反馈</div>");
                $(".szmr_overts").css({ 'width': '265px' });
                $(".tanchuang_main").html("<div class=\"szmr_sm\">感谢您的反馈</div>");
                var szmr = $(".szmr_over");
                showCenter(szmr);
                szmr.fadeIn().delay(2000).fadeOut();
                $.popupClose();
            }
        }, width: 520
    });
    return false;
});

$("input[name='forwardingFormat']").live("change", function () {
    if ($("input[name='forwardingFormat'][value='word']")[0].checked) {
        $(".forwarding-tips-add").show();
    } else {
        $(".forwarding-tips-add").hide();
    }
});

$("input[name='importType']").live("change", function () {
    if ($("input[name='importType'][value='word']")[0].checked) {
        $(".forwarding-tips-add").show();
    } else {
        $(".forwarding-tips-add").hide();
    }
});

$(".complaints-close-img").live("click", function () {
    CloseMsg();
});

function toTopHide() {
    document.documentElement.scrollTop + document.body.scrollTop > 400 ? $(".back-to").show() : $(".back-to").hide();
}
window.onload = toTopHide;
window.onscroll = toTopHide;
//匹配度弹出层控件Begin
(function ($) {
    jQuery.fn.match = function (options) {
        var _this = this;
        opts = {
            url: "",
            type: "GET",
            data: "",
            callback: "",
            posLeft: ""
        };
        $.extend(opts, options);
        var id = _this.attr("id") || Math.round(Math.random() * 10000);
        var matchWrap = $("#matching-" + id);

        if (!matchWrap.length) {
            //最外层div
            matchWrap = createTag("<div class='matching' id='matching-" + id + "'></div>'");
            //关闭按钮
            var close = createTag('<a href="###" class="close"></a>', matchWrap);
            close.bind("click", function () {
                matchWrap.stop(true, true).fadeOut();
            });
            //提示框上面的小三角
            var tipsIco = createTag('<img src="http://img02.zhaopin.cn/2012/img/rd/top-sharp.png" class="top-sharp"/>', matchWrap);
            var ajaxLoding = createTag('<img src="http://img01.zhaopin.cn/2012/img/rd/loading1202.gif" style="margin:50px 0 40px 250px"/>', matchWrap)
            $.ajax({
                type: opts.type,
                url: opts.url,
                data: opts.data,
                dataType: "jsonp",
                jsonp: opts.callback,
                success: function (msg) {
                    ajaxLoding.hide();
                    var data = msg;
                    var matchTitle = createTag('<div class="matching-name"></div>', matchWrap);
                    var titleName = createTag('<strong class="strong-name"></strong>', matchTitle);
                    var titleMatch = createTag('<span class="matching-degree">匹配度：</span>', matchTitle);
                    var titleMatchStart = createTag('<span class="matching-mark"></span>', matchTitle);
                    var titleMatchexplain = createTag('<div style="display:none" class="matching-explain">因为<a></a>严重不匹配，总匹配程度为0星</div>', matchTitle);
                    //提示信息主要内容
                    var matchContent = createTag('<table cellpadding="0" cellspacing="0" align="center" border="1"  class="tableBig"></table>', matchWrap);
                    var thead = createTag('<thead><tr align="center"><td class="wid82"></td><td class="wid74">匹配度</td><td class="wid224"> 简历信息</td><td class="wid150">职位要求</td></tr></thead>', matchContent);
                    var tbody = createTag('<tbody></tbody>', matchContent);
                    _listDisplay();
                    _publicInfo();
                    //_updatePos();
                    //编辑按钮
                    var edit = createTag('<a class="edit">编辑</a>', matchWrap);
                    //判否条件显示
                    _isJudge();
                    //判否信息提示
                    function _isJudge() {
                        var judeLen = $(".warn", matchWrap).length;
                        if (judeLen > 0) {
                            titleMatchexplain.show();
                            if (judeLen > 1) {
                                $(".matching-explain a", matchWrap).text("多个");
                            } else {
                                var datalist = data['Item'];
                                for (var i = 0; i < datalist.length ; i++) {
                                    var isju = datalist[i].IsJudge;
                                    if (!parseInt(isju)) {
                                        $(".matching-explain a", matchWrap).text(datalist[i].Name);
                                    }
                                }
                                if (!data['Gender'][1]) {
                                    titleMatchexplain.html('因为<a>性别</a>不匹配，总匹配程度为0星');
                                }
                                if (!data['Photo'][1]) {
                                    titleMatchexplain.html('因为没有<a>照片</a>，总匹配程度为0星');
                                }
                                if (!data['DeType'][1]) {
                                    titleMatchexplain.html('因为是<a>委托投递</a>，总匹配程度为0星');
                                }
                            }
                        }
                    }
                    //公告信息部分
                    function _publicInfo() {
                        //姓名
                        titleName.text(data['Name']);
                        //总匹配度
                        var totleMatch = data['Degree'];
                        titleMatchStart.addClass("mark" + totleMatch);
                        //
                    }
                    //列表信息显示
                    function _listDisplay() {
                        var listDtat = data['Item'];
                        for (var i = 0; i < listDtat.length; i++) {
                            //名字信息
                            var thTitle = listDtat[i]['Name'];
                            //总匹配度
                            var star = listDtat[i]['Degree'];
                            //是否是职位或者行业
                            var ifJobOrInd = listDtat[i]['IsJobOrInd'];
                            //简历信息
                            var resumeInfo = listDtat[i]['Resume'];
                            //职位要求
                            var jobRequirements = listDtat[i]['JobRe'];
                            //判否条件
                            var isJudge = listDtat[i]['IsJudge'];
                            var tr = createTag("<tr></tr>", tbody);
                            //判否
                            if (!parseInt(isJudge)) {
                                tr.addClass("warn");
                            }
                            var th = createTag("<th align='center'>" + thTitle + "</th>", tr);
                            var td1 = createTag("<td class='padding16'><a class='star" + star + "'></a></td>", tr);
                            var Main = listDtat[i]['Main'];
                            var othersMsg = listDtat[i]['Other'];
                            if (parseInt(ifJobOrInd)) {
                                var MainTitle = "";
                                var otherTitle = "";
                                if (thTitle === "职位类别") {
                                    MainTitle = "目前职位:";
                                    otherTitle = "其他相关经验:";
                                } else if (thTitle === "行业") {
                                    MainTitle = "目前行业:";
                                    otherTitle = "其他相关经验:";
                                }
                                var td2 = createTag("<td class='padding16'></td>", tr);
                                var MainTitleMsg = "";
                                if (Main !== "") {
                                    if (Main.length > 12) {
                                        MainTitleMsg = Main;
                                        Main = Main.substring(0, 12) + "...";
                                    }
                                    var p1 = createTag('<p class="wid224 ellipsis" id="nowPost" title="' + ((Main.length > 12) ? MainTitle + MainTitleMsg : "") + '">' + MainTitle + Main + '</p>', td2);
                                }
                                var othersMsgs = "";
                                var othersMsgsTitle = "";
                                var jobRequirementsTitle = "";
                                if (othersMsg.length > 1) {
                                    othersMsgs = othersMsg[0] + "、" + othersMsg[1];
                                } else {
                                    othersMsgs = othersMsg[0];
                                }
                                othersMsgsTitle = othersMsgs;
                                if (typeof (othersMsgs) != "undefined" && othersMsgs.length > 24) {
                                    othersMsgs = othersMsgs.substring(0, 24) + "...";
                                }
                                if (othersMsgs !== "") {
                                    var p2 = createTag('<p class="wid224 introduce" id="otherPost" title="' + ((othersMsgs.length > 24) ? otherTitle + othersMsgsTitle : "") + '">' + otherTitle + othersMsgs + '</p>', td2);
                                }
                                if (Main === "" && othersMsgs === "") {
                                    td2.text("-");
                                }
                            } else {
                                var td2 = createTag("<td class='padding16'>" + resumeInfo + "</td>", tr);
                            }
                            if (typeof (jobRequirements) != "undefined" && jobRequirements.length > 26) {
                                jobRequirementsTitle = jobRequirements;
                                jobRequirements = jobRequirements.substring(0, 26) + "...";
                            }
                            var td3 = createTag("<td class='padding16 wid134 padR16' title = '" + jobRequirementsTitle + "'>" + jobRequirements + "</td>", tr);
                        }
                        var others = createTag("<tr></tr>", tbody);
                        var otherstd = createTag('<th align="center">其他</th>', others);
                        var otherstd1 = createTag('<td colspan="3" class="padding6"></td>', others);
                        var othersTable = createTag('<table cellpadding="0" cellspacing="0" border="0"  class="tableSmall"> </table>', otherstd1);
                        var othersTableTr = createTag("<tr></tr>", othersTable);
                        var gender = data['Gender'];
                        var photo = data['Photo'];
                        var deType = data['DeType'];
                        if (gender[1] === "-1" && photo[1] === "-1" && deType[2] === "0") {
                            others.hide();
                        }
                        if (gender[1] > -1) {
                            var tdGender = createTag('<td><div class="gap ' + (gender[1] ? "" : "warn") + '" ><a class="others-gender ' + ((gender[0] === "male") ? "" : " others-genderWomen") + '">' + ((gender[0] === "male") ? "男" : "女") + '</a></div></td>', othersTableTr);
                        }
                        if (photo[1] > -1) {
                            var tdPhoto = createTag('<td><div class="gap ' + (photo[1] ? "" : "warn") + '"><a class="others-photo ' + (photo[0] ? "others-photoBe" : "") + '">' + (photo[0] ? "有照片" : "无照片") + '</a></div></td>', othersTableTr);
                        }
                        if (deType[2] > 0) {
                            var tdDeType = createTag('<td><div class="gap ' + (deType[1] ? "" : "warn") + '"><a class="others-deliver">' + deType[0] + '</a></div></td>', othersTableTr);
                            if (deType[0] === "投递") {
                                $(".others-deliver").attr("title", "求职者发起求职申请，主动投递简历到简历收件箱");
                            } else if (deType[0] === "委托投递") {
                                $(".others-deliver").attr("title", "求职者开放智联委托投递功能，委托智联代投简历，每人每日最多代投10个职位");
                            } else if (deType[0] === "下载") {
                                $(".others-deliver").attr("title", "不是求职者主动求职，是从智联简历库中下载获得的简历");
                            }
                        }
                    }
                }
            });
            //外层div的控制
            matchWrap.css({ "z-index": 9999 });
            $("body").append(matchWrap);
            //提示信息姓名一栏
            //定位弹层

        }
        _updatePos();
        /*$.popupBase.init({
			div : matchWrap,
			maskable:false,
			posx : _this.offset().left - $(document).scrollLeft() - opts.posLeft,
			posy : _this.offset().top - $(document).scrollTop() + _this.outerHeight()+14
		});*/
        $(document).click(function (e) {
            if ($(e.target).closest(matchWrap).length || $(e.target).closest(_this).length) {
                return;
            }
            //$.popupBase.close(matchWrap);
            matchWrap.stop(true, true).fadeOut();
        });
        function _updatePos() {
            var posx = $(document).scrollLeft() + _this.offset().left - $(document).scrollLeft() - opts.posLeft - 18;
            var posy = $(document).scrollTop() + _this.offset().top - $(document).scrollTop() + _this.outerHeight() + 14;
            matchWrap.css({
                "position": "absolute",
                "top": posy + "px",
                "left": posx + "px",
                "display": "block"
            });
        }
        // 生成Tag函数
        function createTag(str, parent) {
            var temp = $(str);
            if (parent) {
                temp.appendTo(parent);
            }
            return temp;
        }
    }
})(jQuery);

//弹出层控件End
