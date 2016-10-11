/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";

    function showVcodeErr($mobile, html) {
        $("#tel_no_error").remove();
        $mobile.after(html);
    }

    function toRegister() {
        var $form = $("#loginForm");
        var type_id = $("input[name='type_id']:checked").val();
        var email = $('#email').val();
        var password = $('#password').val();
        var tel_no = $('#tel_no').val();
        var validate_code = $('#validate_code').val();
        $form.find(":submit").attr("disabled", true);
        var user = {
            tel_no: tel_no,
            email: email,
            password: password,
            type_id: type_id,
            validate_code: validate_code
        };
        $.addCnfwsy(lr_r_url, user, loginSucc, loginFail);
    }

    $(function (e) {

        $('.register_radio li input').click(function (e) {
            $(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
        });

        $('#email').focus(function () {
            $('#beError').hide();
        });
        //验证表单
        $("#loginForm").validate({
            rules: {
                type_id: {
                    required: true
                },
                tel_no: {
                    required: true,
                    rangelength: [11, 11],
                },
                validate_code: {
                    required: false,
                    rangelength: [6, 6],
                },
                email: {
                    required: false,
                    email: true
                },
                password: {
                    required: true,
                    rangelength: [6, 16],
                },
                checkbox: {required: true}
            },
            messages: {
                type_id: {
                    required: "请选择你的身份"
                },
                tel_no: {
                    required: "请输入常用手机号码",
                    rangelength: "请输入手机号码,用于登录使用"
                },
                validate_code: {
                    required: "请输入验证码",
                    rangelength: "请输入手机收到6位验证码"
                },
                email: {
                    required: "请输入常用邮箱地址",
                    email: "请输入有效的邮箱地址，用户接受简历或者职位邀请"
                },
                password: {
                    required: "请输入密码",
                    rangelength: "请输入6-16位非纯数字密码，字母区分大小写"
                },
                checkbox: {
                    required: "请接受招徕网用户协议"
                }
            },
            errorPlacement: function (label, element) {
                if (element.attr("type_id") == "radio") {
                    label.insertAfter($(element).parents('ul')).css('marginTop', '-20px');
                } else if (element.attr("type_id") == "checkbox") {
                    label.insertAfter($(element).parent()).css('clear', 'left');
                } else {
                    label.insertAfter(element);
                }
            },
            submitHandler: function (form) {
                toRegister();
            }
        });




        var $getCode = $('#validateCodeBtn');
        var $mobile = $("#tel_no");

        $getCode.bind("click", function () {
            var mobile = $mobile.val();
            if (mobile == null || mobile == "") {
                var html = '<span for="tel_no" id="tel_no_error" generated="true" class="error">请输入手机号码,用于登录使用</span>';
                showVcodeErr($mobile, html);
                return;
            } else {
                $("#tel_no_error").remove();
            }
            $getCode.removeClass("validateCodeBtn").addClass("btn_disabled")
            $getCode.attr("disabled", "true");
            $getCode.val("60秒后可以重发");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
            var mobile = {mobile: mobile};
            //向后台发送处理数据
            $.addCnfwsy(gvc_url, mobile, succv, failv);
        });

        function succv(item) {
            console.info("成功获取验证码");
        }

        function failv(err) {
            $('#beError').text("获取验证码失败，请稍后再试").show();
            $("#loginForm").find(":submit").attr("disabled", false);
        }


        function restTimeCountDown($el) {
            var startTime = $el.val();
            if (startTime > 0) {
                $el.val(--startTime);
                setTimeout(function () {
                    restTimeCountDown($el);
                }, 1000);
            }
        }

        var InterValObj; //timer变量，控制时间
        var curCount = 60;//当前剩余秒数
        var code = ""; //验证码

        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $getCode.removeAttr("disabled");//启用按钮
                $getCode.val("获取验证码");
                $getCode.removeClass("btn_disabled").addClass("validateCodeBtn");
                curCount = 60
                code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
            }
            else {
                curCount--;
                $getCode.val(curCount + "秒后可以重发");
            }
        }
    });

    function loginSucc(result) {
        window.location.href = lr_loginhtml_url;
    }

    function loginFail(msg) {
        $('#beError').text(msg).show();
        $("#loginForm").find(":submit").attr("disabled", false);
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
                    if (data && (data.status === "success")) {
//                        $(document.body).html('<h2>验证成功 </h2><a href="/index.html">返回主页</a>');
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
