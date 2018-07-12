
function confirmOpe() {
    var value = document.getElementById('addmoney').value;
    if (value == "") {
        alert("金额输入不能为空");
        return false;
    }else if(value < 0){
        document.getElementById('addmoney').value = "";
        alert("充值的钱不能为负数,请重新输入");
        return false;
    }else if(isNaN(value)){
        document.getElementById('addmoney').value = "";
        alert("只能为数字,不能有其他字符,请重新输入");
        return false;
    }else {
        if (window.confirm("确定充值" + value + "元?")) {
            return true;
        } else {
            return false;
        }
    }

}
function confirmOpe2() {
    var value = document.getElementById('reducemoney').value;
    if (value == "") {
        alert("金额输入不能为空");
        return false;
    }else if(value < 0){
        document.getElementById('reducemoney').value = "";
        alert("提现的钱不能为负数,请重新输入");
        return false;
    }else if(isNaN(value)){
        document.getElementById('reducemoney').value = "";
        alert("只能为数字,不能有其他字符,请重新输入");
        return false;
    }else {
        if (window.confirm("确定提现" + value + "元?")) {
            return true;
        } else {
            return false;
        }
    }

}
