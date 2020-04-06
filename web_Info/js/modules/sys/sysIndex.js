$(function () {
    $('#sidebarLoginOut, #loginOut').off("click").on("click", function () {
        $.messager.confirm("提示","确认要退出系统吗？",function(r){
            if(r) {
                sessionStorage.removeItem("userId");
                location.href = '/user/logout';
            }
        });
    });

    //广告循环
    var loginName = sessionStorage.getItem("loginName");
    if(loginName == "jsh") {
        //根据时间戳决定展示aliyun还是tencent
        function autoChangeTip() {
            var timestamp=new Date().getTime();
            var checkShow = timestamp%2;
            if(checkShow) {
                $(".aliyun").show();
                $(".tencent").hide();
            } else {
                $(".aliyun").hide();
                $(".tencent").show();
            }
        }
        setInterval(function () {
            autoChangeTip();
        }, 10 * 1000);
    }

    //更新消息条数
    function getMsgCountByStatus() {
        $.ajax({
            type: "get",
            url: "/msg/getMsgCountByStatus?status=1",
            dataType: "json",
            success: function (res) {
                if (res && res.code === 200) {
                    if(res.data) {
                        var count = res.data.count;
                        $("#msgNum, #msgNum2").text(count);
                    }
                }
            }
        });
    }
    getMsgCountByStatus();
    setInterval(function() {
        getMsgCountByStatus()
    }, 1000*60);

});