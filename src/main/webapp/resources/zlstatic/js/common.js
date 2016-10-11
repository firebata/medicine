/**
 * Created by zhangjh on 16/6/10.
 */
var ACCOUNT_TYPE_COMMPANY = "1";
(function ($) {
    "use strict";

    //扩展常用方法
    $.extend({
        // basepath: getContextPath,
        addCnfwsy: addCnfwsy,
        delCnfwsy: delCnfwsy,
        updateCnfwsy: updateCnfwsy,
        infoCnfwsy: infoCnfwsy,
        listCnfwsy: listCnfwsy,
        op_sucess_code: "000000",
        not_finish_resume:"300002",
        objIsEmpty: objIsEmpty,
        picUpload: picUpload,
        deal_usrinfo_div: deal_usrinfo_div,
        getUsrId: getUsrId,
        showmsg: showmsg,
        logout: logout,
        pagesReolad: pagesReolad,
        usr_type: usr_type,
        isEnt: isEnt
    });

    /**
     *将表单值序列化为对象
     */
    $.fn.extend({
        serializeJson: serializeJson
    });

    //
    // function getContextPath() {
    //     var result = "";
    //     if ("spe" != environment_current) {
    //         var pathName = document.location.pathname;
    //         var index = pathName.substr(1).indexOf("/");
    //         result = pathName.substr(0, index + 1);
    //     }
    //     return result;
    // }

    /**
     * 新增
     * @param _url
     * @param _data
     * @param _async
     * @param _done 成功函数
     * @param _fail 失败回调函数
     * @param _type
     */
    function addCnfwsy(_url, _data, _done, _fail, _type, _async) {
        var type = objIsEmpty(_type) ? 'POST' : _type;
        var sf = objIsEmpty(_done) ? dodone : _done;
        var ef = objIsEmpty(_fail) ? doNotdone : _fail;
        var async = objIsEmpty(_async) ? true : _async;
        $.ajax({
            url: _url,
            data: JSON.stringify(_data),
            type: type,
            headers: {
                "X-Token": $.cookie("X-Token")
            },
            async: async,
            contentType: "application/json",
            dataType: "json"
        }).done(function (result, status, xhr) {
            if (result.header.rtn_code == "100006") {
                window.location.href = "/login.html";
            }
            else if (result.header.rtn_code == "300001") {
                $.showmsg(result.header.rtn_msg)
            } else {
                var data = result.data;
                sf(data, status, xhr);
            }
        }).fail(function (result) {
            var responseText = JSON.parse(result.responseText);
            var rtn_msg = responseText.header.rtn_msg;
            ef(rtn_msg);
        });
    }

    /**
     * 删除
     * @param _url
     * @param _data
     * @param _async
     * @param _done 成功函数
     * @param _fail 失败回调函数
     * @param _type
     */
    function delCnfwsy(_url, _data, _done, _fail, _type, _async) {
        var type = objIsEmpty(_type) ? 'DELETE' : _type;
        var sf = objIsEmpty(_done) ? dodone : _done;
        var ef = objIsEmpty(_fail) ? doNotdone : _fail;
        var async = objIsEmpty(_async) ? true : _async;
        $.ajax({
            url: _url,
            data: _data,
            headers: {
                "X-Token": $.cookie("X-Token")
            },
            type: type,
            async: async,
            dataType: "json"
        }).done(function (result) {
            var data = result.data;
            sf(data);
        }).fail(function (result) {
            var responseText = JSON.parse(result.responseText);
            var rtn_msg = responseText.header.rtn_msg;
            var rtn_code = responseText.header.rtn_code;
            ef(rtn_msg,rtn_code);
        });
    }

    /**
     * 更新
     * @param _url
     * @param _data
     * @param _async
     * @param _done 成功函数
     * @param _fail 失败回调函数
     * @param _type
     */
    function updateCnfwsy(_url, _data, _done, _fail, _type, _async) {
        var type = objIsEmpty(_type) ? 'PUT' : _type;
        var sf = objIsEmpty(_done) ? dodone : _done;
        var ef = objIsEmpty(_fail) ? doNotdone : _fail;
        var async = objIsEmpty(_async) ? true : _async;
        $.ajax({
            url: _url,
            data: JSON.stringify(_data),
            type: type,
            async: async,
            headers: {
                "X-Token": $.cookie("X-Token")
            },
            contentType: "application/json",
            dataType: "json"
        }).done(function (result) {
            var data = result.data;
            sf(data);
        }).fail(function (result) {
            var responseText = JSON.parse(result.responseText);
            var rtn_msg = responseText.header.rtn_msg;
            var rtn_code = responseText.header.rtn_code;
            ef(rtn_msg,rtn_code);
        });
    }

    /**
     * 查询列表
     * @param _url
     * @param _data
     * @param _done 成功函数
     * @param _fail 失败回调函数
     * @param _type
     * @param _async
     */
    function listCnfwsy(_url, _data, _done, _fail, _type, _async) {
        var type = objIsEmpty(_type) ? 'POST' : _type;
        var sf = objIsEmpty(_done) ? dodone : _done;
        var ef = objIsEmpty(_fail) ? doNotdone : _fail;
        var async = objIsEmpty(_async) ? true : _async;
        $.ajax({
            url: _url,
            data: JSON.stringify(_data),
            type: type,
            async: async,
            headers: {
                "X-Token": $.cookie("X-Token")
            },
            contentType: "application/json",
            dataType: "json"
        }).done(function (result) {
            var data = result.data;
            sf(data);
        }).fail(function (result) {
            var responseText = JSON.parse(result.responseText);
            var rtn_msg = responseText.header.rtn_msg;
            var rtn_code = responseText.header.rtn_code;
            ef(rtn_msg,rtn_code);
        });
    }

    /**
     * 查询详细
     * @param _url
     * @param _data
     * @param _done 成功函数
     * @param _fail 失败回调函数
     * @param _type
     * @param _async
     */
    function infoCnfwsy(_url, _data, _done, _fail, _type, _async) {
        var type = objIsEmpty(_type) ? 'GET' : _type;
        var sf = objIsEmpty(_done) ? dodone : _done;
        var ef = objIsEmpty(_fail) ? doNotdone : _fail;
        var async = objIsEmpty(_async) ? true : _async;
        $.ajax({
            url: _url,
            data: _data,
            type: type,
            headers: {
                "X-Token": $.cookie("X-Token")
            },
            async: async
        }).done(function (result) {
            var data = result.data;
            sf(data);
        }).fail(function (result) {
            var responseText = JSON.parse(result.responseText);
            var rtn_msg = responseText.header.rtn_msg;
            var rtn_code = responseText.header.rtn_code;
            ef(rtn_msg,rtn_code);
        });
    }


    /*bootbox.setLocale("zh_CN");*/
    var doNotdone = function (msg, code) {
        //console.fail(XMLHttpRequest);
        console.fail("本次操作失败.");
        showmsg("本次操作失败,错误码：" + code);
    }

    var dodone = function (XMLHttpRequest, textStatus, failThrown) {
        console.info("本次操作成功.");
        //bootbox.alert(XMLHttpRequest);
        showmsg("本次操作成功");
    }

    /**
     * 校验对象为空
     * @param input 字符串
     * @returns {boolean}
     */
    function objIsEmpty(input) {
        return input == null || $.trim(input) == '';
    }


    /**
     *
     * @returns {{}}
     */
    function serializeJson() {
        var serializeObj = {};
        var array = this.serializeArray();
        // var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };


    /**
     * 图片上传
     * @param _this
     * @param _url
     * @param _done
     * @param fail
     */
    function picUpload(_this, _url, _done, _fail) {

        var $this = $(_this);
        var inputId = $this.attr('id');
        var hint = $this.attr('title');

        var dataType = 'json';
        var params = {};
        this.allowSuffix = '.jpg,.gif,.jpeg,.png';
        this.fileSuffix = $this.val().substr($this.val().lastIndexOf(".")).toLowerCase();
        if (this.allowSuffix != 0 && this.allowSuffix.indexOf(this.fileSuffix) == -1)//文件格式
        {
            errorTips(hint);
            $("input[type = 'file']").val("");
        } else {
            $.ajaxFileUpload({
                url: _url,
                secureuri: false,
                fileElementId: inputId,
                data: params,
                dataType: dataType,
                success: function (result) {
                    var _data = result.data;
                    _done && _done(_data, inputId);
                },
                error: function (data) {
                    _fail && _fail(data);
                    errorTips("支持jpg、jpeg、gif、png格式，文件小于10M", "错误提示");
                }
            });
        }

    }

    /**
     *
     */
    $(function () {
        deal_usrinfo_div();
        listnerLogout();
    })


    /**
     *用户信息显示
     */
    function deal_usrinfo_div() {
        var usrStr = $.cookie("cusr");
        if (null != usrStr) {
            var usr = JSON.parse(usrStr);
            var type_id = usr.type_id;
            var cur_collapsible_menu_ = "#collapsible_menu_" + type_id;
            $(cur_collapsible_menu_).show();
            $(cur_collapsible_menu_).siblings(".collapsible_menu").hide();
            $("#loginTopId").hide();
            var name = null == usr.name ? usr.tel_no : usr.name + "&nbsp;";
            $(cur_collapsible_menu_ + ">dt>span").eq(0).html(name);
            console.info("usrname:" + name);
        } else {

        }

    }

    /**
     *
     * @returns {*}
     */
    function usr_type() {
        var usrStr = $.cookie("cusr");
        var type_id = null;
        if (null != usrStr) {
            var usr = JSON.parse(usrStr);
            type_id = usr.type_id;
        }

        return type_id;
    }

    /**
     *
     * @returns {boolean}
     */
    function isEnt() {
        var type_id = usr_type();
        return type_id == ACCOUNT_TYPE_COMMPANY;
    }

    /**
     *
     */
    function logout() {
        var usrStr = $.cookie("cusr");
        $("dl[id^=collapsible_menu_]").hide();
        $("#loginTopId").show();
        if (usrStr != null) {
            var usr = JSON.parse(usrStr);
            var urid = usr.account_id;
            $.cookie("cusr", null);
            delCnfwsy("/loginout/" + urid, function () {
                window.location.href = "/index.html";
            }, function () {
                window.location.href = "/index.html";
            });
        }
        else {
            window.location.href = "/index.html";
        }
    }

    /**
     * 登出
     */
    function listnerLogout() {
        $(".logout").on({
            click: function () {
                logout();
            }
        });
    }

    /**
     * urid
     * @returns {*}
     */
    function getUsrId() {
        var usrStr = $.cookie("cusr");
        var urid = null;
        if (usrStr != null) {
            var usr = JSON.parse(usrStr);
            urid = usr.account_id;
        }
        return urid;
    }


    function showmsg(msg) {
        var c = $(".showmsg").attr("class");
        if (c == 'showmsg') {
            $(".showmsg").fadeIn(100);
            $(".showmsg>span").text(msg);
        } else {
            var htm = '<div class="showmsg"><span>' + msg + '</span></div>';
            $("body").append(htm);
            $(".showmsg").fadeIn(100);
        }
        setTimeout(function () {
            $(".showmsg").fadeOut(100);
        }, 1500);
    }



    function _fail(rtn_msg) {
        showmsg(rtn_msg);
    }



    function _done(data) {
        showmsg("成功申请职位！");
    }

    /**
     * 分页
     */
    function pagesReolad(no, data, statusId) {
        $(".list_total").text(data.all_record_count);
        $("#list_count").text(data.all_record_count);
        $(".page_total").text(data.page_count);
        if (data.page_count > 1) {
            $(".pages").css("display", "block");
        }

        $(".pages span").unbind("click");
        $(".pages span").addClass("disable");

        if (no > 1) {
            $("span.first").bind("click", function () {
                mp.listLoad(1, statusId);
                return false;
            });
            $("span.first").removeClass("disable");
            $("span.prev").bind("click", function () {
                mp.listLoad(no - 1, statusId);
                return false;
            });
            $("span.prev").removeClass("disable");
        }

        if (no < data.page_count) {
            $("span.last").bind("click", function () {
                mp.listLoad(data.page_count, statusId);
                return false;
            });
            $("span.last").removeClass("disable");
            $("span.next").bind("click", function () {
                mp.listLoad(no + 1, statusId);
                return false;
            });
            $("span.next").removeClass("disable");
        }
    }
}(jQuery || {}));