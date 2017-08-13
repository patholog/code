var SlideLabel = function (n) {
    function u() {
        var f = document.createElement("div"),
        u;
        t = $(f),
        t.css({
            top: "25px",
            right: "10px"
        }),
        u = document.createElement("img"),
        u.src = n,
        u.alt = "",
        u.onerror = function () {
            r = !1,
            i.setVisibility(!1)
        },
        $(u).css({
            border: "1px solid #319DCE"
        }),
        t.append($(u)),
        i.elmt = f
    }
    var i = this,
    t, r = !0;
    i.elmt = null,
    function () {
        u()
    } (),
    this.setVisibility = function (n) {
        r && n ? t.show() : t.hide()
    }
};