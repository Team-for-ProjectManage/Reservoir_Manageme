var informationData;
var watherInfo;

$(function(){

	 $('#myTab li:eq(1) a').tab('show');
	 searchInfoData();
	 
	 //初始化页面数据
	 initData();
});

function initData(){
	$("#totalPersion").text(informationData.totalPersion);
	$("#waterLevel").text(informationData.waterLevel);
	$("#storageCapacity").text(informationData.StorageCapacity);
	$("#dataTime").text(informationData.dataTime);
	$("#realWather").text(watherInfo.realWather);
	$("#temperature").text(watherInfo.temperature);
	$("week").text(informationData.week);
	$("wather").text(watherInfo.wather);
}

//查询页面需要的值
function searchInfoData(){
	$.ajax({
	    type: "post",
	    url: "/information/getInfoData",
	    dataType: "json",
	    async: false,
	    success: function (res) {
	        if(res.status == "200") {
	        	informationData = res.data;
	        	watherInfo = res.data.wather;
	        }
	    }
	});
}

$(window).resize(function () {
    var footerHeight = $('.main-footer').outerHeight() || 0;
    var windowHeight = $(window).height();
    $('.content').css('min-height', windowHeight - footerHeight)
}).resize();

$('.ui-sortable').sortable({
    placeholder: 'sort-highlight',
    connectWith: '.ui-sortable',
    handle: '.box-header, .nav-tabs',
    forcePlaceholderSize: true, zIndex: 999999
}).find('.box-header, .nav-tabs').css('cursor', 'move');

