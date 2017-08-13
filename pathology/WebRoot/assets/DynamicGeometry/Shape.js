//var Shape;
//function () {
//    Shape = function (n, t, i) {
//        this.startPoint = t,
//        this.endPoint = i,
//        this.rsPoint,
//        this.rePoint,
//        this.movePoint,
//        this.calibration = 0,
//        this.width = ShapeDefaultConfig.lineWidth,
//        this.color = ShapeDefaultConfig.defaultColor,
//        this.imageId,
//        this.guid = null,
//        this.name = ShapeDefaultConfig.name,
//        this.description = ShapeDefaultConfig.description,
//        this.scale = 1,
//        this.type,
//        this.region,
//        this.fontUnderLine = !1,
//        this.fontSize = 11,
//        this.fontFamily = "Microsoft Sans Serif",
//        this.fontItalic = !1,
//        this.fontBold = !1,
//        this.visible = !0,
//        this.measurement = !1,
//        this.radius = 0,
//        this.arcLength = 0,
//        this.angle = 0,
//        this.points = [],
//        this.isEndDrawing = !1,
//        this.txtElmt,
//        this.inpElmt,
//        this.container = n,
//        this.isSelected = !1,
//        this.cavScale,
//        this.cavOffset,
//        this.moveOffset,
//        this.activeMove = ActiveMove.None,
//        this.isMeasurementChanged = !0,
//        this.isDrawStart = !1,
//        this.cavRect
//    };
//    var n = Shape.prototype;
//    n.drawThumb = function (n) {
//        if (n != null) {
//            var t = this.getContext();
//            t.beginPath(),
//            t.lineWidth = 2,
//            t.arc(n.x, n.y, ShapeDefaultConfig.thumbRadius, 0, Math.PI * 2, !1),
//            t.fillStyle = "rgba(255, 255, 255, 0.6)",
//            t.fill(),
//            t.strokeStyle = "#666465",
//            t.stroke()
//        }
//    },
//    n.drawMoveThumb = function (n) {
//        if (n != null) {
//            var t = this.getContext();
//            t.beginPath(),
//            t.lineWidth = 2,
//            t.arc(n.x, n.y, ShapeDefaultConfig.thumbMoveRadius, 0, Math.PI * 2, !1),
//            t.fillStyle = "rgba(255, 255, 255, 0.6)",
//            t.fill(),
//            t.strokeStyle = "#666465",
//            t.stroke()
//        }
//    },
//    n.getContext = function () {
//        return this.isSelected ? ShapeViewer.DrawCanvas.getContext("2d") : ShapeViewer.Canvas.getContext("2d")
//    },
//    n.drawStart = function (n) {
//        this.startPoint = n,
//        this.endPoint = new Point(n.x, n.y),
//        this.drawThumb(this.toCanvasPoint(n)),
//        this.isDrawStart = !0
//    },
//    n.drawMove = function (n) {
//        this.endPoint = n,
//        this.isDrawStart = !1
//    },
//    n.drawClick = function (n) {
//        n != null && (this.endPoint = n),
//        this.startPoint.x != this.endPoint.x && this.startPoint.y != this.endPoint.y && (this.isEndDrawing = !0)
//    },
//    n.drawEnd = function () { },
//    n.refresh = function (n, t) {
//        this.cavScale = n,
//        this.cavOffset = t
//    },
//    n.createElmt = function () {
//        this.txtElmt == null && (this.txtElmt = document.createElement("div"), this.container.appendChild(this.txtElmt), registerMeasurementTxtCSS(this.txtElmt))
//    },
//    n.showMeasurement = function () {
//        if (!this.measurement || !SlideViewerConfig.enableAnnotation) {
//            $(this.txtElmt).hide();
//            return
//        }
//        if (this.createElmt(), $(this.txtElmt).show(), registerPositionCSS(this.txtElmt, this.movePoint.x + ShapeDefaultConfig.thumbMoveRadius, this.movePoint.y + ShapeDefaultConfig.thumbMoveRadius), this.isMeasurementChanged) {
//            var n = this.calcMeasurementInfo();
//            n += isHasEnter(this.description) ? append("<table style='border-spacing:0px;'><tr>", "<td>" + Measurement.Description + "</td>" + replaceHtmlEnter("<td>" + this.description + "</td></tr></table>")) : appendLine(Measurement.Description, this.description),
//            $(this.txtElmt).html(n),
//            this.isMeasurementChanged = !1
//        }
//    },
//    n.calcMeasurementInfo = function () { },
//    n.active = function () { },
//    n.shapeMovePosition = function () { },
//    n.isHitMe = function () { },
//    n.isHitMyArea = function (n) {
//        var r, i, u, f, t;
//        return this.type == AnnotationType.Remark || this.type == AnnotationType.Position ? !1 : (this.rsPoint.x < this.rePoint.x ? (r = this.rsPoint.x, u = this.rePoint.x) : (r = this.rePoint.x, u = this.rsPoint.x), this.rsPoint.y < this.rePoint.y ? (i = this.rsPoint.y, f = this.rePoint.y) : (i = this.rePoint.y, f = this.rsPoint.y), t = this.width / 2, this.isSelected = r - t <= n.x && n.x <= u + t && i - t <= n.y && n.y <= f + t ? !0 : !1, this.cavRect = new Rect(r, i, u - r, f - i), this.isSelected)
//    },
//    n.resetPoint = function (n, t, i) {
//        var r = new Point(n.x, n.y);
//        return t && (r.x *= t, r.y *= t),
//        i && (r.x += i.x, r.y += i.y),
//        r
//    },
//    n.resetDefaultColor = function () {
//        defaultColor = this.color
//    },
//    n.clickInThumb = function (n, t) {
//        return clickInCircleResult(ShapeDefaultConfig.thumbHitRadius, t, n, this.width)
//    },
//    n.clickInMoveThumb = function (n, t) {
//        return clickInCircleResult(ShapeDefaultConfig.thumbHitMoveRadius, t, n, this.width)
//    },
//    n.addClickResult = function (n, t, i, r, u) {
//        var f = this.clickInThumb(t, i);
//        f.isIn && (f.activeMove = r, f.pIndex = u, n.push(f))
//    },
//    n.setNearestMove = function (n) {
//        var i, r, t;
//        if (n.length <= 0) this.activeMove = ActiveMove.None;
//        else if (n.length == 1) this.activeMove = n[0].activeMove,
//        this.pIndex = n[0].pIndex;
//        else {
//            for (i = 0, r = 0, t = 0; t < n.length; t++) t == 0 ? r = n[t].length : n[t].length < r && (r = n[t].length, i = t);
//            this.activeMove = n[i].activeMove,
//            this.pIndex = n[i].pIndex
//        }
//    },
//    n.resetActiveMovePoint = function (n, t, i) {
//        if (i == null) {
//            if (this.moveOffset == null) return;
//            n.x += this.moveOffset.x,
//            n.y += this.moveOffset.y
//        } else n.x += i.x,
//        n.y += i.y;
//        t.x = (n.x - this.cavOffset.x) / this.cavScale,
//        t.y = (n.y - this.cavOffset.y) / this.cavScale
//    },
//    n.resetStartPoint = function (n) {
//        this.rsPoint = n,
//        this.startPoint = this.toImagePoint(n)
//    },
//    n.resetEndPoint = function (n) {
//        this.rePoint = n,
//        this.endPoint = this.toImagePoint(n)
//    },
//    n.toImagePoint = function (n) {
//        return new Point((n.x - this.cavOffset.x) / this.cavScale, (n.y - this.cavOffset.y) / this.cavScale)
//    },
//    n.toCanvasPoint = function (n) {
//        return new Point(n.x * this.cavScale + this.cavOffset.x, n.y * this.cavScale + this.cavOffset.y)
//    }
//} ();
var Shape;
Shape = function (n, t, i) {
    this.startPoint = t,
        this.endPoint = i,
        this.rsPoint,
        this.rePoint,
        this.movePoint,
        this.calibration = 0,
        this.width = ShapeDefaultConfig.lineWidth,
        this.color = ShapeDefaultConfig.defaultColor,
        this.imageId,
         this.imageindex,
        this.guid = null,
        this.name = ShapeDefaultConfig.name,
        this.description = ShapeDefaultConfig.description,
        this.scale = 1,
        this.type,
        this.region,
        this.fontUnderLine = !1,
        this.fontSize = 11,
        this.fontFamily = "Microsoft Sans Serif",
        this.fontItalic = !1,
        this.fontBold = !1,
        this.visible = !0,
        this.measurement = !1,
        this.radius = 0,
        this.arcLength = 0,
        this.angle = 0,
        this.points = [],
        this.isEndDrawing = !1,
        this.txtElmt,
        this.inpElmt,
        this.container = n,
        this.isSelected = !1,
        this.cavScale,
        this.cavOffset,
        this.moveOffset,
        this.activeMove = ActiveMove.None,
        this.isMeasurementChanged = !0,
        this.isDrawStart = !1,
        this.cavRect
};
    var n = Shape.prototype;
    n.drawThumb = function (n) {
        if (n != null) {
            var t = this.getContext();
            t.beginPath(),
            t.lineWidth = 2,
            t.arc(n.x, n.y, ShapeDefaultConfig.thumbRadius, 0, Math.PI * 2, !1),
            t.fillStyle = "rgba(255, 255, 255, 0.6)",
            t.fill(),
            t.strokeStyle = "#666465",
            t.stroke()
        }
    },
    n.drawMoveThumb = function (n) {
        if (n != null) {
            var t = this.getContext();
            t.beginPath(),
            t.lineWidth = 2,
            t.arc(n.x, n.y, ShapeDefaultConfig.thumbMoveRadius, 0, Math.PI * 2, !1),
            t.fillStyle = "rgba(255, 255, 255, 0.6)",
            t.fill(),
            t.strokeStyle = "#666465",
            t.stroke()
        }
    },
    n.getContext = function () {
        return this.isSelected ? ShapeViewer.DrawCanvas.getContext("2d") : ShapeViewer.Canvas.getContext("2d")
    },
    n.drawStart = function (n) {
        this.startPoint = n,
        this.endPoint = new Point(n.x, n.y),
        this.drawThumb(this.toCanvasPoint(n)),
        this.isDrawStart = !0
    },
    n.drawMove = function (n) {
        this.endPoint = n,
        this.isDrawStart = !1
    },
    n.drawClick = function (n) {
        n != null && (this.endPoint = n),
        this.startPoint.x != this.endPoint.x && this.startPoint.y != this.endPoint.y && (this.isEndDrawing = !0)
    },
    n.drawEnd = function () { },
    n.refresh = function (n, t) {
        this.cavScale = n,
        this.cavOffset = t
    },
    n.createElmt = function () {
        this.txtElmt == null && (this.txtElmt = document.createElement("div"), this.container.appendChild(this.txtElmt), registerMeasurementTxtCSS(this.txtElmt))
    },
    n.showMeasurement = function () {
        if (!this.measurement || !SlideViewerConfig.enableAnnotation) {
            $(this.txtElmt).hide();
            return
        }
        if (this.createElmt(), $(this.txtElmt).show(), registerPositionCSS(this.txtElmt, this.movePoint.x + ShapeDefaultConfig.thumbMoveRadius, this.movePoint.y + ShapeDefaultConfig.thumbMoveRadius), this.isMeasurementChanged) {
            var n = this.calcMeasurementInfo();
            n += isHasEnter(this.description) ? append("<table style='border-spacing:0px;'><tr>", "<td>" + Measurement.Description + "</td>" + replaceHtmlEnter("<td>" + this.description + "</td></tr></table>")) : appendLine(Measurement.Description, this.description),
            $(this.txtElmt).html(n),
            this.isMeasurementChanged = !1
        }
    },
    n.calcMeasurementInfo = function () { },
    n.active = function () { },
    n.shapeMovePosition = function () { },
    n.isHitMe = function () { },
    n.isHitMyArea = function (n) {
        var r, i, u, f, t;
        return this.type == AnnotationType.Remark || this.type == AnnotationType.Position ? !1 : (this.rsPoint.x < this.rePoint.x ? (r = this.rsPoint.x, u = this.rePoint.x) : (r = this.rePoint.x, u = this.rsPoint.x), this.rsPoint.y < this.rePoint.y ? (i = this.rsPoint.y, f = this.rePoint.y) : (i = this.rePoint.y, f = this.rsPoint.y), t = this.width / 2, this.isSelected = r - t <= n.x && n.x <= u + t && i - t <= n.y && n.y <= f + t ? !0 : !1, this.cavRect = new Rect(r, i, u - r, f - i), this.isSelected)
    },
    n.resetPoint = function (n, t, i) {
        var r = new Point(n.x, n.y);
        return t && (r.x *= t, r.y *= t),
        i && (r.x += i.x, r.y += i.y),
        r
    },
    n.resetDefaultColor = function () {
        defaultColor = this.color
    },
    n.clickInThumb = function (n, t) {
      
        return clickInCircleResult(ShapeDefaultConfig.thumbHitRadius, t, n, this.width)
    },
    n.clickInMoveThumb = function (n, t) {
      
        return clickInCircleResult(ShapeDefaultConfig.thumbHitMoveRadius, t, n, this.width)
    },
    n.addClickResult = function (n, t, i, r, u) {
        var f = this.clickInThumb(t, i);
        f.isIn && (f.activeMove = r, f.pIndex = u, n.push(f))
    },
    n.setNearestMove = function (n) {
        var i, r, t;
        if (n.length <= 0) this.activeMove = ActiveMove.None;
        else if (n.length == 1) this.activeMove = n[0].activeMove,
        this.pIndex = n[0].pIndex;
        else {
            for (i = 0, r = 0, t = 0; t < n.length; t++) t == 0 ? r = n[t].length : n[t].length < r && (r = n[t].length, i = t);
            this.activeMove = n[i].activeMove,
            this.pIndex = n[i].pIndex
        }
    },
    n.resetActiveMovePoint = function (n, t, i) {
        if (i == null) {
            if (this.moveOffset == null) return;
            n.x += this.moveOffset.x,
            n.y += this.moveOffset.y
        } else n.x += i.x,
        n.y += i.y;
        t.x = (n.x - this.cavOffset.x) / this.cavScale,
        t.y = (n.y - this.cavOffset.y) / this.cavScale
    },
    n.resetStartPoint = function (n) {
        this.rsPoint = n,
        this.startPoint = this.toImagePoint(n)
    },
    n.resetEndPoint = function (n) {
        this.rePoint = n,
        this.endPoint = this.toImagePoint(n)
    },
    n.toImagePoint = function (n) {
        return new Point((n.x - this.cavOffset.x) / this.cavScale, (n.y - this.cavOffset.y) / this.cavScale)
    },
    n.toCanvasPoint = function (n) {
        return new Point(n.x * this.cavScale + this.cavOffset.x, n.y * this.cavScale + this.cavOffset.y)
    }