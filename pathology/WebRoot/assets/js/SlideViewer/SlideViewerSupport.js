var SlideViewerSupport;
(function () {
    var t, n, i;
    SlideViewerSupport || ($.extend($.support, {
        orientation: "orientation" in window && "onorientationchange" in window,
        touch: "ontouchend" in document
    }), SlideViewerSupport = {
        imageAdjustment: !1,
        canvas: !1,
        isAndroid: !1
    },
    t = !!document.createElement("canvas").getContext, SlideViewerSupport.canvas = t, n = SeadragonUtils.getBrowser(), t && n != SeadragonBrowser.IE && n != SeadragonBrowser.UNKNOWN && (SlideViewerSupport.imageAdjustment = !0), i = navigator.userAgent.toLowerCase(), SlideViewerSupport.isAndroid = i.indexOf("android") > -1)
})();