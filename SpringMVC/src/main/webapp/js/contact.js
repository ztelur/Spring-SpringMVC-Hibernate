/**
 * Created by homer on 16-12-21.
 */
$(document).ready(function () {

    var currentUrl = window.location.href;
    var pathName = document.location.pathname;
    var index = pathName.indexOf("/");
    var pathContext = pathName.substring(0, index);
    var url = pathContext + "/otherInfos";
    console.log("ddd");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        data: "",
        success: function (data) {
            // 百度地图API功能

            var longitude = data.data.longitude;
            var latitude = data.data.latitude;
            var email = data.data.email;
            var phone = data.data.telephone;
            var fax = data.data.fax;
            console.log("the email is " + email);
            if (email) {
                $("#email").html(email);
            }
            if (phone) {
                $("#phone").html(phone);
            }
            if (fax) {
                $("#fax").html(fax);
            }
            console.log("the size is " + longitude + " " +　latitude);
            var map = new BMap.Map("allmap");
            map.centerAndZoom(new BMap.Point(longitude, latitude), 15);
            map.enableScrollWheelZoom(true);
            var marker = new BMap.Marker(new BMap.Point(longitude, latitude));
            map.addOverlay(marker);

            var label = new BMap.Label("电子学院所在地,可拖动设置新地点",{offset:new BMap.Size(20,-10)});
            marker.setLabel(label);
            marker.addEventListener("dragend", function (e) {
                // console.log("longitutde:" + $("#longitude").val() + ";latitude:" + $("#latitude").val());
                longitude =  e.point.lng;
                latitude = e.point.lat;
                map.centerAndZoom(new BMap.Point(longitude, latitude), 15);
            })
        }

    });


});