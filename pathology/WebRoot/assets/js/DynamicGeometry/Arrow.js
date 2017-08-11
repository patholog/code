var Arrow;
//function () {
//    Arrow = function (n, t, i) {
//        Line.apply(this, [n, t, i])
//    },
//    Arrow.prototype = new Line;
//    var n = Arrow.prototype;
//    n.draw = function () {
//        var t = this.getContext(),
//        o,
//        r,
//        i,
//        n;
//        if (t.beginPath(), this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset), this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset), this.shapeMovePosition(), this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2), t.moveTo(this.rsPoint.x, this.rsPoint.y), t.lineTo(this.rePoint.x, this.rePoint.y), o = (this.rsPoint.y - this.rePoint.y) / (this.rsPoint.x - this.rePoint.x), n = new Point(this.width * 2, this.width * 3), this.rsPoint.x == this.rePoint.x) this.rsPoint.y < this.rePoint.y ? (r = new Point(this.rsPoint.x - n.x, this.rsPoint.y + n.y), i = new Point(this.rsPoint.x + n.x, this.rsPoint.y + n.y)) : (r = new Point(this.rsPoint.x - n.x, this.rsPoint.y - n.y), i = new Point(this.rsPoint.x + n.x, this.rsPoint.y - n.y));
//        else if (this.rsPoint.y == this.rePoint.y) this.rsPoint.x < this.rePoint.x ? (r = new Point(this.rsPoint.x + n.y, this.rsPoint.y - n.x), i = new Point(this.rsPoint.x + n.y, this.rsPoint.y + n.x)) : (r = new Point(this.rsPoint.x - n.y, this.rsPoint.y - n.x), i = new Point(this.rsPoint.x - n.y, this.rsPoint.y + n.x));
//        else {
//            var e = Math.atan2(this.rsPoint.y - this.rePoint.y, this.rsPoint.x - this.rePoint.x),
//            u = Math.atan2(n.x, n.y),
//            f = Math.sqrt(n.x * n.x + n.y * n.y);
//            r = new Point(this.rsPoint.x - f * Math.cos(e + u), this.rsPoint.y - f * Math.sin(e + u)),
//            i = new Point(this.rsPoint.x - f * Math.cos(e - u), this.rsPoint.y - f * Math.sin(e - u))
//        }
//        t.moveTo(r.x, r.y),
//        t.lineTo(this.rsPoint.x, this.rsPoint.y),
//        t.lineTo(i.x, i.y),
//        t.lineWidth = this.width,
//        t.strokeStyle = this.color,
//        t.stroke(),
//        this.active(),
//        this.showMeasurement()
//    }
//} ();
Arrow = function (n, t, i) {
    Line.apply(this, [n, t, i])
},
    Arrow.prototype = new Line;
var n = Arrow.prototype;
n.draw = function () {
    var t = this.getContext(),
        o,
        r,
        i,
        n;
    if (t.beginPath(), this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset), this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset), this.shapeMovePosition(), this.movePoint = new Point((this.rsPoint.x + this.rePoint.x) / 2, (this.rsPoint.y + this.rePoint.y) / 2), t.moveTo(this.rsPoint.x, this.rsPoint.y), t.lineTo(this.rePoint.x, this.rePoint.y), o = (this.rsPoint.y - this.rePoint.y) / (this.rsPoint.x - this.rePoint.x), n = new Point(this.width * 2, this.width * 3), this.rsPoint.x == this.rePoint.x) this.rsPoint.y < this.rePoint.y ? (r = new Point(this.rsPoint.x - n.x, this.rsPoint.y + n.y), i = new Point(this.rsPoint.x + n.x, this.rsPoint.y + n.y)) : (r = new Point(this.rsPoint.x - n.x, this.rsPoint.y - n.y), i = new Point(this.rsPoint.x + n.x, this.rsPoint.y - n.y));
    else if (this.rsPoint.y == this.rePoint.y) this.rsPoint.x < this.rePoint.x ? (r = new Point(this.rsPoint.x + n.y, this.rsPoint.y - n.x), i = new Point(this.rsPoint.x + n.y, this.rsPoint.y + n.x)) : (r = new Point(this.rsPoint.x - n.y, this.rsPoint.y - n.x), i = new Point(this.rsPoint.x - n.y, this.rsPoint.y + n.x));
    else {
        var e = Math.atan2(this.rsPoint.y - this.rePoint.y, this.rsPoint.x - this.rePoint.x),
            u = Math.atan2(n.x, n.y),
            f = Math.sqrt(n.x * n.x + n.y * n.y);
        r = new Point(this.rsPoint.x - f * Math.cos(e + u), this.rsPoint.y - f * Math.sin(e + u)),
            i = new Point(this.rsPoint.x - f * Math.cos(e - u), this.rsPoint.y - f * Math.sin(e - u))
    }
    t.moveTo(r.x, r.y),
        t.lineTo(this.rsPoint.x, this.rsPoint.y),
        t.lineTo(i.x, i.y),
        t.lineWidth = this.width,
        t.strokeStyle = "#" + this.color,
        t.stroke(),
        this.active(),
        this.showMeasurement()
}