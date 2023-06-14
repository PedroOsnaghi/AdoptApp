jQuery(document).ready(function () {
    ImgUpload();
});

function ImgUpload() {
    const input_file = document.getElementById('input_file');

    var imgArray = [];

    var imgLoaded = parseInt(input_file.getAttribute('img-loaded'));

    var labelLoaded = document.getElementById("img-loaded");


        input_file.addEventListener('change', function (e) {


            var maxLength = parseInt(input_file.getAttribute('data-max_length'));
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);


            filesArr.forEach(function (f, index) {

                //si no son imagenes salimos
                if (!f.type.match('image.*')) {
                    return false;
                }

                //se verifica la cantidad maxima permitida o se sale
                if (imgArray.length >= (maxLength -  imgLoaded)) {
                    return false;
                } else {

                    var len = 0;
                    for (var i = 0; i < imgArray.length; i++) {
                        if (imgArray[i] !== undefined) {
                            len++;
                        }
                    }
                    if (len > (maxLength -  imgLoaded)) {
                        return false;
                    } else {

                        imgArray.push(f);
                        labelLoaded.innerText = (imgArray.length + imgLoaded).toString();
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            var html = "<div class='upload__img-box'><div style='background-image: url(" + e.target.result + ")' data-number='" + $(".upload__img-close").length + "' data-file='" + f.name + "' class='img-bg'><div class='upload__img-close'></div></div></div>";
                            $('#img_wrap').append(html);
                        }
                        reader.readAsDataURL(f);
                    }
                }
            });
        });


    $('body').on('click', ".upload__img-close", function (e) {
        var file = $(this).parent().data("file");
        for (var i = 0; i < imgArray.length; i++) {
            if (imgArray[i].name === file) {
                imgArray.splice(i, 1);
                break;
            }
        }
        $(this).parent().parent().remove();
        labelLoaded.innerText = (imgArray.length + imgLoaded).toString() ;
    });
}