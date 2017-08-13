//var Line;
//function () {
//    Line = function (n, t, i) {
//        Shape.apply(this, [n, t, i])
//    },
//    Line.prototype = new Shape;
//    var n = Line.prototype;
//    n.draw = function () {
//        var n = this.getContext();
//        n.beginPath(),
//        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
//        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
//        this.shapeMovePosition(),
//        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
//        n.moveTo(this.rsPoint.x, this.rsPoint.y),
//        n.lineTo(this.rePoint.x, this.rePoint.y),
//        n.lineWidth = this.width,
//        n.strokeStyle = this.color,
//        n.stroke(),
//        this.active(),
//        this.showMeasurement()
//    },
//    n.shapeMovePosition = function () {
//        if (this.activeMove != ActiveMove.None) {
//            switch (this.activeMove) {
//                case ActiveMove.StartMove:
//                    this.resetActiveMovePoint(this.rsPoint, this.startPoint);
//                    break;
//                case ActiveMove.EndMove:
//                    this.resetActiveMovePoint(this.rePoint, this.endPoint);
//                    break;
//                case ActiveMove.ShapeMove:
//                    this.resetActiveMovePoint(this.rsPoint, this.startPoint),
//                this.resetActiveMovePoint(this.rePoint, this.endPoint)
//            }
//            this.activeMove != ActiveMove.ShapeMove && (this.isMeasurementChanged = !0)
//        }
//    },
//    n.calcMeasurementInfo = function () {
//        return appendLine(Measurement.Length, floatRound(CalcRadius(this.startPoint, this.endPoint) * this.calibration) + Measurement.Unit)
//    },
//    n.active = function () {
//        (this.isEndDrawing || !this.isDrawStart) && this.isSelected && (this.drawThumb(this.rsPoint), this.drawThumb(this.rePoint), this.drawMoveThumb(this.movePoint))
//    },
//    n.isHitMe = function (n) {
//        if (this.isSelected) {
//            var t = [];
//            this.addClickResult(t, n, this.rePoint, ActiveMove.EndMove),
//            this.addClickResult(t, n, this.rsPoint, ActiveMove.StartMove),
//            this.addClickResult(t, n, this.movePoint, ActiveMove.ShapeMove),
//            this.setNearestMove(t)
//        }
//        return this.activeMove != ActiveMove.None ? !0 : !1
//    },
//    n.isHitMyArea = function (n) {
//        if (this.activeMove == ActiveMove.None) {
//            var t = clickOnLine(this.rsPoint, this.rePoint, n, this.width);
//            return this.isSelected = t,
//            t
//        }
//        return !0
//    }
//} ();
var Line;
Line = function (n, t, i) {
    Shape.apply(this, [n, t, i])
},
    Line.prototype = new Shape;
var n = Line.prototype;
n.draw = function () {
    var n = this.getContext();
    n.beginPath(),
        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
        this.shapeMovePosition(),
        this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2),
        n.moveTo(this.rsPoint.x, this.rsPoint.y),
        n.lineTo(this.rePoint.x, this.rePoint.y),
        n.lineWidth = this.width,
        n.strokeStyle ="#"+this.color,
        n.stroke(),
        this.active(),
        this.showMeasurement()
},
    n.shapeMovePosition = function () {
        if (this.activeMove != ActiveMove.None) {
            switch (this.activeMove) {
                case ActiveMove.StartMove:
                    this.resetActiveMovePoint(this.rsPoint, this.startPoint);
                    break;
                case ActiveMove.EndMove:
                    this.resetActiveMovePoint(this.rePoint, this.endPoint);
                    break;
                case ActiveMove.ShapeMove:
                    this.resetActiveMovePoint(this.rsPoint, this.startPoint),
                this.resetActiveMovePoint(this.rePoint, this.endPoint)
            }
            this.activeMove != ActiveMove.ShapeMove && (this.isMeasurementChanged = !0)
        }
    },
    n.calcMeasurementInfo = function () {
        return appendLine(Measurement.Length, floatRound(CalcRadius(this.startPoint, this.endPoint) * this.calibration) + Measurement.Unit)
    },
    n.active = function () {
        (this.isEndDrawing || !this.isDrawStart) && this.isSelected && (this.drawThumb(this.rsPoint), this.drawThumb(this.rePoint), this.drawMoveThumb(this.movePoint))
    },
    n.isHitMe = function (n) {
        if (this.isSelected) {
            var t = [];
            this.addClickResult(t, n, this.rePoint, ActiveMove.EndMove),
            this.addClickResult(t, n, this.rsPoint, ActiveMove.StartMove),
            this.addClickResult(t, n, this.movePoint, ActiveMove.ShapeMove),
            this.setNearestMove(t)
        }
        return this.activeMove != ActiveMove.None ? !0 : !1
    },
    n.isHitMyArea = function (n) {
        if (this.activeMove == ActiveMove.None) {
            var t = clickOnLine(this.rsPoint, this.rePoint, n, this.width);
            return this.isSelected = t,
            t
        }
        return !0
    }