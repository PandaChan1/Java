$(function () {
    //绑定表单提交时间，返回false，相当于禁止表单的默认提交
  $("#login_form").submit(function () {
      //校验表单数据
      //发起ajax请求
      $.ajax({
          url:'../api/user/login',
          type:'post',//请求方法
          // dataType   不写默认表单提交
          data:$("#login_form").serialize(),    //表单数据序列化为k1=v1&k2=v2
          //前后端接口的数据：成功{success：true}
          //失败：{success：false，code:xxx,message:xxx}
          success:function (r) {
              //成功：跳转到首页

              if (r.success) {
                  //js相对路径是以引入的html文件作为参照点
                  window.location.href = "../index.html";
              }
              //失败：显示错误信息
              else {
                  $("#err_message").show();
                  $("#err_message").html(r.message);
              }
          },
          error:function (req,status,error) {
                alert(req.status)
          }
      })
      return false;
  })
})