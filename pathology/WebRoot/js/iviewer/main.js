(function ($) {
    var gallery = new Array();
    function init() {
        var viewer = $("#iviewer .viewer").
        width($(window).width() - 100).
        height($(window).height() - 100).
        css({ "margin-left": "50px", "margin-top": "50px" }).
        iviewer({
                zoom: '100',
                zoom_base: 25,
                onFinishLoad: function (ev) {
                    $("#iviewer .loader").fadeOut();
                    $("#iviewer .viewer").fadeIn();
                }
            }
        );



        $("a[rel='gallery']").each(function (index) {
            gallery[index] = $(this).attr("href");
        });



    }

    function open(src) {
        $("#iviewer").fadeIn().trigger('fadein');
        $("#iviewer .loader").show();
        $("#iviewer .viewer").hide();

        var viewer = $("#iviewer .viewer")
            .iviewer('loadImage', src)
            .iviewer('set_zoom', 'fit');
    }

    function close() {
        $("#iviewer").fadeOut().trigger('fadeout');
    }

    //Ӱ��ѧ���ͼƬ����a��ǩ
    $("#divImageCheck img").each(function () {
        $(this).wrap("<a class='go' rel='gallery' href='" + $(this).attr("src").replace(/\(thumb\)/ig, "") + "'></a>")
    });

    //�����������ͼƬ����a��ǩ
    $("#divGeneralObservation img").each(function () {
        $(this).wrap("<a class='go' rel='gallery' href='" + $(this).attr("src").replace(/\(thumb\)/ig, "") + "'></a>")
    });

    $('.go').click(function (e) {
        e.preventDefault();
        var src = $(this).attr('href');
        open(src);
        // Refresh next and prev links
        refreshNextPrevLinks(src);

        //var path = window.location.host + src.replace("..", "");

        $("<a   href=\"" + src + "\" target=\"_blank\" download=\"\"><div class=\"iviewer_download iviewer_common iviewer_button\"></div></a>")
            .appendTo("#viewer");
    });

    $("#iviewer .close").click(function (e) {
        e.preventDefault();
        close();
    });

    $("#iviewer").bind('fadein', function () {
        $(window).keydown(function (e) {
            if (e.which == 27) close();
        });
    });

    /*
     *   refreshes Next and previous links
     */
    function refreshNextPrevLinks(src) {
        // console.log('RefreshNextPrevLinks called. src: ' + src);
        var imageIndex = 0;
        for (i = 0; i < gallery.length; i++) {
            if (src == gallery[i]) {
                imageIndex = i;
            }
        }

        // Next link
        var nextLink = document.getElementById('nextLink');
        if (gallery.length > imageIndex + 1) {
            nextLink.href = gallery[imageIndex + 1];
            nextLink.style.visibility = 'visible';
        } else {
            nextLink.href = "#";
            nextLink.style.visibility = 'hidden';
        }

        // Prev link
        var prevLink = document.getElementById('prevLink');
        if (imageIndex > 0) {
            prevLink.href = gallery[imageIndex - 1];
            prevLink.style.visibility = 'visible';
        } else {
            prevLink.setAttribute("href", "#");
            prevLink.style.visibility = 'hidden';
        }

        document.getElementById('imageCount').innerHTML = " (" + (imageIndex + 1) + "/" + gallery.length + ")";
    }
    function fadeBar(a) {
        clearTimeout(timer);
        timer = setTimeout(function () {
            $("#topBar").animate({ top: "-50px" }, 500);
        }, a);


    }

    $("#iviewer .iviewer_download").click(function (e) {

    });

    $(document).keyup(function (e) {
        //left arrow key
        if (e.keyCode == 37) {
            if ($("#prevLink").attr("href") != "#") {
                $("#prevLink").click();
            }
        }
        //right arrow
        if (e.keyCode == 39) {
            if ($("#nextLink").attr("href") != "#") {
                $("#nextLink").click();
            }
        }
    });
    //  var timer = "";
    init();
    //    fadeBar(4000);
    //    $(".info").hover(function () {
    //        $("#topBar").animate({ top: "0" }, 300);
    //        clearTimeout(timer);
    //    }, function () {
    //        fadeBar(2000);
    //    })

    $(window).resize(function () {
        init();
    })
})(jQuery);

