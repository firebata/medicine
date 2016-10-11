/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";
    //方法扩展
    $.extend({
        img_check_com_log: img_check
    });

    //实例化编辑器
    var um = UM.getEditor('myEditor', {
        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo'],
            ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
        ],
        autoHeightEnabled: true,
        autoFloatEnabled: true

    });

    $(function () {
        $("#province_id").on({
            change: provinceIdChange
        })
        $("#formSubmit").on({
            click: formSubmitClick
        })


    })

    function provinceIdChange() {
        var provinceId = $("#province_id").val();
        $.infoCnfwsy("/qCitysByPid/" + provinceId, {}, function (items) {
            $("#city_id option").remove();
            $("#city_id").empty();
            $("#city_id").append("<option value=''>--请选择--</option>");
            $.each(items, function (key, value) {
                $("#city_id").append("<option value='" + key + "'>" + value + "</option>");
            });
        })
    }


    function formSubmitClick() {
        var company = $('#jobForm').serializeJson();
        var url = "/entCompany/";
        company.editor_value = company.editorValue;
        delete company.editorValue;
        var company_type_name = $("#company_type_id").find("option:selected").text();
        var company_size_name = $("#company_size_id").find("option:selected").text();
        var industry_name = $("#industry_id").find("option:selected").text();
        var industry_name2 = $("#industry_id2").find("option:selected").text();
        var province_name = $("#province_id").find("option:selected").text();
        var city_name = $("#city_id").find("option:selected").text();
        company.company_type_name = company_type_name;
        company.company_size_name = company_size_name;
        company.industry_name = industry_name;
        company.industry_name2 = industry_name2;
        company.province_name = province_name;
        company.city_name = city_name;
        $.updateCnfwsy(url + company.company_id, company, _c1sucess, _c1fail);
    }

    function _c1fail(e) {
        alert("保存失败:" + e);
    }

    function _c1sucess(data) {
        window.location.href = "/issue";
    }

    function img_check(_this) {
        $.picUpload(_this, upload_url, updataSuccess, uploadFail);
    }

    function updataSuccess(data) {
        var img_url = data.file_path + "/" + data.new_file_name;
        var file_id = data.file_id;
        var image_path = img_url;
        "" != img_url ? ($("#file_id").val(file_id), $("#company_logo_url").val(image_path), $("#logoShow img").attr("src", img_url), $("#logoNo").hide(), $("#logoShow").show(), $("#logo_error").hide()) : $("#logo_error").text("上传失败，请重新上传").show();
    }

    function uploadFail(msg) {
        errorTips("只支持jpg、jpeg、gif、png格式，文件小于2M", "错误提示");
    }

}(jQuery || {}));

