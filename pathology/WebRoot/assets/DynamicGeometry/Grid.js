Grid = function (n, t, i, r, u, f) {
    Measure.apply(this, [n, t]),
    this.imgSize = new Size(i, r),
    this.containerSize = new Size(u, f),
    this.displayRect = new Rect,
    this.draw = function (n, t) {
        var r, i, f, u;
        if (this.refresh(n, t), r = this.cellWidth * this.cavScale / this.calibration, this.autoAdjustCellWidth) {
            if (r < this.minCellWidth) {
                this.cellWidth *= 2,
                this.draw(n, t);
                return
            }
            if (r > this.maxCellWidth) {
                this.cellWidth /= 2,
                this.draw(n, t);
                return
            }
        }
        if (SlideViewerConfig.showRulers() || (this.defaultPadding = 0), this.displayRect.x = this.cavOffset.x, this.displayRect.y = this.cavOffset.y, this.displayRect.width = this.imgSize.width * this.cavScale, this.displayRect.height = this.imgSize.height * this.cavScale, !(this.displayRect.width < r) && !(this.displayRect.width.height < r)) {
            i = this.getContext(),
            i.beginPath();
            var f, u, o = this.location.x + this.defaultPadding,
            e = this.location.y + this.defaultPadding,
            t = new Point(o + this.cavOffset.x, e + this.cavOffset.y),
            h = t.x % r - o,
            s = t.y % r - e,
            l = Math.min(this.containerSize.width, this.displayRect.width),
            c = Math.min(this.containerSize.height, this.displayRect.height);
            if (this.containerSize.width < this.displayRect.width && this.containerSize.height < this.displayRect.height) {
                for (f = h; f < this.containerSize.width; f += r) i.moveTo(f, e),
                i.lineTo(f, this.containerSize.height);
                for (u = s; u < this.containerSize.height; u += r) i.moveTo(o, u),
                i.lineTo(this.containerSize.width, u)
            } else {
                for (f = this.displayRect.x; f < this.displayRect.width + this.displayRect.x; f += r) i.moveTo(f, this.displayRect.y),
                i.lineTo(f, this.displayRect.y + this.displayRect.height);
                for (u = this.displayRect.y; u < this.displayRect.height + this.displayRect.y; u += r) i.moveTo(this.displayRect.x, u),
                i.lineTo(this.displayRect.x + this.displayRect.width, u)
            }
            i.lineWidth = this.width,
            i.strokeStyle = "Grey",
            i.stroke()
        }
    }
};