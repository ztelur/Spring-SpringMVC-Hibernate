/**
 * Created by homer on 16-12-17.
 */


/**
 * Created by homer on 16-12-6.
 */


$(document).ready(function () {
    //这是一个非常简单的demo实例，让列表元素分页显示
    //回调函数的作用是显示对应分页的列表项内容
    //回调函数在用户每次点击分页链接的时候执行
    //参数page_index{int整型}表示当前的索引页
    var initPagination = function(totalPage, pageSize) {
        // 创建分页
        $("#Pagination").pagination(totalPage, {
            num_edge_entries: 1, //边缘页数
            num_display_entries: 1, //主体页数
            callback: pageselectCallback,
            items_per_page:1 //每页显示1项
        });
    };

    var load = function () {
        var pathName = document.location.pathname;
        pathName = pathName.substring(1,pathName.length);
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = "/" + pathContext + "/equipments";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=1",
            success: function (data) {
                var page = data.data;
                var totalPage = page.totalPage;
                var pageSize = page.pageSize;
                initPagination(totalPage, pageSize);
            }
        });

    }();



    function pageselectCallback(page_index, jq){
        console.log(page_index + " " + jq);
        var currentUrl = window.location.href;
        console.log(currentUrl);
        var pageSize = 10;

        var pathName = document.location.pathname;
        pathName = pathName.substring(1,pathName.length);
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = "/" + pathContext + "/equipments";


        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=" + (page_index+1) + "&pageSize=" + pageSize,
            success: function (data) {

                var page = data.data;
                var pageNum = page.pageSize;
                var equipments = page.data;
                $('.row-list').empty();
                for (var i = 0; i <  equipments.length; i++) {
                    var equipment = equipments[i];
                        $('.row-list').append('<div class="grid_4"> <div class="box"> <a href="' +
                            url + "/" + equipment.id + '" class="gall_item"><img src="' +
                            equipment.url + '" alt=""></a> <div class="box_bot"><div class="box_bot_title">' +
                            equipment.name + '</div></div> </div> </div>');
                }
            }
        });
        return true;
    }
});


