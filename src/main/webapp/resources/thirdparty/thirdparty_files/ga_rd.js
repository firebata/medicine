var _dyweq = _dyweq || [];
_dyweq.push(['_setAccount',window['acc4zpAnalytics']||'log000001']);
_dyweq.push(['_setDomainName',window['dom4zpAnalytics']||'.zhaopin.com']);
if(window['url4zpAnalytics']) _dyweq.push(['_trackPageview',url4zpAnalytics]);
else _dyweq.push(['_trackPageview']);
(function(){
    var dywe = document.createElement('script');
    dywe.type = 'text/javascript'; dywe.async = true;
    dywe.src = 'http://img01.zhaopin.cn/2012/js/dywe.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(dywe, s);
})();
var _gaq = _gaq || [];
_gaq.push(['_setAccount', window['acc4googleAnalytics']||'UA-7874902-2']);
_gaq.push(['_setDomainName',window['dom4googleAnalytics']||'zhaopin.com']);
_gaq.push(['_addOrganic','youdao','q']);
_gaq.push(['_addOrganic','sogou','query']);
_gaq.push(['_addOrganic','soso','w']);
_gaq.push(['_addOrganic','360','q']);
if(window['url4googleAna']) _gaq.push(['_trackPageview',url4googleAna]);
else _gaq.push(['_trackPageview']);
/*(function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();*/
function recordOutboundLink(link, category, action) {
    function ed(d,a){var c=encodeURIComponent;return c instanceof Function?(a?encodeURI(d):c(d)):escape(d);}
    try{
        _dywet._getTrackerByName()._trackEvent(category, action);
        try{
            _gat._getTrackerByName()._trackEvent(category, action);
        }catch(err){}
        if(link.target!="_blank" && link.href){
            setTimeout('document.location = "' + link.href + '"', 100);
        }
    }catch(err){
        var i=new Image(1,1);
        var e=document.location;
        i.src="http://l.zhaopin.com/track_err.gif?dywee=5("+category+"*"+action+")&dywehn="+ed(e.hostname)+"&dywep="+ed(e.pathname+e.search,true);
    }
}
function dyweTrackEvent(category, action) {
    function ed(d, a) {
        var c = encodeURIComponent;
        return c instanceof Function ? (a ? encodeURI(d) : c(d)) : escape(d);
    }
    try {
        _dywet._getTrackerByName()._trackEvent(category, action);
        try {
            _gat._getTrackerByName()._trackEvent(category, action);
        } catch (err) {
        }
    } catch (err) {
        var i = new Image(1, 1);
        var e = document.location;
        i.src = "http://l.zhaopin.com/track_err.gif?dywee=5(" + category + "*"
            + action + ")&dywehn=" + ed(e.hostname) + "&dywep="
            + ed(e.pathname + e.search, true);
    }
}
$.extend((function(){
    var isIE=!!window.ActiveXObject;
    var isIE6=isIE&&!window.XMLHttpRequest;
    var isIE8=isIE&&(document.documentMode==8);
    var isIE7=isIE&& !isIE6&& !isIE8;
    if(isIE){
        var browser=navigator.appName
        var b_version=navigator.appVersion
        var version=b_version.split(";");
        var trim_Version=version[1].replace(/[ ]/g,"");
        isIE7 = isIE7 && (trim_Version == 'MSIE7.0' || document.documentMode==7) ;
    }
    return {
        isIE : isIE,
        isIE6 : isIE6,
        isIE7 : isIE7,
        isIE8 : isIE8
    }
})());
var ZP = {};
$.extend(ZP.analysis = {},{
    monitor_class_reg : /__ga__(\w+)_(\w+)_(((\d{3})_((\w+-\w+)|(\w+)))|(\d{3}))/,
    monitor_class_selector : "[class *= __ga__]"
});
ZP.analysis.elements_analysis = function(scope){
    var zpa = ZP.analysis,scope = scope || document;
    $(zpa.monitor_class_selector,scope).each(function(){
            var monitor_dom = this;
            var jq_monitor_dom = $(this);
            var options = monitor_dom.className.match(zpa.monitor_class_reg);
            if(!options){
                return true;
            }
            var category = options[1] || '',
                action = options[2] || '',
                listeners = options[6] || '';
            var index = (listeners == '' ? options[3] : options[5] ),
                index = index ? index : '';
            if(listeners == ''){
                ZP.analysis.bind_click(jq_monitor_dom,function(){
                    ZP.analysis.init_monitor_analy(monitor_dom,category,action,index);
                },"ZP.analysis.init_monitor_analy(this,\'"+category+"\',\'"+action+"\',\'"+index+"\');");
            }else{
                listeners = listeners.split("-");
                for(var step = 0 ,len = listeners.length; step < len ; step++){
                    switch(listeners(step))
                    {
                        case "click":
                            ZP.analysis.bind_click(jq_monitor_dom,function(){
                                ZP.analysis.init_monitor_analy(monitor_dom,category,action,index);
                            },"ZP.analysis.init_monitor_analy(this,\'"+category+"\',\'"+action+"\',\'"+index+"\');");
                            break;
                        case "mover":
                            jq_monitor_dom.hover(function(monitor_dom){
                                ZP.analysis.init_monitor_analy(monitor_dom,category,action,index);
                            },function(){});
                            break;
                    }
                }
            }
        }
    );
};
ZP.analysis.bind_click = function(scope,ie67Fun,w3Fun){
    if(scope && (scope instanceof jQuery)){
        var dom = scope.get(0);
        var funstr =dom.getAttribute("onclick") || "";
        dom.setAttribute("onclick", "");
        if($.isIE6 || $.isIE7 || funstr instanceof Function){
            if(ie67Fun instanceof Function){
                scope.click(ie67Fun);
            }
            if(funstr instanceof Function){
                scope.click(funstr);
            }
        }else{
            dom.setAttribute("onclick", w3Fun +";"+ funstr);
        }
    }else{
        return ;
    }
};
ZP.analysis.init_monitor_analy = function(dom,category,action,index){
    if(index != ''){
        action += index;
    }
    this.on_track_analy({
        analyFun:function(){
            if(dom && dom.tagName.toLowerCase() == "a"){
                recordOutboundLink(dom, category, action);
            }else if(dom){
                dyweTrackEvent(category, action);
            }
        }
    });
};
ZP.analysis.on_track_analy = function (paramCfg) {
    var defaults = {
        beforeAnalyFun: new Function(),
        afterAnalyFun: new Function(),
        analyFun:new Function(),
        analyErrorFun:new Function(),
        category : '',
        action : '',
        scope : null,
        delay : 10
    };
    $.extend(defaults,paramCfg);
    try{
        defaults.beforeAnalyFun();
        defaults.analyFun();
    }catch(err){
        defaults.analyErrorFun();
    }finally{
        setTimeout(defaults.afterAnalyFun,defaults.delay);
    }
};
$(document).ready(function(){
    try{ZP.analysis.elements_analysis();}catch(e){}
});