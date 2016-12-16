/**
 * Created by zang on 16-12-14.
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

});

function delete_article(id){
  var pathName = document.location.pathname;
  var index = pathName.indexOf("/");
  var pathContext = pathName.substring(0, index);
  var url = pathContext + "/equipments/manage/delete/"+id;
  console.log($('#Pagination').children('span.current').not('.current.prev'));
  console.log($('#Pagination').children('span.current').not('.current.prev').eq(0).html());
  console.log($('#Pagination').children('.prev').not('.current.prev'));
  $.get(url,{success:'success'},function(data){
      if(data.result==1){
        alert('删除成功');
        console.log($('#Pagination').children().filter('.current').eq(1).html());
        var page_num=$('#Pagination').children('span.current').not('.current.prev').eq(0).html()-1;
        console.log(page_num);
        pageselectCallback(page_num,null);
      }
      else{
        alert('删除失败');
      }
  })
}

function pageselectCallback(page_index, jq){
    var currentUrl = window.location.href;
    var pageSize = 10;

    var pathName = document.location.pathname;
    var index = pathName.indexOf("/");
    var pathContext = pathName.substring(0, index);
    var url = pathContext + "/equipments";


    $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        data: "pageNum=" + page_index + "&pageSize=" + pageSize,
        success: function (data) {
          console.log('data is :');
          console.log(data);
            var data = data.data;
            var content=data.content;
            $('.news_list_container').empty();
            for (var i = 0; i <  content.length; i++) {
                var equipment = content[i];
                $('.news_list_container').append(
                    '<li> <span class="title"> <a href=' + url + '/' +equipment.id + '>' + equipment.name  + '</a> ' +
                    '</span>' +
                    '<span class="hits">'+
                    '<a type="button" class="edit_button" href="/equipments/manage/'+equipment.id+'">编辑</a>&nbsp&nbsp&nbsp'+
                    '<a type="button" class="delete_button" id="'+equipment.id+'" value="'+equipment.id+'" onclick="delete_article('+equipment.id+')">删除</a>'+
                    '</span>'+
                    ' </li>');
            }
        }
    });
    return true;
}