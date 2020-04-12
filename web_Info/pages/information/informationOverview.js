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
	 //巡查记录
	 potalCheckRecord();
	 //巡查任务
	 //potalCheckRask();
});

function getSelected() {
	var houtOption =  $("#houtOption option:selected").val();
	//获得折线图数据
	getEchartsData(houtOption);
	echartOption()
}

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

//初始化巡检记录表格
function potalCheckRecord(){
	$('#potalCheckRecordTable').bootstrapTable('destroy');
	$('#potalCheckRecordTable').bootstrapTable({
        columns: [
            {
            	field:'checkName',
                title:'巡查计划名称',
                width:120
            },
            {
                field:'checkUser',
                title:'巡查员',
                width:120

            },{
                field:'startTime',
                title:'开始时间',
                width:120
            },{
                field:'endTime',
                title:'结束时间',
                width:60,
            },{
                field:'remark',
                title:'备注',
                width:60,
            }
        ], 
        url: '/information/getPotalCheckData',         //请求后台的URL（*）
		method: 'get',                      //请求方式（*）
		dataType: "json",
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: 'queryParams',         //传递参数（*）
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [5, 10, 25],       		 //可供选择的每页的行数（*）
        //smartDisplay:false,
        search: false,                      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        //strictSearch: true,
        showColumns: false,                 //是否显示所有的列
        showRefresh: false,                 //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle:false,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
    });
}

//初始化巡检任务表格
function potalCheckRask(){
	$('#potalCheckRaskTable').bootstrapTable('destroy');
	$('#potalCheckRaskTable').bootstrapTable({
		columns: [
			{
				field:'checkName',
				title:'巡查任务名称',
				width:120
			},{
				field:'startTime',
				title:'开始时间',
				width:120
			},{
				field:'endTime',
				title:'结束时间',
				width:60,
			},{
				field:'remark',
				title:'备注',
				width:60,
			}
			], 
			url: '/information/getPotalCheckResk',         //请求后台的URL（*）
			method: 'get',                      //请求方式（*）
			dataType: "json",
			toolbar: '#toolbar',                //工具按钮用哪个容器
			striped: true,                      //是否显示行间隔色
			cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,                   //是否显示分页（*）
			sortable: true,                     //是否启用排序
			sortOrder: "asc",                   //排序方式
			queryParams: 'queryParams',         //传递参数（*）
			sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,                       //初始化加载第一页，默认第一页
			pageSize: 10,                       //每页的记录行数（*）
			pageList: [5, 10, 25],       		 //可供选择的每页的行数（*）
			//smartDisplay:false,
			search: false,                      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			//strictSearch: true,
			showColumns: false,                 //是否显示所有的列
			showRefresh: false,                 //是否显示刷新按钮
			minimumCountColumns: 2,             //最少允许的列数
			clickToSelect: true,                //是否启用点击选中行
			height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "id",                     //每一行的唯一标识，一般为主键列
			showToggle:false,                   //是否显示详细视图和列表视图的切换按钮
			cardView: false,                    //是否显示详细视图
			detailView: false,                   //是否显示父子表
	});
}

$("#potalCheckRecord").click(function)(){
	potalCheckRecord();
	$("#query0").css("display","none");//隐藏div
    $("#query1").css("display","block");//显示div
})

$("#potalCheckRask").click(function)(){
	potalCheckRask();
	$("#query0").css("display","block");//隐藏div
    $("#query1").css("display","none");//显示div
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

