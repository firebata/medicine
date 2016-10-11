/**
 * description:简历
 * Created by liangminglong on 2016/6/20.
 */
//页面加载后执行
$(function () {
    var account_id = $.getUsrId();
    var employee_id = $("#employeeId").val();
    $("#account_id").val(account_id);

    //初始化
    preview.init(employee_id, account_id);



});

//简历操作
var preview = {
    //初始化数据
    init: function (employee_id, account_id) {
        //初始化简历
        preview.initBasic(employee_id, account_id);
        preview.initExpectForm(employee_id, account_id);
        preview.initCompanyList(employee_id, account_id);
        preview.initEducationalList(employee_id, account_id);
        preview.initDescription(employee_id, account_id);


    },
    initBasic: function (employee_id, account_id) {
        //初始化基本信息
        $.infoCnfwsy(employeeUrl + employee_id, {}, function (data) {
            if (!data.name) {
            } else {
                $("#userName").attr("alt", data.name);
                $("#userName").text(data.name);
                $("#resumeContentBody .summary a").attr("href", data.icon_path);
                $("#resumeContentBody .summary a img").attr("src", data.icon_path);
                $("#resumeContentBody .summary .summary-top").html("<span>" + data.sex_name  + "&nbsp;&nbsp;&nbsp;&nbsp;" + data.seniority_name + "&nbsp;&nbsp;&nbsp;&nbsp;" + data.academic_name + "&nbsp;&nbsp;&nbsp;&nbsp;</span>" +
                /*"<br>现居住地：广州 黄埔区 | 户口：湘潭 | 团员" +*/
                "<br>电话：" + data.phone + "  |  邮箱： " + data.mail_box);
            }
        }, function () {
            alert("fail");
        });
    },
    initExpectForm: function (employee_id, account_id) {
        //初始化期望信息
        $.infoCnfwsy(empResExpectUrl + employee_id, {}, function (data) {
            if (!data) {

            } else {
                //console.info(data);
                $("#expectJob tbody").html('<tr valign="top"><td width="85" align="right">期望工作地区：</td><td>' + data.area_name + '</td></tr>' +
                    '<tr valign="top"><td width="85" align="right">期望月薪：</td><td>' + data.salary_name + '</td></tr>' +
                    '<tr valign="top"><td width="85" align="right">期望职位：</td><td>' + data.position_name + '</td></tr>' +
                    '<tr valign="top"><td width="85" align="right">期望工作性质：</td><td>' + data.type_name + '</td></tr>' /*+
                 '<tr valign="top"><td width="85" align="right">期望从事职业：</td><td>工程造价/预结算、互联网产品/运营管理、艺术/设计</td></tr>' +
                 '<tr valign="top"><td width="85" align="right">期望从事行业：</td><td>房地产/建筑/建材/工程、礼品/玩具/工艺美术/收藏品/奢侈品、贸易/进出口</td></tr>'*/
                );
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
            if ((data.items.length) == 0) {
            } else {

                (data.items).forEach(function (eachItem) {

                    $("#workExperience .fc6699cc").after(
                        '<h2>' + eachItem.company_start_year + '.' + eachItem.company_start_month + ' - ' + eachItem.company_end_year + '.' + eachItem.company_end_month + '&nbsp;&nbsp;' + eachItem.company_name + '&nbsp;&nbsp;（3个月）</h2>' +
                        '<h5>' + eachItem.position_name + ' </h5>' + '<div class="resume-preview-dl">' +
                        '<table cellpadding="0" cellspacing="0">' +
                        '<tbody>' +
                        '<tr valign="top">' +
                        '<td width="60">工作描述：</td>' +
                        '<td>'+eachItem.text+'</td>'+
                    '</tr>' +
                    '</tbody>' +
                    '</table>' +
                    '</div>'
                    );

                    /*
                     e = '<li data-id="' + eachItem.company_id + '">';
                     e += '<i class="sm_del dn"></i><i class="sm_edit dn"></i>' +
                     '<span class="c9" data-startYear="' + eachItem.company_start_year + '" data-endYear="' + eachItem.company_end_year
                     + '" data-startMonth = "' + eachItem.company_start_month + '" data-endMonth = "'
                     + eachItem.company_end_month + '">' + eachItem.company_start_year + "-" + eachItem.company_end_year
                     + "</span>" + "<div>" + '<img src="" width="56" height="56" alt="' + 1 + '" />'
                     + "<h3>" + eachItem.company_name + "</h3>" + "<h4>" + eachItem.position_name + "</h4>" + "</div>" + "</li>";
                     $("#workExperience .experienceShow .wlist").append(e);*/
                });


                //console.info($(".experienceShow .wlist li").length);

            }


        }, function () {
            alert("fail");
        });
    },
    initEducationalList: function (employee_id, account_id) {
        //初始化教育背景
        $.listCnfwsy(empResEduListUrl, {'resume_id': employee_id, "page_size": 20, "page_no": 1}, function (data) {
            //console.info(data);
            if ((data.items.length) == 0) {
            } else {

                (data.items).forEach(function (eachItem) {

                    $("#eduExperience .fc6699cc").after(
                        '<div class="resume-preview-dl educationContent">' + eachItem.start_year + ' - ' + eachItem.end_year + '&nbsp;&nbsp;' + eachItem.university_name + '&nbsp;&nbsp;' + eachItem.speciality_name + '&nbsp;&nbsp;' + eachItem.academic_name + '<br>'
                    );

                });


            }


        }, function () {
            alert("fail");
        });
    },
    initDescription: function (employee_id, account_id) {
        //console.info(resume_id);
        //初始化自我描述
        $.infoCnfwsy(empResCustomUrl + employee_id, {}, function (data) {
            console.info(data);
            if (!data) {
            } else {
                $("#selfDescription").css('display', 'block');
                $("#selfDescription .resume-preview-dl.rd-break").html(data.description);
            }
        }, function () {
            alert("fail");
        });
    }
};
