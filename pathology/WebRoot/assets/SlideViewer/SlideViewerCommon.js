function CalcCenterX(n, t, i, r, u, f) {
    return ((n * n + t * t) * (r - f) - (i * i + r * r) * (r - f) - (i * i + r * r) * (t - r) + (u * u + f * f) * (t - r)) / (2 * ((n - i) * (r - f) - (i - u) * (t - r)))
}
function CalcCenterY(n, t, i, r, u, f) {
    var o = CalcCenterX(n, t, i, r, u, f);
    return (i * i + r * r - (u * u + f * f) - 2 * o * (i - u)) / (2 * (r - f))
}
function CalcCenterPoint(n, t, i) {
    var u = CalcCenterX(n.x, n.y, t.x, t.y, i.x, i.y),
    r = CalcCenterY(n.x, n.y, t.x, t.y, i.x, i.y);
    return new Point(u, r)
}
function CalcRadius(n, t) {   //n 开始的x,y 结束的X,Y
    return Math.sqrt((t.x - n.x) * (t.x - n.x) + (t.y - n.y) * (t.y - n.y))
}
function AngleDegreeS(n, t, i, r, u, f) {
    var o = Math.atan2(t - r, n - i),
    s = Math.atan2(f - r, u - i),
    e = (s - o) / Math.PI * 180;
    return e < 0 ? 360 + e : e
}
function AngleRadianS(n, t, i, r, u, f) {
    var o = Math.atan2(t - r, n - i),
    e = Math.atan2(f - r, u - i);
    return e - o
}
function AngleRadian(n, t, i) {
    return AngleRadianS(n.x, n.y, t.x, t.y, i.x, i.y)
}
function Radian(n, t) {
    return Math.atan2(n.y - t.y, n.x - t.x)
}
function AngleDegree(n, t, i) {
    return AngleDegreeS(n.x, n.y, t.x, t.y, i.x, i.y)
}
function AngleArcPointS(n, t, i, r, u) {
    var f = Math.atan2(r - t, i - n),
    o = Math.sin(f) * u,
    e = Math.cos(f) * u;
    return new Point(n + e, t + o)
}
function AngleArcPoint(n, t, i) {
    return AngleArcPointS(n.x, n.y, t.x, t.y, i)
}
function IsLargeArc(n) {
    var t = n < 0 ? 2 * Math.PI + n : n;
    return t < .5 * Math.PI || t > 1.5 * Math.PI
}
function IsCounterClockwise(n) {
    var t = n < 0 ? 2 * Math.PI + n : n;
    return t > 0 && t < Math.PI
}
function CalcArea(n) {
    for (var u = n.length, r, i = 0, t = 0; t < u; t++) r = (t + 1) % u,
    i += n[t].x * n[r].y,
    i -= n[t].y * n[r].x;
    return i /= 2,
    Math.abs(i)
}
function CalcLength(n) {
    var u, i, r, t;
    if (n == null || (u = n.length, u < 2)) return 0;
    for (i = 0, r = 0, t = 1; t < u; t++) i += LineLength(n[r], n[t]),
    r = t;
    return i
}
function CalcLengthClosed(n) {
    var t, i;
    return n == null ? 0 : (t = n.length, t < 2) ? 0 : n[0] != n[t - 1] ? (n.push(n[0]), i = CalcLength(n), n.splice(n.length - 1, 1), i) : CalcLength(n)
}
function TriangleArea(n, t, i) {
    var f = LineLength(n, t),
    e = LineLength(n, i),
    r = LineLength(t, i),
    u;
    return f + e <= r || e + r <= f || r + f <= e ? 0 : (u = (f + e + r) / 2, Math.sqrt(Math.Abs(u * (u - f) * (u - e) * (u - r))))
}
function LineLength(n, t) {
    var r = t.x - n.x,
    i = t.y - n.y;
    return Math.sqrt(r * r + i * i)
}
function RadianOfTwoLine(n, t, i) {
    var u = Math.atan2(t.y - n.y, t.x - n.x),
    r = Math.atan2(i.y - n.y, i.x - n.x);
    return r - u
}
function HexToNumber(n) {
    return parseInt(n.replace("#", "0xFF"))
}
function NumberToHex(n) {
    a = n >> 24 & 255,
    r = n >> 16 & 255,
    g = n >> 8 & 255,
    b = n & 255;
    var t = "rgb(" + r + "," + g + "," + b + ")";
    return colorHex(t)
}
function colorHex(n) {
    var r = n,
    o, f, i, u, e, t;
    if (/^(rgb|RGB)/.test(r)) {
        for (o = r.replace(/(?:\(|\)|rgb|RGB)*/g, "").split(","), f = "#", t = 0; t < o.length; t++) i = Number(o[t]).toString(16),
        i === "0" ? i += i : i.length == 1 && (i = "0" + i),
        f += i;
        return f.length !== 7 && (f = r),
        f
    }
    if (reg.test(r)) {
        if (u = r.replace(/#/, "").split(""), u.length === 6) return r;
        if (u.length === 3) {
            for (e = "#", t = 0; t < u.length; t += 1) e += u[t] + u[t];
            return e
        }
    } else return r
}
function colorRgb(n) {
    var i = n.toLowerCase(),
    u,
    r,
    t;
    if (i && reg.test(i)) {
        if (i.length === 4) {
            for (u = "#", t = 1; t < 4; t += 1) u += i.slice(t, t + 1).concat(i.slice(t, t + 1));
            i = u
        }
        for (r = [], t = 1; t < 7; t += 2) r.push(parseInt("0x" + i.slice(t, t + 2)));
        return "RGB(" + r.join(",") + ")"
    }
    return i
}
function registerTxtCSS(n, t, i, r, u, f, e, o, s, h, c, l) {
    $elmt = $(n),
    $elmt.css({
        left: t + "px",
        top: i + "px",
        "font-size": r + "px",
        "font-family": u,
        color: f,
        position: "absolute",
        padding: "5px",
        float: "left",
        "border-radius": "4px",
        "-moz-border-radius": "4px",
        "-webkit-border-radius": "4px"
    }),
    e && $elmt.css({
        "font-weight": "bold"
    }),
    o && $elmt.css({
        "font-style": "italic"
    }),
    s && $elmt.css({
        "text-decoration": "underline"
    }),
    c && $elmt.css({
        "background-color": "#F7F8FA",
        border: "1px solid #A3AEB9"
    }),
    l && ($elmt.css({
        filter: "alpha(opacity=80)",
        opacity: "0.8",
        display: "block"
    }), h = replaceHtmlEnter(h)),
    $elmt.html(h)
}
function registerMeasurementTxtCSS(n) {
    $elmt = $(n),
    $elmt.css({
        "font-size": "12px",
        "background-color": "#F7F8FA",
        border: "1px solid #A3AEB9",
        color: "#000000",
        "font-family": "Microsoft Sans Serif,Arial, Helvetica, sans-serif,\u5b8b\u4f53",
        filter: "alpha(opacity=80)",
        opacity: "0.8",
        position: "absolute",
        padding: "4px",
        "border-radius": "4px",
        "-moz-border-radius": "4px",
        "-webkit-border-radius": "4px"
    })
}
function floatRound(n) {
    return Math.round(n * 100) / 100
}
function replaceHtmlEnter(n) {
    return n = n.replaceAll("\n", enter)
}
function isHasEnter(n) {
    for (var i = !1, t = 0; t < n.length; t++) if (n[t] == "\n") {
        i = !0;
        break
    }
    return i
}
function replaceSize(n, t) {
    var r = $(t).width(),
    i = $(t).height();
    r < 200 && (r = 200),
    i < 100 && (i = 100),
    $(n).width(r),
    $(n).height(i)
}
function appendLine(n, t) {
    return n += t + enter
}
function append(n, t) {
    return n += t
}
function registerPositionCSS(n, t, i) {
    $elmt = $(n),
    $elmt.css({
        left: t + "px",
        top: i + "px"
    })
}
function GetOffsetWidth(n) {
    return n /= 2,
    n < 10 && (n = 10),
    n
}
function clickOnLine(n, t, i, r) {
    var o, s, e, u, f;
    return (r = GetOffsetWidth(r), n.x > t.x ? (o = t.x, s = n.x) : (o = n.x, s = t.x), n.y > t.y ? (e = t.y, u = n.y) : (e = n.y, u = t.y), i.x < o - r || i.x > s + r || i.y < e - r || i.y > u + r) ? !1 : (f = pointToLineLength(n, t, i), f == null) ? !1 : f < r
}
function pointToLineLength(n, t, i) {
    var u = n.y - t.y,
    r = t.x - n.x,
    f = (n.x - r) * n.y - n.x * (n.y + u);
    return u == 0 && r == 0 ? null : Math.abs(u * i.x + r * i.y + f) / Math.sqrt(u * u + r * r)
}
function clickOnEllipse(n, t, i, r, u) {
    var e;
    if (u = GetOffsetWidth(u), i.x - n - u > r.x || r.x > i.x + n + u || i.y - t - u > r.y || r.y > i.y + t + u) return !1;
    var s = (r.x - i.x) / n,
    o = 1 / s,
    f = Math.sqrt(o * o - 1) / o;
    return isNaN(f) && (f = 0),
    (r.y < i.y && f > 0 || r.y > i.y && f < 0) && (f = -f),
    e = i.y + t * f,
    e - u <= r.y && r.y <= e + u ? !0 : !1
}
function clickInCircle(n, t, i, r) {
    r = GetOffsetWidth(r);
    var u = CalcRadius(t, i);
    return u <= n + r
}
function clickInCircleResult(n, t, i, r) {
    r = GetOffsetWidth(r);
    var f = CalcRadius(t, i),
    u = new ClickResult;
    return u.isIn = f <= n + r,
    u.length = f,
    u
}
function clickOnCircle(n, t, i, r) {
    r = GetOffsetWidth(r);
    var u = CalcRadius(t, i);
    return n - r < u && u < n + r
}
function clickOnArc(n, t, i, r, u, f, e) {
    e = GetOffsetWidth(e);
    var s = LineLength(t, i),
    o = Radian(i, t);
    return n - e > s || s > n + e ? !1 : Math.abs(r - u) < Math.PI ? f ? Math.min(r, u) > o || o > Math.max(r, u) : Math.min(r, u) < o && o < Math.max(r, u) : f ? Math.min(r, u) < o && o < Math.max(r, u) : Math.min(r, u) > o || o > Math.max(r, u)
}
function clickInArc(n, t, i, r, u, f, e) {
    e = GetOffsetWidth(e);
    var s = LineLength(t, i),
    o = Radian(i, t);
    return s > n + e ? !1 : Math.abs(r - u) < Math.PI ? f ? Math.min(r, u) > o || o > Math.max(r, u) : Math.min(r, u) < o && o < Math.max(r, u) : f ? Math.min(r, u) < o && o < Math.max(r, u) : Math.min(r, u) > o || o > Math.max(r, u)
}
function guidGenerator() {
    var n = function () {
        return ((1 + Math.random()) * 65536 | 0).toString(16).substring(1)
    };
    return n() + n() + "-" + n() + "-" + n() + "-" + n() + "-" + n() + n() + n()
}
var reg, enter;
(function () {
    var n = window.CanvasRenderingContext2D && CanvasRenderingContext2D.prototype;
    n && n.lineTo && (n.dashedLine = function (n, t, i, r, u) {
        var v = function (n, t) {
            return n <= t
        },
        w = function (n, t) {
            return n >= t
        },
        p = function (n, t) {
            return Math.min(n, t)
        },
        y = function (n, t) {
            return Math.max(n, t)
        },
        s = {
            thereYet: w,
            cap: p
        },
        o = {
            thereYet: w,
            cap: p
        },
        h,
        a;
        t - r > 0 && (o.thereYet = v, o.cap = y),
        n - i > 0 && (s.thereYet = v, s.cap = y),
        this.moveTo(n, t);
        for (var e = n, f = t, c = 0, l = !0; !(s.thereYet(e, i) && o.thereYet(f, r)); ) h = Math.atan2(r - t, i - n),
        a = u[c],
        e = s.cap(i, e + Math.cos(h) * a),
        f = o.cap(r, f + Math.sin(h) * a),
        l ? this.lineTo(e, f) : this.moveTo(e, f),
        c = (c + 1) % u.length,
        l = !l
    })
})(),
reg = /^#([0-9a-fA-f]{3}|[0-9a-fA-f]{6})$/,
enter = "<br/>",
String.prototype.replaceAll = function (n, t) {
    return this.replace(new RegExp(n, "gm"), t)
};