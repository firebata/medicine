/**
 * Created by lindaquan on 16/7/3.
 */
var resume_tpl;
var companyId;
var status;
var pageSize=10;

//页面加载后执行
$(function () {
    //注册一个比较大小的Helper,判断v1是否等于v2
    Handlebars.registerHelper("ifequal", function (v1,v2, options) {
        if (v1==v2) {
            //满足添加继续执行
            return options.fn(this);
        } else {
            //不满足条件执行{{else}}部分
            return options.inverse(this);
        }
    });
    //注册一个比较大小的Helper,判断v1不等于v2
    Handlebars.registerHelper("noequal", function (v1,v2, options) {
        if (v1!=v2) {
            //满足添加继续执行
            return options.fn(this);
        } else {
            //不满足条件执行{{else}}部分
            return options.inverse(this);
        }
    });

    companyId = $("#company_id").val();
    mp.dictsLoad();
    //用jquery获取模板
    resume_tpl  =  $("#resumes_template").html();
    status = eval($("#status").val());
    mp.listLoad(1,status);
    
    $("#re_0").bind("click",function(){mp.listLoad(1,0);return false;});
    $("#re_1").bind("click",function(){mp.listLoad(1,1);return false;});
    $("#re_2").bind("click",function(){mp.listLoad(1,2);return false;});
    $("#re_3").bind("click",function(){mp.listLoad(1,3);return false;});
    $("#re_4").bind("click",function(){mp.listLoad(1,4);return false;});

    $("#filter_btn").bind("click", function () {
        "show" == $(this).attr("class") ? ($("#filterStatus").val(0),
            $(this).removeClass("show").children("em").removeClass("transform"),
            $(".filter_options").slideUp(200).prev(".filter_actions").removeClass("btm")) :
            ($("#filterStatus").val(1),
                $(this).addClass("show").children("em").addClass("transform"),
                $(".filter_options").slideDown(200).prev(".filter_actions").addClass("btm"))
    });
    $(".filter_actions .checkbox input").bind("click", function () {
        return $(this).attr("checked") ? ($(this).removeAttr("checked"), $(this).siblings("i").fadeOut(200), $(".resumeLists li").each(function () {
            $(".checkbox i", this).fadeOut(200), $(".checkbox input", this).removeAttr("checked"), $(".checkbox", this).removeClass("checkhover")
        })) : ($(this).attr("checked", "checked"), $(this).siblings("i").fadeIn(200), $(".resumeLists li").each(function () {
            $(".checkbox i", this).fadeIn(200), $(".checkbox input", this).attr("checked", "checked"), $(".checkbox", this).removeClass("checkhover")
        })), $(this).parent().removeClass("checkhover"), !1
    });
    $(".resumeLists .checkbox input").bind("click", function () {
        if ($(this).attr("checked")) {
            $(this).removeAttr("checked"), $(this).siblings("i").fadeOut(200);
            var a = !1;
            $(".resumeLists li").each(function () {
                $(".checkbox input", this).attr("checked") && (a = !0)
            }), a || $(".filter_actions .checkbox input").removeAttr("checked").siblings("i").fadeOut(200)
        } else $(this).attr("checked", "checked"), $(this).siblings("i").fadeIn(200);
        return $(this).parent().removeClass("checkhover"), !1
    });
    $(".filter_options").on("click", "dd a", function () {
        $(this).text();
        var b = $(this).attr("rel");
        $(this).parent().siblings('input[type="hidden"]').val(b);
        $(this).siblings('input[type="hidden"]').val(b);
        $(this).parent().siblings('a').removeClass();
        $(this).siblings('a').removeClass();
        $(this).siblings('div').children().siblings('a').removeClass();
        $(this).addClass("current");
        mp.listLoad(1,status);
    });
    $("#resumeCrlAll").bind("click",function(){mp.resumeAllUpate(1)});
    $("#resumeNoticeAll").bind("click",function(){mp.resumeAllUpate(2)});
    $("#resumeRefuseAll").bind("click",function(){mp.resumeAllUpate(3)});

});


var mp = {
    dictsLoad : function () {
        $.listCnfwsy(dict_url, {"page_size":20,"page_no":1}, function (data) {

            //工作经历
            var work_year_tpl  =  $("#work_year_template").html();
            var wy_com = Handlebars.compile(work_year_tpl);
            var wy_com_data = {"wy_com":data.items};
            var wy_html = wy_com(wy_com_data);
            $('#wy_lists').html(wy_html);
            //学历
            var edu_tpl  =  $("#edu_template").html();
            var edu_com = Handlebars.compile(edu_tpl);
            var edu_com_data = {"edu_com":data.items};
            var edu_html = edu_com(edu_com_data);
            $('#edu_lists').html(edu_html);

        }, _fail);
    },

    //简历加载
    listLoad : function (no, statusId) {
        status = statusId;
        showConditionAll(statusId);

        $("dd").removeClass("current");
        var stext = '';
        switch (statusId-0){
            case 0:
                stext = '待处理简历';
                $("#re_0").parent().addClass("current");
                break;
            case 1:
                stext = '待定简历';
                $("#re_1").parent().addClass("current");
                break;
            case 2:
                stext = '已通知面试简历';
                $("#re_2").parent().addClass("current");
                break;
            case 3:
                stext = '不合适简历';
                $("#re_3").parent().addClass("current");
                break;
            case 4:
                stext = '自动过滤简历';
                $("#re_4").parent().addClass("current");
                break;
            default:
                return;
        }
        $("#statusName").text(stext);

        var resu={
            'company_id':companyId,
            'status_id':statusId,
            "page_size":pageSize,
            "page_no":no
        };
        var workExp = $("input[name='workExp']").val();
        var eduExp = $("input[name='eduExp']").val();
        if(workExp!='-1'){resu["seniority_id"]=workExp};
        if(eduExp!='-1'){resu["academic_id"]=eduExp};

        $.listCnfwsy(resumel, resu, function (data) {

            $("#recordCount").text(data.all_record_count);
            //预编译模板
            var res_com = Handlebars.compile(resume_tpl);
            //匹配json内容
            var res_com_data = {"res_com":data.items};
            var res_html = res_com(res_com_data);
            //输入模板
            $('.resumeLists').html(res_html);

            $(".resume_caninterview").bind("click",function(){var a,b;
                a=$(this).parents("li").attr("data-id");b=$(this).parents("li").attr("data2-id"); mp.resumeUpate(a,b,1);mp.listLoad(1,statusId);return false;});
            $(".resume_notice").bind("click",function(){var a,b;
                a=$(this).parents("li").attr("data-id");b=$(this).parents("li").attr("data2-id");  mp.resumeUpate(a,b,2);mp.listLoad(1,statusId);return false;});
            $(".resume_refuse").bind("click",function(){var a,b;
                a=$(this).parents("li").attr("data-id");b=$(this).parents("li").attr("data2-id");  mp.resumeUpate(a,b,3);mp.listLoad(1,statusId);return false;});

            $.pagesReolad(no, data, statusId);
        }, _fail);
    },

    //更新
    resumeUpate : function (a,b,value) {
        var re;
        re={
            company_id:companyId,
            employee_id:a,
            job_id:b,
            status_id:value
        };
        $.updateCnfwsy(resumecurd+'/'+a, re, _done, _fail);

    },

    //批量更新
    resumeAllUpate : function (value) {
        var re = new Array;
        $(".resumeLists li").each(function () {
            $(this).find('input[type="checkbox"]').attr("checked") && re.push({company_id:companyId,employee_id:$(this).attr("data-id"),job_id:$(this).attr("data2-id"),status_id:value})});
        $.updateCnfwsy(resumecurd, re, _done, _fail);
        this.listLoad(1,status);
        return false;
    }

}

function _done() {
    $.showmsg("更新成功!");
}

function _fail(rtn_msg) {
    $.showmsg(rtn_msg);
}

function showConditionAll(status) {
    $("#resumeRefuseAll").show();
    $("#resumeCrlAll").show();
    $("#resumeNoticeAll").show();
    if(status==1){
        $("#resumeCrlAll").hide();
    }
    if(status==2){
        $("#resumeNoticeAll").hide();
    }
    if(status==3){
        $("#resumeRefuseAll").hide();
    }
}
