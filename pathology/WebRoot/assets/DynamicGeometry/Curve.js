var Curve;
//function () {
//    Curve = function (n, t, i, r, u, f) {
//        CurveRounded.apply(this, [n, t, i, r, u, f]),
//        this.isClose = !1
//    },
//    Curve.prototype = new CurveRounded;
//    var n = Curve.prototype;
//    n.calcMeasurementInfo = function () {
//        var t = CalcLength(this.points) * this.calibration;
//        return appendLine(Measurement.Perimeter, floatRound(t) + Measurement.Unit)
//    }
//} ();

Curve = function (n, t, i, r, u, f) {
    CurveRounded.apply(this, [n, t, i, r, u, f]),
        this.isClose = !1
},
Curve.prototype = new CurveRounded;
var n = Curve.prototype;
n.calcMeasurementInfo = function () {
    var t = CalcLength(this.points) * this.calibration;
    return appendLine(Measurement.Perimeter, floatRound(t) + Measurement.Unit)
}