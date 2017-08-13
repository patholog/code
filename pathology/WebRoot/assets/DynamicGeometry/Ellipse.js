var Ellipse;
//function () {
//    function t(n, t, i, r, u) {
//        var l = .5522848,
//        o = r / 2 * l,
//        s = u / 2 * l,
//        c = t + r,
//        h = i + u,
//        e = t + r / 2,
//        f = i + u / 2;
//        n.beginPath(),
//        n.moveTo(t, f),
//        n.bezierCurveTo(t, f - s, e - o, i, e, i),
//        n.bezierCurveTo(e + o, i, c, f - s, c, f),
//        n.bezierCurveTo(c, f + s, e + o, h, e, h),
//        n.bezierCurveTo(e - o, h, t, f + s, t, f),
//        n.stroke()
//    }
//    Ellipse = function (n, t, i) {
//        Rectangle.apply(this, [n, t, i])
//    },
//    Ellipse.prototype = new Rectangle;
//    var n = Ellipse.prototype;
//    n.draw = function () {
//        var r = this.getContext();
//        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
//        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
//        this.shapeMovePosition();
//        var u = Math.abs(this.rePoint.x - this.rsPoint.x),
//        f = Math.abs(this.rePoint.y - this.rsPoint.y),
//        n = 0,
//        i = 0;
//        this.rePoint.x > this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rsPoint.x, i = this.rsPoint.y) : this.rePoint.x > this.rsPoint.x && this.rePoint.y < this.rsPoint.y ? (n = this.rsPoint.x, i = this.rePoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rePoint.x, i = this.rsPoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y < this.rsPoint.y && (n = this.rePoint.x, i = this.rePoint.y),
//        this.leftTopPoint = new Point(this.rsPoint.x, this.rsPoint.y),
//        this.leftBottomPoint = new Point(this.rsPoint.x, this.rePoint.y),
//        this.rightTopPoint = new Point(this.rePoint.x, this.rsPoint.y),
//        this.rightBottomPoint = new Point(this.rePoint.x, this.rePoint.y),
//        this.topMiddlePoint = new Point(n + u / 2, this.rsPoint.y),
//        this.bottomMiddlePoint = new Point(n + u / 2, this.rePoint.y),
//        this.leftMiddlePoint = new Point(this.rsPoint.x, i + f / 2),
//        this.rightMiddlePoint = new Point(this.rePoint.x, i + f / 2),
//        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
//        r.lineWidth = this.width,
//        r.strokeStyle = this.color,
//        t(r, n, i, u, f),
//        this.active(),
//        this.showMeasurement()
//    },
//    n.calcMeasurementInfo = function () {
//        var f = Math.abs(this.startPoint.x - this.endPoint.x),
//        e = Math.abs(this.startPoint.y - this.endPoint.y),
//        r = f / 2 * this.calibration,
//        i = e / 2 * this.calibration,
//        n = Math.abs(r - i) / (r + i),
//        u,
//        t;
//        return n = n * n,
//        u = isNaN(n) ? 0 : Math.PI * (r + i) * (135168 - 85760 * n - 5568 * n * n + 3867 * n * n * n) / (135168 - 119552 * n + 22208 * n * n - 345 * n * n * n),
//        t = "",
//        t = appendLine(t, Measurement.Majorhalfaxis + floatRound(Math.max(r, i)) + Measurement.Unit),
//        t = appendLine(t, Measurement.Minorhalfaxis + floatRound(Math.min(r, i)) + Measurement.Unit),
//        t = appendLine(t, Measurement.Area + floatRound(Math.abs(Math.PI * f * this.calibration * e * this.calibration / 4)) + Measurement.AreaUnit),
//        t = appendLine(t, Measurement.Perimeter + floatRound(u) + Measurement.Unit)
//    },
//    n.isHitMe = function (n) {
//        return this.isSelected && this.getActiveMove(n),
//        this.activeMove != ActiveMove.None ? !0 : !1;
//        var t
//    }
//} ();
function ta(n, t, i, r, u) {
    var l = .5522848,
        o = r / 2 * l,
        s = u / 2 * l,
        c = t + r,
        h = i + u,
        e = t + r / 2,
        f = i + u / 2;
    n.beginPath(),
        n.moveTo(t, f),
        n.bezierCurveTo(t, f - s, e - o, i, e, i),
        n.bezierCurveTo(e + o, i, c, f - s, c, f),
        n.bezierCurveTo(c, f + s, e + o, h, e, h),
        n.bezierCurveTo(e - o, h, t, f + s, t, f),
        n.stroke()
}
Ellipse = function (n, t, i) {
    Rectangle.apply(this, [n, t, i])
},
    Ellipse.prototype = new Rectangle;
var n = Ellipse.prototype;
n.draw = function () {
    var r = this.getContext();
    this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
        this.shapeMovePosition();
    var u = Math.abs(this.rePoint.x - this.rsPoint.x),
        f = Math.abs(this.rePoint.y - this.rsPoint.y),
        n = 0,
        i = 0;
    this.rePoint.x > this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rsPoint.x, i = this.rsPoint.y) : this.rePoint.x > this.rsPoint.x && this.rePoint.y < this.rsPoint.y ? (n = this.rsPoint.x, i = this.rePoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rePoint.x, i = this.rsPoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y < this.rsPoint.y && (n = this.rePoint.x, i = this.rePoint.y),
        this.leftTopPoint = new Point(this.rsPoint.x, this.rsPoint.y),
        this.leftBottomPoint = new Point(this.rsPoint.x, this.rePoint.y),
        this.rightTopPoint = new Point(this.rePoint.x, this.rsPoint.y),
        this.rightBottomPoint = new Point(this.rePoint.x, this.rePoint.y),
        this.topMiddlePoint = new Point(n + u / 2, this.rsPoint.y),
        this.bottomMiddlePoint = new Point(n + u / 2, this.rePoint.y),
        this.leftMiddlePoint = new Point(this.rsPoint.x, i + f / 2),
        this.rightMiddlePoint = new Point(this.rePoint.x, i + f / 2),
        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
        r.lineWidth = this.width,
        r.strokeStyle = "#" + this.color,
        ta(r, n, i, u, f),
        this.active(),
        this.showMeasurement()
},
    n.calcMeasurementInfo = function () {
        var f = Math.abs(this.startPoint.x - this.endPoint.x),
        e = Math.abs(this.startPoint.y - this.endPoint.y),
        r = f / 2 * this.calibration,
        i = e / 2 * this.calibration,
        n = Math.abs(r - i) / (r + i),
        u,
        t;
        return n = n * n,
        u = isNaN(n) ? 0 : Math.PI * (r + i) * (135168 - 85760 * n - 5568 * n * n + 3867 * n * n * n) / (135168 - 119552 * n + 22208 * n * n - 345 * n * n * n),
        t = "",
        t = appendLine(t, Measurement.Majorhalfaxis + floatRound(Math.max(r, i)) + Measurement.Unit),
        t = appendLine(t, Measurement.Minorhalfaxis + floatRound(Math.min(r, i)) + Measurement.Unit),
        t = appendLine(t, Measurement.Area + floatRound(Math.abs(Math.PI * f * this.calibration * e * this.calibration / 4)) + Measurement.AreaUnit),
        t = appendLine(t, Measurement.Perimeter + floatRound(u) + Measurement.Unit)
    },
    n.isHitMe = function (n) {
        return this.isSelected && this.getActiveMove(n),
        this.activeMove != ActiveMove.None ? !0 : !1;
        var t
    }