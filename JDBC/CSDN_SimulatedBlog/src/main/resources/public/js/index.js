function logout(){

}

$(function () {
    $.ajax({
        url:"/api/article/query",   //查询所有文章的uri
        success:function (r) {   //成功  r = {success:true, data: {user:xxx,articles:xxx}}
                if (r.success){
                    let data = r.data;
                    if (data.user) {
                        $("#index_login").show();  //显示登录后的div
                        $("#index_unlogin").hide();  //隐藏未登录的div
                    }else {
                        $("#index_unlogin").show();
                        $("#index_login").hide();
                    }
                    let content = "";
                    for (let a of data.articles){
                     content += "<li>";
                     content +=    "<a href='javascript:void(0)'>";
                     content +=        a.title;
                     content +=    "</a>"
                     content += "</li>"
                    }
                    $("#index_articles").html(content);
                }else {
                 alert("错误码:", + r.code + "\n错误消息:" + r.message)
                }
        },
        error:function (err,textStatus,thr) {  //出错
            alert("状态码:" + err.status)   //弹出出错的状态码
        }
    })
})