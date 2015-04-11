<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="public/frame/head.jsp" flush="true"/>
<div class="container">
<div class="panel">
<div class="panel-body">
<div id="bd_toptab">
    <h4 class="refresh"></h4>
    <div class="tabblock" id="tabblock"></div>
</div>
    <script>
        var tpl = [[{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [2, 2], pos: [0, 1] }], [{ size: [2, 2], pos: [0, 0] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 1], pos: [1, 2] }], [{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [1, 2], pos: [0, 1] }, { size: [1, 1], pos: [1, 1] }, { size: [1, 1], pos: [1, 2] }], [{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [1, 1], pos: [0, 1] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 2], pos: [1, 1] }], [{ size: [1, 2], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [1, 1], pos: [1, 1] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 1], pos: [1, 2] }], [{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [0, 1] }, { size: [1, 2], pos: [1, 0] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 1], pos: [1, 2] }], [{ size: [2, 1], pos: [0, 0] }, { size: [1, 1], pos: [0, 1] }, { size: [1, 1], pos: [1, 1] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 1], pos: [1, 2] }], [{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [2, 1], pos: [0, 1] }, { size: [1, 1], pos: [0, 2] }, { size: [1, 1], pos: [1, 2] }], [{ size: [1, 1], pos: [0, 0] }, { size: [1, 1], pos: [1, 0] }, { size: [1, 1], pos: [0, 1] }, { size: [1, 1], pos: [1, 1] }, { size: [2, 1], pos: [0, 2] }]];
        var colors = ["#6e89a0", "#3e6181", "#f19b83", "#f3ab97", "#6696c1","#0000CC","#006699","#00CCCC","#000099","#3300CC","#990000"];
        var data = [
            {
                "id": "12281",
                "title": "关联算法",
                "ltitle": "charm算法是一种很常见的关联算法",
                "url": "view/algorithm/queryAlgo.jsp",
                "img": ""
            },
            {
                "id": "11886",
                "title": "文件上传",
                "ltitle": "",
                "url": "view/dataset/importFile.jsp",
                "img": ""
            },
            {
                "id": "12275",
                "title": "任务管理",
                "ltitle": "管理所有生成的任务",
                "url": "TaskIndexServlet.do",
                "img": ""
            },
            {
                "id": "12211",
                "title": "注册账户",
                "ltitle": "注册成为新用户，你可以享受我们所有的服务",
                "url": "register.jsp",
                "img": ""
            },
            {
                "id": "12276",
                "title": "查看信息",
                "ltitle": "查看您的个人信息",
                "url": "",
                "img": ""
            },
            {
                "id": "12264",
                "title": "聚类算法",
                "ltitle": "charm算法是一种很常见的关联算法",
                "url": "",
                "img": ""
            },
            {
                "id": "12263",
                "title": "频繁模式算法",
                "ltitle": "charm算法是一种很常见的关联算法",
                "url": "",
                "img": ""
            },
            {
                "id": "12119",
                "title": "分类算法",
                "ltitle": "charm算法是一种很常见的关联算法",
                "url": "",
                "img": ""
            },
            {
                "id": "12268",
                "title": "任务实例管理",
                "ltitle": "charm算法是一种很常见的关联算法",
                "url": "",
                "img": ""
            },
            {
                "id": "11074",
                "title": "结果管理",
                "ltitle": "中国失独家庭已超百万 每年约增长7.6万个",
                "url": "",
                "img": ""
            },
            {
                "id": "12273",
                "title": "查看结果",
                "ltitle": "再现打砸抢！巴西上千民众抵制世界杯",
                "url": "",
                "img": ""
            }

        ];


        $("#bd_toptab .refresh").click(function () {
            $("#tabblock").empty();
            tpl.sort(function () { return 0.5 - Math.random() });

            data.sort(function () { return 0.5 - Math.random() });

            var html = '<div id="bd_hot">', count = 0, l = t = w = h = 0, s = 4;
            for (var i = 0; i < 4; i++) {

                for (var k = 0; k < tpl[i].length; k++) {
                    if (count >= data.length) {
                        break;
                    }

                    var item = tpl[i][k];
                    w = item.size[0] == 1 ? 238 : 484;
                    h = item.size[1] == 1 ? 150 : 308;
                    l = item.pos[0] == 0 ? 492 * i : 492 * i + 246;
                    if (item.pos[1] == 0) {
                        t = 0;
                    } else if (item.pos[1] == 1) {
                        t = 158;
                    } else {
                        t = 316;
                    }

                    item = data[count];
                    html += '<div class="box" style="width:' + w + 'px;height:' + h + 'px;top:' + t + 'px;left:' + l + 'px;background-color:' + colors.sort(function () { return 0.5 - Math.random() })[0] + '"><a href="' + item.url + '" target="_blank" class="img tp_12">';
                    if (item.img) {
                        html += '<img src="' + item.img + '" />';
                    }
                    html += '<span class="main_title">' + item.title + '</span><div><p><strong>' + item.title + '</strong><span class="sub_title">' + item.ltitle + '</span></p></div></a></div>';
                    count++;
                }
            }
            html += '</div>';
            $("#tabblock").html(html);

            $('#tabblock .box').each(function () {
                var _this = $(this), _title = _this.find('.main_title'), _p = _this.find('p'), h = _this.height();
                _title.css('padding-top', (h - _title.height()) / 2 + 'px');
                _p.css('padding-top', (h - _p.height()) / 2 + 'px');

                _this.hover(function () {
                    _this.find('div').animate({ height: '100%' }, 300);
                }, function () {
                    _this.find('div').animate({ height: '0' }, 300);
                });
            });
        }).click();
    </script>
</div>
</div>
</div>

<%@ include file="public/frame/bottom.jsp" %>