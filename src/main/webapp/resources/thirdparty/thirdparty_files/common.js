   /*
     * 名称：表单内，checkbox全选动作
     * 说明：点击全选前的checkbox，全选指定name=参数名的input[type=checkbox].checked=true
     * 参数：
     *      docheck：全选前的checkbox对象，判断其是否checked，来实现全选或者全不选【this】
     *      checkname：欲应用全选的checkbox元素组的统一name 【字符串】
     * 调用：zlzpUtils.checkAll(this,'checklist');
     * 作者：chris.cai
     */
  var zlzpUtils={};
   zlzpUtils.checkAll = function(docheck,checkname) {
   var _form = $(docheck).closest('form'),
    _checks = $('input[name='+checkname+']',_form);
    _checks.attr('checked',docheck.checked);

 };
 

/*--------------------------------------------------验证---------------------------------------------------*/
var tagNo = 1000;
function createErrTag(obj, msg, parent, btn){
  var tag = getErrTag(obj, parent);
  var pos = obj;
  parent = parent || 0;
  if (!tag){
    tag = $("<div id=\"tip-x-validate-"+(tagNo++)+"\" class=\"tip-x-validate-error\">"+msg+"</div>");    
    for (var i=0; i < parent; i++){
      pos = pos.parent();
    }
    tag.css({left: pos.offset().left, top: pos.offset().top});
    pos.after(tag);
    obj.bind("click", function(){
      if (obj[0].tagName.toLowerCase() === "input" && obj[0].type.toLowerCase() === "radio"){
        tag.show();
        for (var i=0; i<obj.length; i++){
          if (obj[i].checked){
            tag.hide();
          }
        }
      } else {
        tag.hide();
        obj.removeClass("input-x-validate-error");
      }
    });
    if (btn){
      btn.bind("click",function(){
        tag.hide();
        obj.removeClass("input-x-validate-error");
      });
    }
  } else {
	if (msg){
		tag.html(msg);
	}
    tag.show();
  }
  if (obj[0].tagName.toLowerCase() !== "input" || obj[0].type.toLowerCase() === "text" || obj[0].type.toLowerCase() === "textarea"){    
    obj.addClass("input-x-validate-error");
  }
  return tag; 
}
function getErrTag(obj, parent){
  var pos = obj;
  parent = parent || 0;
  for (var i=0; i < parent; i++){
    pos = pos.parent();
  }
  pos = pos.next("div");
  if (pos.hasClass("tip-x-validate-error")){
    return pos;
  } else {
    return null;
  }
}