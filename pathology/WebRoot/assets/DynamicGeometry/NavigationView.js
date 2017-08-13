var NavigationView = function (n, t, i) {
    function lt() {
        $("#Thumbnail").remove(),
        f = document.createElement("div"),
        f.id = "Thumbnail",
        f.style.width = t + u,
        f.style.height = i + u,
        f.style.top = 10 + u,
        f.style.left = 10 + u,
        SlideViewerSupport.canvas ? (y = document.createElement("canvas"), y.width = t, y.height = i, y.id = "cavView", f.appendChild(y), k = new Image, k.src = n, k.onload = function () {
            c.refresh(),
            c.imgLoaded = !0
        }) : (p = document.createElement("img"), p.id = "imgView", p.src = n, p.alt = "", f.appendChild(p),p.style.width = t + u, p.style.height = i + u),
        o = document.createElement("div"),
        o.id = "hLine",
        o.style.top = i / 2 + u,
        o.style.width = t + u,
        f.appendChild(o),
        e = document.createElement("div"),
        e.id = "vLine",
        e.style.left = t / 2 + u,
        e.style.height = i + u,
        f.appendChild(e),
        r = document.createElement("div"),
        r.id = "viewRect",
        r.style.top = (i - 50) / 2 + u,
        r.style.left = (t - 50) / 2 + u;
        //        r.className = "ViewRect";
        //        r.style.filter = "alpha(opacity = 50)";
        var s = $(r);
        $.support.touch ? (s.bind("touchstart", et), s.bind("touchmove", nt), s.bind("touchend", tt), $(f).bind("touchstart", ct)) : (s.mousedown(ut), s.mouseup(d), $(f).mouseleave(g), $(f).mousedown(it)),
        f.appendChild(r)
    }
    function ct(n) {
        var t = n.originalEvent;
        if (t.preventDefault(), s = t.targetTouches[0].pageX, h = t.targetTouches[0].pageY, o.style.top = parseFloat(h - w - v) + u, e.style.left = parseFloat(s - b - v) + u, r.style.top = parseFloat(h - w - parseFloat(r.style.height) / 2 - v) + u, r.style.left = parseFloat(s - b - parseFloat(r.style.width) / 2 - v) + u, c.onUserMove) {
            var a = parseFloat(r.style.left) + parseFloat(r.style.width) / 2,
            y = parseFloat(r.style.top) + parseFloat(r.style.height) / 2,
            i = a / (parseFloat(r.style.width) * l),
            f = y / (parseFloat(r.style.width) * l);
            c.onUserMove(i, f)
        }
        return n.stopPropagation(),
        !1
    }
    function et(n) {
        a = !0,
        n.stopPropagation();
        var t = n.originalEvent;
        t.preventDefault(),
        s = t.targetTouches[0].pageX,
        h = t.targetTouches[0].pageY
    }
    function tt(n) {
        n.stopPropagation();
        var t = n.originalEvent;
        t.preventDefault(),
        a = !1
    }
    function nt(n) {
        var t, f, i;
        if (n.stopPropagation(), t = n.originalEvent, t.preventDefault(), a && t.targetTouches.length == 1 && (f = s - t.targetTouches[0].pageX, i = h - t.targetTouches[0].pageY, s = t.targetTouches[0].pageX, h = t.targetTouches[0].pageY, r.style.top = parseFloat(r.style.top) - i + u, r.style.left = parseFloat(r.style.left) - f + u, o.style.top = parseFloat(o.style.top) - i + u, e.style.left = parseFloat(e.style.left) - f + u, c.onUserMove)) {
            var p = parseFloat(r.style.left) + parseFloat(r.clientWidth) / 2,
            w = parseFloat(r.style.top) + parseFloat(r.clientHeight) / 2,
            v = p / (parseFloat(r.style.width) * l),
            y = w / (parseFloat(r.style.width) * l);
            c.onUserMove(v, y)
        }
    }
    function d() {
        return a = !1,
        $(r).mousemove(null),
        !1
    }
    function g() {
        return a = !1,
        !1
    }
    function ut(n) {
        return n.stopPropagation(),
        a = !0,
        s = n.pageX,
        h = n.pageY,
        $(f).mousemove(ft),
        !1
    }
    function ft(n) {
        n.stopPropagation();
        var i = 0,
        t = 0,
        v = 0,
        f = 0;
        if (a) {
            if (v = n.pageX, f = n.pageY, i = v - s, t = f - h, s = v, h = f, t == 0 && i == 0) return !1;
            if (r.style.top = parseFloat(r.style.top) + t + u, r.style.left = parseFloat(r.style.left) + i + u, o.style.top = parseFloat(o.style.top) + t + u, e.style.left = parseFloat(e.style.left) + i + u, c.onUserMove) {
                var w = parseFloat(r.style.left) + parseFloat(r.style.width) / 2,
                b = parseFloat(r.style.top) + parseFloat(r.style.height) / 2,
                y = w / (parseFloat(r.style.width) * l),
                p = b / (parseFloat(r.style.width) * l);
                c.onUserMove(y, p)
            }
            return !1
        }
    }
    function it(n) {
        if (s = n.pageX, h = n.pageY, o.style.top = parseFloat(h - w - v) + u, e.style.left = parseFloat(s - b - v) + u, r.style.top = parseFloat(h - w - parseFloat(r.style.height) / 2 - v) + u, r.style.left = parseFloat(s - b - parseFloat(r.style.width) / 2 - v) + u, c.onUserMove) {
            var f = parseFloat(r.style.left) + parseFloat(r.style.width) / 2,
            a = parseFloat(r.style.top) + parseFloat(r.style.height) / 2,
            t = f / (parseFloat(r.style.width) * l),
            i = a / (parseFloat(r.style.width) * l);
            c.onUserMove(t, i)
        }
        return n.stopPropagation(),
        !1
    }
    function rt() {
        $(f).css({
            position: "relative",
            "z-index": "0",
            overflow: "hidden",
            border: "1px solid #319DCE"
        }),
        $(y).css({
            "z-index": "0",
            position: "absolute"
        }),
        $(p).css({
            "z-index": "0"
        }),
        $(o).css({
            height: "1px",
            "line-height": "1px",
            position: "absolute",
            left: "0px",
            "background-color": "#FF0000",
            "z-index": "0"
        }),
        $(e).css({
            width: "1px",
            "line-height": "1px",
            position: "absolute",
            top: "0px",
            "background-color": "#FF0000",
            "z-index": "0"
        }),
        $(r).css({
            border: "1px solid #FF0000",
            "background-color": "#FFFFFF",
            position: "absolute",
            width: "50px",
            height: "50px",
            cursor: "pointer",
            "z-index": "0",
            top: "0px",
            left: "0px",
            filter: "alpha(opacity=50)",
            opacity: "0.5"
        })
    }
    var c = this,
    a = !1,
    o, e, at = null,
    p = null,
    y = null,
    k = null,
    f = null,
    r = null,
    s, h, st = 25,
    ot = 25,
    b = 0,
    w = 0,
    u = "px",
    l, yt, vt, t, i, v = 1,
    ht;
    this.imgLoaded = !1,
    this.onUserMove,
    function () {
        lt(),
        rt(),
        c.elmt = f
    } (),
    this.isOnDragging = function () {
        return a
    },
    this.setVisibility = function (n) {
        n ? $(f).show() : $(f).hide()
    },
    this.refresh = function () {
        var n = y.getContext("2d");
        n.clearRect(0, 0, t, i),
        n.drawImage(k, 0, 0, t, i)
    },
    this.getCanvas = function () {
        return y
    },
    this.UpdateViewRect = function (n, i, f, s) {
        (l = n, ht = s, a) || (width = t / l, height = width / s, topX = t * i, topY = t * f, r.style.width = width + u, r.style.height = height + u, r.style.top = topY + u, r.style.left = topX + u, o.style.top = height / 2 + topY + u, e.style.left = width / 2 + topX + u)
        var vit = { topX: topX, topY: topY };
        return vit;
    },
    this.UpdateThumbnailOrigin = function (n, t) {
        b = n,
        w = t
    }
};