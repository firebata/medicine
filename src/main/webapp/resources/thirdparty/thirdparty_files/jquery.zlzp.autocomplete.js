/*
 * 自动输入提示功能
 * 制作：2012-9-4
 * 修改：2012-11-6 by lesanc.li
 */
!function($){
    var ac = {};
    ac.div = $(".autocomplete-tips-box");
    ac.ele = null;
    ac.select = function(){};
    ac.ajaxTimer = null;
    ac.createTipsBox = function(el){
        if (!ac.div.length){
            ac.div = $('<div class="autocomplete-tips-box" style="display:none;"></div>');
            ac.div.append('<ul></ul>');
            ac.div.css({
                "position": "absolute",
                "left":     el.offset().left + "px",
                "top":      el.offset().top + el.outerHeight() + "px",
                "z-index" : 9008
            });
             // 选择事件  jquery版本兼容的处理
            try{
                $(".autocomplete-tips-box li").live("click", function(){
                    ac.select($(this).text(), ac.ele);
                });
            }catch(e){
                $(document).on('click', '.autocomplete-tips-box li', function(){
                    ac.select($(this).text(), ac.ele);
                });
            }
            $("body").append(ac.div);
        }
    };
    ac.updateTipList = function(data, format, el){ 
        ac.div.find("ul").empty();
        $.each(data, function(i){
            var dt = format(data[i]);
            ac.div.find("ul").append('<li>'+dt+'</li>');
        });
        ac.ele = el;
        ac.showDiv();
    };
    ac.showDiv = function(){
        if (ac.ele){       
            ac.div.css({
                "left": ac.ele.offset().left + "px",
                "top":  ac.ele.offset().top + ac.ele.outerHeight() + "px"
            });
            ac.div.show();
        }
    };
    ac.hideDiv = function(){
        setTimeout(function(){
            ac.div.hide();
        }, 200);
    };

    $.fn.autocomplete = function(opts){
        return this.each(function(){
            var el = $(this);

            // 默认参数
            var cfg = {
                data : [],
                keyword : function(kw, el){return kw},
                format : function(data){return data},
                filter : function(data, kw){return data},
                select : function(txt, el){
                    el.val(txt);
                }
            };
            // 参数覆盖
            cfg = $.extend(cfg, opts);

            ac.select = cfg.select;
            
            // 匹配项过滤
            var filter = function(data, kw){
                var newData = [];
                $.each(data, function(i){
                    if (cfg.filter(data[i], kw)){
                        newData.push(data[i]);
                    };
                });
                return newData;
            };
            // 更新提示框内容
            var uplist = function(data, kw, format){
                data = filter(data, kw);
                if (data.length > 0){
                    ac.updateTipList(data, format, el);
                } else {
                    ac.hideDiv();
                }
            };
            // 获得提示框内容
            var getlist = function(){
                var kw = el.val(), data, success, str, ajaxOpts;
                clearTimeout(ac.ajaxTimer);
                kw = cfg.keyword(kw, el);
                if (!kw){
                    ac.hideDiv();
                    return;
                }
                if (cfg.data.url){               
                    ajaxOpts = $.extend({}, cfg.data);
                    ajaxOpts.data = $.extend({}, cfg.data.data);
                    // 重写ajax回调
                    success = cfg.data.success || function(){};
                    ajaxOpts.success = function(res){
                        res = success(res) || res;
                        uplist(res, kw, cfg.format);
                    };
                    // 替换关键词
                    ajaxOpts.url = cfg.data.url.replace("{kw}", kw);
                    for (var key in ajaxOpts.data){
                        str = cfg.data.data[key];
                        str = str.replace(/{kw}/g, kw);
                        ajaxOpts.data[key] = str;
                    }                  
                    // ajax请求
                    ac.ajaxTimer = setTimeout(function(){
                        $.ajax(ajaxOpts);
                    }, 300);
                } else {
                    uplist(cfg.data, kw, cfg.format);
                }
            };

            // 生成提示框
            ac.createTipsBox(el);

            // 绑定事件
            var flagStopKey = false;
            el.keydown(function(e){
                var box = $(".autocomplete-tips-box"), li = box.find("li"), hoverObj, index, ah = "ac-hover";
                flagStopKey = false;
                if (li.length){
                    hoverObj = box.find("li." + ah);
                    index = hoverObj.length?hoverObj.index():-1;
                    if (e.keyCode === 38){  // 键盘上键
                        if (index < 1){
                            li.removeClass(ah).eq(-1).addClass(ah);
                        } else {
                            li.removeClass(ah).eq(index - 1).addClass(ah);
                        }
                        flagStopKey = true;
                    } else if (e.keyCode === 40){  // 键盘下键
                        if (index === li.length - 1){
                            li.removeClass(ah).eq(0).addClass(ah);
                        } else {
                            li.removeClass(ah).eq(index + 1).addClass(ah);
                        }
                        flagStopKey = true;
                    } else if (e.keyCode === 13 && box.is(":visible") && index > -1){  //  键盘回车键
                        cfg.select(hoverObj.text(), el);
                        el.trigger("blur");
                        flagStopKey = true;   
                    }
                }
                if (flagStopKey){
                    e.preventDefault();
                    e.stopPropagation();
                    return false;
                }
            }).keyup(function(e){
                if (!flagStopKey){
                    getlist();
                }
            }).click(getlist).bind("paste", function(){
                setTimeout(function(){
                    getlist();
                }, 0);
            }).blur(ac.hideDiv);

        });
    };
}(jQuery);