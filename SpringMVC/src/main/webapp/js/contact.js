/**
 * Created by homer on 16-12-21.
 */
$(document).ready(function () {

    var currentUrl = window.location.href;
    var pathName = document.location.pathname;
    var index = pathName.indexOf("/");
    var pathContext = pathName.substring(0, index);
    var url = pathContext + "/otherInfos";
    $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        data: "pageNum=1",
        success: function (data) {
            // 百度地图API功能


            var map = new BMap.Map("allmap");
            map.centerAndZoom(new BMap.Point($("#longitude").val(), $("#latitude").val()), 15);
            map.enableScrollWheelZoom(true);
            var marker = new BMap.Marker(new BMap.Point($("#longitude").val(), $("#latitude").val()));
            map.addOverlay(marker);

            var label = new BMap.Label("电子学院所在地,可拖动设置新地点",{offset:new BMap.Size(20,-10)});
            marker.setLabel(label);
            marker.addEventListener("dragend", function (e) {
                // console.log("longitutde:" + $("#longitude").val() + ";latitude:" + $("#latitude").val());
                $("#longitude").val(e.point.lng);
                $("#latitude").val(e.point.lat);
                map.centerAndZoom(new BMap.Point($("#longitude").val(), $("#latitude").val()), 15);
            })
        }

    });


});