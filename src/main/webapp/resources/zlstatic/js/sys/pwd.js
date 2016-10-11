/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";
    //方法扩展
    $(function () {
        $("#uppwd").on({
            click: function () {
                var password = $("#password").val();
                var passwordnew = $("#passwordnew").val();
                var passwordnewrepeat = $("#passwordnewrepeat").val();
                if (null == password) {
                    $('#beError').text("输入密码").show();
                    return;
                }
                if (passwordnew != passwordnewrepeat) {
                    $('#beError').text("两次新密码不相同").show();
                    return;
                }
                var account = {password: password, passwordnew: passwordnew};
                $.updateCnfwsy("/upwd", account, function () {
                    $.showmsg("密码修改成功!");
                    $.logout();

                });
            }
        });
    })
}(jQuery || {}));
