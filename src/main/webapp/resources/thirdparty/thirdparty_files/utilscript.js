//Browsercheck
var w3c=(document.getElementById)?true:false;
var ie=document.all?1:0;
var ie4=(document.all && !w3c)?true:false;
var ie5=(document.all && w3c)?true:false;
var ns4=document.layers?1:0;
var ns6=document.getElementById&&!document.all?1:0;


var tipSwitchStandardName="12007036abeyond";
//我已经知道了，以后不用自动弹出了！
function setTipSwitch(nickname,switchCK){
  var val="on";
  var name=nickname+tipSwitchStandardName;
  if(switchCK.checked)
    val="off";
  
  var the_date = new Date("December 31, 2023");
  var the_cookie_date =the_date.toGMTString();

  var the_cookie = name+ "=" + val + ";" ;
  the_cookie+="path=/;";
  the_cookie+="expires=" + the_cookie_date;
  document.cookie =the_cookie;
}
function getTipSwitch(nickname){
  var name=nickname+tipSwitchStandardName;
  var start = document.cookie.indexOf(name+"=");
  var len = start+name.length+1;
  if ((!start) && (name != document.cookie.substring(0,name.length))) return null;
  if (start == -1) return null;
  var end = document.cookie.indexOf(";",len);
  if (end == -1) end = document.cookie.length;
  return unescape(document.cookie.substring(len,end)); 
}


//check form data
function checkFormTxtItem(name){
 if(AllTrim(name.value) == "" )
    return false;
 else
    return true;
}

function checkFormLisItem(name){
 //if(name.options.value == "" || name.options.value == "-1")
 if(!name.options.length)
    return false;
 else
    return true;
}

function checkFormItemLength(name, len){
  if(name.value.length != len)
    return false;
 else
    return true;
}

function checkFormItemLengthNotNull(name, len){
  if(!checkFormTxtItem(name)) return false;
  return checkFormItemLength(name, len);
}

function checkFormIsEmail(name,required){
  var strEmail = AllTrim(name.value);
  if(strEmail==''&&required) {alert("电子邮件地址必须填写！");setFocus(name);return false;}
  if(strEmail==''&&!required) return true;
  if(strEmail.indexOf("@") < 1 || strEmail.indexOf(".") < 1 || strEmail.indexOf("@") != strEmail.lastIndexOf("@") || strEmail.lastIndexOf(".") <= strEmail.indexOf("@")){
      alert("电子邮件地址填写错误！");
	  setFocus( name );
	  return false;
  }
  return true;
}

function checkFormIsNumber(a){
  var myEvent = a?a:window.event;
  if(window.event) //IE
  if(myEvent.keyCode<48 || myEvent.keyCode>58){
    alert("此项只允许输入数字'0-9'。");
    return false;
  }
  if(a) //NS
  if(myEvent.keyCode != 8 && myEvent.keyCode != 13 && myEvent.keyCode != 46 && myEvent.keyCode != 37 && myEvent.keyCode != 39 && myEvent.keyCode != 9)
  if(myEvent.charCode<48 || myEvent.charCode>58){
    alert("此项只允许输入数字'0-9'。");
    return false;
  }
  return true;
}

function checkFormIsNumberWithSpace(a){
	var myEvent = a?a:window.event;
	if(window.event) //IE
  if((myEvent.keyCode<48 || myEvent.keyCode>58) && !(myEvent.keyCode==45) && !(myEvent.keyCode==32)){
    alert("此项只允许输入数字'0-9'、'空格'或'-'。");
    return false;
  }
  if(a) //NS
  if(myEvent.keyCode != 8 && myEvent.keyCode != 13 && myEvent.keyCode != 46 && myEvent.keyCode != 37 && myEvent.keyCode != 39 && myEvent.keyCode != 9)
  if((myEvent.charCode<48 || myEvent.charCode>58) && !(myEvent.charCode==45) && !(myEvent.charCode==32)){
    alert("此项只允许输入数字'0-9'、'空格'或'-'。");
    return false;
  }
  return true;
}

function checkFormIsIncludingQuotation(a){
	var myEvent = a?a:window.event;
	if(window.event) //IE
  if(myEvent.keyCode==39 || myEvent.keyCode==34){
    alert("这里不允许输入英文单引号和双引号!");
    return false;
  }
  if(a) //NS
  if(myEvent.keyCode != 8 && myEvent.keyCode != 13 && myEvent.keyCode != 46 && myEvent.keyCode != 37 && myEvent.keyCode != 39 && myEvent.keyCode != 9)
  if(myEvent.charCode==39 || myEvent.charCode==34){
    alert("这里不允许输入英文单引号和双引号!");
    return false;
  }
  return true;
}

function checkFormIsIncludingSpecial(a){
	var myEvent = a?a:window.event;
	if(window.event) //IE
  if(myEvent.keyCode==39 || myEvent.keyCode==34 || myEvent.keyCode==38){
    alert("这里不允许输入英文单引号、双引号，及&符号!");
    return false;
  }
  if(a) //NS
  if(myEvent.keyCode != 8 && myEvent.keyCode != 13 && myEvent.keyCode != 46 && myEvent.keyCode != 37 && myEvent.keyCode != 39 && myEvent.keyCode != 9)
  if(myEvent.charCode==39 || myEvent.charCode==34 || myEvent.keyCode==38){
    alert("这里不允许输入英文单引号、双引号，及&符号!");
    return false;
  }
  return true;
}

function StartDateAndEndDateCheck(sd_y,sd_m,ed_y,ed_m){//Year,Month
  if(sd_y.value!="-1" && ed_y.value!="-1"){//-1:Please select
     var enddate_mm=ed_m.value;
	 if(parseInt(enddate_mm)<10) enddate_mm="0" + enddate_mm;
	 var startdate_mm=sd_m.value;
	 if(parseInt(startdate_mm)<10) startdate_mm="0" + startdate_mm;  
	 if(parseInt(ed_y.value + enddate_mm) - parseInt(sd_y.value +startdate_mm) < 0){
			alert("截至日期不能比起始日期小！");
			ed_y.focus();
			return false;
	 }
  }
  return true;
}

function IsDigital(str){
 strRef = "1234567890";
 for (i=0;i<str.length;i++){
  tempChar= str.substring(i,i+1);
  if (strRef.indexOf(tempChar,0)==-1) 
    return false; 
  else {
    tempLen=str.indexOf(".");
    if(tempLen!=-1){
      strLen=str.substring(tempLen+1,str.length);
      if(strLen.length>2)
        return false; 
    }
  }
 }
 return true;
}


function AllTrim(str){
 if(str.charAt(0) == " "){
  str = str.slice(1);
  str = AllTrim(str);
 }
 return str;
}

function setFocus(item){
	item.focus();
}

function displaySpan(objCheckbox,spanId){
	 var objSpan = document.getElementById(spanId);
     if(objCheckbox && objSpan)
	    if(objCheckbox.checked) objSpan.style.display='';
		else objSpan.style.display='none';
}

function DateYearChange(d_y,d_m){//if Year='Please select',disable Month
  if(d_y!=null && d_y.value<="0")
    d_m.disabled=true;
  else if(d_m!=null)
    d_m.disabled=false;
}


function ChkSelectAll(chknameStr,chkallnameStr){
	var arrInput = document.getElementsByTagName('input');
	var arrCheckbox = [];
	var chkname = [];
	var chkallname;
	for(var j=0;j<arrInput.length;j++){
	    if(arrInput[j].type.toLowerCase()=='checkbox') arrCheckbox[arrCheckbox.length] = arrInput[j];
	}
	for(j=0;j<arrCheckbox.length;j++){
	    if(arrCheckbox[j].name==chknameStr) chkname[chkname.length] = arrCheckbox[j];
		else if(arrCheckbox[j].name==chkallnameStr) chkallname = arrCheckbox[j];
	}
	
	var length = chkname.length;   
    chkallname.checked = chkallname.checked|0;

    for (var i = 0; i < length; i++) if(!chkname[i].disabled) chkname[i].checked=chkallname.checked;            
}
function unChkSelectAll(chkallnameStr){
	var arrInput = document.getElementsByTagName('input');
	var arrCheckbox = [];
	var chkallname;
	for(var j=0;j<arrInput.length;j++){
	    if(arrInput[j].type.toLowerCase()=='checkbox') arrCheckbox[arrCheckbox.length] = arrInput[j];
	}
	for(j=0;j<arrCheckbox.length;j++){
		if(arrCheckbox[j].name==chkallnameStr) chkallname = arrCheckbox[j];
	}
	
	if(chkallname.checked) chkallname.checked = chkallname.checked&0;
}


function subStringPro(str, length) {
  var stri = '';
  for(i=0,j=0; j<length;) {
    if ((str.charCodeAt(i)>=0) && (str.charCodeAt(i)<=255)) {
      stri += str.charAt(i);
      j++;
    } else {
      stri += str.charAt(i);
      j += 2;
    }
    i++;
  }
  return stri;
}


//popup feedback
function openFeedback(strTarget){ 
	window.open(strTarget, "_blank",'width=1,height=1,left=100,top=60, scrollbars=0, overflow=auto, status=0');
}
//popup help
function openHelp(url){
    window.open(url,"","width=745,height=420,scrollbars=yes,resizable=yes");
}
function openPopup(url,windowname,w,h){
  var intTop = 0;
  var intLeft = 0;
  var winWidth = window.screen.availWidth-12;
  var winHeight = window.screen.availHeight-50;
  var scrollNorY='no';
  if(parseInt(h) == 8888){
	 //如果高度为8888,那么全屏显示
	 w=window.screen.availWidth-12;
	 h=window.screen.availHeight-50;}
  else{ //从中间呈现


		intTop = (window.screen.availHeight-parseInt(h))/2;
		intLeft = (window.screen.availWidth-parseInt(w))/2;
		if (intTop < 30)	intTop = 0;
		if (intLeft < 30)	intLeft = 0;}
  if(w > winWidth){
     w=winWidth;
	 scrollNorY='yes';
  }
  if(h > 699) scrollNorY='yes';
  if(h > winHeight){
     if(h==5555) scrollNorY='no';
	 else scrollNorY='yes';
	 h=winHeight;
  }
  var windowconfig = "status=no,scrollbars=" + scrollNorY + ",top="+ intTop +",left="+ intLeft  +",resizable=0,width=" + w + ",height=" + h;
  subwin=window.open(url, windowname, windowconfig);
  if(subwin){
	 subwin.focus();
	 return subwin;}
}


function GetRealLength(strTemp){
 var i,sum;
 sum=0;
 for(i=0;i<strTemp.length;i++)
 {
  if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))
   sum=sum+1;
  else
   sum=sum+2;
 }
 return sum;
}


function addPrefix(str,prefix){
     return prefix+str;
}

function trimPrefix(str,prefix){
	var tmpstr = str;
	var len = prefix.length;
	
	//alert("char code:"+tmpstr.charCodeAt(0));
	//alert(tmpstr.substring(0,len));
	if(tmpstr.substring(0,len) == prefix)
	//if(prefix.indexOf(tmpstr.substring(0,len)) != -1)
	{
		tmpstr = tmpstr.substr(len);
	}
	return tmpstr;
}

function trimPrefixIndent(str){
	//(2004-01-18,by Fred)space in Option.text is unicode 160
	var prefixIndent = String.fromCharCode(160,160)+"--";
	return trimPrefix(str,prefixIndent);
}


//获取表单元素的index值
function GetObjID(formName,ObjName){
  var objForm = eval('document.'+formName);
  if(objForm){
     for(var ObjID=0; ObjID < objForm.elements.length; ObjID++)
         if(objForm.elements[ObjID].name == ObjName){
		    return(ObjID);
            break;
         }
     return(-1);
  }
  else return(-1);
}


function jtrim(sstr){ //去掉头尾上的空格
	var astr=""; 
	var dstr=""; 
	var flag=0; 
	for(var i=0;i<sstr.length;i++){
	    if((sstr.charAt(i)!=' ')||(flag!=0)){
		   dstr+=sstr.charAt(i); 
		   flag=1; 
		} 
	} 
	flag=0; 
	for(i=dstr.length-1;i>=0;i--){
	    if((dstr.charAt(i)!=' ')||(flag!=0)){
		   astr+=dstr.charAt(i); 
		   flag=1; 
		} 
	} 
	dstr=""; 
	for(i=astr.length-1;i>=0;i--) dstr+=astr.charAt(i); 
	return dstr; 
}


function changeemail(){
	var objform = document.addvacancyForm;
	objform.email.value = objform.selEmail.options[objform.selEmail.selectedIndex].text;
	if(objform.selEmail.value==-1) objform.email.value='';
}
function addEmail(){
	var objform = document.addvacancyForm;
    strEmail = jtrim(objform.email.value);
	if(strEmail == "") {return true;}
    if(strEmail.charAt(0)=="." || strEmail.charAt(0)=="@"|| strEmail.indexOf("@",0)==-1 || strEmail.indexOf(".",0)==-1 || strEmail.lastIndexOf("@")==strEmail.length-1 || strEmail.lastIndexOf(".")==strEmail.length-1) {
	   alert("电子邮件地址填写错误！");
	   return true;
	}
	var intSelected = objform.emaillist.options.length;
	var intEmailValue = objform.selEmail.value;
    for(i=0; i<intSelected; i++){
		if (strEmail == objform.emaillist.options[i].text){alert(strEmail+'已添加！');return true;}
	}
	objform.emaillist.options.length++;
	objform.emaillist.options[objform.emaillist.options.length-1] = new Option(strEmail,strEmail);//intEmailValue);
}

function openLogout(){
	location.href = "/s/loginmgr/logout.asp";
}

function loginSwitch(id){
//id = 0, 则会转到控制面板，否则转到对应id的登陆点重新登陆。
	if (id >= 0)
	{
		location.href = "/s/loginmgr/loginpoint.asp?id=" + id;
	}
}

//清空
function reventList(objSel){
  var listsLength = objSel.options.length;
  for(var i=listsLength-1;i>=0;i--) objSel.options[i] = null;
  //objSel.disabled = true;
}

//新增option
function addOption(selObj,text,value){
     if(selObj){
	    selObj.options[selObj.options.length] = new Option(text,value);
	 }
	 else return false;
}
function cancelBubble(e){var myEve = e?e:event;if(myEve.stopPropagation) myEve.stopPropagation();else myEve.cancelBubble=true;}
function $regEventDomReady(fn){var callFn=arguments.callee;if(!callFn['domReadyUtil']){var userAgent=navigator.userAgent.toLowerCase();callFn['domReadyUtil']={browser:{version:(userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/)||[])[1],safari:/webkit/.test(userAgent),opera:/opera/.test(userAgent),msie:/msie/.test(userAgent)&&!/opera/.test(userAgent),mozilla:/mozilla/.test(userAgent)&&!/(compatible|webkit)/.test(userAgent)},readyList:[],each:function(object,callback,args){var name,i=0,length=object.length;if(args){if(length==undefined){for(name in object)if(callback.apply(object[name],args)===false)break}else for(;i<length;)if(callback.apply(object[i++],args)===false)break}else{if(length==undefined){for(name in object)if(callback.call(object[name],name,object[name])===false)break}else for(var value=object[0];i<length&&callback.call(value,i,value)!==false;value=object[++i]){}}return object},ready:function(){var dom=callFn['domReadyUtil'];if(!dom.isReady){dom.isReady=true;if(dom.readyList){dom.each(dom.readyList,function(){this.call(document)});dom.readyList=null}}}}}var domReadyUtil=callFn['domReadyUtil'];(function(){if(callFn['readyBound'])return;callFn['readyBound']=true;if(document.addEventListener&&!domReadyUtil.browser.opera)document.addEventListener("DOMContentLoaded",domReadyUtil.ready,false);if(domReadyUtil.browser.msie&&window==top)(function(){if(domReadyUtil.isReady)return;try{document.documentElement.doScroll("left")}catch(error){setTimeout(arguments.callee,0);return}domReadyUtil.ready()})();if(domReadyUtil.browser.opera)document.addEventListener("DOMContentLoaded",function(){if(domReadyUtil.isReady)return;for(var i=0;i<document.styleSheets.length;i++)if(document.styleSheets[i].disabled){setTimeout(arguments.callee,0);return}domReadyUtil.ready()},false);myAttachEvent(window,"load",domReadyUtil.ready)})();if(domReadyUtil.isReady)fn.call(document,domReadyUtil);else domReadyUtil.readyList.push(function(){return fn.call(this,domReadyUtil)});return this};function myAttachEvent(d,e,f){try{if(d.attachEvent) d.attachEvent("on"+e,f);else if(d.addEventListener) d.addEventListener(e,f,false);else{var oldF = eval('d.on'+e);if(typeof oldF!='function') eval('d.on'+e+'=f');else eval('d.on'+e)=function(){oldF();f();}}}catch (error){}};function myDetachEvent(d,e,f){try{if(d.detachEvent) d.detachEvent("on"+e,f);else if(d.removeEventListener) d.removeEventListener(e,f,false);}catch (error){};};

function fnMouseoveroutTr(){
	/*var allTr = document.getElementsByTagName('tr');
	var okTr = [],i;
	for(i=0;allTr[i];i++) if(allTr[i].className=='list1'||allTr[i].className=='list2') okTr.push(allTr[i]);
	for(i=0;okTr[i];i++){
		okTr[i].origClass = okTr[i].className;
		okTr[i].onmouseover = function(){this.className='list3'}
		okTr[i].onmouseout = function(){this.className=this.origClass}
	}*/
	var allTr = document.getElementsByTagName('tr');
	var okTr = [],i;
	for(i=0;allTr[i];i++) if(new RegExp("(^|\\s)(list1|list2)(\\s|$)").test(allTr[i].className)) okTr.push(allTr[i]);
	for(i=0;okTr[i];i++){
		okTr[i].origClass = okTr[i].className.indexOf('list1')>-1?'list1':'list2';
		okTr[i].onmouseover = function(){this.className=this.className.replace('list1','list3').replace('list2','list3');};
		okTr[i].onmouseout = function(){this.className=this.className.replace('list3',this.origClass);};
	}
}
$regEventDomReady(fnMouseoveroutTr);

function trySetDefaultText(obj,txt){
	if(obj.value==""){
		obj.value = txt;
		obj.className = 'inputgrey';
	}
	else obj.className = 'inputblack';
}

function tryClearDefaultText(obj,txt){
	if(obj.value==txt){
		obj.value = '';
		obj.className = 'inputblack';
	}
}

function CheckChilds(o,cN,pNArr){
	var cArr = [],pArr = [],checkboxArr = [],i,j,allChecked = true,clickP = false;
	var inputArr = document.getElementsByTagName('input');
	for(i=0;inputArr[i];i++) if(inputArr[i].type.toString().toLowerCase()=='checkbox') checkboxArr.push(inputArr[i]);
	for(i=0;checkboxArr[i];i++){
		if(checkboxArr[i].name == cN) cArr.push(checkboxArr[i]);
		else{
			for(j=0;pNArr[j];j++) if(checkboxArr[i].name == pNArr[j]) pArr.push(checkboxArr[i]);
		}
	}
	
	for(i=0;cArr[i];i++) if(!cArr[i].checked) {allChecked = false;break;}
	for(i=0;pArr[i];i++) if(o.name == pArr[i].name) {clickP = true;break;}
	switch(true){
		case clickP : for(i=0;cArr[i];i++) cArr[i].checked = o.checked;
					   for(i=0;pArr[i];i++) if(pArr[i].name != o.name) pArr[i].checked = o.checked;break;
		case allChecked : for(i=0;pArr[i];i++) pArr[i].checked = true;break;
		case !allChecked : for(i=0;pArr[i];i++) pArr[i].checked = false;break;
	}
}

String.prototype.trim = function(){
	var x=this;
	x=x.replace(/^\s*(.*)/, "$1");
    x=x.replace(/(.*?)\s*$/, "$1");
    return x;
}

function checkUserEmail(mail){
	var strSuffix = "cc|com|edu|gov|int|net|org|biz|info|pro|name|coop|al|dz|af|ar|ae|aw|om|az|eg|et|ie|ee|ad|ao|ai|ag|at|au|mo|bb|pg|bs|pk|py|ps|bh|pa|br|by|bm|bg|mp|bj|be|is|pr|ba|pl|bo|bz|bw|bt|bf|bi|bv|kp|gq|dk|de|tl|tp|tg|dm|do|ru|ec|er|fr|fo|pf|gf|tf|va|ph|fj|fi|cv|fk|gm|cg|cd|co|cr|gg|gd|gl|ge|cu|gp|gu|gy|kz|ht|kr|nl|an|hm|hn|ki|dj|kg|gn|gw|ca|gh|ga|kh|cz|zw|cm|qa|ky|km|ci|kw|cc|hr|ke|ck|lv|ls|la|lb|lt|lr|ly|li|re|lu|rw|ro|mg|im|mv|mt|mw|my|ml|mk|mh|mq|yt|mu|mr|us|um|as|vi|mn|ms|bd|pe|fm|mm|md|ma|mc|mz|mx|nr|np|ni|ne|ng|nu|no|nf|na|za|aq|gs|eu|pw|pn|pt|jp|se|ch|sv|ws|yu|sl|sn|cy|sc|sa|cx|st|sh|kn|lc|sm|pm|vc|lk|sk|si|sj|sz|sd|sr|sb|so|tj|tw|th|tz|to|tc|tt|tn|tv|tr|tm|tk|wf|vu|gt|ve|bn|ug|ua|uy|uz|es|eh|gr|hk|sg|nc|nz|hu|sy|jm|am|ac|ye|iq|ir|il|it|in|id|uk|vg|io|jo|vn|zm|je|td|gi|cl|cf|cn";
	var regu = "^[a-z0-9][_a-z0-9\-]*([\.][_a-z0-9\-]+)*@([a-z0-9\-_]+[\.])+(" + strSuffix + ")$";
	return new RegExp(regu,'i').test(mail);
}

function getCookie(name){
	var dc = document.cookie;
    var prefix = name + '=';
    var begin = dc.indexOf('; ' + prefix);
    if(begin == -1){
       begin = dc.indexOf(prefix);
       if(begin != 0) return null;
    }else{
       begin += 2;
    }
    var end = document.cookie.indexOf(';', begin);
    if(end == -1) {
       end = dc.length;
    }
    return window.decodeURIComponent?decodeURIComponent(dc.substring(begin + prefix.length, end)):unescape(dc.substring(begin + prefix.length, end));
}
function checkWhitePosition(obj){
	var subjobid = "$535$536$542$209$399$212$206$211$200$202$201$203$409$224$363$226$517$144$136$138$137$139$143$140$141$332$506$503$040$042$052$398$313$058$314$044$316$098$096$350$106$465$102$351$103$353$241$488$243$349$347$194$468$195$346$189$191$190$368$281$391$390$493$016$153$534$473$471$470$478$474$476$477$123$120$121$125$312$235$063$065$061$496$294$495$158$159$164$168$457$005$004$003$001$000$454$455$456$453$459$328$114$255$362$249$251$253$330$331$216$217$220$";
	if(obj.MinYears.value == "8888"){
		if(parseInt(obj.MinYearsfrom.value,10)<3) return false;
	}
	else
	{
		if(String("$0305$0510$1099$").indexOf("$"+obj.MinYears.value+"$")==-1) return false;
	}
	if(String("$4$3$10$11$1$").indexOf("$"+obj.education.value+"$")==-1) return false;
	
	if(!obj.employment_type[0].checked) return false;
	if(subjobid.indexOf("$"+obj.jobnameid.value+"$")==-1 && subjobid.indexOf("$"+obj.jobnameid2.value+"$")==-1) return false;
	return true;
}
var cvTabDefColCookieName = 'cvListDefCol';