/**
 *公司相关操作
 * Created by zhangjh on 16/6/6.
 */
(function ($) {

    "use strict";
    //扩展常用方法
    $.extend({
        listCompany: listCompany,
        saveCompany: saveCompany,
        delCompany: delCompany,
        infoCompany: infoCompany,
        updateCompany: updateCompany,
        saveCompanyBaseInfo: saveCompanyBaseInfo
    });

    /**
     *
     */
    function listCompany(qrBody, callback) {
        callback();
    }


    /**
     * 不同页面的保存按钮
     */
    function saveCompany(step) {
        if (step == 1) {
            saveCompanyBaseInfo();
        }
        else if (step == 2) {
            saveCompanyLabels();
        }
        else if (step == 3) {
            saveLeaderInfos();
        }
        else if (step == 4) {
            saveProductInfos();
        }
        else if (step == 5) {
            saveProfile();
        }

    }

    /**
     *
     */
    function delCompany(bid, callback) {
        callback();
    }

    /**
     *
     */
    function infoCompany(bid, callback) {
        callback();
    }

    /**
     *
     */
    function updateCompany(upBody, callback) {
        callback();
    }


    /**
     * 基本信息
     */
    function saveCompanyBaseInfo() {
        // var a, company_id, company_name, name, image_path, website, city_name, i, scale_name, k, l, m, n, temptation;
        // a = !0;
        // company_id = $("#company_id").val();
        // company_name = $("#company_name").val();
        // name = $("#name").val();
        // image_path = $("#image_path").val();
        // website = $("#website").val();
        // city_name = $("#city").val();
        // var scaleId = $("#scaleId").val();
        // scale_name = $("#scale_name").val();
        // temptation = $("#temptation").val();
        // var city_id = $("#city_id").val();
        //
        // var company = {
        //     company_id: company_id,
        //     name: name,//简称
        //     image_path: image_path,
        //     website: website,
        //     city_id: city_id,
        //     city_name: city_name,
        //     scale_id: scaleId,
        //     scale_name: scale_name,
        //     temptation: temptation
        // };
        var company = $('#baseForm').serializeJson();
        var url = comcurd;
        $.updateCnfwsy(url + company.company_id, company, _c1done, _c1fail);
    };

    /**
     *保存公司标签
     */
    function saveCompanyLabels() {
        var a = [],
            b = $("#company_id").val();
        $("#labels li").each(function () {
            a.push($(this).children("span").text())
        });
        var labels = a.join();
        if (!$.objIsEmpty(labels)) {
            var company = {company_id: b, company_label_names: labels};
            var url = comcurd;
            $.updateCnfwsy(url + b, company, _c2done, _c2fail);
        }
        else {
            alert("未选择标签");
        }


    }

    /**
     *保存公司创始人信息
     */
    function saveLeaderInfos() {
        var data3 = $('#memberForm').serializeJson();
        var company = {
            company_id: data3.company_id,
            leader_infos: []
        }
        var size = company.leader_infos.length;
        $.each(data3, function (name, value) {
            if (name.indexOf("leaderInfos") != -1) {
                var index = name.substr(12, 1);//第几个创始人
                if ($.objIsEmpty(company.leader_infos[index])) {
                    company.leader_infos[index] = {};
                }
                company.leader_infos[index].company_id = data3.company_id;
                var _name = name.substr(15)//leaderInfos[0].的长度
                company.leader_infos[index][_name] = value;
            }
        });

        $.addCnfwsy(leadercurd_url + data3.company_id, company, _c3done, _c3fail);
    }

    /**
     * 保存公司产品信息
     */
    function saveProductInfos() {
        var data3 = $('#productForm').serializeJson();
        var company = {
            company_id: data3.company_id,
            product_infos: []
        }
        var size = company.product_infos.length;
        $.each(data3, function (name, value) {
            if (name.indexOf("productInfos") != -1) {
                var index = name.substr(13, 1);//第几个产品
                if ($.objIsEmpty(company.product_infos[index])) {
                    company.product_infos[index] = {};
                }
//                company.product_infos[index].company_id = data3.company_id;
                var _name = name.substr(16)//productInfos[0].的长度
                company.product_infos[index][_name] = value;
            }
        });
        $.addCnfwsy(productcurd_url + data3.company_id, company, _c4done, _c4fail);
    }

    /**
     * 保存公司介绍
     */
    function saveProfile() {
        var data3 = $('#infoForm').serializeJson();
        var company ={ company_id: data3.company_id,profile: data3}
        $.addCnfwsy(profilecurd_url + company.company_id, company, _c5done, _c5fail);
    }

    function _c5done(data) {
        window.location.href = com_home;
    }

    function _c5fail(data) {
        alert("保存失败");
    }

    function _c4done(data) {
        window.location.href = com_c5_url;
    }

    function _c4fail(data) {
        alert("保存失败");
    }


    function _c3done(data) {
        window.location.href = com_c4_url;
    }

    function _c3fail(data) {
        alert("保存失败");
    }

    function _c2done(data) {
        window.location.href = com_c3_url;
    }

    function _c2fail(data) {
        alert("保存失败");
    }

    function _c1done(data) {
        window.location.href = com_c2_url;
    }

    function _c1fail(rtn_msg) {
        $("#beError").text(rtn_msg).show(), $(b).find(":submit").attr("disabled", !1);
    }


    $(function () {

        $("#step2Submit").on("click", function () {
            saveCompanyLabels();
        });
    });


}(jQuery || {}));