/**
 * Created by lindaquan on 16/8/28.
 */
var job_list_tpl;
var companyId;
var pageSize=10;

//页面加载后执行
$(function () {
    companyId = $("#company_id").val();
    //用jquery获取模板
    job_list_tpl  =  $("#job_list_template").html();
    mp.listLoad(1);
});


var mp = {
    //加载
    listLoad : function (no) {
        var jl={
            'company_id':companyId,
            "page_size":pageSize,
            "page_no":no
        };

        $.listCnfwsy(jobl, jl, function (data) {
            console.info(data);

            //预编译模板
            var job_list = Handlebars.compile(job_list_tpl);
            //匹配json内容
            var job_list_data = {"job_list":data.items};
            var job_list_html = job_list(job_list_data);
            //输入模板
            $('.item_con_list').html(job_list_html);

            $.pagesReolad(no, data);

        }, _fail);
    }

}

function _fail(rtn_msg) {
    $.showmsg(rtn_msg);
}

