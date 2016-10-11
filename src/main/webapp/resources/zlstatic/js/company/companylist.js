/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";
    //方法扩展
    $.extend({
        getJobDataList: getJobDataList
    });


    function pagination(data) {
        var page_count = data.page_count;
        var page_no = data.page_no;
        //console.info(total);

        //分页-只初始化一次
        $(".Pagination").pagination(page_count * 20, {
            'items_per_page': 20,//pageSize，每页最多显示的记录数
            'num_display_entries': 11,//可见的页码数量. 建议设置为奇数（对称好看些）
            'num_edge_entries': 2,
            'prev_text': "上一页",
            'next_text': "下一页",
            'current_page': page_no - 1,   //当前页索引
            'callback': pageselectCallback
        });
    }

    function getJobDataList(pageIndex) {
        // var pageIndex = 1;

        var jobinfo = {
            "page_no": pageIndex,
            "page_size": "20",
            "job_name": $("#search_input").val(),
            "payroll": $("#yxInput").val(),
            "education_name": $("#xlInput").val(),
            "job_nature_name": $("#gxInput").val(),
            "update_time": $("#stInput").val(),
            "experience_name": $("#gjInput").val(),
            "city_name": $("#cityInput").val(),
            "company_size_name": $("#comInput").val(),
            "company_type_name": $("#xjInput").val()
        };

        //加载热门职位
        $.listCnfwsy(jobs_qr, jobinfo, _succ, _err);
    }

    function _succ(data) {
        showJobList(data);
        pagination(data);

        applyJobX();
    }

    function _err() {
        console.error("fail");
    }

    function pageselectCallback(pageIndex) {
        getJobDataList(pageIndex + 1);
    }

    function showJobList(data) {
        $(".workplace dd").not('.more').children('a').each(function (index, ele) {
            if ($(ele).html() == $("#cityInput").val()) {
                $(this).addClass("current");
                $($(this).parents('dd').siblings()).children('a').removeClass("current");
            }
        });
        /*$(this).addClass("current");
         $($(this).parents('dd').siblings()).children('a').removeClass("current");*/


        var hotPosJoblist = Handlebars.compile($("#hot_pos_joblist-temple").html());

        Handlebars.registerHelper("ifOdd", function (v1, options) {
            if ((v1 % 2) == 0) {
                //满足添加继续执行
                return options.fn(this);
            } else {
                //不满足条件执行{{else}}部分
                return options.inverse(this);
            }
        });
        var hotPosJoblistData = {"hot_pos_joblist": data.items};
        $('#hotPosJoblistResult').html(hotPosJoblist(
            hotPosJoblistData));
    }


    $(function () {

        ///console.info('${labelWords}');
        $("#search_input").val($("#labelWords").val());
        $("#yxInput").val($("#yx").val());
        $("#xlInput").val($("#xl").val());
        $("#gxInput").val($("#gx").val());
        $("#stInput").val($("#st").val());
        $("#gjInput").val($("#gj").val());
        $("#cityInput").val($("#ct").val());
        $("#comInput").val($("#com").val());
        $("#xjInput").val($("#xj").val());

        $(".hotSearch a").each(function (index, ele) {
            $(ele).bind("click", function () {
                window.location = "/entJobList/turnPage?labelWords=" + $(ele).text() + "&ct=" + $("#cityInput").val();
            });

        });

        //加载热门职位
        var isFromIndex = $("#isFromIndex").val();
        if (isFromIndex == 1) {
            getJobDataList(1);
        }

        $(".workplace dd").not('.more').children('a').click(function () {
            $(this).addClass("current");
            $($(this).parents('dd').siblings()).children('a').removeClass("current");
            editForm("cityInput", $(this).html());
        });

        $("#box_expectCity dd span").click(function () {
            //$('#lc').val(1);
            $(".workplace dd").not('.more').children('a').removeClass("current");
            editForm("cityInput", $(this).html());
        });

        $('#options dd div').click(function () {
            var firstName = $(this).parents('dl').children('dt').text();
            var fn = $.trim(firstName);
            $($(this).siblings()).css("background", "");
            //console.info($(this).css("background"));
            if ($(this).attr("flag") == "1") {
                $(this).attr("flag", "2");
                $(this).css("background", "");
                if (fn == "月薪范围") {
                    editForm("yxInput", "");
                }
                else if (fn == "工作年限") {
                    editForm("gjInput", "");
                }
                else if (fn == "最低学历") {
                    editForm("xlInput", "");
                }
                else if (fn == "工作性质") {
                    editForm("gxInput", "");
                }
                else if (fn == "发布时间") {
                    editForm("stInput", "");
                }
                else if (fn == "企业规模") {
                    editForm("comInput", "");
                }
                else if (fn == "企业性质") {
                    editForm("xjInput", "");
                }
                return;
            }
            $(this).css("background", "#23B6D2");
            $(this).attr("flag", "1");
            if (fn == "月薪范围") {

                editForm("yxInput", $(this).html());
            }
            else if (fn == "工作年限") {
                editForm("gjInput", $(this).html());
            }
            else if (fn == "最低学历") {
                editForm("xlInput", $(this).html());
            }
            else if (fn == "工作性质") {
                editForm("gxInput", $(this).html());
            }
            else if (fn == "发布时间") {
                editForm("stInput", $(this).html());
            }
            else if (fn == "企业规模") {
                editForm("comInput", $(this).html());
            }
            else if (fn == "企业性质") {
                editForm("xjInput", $(this).html());
            }
        });

        $('#selected ul').delegate('li span.select_remove', 'click', function (event) {
            var firstName = $(this).parent('li').find('strong').text();
            var fn = $.trim(firstName);
            if (fn == "月薪范围")
                editForm("yxInput", "");
            else if (fn == "工作年限")
                editForm("gjInput", "");
            else if (fn == "最低学历")
                editForm("xlInput", "");
            else if (fn == "工作性质")
                editForm("gxInput", "");
            else if (fn == "发布时间")
                editForm("stInput", "");
            else if (fn == "企业规模")
                editForm("comInput", "");
            else if (fn == "企业性质")
                editForm("xjInput", "");
        });

        /* search结果飘绿	*/
        var searchVal = $('#search_input').val();
        var reg = /\s/g;
        searchVal = searchVal.replace(reg, "").split("");

        var resultL = '';
        var resultR = '';
        $('.hot_pos li').each(function () {
            resultL = $('.hot_pos_l a', this).text().split("");
            $.each(resultL, function (i, v) {
                if ($.inArray(v.toLowerCase(), searchVal) != -1 || $.inArray(v.toUpperCase(), searchVal) != -1) {
                    resultL[i] = '<span>' + v + '</span>';
                }
            });
            $('.hot_pos_l a', this).html(resultL.join(''));

            resultR = $('.hot_pos_r .mb10 a', this).text().split("");
            $.each(resultR, function (i, v) {
                if ($.inArray(v.toLowerCase(), searchVal) != -1 || $.inArray(v.toUpperCase(), searchVal) != -1) {
                    resultR[i] = '<span>' + v + '</span>';
                }
            });
            $('.hot_pos_r .mb10 a', this).html(resultR.join(''));
        });


        //didi tip
        if ($.cookie('didiTip') != 1 && false) {
            $('#tip_didi').show();
        }
        $('#tip_didi a').click(function () {
            $(this).parent().remove();
            $.cookie('didiTip', 1, {expires: 30, path: '/'});
        });

    });

    function editForm(inputId, inputValue) {
        if (inputValue == '全国') {
            inputValue = "";
        }
        if (inputValue == '所有') {
            inputValue = "";
        }
        $("#" + inputId).val(inputValue);
        // var keyword = $.trim($('#search_input').val());
        getJobDataList(1);
    }


    function applyJobX() {
        if ($.isEnt()) {
            $(".apply").css("display", "none");
        } else {
            $(".apply a").bind("click", function () {
                $.applyJob($(this).attr("data-id"), $(this).attr("data2-id"));
                return false;
            })
        }
    }


    /**
     * 申请职位
     */
    function applyJob(jobId, companyId) {
        var applyInfo = {
            job_id: jobId,
            company_id: companyId
        };
        $.addCnfwsy(empJobApply, applyInfo, null, _fail);
    }

    function _fail(msg, code) {
        if (code == $.not_finish_resume) {
            window.location.href = "/jian";
        }
        else {
            window.location.href = "/login.html";
        }
    }

}(jQuery || {}));
