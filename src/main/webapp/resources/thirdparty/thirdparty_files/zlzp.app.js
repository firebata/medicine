// 智联招聘全站通用方法
if (!window.zlzp){
	window.zlzp = {};
}

zlzp.App = {
	loading : function(bShow){
		if (!$("#ajaxLoading").length){
			$("body").append('<div id="ajaxLoading" style="display:none;"></div>');
		}
		if (bShow === false){
			$("#ajaxLoading").hide();			
		} else {
			$("#ajaxLoading").css({
				"position" : "absolute",
				"z-index" : "9999",
				"left" : $(window).width() / 2 - 16 + "px",
				"top" : $(window).height() / 2 - 16 + "px"
			}).html('<img src="http://myimg.zhaopin.com/images/new_v3/ani_ajaxload.gif" \/>')
			.show();
		}
	},
    placeHolder : function(el, tips, supportLowBrowser){
    if (supportLowBrowser === undefined){supportLowBrowser = true;}
        if (typeof document.createElement("input").placeholder != "undefined"){
            $(el).attr("placeholder", tips);
        } else if(supportLowBrowser){
            $(el).bind("focus", function(){
                if($(this).val() == tips){
                    $(this).val("").css("color","#000000");
                }
            }).bind("blur", function(){
                if($.trim($(this).val()) == "" || $(this).val() == tips){
                    $(this).val(tips).css("color","#999999");
                }
            }).trigger("blur");
        }
    },
    // 显示元素的提示信息功能，支持多元素调用同一个提示文本框
    showInfo : function(inObj, infoObj, isHover, fn1, fn2){
        var s = null; // 记录当前操作的元素
        var el = null; // 记录上次操作的元素
        var dt = null; // 鼠标移开元素的时间对象
        if (typeof(isHover)!== "boolean"){isHover = false;}
        if (!(fn1 instanceof Function)){
          fn1 = function(){infoObj.show();};
        }
        if (!(fn2 instanceof Function)){
          fn2 = function(){infoObj.hide();};
        }
        // 信息文本框的鼠标事件 
        infoObj.mouseenter(function(){
          clearTimeout(dt);
        }).mouseleave(function(e){
          clearTimeout(dt);
          dt = setTimeout(function(){fn2(el);}, 500);
        });
        // 元素本身的鼠标事件
        inObj.each(function(){
          $(this).click(function(){
            fn1($(this));
          }).mouseleave(function(){
            el = $(this);
            clearTimeout(dt);
            dt = setTimeout(function(){fn2(el);}, 500);
          });
          if (isHover){
            $(this).mouseenter(function(){
              s = $(this);
              if (el && el != s){
                  clearTimeout(dt);
                  dt = setTimeout(function(){fn2(el);fn1(s);}, 100);
              } else {
                fn1(s);
              }
            });
          }
        });
    },
    // 字数提示功能
    inputLimit: function(el, n, vtype, ttype){
        var editPanel = $(el).parents("form");
        vtype = vtype || "val";
        ttype = ttype || "yes";
        var elLen = 0;
        var timeId = null;
        if(ttype=="yes"){
            var limitwords = $(el).next('.limitwords');
            if(!limitwords.length) {
                limitwords = $('<div class="limitwords"></div>');
                if (vtype==="text"){
                    $(el).parents(".qeditor_border").after(limitwords);
                } else {
                    $(el).after(limitwords);
                }
            }
            limitwords.hide();
            updateText();
        }
        $(el).bind("focus", function(){
            if(ttype=="yes"){
                setTimeout(function(){limitwords.show();}, 0);
                timeId = setInterval(function(){    
                    updateText();
                }, 500);
            }
        });
        var _rh = $(el).height();
        $(el).bind("keypress", function(event){
            event = event || window.event;
            elLen = (vtype == "val")?real_length2($(el).val()):real_length2($(el).text());
            if (elLen >= 2*n && event.keyCode != 8){
                return false;
            } 
        });
        $(el).bind("paste", function(e){
           updateText();
        });  
        editPanel[0].onsubmit = preventSubmit;
        $("input[type='submit'],button[type='submit']", editPanel).click(preventSubmit);
        function preventSubmit(e){
            elLen = (vtype == "val")?real_length($(el).val()):real_length($(el).text());
            if (elLen > n){
                App.loading(false);
                e.preventDefault();
                e.stopPropagation();
                return false;
            }
        }
        function updateText(){
            elLen = (vtype == "val")?real_length($(el).val()):real_length($(el).text());
            if (elLen > n){
                limitwords.html('<span style="color:red">已经超过' + (elLen - n) + '个汉字</span>');
            } else {
                limitwords.html('您还可以输入' + (n - elLen) + '个汉字');
            }
        }
        function real_length(str) {
            var elLen = str.length;
            var dStr = str.match(/[\u4e00-\u9fa5\uf900-\ufa2d]/g);
            if (dStr != null) elLen+=dStr.length;
            elLen=Math.ceil(elLen/2);
            return elLen;
        }
        function real_length2(str) {
            var elLen = str.length;
            var dStr = str.match(/[\u4e00-\u9fa5\uf900-\ufa2d]/g);
            if (dStr != null) elLen+=dStr.length;
            return elLen;
        }
    },
    // 输入框自适应高度
    autoHeight : function(el, lineHeight){
        lineHeight = lineHeight || 12;
        el = $(el);
        var rh = el.height();          
        el.css({"overflow":"hidden"});
        el.bind("keyup", updateHeight);
        el.bind("input", updateHeight);
        el.bind("paste", updateHeight);
        function updateHeight(e){
          if (e.keyCode === 8 || e.keyCode === 46){
              el.css("height","auto");   
          }
          var sh = el[0].scrollHeight;
          if ($.browser.webkit){
            sh -= lineHeight;
          }
          if (sh > rh){
            el.css("height", sh + "px");
          } else {
			el.css("height", rh + "px");
		  }
        }
    }
};