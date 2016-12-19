$(document).ready(function () {
  $('#banner-set-display').click(function(){
    console.log('ssf');
  });

  
  $("#image1").change(function(e) {
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
  $("#image2").change(function(e) {
      for (var i = 0; i < e.target.files.length; i++) {
          var file = e.target.files.item(i);
          var freader = new FileReader();
          freader.readAsDataURL(file);
          freader.onload = function(e) {
              var src = e.target.result;
              $("#img_head2").attr("src",src);
          }
      }
  });
  $("#image3").change(function(e) {
      for (var i = 0; i < e.target.files.length; i++) {
          var file = e.target.files.item(i);
          var freader = new FileReader();
          freader.readAsDataURL(file);
          freader.onload = function(e) {
              var src = e.target.result;
              $("#img_head3").attr("src",src);
          }
      }
  });
  $("#image4").change(function(e) {
      for (var i = 0; i < e.target.files.length; i++) {
          var file = e.target.files.item(i);
          var freader = new FileReader();
          freader.readAsDataURL(file);
          freader.onload = function(e) {
              var src = e.target.result;
              $("#img_head4").attr("src",src);
          }
      }
  });
  $("#image5").change(function(e) {
      for (var i = 0; i < e.target.files.length; i++) {
          var file = e.target.files.item(i);
          var freader = new FileReader();
          freader.readAsDataURL(file);
          freader.onload = function(e) {
              var src = e.target.result;
              $("#img_head5").attr("src",src);
          }
      }
  });
});



function click_upload(id){
  $("#image"+id).click();
}
