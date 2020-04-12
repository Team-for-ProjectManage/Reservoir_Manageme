var informationData;
var watherInfo;
var echartsData;

$(function(){

	 $('#myTab li:eq(1) a').tab('show');
	 searchInfoData();
	 
	 //初始化页面数据
	 initData();
	 
	 //获得折线图数据
	 getEchartsData("24");
	 
	 echartOption()
	 
});

function initData(){
	$("#totalPersion").text(informationData.tatalPersion);
	$("#waterLevel").text(informationData.waterLevel);
	$("#storageCapacity").text(informationData.storageCapacity);
	$("#dataTime").text(informationData.dataTime);
	$("#dataTime2").text(informationData.dataTime);
	$("#realWather").text(watherInfo.realWather);
	$("#temperature").text(watherInfo.temperature);
	$("#week").text(informationData.week);
	$("#wather").text(watherInfo.wather);
	$("#cityInfo").text(watherInfo.cityInfo);
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

//查询页面需要的值
function getEchartsData(hour){
	$.ajax({
	    type: "post",
	    url: "/information/getEchartsData",
	    data: {
	    	hour:hour
	    },
	    dataType: "json",
	    async: false,
	    success: function (res) {
	        if(res.status == "200") {
	        	echartsData = res.data;
	        }
	    }
	});
}

function echartOption(){
   var title = {
      text: '实时库容'   
   };
   var xAxis = {
	   title: {
	         text: '时间/小时'
	      },
      categories: echartsData.hourList
   };
   var yAxis = {
      title: {
         text: '库容 (万方)'
      },
      plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
      }]
   };   

   var legend = {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle',
      borderWidth: 1
   };

   var series =  [
      {
         name: '实时库容',
         data: echartsData.storageCapacityList
      }
      ,
      {
         name: '水位',
         data: echartsData.waterLevelList
      }
   ];

   var json = {};

   json.title = title;
   json.xAxis = xAxis;
   json.yAxis = yAxis;
   json.legend = legend;
   json.series = series;
   
   $('#buyIn').highcharts(json);
}

$("#houtOption").change(function(){
	
	 alert($("#sel option:selected").text())
	
	 var houtOption =  $("#houtOption option:selected").text();
	 //获得折线图数据
	 getEchartsData(houtOption);
	 
	 echartOption()
})

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

