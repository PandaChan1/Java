$(function () {  //网页加载完成之后执行里面的方法逻辑
    //$("#id")通过id获取页面元素,绑定表单的提交事件
$("#login_form").submit(function () {
    //自己ajax提交表单数据，
    $.ajax({
        url:"../login",  //请求服务路径
        type:"post",  //请求方法
        //请求数据类型，不使用，默认为表单提交.如果是json要注明是json
        // contentType:"application/json"
        data:$("#login_form").serialize(),   //序列化表单数据格式

        dataType:"json",  //响应的数据类型

        success:function (r) {
        if (r.success) {
            window.location.href = "../jsp/articleList.jsp";
        }else{
            alert("错误码:" + r.code +"\n错误信息:"+ r.message);
        }
        }


    })

    //禁用表单的默认提交

    return false;

})
})