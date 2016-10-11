/**
 * description:简历
 * Created by liangminglong on 2016/6/20.
 */
//页面加载后执行
$(function () {
    //var employee_id = $.getUsrId();

    var account_id = $.getUsrId();
    var employee_id = $("#employee_id").val();
    $("#account_id").val(account_id);

    //初始化
    curriculum_vitae.init( employee_id,account_id);

});

//简历操作
var curriculum_vitae = {
    //初始化数据
    init: function (employee_id, account_id) {

        if (!account_id) {
            $(".expectAdd.pAdd").removeClass("dn");
            return;
        }
        //alert(resumeUrl);
        //初始化简历
        /*$.infoCnfwsy(resumeUrl + employee_id, {}, function (data) {
            curriculum_vitae.initBasic(employee_id, account_id);
            curriculum_vitae.initExpectForm(employee_id, account_id);
            curriculum_vitae.initCompanyList(employee_id, account_id);
            curriculum_vitae.initEducationalList(employee_id, account_id);
            curriculum_vitae.initDescription(employee_id, account_id);





        }, function () {
            alert("fail");
        });
*/
        curriculum_vitae.initBasic(employee_id, account_id);
        curriculum_vitae.initExpectForm(employee_id, account_id);
        curriculum_vitae.initCompanyList(employee_id, account_id);
        curriculum_vitae.initEducationalList(employee_id, account_id);
        curriculum_vitae.initDescription(employee_id, account_id);

    },
    initBasic: function (employee_id, account_id) {
        //初始化基本信息
        $.infoCnfwsy(employeeUrl + employee_id, {}, function (data) {

            if (!data){
                $(".basicShow").append("<span>增加真实基本信息，增加就业机会</span>");
            }else {
                //console.info(data);
                $("#curriculum_title").append('<h1 title="' + data.name + '">' + data.name + '</h1>| <a target="_blank" href="/preview">预览</a>');

                $(".basicShow").append("<span>" + data.name + " |  " + data.sex_name + " |    " +
                    data.academic_name + " |  " + data.seniority_name + "<br>" + data.phone + " | " + data.mail_box + "<br> </span>");
                $(".basicShow").append('<div class="m_portrait"><div></div><img width="120" height="120" alt="' + data.name + '" src="'+data.icon_path+'"></div>');
                //init profileForm form

                $("#editFlag").val("edit");
                $("#nameVal").val(data.name);
                $("#genderVal").val(data.sex_name);
                $("#topDegreeVal").val(data.academic_name);
                $("#workyearVal").val(data.seniority_name);
                $("#currentStateVal").val(data.state_name);
                $("#emailVal").val(data.mail_box);
                $("#telVal").val(data.phone);
                $("#name").val(data.name);
                $("#sex_name").val(data.sex_name);
                $("#academic_name").val(data.academic_name);
                $("#seniority_name").val(data.seniority_name);
                $("#state_name").val(data.state_name);
                $("#mail_box").val(data.mail_box);
                $("#phone").val(data.phone);
                $("#pageType").val("7");
                //$("#employee_id").val("1");
                //userId = "1"
                $("#lastChangedTime").html('<span>'+data.update_time+'</span>');
            }
        }, function () {
            alert("fail");
        });
    },
    initExpectForm: function (employee_id, account_id) {

        tinyMCE.init({
            selector: '#experienceText',
            menubar: false,
            width: 540,
            height: 200,
            plugins: [
                'advlist autolink lists charmap print preview hr anchor pagebreak spellchecker',
                'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
                'save table contextmenu directionality emoticons template paste textcolor'
            ],
            toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | print preview fullpage | forecolor backcolor emoticons'
        });
        //初始化期望信息
        $.infoCnfwsy(empResExpectUrl + employee_id, {}, function (data) {
            //console.info(data);
            if (!data) {
                //alert(1);
                $(".expectAdd.pAdd").removeClass("dn");
                $("#expectJob #controllFlag").val("insert");
            } else {

                $(".expectShow").append('<span>' + data.position_name + ' | ' + data.type_name + ' | ' + data.area_name + ' | ' + data.salary_name + '</span>');

                $("#expectJob .c_edit").removeClass("dn");

                $("#expectJobVal").val(data.type_name);
                $("#expectCityVal").val(data.area_name);
                $("#typeVal").val(data.type_name);
                $("#expectPositionVal").val(data.position_name);
                $("#expectSalaryVal").val(data.salary_name);
                $("#select_expectCity").val(data.area_name);
                $("#position_name").val(data.position_name);
                $("#select_expectSalary").val(data.salary_name);
                $("#type_name").val(data.type_name);
                $("#expectJob #controllFlag").val("edit");
                $("#lastChangedTime").html('<span>'+data.update_time+'</span>');
            }


        }, function () {
            alert("fail");
        });
    },
    initCompanyList: function (employee_id, account_id) {
        //初始化工作经验
        $.listCnfwsy(empResCompanyListUrl, {
            'employee_id': employee_id,
            "page_size": 20,
            "page_no": 1
        }, function (data) {
            //console.info(data);

            //var data=1;
            if ((data.items.length) == 0) {


            } else {

                $("#workExperience .experienceShow").removeClass("dn");
                $("#workExperience .c_add").removeClass("dn");
                var e = "";
                (data.items).forEach(function (eachItem) {
                    e = '<li data-id="' + eachItem.company_id + '">';
                    e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i>' +
                        '<span class="c9"  style="float: left;" data-startYear="' + eachItem.company_start_year + '" data-endYear="' + eachItem.company_end_year
                        + '" data-startMonth = "' + eachItem.company_start_month + '" data-endMonth = "'
                        + eachItem.company_end_month + '">' + eachItem.company_start_year + "-" + eachItem.company_end_year  +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "</span>" + "<div>"
                        + "<h3 style='display: inline'>" + eachItem.position_name +"</h3><h4 style='display: inline'>"+ eachItem.company_name +"</h4>" + "</div>" +"<div class='descriptionShow' >"+eachItem.text+"</div>" + "</li>";
                    $("#workExperience .experienceShow .wlist").append(e);
                });


                //console.info($(".experienceShow .wlist li").length);
                $(".experienceAdd.pAdd").addClass("dn");
                $("#lastChangedTime").html('<span>'+data.update_time+'</span>');

            }


        }, function () {
            alert("fail");
        });
    },
    initEducationalList: function (employee_id, account_id) {
        //初始化教育背景
        $.listCnfwsy(empResEduListUrl, {'resume_id': employee_id, "page_size": 20, "page_no": 1}, function (data) {
            //console.info(data);

            //var data=1;
            if ((data.items.length) == 0) {


            } else {

                $("#educationalBackground .educationalShow").removeClass("dn");
                $("#educationalBackground .c_add").removeClass("dn");
                var e = "";
                (data.items).forEach(function (eachItem) {
                    e = '<li data-id="' + eachItem.university_id + '">';
                    e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i><span class="c9" data-startY="' + eachItem.start_year + '" data-endY="' +
                        eachItem.end_year + '">'
                        + eachItem.start_year + "-" + eachItem.end_year + "</span>" + "<div>" + '<h3 data-schName="' + eachItem.university_name + '">'
                        + eachItem.university_name + "</h3>" + '<h4 data-proName="' + eachItem.speciality_name + '" data-degree="' + eachItem.academic_name + '">'
                        + eachItem.academic_name + "，" + eachItem.speciality_name + "</h4>" + "</div>" + "</li>";
                    $("#educationalBackground .educationalShow .elist").append(e);
                });

                $(".educationalAdd.pAdd").addClass("dn");
                $("#lastChangedTime").html('<span>'+data.update_time+'</span>');

            }


        }, function () {
            alert("fail");
        });
    },
    initDescription: function (employee_id, account_id) {
        //console.info(account_id);
        //初始化自我描述
        $.infoCnfwsy(empResCustomUrl + employee_id, {}, function (data) {
            //console.info(data);
            //var data=1;
            if (!data) {


            } else {
                //console.info("enter?");
                /*

                 $("#resubmitToken").val(b.resubmitToken), b.success ?

                 (c = b.content.resume, d = "", c.myRemark ? (d = c.myRemark, g.text = c.myRemark, g.obj.children(".c_edit").removeClass("dn"),
                 g.obj.children(".descriptionShow").html(d).removeClass("dn"), g.obj.children(".descriptionEdit").addClass("dn"),
                 $("#lastChangedTime span").text(b.content.refreshTime),
                 $("#resumeScore .which div").text(b.content.infoCompleteStatus.msg),
                 $("#resumeScore .which span").attr("rel", b.content.infoCompleteStatus.nextStage),
                 scoreChange(b.content.infoCompleteStatus.score), k(g.obj)) : (g.text = "", g.obj.children(".c_edit").addClass("dn"),
                 g.obj.children(".descriptionShow").addClass("dn"), g.obj.children(".descriptionEdit").addClass("dn"), g.obj.children(".descriptionAdd").removeClass("dn")
                 , $("#lastChangedTime span").text(b.content.refreshTime), $("#resumeScore .which div").text(b.content.infoCompleteStatus.msg),
                 $("#resumeScore .which span").attr("rel", b.content.infoCompleteStatus.nextStage), scoreChange(b.content.infoCompleteStatus.score), k(g.obj)),
                 b.content.isNew && changeAllIds(b.content.jsonIds)) : alert(b.msg), $(a).find(":submit").val("保 存").attr("disabled", !1)

                 */

                $("#lastChangedTime span").text(data.update_time);

                $("#selfDescription .descriptionShow").removeClass("dn");
                $("#selfDescription .descriptionShow").html(data.description);
                $("#selfDescription .c_edit").removeClass("dn");


                $(".descriptionAdd.pAdd").addClass("dn");

            }


        }, function () {
            alert("fail");
        });
    },
    //提交基本信息
    submitBasic: function () {
        var params = getFormJson($("#profileForm"));
        var portraitNo_url = $("#portraitNo_url").val();

        //delete params.account_id;
        console.info(params);
        params.icon_path = portraitNo_url;
        $("#basicFormButton").val("保存中...").attr("disabled", !0);

        var flag = $(".basicShow span").text()=="增加真实基本信息，增加就业机会"?true:false;

        if ($("#employee_id").val()) {
            $.updateCnfwsy(flag?employeeAddUrl:employeeUrl + $("#employee_id").val(), params, function (data) {

                $(".basicShow").html("");
                $(".basicShow").append("<span>" + $("#name").val() + " |  " + $("[name='sex_name']").val() + " |    " +
                    $("#academic_name").val() + " |  " + $("#seniority_name").val() + "<br>" + $("#phone").val() + " | " + $("#mail_box").val() + "<br> </span>");
                $(".basicShow").append('<div class="m_portrait"><div></div><img width="120" height="120" alt="' + data.name + '" src="'+data.icon_path+'"></div>');
                $("#basicInfo .basicEdit").addClass("dn");
                $("#basicInfo .c_edit").removeClass("dn");
                $(".basicShow").removeClass("dn");

                $("#basicFormButton").val("保存").attr("disabled", !1);
                $("#basicFormCancel").trigger("click");
                $("#lastChangedTime span").text(data.update_time);
            }, function () {
                alert("fail");
            }, flag?"POST":"PUT")
        }
    },
    //提交期望工作
    submitExpectForm: function () {
        $("#expectShowButton").val("保存中...").attr("disabled", !0);
        var data_params = getFormJson($("#expectForm"));
        data_params.employee_id = $("#resume_id").val();
        data_params.resume_id = $("#resume_id").val();
        //新增
        if ($("#expectJob #controllFlag").val()=="insert") {


            //console.info(data_params);
            $.updateCnfwsy(empResExpectAddUrl, data_params, function (data) {

                $(".expectShow").html("");
                $(".expectShow").append('<span>' + $("#position_name").val() + ' | ' + data_params.type_name + ' | ' + $("#area_name").val() + ' | ' + $("#salary_name").val() + '</span>');

                $("#expectJob .c_edit").removeClass("dn");

                $("#expectJob .expectShow").removeClass("dn");
                $("#expectJob .expectEdit").addClass("dn");
                $("#expectJobVal").val(data_params.type_name);
                $("#expectCityVal").val(data_params.area_name);
                $("#typeVal").val(data_params.type_name);
                $("#expectPositionVal").val(data_params.position_name);
                $("#expectSalaryVal").val(data_params.salary_name);

                $("#expectShowButton").val("保存").attr("disabled", !1);
                $("#empResExpectCancel").trigger("click");
                $("#lastChangedTime span").text(data.update_time);
            }, function () {
                alert("fail");
        }, "POST");
            //更新
        } else if ($("#expectJob #controllFlag").val()=="edit") {
            //var data_params = getFormJson($("#expectForm"));
            data_params.employee_id = $("#resume_id").val();

            $.updateCnfwsy(empResExpectUrl + $("#resume_id").val(), data_params, function (data) {


                $(".expectShow").html("");
                $(".expectShow").append('<span>' + $("#position_name").val() + ' | ' + data_params.type_name + ' | ' + $("#area_name").val() + ' | ' + $("#salary_name").val() + '</span>');

                $("#expectJob .c_edit").removeClass("dn");

                $("#expectJob .expectShow").removeClass("dn");
                $("#expectJob .expectEdit").addClass("dn");
                $("#expectJobVal").val(data_params.type_name);
                $("#expectCityVal").val(data_params.area_name);
                $("#typeVal").val(data_params.type_name);
                $("#expectPositionVal").val(data_params.position_name);
                $("#expectSalaryVal").val(data_params.salary_name);

                $("#expectShowButton").val("保存").attr("disabled", !1);
                $("#empResExpectCancel").trigger("click");
                $("#lastChangedTime span").text(data.update_time);
            }, function () {
                alert("fail");
            }, "PUT")
        }

    },
    //提交工作经验
    submitExperienceForm: function () {

        $("#submitExperienceForm").val("保存中...").attr("disabled", !0);
        var company_name = $('input[name="company_name"]').val(),
            position_name = $('input[name="company_position_name"]').val(),
            company_start_year = $('input[name="company_start_year"]').val(),
            company_start_month = $('input[name="company_start_month"]').val(),
            company_end_year = $('input[name="company_end_year"]').val(),
            company_end_month = $('input[name="company_end_month"]').val(),
            text = tinyMCE.get('experienceText').getContent(),
            company_id = $('.expId').val(),
            employee_id = $('#employee_id').val(),
            resume_id = $('#resume_id').val();
        var submitData = {
            company_name: company_name,
            position_name: position_name,
            company_start_year: company_start_year,
            company_start_month: company_start_month,
            company_end_year: company_end_year,
            company_end_month: company_end_month,
            company_id: company_id,
            employee_id: employee_id,
            text:text,
            resume_id: employee_id
        }
        //console.info(company_id);
        //新增
        if (!company_id || company_id == '') {
            $.updateCnfwsy(empResCompanyAddUrl, submitData, function (data) {


                $("#workExperience .experienceShow").removeClass("dn");
                //$("#workExperience .c_add").removeClass("dn");
                var e = '<li data-id="' + 1 + '">';
                e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i>' +
                    '<span class="c9"  style="float: left;" data-startYear="' + company_start_year + '" data-endYear="' + company_end_year
                    + '" data-startMonth = "' + company_start_month + '" data-endMonth = "'
                    + company_end_month + '">' + company_start_year + "-" + company_end_year  +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "</span>" + "<div>"
                    + "<h3 style='display: inline'>" + position_name +"</h3><h4 style='display: inline'>"+ company_name
                    +"</h4>" + "</div>" +"<div class='descriptionShow' >"+text+"</div>" + "</li>";


                $("#workExperience .experienceShow .wlist").append(e);


                $("#workExperience .c_add").removeClass("dn"),
                    $(".experienceAdd.pAdd").addClass("dn");
                $(".experienceForm.borderBtm").addClass("dn");

                $("#cancelExperience").trigger("click");

                $("#expectShowButton").val("保存").attr("disabled", !1);
                $("#lastChangedTime span").text(data.update_time);
            }, function () {
                alert("fail");
            }, "POST");
            //更新
        } else {

            $.updateCnfwsy(empResCompanyUrl + company_id, submitData, function (data) {
                $("#workExperience .experienceShow .wlist li").each(function(index,ele){
                    //console.info($(ele));
                    if($(ele).attr("data-id") == company_id){
                        $(ele).empty();
                        var e = "";
                        e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i>' +
                            '<span class="c9" style="float: left;" data-startYear="' + company_start_year + '" data-endYear="' + company_end_year + '" data-startMonth = "' + company_start_month + '" data-endMonth = "'
                            + company_end_month + '">' + company_start_year + "-" + company_end_year+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "</span>" +  "<div>"
                            + "<h3 style='display: inline'>" + position_name +"</h3><h4 style='display: inline'>"+ company_name
                            +"</h4>" + "</div>" +"<div class='descriptionShow' >"+text+"</div>" ;
                        $(ele).append(e);
                        $("#cancelExperience").trigger("click");

                        $("#submitExperienceForm").val("保存").attr("disabled", !1);
                    }else {
                        return;
                    }
                })

                /*$("#workExperience .experienceShow").removeClass("dn");
                 $("#workExperience .c_add").removeClass("dn");



                 $("#workExperience .c_add").addClass("dn"),
                 $(".experienceAdd.pAdd").addClass("dn");
                 $(".experienceForm.borderBtm").addClass("dn");*/
                $("#cancelExperience").trigger("click");

                $("#submitExperienceForm").val("保存").attr("disabled", !1);
                $("#lastChangedTime span").text(data.update_time);



            }, function () {
                alert("fail");
            }, "PUT");
        }

    }

};


// ps:注意将同名的放在一个数组里
function getFormJson(form) {
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}


function img_check(_this) {
    $.picUpload(_this, upload_url, updataSuccess, uploadFail);
}

function updataSuccess(data) {
    var img_url = data.file_path + "/" + data.new_file_name;
    var file_id = data.file_id;
    var image_path = img_url;
    "" != img_url ? ($("#file_id").val(file_id), $("#portraitNo_url").val(image_path), $("#portraitShow img").attr("src", img_url), $("#portraitNo").hide(), $("#portraitShow").show()) : $("#" + g).text("上传失败，请重新上传").show();
}

function uploadFail(msg) {
    errorTips("只支持jpg、jpeg、gif、png格式，文件小于2M", "错误提示");
}