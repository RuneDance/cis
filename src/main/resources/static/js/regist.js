/**
 * Created by yyt on 2018/6/8.
 */
$(document).ready(function () {
    /**
     * 屏蔽浏览器右键功能
     */
    $(document).bind("contextmenu", function (e) {
        return false;
    });

    if (window != top) {
        top.location.href = location.href;
    }

    $(".tip").hide();

    $(".btn-regist").click(function () {
        var username = $.trim($("#username").val());
        var password = $.trim($("#password").val());
        var repassword = $.trim($("#repassword").val());
        var sex = $.trim($("#sex input[type='radio']:checked").val());
        var phone = $.trim($("#phone").val());
        var email = $.trim($("#email").val());

        if (username == "") {
            $(".tip").fadeIn(1500);
            $(".tip").text('用户名不能为空');
            return false;
        }

        if (password == "") {
            $(".tip").fadeIn(1500);
            $(".tip").text('密码不能为空');
            return false;
        }

        if (repassword == "") {
            $(".tip").fadeIn(1500);
            $(".tip").text('确认密码不能为空');
            return false;
        }

        if (password != repassword) {
            $(".tip").fadeIn(1500);
            $(".tip").text('两次密码不一致');
            return false;
        }

        if (phone == "") {
            $(".tip").fadeIn(1500);
            $(".tip").text('手机号不能为空');
            return false;
        }

        if (email == "") {
            $(".tip").fadeIn(1500);
            $(".tip").text('邮箱不能为空');
            return false;
        }

        $.ajax({
            async: true,
            type: "POST",
            url: "/regist",
            dataType: "JSON",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({
                username: username,
                password: password,
                sex: sex,
                phone: phone,
                email: email
            }),
            beforeSend: function () {
                MaskUtil.mask();
            },
            success: function (data) {
                if (data.code == 1) {
                    window.location.href = "login.html";
                    $(".tip").hide();
                } else {
                    $(".tip").fadeIn(1500);
                    $(".tip").text(data.msg);
                }
            },
            complete: function () {
                MaskUtil.unmask();
            },
            error: function () {
                window.location.href = "error.html";
            }
        });
    });

    /**
     * 按回车键提交表单
     */
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $(".btn-regist").click();
        }
    });

    $("#reg-form input").focus(function () {
        $(".tip").fadeOut(1000);
        $(this).css({"border": "1px solid #9494ff", "background-color": "#fff"});
    });
    $("#reg-form input").blur(function () {
        $(this).css("border", "1px solid #c3c3c3");
    });

});