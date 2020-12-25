$(function main() { //html加载完执行方法
    $("#login_form").submit(function () {  //绑定表单的提交事件

        $.ajax({
           url:"../data/login.json",
           //  url:"../data/login2.json",
            type:"get",  // 请求方法
            //dataType:"x-www-form-urlencoded"  //请求数据类型
            data:$("#login_form").serialize(),  //使用表单数据
            contentType:"application/json", //响应数据类型
            success:function (resp) {
                //success为true跳转到main页面，否则提示code和message
                if (resp.success) {
                    //把地址栏url改为指定的值
                    window.location.href = "../views/main.html";
                }else{
                    alert("错误码：" + resp.code + "\n" + "错误信息：" + resp.message)
                }
                //alert(JSON.stringify(resp))   //提示框显示JSON对象转为字符串
            },
            error:function (req,testStatus,err) {
                alert(req.status)
            }
        })
        //alert("submit");
        return false;   //返回值决定是否使用表单的默认提交
    })
})