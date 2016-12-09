$('#edit').froalaEditor({
    charCounterMax:10000,
    heightMin:400,
    // Set the image upload URL.
    imageUploadURL: '/files/img',
    // Set request type.
    imageUploadMethod: 'POST',
    imageUploadParam:'file',
    // Set max image size to 5MB.
    imageMaxSize: 5 * 1024 * 1024,
    // Allow to upload PNG and JPG.
    imageAllowedTypes: ['jpeg', 'jpg', 'png']
});
function reset(){
    console.log(reset);
};
function checkForm(){
    return true;
}