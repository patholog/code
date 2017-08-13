(function () {
    SlideSeadragonViewer.createViewer = function (n) {
        function f() {
                        var n = $(u).height() || 45;
                        $(r).height($(window).height()),
                        $(t).height($(r).height())

            //$(r).height($(window).height());
        }
        //        function e(n) {
        //            if (SlideViewerConfig.exitConfirm && i && i.dataChanged() && i.canWrite()) {
        //                var t = n || window.event;
        //                return n && (n.returnValue = SlideViewerStrings.getString("Messages.ExitConfirm")),
        //                SlideViewerStrings.getString("Messages.ExitConfirm")
        //            }
        //        }
        var r = document.getElementById(n),
        u = document.createElement("div"),
        t,
        i;
        u.id = n + "_toolbar",
        t = document.createElement("div"),
        t.id = n + "_viewer", //
        r.appendChild(u),
        r.appendChild(t),
        f();
        //        document.getElementById(t.id).addEventListener('touchstart', function (e) { e.preventDefault(); }, false);

        // $(window).resize(f).on("beforeunload", e);
        return i = new SlideSeadragonViewer(t.id, u.id);
    }
})();