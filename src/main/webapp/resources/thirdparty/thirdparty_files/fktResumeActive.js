//#region  投递邀请简历

//邀请验证


$("#jobinvited").live("click", function () {
    CheckResumeInvite(0);
    return false;
});

$("#jobinvitedagain").live("click", function () {
    CheckResumeInvite(1);
    return false;
});

//先选择职位的橄榄枝邀请。
$("#jobinvited_select_posi").live("click", function () {
    showPositionList();
    return false;
});

//橄榄枝邀请时展示职位选择列表。
function showPositionList() {
    $.popupDiv({
        title: "选择职位", url: "/resumePreview/resume/resumeinvitedpositionlist", buttons: {
            "确 定": function () {
                if (!confirmChecking()) {
                    return false;
                }
                else {
                    var greenRoomArg = loadingMeg();
                }
                var contacts = greenRoomArg.contacts;
                var contactPhoneType = greenRoomArg.contactPhoneType;
                var contactPhone = greenRoomArg.contactPhone;
                var extId = $("#extId").val();
                var PositionNumber = $("#PositionNumber").val();
                var resume_version = $("#resume_version").val();
                myAjax({
                    type: "POST",
                    url: "/resumePreview/resume/_ResumeInvited?positionnumber=" + PositionNumber + "&extid=" + extId + "&version=" + resume_version + "&contact.Contacts=" + greenRoomArg.contacts + "&contact.contactPhoneType=" + greenRoomArg.contactPhoneType + "&contact.contactPhone=" + greenRoomArg.contactPhone,
                    dataType: 'json',
                    success: function (msg) {
                        $.popupClose();
                        if (msg.Code == 200) {
                            location.replace("http://rd.zhaopin.com/resumepreview/resume/viewone/4/2_" + $("#positionid").val() + "_" + $("#resume_id").val());
                        } else {
                            ShowMsg("265", "邀请失败,错误码:" + msg.Code, 3000);
                        }
                    }
                });

            },
            "取 消": function () {
                $.popupClose();
            }
        },
        width: 420,
        success: function () {

            var $posiList = $('#resume_invited_posi_list');
            if ($posiList.size() > 0) {
                //第一个职位。
                var $firstPosi = $posiList.find('option').first();
                savePositionAndReturnCheckInfo($firstPosi.val(), $firstPosi.data('posi-id'));

            }


        }


    });
}

//选择职位下拉列表选择事件。
$("#resume_invited_posi_list").live("change", function () {
    savePositionAndReturnCheckInfo($(this).val(), $(this).find('option:selected').data('posi-id'));
});

function savePositionAndReturnCheckInfo(posiNumber, posiId) {
    $('#PositionNumber').val(posiNumber);
    $("#positionid").val(posiId);

    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_ResumeInvitedCheck?positionNumber=" + posiNumber + "&resumeNumber=" + $("#extId").val() + "&type=" + 0,
        dataType: 'json',
        success: function (result) {

            //智联币不足。
            if (result.Code == 952) {
                $.popupClose();
                ShowMsg("265", "抱歉，您的智联币不足", 3000);
            }
            else {

                if (result.Code == 960) {
                    $('.popupConfirmBtn').hide();
                } else {
                    $('.popupConfirmBtn').show();
                }

                //获取提示信息。
                var $prompt = $('#check_result_' + result.Code);
                if ($prompt.size() == 0) {
                    $prompt = $('#check_result_1');
                }

                //显示提示信息。
                $('#check_prompt').html($prompt.html());
                if (result.Code == 953 || result.Code == 200) {
                    $('#invitation_contact').show();
                } else {
                    $('#invitation_contact').hide();
                }

            }
            //表单验证与 切换实现；
            feature();
            formValidation();
        },
        error: function (XMLHttpRequest) {
            document.location.href = location.href;
        }
    });
}

//发送橄榄枝
$("#btnglzsend").live("click", function () {
    var PositionNumber = $("#PositionNumber").val();
    window.open("http://jobads.zhaopin.com/Position/RecommendResumes4Position/" + PositionNumber);
});

function CheckResumeInvite(type) {

    //职位编号
    var jobnumber = $("#PositionNumber").val();
    var resumenumber = $("#extId").val();


    myAjax({
        type: "POST",
        url: "/resumePreview/resume/_ResumeInvitedCheck?positionNumber=" + jobnumber + "&resumeNumber=" + resumenumber + "&type=" + type,
        dataType: 'json',
        success: function (msg) {
            ShowDiv(msg.Code, type);


        },
        error: function (XMLHttpRequest) {
            document.location.href = location.href;
        }


    });
}
function ShowDiv(code, type) {
    if (code == 200 || code == 953) {
        $.popupDiv({
            title: "提示", url: "/resumePreview/resume/ResumeInvitedCheck?type=" + code, buttons: {

                "确 定": function () {

                    if (!confirmChecking()) {
                        return false;
                    }
                    else {
                        var greenRoomArg = loadingMeg();
                    }
                    var contacts = greenRoomArg.contacts;
                    var contactPhoneType = greenRoomArg.contactPhoneType;
                    var contactPhone = greenRoomArg.contactPhone;

                    var extId = $("#extId").val();
                    var PositionNumber = $("#PositionNumber").val();
                    var resume_version = $("#resume_version").val();
                    if (type == 0) {
                        myAjax({
                            type: "POST",
                            url: "/resumePreview/resume/_ResumeInvited?positionnumber=" + PositionNumber + "&extid=" + extId + "&version=" + resume_version + "&contact.Contacts=" + greenRoomArg.contacts + "&contact.contactPhoneType=" + greenRoomArg.contactPhoneType + "&contact.contactPhone=" + greenRoomArg.contactPhone,
                            dataType: 'json',
                            success: function (msg) {
                                if (msg.Code == 200) {
                                    $.popupClose();
                                    RefreshResumeInvited();
                                } else {
                                    $.popupClose();
                                    ShowMsg("265", "邀请失败,错误码:" + msg.Code, 3000);
                                }
                            }
                        });
                    } else if (type == 1) {
                        var resumeid = $("#resume_id").val();
                        myAjax({
                            type: "POST",
                            url: "/resumePreview/resume/_ResumeInvitedAgain?positionnumber=" + PositionNumber + "&resumeid=" + resumeid,
                            dataType: 'json',
                            success: function (msg) {
                                if (msg.Code == 200) {
                                    $.popupClose();
                                    RefreshResumeInvited();
                                } else {
                                    $.popupClose();
                                    ShowMsg("265", "邀请失败,错误码:" + msg.Code, 3000);
                                }
                            }
                        });
                    } else {
                        $.popupClose();
                    }

                },
                "取 消": function () {
                    $.popupClose();
                }
            }, width: 420,
            success: function () {
                feature();
                formValidation();
            }
        });

    } else if (code == 1) {
        ShowMsg("265", " 操作出现异常，请稍后重试【错误码：" + code + "】！", 3000);

    } else if (code == 951) {
        var jobNumber = $("#PositionNumber").val();
        $.popupDiv({
            title: "提示",
            url: "/resumePreview/resume/ResumeInvitedCheck?type=" + code + "&jobnumber=" + jobNumber,
            buttons: {

                "确 定": function () {
                    $.popupClose();
                }
            },
            width: 420

        });

    } else if (code == 960) {
        ShowMsg("265", " 您已经给TA发送过橄榄枝", 3000);

    } else if (code == 952) {

        $.popupDiv({
            title: "提示", url: "/resumePreview/resume/ResumeInvitedCheck?type=" + code, buttons: {

                "确 定": function () {
                    $.popupClose();
                }
            }, width: 420
        });
    } else
        ShowMsg("265", "操作出现异常，请稍后重试【错误码：" + code + "】！", 3000);
}
//刷新
function RefreshResumeInvited() {

    var positionid = $("#positionid").val();
    var resumeid = $("#resume_id").val();
    var actionUrl = "http://rd.zhaopin.com/resumepreview/resume/viewone/4/2_" + positionid + "_" + resumeid;
    document.location.href = actionUrl;
    return false;
}

//#endregion
/*详情页弹框修改js SRART*/
/*手机座机切换功能实现*/
function feature() {
    var num = 0;
    $("#select").click(function (e) {
        e.stopPropagation(); //阻止事件冒泡，否则事件会冒泡到下面的文档点击事件;
        if (num == 0) {
            $("#select>ul").css("display", "block");
            $(".reminderphone").html("");
            ++num
        } else {
            $("#select>ul").css("display", "none");
            $(".reminderphone").html("");
            num = 0;
        }
    });
    $(document).click(function () {
        $("#select>ul").hide();
    });
    $("#select>ul>li").mousemove(function () {
        $(this).css("background", "#2F9DDF");
        $(this).siblings().css("background", "#fff");
    });
    //手机座机切换
    $("#select>ul>li").click(function () {

        $("#select>span").html($(this).children().text() + '<b></b>');

        if ($("#select>span").text() == "手机") {
            $(".telephone-coding").children().css("display", "none");
            $(".telephone-coding #telephoneNum").css("display", "inline-block");
        }
        if ($("#select>span").text() == "座机") {
            $(".telephone-coding").children().css("display", "none");
            $(".telephone-coding #region").css("display", "inline-block");
            $(".telephone-coding #phone").css("display", "inline-block");
            $(".telephone-coding #branch").css("display", "inline-block");
            $(".telephone-coding span[data-heng]").css("display", "inline");
        }
    });
};
/*弹框的表单验证*/
function formValidation() {
    //验证联系人
    $("#contact").blur(function () {
        if (!/^[A-Za-z\u4e00-\u9fa5 \,\，\.\。\、]+$/.test($("#contact").val())) {
            $("#contact").css({"border": "1px solid red"});
            $(".contact-man .reminder").html("请输入联系人姓名");
            $(".contact-man .reminder").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else{
            $(".contact-man .reminder").css("visibility", "hidden");
            $("#contact").css({"border": "1px solid #57A8E4"});
            $("#invitation-contact-check").val("1");
        }
    });
    //手机验证；
    $("#telephoneNum").blur(function () {
        reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/i;//电话正则
        if ($("#telephoneNum").val() == ""){
            $("#telephoneNum").css({"border": "1px solid red"});
            $(".reminderphone").html("请输入手机号码");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if ($("#telephoneNum").val().length < 11) {
            $("#telephoneNum").css("border", "1px solid red");
            $(".reminderphone").html("电话号码有误！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if (!reg.test($("#telephoneNum").val())) {
            $("#telephoneNum").css("border", "1px solid red");
            $(".reminderphone").html("请输入手机号！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else {

            $(".reminderphone").css("visibility", "hidden");
            $("#telephoneNum").css({"border": "1px solid #57A8E4"});
            $("#invitation-contact-check").val("1");
        }
    });
    //验证区号
    $("#region").blur(function () {
        reg = /^0\d{2,5}$/ig;//区号正则
        if ($("#region").val() == "") {
            $("#region").css({"border": "1px solid red"});
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if($("#region").val().length < 3) {
            $("#region").css("border", "1px solid red");
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if(!reg.test($("#region").val())) {
            $("#region").css("border", "1px solid red");
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else{
            $(".reminderphone").css("visibility", "hidden");
            $(".reminderphone").html("ok");
            $("#region").css({"border": "1px solid #57A8E4"});
            $("#invitation-contact-check").val("1");
        }
    });
    //验证固定电话
    $("#phone").blur(function () {
        reg = /\d{7,8}/i;//电话正则
        if ($("#phone").val() == "") {
            $("#phone").css({"border": "1px solid red"});
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if($("#phone").val().length > 8) {
            $("#phone").css("border", "1px solid red");
            $(".reminderphone").html("请输入固定电话！！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else if(!reg.test($("#phone").val())) {
            $("#phone").css("border", "1px solid red");
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            $("#invitation-contact-check").val("0");
        }else{

            $(".reminderphone").css("visibility", "hidden");
            $("#phone").css({"border": "1px solid #57A8E4"});
            $("#invitation-contact-check").val("1");
        }
    });
}
/*点击确定参数*/
function loadingMeg() {
    var contactObjct = {};
    contactObjct.contactPhoneType = ($("#select>span").text() === '手机' ? 0 : 1);
    if ($("#contact").val() == ""){
        return false;
    }else if($("#region").val() != "" && $("#phone").val() != "" && contactObjct.contactPhoneType == 1) {
        contactObjct.contactPhone = $("#region").val() + '-' + $("#phone").val() + '-' + $("#branch").val();
    }else if($("#telephoneNum").val() != "" && contactObjct.contactPhoneType == 0) {
        contactObjct.contactPhone = $('#telephoneNum').val();
    }
    contactObjct.contacts = $("#contact").val();
    return contactObjct;
}
function confirmChecking() {
    var reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/i;//手机正则
    var regPhone = /\d{7,8}/i;//固定电话电话正则
    var regAreaCode = /^0\d{2,5}$/ig;//区号正则
    var flag = true;
    //验证联系人
    if ($("#contact").val() == "") {
        $("#contact").css({"border": "1px solid red"});
        $(".contact-man .reminder").html("请输入联系人姓名");
        $(".contact-man .reminder").css({
            "visibility": "visible",
            "color": "red"
        });
        flag = false;
    }
    if(!reg.test($("#telephoneNum").val()) && !$("#telephoneNum").val() == "" && $("#select>span").text() == '手机') {
        $("#telephoneNum").css("border", "1px solid red");
        $(".reminderphone").html("请输入手机号码！");
        $(".reminderphone").css({
            "visibility": "visible",
            "color": "red"
        });
        flag = false;
    }
    if(!regPhone.test($("#phone").val()) && !$("#phone").val() == "" && $("#select>span").text() === '座机') {
        $("#telephoneNum").css("border", "1px solid red");
        $(".reminderphone").html("请输入固定电话！");
        $(".reminderphone").css({
            "visibility": "visible",
            "color": "red"
        });
        flag = false;
    }
    if (!regAreaCode.test($("#region").val()) && !$("#phone").val() == "" && $("#select>span").text() === '座机') {
        $("#telephoneNum").css("border", "1px solid red");
        $(".reminderphone").html("请输入固定电话！");
        $(".reminderphone").css({
            "visibility": "visible",
            "color": "red"
        });
        flag = false;
    }
    //验证联系人
    if ($("#region").val() == "" && $("#select>span").text() == '座机' || $("#phone").val() == "" && $("#select>span").text() == '座机') {
            $("#region").css({"border": "1px solid red"});
            $("#phone").css({"border": "1px solid red"});
            $(".reminderphone").html("请输入固定电话！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            flag = false;
        }
    if ($("#telephoneNum").val() == "" && $("#select>span").text() == '手机') {
            $("#telephoneNum").css({"border": "1px solid red"});
            $(".reminderphone").html("请输入手机号码！");
            $(".reminderphone").css({
                "visibility": "visible",
                "color": "red"
            });
            flag = false;
        }
    if(flag){
            $(".contact-man .reminder").css("visibility", "hidden");
            $("#contact").css({"border": "1px solid #57A8E4"});
            $(".reminderphone").css("visibility", "hidden");
            $("#telephoneNum").css({"border": "1px solid #57A8E4"});
        }

       return flag;
}
/*详情页弹框修改js END*/

