$(function () {

    $('.trees li a').bind("click", function () {
        var title = $(this).text();
        var url = $(this).attr('data-link');
        var iconCls = $(this).attr('data-icon');
        var iframe = $(this).attr('iframe') == 1 ? true : false;
        addTab(title, url, iconCls, iframe);
    });

    getLoginUserName();

    $.extend($.fn.validatebox.defaults.rules, {
        old_pwd: {
            validator: function (value) {
                if (value.length > 50) {
                    $.fn.validatebox.defaults.rules.old_pwd.message = "你输入的旧密码长度过长";
                    return false;
                } else {
                    return true;
                }
            }
        },
        new_pwd: {
            validator: function (value) {
                if (value.length > 50) {
                    $.fn.validatebox.defaults.rules.new_pwd.message = "你输入的新密码长度过长";
                    return false;
                } else {
                    return true;
                }
            }
        },
        again_new_pwd: {
            validator: function (value) {
                if (value.length > 50) {
                    $.fn.validatebox.defaults.rules.again_new_pwd.message = "你输入的新密码长度过长";
                    return false;
                } else {
                    return true;
                }
            }
        }
    });

    //关闭当前
    $("#close-current").click(function () {
        var currTab = $('#tabs').tabs('getSelected');
        var currTitle = currTab.panel('options').title;
        $('#tabs').tabs('close', currTitle);
    });

    //关闭其他
    $("#close-other").click(function () {
        var currTab = $('#tabs').tabs('getSelected');
        var currTitle = currTab.panel('options').title;

        $(".tabs li").each(function (i, n) {
            var title = $(n).text();
            if (currTitle != title) {
                $('#tabs').tabs('close', title);
            }
        });
    });

    //关闭所有
    $("#close-all").click(function () {
        $(".tabs li").each(function (i, n) {
            var title = $(n).text();
            $('#tabs').tabs('close', title);
        });
    });

    //为选项卡绑定右键
    $(".tabs li").live('contextmenu', function (e) {
        /* 选中当前触发事件的选项卡 */
        var subtitle = $(this).text();
        $('#tabs').tabs('select', subtitle);
        //显示快捷菜单
        $('#menu').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
        return false;
    });


});


/**
 * 添加菜单选项
 * @param title
 * @param href
 * @param iconCls
 * @param iframe
 */
function addTab(title, href, iconCls, iframe) {
    var tabPanel = $('#tabs');
    if (!tabPanel.tabs('exists', title)) {
        var content = '<iframe frameborder="0" scrolling="auto" src="' + href + '" style="width:100%;height:100%;"></iframe>';
        if (iframe) {
            tabPanel.tabs('add', {
                title: title,
                content: content,
                iconCls: iconCls,
                fit: true,
                cls: 'pd3',
                closable: true
            });
        } else {
            tabPanel.tabs('add', {
                title: title,
                href: href,
                iconCls: iconCls,
                fit: true,
                cls: 'pd3',
                closable: true
            });
        }
    } else {
        tabPanel.tabs('select', title);
    }
}

/**
 * 获取登录用户名
 */
function getLoginUserName() {
    $.ajax({
        async: false,
        type: "POST",
        url: "/getUserName",
        dataType: "text",
        success: function (data) {
            if (data != "") {
                if (data == "admin") {
                    $('div#user-manage ul:first').show();
                } else {
                    $('div#user-manage ul:first').hide();
                }
                $(".north-right p strong").text(data);
            }
        },
        error: function () {
            window.location.href = "error.html";
        }
    });
}

/**
 * 清空session
 */
function logout() {
    $.ajax({
        async: false,
        type: "GET",
        url: "/logout",
        success: function () {
            window.location.href = "login.html";
        },
        error: function () {
            window.location.href = "error.html";
        }
    });
}

/**
 * 修改密码
 */
function resetPassword() {
    $('#old_pwd').textbox("setValue", '');
    $('#new_pwd').textbox('setValue', '');
    $('#again_new_pwd').textbox('setValue', '');
    $('#reset-password-dialog').dialog({
        closed: false,
        modal: true,
        title: "修改密码",
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: function () {
                if (!$('#form-reset-password').form('validate')) {
                    return;
                }
                if ($.trim($("#old_pwd").val()) == $.trim($("#new_pwd").val())) {
                    $.messager.alert('提示', '新密码和旧密码不能相同！', 'info');
                    return;
                }
                if ($.trim($("#new_pwd").val()) != $.trim($("#again_new_pwd").val())) {
                    $.messager.alert('提示', '两次输入的新密码不一致！', 'info');
                    return;
                }
                $.ajax({
                    async: false,
                    type: "POST",
                    url: "reset_password.action",
                    dataType: "text", // 预期服务器返回的数据类型
                    data: {
                        oldPassword: $.trim($("#old_pwd").val()),
                        newPassword: $.trim($("#new_pwd").val())
                    },
                    success: function (data) {
                        if (data == "0") {
                            $('#reset-password-dialog').dialog('close');
                            $.messager.alert({
                                title: '提示',
                                msg: '重置密码成功！',
                                icon: 'info',
                                fn: function () {
                                    logout();
                                    window.location.href = "login.html";
                                }
                            });
                        } else if (data == "1") {
                            $.messager.alert('提示', '你所输入的旧密码有误！', 'info');
                        } else {
                            window.location.href = "error.html";
                        }

                    },
                    error: function () {
                        window.location.href = "error.html";
                    }
                });
            }
        }, {
            text: '取消',
            iconCls: 'icon-cancel',
            handler: function () {
                $('#reset-password-dialog').dialog('close');
            }
        }]
    });
}

/**
 * 退出登录
 */
function exit() {
    $.messager.confirm('提示', '你确定要退出登录？', function (r) {
        if (r) {
            logout();
        }
    });
}

/**
 * 关于系统
 */
function about() {
    $.messager.alert('版权提示', 'CIS系统 版权所有！', 'info');
}