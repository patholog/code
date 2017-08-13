var SlideViewerConfig;
(function () {
    function n(n, i, r) {
        if (i === undefined) {
            if (t[n] === undefined) {
                var u = $.cookie(n);
                t[n] = u ? u === "on" : r === !0
            }
            return t[n]
        }
        t[n] = i,
        i ? $.cookie(n, "on", {
            expires: 7
        }) : $.cookie(n, "off", {
            expires: 7
        })
    }
    function i(n) {
        n ? (SlideViewerConfig.enableImageAdjustment = !1, SlideViewerConfig.enableAnnotation = !1, SeadragonConfig.animationTime = 0, SeadragonConfig.blendTime = 0, SeadragonConfig.immediateRender = !0) : (SlideViewerConfig.enableImageAdjustment = !0, SlideViewerConfig.enableAnnotation = !0, SeadragonConfig.animationTime = 1, SeadragonConfig.blendTime = .5, SeadragonConfig.immediateRender = !1)
    }
    if (!SlideViewerConfig) {
        var t = {};
        SlideViewerConfig = {
        slidelists:0,
            enableImageAdjustment: !0,
            enableAnnotation: !0,
            enableOne:[!0,""],
            language: "auto",
            exitConfirm: !0,
            autoShowAnnoDialog: !0,
            showOption: !0,
            showRuler:!1,
            PositionUrl:"1",
            showNavMap: function (t) {
                return n("shownavmap", t, !0)
            },
            compactBrowsing: function (t) {
                return t !== undefined && i(t),
                n("compactbrowsing", t)
            },
            showRulers: function (t) {
                return n("showrulers", t)
            },
            showGrid: function (t) {
                return n("showgrid", t)
            },
            showLabel: function (t) {
                return n("showlabel", t)
            }
        },
        SeadragonConfig.debugMode = !1,
        SeadragonConfig.autoHideControls = !1,
        SeadragonConfig.maxZoomPixelRatio = 2,
        SeadragonConfig.imageLoaderLimit = 4,
        SeadragonConfig.zoomPerClick = 1,
        i(SlideViewerConfig.compactBrowsing())
    }
})();