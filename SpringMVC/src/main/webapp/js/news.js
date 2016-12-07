/**
 * Created by homer on 16-12-6.
 */


$(document).ready(function () {
    //这是一个非常简单的demo实例，让列表元素分页显示
    //回调函数的作用是显示对应分页的列表项内容
    //回调函数在用户每次点击分页链接的时候执行
    //参数page_index{int整型}表示当前的索引页
    var initPagination = function() {
        // 创建分页
        $("#Pagination").pagination(20, {
            num_edge_entries: 2, //边缘页数
            num_display_entries: 4, //主体页数
            callback: pageselectCallback,
            items_per_page:2 //每页显示1项
        });

    }();
    function pageselectCallback(page_index, jq){
        console.log(page_index + " " + jq);
        var pageSize = 10;
        $.ajax({
            type: "GET",
            dataType: "text",
            url: "",
            data: "pageIndex=" + (page_index) + "&pageSize=" + pageSize,
            success: function (data) {
                //后台服务
                data = {
                    "pageIndex": 1,
                    "pageSize": 10,
                    "data": [
                        {
                            "id": "1",
                            "title": "第一个新闻",
                            "date": "2016.2.2",
                            "category": "新闻",
                            "readTime":"23"
                        },
                        {
                            "id": "2",
                            "title": "第二个新闻",
                            "date": "2016.2.2",
                            "category": "新闻",
                            "readTime":"23"
                        }
                    ]
                };
                var newsList = data.data;
                $('.news_list_container').empty();
                for (var i = 0; i < newsList.length; i++) {
                    var news = newsList[i];
                    $('.news_list_container').append('<li> <span class="title"><a href="' + news.id
                        + ' title="' + news.title + '">' + news.title + page_index + '</a></span><br> <span class="time">' +
                        news.date + '</span> <span class="class">分类：' + news.category  + ' </span> </li>');
                }
            }
        });
        return true;
    }
});


