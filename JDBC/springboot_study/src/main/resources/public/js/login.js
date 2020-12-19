$(function main() { //html加载完执行方法
    $("#login_form").submit(function () {  //绑定表单的提交事件

        $.ajax({
            url:"data/login.json",
            type:"get",  // 请求方法
            //dataType:"x-www-form-urlencoded"  //请求数据类型
            data:$("#login_form").serialize(),  //使用表单数据
            contentType:"application/json", //响应数据类型
            success:function (resp) {
            alert(JSON.stringify(resp))   //提示框显示JSON对象转为字服符串
            }
        })
        //alert("submit");
        return false;   //返回值决定是否使用表单的默认提交
    })
})