/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";
    //方法扩展
    $.extend({
        auth_img_check: auth_img_check
    });

    /**
     * 方法扩展
     */
    function auth_img_check(_this) {
        $.picUpload(_this, upload_url, updataSuccess, uploadFail);
    }


    function showAndUpdateInfo(file_id, image_path, img_url, callback) {
        $("#file_id").val(file_id);
        $("#company_licence_url").val(image_path);
        $("#licenceNoShow img").attr("src", img_url);
        $("#licenceNoNo").hide();
        $("#licenceNoShow").show();
        $("#licence_error").hide();
        callback();
    }

    function updateRecordStatus(file_id) {
        var company = {file_id: file_id};
        $.updateCnfwsy("/to_auth", company, function () {
            window.location.href = "/auth_success";
        }, _c1fail);
    }

    function _c1fail() {
        $("#licence_error").text("上传失败，请重新上传").show();
    }

    function updataSuccess(data) {
        var img_url = data.file_path + "/" + data.new_file_name;
        var file_id = data.file_id;
        var image_path = img_url;
        "" != img_url ? showAndUpdateInfo(file_id, image_path, img_url, function () {
            updateRecordStatus(file_id);
        }) : _c1fail();
    }


    function uploadFail(msg) {
        errorTips("只支持jpg、jpeg、gif、png格式，文件小于2M", "错误提示");
    }


}(jQuery || {}));
