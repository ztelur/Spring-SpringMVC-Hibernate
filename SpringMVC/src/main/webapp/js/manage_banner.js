$(document).ready(function () {
  $('#banner-set-display').click(function(){
    console.log('ssf');
  });

  // $(".upload_button").click(function(){
  //   console.log("sssssfb");
  //   console.log($(this));
  //   console.log($(this).siblings("img")));
  //   $(this).siblings("img")).first().click();
  //
  // });
});


$(".image").change(function(e) {
    for (var i = 0; i < e.target.files.length; i++) {
        var file = e.target.files.item(i);
        var freader = new FileReader();
        freader.readAsDataURL(file);
        freader.onload = function(e) {
            var src = e.target.result;
            $("#img_head1").attr("src",src);
        }
    }
});

function click_upload(id){
  console.log(id);
  $("#image"+id).click();
}
