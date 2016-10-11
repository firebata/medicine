$(function(){
	$('.list_bottoml').each(function(i, ele){
		var tiemDiv = $(ele), d = tiemDiv.find('.rob_day'), h = tiemDiv.find('.rob_hour'), m = tiemDiv.find('.rob_min'), s = tiemDiv.find('.rob_sec');
		//倒计时时间
		var time=new Date().getTime()/1000 + (60*60*24* Number(d.text())) + (60*60* Number(h.text())) + (60* Number(m.text()))+  + Number(s.text());
		xcsoft.countdown(time,function(obj){
			var t = (60*60*24* obj.day) + (60*60* obj.hour) + (60* obj.minute) + obj.second, cls = '';
				
			if(t == 0){
				tiemDiv.css("display","none");
				var href = tiemDiv.data('redirect-url');
				if(href){
					window.location.href = href;
				};
			}else{
				d.text(obj.day);
				h.text(obj.hour);
				m.text(obj.minute);
				s.text(obj.second);
			}
		});
	});
});