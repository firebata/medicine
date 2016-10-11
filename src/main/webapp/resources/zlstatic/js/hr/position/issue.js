function city_check(a) {
    var b;
    var val = $.infoCnfwsy(checkCity_url + a, {}, function (data) {
        if (data == null) {
            b = false;
        } else {
            b = true;
        }

    }, function () {
        b = false;
    }, null, false), b;
    return b;
}
function getStrLen(a) {
    var c, d, b = 0;
    for (c = 0; c < a.length; c++)d = a.charCodeAt(c), b += isDbcCase(d) ? 1 : 2;
    return b
}
function isDbcCase(a) {
    return a >= 32 && 127 >= a ? !0 : a >= 65377 && 65439 >= a ? !0 : !1
}
$(function () {
    function a(n) {
        $("#jobPreview").attr("disabled","disabled");
        $("#jobPreview").css("background-color","#888080");
        $("#formSubmit").attr("disabled","disabled");
        $("#formSubmit").css("background-color","#888080");
        var a, aId, b, c, d, dId, e, f, g, h, hId, i, iId, j, k, l, o, p, p2, q, r, s;
        var job;
        $("#jobForm").valid() && (
            ("" == $("#salaryMin").val() || $("#salaryMin").val() == $("#salaryMin").attr("placeholder")) && $("#salaryMin").val(""),
            ("" == $("#salaryMax").val() || $("#salaryMax").val() == $("#salaryMax").attr("placeholder")) && $("#salaryMax").val(""),
            $("#jobAddress").val() == $("#jobAddress").attr("placeholder") && $("#jobAddress").val(""),
                a = $("#jobType").val(), aId = $("#jobTypeId").val(), b = $("#jobName").val(), c = $("#quantity").val(),
                d = $.trim($('#jobForm input[name="jobNature"]:checked').parent().text()), dId = $('#jobForm input[name="jobNature"]:checked').val(),
                e = $("#salaryMin").val(), f = $("#salaryMax").val(), g = $("#workAddress").val(),
                h = $("#experience").val(), hId = $("#experienceId").val(),
                i = $("#education").val(), iId = $("#educationId").val(),
                j = $("#jobAdvantage").val(), k = tinyMCE.get("jobDetail").getContent(),
                l = $("#jobAddress").val(), p = $("#forwardEmail").val(), p2 = $("#receiveEmailVal").val(),
                o = $('#jobForm input[name="companyName"]').val(), q = $('#jobForm input[name="jobId"]').val(),
                r = $('#jobForm input[name="companyId"]').val(), s = $("#resubmitToken").val(),
                job = {
                    job_type_name: a,
                    job_type_id: aId,
                    job_name: b,
                    quantity: c,
                    job_nature_id: dId,
                    job_nature_name: d,
                    salary_start: e,
                    salary_end: f,
                    city_name: g,
                    experience_name: h,
                    experience_id: hId,
                    education_id: iId,
                    education_name: i,
                    job_welfare: j,
                    job_desc: k,
                    address: l,
                    job_mail: p,
                    hr_mail: p2,
                    job_id: q,
                    company_id: r,
                    company_name: o,
                    third_kind:'zl',
                    // resubmit_token: s,
                    payroll: e+'k-'+f+'k'
                },
                addjob(n,job)

        )
    }

    $(".profile_radio li input").click(function () {
        $(this).parent("li").siblings("li").removeClass("current"),
            $(this).parent("li").addClass("current"),
            $("#jobForm").validate().element($(this))
    }), $("#salaryMin").focus(function () {
        "" == $.trim($(this).val()) && $(this).prev().text("最低月薪").css({color: "#dddee0"})
    }).blur(function () {
        "" == $.trim($(this).val()) && $(this).prev().text("最低月薪").css({color: "#777"})
    }).keyup(function () {
        $(this).prev().text("")
    }), $("#salaryMax").focus(function () {
        "" == $.trim($(this).val()) && $(this).prev().text("最高月薪").css({color: "#dddee0"})
    }).blur(function () {
        "" == $.trim($(this).val()) && $(this).prev().text("最高月薪").css({color: "#777"})
    }).keyup(function () {
        $(this).prev().text("")
    }), $(document).click(function () {
        $("#box_job").hide(),
        $(".boxUpDown").hide(),
        $(".selectr").removeClass("selectrFocus")
    }), $("#box_job").bind("click", function (a) {
        a.stopPropagation()
    }), $("#box_job").on("mouseenter", ".job_main li", function () {
        $(this).children("ul").show();
        var a = "";
        $("#box_job .job_main").each(function () {
            $(this).children("li").each(function () {
                a = $("#box_job").height() - ($(this).offset().top - $(this).parents("#box_job").offset().top + 32), a < $(this).children(".job_sub").height() && (navigator.userAgent.indexOf("MSIE") > 0 && "7." == navigator.appVersion.match(/7./i) ? $(this).children(".job_sub").css({marginTop: "-30" - $(this).children(".job_sub").height() + "px"}) : $(this).children(".job_sub").css({marginTop: "-44" - $(this).children(".job_sub").height() + "px"}))
            })
        })
    }), $("#box_job").on("mouseleave", ".job_main li", function () {
        $(this).children("ul").hide()
    }), $("#select_category").bind("click", function (a) {
        a.stopPropagation(),
        $(".boxUpDown").hide(),
        $(".selectr").removeClass("selectrFocus"),
        $(this).addClass("selectrFocus"),
        $("#box_job").show()
    }), $("#box_job").on("click", "ul.job_main > li", function (a) {
        a.stopPropagation();
        var b = $(this).children("span").text();
        var d = $(this).children("span").children("input").val();
        $("#select_category").css("color", "#333").val(b).removeClass("selectrFocus"),
        $("#jobType").val(b),
        $("#jobTypeId").val(d),
        $("#jobName").val(b),
        $("#box_job").hide(),
        placeholderFn(),
        $("#jobForm").validate().element("#jobType")
    }), $("#select_experience").bind("click", function (a) {
        a.stopPropagation(),
        $(".selectr").removeClass("selectrFocus"),
        $("#box_job").hide(),
        $(".boxUpDown").hide(),
        $(this).addClass("selectrFocus"),
        $(this).siblings(".boxUpDown").show()
    }), $("#box_experience").on("click", "ul li", function (a) {
        a.stopPropagation();
        var b = $(this).attr("value");
        var d = $.trim($(this).text());
        $(this).parents("#box_experience").hide().siblings("#select_experience").val(d).css("color", "#333").removeClass("selectrFocus"),
        $(this).parents("#box_experience").hide().siblings("#experienceId").val(b),
        $(this).parents("#box_experience").hide().siblings("#experience").val(d),
        $("#jobForm").validate().element($("#experience"))
    }), $("#select_education").bind("click", function (a) {
        a.stopPropagation(),
        $(".selectr").removeClass("selectrFocus"),
        $("#box_job").hide(),
        $(".boxUpDown").hide(),
        $(this).addClass("selectrFocus"),
        $(this).siblings(".boxUpDown").show()
    }), $("#box_education").on("click", "ul li", function (a) {
        a.stopPropagation();
        var b = $(this).attr("value");
        var d = $.trim($(this).text());
        $(this).parents("#box_education").hide().siblings("#select_education").val(d).css("color", "#333").removeClass("selectrFocus"),
        $(this).parents("#box_education").hide().siblings("#educationId").val(b),
        $(this).parents("#box_education").hide().siblings("#education").val(d),
        $("#jobForm").validate().element($("#education"))
    }), $("#jobForm").submit(function () {
        tinyMCE.triggerSave(!0);
        //$("#jobDetail").value(tinyMCE.get("jobDetail_parent").getContent());
    }).validate({
        groups: {salary: "salaryMin salaryMax"},
        onkeyup: !1,
        focusCleanup: !0,
        rules: {
            jobName: {required: !0, specialchar: !0, rangelength: [1, 40]},
            jobType: {required: !0},
            jobNature: {required: !0},
            workAddress: {required: !0, cityAvailable: !0, maxlenStr: 20},
            salaryMin: {
                required: function () {
                    return !("" != $("#salaryMin").val() && $("#salaryMin").val() != $("#salaryMin").attr("placeholder") || "" != $("#salaryMax").val() && $("#salaryMax").val() != $("#salaryMax").attr("placeholder"))
                }, digits: !0, range: [1, 100], Dvalue: !0
            },
            salaryMax: {
                required: function () {
                    return !("" != $("#salaryMin").val() && $("#salaryMin").val() != $("#salaryMin").attr("placeholder") || "" != $("#salaryMax").val() && $("#salaryMax").val() != $("#salaryMax").attr("placeholder"))
                }, digits: !0, range: [1, 100], Dvalue: !0
            },
            workYear: {required: !0},
            education: {required: !0},
            jobAdvantage: {required: !0, specialchar: !0, checkNum: !0, rangelength: [2, 20]},
            quantity: {required: !0, digits: !0},
            jobDetail: {required: !1, textInMce: !0, hasEmail: !0},
            jobAddress: {required: !0, maxlength: 150},
            forwardEmail: {required: !1, email: !0, forwardEmailFormat: !0, forwardSame: !0}
        },
        messages: {
            jobName: {required: "请输入职位名称，如：产品经理", specialchar: "请输入有效的职位名称", rangelength: "请输入1-40字的职位名称"},
            jobType: {required: "请选择职位类别"},
            jobNature: {required: "请选择工作性质"},
            workAddress: {required: "请输入工作城市，如：广州", maxlenStr: "请输入有效的工作城市"},
            salaryMin: {
                required: "请输入月薪范围，如：4",
                digits: "请输入有效的月薪范围，如：4",
                range: "请输入有效的月薪范围，1k-100k",
                salaryRange: "最高月薪不能大于最低月薪的2倍",
                Dvalue: "最高月薪需大于最低月薪"
            },
            salaryMax: {
                required: "请输入月薪范围，如：4",
                digits: "请输入有效的月薪范围，如：4",
                range: "请输入有效的月薪范围，1k-100k",
                salaryRange: "最高月薪不能大于最低月薪的2倍",
                Dvalue: "最高月薪需大于最低月薪"
            },
            workYear: {required: "请选择工作经验要求"},
            education: {required: "请选择学历要求"},
            quantity: {
                required: "请输入招聘人数，如：1",
                digits: "请输入有效的招聘人数"
            },
            jobAdvantage: {
                required: "一句话描述该职位的吸引力，如：负责领域、福利待遇等，限20字",
                specialchar: "请输入有效的职位诱惑信息",
                checkNum: "请输入有效的职位诱惑信息",
                rangelength: "请输入2-20字的职位诱惑"
            },
            jobDetail: {
                required: "请输入岗位职责、任职要求等，建议尽量使用短句并分条列出",
                textInMce: "请输入20-2000字的职位描述",
                hasEmail: "职位描述不能包含邮箱，请去掉"
            },
            jobAddress: {required: "请输入工作地点", maxlength: "请输入150字以内的工作地点"},
            forwardEmail: {
                email: "请输入正确的邮箱格式",
                forwardEmailFormat: "请输入与当前接收简历邮箱后缀一致的邮箱地址",
                forwardSame: "请输入与当前接收简历邮箱不同的邮箱地址"
            }
        },
        errorPlacement: function (a, b) {
            "hidden" == b.attr("type") ? a.appendTo($(b).parent()) : "radio" == b.attr("type") ? a.insertAfter($(b).parents("ul.profile_radio")) : "salaryMin" == b.attr("name") || "salaryMax" == b.attr("name") ? a.insertAfter($(b).parents(".salary_range")) : b.is("textarea") ? a.appendTo($(b).parent()) : a.insertAfter($(b))
            setTimeout(function () {
                $("#jobPreview").removeAttrs("disabled");
                $("#jobPreview").css("background-color","#09A1D2");
                $("#formSubmit").removeAttrs("disabled");
                $("#formSubmit").css("background-color","#09A1D2");
            }, 1500);
        },
        invalidHandler: function (a, b) {
            if (b.numberOfInvalids()) {
                var c = $(b.errorList[0].element).offset().top;
                "jobType" == b.errorList[0].element.name ? c = 150 : "workYear" == b.errorList[0].element.name ? c = 650 : "education" == b.errorList[0].element.name && (c = 700), $("html, body").animate({scrollTop: c}, 400)
            }
            setTimeout(function () {
                $("#jobPreview").removeAttrs("disabled");
                $("#jobPreview").css("background-color","#09A1D2");
                $("#formSubmit").removeAttrs("disabled");
                $("#formSubmit").css("background-color","#09A1D2");
            }, 1500);
        }
    }), jQuery.validator.addMethod("cityAvailable", function (a, b) {
        return this.optional(b) || city_check(a)
    }, "请输入有效的公司所在城市，如：广州"),
        jQuery.validator.addMethod("hasEmail", function (a) {
        return a.indexOf("@") > 0 && (a.indexOf(".com") > 0 || a.indexOf(".cn") > 0) && (a.indexOf(".com") - a.indexOf("@") < 15 && a.indexOf(".com") - a.indexOf("@") > 0 || a.indexOf(".cn") - a.indexOf("@") < 15 && a.indexOf(".cn") - a.indexOf("@") > 0) ? !1 : !0
    }, "职位描述不能包含邮箱，请去掉"),
        $.validator.addMethod("textInMce", function () {
        var c = tinyMCE.get("jobDetail").getContent().replace(/<.*?>/g, ""), d = getStrLen(c);
        return d >= 40 && 4e3 >= d ? !0 : !1
    }, "请输入20-2000字的职位描述"),
        $.validator.classRuleSettings.textInMce = {textInMce: !0}, $("#workAddress").focus(function () {
        $("#beError").hide()
    }),
        jQuery.validator.addMethod("forwardEmailFormat", function (a) {
        var d = $.trim(a).indexOf("@"), e = $.trim(a).substring(d, $.trim(a).length), f = $.trim($("#receiveEmailVal").val()),
            g = f.indexOf("@"), h = f.substring(g, f.length);
        return "" != $.trim(a) && e != h ? !1 : !0
    }, "请输入与当前接收简历邮箱后缀一致的邮箱地址"),
        jQuery.validator.addMethod("forwardSame", function (a) {
        var d = $.trim(a), e = $.trim($("#receiveEmailVal").val());
        return "" != d && d == e ? !1 : !0
    }, "请输入与当前接收简历邮箱不同的邮箱地址"),
        $("#jobPreview").click(function () {
            $("#jobForm").click(function () {
                a(2)
            })
    }), $("#forwardEmail").focus(function () {
        $(".error").siblings("span").hide()
    }), $("#formSubmit").click(function () {
        a(1)
    })
});

function addjob(n,job) {
    var _done;
    _done = n==1? _1done : _2done;
    var flag;
    flag = n==1? '1':'0';
    job['online'] = flag;
    if(job['job_id']!=null && job['job_id']!=''){
        $.updateCnfwsy(jobcurd+'/'+job['job_id'], job, _done, _c1fail)
    }else {
        $.addCnfwsy(jobcurd, job, _done, _c1fail);
    }

    setTimeout(function () {
        $("#jobPreview").removeAttrs("disabled");
        $("#jobPreview").css("background-color","#09A1D2");
        $("#formSubmit").removeAttrs("disabled");
        $("#formSubmit").css("background-color","#09A1D2");
    }, 1500);
}

function _1done(data) {
    $("#issue").hide();
    $("#issue_suc").show()
}

function _2done(data) {
    window.location.href = job_preview + data.job_id;
}

function _c1fail(rtn_msg) {
    $("#beError").text(rtn_msg).show();
}