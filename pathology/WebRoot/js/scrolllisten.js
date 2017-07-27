$(document).ready(function () {
    /*滚动监听*/
    $(window).scroll(function () {
        var scrollTop = $(document).scrollTop();
        var scrollHeight = $(document).height();
        var windowHeight = $(window).height();
        var contentItems = $(".in_box_canvas").find(".mpt80");
        var currentItem = "";
        contentItems.each(function (index) {
            var contentItem = $(this);
            var offsetTop = contentItem.offset().top;
            var lastLia = $(".in_box_nav li").last().find("a");
            if ((scrollTop > offsetTop - 10 && index != 0) || (scrollTop > offsetTop - 43 && index == 0)) {
                currentItem = "#" + contentItem.attr("id");
            }
            if (scrollTop + windowHeight == scrollHeight) {
                currentItem = lastLia.attr("href");
            }
            if (currentItem != $(".in_box_nav").find(".in_box_nav_on a").attr("href")) {
                $(".in_box_nav").find(".in_box_nav_on").removeClass("in_box_nav_on");
                $(".in_box_nav").find("[href=" + currentItem + "]").parents('li').addClass("in_box_nav_on");

            }

        });
    })
    /*返回顶部*/
    function go_to_top() {
        $('html,body').stop().animate({ scrollTop: '0px' }, 400);
    }
    $(window).scroll(function () {
        var st = $(window).scrollTop();
        if (st > 150) {
            $(".toolbar-wrap").show();
            $(".return_top").bind("click", go_to_top);
        } else {
            $(".toolbar-wrap").hide();
        }
    });

})