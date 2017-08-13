var CurveRounded;
//function () {
//    function t(n, t, i, r) {
//        for (var u, f, e, o = 0; o < t.length; o++) u = new Point(t[o].x, t[o].y),
//        u = n.resetPoint(u, i, r),
//        o == 0 ? (f = new Point(u.x, u.y), e = new Point(u.x, u.y)) : (f.x > u.x && (f.x = u.x), f.y > u.y && (f.y = u.y), e.x < u.x && (e.x = u.x), e.y < u.y && (e.y = u.y)),
//        n.cavPoints.push(u);
//        n.cavScale = i,
//        n.cavOffset = r,
//        n.resetStartPoint(f),
//        n.resetEndPoint(e),
//        n.initRect = new Rect(f.x, f.y, e.x - f.x, e.y - f.y)
//    }
//    CurveRounded = function (n, i, r, u, f, e) {
//        (Rectangle.apply(this, [n, i, r]), this.isClose = !0, this.pointCount = 0, this.cavPoints = [], this.tempPoints, this.initRect, u != null) && t(this, u, f, e)
//    },
//    CurveRounded.prototype = new Rectangle;
//    var n = CurveRounded.prototype;
//    n.draw = function () {
//        var i = this.getContext(),
//        n,
//        o,
//        t;
//        if (i.beginPath(), this.shapeMovePosition(), this.isEndDrawing) {
//            this.activeMove == ActiveMove.None && (this.rsPoint = this.toCanvasPoint(this.startPoint), this.rePoint = this.toCanvasPoint(this.endPoint), this.resetStartPoint(this.rsPoint), this.resetEndPoint(this.rePoint));
//            var f = this.rePoint.x - this.rsPoint.x,
//            e = this.rePoint.y - this.rsPoint.y,
//            r = this.rsPoint.x,
//            u = this.rsPoint.y,
//            s = (this.rePoint.x - this.rsPoint.x) / this.initRect.width,
//            h = (this.rePoint.y - this.rsPoint.y) / this.initRect.height;
//            for (this.tempPoints = [], t = 0; t < this.cavPoints.length; t++) n = new Point(this.cavPoints[t].x, this.cavPoints[t].y),
//            n.x -= this.initRect.x,
//            n.y -= this.initRect.y,
//            n.x *= s,
//            n.y *= h,
//            n.x += r,
//            n.y += u,
//            this.tempPoints.push(n);
//            for (this.points = [], t = 0; t < this.tempPoints.length; t++) n = this.tempPoints[t],
//            this.points.push(new Point((n.x - this.cavOffset.x) / this.cavScale, (n.y - this.cavOffset.y) / this.cavScale)),
//            t == 0 ? (i.moveTo(n.x, n.y), o = n) : t == this.tempPoints.length - 1 ? (i.lineTo(n.x, n.y), this.isClose && i.lineTo(o.x, o.y)) : i.lineTo(n.x, n.y);
//            this.leftTopPoint = new Point(r, u),
//            this.leftBottomPoint = new Point(r, u + e),
//            this.rightTopPoint = new Point(r + f, u),
//            this.rightBottomPoint = new Point(r + f, u + e),
//            this.topMiddlePoint = new Point(r + f / 2, u),
//            this.bottomMiddlePoint = new Point(r + f / 2, u + e),
//            this.leftMiddlePoint = new Point(r, u + e / 2),
//            this.rightMiddlePoint = new Point(r + f, u + e / 2),
//            this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2)
//        } else for (t = 0; t < this.points.length; t++) n = this.resetPoint(this.points[t], this.cavScale, this.cavOffset),
//        t == 0 ? i.moveTo(n.x, n.y) : i.lineTo(n.x, n.y);
//        i.lineWidth = this.width,
//        i.strokeStyle = this.color,
//        i.stroke(),
//        this.active(),
//        this.showMeasurement()
//    },
//    n.calcMeasurementInfo = function () {
//        var t = CalcLengthClosed(this.points) * this.calibration,
//        i = CalcArea(this.points) * this.calibration * this.calibration,
//        n = "";
//        return n = appendLine(n, Measurement.Area + floatRound(i) + Measurement.AreaUnit),
//        n = appendLine(n, Measurement.Perimeter + floatRound(t) + Measurement.Unit)
//    },
//    n.isHitMe = function (n) {
//        var i, r, t;
//        return this.isSelected && this.getActiveMove(n),
//        this.activeMove != ActiveMove.None ? !0 : !1
//    },
//    n.drawStart = function (n) {
//        this.points.push(n),
//        this.startPoint = this.endPoint = n
//    },
//    n.drawMove = function (n) {
//        this.pointCount++,
//        this.pointCount == 4 && (this.pointCount = 0, this.points.push(n), this.endPoint = n)
//    },
//    n.drawEnd = function () {
//        t(this, this.points, this.cavScale, this.cavOffset)
//    }
//} ();


function tc(n, t, i, r) {
    for (var u, f, e, o = 0; o < t.length; o++) u = new Point(t[o].x, t[o].y),
        u = n.resetPoint(u, i, r),
        o == 0 ? (f = new Point(u.x, u.y), e = new Point(u.x, u.y)) : (f.x > u.x && (f.x = u.x), f.y > u.y && (f.y = u.y), e.x < u.x && (e.x = u.x), e.y < u.y && (e.y = u.y)),
        n.cavPoints.push(u);
    n.cavScale = i,
        n.cavOffset = r,
        n.resetStartPoint(f),
        n.resetEndPoint(e),
        n.initRect = new Rect(f.x, f.y, e.x - f.x, e.y - f.y)
}
CurveRounded = function (n, i, r, u, f, e) {
    (Rectangle.apply(this, [n, i, r]), this.isClose = !0, this.pointCount = 0, this.cavPoints = [], this.tempPoints, this.initRect, u != null) && t(this, u, f, e)
},
    CurveRounded.prototype = new Rectangle;
var n = CurveRounded.prototype;
n.draw = function () {
    var i = this.getContext(),
        n,
        o,
        t;
    if (i.beginPath(), this.shapeMovePosition(), this.isEndDrawing) {
        this.activeMove == ActiveMove.None && (this.rsPoint = this.toCanvasPoint(this.startPoint), this.rePoint = this.toCanvasPoint(this.endPoint), this.resetStartPoint(this.rsPoint), this.resetEndPoint(this.rePoint));
        var f = this.rePoint.x - this.rsPoint.x,
            e = this.rePoint.y - this.rsPoint.y,
            r = this.rsPoint.x,
            u = this.rsPoint.y,
            s = (this.rePoint.x - this.rsPoint.x) / this.initRect.width,
            h = (this.rePoint.y - this.rsPoint.y) / this.initRect.height;
        for (this.tempPoints = [], t = 0; t < this.cavPoints.length; t++) n = new Point(this.cavPoints[t].x, this.cavPoints[t].y),
            n.x -= this.initRect.x,
            n.y -= this.initRect.y,
            n.x *= s,
            n.y *= h,
            n.x += r,
            n.y += u,
            this.tempPoints.push(n);
        for (this.points = [], t = 0; t < this.tempPoints.length; t++) n = this.tempPoints[t],
            this.points.push(new Point((n.x - this.cavOffset.x) / this.cavScale, (n.y - this.cavOffset.y) / this.cavScale)),
            t == 0 ? (i.moveTo(n.x, n.y), o = n) : t == this.tempPoints.length - 1 ? (i.lineTo(n.x, n.y), this.isClose && i.lineTo(o.x, o.y)) : i.lineTo(n.x, n.y);
        this.leftTopPoint = new Point(r, u),
            this.leftBottomPoint = new Point(r, u + e),
            this.rightTopPoint = new Point(r + f, u),
            this.rightBottomPoint = new Point(r + f, u + e),
            this.topMiddlePoint = new Point(r + f / 2, u),
            this.bottomMiddlePoint = new Point(r + f / 2, u + e),
            this.leftMiddlePoint = new Point(r, u + e / 2),
            this.rightMiddlePoint = new Point(r + f, u + e / 2),
            this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2)
    } else for (t = 0; t < this.points.length; t++) n = this.resetPoint(this.points[t], this.cavScale, this.cavOffset),
        t == 0 ? i.moveTo(n.x, n.y) : i.lineTo(n.x, n.y);
    i.lineWidth = this.width,
        i.strokeStyle = "#"+this.color,
        i.stroke(),
        this.active(),
        this.showMeasurement()
},
    n.calcMeasurementInfo = function () {
        var t = CalcLengthClosed(this.points) * this.calibration,
        i = CalcArea(this.points) * this.calibration * this.calibration,
        n = "";
        return n = appendLine(n, Measurement.Area + floatRound(i) + Measurement.AreaUnit),
        n = appendLine(n, Measurement.Perimeter + floatRound(t) + Measurement.Unit)
    },
    n.isHitMe = function (n) {
        var i, r, t;
        return this.isSelected && this.getActiveMove(n),
        this.activeMove != ActiveMove.None ? !0 : !1
    },
    n.drawStart = function (n) {
        this.points.push(n),
        this.startPoint = this.endPoint = n
    },
    n.drawMove = function (n) {
        this.pointCount++,
        this.pointCount == 4 && (this.pointCount = 0, this.points.push(n), this.endPoint = n)
    },
    n.drawEnd = function () {
        tc(this, this.points, this.cavScale, this.cavOffset)
    }