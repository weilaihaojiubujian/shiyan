function backLogin() {
    window.location.href = ("denlu.jsp");
}

$(document).ready(function () {

    var username = $("#username");
    var password = $("#password");
    var confirm = $("#confirm");
    var address = $("#address");
    var bankAccount = $("#bankaccount");
    var IdCard = $("#card");
    var span1 = $("#uspan");
    var span2 = $("#psdspan");
    var span3 = $("#confirmSpan")
    var span4 = $("#addspan");
    var span5 = $("#bkspan");
    var span6 = $("#cspan");
    var passwordReg = /^[0-9a-zA-Z]+$/;
    var idReg15 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
    var idReg18 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;

    // 用户名
    username.blur(function () {
        if (username.val() == "") {
            username.focus();
            span1.css("color", "red");
            span1.text("用户名不能为空 ×");
        } else if (username.val().length > 13) {
            username.focus();
            span1.css("color", "red");
            span1.text("用户名不能超过13位×");
        } else {
            span1.css("color", "green");
            span1.text("用户名符合要求√");
        }
    })
    //密码
    password.blur(function () {
        if (password.val() == "") {
            span2.css("color", "red");
            password.focus();
            span2.text("密码不能为空×");
        } else if (password.val().length > 13) {
            span2.css("color", "red");
            password.focus();
            span2.text("密码长度为不能超过13位×");
        } else if (!passwordReg.test(password.val())) {
            span2.css("color", "red");
            password.focus();
            span2.text("密码只能是字母和数字×");
        } else {
            span2.css("color", "green");
            span2.text("密码符合要求√");
        }
    })
    //确认密码
    confirm.blur(function () {
        //如果密码存在
        if (password.val() != "") {
            if (confirm.val() != password.val()) {
                password.focus();
                span3.css("color", "red")
                span3.text("两次密码不一致×");
            } else if (confirm.val() == password.val()) {
                span3.css("color", "green")
                span3.text("两次密码一致√");
            }
        }
    })
    //地址
    address.blur(function () {
        if (address.val() == "") {
            address.focus();
            span4.css("color", "red");
            span4.text("地址不能为空 ×");
        } else {
            span4.text("");
        }
    })
    //银行账户
    bankAccount.blur(function () {
        if (bankAccount.val() == "") {
            bankAccount.focus();
            span5.css("color", "red");
            span5.text("银行账户不能为空 ×");
        } else {
            span5.text("");
        }
    })
    //身份号
    IdCard.blur(function () {
            if (IdCard.val() == "") {
                IdCard.focus();
                span6.css("color", "red");
                span6.text("身份证号不能为空 ×");
            }
            else if (IdCard.val().length == 15) {
                if (!idReg15.test(IdCard.val())) {
                    IdCard.focus();
                    span6.css("color", "red");
                    span6.text("身份证号格式错误 ×");
                } else {
                    span6.css("color", "green");
                    span6.text("身份证号格式正确 √");
                }
            } else if (IdCard.val().length == 18) {
                if (!idReg18.test(IdCard.val())) {
                    IdCard.focus();
                    span6.css("color", "red");
                    span6.text("身份证号格式错误 ×");
                } else   {
                    span6.css("color", "green");
                    span6.text("身份证号格式正确 √");
                }

            }
            else  {
                IdCard.focus();
                span6.css("color", "red");
                span6.text("身份证号格式不对 ×");
            }
        }
    )


})