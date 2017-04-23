/**
 * Created by homer on 16-12-16.
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
        var currentUrl = window.location.href;
        var pathName = document.location.pathname;
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = pathContext + "/papers";
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
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = pathContext + "/papers";


        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=" + (page_index + 1) + "&pageSize=" + pageSize,
            success: function (data) {

                var page = data.data;
                var pageNum = page.pageSize;
                var papers = page.data;
                $('.news_list_container').empty();
                for (var i = 0; i <  papers.length; i++) {
                    var paper = papers[i];
                    console.log("the url is " + paper.url);
                    $('.news_list_container').append('<h1 class="paper-title"><span>' +
                                    paper.title + '<br></span></h1> <p class="paper-desc">' +
                                    paper.desc +
                                    '</p><p class="paper-time">' +
                                    paper.date.replace("-", "/") +
                                    "-" +
                                    '<a href="' + paper.url + '" download>点击下载 </a><a href="' +
                                    paper.url +
                                    '"><img src="/images/pdf_button.png" border="0"></a></p>'
                );
                }

            }
        });
        return true;
    }
});