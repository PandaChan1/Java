$(function main() {
   setInterval(function () {
       $.get("getcount",function (data) {
        $("#contents").html(data);
       });
   },2000);
});