/**
 * Created by lindaquan on 16/7/3.
 */

var companyId;
var pageSize=10;

//页面加载后执行
$(function () {
    var online = eval($("#online").val());
    mp.listLoad(1,online);
    $("#online_pt").bind("click",function(){mp.listLoad(1,1);return false;});
    $("#offline_pt").bind("click",function(){mp.listLoad(1,0);return false;});
});


var mp = {

    //职位加载
    listLoad : function (no, statusId) {
        $("dd").removeClass("current");
        if(statusId){
            $("#online_pt").parent().addClass("current");
        }else {
            $("#offline_pt").parent().addClass("current");
        }
        var companyId = $("#company_id").val();
        $.listCnfwsy(jobl, {'company_id':companyId,'online':statusId,"page_size":pageSize,"page_no":no}, function (data) {

            var content = $("#searchForm .my_jobs");
            content.html("");
            var stext = '<em></em>';
            stext += statusId==1?'有效职位':'已下线职位';
            stext += ' <span>（共<i style="color:#fff;font-style:normal" id="positionNumber">'+data.all_record_count+'</i>个）</span>';
            $("#statusName").html(stext);
            if((data.items.length)==0){

            }else {

                var e ="";
                var refresh = statusId==1?'刷新':'';
                var statusText = statusId==1?'下线':'上线';
                (data.items).forEach(function(eachItem){
                    e = '<li data-id="' + eachItem.job_id + '"><h3><a target="_blank" title="';
                    e += eachItem.job_name + '" href="' + job_detail + eachItem.job_id + '">' + eachItem.job_name + '</a><span>[';
                    e += eachItem.city_name + ']</span></h3><span class="receivedResumeNo"><a href="' + eachItem.job_id + '">应聘简历（0）</a></span>';
                    e += '<div>' + eachItem.job_nature_name 
                        + ' / '+ eachItem.payroll + ' / ' + eachItem.experience_name + ' / ' + eachItem.education_name + '及以上</div>';
                    e += '<div class="c9">发布时间： ' + eachItem.publish_date + '</div> <div class="links"><a class="job_refresh" href="javascript:void(0)">'+refresh+'<span>每个职位7天内只能刷新一次</span></a>';
                    e += '<a target="_blank" class="job_edit" href="/edit/' + eachItem.job_id + '">编辑</a><a class="job_offline" href="javascript:void(0)">'+statusText+'</a>';
                    e += '<a class="job_del" href="javascript:void(0)">删除</a> </div> </li>';
                    content.append(e);
                });

                init(statusId);
                $.pagesReolad(no, data, statusId);
            }

        }, _fail);
    },

    //更新
    positionUpdate : function (a, key, value) {
        var job;
        job={
            job_id:a
        }
        if(key=='publish_date'){
            job['publish_date']='1';
        };
        if(key=='online'){
            job['online']=value;
        }
        if(key=='del_flag'){
            job['del_flag']=value;
        }
        $.updateCnfwsy(jobcurd+'/'+a, job, _done, _fail);
        
    }

}

function init(online) {
    $(".job_refresh").bind("click",function(){var a;
        a=$(this).parents("li").attr("data-id"); mp.positionUpdate(a,'publish_date','');mp.listLoad(1,online);return false;});
    $(".job_offline").bind("click",function(){
        var a,b;
        a=$(this).parents("li").attr("data-id");
        if(online==1){
            b=0;
        }
        if(online==0){
            b=1;
        }
        mp.positionUpdate(a,'online',b);mp.listLoad(1,online);return false;});
    $(".job_del").bind("click",function(){var a;
        a=$(this).parents("li").attr("data-id"); mp.positionUpdate(a,'del_flag','1');mp.listLoad(1,online);return false;});
}

function _done() {
    $.showmsg("更新成功!");
}

function _fail(rtn_msg) {
    $.showmsg(rtn_msg);
}


