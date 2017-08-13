var ShapeCanvas = function (n) {
    function wt() {
        tt = !0
    }
    function dt() {
        pt(),
        u.showImageAnnotations()
    }
    function ii() {
        tt = !1
    }
    function at() {
        var t = n.viewport.getContainerSize();
        a.width = t.x,
        a.height = t.y,
        y.width = t.x,
        y.height = t.y,
        w.width = t.x,
        w.height = t.y,
        h != null && (it.resetContainerSize(t.x, t.y), ut.resetContainerSize(t.x, t.y), u.showImageAnnotations()),
        i.style.width = t.x + "px",
        i.style.height = t.y + "px"
    }
    function pt() {
        var r = n.viewport.getBounds(!0),
        i = n.viewport.getZoom(!0),
        t = n.viewport.getContainerSize();
        o = t.x * i / Number(h.Width);
        s = new SeadragonPoint(-1 * r.x * t.x * i, -1 * r.y * t.x * i)
    }
    function IEpt(h) {
        var r = n.viewport.getBounds(!0),
        i = n.viewport.getZoom(!0),
        t = n.viewport.getContainerSize();
        o = t.x * i / Number(h.Width);
        s = new SeadragonPoint(-1 * r.x * t.x * i, -1 * r.y * t.x * i)
    }
    function ti() {
        Measurement = {
            Length: SlideViewerStrings.getString("Annotations.Measurement.TxtLength"),
            Width: SlideViewerStrings.getString("Annotations.Measurement.TxtWidth"),
            Height: SlideViewerStrings.getString("Annotations.Measurement.TxtHeight"),
            Angle: SlideViewerStrings.getString("Annotations.Measurement.TxtAngle"),
            ArcLength: SlideViewerStrings.getString("Annotations.Measurement.TxtArcLength"),
            Area: SlideViewerStrings.getString("Annotations.Measurement.TxtArea"),
            Majorhalfaxis: SlideViewerStrings.getString("Annotations.Measurement.TxtMajorhalfaxis"),
            Minorhalfaxis: SlideViewerStrings.getString("Annotations.Measurement.TxtMinorhalfaxis"),
            Perimeter: SlideViewerStrings.getString("Annotations.Measurement.TxtPerimeter"),
            Radius: SlideViewerStrings.getString("Annotations.Measurement.TxtRadius"),
            Description: SlideViewerStrings.getString("Annotations.Measurement.TxtDescription"),
            Unit: SlideViewerStrings.getString("Annotations.Measurement.TxtUnit"),
            AreaUnit: SlideViewerStrings.getString("Annotations.Measurement.TxtAreaUnit"),
            Deg: SlideViewerStrings.getString("Annotations.Measurement.TxtDeg")
        },
        ShapeDefaultConfig.name = SlideViewerStrings.getString("Annotations.Default.Name");
        //ShapeDefaultConfig.description = SlideViewerStrings.getString("Annotations.Default.Description")
    }
    function k(n) {
        n.getContext("2d").clearRect(0, 0, n.width, n.height)
    }
    function g() {
        t != null && (t.isSelected = !1, t.measurement = !1),
        t = null,
        k(y)
    }
    function ct(n) {
        var i, t;
        if (r == null) return !1;
        for (i = !1, t = 0; t < r.length; t++) (r[t].isSelected || r[t].measurement) && (r[t].isSelected = !1, r[t].measurement = !1, i = !0);
        return n != null && (n.isSelected = !0),
        i
    }
    function ft(n) {
        var c, o, f;
        if (r == null) return !1;
        var s = !1,
        e = [],
        h = !1;
        if (t != null && (t.measurement = !1), t == null || t.isSelected || (g(), u.showImageAnnotations()), t != null && t.isHitMe(n)) s = !0;
        else if (u.isSelectedEnable || u.isShowInfo) for (f = 0; f < r.length; f++) c = r[f].isHitMyArea(n),
        c && (s = !0, r[f].isSelected = !1, e.push(r[f]), t == r[f] && (h = !0));
        else t != null && (t.isSelected = !1, g(), u.showImageAnnotations());
        if (e.length == 1 && t != e[0]) t = e[0],
        t.isSelected = !0;
        else if (!h && e.length > 0, !1) {
            for (f = 0; f < e.length; f++) f == 0 ? o = e[0] : o.cavRect.x < e[f].cavRect.x && o.cavRect.y < e[f].cavRect.y && o.cavRect.width > e[f].cavRect.width && o.cavRect.height > e[f].cavRect.height && (o = e[f]);
            t = o,
            t.isSelected = !0
        } else for (t == null && (t = e[0]), f = 0; f < e.length; f++) if (t == e[f]) {
            f < e.length - 1 ? (t.isSelected = !1, t = e[f + 1], t.isSelected = !0) : (t.isSelected = !1, t = e[0], t.isSelected = !0);
            break
        }

        return t != null && (t.isSelected ? (t.measurement = !0, t.activeMove != ActiveMove.None ? ($.support.touch ? $(i).bind("touchmove", st) : $(i).bind("mousemove", ot), b = !0, l = n) : !u.isSelectedEnable && u.isShowInfo && (t.isSelected = !1)) : (g(), u.showImageAnnotations())),
        s
    }
    function ht(n) {
        return n.stopPropagation(),
        p && t != null ? (nt(), !1) : void 0
    }
    function ni(n) {
        var b = n.originalEvent,
        w, y, l;
        if (e = b.targetTouches[0].pageX, f = b.targetTouches[0].pageY, c = Seadragon.Utils.getElementPosition(a), e -= c.x, f -= c.y, v == null && ft(new Seadragon.Point(e, f)) && (u.showImageAnnotations(), u.isSelectedEnable || t != null && t.activeMove != ActiveMove.None)) return !1;
        if (v != null) {
            if (t != null && !t.isEndDrawing) return e -= s.x,
            f -= s.y,
            !1;
            ct() && u.showImageAnnotations(),
            n.stopPropagation(),
            e -= s.x,
            f -= s.y,
            w = new Seadragon.Point(e / o, f / o),
            y = endPoint = w;
            switch (v) {
                case AnnotationType.Line:
                    l = new Line(i, y, endPoint);
                    break;
                case AnnotationType.Arrow:
                    l = new Arrow(i, y, endPoint);
                    break;
                case AnnotationType.Rectangle:
                    l = new Rectangle(i, y, endPoint);
                    break;
                case AnnotationType.Ellipse:
                    l = new Ellipse(i, y, endPoint);
                    break;
                case AnnotationType.Remark:
                    l = new Remark(i, y, endPoint);
                    break;
                case AnnotationType.Position:
                    l = new Position(i, y, endPoint);
                    break;
                case AnnotationType.CurveRounded:
                    l = new CurveRounded(i, y, endPoint);
                    break;
                case AnnotationType.Curve:
                    l = new Curve(i, y, endPoint);
                    break;
                case AnnotationType.Angle:
                    l = new Angle(i, y, endPoint);
                    break;
                case AnnotationType.Circle:
                    l = new Circle(i, y, endPoint);
                    break;
                case AnnotationType.CircleThreePoints:
                    l = new CircleThreePoints(i, y, endPoint);
                    break;
                case AnnotationType.Arc:
                    l = new Arc(i, y, endPoint);
                    break;
                case AnnotationType.Polygon:
                    l = new Polygon(i, y, endPoint)
            }
            return r.push(l),
            t = l,
            t.isSelected = !0,
            t.imageId = h.id,
            t.type = v,
            t.scale = o,
            t.guid = guidGenerator(),
            t.refresh(o, s),
            t.calibration = h.calibration,
            t.drawStart(w),
            p = !0,
            $(i).bind("touchmove", st),
            !1
        }
    }
    function gt(n) {
        if (b) return n.stopPropagation(),
        rt(),
        u.showImageAnnotations(),
        !1;
        if (p && t != null) {
            var i = new Seadragon.Point(e / o, f / o);
            return t.drawClick(i),
            t.isEndDrawing ? nt(i) : u.showImageAnnotations(),
            !1
        }
    }
    function st(n) {
        var i = n.originalEvent,
        h, r, a;
        if (i.preventDefault(), b) return e = i.targetTouches[0].pageX,
        f = i.targetTouches[0].pageY,
        e -= c.x,
        f -= c.y,
        (e != l.x || f != l.y) && (t.moveOffset = new Seadragon.Point(e - l.x, f - l.y), l.x = e, l.y = f, u.showImageAnnotations(), t.moveOffset.x = 0, t.moveOffset.y = 0),
        n.stopPropagation(),
        d(),
        !1;
        if (p && t != null) n.stopPropagation();
        else return;
        if (h = i.targetTouches[0].pageX, r = i.targetTouches[0].pageY, h -= c.x + s.x, r -= c.y + s.y, h != e || r != f) return e = h,
        f = r,
        a = new Seadragon.Point(e / o, f / o),
        t.drawMove(a),
        u.showImageAnnotations(),
        d(),
        !1
    }
    function isShow() {
        if (document.getElementById("MainUl").style.display == "block" || document.getElementById("RightUl").style.display == "block") {
            document.getElementById("MainUl").style.display = "none"
            document.getElementById("OtherUl").style.display = "none"
            document.getElementById("RightUl").style.display = "none"
        }
    }
    function ui(n) {
        if (document.getElementById("ysbl"))
            document.getElementById("ysbl").style.display = "none";
        if (document.getElementById("myCanvas"))
            document.getElementById("myCanvas").style.display = "none";
        if (isIElast() && n.button == 0 || n.button == 1) {
            isShow();
            if (e = n.pageX, f = n.pageY, c = Seadragon.Utils.getElementPosition(a), e -= c.x, f -= c.y, v == null && ft(new Seadragon.Point(e, f)) && (u.showImageAnnotations(), t != null && t.activeMove != ActiveMove.None)) return !1;

            if (v != null && (t == null || t.isEndDrawing)) {
                ct() && u.showImageAnnotations(),
            n.stopPropagation(),
            e, f;
                e -= s.x,
            f -= s.y;
                var w = new Seadragon.Point(e / o, f / o),
            y = endPoint = w,
            l;
                switch (v) {
                    case AnnotationType.Line:
                        l = new Line(i, y, endPoint);
                        break;
                    case AnnotationType.Arrow:
                        l = new Arrow(i, y, endPoint);
                        break;
                    case AnnotationType.Rectangle:
                        l = new Rectangle(i, y, endPoint);
                        break;
                    case AnnotationType.Ellipse:
                        l = new Ellipse(i, y, endPoint);
                        break;
                    case AnnotationType.Remark:
                        l = new Remark(i, y, endPoint);
                        break;
                    case AnnotationType.Position:
                        l = new Position(i, y, endPoint);
                        break;
                    case AnnotationType.CurveRounded:
                        l = new CurveRounded(i, y, endPoint);
                        break;
                    case AnnotationType.Curve:
                        l = new Curve(i, y, endPoint);
                        break;
                    case AnnotationType.Angle:
                        l = new Angle(i, y, endPoint);
                        break;
                    case AnnotationType.Circle:
                        l = new Circle(i, y, endPoint);
                        break;
                    case AnnotationType.CircleThreePoints:
                        l = new CircleThreePoints(i, y, endPoint);
                        break;
                    case AnnotationType.Arc:
                        l = new Arc(i, y, endPoint);
                        break;
                    case AnnotationType.Polygon:
                        l = new Polygon(i, y, endPoint)
                }
                return r.push(l),
            t = l,
            t.imageId = h.ID,
            t.type = v,
            t.scale = o,
            t.guid = guidGenerator(),
            t.refresh(o, s),
            t.calibration = h.calibration,
            t.drawStart(w),
            $(i).bind("mousemove", ot),
            p = !0,
                    t.isSelected = !0,
            !1
            }
        }
    }
    function ri(n) {
        if (b) return n.stopPropagation(),
        rt(),
        u.showImageAnnotations(),
        !1;
        if (p && t != null) {
            n.stopPropagation(),
            e = n.pageX,
            f = n.pageY,
            e -= c.x + s.x,
            f -= c.y + s.y;
            var i = new Seadragon.Point(e / o, f / o);
            return t.drawClick(i),
            t.isEndDrawing && nt(i),
            !1
        }
    }
    function nt(n) {
        t.cavScale = o,
        t.cavOffset = s,
        t.isEndDrawing = !0,
        t.measurement = !0,
        t.drawEnd(n),
        rt(),
        u.showImageAnnotations(),
        u.onShapeDrawEnd && u.onShapeDrawEnd()
    }
    function rt() {
        $(i).unbind("mousemove"),
        $(i).unbind("touchmove"),
        t.activeMove = ActiveMove.None,
        v = null,
        p = !1,
        b = !1
    }
    function ot(n) {
        var r, i, h;
        if (b) return e = n.pageX,
        f = n.pageY,
        e -= c.x,
        f -= c.y,
        (e != l.x || f != l.y) && (t.moveOffset = new Seadragon.Point(e - l.x, f - l.y), l.x = e, l.y = f, u.showImageAnnotations(), t.moveOffset.x = 0, t.moveOffset.y = 0),
        n.stopPropagation(),
        d(),
        !1;
        if (p && t != null) n.stopPropagation();
        else return;
        if (r = n.pageX, i = n.pageY, r -= c.x + s.x, i -= c.y + s.y, r != e || i != f) return e = r,
        f = i,
        h = new Seadragon.Point(e / o, f / o),
        t.drawMove(h),
        u.showImageAnnotations(),
        d(),
        !1
    }
    function bt(n, t) {
        return t.imageId = n.imageId,
        t.guid = n.guid,
        t.name = n.name,
        t.description = n.description,
        t.scale = n.scale,
        t.width = n.width,
        t.type = n.type,
        t.region = n.region,
        t.fontUnderLine = n.fontUnderLine,
        t.fontSize = n.fontSize,
        t.fontFamily = n.fontFamily,
        t.fontItalic = n.fontItalic,
        t.fontBold = n.fontBold,
        t.visible = n.visible,
        t.color = NumberToHex(n.color),
        t.measurement = n.measurement,
        t.radius = n.radius,
        t.arcLength = n.arcLength,
        t.angle = n.angle,
        t.points = et(n.points),
        t.calibration = h.calibration,
        t.isEndDrawing = !0,
        t
    }
    function kt(n, t) {
        return n.imageId = t.imageId,
        n.guid = t.guid == null ? guidGenerator() : t.guid,
        n.name = t.name,
        n.description = t.description,
        n.scale = t.scale,
        n.width = t.width,
        n.type = t.type,
        n.fontUnderLine = t.fontUnderLine,
        n.fontSize = t.fontSize,
        n.fontFamily = t.fontFamily,
        n.fontItalic = t.fontItalic,
        n.fontBold = t.fontBold,
        n.visible = t.visible,
        n.color = HexToNumber(t.color),
        n.measurement = t.measurement = !1,
        n.radius = t.radius,
        n.arcLength = t.arcLength,
        n.angle = t.angle,
        n.points = et(t.points),
        n.region = new SeadragonRect(t.startPoint.x, t.startPoint.y, t.endPoint.x - t.startPoint.x, t.endPoint.y - t.startPoint.y),
        n
    }
    function et(n) {
        for (var i = [], t = 0; t < n.length; t++) i.push(new Point(n[t].x, n[t].y));
        return i
    }
    function d() {
        u.isShapeChanged = !0,
        u.onShapeChanged && u.onShapeChanged()
    }
    function lt(n) {
        vt = n
    }
    function IsSelected() {
        var isSelect;
        for (var i = 0; i < r.length; i++) {
            if (r[i].isSelected) {
                isSelect = !0;
                return isSelect;
            }
            else {
                isSelect = !1;
            }
        }
        return isSelect;
    }
    function Rmouse(event) {
        var e = event || window.event;
        var t = { 'x': e.clientX, 'y': e.clientY }
        var ul, oul, uw, uh, ouh, w, h;
        ul = $("#MainUl"); oul = $("#OtherUl"); rul = $("#RightUl");
        uw = ul.width(), uh = ul.height(), ouh = oul.height();
        w = document.body.clientWidth - uw, h = document.body.clientHeight - uh;
        if (IsSelected()) {

            rul[0].style.left = t.x + "px", rul[0].style.top = t.y + "px";
            $("#RightUl").show();
        }
        else {
            t.x < w && t.y < h - ouh ? (ul[0].style.left = t.x + "px", ul[0].style.top = t.y + "px", oul[0].style.left = (t.x + uw) + "px", oul[0].style.top = (t.y + uh - 30) + "px") :
            t.x > w - uw && t.y > h ? (ul[0].style.left = (t.x - uw) + "px", ul[0].style.top = (t.y - uh) + "px", oul[0].style.left = (t.x - uw - uw) + "px", oul[0].style.top = (t.y - ouh) + "px") :
            t.x > w ? (ul[0].style.left = (t.x - uw) + "px", ul[0].style.top = t.y + "px", oul[0].style.left = (t.x - uw - uw) + "px", oul[0].style.top = (t.y + uh - 30) + "px") :
            (ul[0].style.left = t.x + "px", ul[0].style.top = (t.y - uh) + "px", oul[0].style.left = (t.x + uw) + "px", oul[0].style.top = (t.y - ouh) + "px")
            $("#MainUl").show();
            $("#OtherUl").hide()
        }
        $(document).bind("contextmenu", function () {
            return false;
        });
        return false
    }
    function IE(n) {
        if (document.getElementById("MainUl").style.display == "block") {
            document.getElementById("MainUl").style.display = "none"
            document.getElementById("OtherUl").style.display = "none"
        }
    }
    var u = this,
    r = [],
    vt,
    h,
    a,
    y,
    w,
    yt,
    p = !1,
    b = !1,
    tt = !1,
    l,
    t,
    v,
    o = 1,
    s,
    c,
    i,
    e,
    f,
    it,
    inout,
    MinCellWidth = 200,
    divisionNum = 5,
    viewer = n,
    xs,
    MinlblV,
    ut;
    this.isShapeChanged = !1,
    this.onShapeChanged,
    this.onShapeDrawEnd,
    this.isSelectedEnable = !1,
    this.isShowInfo = !0,
    this.setOpenImage = function (t, i) { //t为数据集
        h = t,
        yt = i;
        var r = n.viewport.getContainerSize();   //获取图像大小
        it = new Grid(w, h.calibration, h.Width, h.Height, r.x, r.y),
        ut = new Ruler(w, h.calibration, r.x, r.y),
        pt()
    },
    this.createShapeCanvas = function () {
        if (!SlideViewerSupport.canvas) {
            a = document.createElement("canvas"),
        a.id = "shapeCanvas",
        a.style.position = "absolute",
        y = document.createElement("canvas"),
        y.id = "drawCanvas",
        y.style.position = "absolute",
        w = document.createElement("canvas"),
        w.id = "measureCanvas",
        w.style.position = "absolute",
        ShapeViewer.Canvas = a,
        ShapeViewer.Viewer = u,
        ShapeViewer.DrawCanvas = y,
        i = document.createElement("div"),
        i.id = "shapeContainer",
        i.style.position = "absolute",
        at(),
        ti(),
            //g(),
        i.appendChild(a),
        i.appendChild(y),
        i.appendChild(w),
        n.drawer.elmt.appendChild(i);
            var t = $(i);
            $.support.touch ? (t.bind("touchstart", ni), t.bind("touchend", gt), t.bind("taphold", ht)) : ($("#slide").bind("mousedown", ui), t.bind("mousedown", ui), t.bind("mouseup", ri), t.bind("mouseleave", ri), t.dblclick(ht),
        t.bind("contextmenu", Rmouse), $("#slide").bind("contextmenu", Rmouse));
            $("#slide").bind("mousewheel", u.showrulers); t.bind("mousewheel", u.showrulers);
            n.addEventListener("animationstart", wt);
            n.addEventListener("animation", dt);
            n.addEventListener("animationfinish", ii);
            n.addEventListener("resize", at);
            return !1;
        }
        else {
            a = document.createElement("canvas"),
        a.id = "shapeCanvas",
        a.style.position = "absolute",
        y = document.createElement("canvas"),
        y.id = "drawCanvas",
        y.style.position = "absolute",
        w = document.createElement("canvas"),
        w.id = "measureCanvas",
        w.style.position = "absolute",
        ShapeViewer.Canvas = a,
        ShapeViewer.Viewer = u,
        ShapeViewer.DrawCanvas = y,
        i = document.createElement("div"),
        i.id = "shapeContainer",
        i.style.position = "absolute",
        at(),
        ti(),
        g(),
        i.appendChild(a),
        i.appendChild(y),
        i.appendChild(w),
        n.drawer.elmt.appendChild(i);
            var t = $(i);
            return $.support.touch ? (t.bind("touchstart", ni), t.bind("touchend", gt), t.bind("taphold", ht)) : (t.bind("mousedown", ui), t.bind("mouseup", ri), t.bind("mouseleave", ri), t.dblclick(ht),
        t.bind("contextmenu", Rmouse)),
        n.addEventListener("animationstart", wt),
        n.addEventListener("animation", dt),
        n.addEventListener("animationfinish", ii),
        n.addEventListener("resize", at),
        !0
        }
    },
    this.initImageAnnotationsShape = function (n) {
        var t, u;
        if (n != null) {
            for (this.clearShapeArray(), u = 0; u < n.length; u++) {
                startPoint = new SeadragonPoint(n[u].region.x, n[u].region.y),
                endPoint = new SeadragonPoint(startPoint.x + n[u].region.width, startPoint.y + n[u].region.height);
                switch (n[u].type) {
                    case AnnotationType.Line:
                        t = new Line(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Arrow:
                        t = new Arrow(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Rectangle:
                        t = new Rectangle(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Ellipse:
                        t = new Ellipse(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Remark:
                        t = new Remark(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Position:
                        t = new Position(i, startPoint, endPoint);
                        break;
                    case AnnotationType.CurveRounded:
                        t = new CurveRounded(i, startPoint, endPoint, n[u].points, o, s);
                        break;
                    case AnnotationType.Curve:
                        t = new Curve(i, startPoint, endPoint, n[u].points, o, s);
                        break;
                    case AnnotationType.Angle:
                        t = new Angle(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Circle:
                        t = new Circle(i, startPoint, endPoint);
                        break;
                    case AnnotationType.CircleThreePoints:
                        t = new CircleThreePoints(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Arc:
                        t = new Arc(i, startPoint, endPoint);
                        break;
                    case AnnotationType.Polygon:
                        t = new Polygon(i, startPoint, endPoint);
                        break;
                    default:
                        t = null
                }
                t != null && r.push(bt(n[u], t))
            }
            lt(n)

        }
    },
    this.getAnnotation = function () {
        return r;
    },
    this.dirtyCanvas = function () {
        d()
    },
    this.resumeBackUpShapes = function () {
        for (var n = 0; n < r.length; n++) (r[n].type == AnnotationType.Remark || r[n].type == AnnotationType.Position) && ($(r[n].txtElmt).remove(), $(r[n].inpElmt).remove());
        u.initImageAnnotationsShape(vt),
        u.showImageAnnotations(),
        u.isShapeChanged = !1
    },
    this.setSelectedEnable = function (n) {
        var i, t;  //this.isSelectedEnable=!1;
        if (v = null, u.isSelectedEnable = n, i = !1, !n) {
            for (t = 0; t < r.length; t++) (r[t].isSelected || r[t].measurement) && (r[t].isSelected = r[t].measurement = !1, i = !0);
            i && u.showImageAnnotations()
        }
    },
    this.setShowInfoEnable = function (n) {
        if (u.isShowInfo = n, !n) for (var t = 0; t < r.length; t++) r[t].measurement && (r[t].measurement = !1, $(r[t].txtElmt).hide())
    },
    this.updateImageAnnotations = function (t) {
        function f(n) {
            n.success && (u.isShapeChanged = !1),
            t(n)
        }
        if (h != null && u.isShapeChanged) {
            h.annotations = [];
            for (var i = 0; i < r.length; i++) h.annotations.push(kt(new AnnotationInfo, r[i]));
            n.provider.updateAnnotations(yt, h.id, h.annotations, f),
            lt(h.annotations)
        }
    },
    this.finishDrawing = function () {
        nt()
    },
    this.getActiveShape = function (n) {   //获取标注具体内容
        n == null ? !0 : t = n;
        return t;
    },
    this.setActiveShape = function (n) {
        n.isSelected = !0,
        t = n
    },
    this.turnToShape = function () {
        var u, r;
        if (t != null && t.isSelected) {
            u = n.viewport.getContainerSize(),
            r = h.width * t.scale / u.x,
            n.viewport.zoomTo(r);
            var i = t.toImagePoint(t.movePoint),
            e = i.x / h.width,
            f = i.y / h.width;
            n.viewport.panTo(new Point(e, f))
        }
    },
    this.showMeasurement = function (n) {
        for (var i = 0, t = 0; t < r.length; t++) r[t].type != AnnotationType.Remark && r[t].type != AnnotationType.Position && (r[t].measurement = n, r[t].showMeasurement(), i++);
        i > 0 && d()
    },
    this.deleteAnnotation = function () {
        for (var i, f, n = 0; n < r.length; n++) if (t == r[n] || r[n].isSelected) {
            i = n,
            f = r[n];
            break
        }
        i != null && (r.splice(i, 1), u.showImageAnnotations(), $(f.txtElmt).remove(), $(f.inpElmt).remove(), g(), d())
    },
    this.showrulers = function () {
        var source = viewer.getCurrentImage();
        IEpt(source);
        u.ruler(o, s, source.calibration)
    }
    this.ruler = function (n, t, calibration) {
        var h, cm, cellCm, ot = n;
        var Param = 1 / ot, bl;
        if (Param <= 1) {
            bl = 1;
        }
        else if (Param > 1 && Param < 2) {
            bl = 1;
        }
        else {
            bl = Param - (Param % 2);
        }
        MinlblV = 100 * bl;
        if (MinlblV < 1000) {
            if (MinlblV % 5 != 0) {
                MinlblV = MinlblV + (MinlblV - MinlblV % 5);
            }
        }
        else {
            if (MinlblV % 5000 != 0) {
                if (MinlblV < 5000) {
                    MinlblV = 5000;
                }
                else {
                    MinlblV = MinlblV + (MinlblV / 5000 - MinlblV % 5000);
                }
            }
        }
        xs = MinlblV / (Param * calibration);
        this.CheckLimtRule(xs, MinlblV);
        this.UpRuleLayout(xs, MinlblV)

    }
    this.CheckLimtRule = function () {
        if (xs >= MinCellWidth + MinCellWidth / 2) {
            xs = xs / 2;
            MinlblV = MinlblV / 2;
            this.CheckLimtRule()
        }
        if (xs < 150) {
            xs = xs * 2;
            MinlblV = MinlblV * 2;
        }
    }

    this.UpRuleLayout = function () {
        var k, k1, un;
        if (MinlblV >= 1000) {
            k = Math.round(MinlblV / 5000 * 100) / 100
            un = "mm";
        }
        else {
            k = MinlblV / 5;
            un = "μm";
        }
        k1 = xs / 5;
        $("#slideRuler").css("width", xs + 5);
        $("#rulerHeight2").css("left", k1)
        $("#rulerHeight3").css("left", k1 * 2)
        $("#rulerHeight4").css("left", k1 * 3)
        $("#rulerHeight5").css("left", k1 * 4)
        $("#rulerHeight6").css("left", k1 * 5)

        $("#rulerNum1").text((k * 1))
        $("#rulerNum2").text((k * 2))
        $("#rulerNum3").text((k * 3))
        $("#rulerNum4").text((k * 4))
        $("#rulerNum5").text((k * 5) + un)

    }
    this.showImageAnnotations = function (n) {
        if (a != null && r != null) if (n == null && (n = !1), this.clearShapeCanvas(n), !tt && t != null && !n && (p || b)) t.refresh(o, s),
        t.draw();
        else {
            if (SlideViewerConfig.enableAnnotation != n) {
                for (var i = 0; i < r.length; i++) {
                    if (SlideViewerConfig.enableOne[0] != true) {
                        if (SlideViewerConfig.enableOne[1] == r[i].name) { }
                        else {
                            r[i].refresh(o, s),
                     r[i].draw();
                        }
                    }
                    else {
                        r[i].refresh(o, s),
            r[i].draw();
                    }
                }
                SlideViewerConfig.showGrid() && it.draw(o, s),
            SlideViewerConfig.showRulers() && ut.draw(o, s),
            ut.draws(o, s)
            }
            else {
                if (SlideViewerConfig.enableAnnotation) for (var i = 0; i < r.length; i++) r[i].refresh(o, s),
            r[i].draw();
                SlideViewerConfig.showGrid() && it.draw(o, s),
            SlideViewerConfig.showRulers() && ut.draw(o, s),
            ut.draws(o, s)
            }
        }
    },
    this.setDrawAnnotationType = function (n) {
        v = n
    },
    this.clearShapeCanvas = function (n) {
        if (n == null && (n = !1), n) {
            if (k(a), k(y), k(w), !SlideViewerConfig.enableAnnotation) for (var i = 0; i < r.length; i++) $(r[i].txtElmt).hide(),
            $(r[i].inpElmt).hide()
        } else !tt && t != null && (p || b) ? k(y) : (k(a), t != null && k(y), (SlideViewerConfig.showGrid() || SlideViewerConfig.showRulers()) && k(w))
    },
    this.clearShapeArray = function () {
        r = []
    }
    return u;
}