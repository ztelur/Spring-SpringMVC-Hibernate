/**
 * Created by zang on 16-12-14.
 */


$(document).ready(function () {
    //这是一个非常简单的demo实例，让列表元素分页显示
    //回调函数的作用是显示对应分页的列表项内容
    //回调函数在用户每次点击分页链接的时候执行
    //参数page_index{int整型}表示当前的索引页
    var initPagination = function (totalPage, pageSize) {
        // 创建分页
        $("#Pagination").pagination(totalPage, {
            num_edge_entries: 1, //边缘页数
            num_display_entries: 1, //主体页数
            callback: pageselectCallback,
            items_per_page: 1 //每页显示1项
        });

    };
    var load = function () {
        var pathName = document.location.pathname;
        pathName = pathName.substring(1,pathName.length);
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = "/" + pathContext + "/articles";

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



});
function pageselectCallback(page_index, jq) {
    var currentUrl = window.location.href;
    var pageSize = 10;

    var pathName = document.location.pathname;
    pathName = pathName.substring(1,pathName.length);
    var index = pathName.indexOf("/");
    var pathContext = pathName.substring(0, index);
    console.log("ddd" + pathContext + " " + pathName);
    var url = "/" + pathContext + "/articles";


    $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        data: "pageNum=" + (page_index + 1) + "&pageSize=" + pageSize,
        success: function (data) {
            var page = data.data;
            var pageNum = page.pageSize;
            var articles = page.data;
            $('.news_list_container').empty();
            for (var i = 0; i < articles.length; i++) {
                var news = articles[i];
                $('.news_list_container').append(
                    '<li> <span class="title"> <a href=' + url + '/' + news.id + '>' + news.title + '</a> ' +
                    '</span><br>' +
                    '<span class="hits">' +
                    '<a type="button" class="edit_button" href="/' + pathContext + '/articles/manage/' + news.id + '">编辑</a>&nbsp&nbsp&nbsp' +
                    '<a type="button" class="delete_button" id="' + news.id + '" value="' + news.id + '" onclick="delete_article(' + news.id + ')">删除</a>' +
                    '</span>' +
                    '<span class="time">' + news.date + '</span> <span class="class">分类：' + news.category + ' </span> </li>');
            }
        }
    });
    return true;
}
function delete_article(id) {
    var pathName = document.location.pathname;
    pathName = pathName.substring(1,pathName.length);
    var index = pathName.indexOf("/");
    var pathContext = pathName.substring(0, index);
    var url = "/" + pathContext + "/articles/manage/delete/" + id;
    console.log($('#Pagination').children('span.current').not('.current.prev'));
    console.log($('#Pagination').children('span.current').not('.current.prev').eq(0).html());
    console.log($('#Pagination').children('.prev').not('.current.prev'));
    $.get(url, {success: 'success'}, function (data) {
        if (data.result == 1) {
            alert('删除成功');
            console.log($('#Pagination').children().filter('.current').eq(1).html());
            var page_num = $('#Pagination').children('span.current').not('.current.prev').eq(0).html() - 1;
            console.log(page_num);
            pageselectCallback(page_num, null);
        }
        else {
            alert('删除失败');
        }
    })
}
