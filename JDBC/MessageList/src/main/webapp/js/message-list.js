$(function () {

    setTimeout(function () {
        $.get("message-list-show",function (data) {
            let body =  $("body");

            for (i in data) {
                let message  = data[i];
                let html = "<tr>" +
                    "<td>" +message.id+ "</td>"+
                    "<td>" +message.who+ "</td>"+
                    "<td>" +message.when+ "</td>"+
                    "<td>" +message.what+ "</td>"+
                    "</tr>>"
                body.append(html);
            }
        });
    },3000);
});