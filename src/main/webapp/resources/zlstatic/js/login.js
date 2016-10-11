/**
 * Created by zhangjh on 2016-08-26.
 */
(function ($) {
    "use strict";
    function toLogin() {
        var $form = $("#loginForm");
        if ($('#remember').prop("checked")) {
            $('#remember').val(1);
        } else {
            $('#remember').val(null);
        }
        var tel_no = $('#tel_no').val();
        var password = $('#password').val();
        var remember = $('#remember').val();

        $form.find(":submit").attr("disabled", true);
        var user = {tel_no: tel_no, password: password/*,autoLogin:remember*/};
        $.addCnfwsy(lr_li_url, user, succ, fail);
    }

    $(function () {
        //验证表单
        $("#loginForm").validate({
            rules: {
                tel_no: {
                    required: true,
                    rangelength: [11, 11]
                },
                password: {
                    required: true
                }
            },
            messages: {
                tel_no: {
                    required: "请输入手机号码",
                    rangelength: "请输入11位手机号码"
                },
                password: {
                    required: "请输入密码"
                }
            },
            submitHandler: function (form) {

            }
        });
    })

    function succ(result, status, xhr) {
        var token = xhr.getResponseHeader("X-Token");
        var usr = JSON.stringify(result)
        $.cookie("X-Token", token, {expires: 1});
        $.cookie("cusr", usr, {expires: 1});
        var type_id = result.type_id;
        var buss_id = result.buss_id;
//        if (type_id == 1) {
//            window.location.href = "/company_edit/"+buss_id;
//        } else {
//            window.location.href = "/index.html";
//        }
        window.location.href = "/index.html";
    }

    function fail(msg) {
        $('#beError').text(msg).show();
    }


    var handlerPopup = function (captchaObj) {

        $("#submitLogin").click(function () {
            var validate = captchaObj.getValidate();
            if (!validate) {
                alert('请先完成验证！');
                return;
            }
            $.ajax({
                url: "VerifyLoginServlet", // 进行二次验证
                type: "post",
                dataType: "json",
                data: {
                    // 二次验证所需的三个值
                    geetest_challenge: validate.geetest_challenge,
                    geetest_validate: validate.geetest_validate,
                    geetest_seccode: validate.geetest_seccode
                },
                success: function (data) {

//                    console.log("11111");
                    if (data && (data.status === "success")) {
                        toLogin();
                    } else {
//                        $(document.body).html('<h2>验证失败 </h2><a href="/index.html">返回主页</a>');
                    }
                }
            });
        });

        // 弹出式需要绑定触发验证码弹出按钮
        captchaObj.bindOn("#submitLogin");

        // 将验证码加到id为captcha的元素里
        captchaObj.appendTo("#popup-captcha");

        // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
    };

    $.ajax({
        // 获取id，challenge，success（是否启用failback）
        url: "StartCaptchaServlet",
        type: "get",
        dataType: "json",
        success: function (data) {

            // 使用initGeetest接口
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                product: "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
                offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            }, handlerPopup);
        }
    });
}(jQuery || {}));
