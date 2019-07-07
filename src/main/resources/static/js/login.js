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

    $(".btn-login").click(function () {
        var username = $.trim($("#username").val());
        var password = $.trim($("#password").val());

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

        $.ajax({
            async: true,
            type: "POST",
            url: "/login",
            dataType: "JSON",
            data: {
                username: username,
                password: password
            },
            beforeSend: function () {
                MaskUtil.mask();
            },
            success: function (data) {
                if (data.code == 1) {
                    window.location.href = "index.html";
                    $(".tip").hide();
                } else {
                    $(".tip").fadeIn(1500);
                    $(".tip").text(data.msg);
                }
            },
            complete: function () {
                MaskUtil.unmask();
            },
            error: function (data) {
                window.location.href = "errors.html";
            }
        });
    });

    /**
     * 按回车键提交表单
     */
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $(".btn-login").click();
        }
    });

    $("#log-form input").focus(function () {
        $(".tip").fadeOut(1000);
        $(this).css({"border": "1px solid #9494ff", "background-color": "#fff"});
    });
    $("#log-form input").blur(function () {
        $(this).css("border", "1px solid #c3c3c3");
    });

});