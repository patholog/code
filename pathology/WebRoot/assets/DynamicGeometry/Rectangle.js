var Rectangle;
//function () {
//    Rectangle = function (n, t, i) {
//        Shape.apply(this, [n, t, i]),
//        this.leftTopPoint,
//        this.leftBottomPoint,
//        this.rightTopPoint,
//        this.rightBottomPoint,
//        this.topMiddlePoint,
//        this.bottomMiddlePoint,
//        this.leftMiddlePoint,
//        this.rightMiddlePoint
//    },
//    Rectangle.prototype = new Shape;
//    var n = Rectangle.prototype;
//    n.draw = function () {
//        var i = this.getContext();
//        i.beginPath(),
//        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
//        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
//        this.shapeMovePosition();
//        var u = Math.abs(this.rePoint.x - this.rsPoint.x),
//        r = Math.abs(this.rePoint.y - this.rsPoint.y),
//        n = 0,
//        t = 0;
//        this.rePoint.x > this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rsPoint.x, t = this.rsPoint.y) : this.rePoint.x > this.rsPoint.x && this.rePoint.y < this.rsPoint.y ? (n = this.rsPoint.x, t = this.rePoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rePoint.x, t = this.rsPoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y < this.rsPoint.y && (n = this.rePoint.x, t = this.rePoint.y),
//        this.leftTopPoint = new Point(this.rsPoint.x, this.rsPoint.y),
//        this.leftBottomPoint = new Point(this.rsPoint.x, this.rePoint.y),
//        this.rightTopPoint = new Point(this.rePoint.x, this.rsPoint.y),
//        this.rightBottomPoint = new Point(this.rePoint.x, this.rePoint.y),
//        this.topMiddlePoint = new Point(n + u / 2, this.rsPoint.y),
//        this.bottomMiddlePoint = new Point(n + u / 2, this.rePoint.y),
//        this.leftMiddlePoint = new Point(this.rsPoint.x, t + r / 2),
//        this.rightMiddlePoint = new Point(this.rePoint.x, t + r / 2),
//        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
//        i.strokeStyle = this.color,
//        i.lineWidth = this.width,
//        i.strokeRect(n, t, u, r),
//        i.stroke(),
//        this.active(),
//        this.showMeasurement()
//    },
//    n.calcMeasurementInfo = function () {
//        var t = Math.abs(this.startPoint.x - this.endPoint.x),
//        i = Math.abs(this.startPoint.y - this.endPoint.y),
//        n = "";
//        return n = appendLine(n, Measurement.Width + floatRound(t * this.calibration) + Measurement.Unit),
//        n = appendLine(n, Measurement.Height + floatRound(i * this.calibration) + Measurement.Unit),
//        n = appendLine(n, Measurement.Area + floatRound(t * this.calibration * i * this.calibration) + Measurement.AreaUnit),
//        n = appendLine(n, Measurement.Perimeter + floatRound((2 * i + 2 * t) * this.calibration) + Measurement.Unit)
//    },
//    n.active = function () {
//        (this.isEndDrawing || !this.isDrawStart) && this.isSelected && (this.drawThumb(this.leftTopPoint), this.drawThumb(this.leftBottomPoint), this.drawThumb(this.rightTopPoint), this.drawThumb(this.rightBottomPoint), this.drawThumb(this.topMiddlePoint), this.drawThumb(this.bottomMiddlePoint), this.drawThumb(this.leftMiddlePoint), this.drawThumb(this.rightMiddlePoint), this.drawMoveThumb(this.movePoint))
//    },
//    n.shapeMovePosition = function () {
//        if (this.activeMove != null && this.activeMove != ActiveMove.None && this.moveOffset != null) {
//            var n;
//            switch (this.activeMove) {
//                case ActiveMove.LeftTopMove:
//                    this.resetActiveMovePoint(this.rsPoint, this.startPoint);
//                    break;
//                case ActiveMove.RightTopMove:
//                    n = new Point(0, this.moveOffset.y),
//                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n),
//                n = new Point(this.moveOffset.x, 0),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
//                    break;
//                case ActiveMove.LeftBottomMove:
//                    n = new Point(this.moveOffset.x, 0),
//                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n),
//                n = new Point(0, this.moveOffset.y),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
//                    break;
//                case ActiveMove.RightBottomMove:
//                    this.resetActiveMovePoint(this.rePoint, this.endPoint);
//                    break;
//                case ActiveMove.TopMiddleMove:
//                    n = new Point(0, this.moveOffset.y),
//                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n);
//                    break;
//                case ActiveMove.BottomMiddleMove:
//                    n = new Point(0, this.moveOffset.y),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
//                    break;
//                case ActiveMove.LeftMiddleMove:
//                    n = new Point(this.moveOffset.x, 0),
//                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n);
//                    break;
//                case ActiveMove.RightMiddleMove:
//                    n = new Point(this.moveOffset.x, 0),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
//                    break;
//                case ActiveMove.ShapeMove:
//                    this.resetActiveMovePoint(this.rsPoint, this.startPoint),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint)
//            }
//            this.activeMove != ActiveMove.ShapeMove && (this.isMeasurementChanged = !0)
//        }
//    },
//    n.getActiveMove = function (n) {
//        var t = [];
//        this.addClickResult(t, n, this.leftTopPoint, ActiveMove.LeftTopMove),
//        this.addClickResult(t, n, this.leftBottomPoint, ActiveMove.LeftBottomMove),
//        this.addClickResult(t, n, this.rightTopPoint, ActiveMove.RightTopMove),
//        this.addClickResult(t, n, this.rightBottomPoint, ActiveMove.RightBottomMove),
//        this.addClickResult(t, n, this.topMiddlePoint, ActiveMove.TopMiddleMove),
//        this.addClickResult(t, n, this.bottomMiddlePoint, ActiveMove.BottomMiddleMove),
//        this.addClickResult(t, n, this.leftMiddlePoint, ActiveMove.LeftMiddleMove),
//        this.addClickResult(t, n, this.rightMiddlePoint, ActiveMove.RightMiddleMove),
//        this.addClickResult(t, n, this.movePoint, ActiveMove.ShapeMove),
//        this.setNearestMove(t);
//        return
//    },
//    n.isHitMe = function (n) {
//        return this.isSelected && this.getActiveMove(n),
//        this.activeMove != ActiveMove.None ? !0 : !1;
//        var t
//    }
//} ();

Rectangle = function (n, t, i) {
    Shape.apply(this, [n, t, i]),
        this.leftTopPoint,
        this.leftBottomPoint,
        this.rightTopPoint,
        this.rightBottomPoint,
        this.topMiddlePoint,
        this.bottomMiddlePoint,
        this.leftMiddlePoint,
        this.rightMiddlePoint
},
    Rectangle.prototype = new Shape;
var n = Rectangle.prototype;
n.draw = function () {
    var i = this.getContext();
    i.beginPath(),
        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
        this.shapeMovePosition();
    var u = Math.abs(this.rePoint.x - this.rsPoint.x),
        r = Math.abs(this.rePoint.y - this.rsPoint.y),
        n = 0,
        t = 0;
    this.rePoint.x > this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rsPoint.x, t = this.rsPoint.y) : this.rePoint.x > this.rsPoint.x && this.rePoint.y < this.rsPoint.y ? (n = this.rsPoint.x, t = this.rePoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y > this.rsPoint.y ? (n = this.rePoint.x, t = this.rsPoint.y) : this.rePoint.x < this.rsPoint.x && this.rePoint.y < this.rsPoint.y && (n = this.rePoint.x, t = this.rePoint.y),
        this.leftTopPoint = new Point(this.rsPoint.x, this.rsPoint.y),
        this.leftBottomPoint = new Point(this.rsPoint.x, this.rePoint.y),
        this.rightTopPoint = new Point(this.rePoint.x, this.rsPoint.y),
        this.rightBottomPoint = new Point(this.rePoint.x, this.rePoint.y),
        this.topMiddlePoint = new Point(n + u / 2, this.rsPoint.y),
        this.bottomMiddlePoint = new Point(n + u / 2, this.rePoint.y),
        this.leftMiddlePoint = new Point(this.rsPoint.x, t + r / 2),
        this.rightMiddlePoint = new Point(this.rePoint.x, t + r / 2),
        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
        i.strokeStyle = "#" + this.color,
        i.lineWidth = this.width,
        i.strokeRect(n, t, u, r),
        i.stroke(),
        this.active(),
        this.showMeasurement()
},
    n.calcMeasurementInfo = function () {
        var t = Math.abs(this.startPoint.x - this.endPoint.x),
        i = Math.abs(this.startPoint.y - this.endPoint.y),
        n = "";
        return n = appendLine(n, Measurement.Width + floatRound(t * this.calibration) + Measurement.Unit),
        n = appendLine(n, Measurement.Height + floatRound(i * this.calibration) + Measurement.Unit),
        n = appendLine(n, Measurement.Area + floatRound(t * this.calibration * i * this.calibration) + Measurement.AreaUnit),
        n = appendLine(n, Measurement.Perimeter + floatRound((2 * i + 2 * t) * this.calibration) + Measurement.Unit)
    },
    n.active = function () {
        (this.isEndDrawing || !this.isDrawStart) && this.isSelected && (this.drawThumb(this.leftTopPoint), this.drawThumb(this.leftBottomPoint), this.drawThumb(this.rightTopPoint), this.drawThumb(this.rightBottomPoint), this.drawThumb(this.topMiddlePoint), this.drawThumb(this.bottomMiddlePoint), this.drawThumb(this.leftMiddlePoint), this.drawThumb(this.rightMiddlePoint), this.drawMoveThumb(this.movePoint))
    },
    n.shapeMovePosition = function () {
        if (this.activeMove != null && this.activeMove != ActiveMove.None && this.moveOffset != null) {
            var n;
            switch (this.activeMove) {
                case ActiveMove.LeftTopMove:
                    this.resetActiveMovePoint(this.rsPoint, this.startPoint);
                    break;
                case ActiveMove.RightTopMove:
                    n = new Point(0, this.moveOffset.y),
                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n),
                n = new Point(this.moveOffset.x, 0),
                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
                    break;
                case ActiveMove.LeftBottomMove:
                    n = new Point(this.moveOffset.x, 0),
                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n),
                n = new Point(0, this.moveOffset.y),
                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
                    break;
                case ActiveMove.RightBottomMove:
                    this.resetActiveMovePoint(this.rePoint, this.endPoint);
                    break;
                case ActiveMove.TopMiddleMove:
                    n = new Point(0, this.moveOffset.y),
                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n);
                    break;
                case ActiveMove.BottomMiddleMove:
                    n = new Point(0, this.moveOffset.y),
                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
                    break;
                case ActiveMove.LeftMiddleMove:
                    n = new Point(this.moveOffset.x, 0),
                this.resetActiveMovePoint(this.rsPoint, this.startPoint, n);
                    break;
                case ActiveMove.RightMiddleMove:
                    n = new Point(this.moveOffset.x, 0),
                this.resetActiveMovePoint(this.rePoint, this.endPoint, n);
                    break;
                case ActiveMove.ShapeMove:
                    this.resetActiveMovePoint(this.rsPoint, this.startPoint),
                this.resetActiveMovePoint(this.rePoint, this.endPoint)
            }
            this.activeMove != ActiveMove.ShapeMove && (this.isMeasurementChanged = !0)
        }
    },
    n.getActiveMove = function (n) {
        var t = [];
        this.addClickResult(t, n, this.leftTopPoint, ActiveMove.LeftTopMove),
        this.addClickResult(t, n, this.leftBottomPoint, ActiveMove.LeftBottomMove),
        this.addClickResult(t, n, this.rightTopPoint, ActiveMove.RightTopMove),
        this.addClickResult(t, n, this.rightBottomPoint, ActiveMove.RightBottomMove),
        this.addClickResult(t, n, this.topMiddlePoint, ActiveMove.TopMiddleMove),
        this.addClickResult(t, n, this.bottomMiddlePoint, ActiveMove.BottomMiddleMove),
        this.addClickResult(t, n, this.leftMiddlePoint, ActiveMove.LeftMiddleMove),
        this.addClickResult(t, n, this.rightMiddlePoint, ActiveMove.RightMiddleMove),
        this.addClickResult(t, n, this.movePoint, ActiveMove.ShapeMove),
        this.setNearestMove(t);
        return
    },
    n.isHitMe = function (n) {
        return this.isSelected && this.getActiveMove(n),
        this.activeMove != ActiveMove.None ? !0 : !1;
        var t
    }