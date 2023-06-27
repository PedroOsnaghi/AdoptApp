if (typeof jQuery === 'undefined'){
	throw new Error('jquery-rate-picker requires jQuery');
}
(function ($){
	"use strict";
	$.ratePicker = function (target, options){
		if (typeof options === 'undefined') options = {};
		options.max = typeof options.max === 'undefined' ? 5 : options.max;
		options.rgbOn = typeof options.rgbOn === 'undefined' ? "#fcac1d" : options.rgbOn;
		options.rgbOff = typeof options.rgbOff === 'undefined' ? "#ecf0f1" : options.rgbOff;
		options.rgbSelection = typeof options.rgbSelection === 'undefined' ? "#f3d37c" : options.rgbSelection;
		options.cursor = typeof options.cursor === 'undefined' ? "pointer" : options.cursor;
		options.indicator = typeof options.indicator === 'undefined' ? "fa fa-star" : "fa "+options.indicator;
		options.starSize = typeof options.starSize === 'undefined' ? "16px" : options.starSize;
		options.starPadding = typeof options.starPadding === 'undefined' ? "5px 0px" : options.starPadding;
		options.counterStyle = typeof options.counterStyle === 'undefined' ? "{}" : options.counterStyle;
		options.counterClass = typeof options.counterClass === 'undefined' ? "{}" : options.counterClass;


		var stars = typeof $(target).data('stars') == 'undefined' ? 0 : $(target).data('stars');

		$(target).css('cursor', options.cursor);
		$(target).append($("<input>", {type : "hidden", name : target.replace("#", ""), value : stars}));

		// $(target).append($("<i>", {class : options.indicator, style : "color: transparent;"}));
		for (var i = 1; i <= options.max; i++){
			if(i == 1){
				$(target).append($("<i>", {class : options.indicator, style : "color: transparent;width:15px; padding: 5px 0px" + ";font-size:" + options.starSize }));
			}else{
				$(target).append($("<i>", {class : options.indicator, style : "color:" + (i <= stars ? options.rgbOn : options.rgbOff) + ";padding:" + options.starPadding + ";font-size:" + options.starSize}));
			}

		}

		$(target).append($("<span>",{id: "counter-star",class: options.counterClass ,style: options.counterStyle}));
		$('#counter-star').html(0);
		// $(target).append($("<i>", {class : options.indicator, style : "color: transparent;"}));

		$.each($(target + " > i"), function (index, item){
			$(item).click(function (){
				$("[name=" + target.replace("#", "") + "]").val(index);
				$('#counter-star').html(index);
				for (var i = 1; i <= options.max; i++){
					$($(target + "> i")[i]).css("color", i <= index ? options.rgbOn : options.rgbOff);
				}
				if (!(options.rate === 'undefined')){
					options.rate(index > options.max ? options.max : index);
					stars = index;
				}
			});
			$(item).mouseover(function (){
				$("[name=" + target.replace("#", "") + "]").val(index);
				$('#counter-star').html(index);
				for (var i = 1; i <= options.max; i++){
					$($(target + " > i")[i]).css("color", i <= index ? options.rgbSelection : options.rgbOff);
				}
			});
			$(item).mouseleave(function(){
				$('#counter-star').html(stars);
				for (var i = 1; i <= options.max; i++){
					$($(target + "> i")[i]).css("color", i <= stars ? options.rgbOn : options.rgbOff);
				}
			});
		});
	};
})(jQuery);
