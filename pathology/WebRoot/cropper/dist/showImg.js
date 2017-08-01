var ShowImg = (function () {

    function events(){

        $(".show-image").click(function(){

            var imgSrc = $(".show-image img").attr("src");
            $(".full-screen-bg").removeClass("hide");
            
            var viweImg = $('#viweImg');
            viweImg.attr("src",imgSrc);
            viweImg.cropper({//使用cropper插件
                background:false,//是否在容器上显示网格背景
                autoCrop:false,//是否在初始化时允许自动剪裁图片
                dragCrop:false,//是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
                checkCrossOrigin: false,
                built: function () {  
                    // Do something here  
                    // ...  
                  
                    // And then  
                    $(this).cropper('crop');  
                  }  
            });
        });

        $(".full-screen-bg").click(function(){
            $(".full-screen-bg").addClass("hide");
        });


    }
    events();

})();