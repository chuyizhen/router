var confLogin = function(){
	function init()
	{
		fml.username.focus();
	}
	return{
		init:function(){init();}
	}
}();


function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	var err_mess = document.getElementById("error-message");
	if(username=="")
	{
		showMess();
		err_mess.innerHTML="请输入账号";
		fml.username.focus();
		return false;
	}
	else if(password=="")
	{
		showMess();
		err_mess.innerHTML="请输入密码";
		fml.password.focus();
		return false;
	}
	else
	{
		hideMess();	
	}
	var datajson = {"username":username, "password":password};
	var url = 'ajaxlogin.action';
	$.ajax({
        type: "POST",
        url: url,
        dataType: "json",
        data: datajson,
        success: responseLogin,
        error: function () {
        }
    });
}
var responseLogin = function(data, textStatus, jqXHR)
{
	var err_mess = document.getElementById("error-message");
	if(data.status=="ok")
	{
		window.location.href="userAction_home.action";
	}
	else
	{
		showMess();
		err_mess.innerHTML="账号或密码错误";
	}
}

function showMess(){
	var error_mess = document.getElementById("error-mess");
	error_mess.style.display='block';
}
function hideMess(){
	var error_mess = document.getElementById("error-mess");
	error_mess.style.display='none';
}