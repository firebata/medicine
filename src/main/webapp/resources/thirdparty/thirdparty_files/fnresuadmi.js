function $try() {
    for (var B = 0, A = arguments.length;
B < A; B++) { try { return arguments[B](); } catch (C) { } } return null;
}

$try(function () { document.execCommand("BackgroundImageCache", false, true); });

if (typeof (window['rdModuleIns']) == 'undefined' || !window['rdModuleIns']) window['rdModuleIns'] = [];
function initResuadmiModule() {
    var e = /<[^>]+\srdmodule=[\'\"]?([\w|]+)[^>]+/g;
    var g = /id=[\'\"]?([\w\-]+)/i;
    var i, j, rIndex = -1;
    window.document.body.innerHTML.replace(e, function (a, b) {
        if ((i = a.match(g)) && (j = document.getElementById(i[1]))) {
            if (window[b]) {
                var x, y, z;
                if (b == 'resumePhotoFac_popdiv') {
                    if (!window[b + '_popupDiv']) window[b + '_popupDiv'] = buildRePhotoDiv();
                    if (window['showPopup']) window['rdModuleIns'][i[1]] = new window[b](j);
                    else {
                        y = i[1];
                        z = j;
                        $loadJs('/s/js/erd2/popupDiv_shim.js', 'utf-8', function () { window['rdModuleIns'][y] = new window[b](z); })
                    }
                }
                else if (b == 'resumeMoreInfoFac') {
                    if (!window['resumeListItemIns']) window['resumeListItemIns'] = new Array();
                    rIndex++;
                    x = rIndex;
                    if (window['submitCallback']) window['resumeListItemIns'][x] = window['rdModuleIns'][i[1]] = new window[b](j, x);
                    else {
                        y = i[1];
                        z = j;
                        $loadJs('/s/js/ajaxbase.js', 'utf-8', function () { window['resumeListItemIns'][x] = window['rdModuleIns'][y] = new window[b](z, x); })
                    }
                }
                else window['rdModuleIns'][i[1]] = new window[b](j);
            }
        }
        return '';
    });
}

function resumePhotoFac(h) {
    var s = this;
    s.html = h;
    s.html.title = '有照片';
    s.photoSrc = s.html.getAttribute('photosrc') || '';
    s.srcPrefix = 'http://my.zhaopin.com';
    s.id = s.html.id.toString().split('_')[1];
    var img = document.createElement('img');
    img.src = '/img/icon_loadingani.gif';
    img.className = 'photoImgLoading';
    s.img = img;
}

function buildRePhotoDiv() {
    var div = document.createElement('div');
    div.id = '$photoPopupDiv';
    div.className = 'photoPopupDiv';
    div.setAttribute('photoId', '');
    var img = document.createElement('img');
    img.src = '/img/icon_loadingani.gif';
    img.className = 'photoImgLoading';
    myAttachEvent(img, 'load', function (e) { var myEve = window.event ? window.event : e; var img = myEve.target ? myEve.target : myEve.srcElement; if (img.src.toString().toLowerCase().indexOf('icon_loadingani.gif') > -1) img.className = 'photoImgLoading'; else img.className = 'photoImg'; });
    div.appendChild(img);
    div.img = img;
    document.body.appendChild(div);
    return div;
}
function resumePhotoFac_popdiv(h) {
    var s = this;
    s.html = h;
    s.photoSrc = s.html.getAttribute('photosrc') || '';
    s.srcPrefix = 'http://my.zhaopin.com';
    s.id = s.html.id.toString().split('_')[1];
    if (!window['resumePhotoFac_popupDiv']) window['resumePhotoFac_popupDiv'] = buildRePhotoDiv();
    s.div = window['resumePhotoFac_popupDiv'];
    s.fOver = function (e) { s.fnShowPhoto(e); };
    s.fOut = function (e) { s.fnHidePhoto(e); };
    myAttachEvent(s.html, 'mouseover', s.fOver);
    myAttachEvent(s.html, 'mouseout', s.fOut);
}
resumePhotoFac_popdiv.prototype = {
    fnShowPhoto: function (e) {
        var s = this;
        if (s.div.photoId != s.id) {
            var pointer = getXY(s.html);
            var x = pointer.x + s.html.offsetWidth;
            var y = pointer.y + s.html.offsetHeight;
            showPopup(s.div.id, e, x, y);
            s.div.img.src = s.srcPrefix + s.photoSrc;
            //s.div.img.className = 'photoImg';
            s.div.photoId = s.id;
        }
        else return;
    },
    fnHidePhoto: function (e) {
        var s = this;
        s.div.photoId = '';
        hideCurrentPopup();
        s.div.img.src = '/img/icon_loadingani.gif';
        //s.div.img.className = 'photoImgLoading';
    }
}

function movetofavoriate_one(str) {
    openPopup('', 'movetofavorite', 450, 200);
    document.form1.select_unique_id.value = str;
    delete_ids = str;
    document.form1.action = "/s/resuadmi/ResumeMoveToFavorite.asp?need_refresh=none";
    document.form1.target = "movetofavorite";
    document.form1.submit();
    document.form1.action = "";
    document.form1.target = "";
}
function forwardResume_one(str) {
    openPopup('', 'FWResume', 360, 150);
    document.form1.select_unique_id.value = str;
    document.form1.action = "/s/resuadmi/FWResume.asp";
    document.form1.target = "FWResume";
    document.form1.submit();
    document.form1.action = "";
    document.form1.target = "";
}
function buttonShowGen(o) {
    var button = document.createElement('input');
    button.type = 'button';
    button.className = 'lineButton';
    button.value = '显示简历';
    var resumeId = o.resumeId;
    myAttachEvent(button, 'click', function () { viewOneResume(resumeId) });
    return button;
}
function buttonSaveGen(o) {
    var button = document.createElement('input');
    button.type = 'button';
    button.className = 'lineButton';
    button.value = '收藏到简历夹';
    button.style.width = '95px';
    var resumeId = o.resumeId;
    myAttachEvent(button, 'click', function () { movetofavoriate_one(resumeId) });
    return button;
}
function buttonSendGen(o) {
    var button = document.createElement('input');
    button.type = 'button';
    button.className = 'lineButton';
    button.value = '简历导出';
    var resumeId = o.resumeId;
    myAttachEvent(button, 'click', function () { forwardResume_one(resumeId) });
    return button;
}
function changeBgMouseover(o) {
    o.className = o.className.replace('list1', 'list3').replace('list2', 'list3');
}
function changeBgMouseout(o) {
    o.className = o.className.replace('list3', o.origClass);
}
function resuadmiListHTMLGen(o, flag, goon) {
    var tr = document.createElement('tr');
    tr.className = o.html.origClass || o.html.className;
    tr.origClass = tr.className;
    tr.onmouseover = function () { changeBgMouseover(this); changeBgMouseover(this.previousSibling); };
    tr.onmouseout = function () { changeBgMouseout(this); changeBgMouseout(this.previousSibling); };
    //myAttachEvent(tr,'mouseover',function(e){var myEve = e?e:window.event;var obj = myEve.target?myEve.target:myEve.srcElement;obj.className=obj.className.replace('list1','list3').replace('list2','list3');});
    //myAttachEvent(tr,'mouseout',function(e){var myEve = e?e:window.event;var obj = myEve.target?myEve.target:myEve.srcElement;obj.className=obj.className.replace('list3',obj.origClass);});
    var td;
    if (!o.htmlClassFnPro || !o.htmlClassFnPro.noBoxTd) {
        td = document.createElement('td');
        td.appendChild(document.createTextNode(' '))
        td.className = 'tdCheckbox';
        tr.appendChild(td);
    }
    td = document.createElement('td');
    td.className = 'listMore';
    td.appendChild(document.createTextNode(' '));
    if (window['RD_RESUMELABEL'] && window['RD_RESUMELABEL'].allHTML.length) td.setAttribute("colSpan", "2");
    td.setAttribute("vAlign", "top");
    tr.appendChild(td);

    /* display photo in td */
    o.tdPhoto = td;

    td = document.createElement('td');
    td.className = 'listMore';
    td.style.width = (window['RD_RESUMELABEL'] && window['RD_RESUMELABEL'].allHTML.length) ? '760px' : '450px'; //807
    if (o.htmlClassFnPro && o.htmlClassFnPro.col) td.setAttribute('colSpan', o.htmlClassFnPro.col);
    else td.setAttribute('colSpan', 8); //9
    var div = document.createElement('div');
    div.className = 'moreInfoLoading';
    o.divLoading = div;
    td.appendChild(div);
    var div = document.createElement('div');
    var div2 = document.createElement('div');
    o.divAjax = div2;
    div.appendChild(div2);
    o.buttonShow = buttonShowGen(o);
    div.appendChild(o.buttonShow);
    o.buttonSave = buttonSaveGen(o);
    div.appendChild(o.buttonSave);
    o.buttonSend = buttonSendGen(o);
    div.appendChild(o.buttonSend);
    o.divInfo = div;
    o.divInfo.style.display = 'none';
    td.appendChild(div);
    tr.appendChild(td);
    if (o.html.nextSibling) o.html.parentNode.insertBefore(tr, o.html.nextSibling);
    else o.html.parentNode.appendChild(tr);
    o.moreTr = tr;
    o.moreTr.style.display = 'none';
    o.flagDisplay = 'hide';
    o.showhideMoreInfo(flag, goon);
}
function resumeMoreInfoFac(h, index) {
    var s = this;
    s.html = h;
    s.html.onmouseover = function () { changeBgMouseover(this); if (window['rdModuleIns'][this.id] && window['rdModuleIns'][this.id].moreTr) changeBgMouseover(window['rdModuleIns'][this.id].moreTr); };
    s.html.onmouseout = function () { changeBgMouseout(this); if (window['rdModuleIns'][this.id] && window['rdModuleIns'][this.id].moreTr) changeBgMouseout(window['rdModuleIns'][this.id].moreTr); };
    s.index = index;
    s.resumeId = s.html.id.toString().split('_')[1];
    s.resumeNum = s.html.getAttribute('resume_number') || '';
    s.resumeBH = s.html.getAttribute('resume_bh') || '';
    s.expItems = s.html.getAttribute('expItems') || null;
    if (s.expItems == null || isNaN(s.expItems)) s.expItems = 1;
    s.htmlClass = s.html.getAttribute('htmlClass') || 'resuadmiListHTMLGen';
    s.htmlClassFn = s.htmlClass.toString().split('|')[0];
    s.htmlClassFnProStr = s.htmlClass.toString().split('|')[1] || null;
    if (s.htmlClassFnProStr != null) eval('s.htmlClassFnPro = ' + s.htmlClassFnProStr);
    else s.htmlClassFnPro = null;
    s.moreInfoStr = null;
    s.flagInsertInfo = false;
    s.ajaxState = 'ok';
    s.C = function (e) { s.fnClick(e); };
    myAttachEvent(s.html, 'click', s.C);
}
resumeMoreInfoFac.prototype = {
    fnClick: function (e) {
        function clickFnOkObj(o) {
            /* display photo in td */
            return o.nodeType == 1 && (o.tagName.toLowerCase() == 'td' || (o.tagName.toLowerCase() == 'img' && o.getAttribute('rdmodule') && o.getAttribute('rdmodule') == 'resumePhotoFac'))
        }

        var s = this;
        var myEve = e ? e : window.event;
        var target = myEve.target ? myEve.target : myEve.srcElement;
        if (clickFnOkObj(target)) s.fnShowHide();
        else return;
    },
    fnShowHide: function (flag, goon) {
        var s = this;
        if (!s.moreTr) window[s.htmlClassFn](s, flag, goon);
        else s.showhideMoreInfo(flag, goon);
    },
    showhideMoreInfo: function (flag, goon) {
        var s = this;
        if (flag) {
            if (flag == 'show') s.showMoreInfo(goon);
            else if (flag == 'hide') s.hideMoreInfo();
        }
        else {
            if (s.flagDisplay == 'hide') s.showMoreInfo(goon);
            else s.hideMoreInfo();
        }
    },
    showMoreInfo: function (goon) {
        var s = this;
        if (s.deadFlag) {
            if (typeof (goon) != 'undefined' && goon) setTimeout('goonShowReDetail()', 0);
            return;
        }
        if (!s.flagInsertInfo) {
            if (s.divLoading.style.display == 'none') s.divLoading.style.display = '';
            if (s.divInfo.style.display != 'none') s.divInfo.style.display = 'none';
        }

        /* display photo in td */
        if (window['rdModuleIns']['photo_' + s.resumeId] && !s.objPhoto) {
            s.objPhoto = window['rdModuleIns']['photo_' + s.resumeId];
            if (s.tdPhoto.childNodes[0]) s.tdPhoto.removeChild(s.tdPhoto.childNodes[0]);
            s.tdPhoto.appendChild(s.objPhoto.img);
            myAttachEvent(s.objPhoto.img, 'load', function (e) { var myEve = window.event ? window.event : e; var img = myEve.target ? myEve.target : myEve.srcElement; if (img.src.toString().toLowerCase().indexOf('icon_loadingani.gif') > -1) img.className = 'photoImgLoading'; else img.className = 'photoImg'; });
            s.objPhoto.img.src = s.objPhoto.srcPrefix + s.objPhoto.photoSrc;
        }

        s.moreTr.style.display = '';
        if (s.html.className.indexOf('list3') > -1) changeBgMouseover(s.moreTr);
        s.flagDisplay = 'show';
        if (s.moreInfoStr == null) s.ajaxGetInfo(goon); //goto AJAX  if(goon) alert(window['resumeDetailProIndex']);
        else {
            if (!s.flagInsertInfo) s.insertAjaxHTML(goon);
            else {
                if (typeof (goon) != 'undefined' && goon) setTimeout('goonShowReDetail()', 0);
            }
            if (s.divLoading.style.display != 'none') s.divLoading.style.display = 'none';
            if (s.divInfo.style.display == 'none') s.divInfo.style.display = '';
        }
    },
    hideMoreInfo: function () {
        var s = this;
        s.moreTr.style.display = 'none';
        s.flagDisplay = 'hide';
    },
    insertAjaxHTML: function (goon) {
        var s = this;
        var str = '<p><b>自我评价：</b>' + s.moreInfo.comm + '</p><p><b>最近工作：</b>';
        var i, workItem;
        for (i = 0; s.moreInfo.work[i]; i++) {
            workItem = s.moreInfo.work[i];
            str += workItem[0] + '&nbsp;&nbsp;' + workItem[1] + '&nbsp;&nbsp;' + workItem[2] + '<br>' + workItem[3] + '<br>';
        }
        str += '</p>'; //if(goon) alert(s.divAjax.innerHTML);
        s.divAjax.innerHTML = str;
        s.flagInsertInfo = true;
        if (typeof (goon) != 'undefined' && goon) setTimeout('goonShowReDetail()', 0);
    },
    ajaxGetInfo: function (goon) {
        var s = this;
        if (s.ajaxState == 'ajax') return;
        var data = 'ext_id=' + s.resumeBH + '&showint=' + s.expItems + '&version_num=' + s.resumeNum; // + '&t='+new Date().getTime();
        //var data = 'showint=3&ext_id=JR009025817R90250001000&version_num=5' + '&t='+new Date().getTime();
        s.ajaxState = 'ajax';
        submitCallback(data, '/s/resume_preview/resume_preview_summy.asp', handleGetMoreInfoResponse, 'get', { o: s, goon: goon });
        //test(data,'xxx.asp',handleGetMoreInfoResponse,'get',s);
    }
}
function test(a, b, c, d, e) {
    c(true, "{comm:'自我评价',work:[['时间','公司名称','职位名称','描&acute;//述'],['时间','公司名称','职位名称','描述']]}", e);
}
function handleGetMoreInfoResponse(success, responseText, objPar) {
    objPar.o.ajaxState = 'ok';
    if (success) {
        objPar.o.moreInfoStr = responseText; //document.form1.GotoPageNum.value = objPar.o.moreInfoStr
        //alert(objPar.o.moreInfoStr)
        try { eval('objPar.o.moreInfo = ' + objPar.o.moreInfoStr); }
        catch (e) { }; //if(objPar.goon) alert(objPar.o.moreInfo&&objPar.o.flagDisplay=='show');
        if (objPar.o.moreInfo && objPar.o.flagDisplay == 'show') objPar.o.showMoreInfo(objPar.goon);
    }
    else {//ajax error
        objPar.o.divAjax.innerHTML = 'ajax 出错！';
        if (objPar.o.divLoading.style.display != 'none') objPar.o.divLoading.style.display = 'none';
        if (objPar.o.divInfo.style.display == 'none') objPar.o.divInfo.style.display = '';
    }
}

function goonShowReDetail() {
    if (window['resumeDetailProFlag']) {
        var index = ++window['resumeDetailProIndex'];
        var obj = window['resumeListItemIns'][index];
        while (obj) {
            if (obj.ajaxState != 'ajax') {
                obj.fnShowHide('show', true);
                break;
            }
            else {
                if (obj.flagDisplay == 'hide') {
                    if (obj.divLoading.style.display == 'none') obj.divLoading.style.display = '';
                    if (obj.divInfo.style.display != 'none') obj.divInfo.style.display = 'none';
                    obj.moreTr.style.display = '';
                    obj.flagDisplay = 'show';
                }
                index = ++window['resumeDetailProIndex'];
                obj = window['resumeListItemIns'][index];
            }
        }
    }
}
function reDetailSimpleFac(h) {
    var s = this;
    s.html = h;
    s.state = s.html.getAttribute('defaultState') || 'simple';
    s.triggerImgs = s.html.getElementsByTagName('img');
    s.trigger2simple = s.triggerImgs[0] || null;
    s.trigger2detail = s.triggerImgs[1] || null;
    s.fnS = function (e) { s.fnSimpleShow(e); };
    s.fnD = function (e) { s.fnDetailShow(e); };
    if (s.trigger2simple) s.trigger2simple.title = s.trigger2simple.alt = '简单列表';
    if (s.trigger2detail) s.trigger2detail.title = s.trigger2simple.alt = '详细列表';
    s.fnBlank = function () { return; };
    s.setTrigger();
}
reDetailSimpleFac.prototype = {
    fnSimpleShow: function () {
        var s = this;
        var allResumeIns = window['resumeListItemIns'];
        window['resumeDetailProFlag'] = false;
        if (allResumeIns && allResumeIns.length)
            if (s.state == 'detail') {
                s.state = 'simple';
                s.setTrigger();
                s.fnHideAllDetail(allResumeIns);
            }
            else if (s.state == 'simple') return;
    },
    fnDetailShow: function () {
        var s = this;
        var allResumeIns = window['resumeListItemIns'];
        window['resumeDetailProFlag'] = true;
        if (allResumeIns && allResumeIns.length)
            if (s.state == 'simple') {
                s.state = 'detail';
                s.setTrigger();
                s.fnShowAllDetail(allResumeIns);
            }
            else if (s.state == 'detail') return;
    },
    fnShowAllDetail: function (arr) {
        var s = this;
        window['resumeDetailProIndex'] = 0;
        if (arr[window['resumeDetailProIndex']]) arr[window['resumeDetailProIndex']].fnShowHide('show', true);
    },
    fnHideAllDetail: function (arr) {
        var s = this;
        for (var i = 0; arr[i]; i++) if (arr[i].flagDisplay == 'show') arr[i].hideMoreInfo();
    },
    setTrigger: function () {
        var s = this;
        switch (s.state) {
            case 'simple': if (s.trigger2simple) {
                    s.trigger2simple.className = 'iconReList_simple_sel';
                    s.trigger2simple.onclick = s.fnBlank;
                }
                if (s.trigger2detail) {
                    s.trigger2detail.className = 'iconReList_detail';
                    s.trigger2detail.onclick = s.fnD;
                }
                break;
            case 'detail': if (s.trigger2simple) {
                    s.trigger2simple.className = 'iconReList_simple';
                    s.trigger2simple.onclick = s.fnS;
                }
                if (s.trigger2detail) {
                    s.trigger2detail.className = 'iconReList_detail_sel';
                    s.trigger2detail.onclick = s.fnBlank;
                }
                break;
        }
    }
}

$regEventDomReady(initResuadmiModule);

function $loadJs(a, b, c) { var d = arguments.callee; var e = d.queue || (d.queue = {}); b = b || (((window.document.charset ? window.document.charset : window.document.characterSet) || "").match(/^(gb2312|big5|utf-8)$/gi) || "utf-8").toString().toLowerCase(); if (a in e) { if (c) { if (e[a]) e[a].push(c); else c(); } return; } e[a] = c ? [c] : []; var f = window.document.createElement("script"); f.type = "text/javascript"; f.charset = b; f.onload = f.onreadystatechange = function () { if (f.readyState && f.readyState != "loaded" && f.readyState != "complete") return; f.onreadystatechange = f.onload = null; while (e[a].length) e[a].shift()(); e[a] = null }; f.src = a; window.document.getElementsByTagName("head")[0].appendChild(f) };

(function () {
    var isIE = navigator.appName.indexOf("Microsoft") > -1;
    var isIE6 = navigator.appVersion.indexOf("MSIE 6") > -1;
    String.prototype.trim = function () {
        return this.replace(/^[\s\xa0\u3000]+|[\s\xa0\u3000]+$/g, "");
    };
    String.prototype.realLength = function () {
        return this.replace(/[^\x00-\xff]/g, "aa").length;
    };
    String.prototype.urlEncode = function () {
        return window.encodeURIComponent ? encodeURIComponent(this) : escape(this);
    };
    String.prototype.urlDecode = function () {
        return window.decodeURIComponent ? decodeURIComponent(this) : unescape(this);
    };
    function $(id) {
        return document.getElementById(id) || null;
    }
    function xhr() {
        var a = null;
        try {
            a = new XMLHttpRequest;
        }
        catch (b) {
            for (var c = ["MSXML2.XMLHTTP.6.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP"], d = 0, e; e = c[d++]; )
                try {
                    a = new ActiveXObject(e);
                    break;
                }
                catch (f) { };
        }
        return a;
    }
    var ajax = function (options) {
        options = {
            type: (options.type && options.type.toUpperCase()) || "POST",
            url: options.url || "",
            timeout: options.timeout || 120000,
            cache: "cache" in options ? options.cache : true,
            onComplete: options.onComplete || function () { },
            onError: options.onError || function () { },
            onSuccess: options.onSuccess || function () { },
            onAbort: options.onAbort || options.onComplete || function () { },
            dataResType: options.dataResType || "",
            dataReqType: options.dataReqType || "form",
            data: options.data || ""
        };
        var reqCt = {
            form: "application/x-www-form-urlencoded",
            xml: "application/xml",
            script: "application/json"
        };
        var url4get = options.url + (options.data != "" ? "?" + options.data : "");
        if (options.cache === false && options.type == "GET") {
            var ts = +new Date;
            var ret = url4get.replace(/(\?|&)_=.*?(&|$)/, "$1_=" + ts + "$2");
            url4get = ret + ((ret == url4get) ? (url4get.match(/\?/) ? "&" : "?") + "_=" + ts : "");
        }
        var xml = xhr();
        xml.open(options.type, options.type == "GET" ? url4get : options.url, true);
        if (options.type == "POST") xml.setRequestHeader("content-type", reqCt[options.dataReqType]);
        var timeoutLength = options.timeout;
        var requestDone = false;
        var timeoutControl = window.setTimeout(function () { requestDone = true; xml.abort(); if (xml) { xml.onreadystatechange = function () { }; options.onAbort(xml); } }, timeoutLength);
        xml.onreadystatechange = function () {
            if (xml.readyState == 4 && !requestDone) {
                window.clearTimeout(timeoutControl);
                if (httpSuccess(xml)) {
                    options.onSuccess(httpData(xml, options.dataResType));
                } else {
                    options.onError();
                }
                options.onComplete();
                xml = null;
            }
        };
        xml.send(options.type == "POST" ? options.data : null);
        function httpSuccess(r) {
            try {
                return !r.status && location.protocol == "file:" ||
			(r.status >= 200 && r.status < 300) ||
			r.status == 304 ||
			navigator.userAgent.indexOf("Safari") >= 0 && typeof r.status == "undefined";
            } catch (e) { }
            return false;
        }
        function httpData(r, type) {
            var ct = r.getResponseHeader("content-type");
            var data = !type && ct && ct.indexOf("xml") >= 0;
            data = type == "xml" || data ? r.responseXML : r.responseText;
            if (type == "script") eval.call(window, data);
            return data;
        }
        return xml;
    };
    ajax.serialize = function (a) {// A hash of key/value pairs  OR  An array of input elements
        var s = [];
        if (a.constructor == Array) {
            for (var i = 0; i < a.length; i++) s.push(a[i].name + "=" + a[i].value.urlEncode());
        }
        else {
            for (var j in a) s.push(j + "=" + a[j].urlEncode());
        }
        return s.join("&");
    };
    function getViewportSize() {
        function viewportWidth() {
            if (typeof window.innerWidth == "number") return window.innerWidth;
            else if (document.documentElement && document.documentElement.clientWidth) return document.documentElement.clientWidth;
            else if (document.body && document.body.clientWidth) return document.body.clientWidth;
            return 0;
        }
        function viewportHeight() {
            if (typeof window.innerHeight == "number") return window.innerHeight;
            else if (document.documentElement && document.documentElement.clientHeight) return document.documentElement.clientHeight;
            else if (document.body && document.body.clientHeight) return document.body.clientHeight;
            return 0;
        }
        return { w: viewportWidth(), h: viewportHeight() };
    }
    function getPageSize() {
        return { w: document.body.scrollWidth, h: document.body.scrollHeight };
    }
    function getScrollPosition() {
        function scrollbarX() {
            if (typeof window.pageXOffset == "number") return window.pageXOffset;
            else if (document.documentElement && document.documentElement.scrollLeft) return document.documentElement.scrollLeft;
            else if (document.body && document.body.scrollLeft) return document.body.scrollLeft;
            return 0;
        }
        function scrollbarY() {
            if (typeof window.pageYOffset == "number") return window.pageYOffset;
            else if (document.documentElement && document.documentElement.scrollTop) return document.documentElement.scrollTop;
            else if (document.body && document.body.scrollTop) return document.body.scrollTop;
            return 0;
        }
        return { x: scrollbarX(), y: scrollbarY() };
    }
    function getStyle(ele, name) {
        if (ele.style[name]) return ele.style[name];
        else if (ele.currentStyle) return ele.currentStyle[name];
        else if (document.defaultView && document.defaultView.getComputedStyle) {
            name = name.replace(/([A-Z])/g, "-$1");
            name = name.toLowerCase();
            var s = document.defaultView.getComputedStyle(ele, "");
            return s && s.getPropertyValue(name);
        }
        else return null;
    }
    function setStyle(ele) {
        for (var i = 1; i < arguments.length; i += 2) {
            var sName = arguments[i];
            var sValue = arguments[i + 1];
            if (sName == "opacity") setOpacity(ele, sValue);
            else {
                if (ele.style && sName in ele.style) ele.style[sName] = sValue;
                else if (sName in ele) ele[sName] = sValue;
            }
        }
        return ele;
    }
    function setOpacity(ele, sValue) {
        if (isIE) ele.style.filter = (ele.style.filter || "").replace(/alpha\([^)]*\)/, "") + "alpha(opacity=" + (sValue * 100) + ")";
        else ele.style.opacity = sValue;
        return ele;
    }
    function clearSelOptions(sel) {
        if (sel.options && sel.options.length)
            while (sel.length) sel.remove(0);
    }
    function getParentByTagName(node, pTag) {
        var parent = node;
        while (parent.parentNode) {
            parent = parent.parentNode;
            if (parent.tagName.toLowerCase() == pTag.toLowerCase()) return parent;
        }
        if (parent.tagName.toLowerCase() == pTag.toLowerCase()) return parent;
        else return null;
    }
    var sendInfoFac = window.sendInfoFac = function (h) {
        var s = this;
        s.html = h;
        s.id = s.html.id;
        s.chkboxname = s.html.getAttribute("cvbox") || "";
        s.chkbox = s.chkboxname != "" ? eval(s.chkboxname) : null;
        s.sender = s.html.getAttribute("sender") || "";
        s.reply = s.html.getAttribute("reply") || "";
        s.tdindex = s.html.getAttribute("tdindex") || 2;
        if (s.chkbox && (s.chkbox.length || s.chkbox.nodeType == 1)) {
            if (s.chkbox.nodeType == 1) s.chkbox = [s.chkbox];
            myAttachEvent(s.html, "click", function (e) { s.fnClickTrig(e); });
        }  
    };
    sendInfoFac.tips = ["请选择要发送通知信的简历", "请先选择模板类型", "您还未获得使用该功能的权限！\n请联系本地智联招聘销售人员咨询和购买短信服务！", "请输入发信人", "请选择模板类型", "请输入邮件主题", "请输入邮件正文", "请输入回复邮箱", "回复邮箱格式错误", "请输入公司签名", "请输入消息内容", "您的短信余额不足，请联系本地智联招聘销售人员进行充值！"];
    sendInfoFac.candidateAttName = "userinfo_forsend";
    sendInfoFac.candidateInfoSepa = "$";
    sendInfoFac.receNameStrN = 24;
    sendInfoFac.emailMax = 1000;
    sendInfoFac.msgMax = 180;
    sendInfoFac.candidate = {
        name: 0,
        id: 1,
        email: 2,
        cellphone: 3,
        xid: 4,
        position: 5,
        trindex: 6
    };
    sendInfoFac.email = {
        "2": "面试通过信",
        "3": "面试信",
        "4": "拒绝信",
        "5": "初步沟通信"
    };
    sendInfoFac.msg = {
        "1": "面试通知",
        "2": "聘用通知",
        "3": "拒绝通知",
        "4": "初步沟通"
    };
    sendInfoFac.placeholderRE = {
        candidate: new RegExp("{姓名}", "g"),
        company: new RegExp("{公司名}", "g"),
        position: new RegExp("{职位名}", "g")
    };
    sendInfoFac.createEmailIcon = function () {
        var icon = document.createElement("img");
        icon.src = "/s/images/erd2/blank.gif";
        icon.className = "iconHasEmailPhoto";
        icon.setAttribute("border", 0);
        return icon;
    };
    sendInfoFac.hasEmailIcon = function (node) {
        var imgs = node.getElementsByTagName("img");
        for (var i = 0; i < imgs.length; i++) if (imgs[i].className == "iconHasEmailPhoto") return true;
        return false;
    };
    sendInfoFac.createMsgIcon = function () {
        var icon = document.createElement("img");
        icon.src = "/s/images/erd2/blank.gif";
        icon.className = "iconHasSMSPhoto";
        icon.setAttribute("border", 0);
        return icon;
    };
    sendInfoFac.hasMsgIcon = function (node) {
        var imgs = node.getElementsByTagName("img");
        for (var i = 0; i < imgs.length; i++) if (imgs[i].className == "iconHasSMSPhoto") return true;
        return false;
    };
    sendInfoFac.buildBodyMask = function (flag) {
        if (!sendInfoFac.bodymask) {
            var div = document.createElement("div");
            div.className = "divMask";
            setStyle(div, "opacity", 0.5);
            setStyle(div, "zIndex", 10);
            setStyle(div, "width", 0);
            setStyle(div, "height", 0);
            setStyle(div, "left", 0);
            setStyle(div, "top", 0);
            setStyle(div, "visibility", "hidden");
            document.body.appendChild(div);
            sendInfoFac.bodymask = div;
            sendInfoFac.bodymask.state = "hidden";
            sendInfoFac.bodymask.show = function () {
                if (this.state == "hidden") {
                    this.state = "visible";
                    var pageS = getPageSize();
                    setStyle(this, "width", pageS.w + "px");
                    setStyle(this, "height", pageS.h + "px");
                    setStyle(this, "visibility", "visible");
                }
                else sendInfoFac.fixBodyMask();
            };
            sendInfoFac.bodymask.hide = function () {
                if (this.state == "visible") {
                    this.state = "hidden";
                    setStyle(this, "visibility", "hidden");
                    setStyle(this, "width", 0);
                    setStyle(this, "height", 0);
                }
            };
        }
        if (flag) sendInfoFac.bodymask.show();
    };
    sendInfoFac.fixBodyMask = function () {
        if (sendInfoFac.bodymask && sendInfoFac.bodymask.state == "visible") {
            var pageS = getPageSize();
            var m = sendInfoFac.bodymask;
            if (parseFloat(getStyle(m, "width")) != pageS.w * 1) setStyle(m, "width", pageS.w * 1 + "px");
            if (parseFloat(getStyle(m, "height")) != pageS.h * 1) setStyle(m, "height", pageS.h * 1 + "px");
        }
    };
    sendInfoFac.buildShim = function (div) {
        var shim = document.createElement("iframe");
        shim.src = "javascript:''";
        shim.frameBorder = "0";
        shim.scrolling = "no";
        shim.className = "iframeShim";
        setStyle(shim, "position", "absolute");
        setStyle(shim, "visibility", "hidden");
        setStyle(shim, "zIndex", getStyle(div, "zIndex") - 1);
        setStyle(shim, "top", "-100px");
        setStyle(shim, "left", "-100px");
        setStyle(shim, "width", isNaN(parseFloat(getStyle(div, "width"))) ? "0px" : parseFloat(getStyle(div, "width")) + "px");
        setStyle(shim, "height", "0px");
        return shim;
    };
    sendInfoFac.fixShimWH = function (div) {
        var div = div || sendInfoFac.div;
        if (sendInfoFac.div.shim) {
            setStyle(sendInfoFac.div.shim, "width", div.offsetWidth + "px");
            setStyle(sendInfoFac.div.shim, "height", div.offsetHeight + "px");
        }
    };
    sendInfoFac.showLoadingWH = function (type) {
        if (sendInfoFac.divLoading && sendInfoFac.div) {
            switch (type) {
                case "loading_e": sendInfoFac.divLoading.htmlCon.innerHTML = "<div class=\"load\"><h4>正在发送邮件......</h4></div>"; break;
                case "loading_m": sendInfoFac.divLoading.htmlCon.innerHTML = "<div class=\"load\"><h4>短信正在发送......</h4></div>"; break;
            }
            sendInfoFac.closeDiv(sendInfoFac.div, true);
            sendInfoFac.openDiv(sendInfoFac.divLoading, true);
            sendInfoFac.fixShimWH(sendInfoFac.divLoading);
        }
    };
    sendInfoFac.buildDivFrame = function () {
        if (!sendInfoFac.div) {
            function c(tag) {
                return document.createElement(tag);
            }
            var div = c("div");
            div.className = "popupSendInfo";
            div.state = "close";
            myAttachEvent(div, "click", function (e) { e = e || window.event; if (e.stopPropagation) e.stopPropagation(); else e.cancelBubble = true; });
            sendInfoFac.div = div;
            document.body.appendChild(div);
            div = c("div");
            div.className = "msgboxclose";
            div.onclick = function () { sendInfoFac.closeDiv(sendInfoFac.div); };
            sendInfoFac.div.appendChild(div);
            div = c("div");
            div.className = "msgtop";
            sendInfoFac.div.appendChild(div);
            div = c("div");
            div.className = "mainBlock";
            sendInfoFac.div.mainBlock = div;
            sendInfoFac.div.appendChild(div);

            var subdiv = c("div");
            subdiv.className = "msgTag";
            var ul = c("ul");
            ul.id = "msgTag";
            var li = c("li");
            var span = c("span");
            var a = c("a");
            a.appendChild(document.createTextNode("发送Email"));
            span.appendChild(a);
            li.appendChild(span);
            sendInfoFac.div.tabEmail = li;
            ul.appendChild(li);
            li = c("li");
            span = c("span");
            a = c("a");
            a.appendChild(document.createTextNode("发送短信"));
            span.appendChild(a);
            li.appendChild(span);
            sendInfoFac.div.tabMsg = li;
            ul.appendChild(li);
            subdiv.appendChild(ul);
            div.appendChild(subdiv);

            subdiv = c("div");
            subdiv.className = "";
            sendInfoFac.div.email = subdiv;
            div.appendChild(subdiv);
            subdiv = c("div");
            subdiv.className = "";
            sendInfoFac.div.msg = subdiv;
            div.appendChild(subdiv);

            div = c("div");
            div.className = "msgbottom";
            sendInfoFac.div.appendChild(div);

            div = c("div");
            div.className = "popupSendInfoLoad";
            div.state = "close";
            myAttachEvent(div, "click", function (e) { e = e || window.event; if (e.stopPropagation) e.stopPropagation(); else e.cancelBubble = true; });
            sendInfoFac.divLoading = div;
            document.body.appendChild(div);
            subdiv = c("div");
            subdiv.className = "guanbi";
            div.appendChild(subdiv);
            var subdiv2 = c("div");
            subdiv2.className = "close";
            subdiv2.onclick = function () { sendInfoFac.closeDiv(sendInfoFac.divLoading); };
            subdiv.appendChild(subdiv2);
            subdiv = c("div");
            sendInfoFac.divLoading.htmlCon = subdiv;
            div.appendChild(subdiv);
            if (isIE6) {
                var shim = sendInfoFac.buildShim(sendInfoFac.div);
                document.body.appendChild(shim);
                sendInfoFac.div.shim = shim;
            }
        }
    };
    sendInfoFac.openDiv = function (div, flag) {
        if (div && div.state == "close") {
            div.state = "open";
            sendInfoFac.positionDiv(div);
            setStyle(div, "visibility", "visible");
            if (sendInfoFac.div.shim) setStyle(sendInfoFac.div.shim, "visibility", "visible");
            if (!flag) sendInfoFac.bodymask.show();
        }
    };
    sendInfoFac.positionDiv = function (div) {
        var vwh = getViewportSize();
        div.x_abs = (vwh.w - div.offsetWidth) / 2;
        div.y_abs = (vwh.h - div.offsetHeight) / 2;
        var x = div.x_abs;
        var y = div.y_abs;
        if (isIE6) {
            var sxy = getScrollPosition();
            x += sxy.x;
            y += sxy.y;
        }
        setStyle(div, "left", x + "px");
        setStyle(div, "top", y + "px");
        if (sendInfoFac.div.shim) {
            setStyle(sendInfoFac.div.shim, "left", x + "px");
            setStyle(sendInfoFac.div.shim, "top", y + "px");
        }
    };
    sendInfoFac.closeDiv = function (div, flag) {
        if (div && div.state == "open") {
            div.state = "close";
            setStyle(div, "visibility", "hidden");
            setStyle(div, "top", "-100px");
            setStyle(div, "left", "-100px");
            if (sendInfoFac.div.shim) {
                setStyle(sendInfoFac.div.shim, "visibility", "hidden");
                setStyle(sendInfoFac.div.shim, "top", "-100px");
                setStyle(sendInfoFac.div.shim, "left", "-100px");
            }
            if (!flag) sendInfoFac.bodymask.hide();
        } else {
            jQuery(".popupSendInfo, .popupSendInfoLoad, .divMask").hide();
        }
    };
    sendInfoFac.lockDiv = function () {
        var div = null;
        if (sendInfoFac.div && sendInfoFac.div.state == "open") div = sendInfoFac.div;
        if (sendInfoFac.divLoading && sendInfoFac.divLoading.state == "open") div = sendInfoFac.divLoading;
        if (div) {
            if ("x_abs" in div && typeof (div.x_abs) == "number") {
                var sx = document.documentElement.scrollLeft || document.body.scrollLeft;
                setStyle(div, "left", (sx + div.x_abs) + "px");
                if (sendInfoFac.div.shim) setStyle(sendInfoFac.div.shim, "left", (sx + div.x_abs) + "px");
            }
            if ("y_abs" in div && typeof (div.y_abs) == "number") {
                var sy = document.documentElement.scrollTop || document.body.scrollTop;
                setStyle(div, "top", (sy + div.y_abs) + "px");
                if (sendInfoFac.div.shim) setStyle(sendInfoFac.div.shim, "top", (sy + div.y_abs) + "px");
            }
        }
    };
    if (isIE6) myAttachEvent(window, "scroll", sendInfoFac.lockDiv);
    sendInfoFac.genSelOptions = function (sel, data) {
        clearSelOptions(sel);
        sel.options[0] = new Option("请选择", "");
        if (data) {
            data = eval("(" + data + ")");
            for (var i = 0; i < data.length; i++) sel.options[sel.options.length] = new Option(data[i]["temptxt"], data[i]["tempval"]);
        }
    };
    sendInfoFac.prototype.fnClickTrig = function (e) {
        var s = this;
        if (e.stopPropagation) e.stopPropagation();
        else e.cancelBubble = true;
        s.candidate = [];
        for (var i = 0; i < s.chkbox.length; i++) if (s.chkbox[i].checked) s.candidate.push(i);
        if (s.candidate.length) s.popupDiv();
        else alert(sendInfoFac.tips[0]);
    };
    sendInfoFac.prototype.popupDiv = function () {
        var s = this;
        if (!sendInfoFac.div) sendInfoFac.buildDivFrame();
        s.genTabsHTML();
        s.setTabs("email");
        s.showWordNum("e");
        sendInfoFac.fixShimWH();
        sendInfoFac.buildBodyMask(true);
        sendInfoFac.openDiv(sendInfoFac.div);
    };
    sendInfoFac.prototype.genTabsHTML = function () {
        var s = this;
        sendInfoFac.div.email.innerHTML = s.genHTML("email");
        s.getEmailFormEle();
    };
    sendInfoFac.prototype.setTabs = function (type) {
        var s = this;
        switch (type) {
            case "email": setStyle(sendInfoFac.div.email, "display", "block"); setStyle(sendInfoFac.div.msg, "display", "none");
                sendInfoFac.div.tabEmail.className = "on"; sendInfoFac.div.tabEmail.onclick = null;
                sendInfoFac.div.tabMsg.className = ""; sendInfoFac.div.tabMsg.onclick = function () { s.fnClickMsgTab(); };
                break;
            case "msg": setStyle(sendInfoFac.div.email, "display", "none"); setStyle(sendInfoFac.div.msg, "display", "block");
                sendInfoFac.div.tabEmail.className = ""; sendInfoFac.div.tabEmail.onclick = function () { s.fnClickEmailTab(); };
                sendInfoFac.div.tabMsg.className = "on"; sendInfoFac.div.tabMsg.onclick = null;
                break;
        }
    };
    sendInfoFac.prototype.loading = function (isShow) {
        var loadingImg = document.getElementById("loadingImg");
        if (!loadingImg) {
            loadingImg = document.createElement("img");
            loadingImg.id = "loadingImg";
            document.getElementsByTagName("body")[0].appendChild(loadingImg);
        }
        if (isShow) {
            loadingImg.src = "/img/icon_loadingani.gif";
            loadingImg.style.position = "absolute";
            loadingImg.style.zIndex = "1001";
            loadingImg.style.left = (getViewportSize().w - 16) / 2 + getScrollPosition().x + "px";
            loadingImg.style.top = (getViewportSize().h - 16) / 2 + getScrollPosition().y + "px";
            loadingImg.style.display = "block";
            setTimeout(function () { loadingImg.style.display = "none"; }, 10000);
        } else {
            loadingImg.style.display = "none";
        }
    }
    sendInfoFac.prototype.fnClickMsgTab = function () {
        var s = this;
        s.loading(true);
        ajax({
            url: "/resumePreview/resume/_GetSmsNum?t=3",
            cache: false,
            onSuccess: function (data) {
                s.loading(false);
                if (data && sendInfoFac.div.state == "open") {
                    data = eval("(" + data + ")");
                    if (data["sms"] == 1 && data["num"] >= s.candidate.length) {
                        s.msgNum = data["num"];
                        sendInfoFac.div.msg.innerHTML = s.genHTML("msg");
                        s.getMsgFormEle();
                        s.setTabs("msg");
                        s.showWordNum("m");
                        sendInfoFac.fixShimWH();
                        sendInfoFac.positionDiv(sendInfoFac.div);
                    }
                    else if (data["sms"] != 1) alert(sendInfoFac.tips[2]);
                    else if (data["num"] < s.candidate.length) alert(sendInfoFac.tips[11]);
                }
            }
        });
    };
    sendInfoFac.prototype.fnClickEmailTab = function () {
        var s = this;
        s.setTabs("email");
        sendInfoFac.fixShimWH();
        sendInfoFac.positionDiv(sendInfoFac.div);
    };
    sendInfoFac.prototype.genHTML = function (type) {
        var s = this;
        var html = "";
        switch (type) {
            case "email": html += "<form name=\"emailForm\">\
        	<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"sendInfoTab\">\
            <tr><td nowrap class=\"titleTd\">收信人：</td>\
            	<td>" + s.genReceiverHTML() + "</td>\
                <td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>发信人：</td>\
            	<td><input style=\"max-width:148px;\" type=\"text\" name=\"sender\" value=\"" + s.sender + "\" size=\"22\" maxlength=\"100\"></td></tr>\
			<tr><td colspan=\"3\"></td><td id=\"senderErr_e\" class=\"error\"></td></tr>\
            <tr><td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>模板类型：</td>\
            	<td><select name=\"tempType\">\
					   <option value=\"\">请选择</option\>";
                for (var i in sendInfoFac.email) {
                    html += "<option value=\"" + i + "\">" + sendInfoFac.email[i] + "</option>";
                }
                html += "</select></td>\
                <td nowrap class=\"titleTd\">模板名称：</td>\
            	<td><select name=\"tempName\">\
					   <option value=\"\">请选择</option>\
					   </select></td></tr>\
			<tr><td></td><td colspan=\"3\" id=\"tempTypeErr_e\" class=\"error\"></td></tr>\
            <tr><td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>邮件主题：</td><td colspan=\"3\"><input style=\"max-width:380px;\" type=\"text\" name=\"subject\" value=\"\" size=\"60\" maxlength=\"40\" /></td></tr>\
			<tr><td></td><td colspan=\"3\" id=\"subjectErr_e\" class=\"error\"></td></tr>\
			<tr><td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>邮件正文：</td><td colspan=\"3\">&nbsp;</td></tr>\
            <tr><td colspan=\"4\"><textarea name=\"content_email\" id=\"content_email\" rows=\"5\"></textarea></td></tr>\
            <tr><td colspan=\"2\" id=\"content_emailErr_e\" class=\"error txtareErr\"></td><td colspan=\"2\" class=\"rightTips\" valign=\"top\">已输入<span class=\"red12px\" id=\"wordNum_e\">0</span>个字（1000字/封）</td></tr>\
            <tr><td colspan=\"4\">&nbsp;&nbsp;<span class=\"red12px\">* </span>接收回复邮箱：<input type=\"text\" name=\"r_email\" value=\"" + s.reply + "\" size=\"30\" maxlength=\"100\">（填写接收邮件的Email地址）</td></tr>\
			<tr><td colspan=\"4\" id=\"r_emailErr_e\" class=\"error\" style=\"padding-left:105px;\"></td></tr>\
            <tr><td colspan=\"4\" class=\"buttonTd\"><input name=\"submit\" type=\"button\" class=\"okButton\"></td></tr>\
            </table>\
            </form>"; break;
            case "msg": html += "<form name=\"msgForm\">\
        	<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"sendInfoTab\">\
            <tr><td nowrap class=\"titleTd\">收信人：</td>\
            	<td>" + s.genReceiverHTML() + "</td>\
                <td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>公司签名：</td>\
            	<td><input style=\"max-width:148px;\" type=\"text\" name=\"sender\" value=\"" + s.sender + "\" size=\"22\" maxlength=\"100\"></td></tr>\
			<tr><td colspan=\"3\"></td><td id=\"senderErr_m\" class=\"error\"></td></tr>\
            <tr><td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>模板类型：</td>\
            	<td><select name=\"tempType\"\>\
					   <option value=\"\">请选择</option>";
                for (var i in sendInfoFac.msg) {
                    html += "<option value=\"" + i + "\">" + sendInfoFac.msg[i] + "</option>";
                }
                html += "</select></td>\
                <td nowrap class=\"titleTd\">模板名称：</td>\
            	<td><select name=\"tempName\">\
					   <option value=\"\">请选择</option>\
					   </select></td></tr>\
			<tr><td></td><td colspan=\"3\" id=\"tempTypeErr_m\" class=\"error\"></td></tr>\
            <tr><td nowrap class=\"titleTd\"><span class=\"red12px\">* </span>消息内容：</td><td colspan=\"3\" class=\"tips\">内容最后会自动加上公司签名，其字数将记入180字范围内</td></tr>\
            <tr><td colspan=\"4\"><textarea name=\"content_msg\" id=\"content_msg\" rows=\"5\"></textarea></td></tr>\
			<tr><td colspan=\"4\" id=\"content_msgErr_m\" class=\"error txtareErr\"></td></tr>\
            <tr><td colspan=\"2\" class=\"leftTips\">将扣除<span class=\"red12px\" id=\"messageCount\">0</span>条短信数，可用余额：<span class=\"red12px\">" + s.msgNum + "</span>条</td><td colspan=\"2\" class=\"rightTips\">已输入+【公司签名】共<span class=\"red12px\" id=\"wordNum_m\">0</span>字(最多<span class=\"red12px\">180</span>字)</td></tr>\
            <tr><td colspan=\"4\" class=\"leftTips\"><input type=\"checkbox\" name=\"reply\">我不想接收求职者的短信回复<br><br>1、短信扣除规则<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;短信标准为60字/条<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;不足60字，按1条短信扣数；超出60字，按60字/条短信扣数。<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;短信内容最后加入的“【公司签名】”，算在短信总数内。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;短信内容涉及的系统标签{姓名}{职位名}{公司名}按照实际长度计算。<br><br>2、求职者收不到短信原因：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有可能为求职者手机软件进行屏蔽，运营商已经把短信发送给求职者，但<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由于求职者手机设置导致短信无法被查看。<br></td></tr>\
            <tr><td colspan=\"4\" class=\"buttonTd\"><input name=\"submit\" type=\"button\" class=\"okButton\"></td></tr>\
            </table>\
            </form>"; break;
        }
        return html;
    };
    sendInfoFac.prototype.getEmailFormEle = function () {
        var s = this;
        s.emailForm = document.getElementsByName("emailForm")[document.getElementsByName("emailForm").length-1];
        s.receiver_e = s.emailForm.receiver;
        s.sender_e = s.emailForm.sender;
        s.temptype_e = s.emailForm.tempType;
        s.tempname_e = s.emailForm.tempName;
        s.subject_e = s.emailForm.subject;
        s.content_e = s.emailForm.content_email;
        s.reply_e = s.emailForm.r_email;
        s.submit_e = s.emailForm.submit;
        if (s.temptype_e){
            s.temptype_e.onchange = function () { s.fnChangeTempType(this, "e"); };
        }
        if (s.tempname_e){
            s.tempname_e.onchange = function () { s.fnChangeTempName(this, "e"); };
        }
        if (s.subject_e){
            s.subject_e.onclick = function () { s.fnFocusContent(this, "e"); };
        }
        if (s.content_e){
            s.content_e.onclick = function () { s.fnFocusContent(this, "e"); };
            s.content_e.onkeyup = function () { s.showWordNum("e"); };
        }
        if (s.submit_e){
            s.submit_e.onclick = function () { s.fnSubmitEmail(); };
        }        
    };
    sendInfoFac.prototype.getMsgFormEle = function () {
        var s = this;
        s.msgForm = document.getElementsByName("msgForm")[document.getElementsByName("msgForm").length-1];
        s.receiver_m = s.msgForm.receiver;
        s.sender_m = s.msgForm.sender;
        s.temptype_m = s.msgForm.tempType;
        s.tempname_m = s.msgForm.tempName;
        s.content_m = s.msgForm.content_msg;
        s.reply_m = s.msgForm.reply;
        s.submit_m = s.msgForm.submit;
        if (s.temptype_m){
            s.temptype_m.onchange = function () { s.fnChangeTempType(this, "m"); };
        }
        if (s.tempname_m){
            s.tempname_m.onchange = function () { s.fnChangeTempName(this, "m"); };
        }
		if(s.sender_m){
		    s.sender_m.onkeyup = function () { s.showWordNum("m"); };
		}
        if (s.content_m){
            s.content_m.onclick = function () { s.fnFocusContent(this, "m"); };
            s.content_m.onkeyup = function () { s.showWordNum("m"); };
        }
        if (s.submit_m){
            s.submit_m.onclick = function () { s.fnSubmitMsg(); };
        }
    };
    sendInfoFac.prototype.genReceiverHTML = function () {
        var s = this;
        var nameStr = "";
        for (var z = 0, name = ""; z < s.candidate.length; z++) {
            name = s.getCandidateInfo(s.candidate[z], "name");
            if (name) nameStr += (nameStr == "" ? "" : ",") + name;
        }
        var nameStrFix = nameStr;
        if (nameStr.realLength() > sendInfoFac.receNameStrN) {
            nameStrFix = "";
            for (var i = 0, j = 0, c, f; i < nameStr.length; i++) {
                c = nameStr.charAt(i);
                f = /[^\x00-\xff]/.test(c);
                if (f) j += 2;
                else j++;
                if (j > sendInfoFac.receNameStrN - 1) break;
                nameStrFix += c;
            }
        }
        if (nameStrFix != nameStr) nameStrFix += "...";
        return "<span title=\"" + nameStr + "\">" + nameStrFix + "</span><input type=\"hidden\" name=\"receiver\" value=\"" + nameStr + "\">";
    };
    sendInfoFac.prototype.getCandidateInfo = function (cindex, type) {
        var s = this;
        var value = "";
        if (s.chkbox[cindex] && s.chkbox[cindex].nodeType == 1) {
            var candidate = s.chkbox[cindex].getAttribute(sendInfoFac.candidateAttName);
            if (candidate) candidate = candidate.split(sendInfoFac.candidateInfoSepa);
            if (type in sendInfoFac.candidate && candidate.length && candidate[sendInfoFac.candidate[type]]) return candidate[sendInfoFac.candidate[type]];
        }
        return value;
    };
    sendInfoFac.prototype.fnChangeTempType = function (typeSel, type) {
        var s = this;
        s.loading(true);
        if (s["temptype_" + type] && $(s["temptype_" + type].name + "Err_" + type)) $(s["temptype_" + type].name + "Err_" + type).innerHTML = "";
        if (s["subject_" + type] && $(s["subject_" + type].name + "Err_" + type)) $(s["subject_" + type].name + "Err_" + type).innerHTML = "";
        if (s["content_" + type] && $(s["content_" + type].name + "Err_" + type)) $(s["content_" + type].name + "Err_" + type).innerHTML = "";
        if (typeSel.value != "") {
            s["temptype_" + type].disabled = true;
            s["tempname_" + type].disabled = true;
            if (s["subject_" + type]) s["subject_" + type].disabled = true;
            s["content_" + type].disabled = true;
            ajax({
                url: "/resumePreview/resume/_GetNotifyTempByType?t=" + (type == "e" ? "1" : "2") + "&m=" + typeSel.value,
                cache: false,
                onComplete: function () {
                    s.loading(false);
                    if (sendInfoFac.div.state == "open") {
                        s["temptype_" + type].disabled = false;
                        s["tempname_" + type].disabled = false;
                        if (s["subject_" + type]) s["subject_" + type].disabled = false;
                        s["content_" + type].disabled = false;
                        sendInfoFac.fixShimWH();
                        sendInfoFac.positionDiv(sendInfoFac.div);
                    }
                },
                onSuccess: function (data) {
                    if (sendInfoFac.div.state == "open") {
                        sendInfoFac.genSelOptions(s["tempname_" + type], data);
                        if (s["subject_" + type]) s["subject_" + type].value = "";
                        s["content_" + type].value = "";
                        s.showWordNum(type);
                    }
                }
            });
        }
        else {
            clearSelOptions(s["tempname_" + type]);
            s["tempname_" + type].options[0] = new Option("请选择", "");
            if (s["subject_" + type]) s["subject_" + type].value = "";
            s["content_" + type].value = "";
            s.showWordNum(type);
            sendInfoFac.fixShimWH();
            sendInfoFac.positionDiv(sendInfoFac.div);
        }
    };
    sendInfoFac.prototype.fnChangeTempName = function (nameSel, type) {
        var s = this;
        if (s["subject_" + type] && $(s["subject_" + type].name + "Err_" + type)) $(s["subject_" + type].name + "Err_" + type).innerHTML = "";
        if (s["content_" + type] && $(s["content_" + type].name + "Err_" + type)) $(s["content_" + type].name + "Err_" + type).innerHTML = "";
        if (nameSel.value != "") {
            s["tempname_" + type].disabled = true;
            if (s["subject_" + type]) s["subject_" + type].disabled = true;
            s["content_" + type].disabled = true;
            ajax({
                url: "/resumePreview/resume/_GetNotifyContentById",
                data: "n=" + nameSel.value + (type == "e" ? "&t=1" : ""),
                cache: false,
                onComplete: function () {
                    if (sendInfoFac.div.state == "open") {
                        s["tempname_" + type].disabled = false;
                        if (s["subject_" + type]) s["subject_" + type].disabled = false;
                        s["content_" + type].disabled = false;
                        sendInfoFac.fixShimWH();
                        sendInfoFac.positionDiv(sendInfoFac.div);
                    }
                },
                onSuccess: function (data) {
                    if (sendInfoFac.div.state == "open") {
                        if (type == "e") {
                            if (data) {
                                data = eval("(" + data + ")");
                                s["subject_" + type].value = data["subject"];
                                s["content_" + type].value = data["content"];
                            }
                        }
                        else if (type == "m") s["content_" + type].value = s["temptype_" + type].options[s["temptype_" + type].selectedIndex].text + "：" + data;
                        s.showWordNum(type);
                    }
                }
            });
        }
        else {
            if (s["subject_" + type]) s["subject_" + type].value = "";
            s["content_" + type].value = "";
            s.showWordNum(type);
            sendInfoFac.fixShimWH();
            sendInfoFac.positionDiv(sendInfoFac.div);
        }
    };
    sendInfoFac.prototype.fnFocusContent = function (textarea, type) {
        var s = this;
        if (s["temptype_" + type].value == "") {
            alert(sendInfoFac.tips[1]);
            s["temptype_" + type].focus();
            textarea.blur();
        }
        else {
            if (type == "m" && textarea.value == "") {
                textarea.value = s["temptype_" + type].options[s["temptype_" + type].selectedIndex].text + "：";
                s.showWordNum("m");
            }
        }
    };
    sendInfoFac.prototype.fnSubmitEmail = function () {
        var s = this;
        var flag = s.checkEmailForm();
        sendInfoFac.fixShimWH();
        sendInfoFac.positionDiv(sendInfoFac.div);
        if (flag) {
            sendInfoFac.showLoadingWH("loading_e");
            var userList = "";
            for (var i = 0, userItem = ""; i < s.candidate.length; i++) {
			    var name = s.getCandidateInfo(s.candidate[i],"name").replace(";","&#59").replace("|","&#124");
				var position = s.getCandidateInfo(s.candidate[i],"position").replace(";","&#59").replace("|","&#124");
                userItem = s.getCandidateInfo(s.candidate[i], "id") + "|" + name + "|" + s.getCandidateInfo(s.candidate[i], "email") + "|" + s.getCandidateInfo(s.candidate[i], "xid") + "|" + position;
                userList += (userList == "" ? "" : ";") + userItem;
            }
            userList = userList.urlEncode();
            var modelType = s.temptype_e.value;
            var from = s.sender_e.value.urlEncode();
            var subject = s.subject_e.value.urlEncode();
            var emailBody = s.content_e.value.urlEncode();
            var reply = s.reply_e.value.urlEncode();
            var data = "t=1&userList=" + userList + "&modelType=" + modelType + "&from=" + from + "&subject=" + subject + "&emailBody=" + emailBody + "&reply=" + reply;
            ajax({
                url: "/resumePreview/resume/_SendNodifyEmail",
                data: data,
                cache: false,
                onSuccess: function (data) {
                    if (sendInfoFac.divLoading.state == "open") {
                        if (data == "true") {
                            sendInfoFac.divLoading.htmlCon.innerHTML = "<div class=\"email_Success\"><h4>您的邮件已发送！</h4></div><ul class=\"ul_1\"><li><a href=\"http://rd2.zhaopin.com/s/report/userEmail.asp\" target=\"_blank\">查看详情</a></li></ul><div class=\"enter\"><img src=\"/img/Confirmation.jpg\" onclick=\"sendInfoFac.closeDiv(sendInfoFac.divLoading)\" /></div>";
                            if (s.tdindex != "-1") s.freshListTabIcons("e");
                        }
                    }
                },
                onError: function () {
                    if (sendInfoFac.divLoading.state == "open") {
                        sendInfoFac.divLoading.htmlCon.innerHTML = "<div class=\"email_Error\"><h4>AJAX出错！</h4></div><div class=\"enter\"><img src=\"/img/Confirmation.jpg\" onclick=\"sendInfoFac.closeDiv(sendInfoFac.divLoading)\" /></div>";
                    }
                }
            });
        }
    };
    sendInfoFac.prototype.checkEmailForm = function () {
        function getErrHTML(formEle) {
            return $(formEle.getAttribute("name") + "Err_e");
        }
        var s = this;
        var flag = true;
        var html = getErrHTML(s.sender_e);
        if (s.sender_e.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[3];
            flag = false;
        }
        else html.innerHTML = "";
        html = getErrHTML(s.temptype_e);
        if (s.temptype_e.value == "") {
            html.innerHTML = sendInfoFac.tips[4];
            flag = false;
        }
        else html.innerHTML = "";
        html = getErrHTML(s.subject_e);
        if (s.subject_e.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[5];
            flag = false;
        }
        else html.innerHTML = "";
        html = getErrHTML(s.content_e);
        if (s.content_e.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[6];
            flag = false;
        }
        else {
            var txt = s.checkContentLength(s.content_e.value.trim(), "e");
            if (txt != "") {
                html.innerHTML = txt;
                flag = false;
            }
            else html.innerHTML = "";
        }
        html = getErrHTML(s.reply_e);
        if (s.reply_e.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[7];
            flag = false;
        }
        else {
            var r = /^[_a-zA-Z0-9\-]+(\.[_a-zA-Z0-9\-]*)*@[a-zA-Z0-9\-]+([\.][a-zA-Z0-9\-]+)+$/;
            if (!r.test(s.reply_e.value.trim())) {
                html.innerHTML = sendInfoFac.tips[8];
                flag = false;
            }
            else html.innerHTML = "";
        }
        return flag;
    };
    sendInfoFac.prototype.checkContentLength = function (content, type) {
        var s = this;
        var txt = "", l, candidate, position;
        var max = (type == "e" ? sendInfoFac.emailMax : sendInfoFac.msgMax);
        for (var i = 0; i < s.candidate.length; i++) {
            candidate = s.getCandidateInfo(s.candidate[i], "name");
            position = s.getCandidateInfo(s.candidate[i], "position");
            l = content.replace(sendInfoFac.placeholderRE.candidate, candidate).replace(sendInfoFac.placeholderRE.position, position).replace(sendInfoFac.placeholderRE.company, s["sender_" + type].value).length;
            if (l > max) txt += (txt == "" ? "" : ",") + candidate;
        }
        if (txt != "") txt += "的" + (type == "e" ? "邮件" : "消息") + "正文超过" + max + "字";
        return txt;
    };
    sendInfoFac.prototype.fnSubmitMsg = function () {
        var s = this;
        var flag = s.checkMsgForm();
        sendInfoFac.fixShimWH();
        sendInfoFac.positionDiv(sendInfoFac.div);
        if (flag) {
           var smsMsg = s.content_m.value.trim().replace(/[\t\n\r]/g, ' ').urlEncode();  //modify by lesanc.li 2012-3-16
		   var compSign = s.sender_m.value.trim().urlEncode();
	       var data1 ="smsMsg="+smsMsg+"["+compSign+"]";
			ajax({
				url:"http://rd.zhaopin.com/resumePreview/resume/_CheckSmsMessage",
				data:data1,
				cache : false,
				onSuccess:function(datas){
					datas = eval("("+datas+")");
					if(datas.keywords.length>0){
					   var textArr =[];
					   for(var i = 0;i< datas.keywords.length;i++){
						   var texts = "“"+datas.keywords[i]+"”";
						   textArr.push(texts);
					   }
					   var text = textArr.join("、");
						alert("因短信内容或公司名称包含电信运营商屏蔽的关键词\n"+text+"\n而不能发送，请修改后再次发送。\n为您带来的不便敬请原谅。");
					   return false;
					}else{
					   sendInfoFac.showLoadingWH("loading_m");
					   var userList = "";
						for(var i=0,userItem="";i<s.candidate.length;i++){
						    var name = s.getCandidateInfo(s.candidate[i],"name").replace(";","&#59").replace("|","&#124");
				            var position = s.getCandidateInfo(s.candidate[i],"position").replace(";","&#59").replace("|","&#124");
							userItem = s.getCandidateInfo(s.candidate[i],"id")+"|"+name+"|"+s.getCandidateInfo(s.candidate[i],"cellphone")+"|"+s.getCandidateInfo(s.candidate[i],"xid")+"|"+position+"|"+s.candidate[i];
							userList += (userList==""?"":";")+userItem;
						}
						userList = userList.urlEncode();
						var modelType = s.temptype_m.value;
						var needReply = s.reply_m.checked?"1":"0";
						var data = "t=2&userList="+userList+"&modelType="+modelType+"&compSign="+compSign+"&smsMsg="+smsMsg+"&needReply="+needReply;
						ajax({
							url        : "/resumePreview/resume/_SendNodifySms",
							data       : data,
							cache      : false,
							onSuccess  : function(data){
								if(data&&sendInfoFac.divLoading.state=="open"){
									data = eval("("+data+")");
									sendInfoFac.divLoading.htmlCon.innerHTML =	"<div class=\"Success\"><h4>短信发送情况提示！</h4></div>"+data["html"]+" <div class=\"enter\"><img src=\"http://rd2.zhaopin.com/s/images/erd2/Confirmation.jpg\" onclick=\"sendInfoFac.closeDiv(sendInfoFac.divLoading)\" /><div style=\"text-align:left;margin-left:5px;color:red\">温馨提示</div><p style=\"font-size:12px;color:red;margin:5px;text-align:left;text-indent:24px\">发送至短信运营商成功后，如果因关键词屏蔽或求职者手机屏蔽导致短信发送失败，敬请谅解！</p></div>";
									if(s.tdindex!="-1") s.freshListTabIcons("m",data["trindex"]);
								}
							},
							onError    : function(){
								if(sendInfoFac.divLoading.state=="open"){
									sendInfoFac.divLoading.htmlCon.innerHTML = "<div class=\"Error\"><h4>AJAX出错！</h4></div><div class=\"enter\"><img src=\"/s/images/erd2/Confirmation.jpg\" onclick=\"sendInfoFac.closeDiv(sendInfoFac.divLoading)\" /></div>";
								}
							}
						});
					}
				},
				onError:function(){
					alert("AJAX出错！");
				}
			});
        }
    };
    sendInfoFac.prototype.checkMsgForm = function () {
        var s = this;
        function getErrHTML(formEle) {
            return $(formEle.getAttribute("name") + "Err_m");
        }
        var s = this;
        var flag = true;
        var html = getErrHTML(s.sender_m);
        if (s.sender_m.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[9];
            flag = false;
        }
        else html.innerHTML = "";
        html = getErrHTML(s.temptype_m);
        if (s.temptype_m.value == "") {
            html.innerHTML = sendInfoFac.tips[4];
            flag = false;
        }
        else html.innerHTML = "";
        html = getErrHTML(s.content_m);
        if (s.content_m.value.trim() == "") {
            html.innerHTML = sendInfoFac.tips[10];
            flag = false;
        }
        else {
            var txt = s.checkContentLength(s.content_m.value.trim() + "[" + s.sender_m.value.trim() + "]", "m");
            if (txt != "") {
                html.innerHTML = txt;
                flag = false;
            }
            else html.innerHTML = "";
        }
        return flag;
    };
   sendInfoFac.prototype.showWordNum = function (type) {
        var s = this;
		var  candidate, position;
        var html = $("wordNum_" + type);
        var textarea = s["content_" + type];
		if(type==="m"){
		    var countElement = $("messageCount");
			var content = textarea.value.replace(/(^\s*)|(\s*$)/g, "")+"["+s.sender_m.value.trim()+"]";
			for (var i = 0; i < s.candidate.length; i++) {
				candidate = s.getCandidateInfo(s.candidate[i], "name");
				position = s.getCandidateInfo(s.candidate[i], "position");
				var messLen = content.replace(sendInfoFac.placeholderRE.candidate, candidate).replace(sendInfoFac.placeholderRE.position, position).replace(sendInfoFac.placeholderRE.company, s["sender_" + type].value).length;
			    if (html && textarea) {html.innerHTML = messLen};
				if(s.candidate.length>1){
					countElement.innerHTML = (Math.ceil(messLen/60))*s.candidate.length;
				}else{
					countElement.innerHTML = Math.ceil(messLen/60);
			   }
			}
		}else{
           if (html && textarea) html.innerHTML = textarea.value.length;
		}
    };
    sendInfoFac.prototype.freshListTabIcons = function (type, trindex) {
        var s = this;
        if (s.candidate && s.candidate.length && s.chkbox && s.chkbox.length) {
            if (type == "e")
                for (var i = 0, tr, td; i < s.candidate.length; i++) {
                    tr = s.chkbox[s.candidate[i]] && getParentByTagName(s.chkbox[s.candidate[i]], "tr");
                    if (tr) {
                        td = tr.getElementsByTagName("td")[s.tdindex];
                        if (td && td.nodeType == 1 && !sendInfoFac.hasEmailIcon(td)) td.appendChild(sendInfoFac.createEmailIcon());
                    }
                }
            else if (type == "m" && trindex) {
                trindex = trindex.split(",");
                for (var i = 0, tr, td; i < trindex.length; i++) {
                    tr = trindex[i] && s.chkbox[trindex[i]] && getParentByTagName(s.chkbox[trindex[i]], "tr");
                    if (tr) {
                        td = tr.getElementsByTagName("td")[s.tdindex];
                        if (td && td.nodeType == 1 && !sendInfoFac.hasMsgIcon(td)) td.appendChild(sendInfoFac.createMsgIcon());
                    }
                }
            }
        }
    };
    myAttachEvent(window, "resize", sendInfoFac.fixBodyMask);
})()