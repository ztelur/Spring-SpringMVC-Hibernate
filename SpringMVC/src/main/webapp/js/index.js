/**
 * Created by homer on 16-12-17.
 */


/**
 * Created by homer on 16-12-6.
 */


$(document).ready(function () {
    var load = function () {
        var currentUrl = window.location.href;
        var pathName = document.location.pathname;
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = pathContext + "/banners";
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "pageNum=1",
            success: function (data) {
                data = {
                    "data":[
                        {
                            "infoUrl":"http://ztelur.github.io/2016/10/30/View%E7%9A%84%E4%B8%89%E6%AC%A1measure-%E4%B8%A4%E6%AC%A1layout%E5%92%8C%E4%B8%80%E6%AC%A1draw/",
                            "brief":"博客2",
                            "imageUrl":"http://7xrxif.com1.z0.glb.clouddn.com/20161030-111.png"
                        },
                        {
                            "infoUrl":"http://ztelur.github.io/2016/10/30/View%E7%9A%84%E4%B8%89%E6%AC%A1measure-%E4%B8%A4%E6%AC%A1layout%E5%92%8C%E4%B8%80%E6%AC%A1draw/",
                            "brief":"博客3",
                            "imageUrl":"http://7xrxif.com1.z0.glb.clouddn.com/20161030-111.png"
                        },
                        {
                            "infoUrl":"http://ztelur.github.io/2016/10/30/View%E7%9A%84%E4%B8%89%E6%AC%A1measure-%E4%B8%A4%E6%AC%A1layout%E5%92%8C%E4%B8%80%E6%AC%A1draw/",
                            "brief":"博客4",
                            "imageUrl":"http://7xrxif.com1.z0.glb.clouddn.com/20161030-111.png"
                        }
                    ]
                }
                var banners = data.data;
                $('#featured_slide').empty();
                for (var i = 0; i <  banners.length; i++) {
                    var banner = banners[i];
                    $('#featured_slide').append(
                    '<div class="featured_box"><a href="#"><img src="' +
                    banner.imageUrl + '" alt="" /></a> <div class="floater"><h2>' +
                        banner.title + '</h2> <p>' +
                        banner.brief + '</p> <p class="readmore"><a href="'  +
                    banner.infoUrl +  '">Continue Reading &raquo;</a></p> </div> </div>');
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

    }();
});


