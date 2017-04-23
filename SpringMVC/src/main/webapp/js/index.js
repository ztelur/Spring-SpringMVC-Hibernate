/**
 * Created by homer on 16-12-17.
 */


/**
 * Created by homer on 16-12-6.
 */


$(document).ready(function () {
    var load = function () {
        var pathName = document.location.pathname;
        pathName = pathName.substring(1,pathName.length);
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = "/" + pathContext + "/banners";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=1",
            success: function (data) {

                var banners = data.data;
                $('#featured_slide').empty();
                for (var i = 0; i <  banners.length; i++) {
                    var banner = banners[i];
                    if(!banner.enabled)
                        continue;
                    if (banner.brief == "" ) {
                        var content = '<div class="featured_box"><a href="#"><img src="' +
                            banner.imageUrl + '" alt="" /></a> <div class="floater"> <div class="banner-content"><h2 style="height: 100%">' +
                            banner.title + '</h2></div> <p class="readmore"><a href="' +
                            banner.infoUrl + '">Continue Reading &raquo;</a></p> </div> </div>'
                    } else {
                        var content = '<div class="featured_box"><a href="#"><img src="' +
                            banner.imageUrl + '" alt="" /></a> <div class="floater"> <div class="banner-content"><h2 >' +
                            banner.title + '</h2> <div class="banner-desc">' +
                            banner.brief + '</div></div> <p class="readmore"><a href="' +
                            banner.infoUrl + '">Continue Reading &raquo;</a></p> </div> </div>'
                    }
                    $('#featured_slide').append(content);
                }

                $('#featured_slide').after('<div id="fsn"><ul id="fs_pagination">').cycle({
                    timeout: 5000, // milliseconds between slide transitions (0 to disable auto advance)
                    fx: 'fade', // choose a transition type, ex: fade, scrollUp, shuffle, etc...
                    pager: '#fs_pagination', // selector for element to use as pager container
                    pause: 0, // true to enable "pause on hover"
                    pauseOnPagerHover: 0 // true to pause when hovering over pager link
                });
            }

        });


        var url = "/" + pathContext + "/articles";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=1",
            success: function (data) {
                var articles = data.data.data;
                $('#news_container').empty();
                for (var i = 0; i <  articles.length; i++) {
                    var article = articles[i];
                    console.log("dddddddd");
                    $('#news_container').append('<li class="clear"><div class="imgl"><img class="new_list_img" src="' +
                        article.imageUrl + '" alt="" /></div><div class="latestnews"><p><a href="' +
                        url + "/" + article.id + '">' + article.title + ' </a></p><p class="news_brief">' +
                        article.brief + ' </p> </div></li>');
                }
            }

        });
    }();
});


