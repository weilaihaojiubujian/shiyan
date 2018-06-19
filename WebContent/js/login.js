function jumpToRegister() {
    window.location.href=("zhuce.jsp");
}
$(document).ready(function () {
    var useaname=$("#username");
    var password=$("#password");
    var span1=$("#user_span");
    var span2=$("#password_span");

    useaname.blur(function () {
        if(useaname.val()==""){
            span1.css("color","red");
            span1.text("用户名不能为空×");
            useaname.focus();
        }else {
            span1.text("");
        }
    })
    password.blur(function () {
        if(password.val()==""){
            span2.css("color","red");
            span2.text("密码不能为空×");
            password.focus();
        }else
            span2.text("");
    })

})