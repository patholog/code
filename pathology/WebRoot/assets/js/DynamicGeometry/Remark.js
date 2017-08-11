var Remark;
//function () {
//    function i(n) {
//        if (!ShapeViewer.Viewer.isSelectedEnable) return !0;
//        var i = n.data.owner;
//        return ShapeViewer.Viewer.setActiveShape(i),
//        i.type == AnnotationType.Position ? (i.isSelected = !0, ShapeViewer.Viewer.showImageAnnotations()) : t(!0, i),
//        n.stopPropagation(),
//        !1
//    }
//    function t(n, t) {
//        if (n) replaceSize(t.inpElmt, t.txtElmt),
//        $(t.txtElmt).hide(),
//        $(t.inpElmt).show(),
//        t.inpElmt.select(),
//        t.isSelected = !0,
//        t.active();
//        else {
//            $(t.txtElmt).show();
//            var i = $(t.inpElmt).val();
//            t.description != i && ShapeViewer.Viewer.dirtyCanvas(),
//            $(t.txtElmt).html(replaceHtmlEnter(i)),
//            $(t.inpElmt).hide(),
//            t.description = i
//        }
//    }
//    Remark = function (n, t, i) {
//        Shape.apply(this, [n, t, i]),
//        n != null && this.createElmt()
//    },
//    Remark.prototype = new Shape;
//    var n = Remark.prototype;
//    n.draw = function () {
//        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
//        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
//        this.setCSS(this.rsPoint.x, this.rsPoint.y),
//        this.shapeMovePosition()
//    },
//    n.active = function () {
//        this.isSelected && (this.movePoint = new Point(this.rsPoint.x + parseInt(this.inpElmt.style.width) / 2, this.rsPoint.y + parseInt(this.inpElmt.style.height) / 2), this.drawMoveThumb(this.rsPoint))
//    },
//    n.isHitMe = function (n) {
//        if (this.isSelected) {
//            var t = [];
//            if (this.addClickResult(t, n, this.rsPoint, ActiveMove.ShapeMove), this.setNearestMove(t), this.activeMove == ActiveMove.ShapeMove) return !0
//        }
//        return !1
//    },
//    n.isHitMyArea = function (n) {
//        return this.isSelected = this.isHitMe(n)
//    },
//    n.shapeMovePosition = function () {
//        this.activeMove != null && this.activeMove != ActiveMove.None && this.activeMove == ActiveMove.ShapeMove && (this.resetActiveMovePoint(this.rsPoint, this.startPoint), this.resetActiveMovePoint(this.rePoint, this.endPoint))
//    },
//    n.createElmt = function () {
//        var n;
//        this.txtElmt == null && (this.txtElmt = document.createElement("label"), this.container.appendChild(this.txtElmt), n = $(this.txtElmt), n.bind("mousedown", {
//            owner: this
//        },
//        i), n.hide()),
//        this.inpElmt == null && (this.inpElmt = document.createElement("textarea"), this.container.appendChild(this.inpElmt), n = $(this.inpElmt), n.hide(), n.mousedown(function (n) {
//            n.stopPropagation()
//        }))
//    },
//    n.setCSS = function (n, i) {
//        registerTxtCSS(this.txtElmt, n, i, this.fontSize, this.fontFamily, this.color, this.fontBold, this.fontItalic, this.fontUnderLine, this.description, !0, !0),
//        registerTxtCSS(this.inpElmt, n, i, this.fontSize, this.fontFamily, this.color, this.fontBold, this.fontItalic, this.fontUnderLine, this.description, !0, !1),
//        t(this.isSelected, this)
//    },
//    n.drawStart = function () { },
//    n.drawClick = function () {
//        this.isEndDrawing = !0
//    }
//} ();

    function i(n) {
        if (!ShapeViewer.Viewer.isSelectedEnable) return !0;
        var i = n.data.owner;
        return ShapeViewer.Viewer.setActiveShape(i),
        i.type == AnnotationType.Position ? (i.isSelected = !0, ShapeViewer.Viewer.showImageAnnotations()) : t(!0, i),
        n.stopPropagation(),
        !1
    }
    function tb(n, t) {
        if (n) replaceSize(t.inpElmt, t.txtElmt),
        $(t.txtElmt).hide(),
        $(t.inpElmt).show(),
        t.inpElmt.select(),
        t.isSelected = !0,
        t.active();
        else {
            $(t.txtElmt).show();
            var i = $(t.inpElmt).val();
            t.description != i && ShapeViewer.Viewer.dirtyCanvas(),
            $(t.txtElmt).html(replaceHtmlEnter(i)),
            $(t.inpElmt).hide(),
            t.description = i
        }
    }
    Remark = function (n, t, i) {
        Shape.apply(this, [n, t, i]),
        n != null && this.createElmt()
    },
    Remark.prototype = new Shape;
    var n = Remark.prototype;
    n.draw = function () {
        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
        this.setCSS(this.rsPoint.x, this.rsPoint.y),
        this.shapeMovePosition()
    },
    n.active = function () {
        this.isSelected && (this.movePoint = new Point(this.rsPoint.x + parseInt(this.inpElmt.style.width) / 2, this.rsPoint.y + parseInt(this.inpElmt.style.height) / 2), this.drawMoveThumb(this.rsPoint))
    },
    n.isHitMe = function (n) {
       this.isSelected = !0;
        if (this.isSelected) {
            var t = [];
            if (this.addClickResult(t, n, this.rsPoint, ActiveMove.ShapeMove), this.setNearestMove(t), this.activeMove == ActiveMove.ShapeMove) return !0
        }
        return !1
    },
    n.isHitMyArea = function (n) {
        return this.isSelected = this.isHitMe(n)
    },
    n.shapeMovePosition = function () {
       
        this.activeMove != null && this.activeMove != ActiveMove.None && this.activeMove == ActiveMove.ShapeMove && (this.resetActiveMovePoint(this.rsPoint, this.startPoint), this.resetActiveMovePoint(this.rePoint, this.endPoint))
    },
    n.createElmt = function () {
        var n;
        this.txtElmt == null && (this.txtElmt = document.createElement("label"), this.container.appendChild(this.txtElmt), n = $(this.txtElmt), n.bind("mousedown", {
            owner: this
        },
        i), n.hide()),
        this.inpElmt == null && (this.inpElmt = document.createElement("textarea"), this.container.appendChild(this.inpElmt), n = $(this.inpElmt), n.hide(), n.mousedown(function (n) {
            n.stopPropagation()
        }))
    },
    n.setCSS = function (n, i) {
        registerTxtCSS(this.txtElmt, n, i, this.fontSize, this.fontFamily, this.color, this.fontBold, this.fontItalic, this.fontUnderLine, this.description, !0, !0),
        registerTxtCSS(this.inpElmt, n, i, this.fontSize, this.fontFamily, this.color, this.fontBold, this.fontItalic, this.fontUnderLine, this.description, !0, !1),
        tb(this.isSelected, this)
    },
    n.drawStart = function () { },
    n.drawClick = function () {
        this.isEndDrawing = !0
    }
