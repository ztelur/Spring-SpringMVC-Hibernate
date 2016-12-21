/**
 * Created by homer on 16-12-21.
 */


$(document).ready(function () {
    var load = function () {
        var currentUrl = window.location.href;
        var pathName = document.location.pathname;
        var index = pathName.indexOf("/");
        var pathContext = pathName.substring(0, index);
        var url = pathContext + "/people";
        console.log("the url is " + url);
        $.ajax({
            type: "GET",
            dataType: "json",
            url: url,
            data: "",
            success: function (data) {
                console.log("the url is " + url);
                var team = data.data;
                $('.ss-general-info').empty();
                for (var p in team) {
                    var content = '<h4>' + p + '：</h4> <p class="p_font_mid clearfix" style="margin: 0 0 20px 40px;">';
                    console.log("the p is " + p);
                    var people = team[p];
                    for (var i =0; i< people.length; i++) {
                        var person = people[i];
                        content = content + '<a class="block-text" href="'  + pathContext + '/people/' + person.id + '">' + person.name + '</a>';
                        console.log("the person name is " + person.name);
                    }
                    content = content + ' </p>';
                    $(".ss-general-info").append(content);
                }

            }

        });

    }();
});