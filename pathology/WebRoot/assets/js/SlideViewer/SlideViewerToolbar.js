var SliderPanel = function (n, t, i) {
    function e() {
        u.elmt = document.createElement("div"),
        $(u.elmt).addClass("ui-corner-all ui-dialog-content slider-panel-contain").hide(),
        f = $('<label for="slider3D" class="slider-panel-text">0</label>'),
        r = $('<div id="slider3D" class="slider-panel-slider"></div>').slider({
            min: n,
            max: t,
            setp: i,
            slide: function (n, t) {
                f.html(t.value.toString())
            }
        }),
        $(u.elmt).append(f).append(r)
    }
    var u = this,
    r, f;
    this.elmt,
    function () {
        e()
    } (),
    this.setData = function (n, t, i, u) {
        r.slider("option", "min", n),
        r.slider("option", "max", t),
        r.slider("option", "step", u || 1),
        r.slider("value", i || 0)
    },
    this.change = function (n) {
        r.bind("slidechange", n)
    },
    this.val = function () {
        return parseInt(r.slider("value"))
    },
    this.show = function () {
        $(u.elmt).show()
    },
    this.hide = function () {
        $(u.elmt).hide()
    }
};
var Toolbar = function () {
    function t() {
        n.addClass("toolbar"),
        n.append("<table><tr></tr></table>")
    }
    this.elmt = document.createElement("div");
    var n = $(this.elmt);
    (function () {
        t()
    })(),
    this.addToolstrip = function (t) {
        var i = n.find("tr");
        i.append(t.elmt)
    },
    this.hide = function () {
        n.hide()
    },
    this.show = function () {
        n.show()
    }
},
Toolstrip = function (n, t) { //n 为百分比 t为对齐方式
    function u() {
        var r = i;
        r.addClass("toolstrip"),
        t && r.css("text-align", t),
        n && r.css("width", n)
    }
    var f = this,
    i, r;
    this.elmt = document.createElement("td"),
    i = $(this.elmt),
    r = [],
    function () {
        u()
    } (),
    this.addItem = function (n) {
        i.append(n.elmt),
        n.toolstrip = f,
        r.push(n)
    }
},
ToolButton = function (n, t, i, r, u) {
    function e() {
        var e = f,
        o;
        i && e.bind("click", r, i),
        t ? (e.addClass("ui-btn ui-btn-up-a ui-btn-inline ui-btn-corner-all ui-shadow toolbutton-jqm"), e.append("<span class='ui-btn-inner ui-btn-corner-all'><span class='ui-btn-text'></span></span>"), e.find(".ui-btn-text").text(t)) : (e.addClass("toolbutton"), o = document.createElement("span"), $(o).addClass("toolbutton-inner toolbtn-icon-" + n), e.append(o)),
        u && e.attr("title", u)
    }
    this.elmt = document.createElement("a"),
    this.data = r;
    var f = $(this.elmt);
    (function () {
        e()
    })(),
    this.hide = function () {
        f.hide()
    },
    this.show = function () {
        f.css("display", "")
    },
    this.setSelected = function (i) {
        if (!t) {
            var r = "toolbtn-icon-" + n + "-selected";
            i ? f.find(".toolbutton-inner").addClass(r) : f.find(".toolbutton-inner").removeClass(r)
        }
    }
},
ToolLabel = function (n, t) {
    function r() {
        var r = i;
        r.addClass("toollabel"),
        t && r.css("width", t),
        r.text(n)
    }
    this.elmt = document.createElement("span");
    var i = $(this.elmt);
    (function () {
        r()
    })(),
    this.setText = function (n) {
        i.text(n)
    }
},
MainToolbar = function (n) {
    function ut() {
        i.onback && i.onback()
    }
    function it() {
        n.viewport && n.viewport.goHome()
    }
    function tt(t) {
        n && n.zoomToObj(t.data.obj)
    }
    function a() { //切片的 Open 事件，harry
        //var i = n.getCurrentSlide(),
        t;
        //        i && f.setText(i.name),
        t = n.getCurrentImage(),
        t && g(t.Rate);
       
        //n.zoomToObj(4);
        //n.zoomToObj(31);//这里调用起作用 harry zoomToObj
    }
    function l() {   //倍率
        var i = n.getCurrentImage(),
        t = n.getScale();
        i && t && h.setText((i.Rate * t).toFixed(2) + "x")
    }
    function rt() {
        SlideViewerSupport.canvas ? SlideViewerConfig.compactBrowsing() ? e.show() : i.onShowAnnotationToobar && i.onShowAnnotationToobar() : o.show()
    }
    function IniDialog() {
        b = new ImageAdjustmentDialog(n),
        c = new OptionsDialog(n),
        e = new CompactDialog,
        o = new NotSupportedDialog
    }
    function IniToolstrip() {
        var n = new Toolstrip("80%", "left"),
        i,
        l;
        for (t.addToolstrip(n), r = new ToolButton("back", null, ut, null, SlideViewerStrings.getString("Tooltips.BtnBackToBase")), r.hide(), n.addItem(r), y = new ToolButton("home", null, it, null, SlideViewerStrings.getString("Tooltips.BtnHome")), n.addItem(y), i = 0; i < u.length; i++) l = new ToolButton(u[i].toString() + "x", null, tt, {
            obj: u[i]
        }),
        l.hide(),
        s.push(l),
        n.addItem(l);
        n = new Toolstrip("20%", "center"),
        t.addToolstrip(n),
        f = new ToolLabel("", "10%"),
        n.addItem(f),
        h = new ToolLabel("", "90%"),
        n.addItem(h)

        //        SlideViewerConfig.enableImageAdjustment && (v = new ToolButton(null, SlideViewerStrings.getString("Buttons.ImageAdjustment"),
        //        function () {
        //            SlideViewerConfig.compactBrowsing() ? e.show() : SlideViewerSupport.imageAdjustment ? b.show() : o.show()
        //        }), n.addItem(v));
        //        SlideViewerConfig.enableAnnotation && (p = new ToolButton(null, SlideViewerStrings.getString("Buttons.Annotation"), rt, null), n.addItem(p)),
        //        SlideViewerConfig.showOption && (w = new ToolButton(null, SlideViewerStrings.getString("Buttons.Options"),
        //        function () {
        //            c.show();
        //        }), n.addItem(w))
    }
    function IniOpen() {
        n.isOpen() && (a(), l()),
        n.addEventListener("open", a),
        n.addEventListener("animation", l)
    }
    function g(n) {
        for (var t = 0; t < u.length; t++) u[t] > n ? s[t].hide() : s[t].show()
    }
    var t = new Toolbar,
    u = [2, 4, 10, 20, 40],
    s = [],
    r,
    y,
    v,
    p,
    w,
    f,
    h,
    i = this,
    b,
    c,
    e,
    o;
    this.elmt = t.elmt,      //div
    this.onShowAnnotationToobar,
    this.onShowAdjustImage,
    this.onback,
    function () {
        //        IniDialog(),
        IniToolstrip(),
        IniOpen();
    } (),
    this.show = function () {
        t && t.show()
    },
    function SlideSize() {
        i.addControl(new BottomPanel(i).elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT)
    },
    this.hide = function () {
        t && t.hide()
    },
    this.setBackButton = function (n) {
        n ? r.show() : r.hide()
    }
},
AnnotationToolbar = function (n) {
    function i(i) {
        for (var r, e, ti = 0; ti < t.length; ti++) if (r = t[ti], e = r.data == i.data, r.setSelected(e), e) {
            f.hide();
            switch (i.data.type) {
                case "hand":
                    n.getShapeCanvas().setSelectedEnable(!1);
                    break;
                case "select":
                    n.getShapeCanvas().setSelectedEnable(!0);
                    break;
                default:
                    //                    r.data.type == AnnotationType.Polygon && f.show(),
                    //                    n.getShapeCanvas().setDrawAnnotationType(r.data.type)

                    n.showMessage(SlideViewerStrings.getString("Annotations.Draw." + r.data.type));
                    //                    n.getShapeCanvas().setDrawAnnotationType(r.data.type);
                    n.getShapeCanvas().setDrawAnnotationType(eval("AnnotationType." + i.data.type));
            }
        }
    }
    function l() {
        var t = n.getShapeCanvas();
        t.setSelectedEnable(!1),
        o.resetAnnotationButtons(),
        o.onback && o.onback(),
        t.isShapeChanged && n.canWrite() && s.show()
    }
    function c() {
        e = new AnnotationDialog(n),
        s = new AnnotationSaveDialog(n);
    }
    function h() {
        var s = new Toolstrip("150px", "left"),
        h,
        o;
        r.addToolstrip(s),
        h = new ToolLabel(SlideViewerStrings.getString("Labels.AnnotationType")),
        s.addItem(h),
        s = new Toolstrip("60%", "left"),
        r.addToolstrip(s),
        o = new ToolButton("hand", null, i, {
            type: "hand"
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("selectanno", null, i, {
            type: "select"
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("line", null, i, {
            type: AnnotationType.Line,
            text: SlideViewerStrings.getString("Annotations.Draw.Line")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("arrow", null, i, {
            type: AnnotationType.Arrow,
            text: SlideViewerStrings.getString("Annotations.Draw.Arrow")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("rect", null, i, {
            type: AnnotationType.Rectangle,
            text: SlideViewerStrings.getString("Annotations.Draw.Rectangle")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("ellipse", null, i, {
            type: AnnotationType.Ellipse,
            text: SlideViewerStrings.getString("Annotations.Draw.Ellipse")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("angle", null, i, {
            type: AnnotationType.Angle,
            text: SlideViewerStrings.getString("Annotations.Draw.Angle")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("arc", null, i, {
            type: AnnotationType.Arc,
            text: SlideViewerStrings.getString("Annotations.Draw.Arc")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("circle3", null, i, {
            type: AnnotationType.CircleThreePoints,
            text: SlideViewerStrings.getString("Annotations.Draw.CircleThreePoints")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("polygon", null, i, {
            type: AnnotationType.Polygon,
            text: SlideViewerStrings.getString("Annotations.Draw.Polygon")
        }),
        s.addItem(o),
        t.push(o),
        o = new ToolButton("position", null, i, {
            type: AnnotationType.Position,
            text: SlideViewerStrings.getString("Annotations.Draw.Position")
        }),
        s.addItem(o),
        t.push(o),
        s = new Toolstrip("40%", "right"),
        r.addToolstrip(s),
        f = new ToolButton(null, SlideViewerStrings.getString("Buttons.Finish"),
        function () {
            n.getShapeCanvas().finishDrawing()
        }),
        f.hide(),
        s.addItem(f),
        u = new ToolButton(null, SlideViewerStrings.getString("Buttons.Save"),
        function () {
            n.saveAnnotations(),
            u.hide()
        }),
        u.hide(),
        s.addItem(u),
        o = new ToolButton(null, SlideViewerStrings.getString("Buttons.Edit"),
        function () {
            e.show()
        }),
        s.addItem(o),
        o = new ToolButton(null, SlideViewerStrings.getString("Buttons.Delete"),
        function () {
            n.getShapeCanvas().deleteAnnotation()
        }),
        s.addItem(o),
        o = new ToolButton(null, SlideViewerStrings.getString("Buttons.Back"), l),
        s.addItem(o)
    }
    var r = new Toolbar,
    t = [],
    f,
    u,
    o = this,
    e,
    s;
    this.elmt = r.elmt,
    this.onback,
    function () {
        c();
        h();
    } (),
    this.show = function () {
        r && r.show()
    },
    this.hide = function () {
        r && r.hide()
    },
    this.setSaveButton = function (n) {
        n ? u.show() : u.hide()
    },
    this.resetAnnotationButtons = function () {
        for (var n = 0; n < t.length; n++) t[n].setSelected(!1);
        f.hide()
    },
    this.showAnnotationDialog = function () {
        e && e.show()
    }
},
ViewerToolbar = function (n, t) {
    function r() {
        i.tbAnnotation.hide(),
        i.tbMain.hide(),
        i.tbMain.onShowAnnotationToobar = function () {
            i.tbAnnotation.show(),
            i.tbMain.hide()
        },
        n.addEventListener("open",
        function () {
            var t = n.getCurrentImage();
            i.tbMain.setBackButton(t.id >= 0);
            var scale = GetQueryParamValue("scale");
            var x = GetQueryParamValue("x");
            var y = GetQueryParamValue("y");
            var slideid = getQueryString("SlideID");
            if (scale != null && x != null && y != null && mCurrentSlideID == slideid) {
                var s = Number(scale);
                var xx = Number(x);
                var yy = Number(y);
                var mpoint = new SeadragonPoint(xx, yy);
                n.viewport && n.viewport.panTo(mpoint);
                n.zoomToObj(s);
            }

            /*
            */
            var curoffsetx = 0, curoffsety = 0, curscale = 0;
            setInterval(function () {
                if (master == "1" && n && n.viewport) {
                    var f = n.viewport.getZoom(true);
                    var center = n.viewport.getCenter();
                    var Scale = n.getScale() * n.getCurrentImage().Rate;
                    var x = center.x;
                    var y = center.y;
                    if ((Scale != curscale || x != curoffsetx || y != curoffsety)) {
                        SendMsg("syncimage|" + mCurrentSlideID + "|" + Scale + "|" + x + "|" + y);
                    }
                    curscale = Scale;
                    curoffsetx = center.x;
                    curoffsety = center.y;
                }
            }, 100);

        }),
        i.tbMain.onback = function () {
            n.openImage()
        },
        i.tbAnnotation.onback = function () {
            i.tbMain.show(),
            i.tbAnnotation.hide()
        },
        i.elmt.appendChild(i.tbMain.elmt),
        i.elmt.appendChild(i.tbAnnotation.elmt)
    }
    this.elmt = document.getElementById(t); //div tool
    var i = this;
    this.tbMain = new MainToolbar(n), //主要工具栏
    this.tbAnnotation = new AnnotationToolbar(n), //注释工具栏
    function () {
        r()
    } ()
};
var ZoomPanel = function (n) { 
    function i() {
        var u = $.support.touch ? "touchstart" : "click",
        f = $('<a class="zoom-button zoom-button-in zoom-icon-in" title="' + SlideViewerStrings.getString("Tooltips.ZoomIn") + '"><span></span></a>'),
        i;
        f.bind(u,
        function () {
            n.viewport && (n.viewport.zoomBy(t / 1), n.viewport.applyConstraints(), e.stopPropagation && e.stopPropagation());
        }),
        i = $('<a class="zoom-button zoom-button-out zoom-icon-out" title="' + SlideViewerStrings.getString("Tooltips.ZoomOut") + '"><span></span></a>'),
        i.bind(u,
        function () {
            //alert("sign=" + sign);
            n.viewport && (n.viewport.zoomBy(1 / t), n.viewport.applyConstraints(), e.stopPropagation && e.stopPropagation())
        }),
        $(r.elmt).addClass("zoom-panel").append(f).append(i)
    }
    var r = this,
    t;
    this.elmt = document.createElement("div"),
    //t = 2, //modified by harry
    t = 1.5,
    function () {
        i()
    } ()
};
var ZoomBotton = function (n) { //n是SeadragonViewer对象
    function bl() { //这里是显示放大倍数的标签，harry
        var i = n.getCurrentImage(),
        t = n.getScale();
        var currentScale = (i.Rate * t).toFixed(2);
        i && t && $("#xbl").html(currentScale)
        var d = (i.Rate * t).toFixed(2);
        Number(d) > Number(i.Rate) ? $("#xbl").css('color', 'red') : $("#xbl").css('color', 'black');
        //added by harry 
        /*
        if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
        {
        //alert("SendMsg=" + SendMsg);
        SendMsg("zoomto|" + currentScale);
        }
        */
    }
    function a() {
        //        var i = n.getCurrentSlide(),
        t;
        //                i && f.setText(i.name),
        t = n.getCurrentImage(),
        t && g(t.Rate)

    }
    function ScaleBotton(fun, param) {
        u = $.support.touch ? "touchstart" : "click";
        var x = $('<a class="toolbutton" style=" margin-top:-9px"></a>');
        var type = '';
        if (param != "home") {
            type = "x";
        }
        var sp = $('<span class="toolbutton-inner toolbtn-icon-' + param + type + '" ></span>');
        x.append(sp);

        x.bind(u, param, fun)
        return x;
    }

    function gohome() {
        n.viewport && n.viewport.goHome();
        //added by harry 
        /*
        if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
        {
            //alert("SendMsg=" + SendMsg);
            SendMsg("gohome|home");
        }
        */
    }
    function zoomTo(t) {
        n && n.zoomToObj(t.data);
        //added by harry 
        /*
        if (sign && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
        {
            //alert("SendMsg=" + SendMsg);
            var center = n.viewport.getCenter();
            SendMsg("zoomto|" + t.data + "|center#" + center.x + "#" + center.y);
        }
        */
    }
    var NavBar = document.createElement("div");
    $(NavBar).addClass("NavBar_zoomControlContainer");



    var NavBar_zoom = document.createElement("div");
    $(NavBar_zoom).addClass("NavBar_zoomDrop");
    $(NavBar_zoom).css('position', 'absolute');
    $(NavBar_zoom).css('display', 'block');

    var home = ScaleBotton(gohome, 'home');
    var Scale2 = ScaleBotton(zoomTo, '2');
    var Scale4 = ScaleBotton(zoomTo, '4');
    var Scale10 = ScaleBotton(zoomTo, '10');
    var Scale20 = ScaleBotton(zoomTo, '20');
    var Scale40 = ScaleBotton(zoomTo, '40');
    var spp = $('<div  id="xbl" href="#" style="font-size:14px;margin-top:10px;font-weight:bold;text-align:center;border: 1px dashed blue;" >0.00</div>');
    $(NavBar_zoom).append(spp);
    $(NavBar_zoom).append(home);
    $(NavBar_zoom).append(Scale2);
    $(NavBar_zoom).append(Scale4);
    $(NavBar_zoom).append(Scale10);
    $(NavBar_zoom).append(Scale20);
    $(NavBar_zoom).append(Scale40);
    $(NavBar).append(NavBar_zoom);

    var r = this;
    var t;
    //var xt = 2; //modified by harry
    var xt = 1.5;
    this.elmt = document.createElement("div");
    $(r.elmt).css("position", "absolute");
    $(r.elmt).css("top", "5px");
    $(r.elmt).css("right", "0px");

    u = $.support.touch ? "touchstart" : "click";

    //加号和减号两个缩放按钮 harry
    var zoomIn = $('<a  class="NavBar_button NavBar_toolButton NavBar_zoomIn" href="#" uici="NB.ZC.ZoomIn"></a>');
    zoomIn.bind(u, function () {
       n.viewport && (n.viewport.zoomBy(xt / 1), n.viewport.applyConstraints())

        /*
        alert(document.getElementById("xbl").innerHTML);
        var curzoom = Number($("#xbl").text());
        curzoom = curzoom + xt;
        if (curzoom > 40)
            curzoom = 40;
        n && n.zoomToObj(curzoom);
        if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
        {
        var center = n.viewport.getCenter();
        //SendMsg("plus|" + xt / 1);
        SendMsg("plus|" + curzoom + "|center#" + center.x + "#" + center.y);
        }
        */
    })
    var zoomOut = $('<a  class="NavBar_button NavBar_toolButton NavBar_zoomOut" href="#" uici="NB.ZC.ZoomOut"></a>');
    zoomOut.bind(u, function () {
        n.viewport && (n.viewport.zoomBy(1 / xt), n.viewport.applyConstraints())
        /*
        var curzoom = Number($("#xbl").text());
        var newzoom = curzoom - xt;
        if (newzoom < 0)
            newzoom = curzoom;
        n && n.zoomToObj(newzoom);
        if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
        {
            //alert("SendMsg=" + SendMsg);
            //SendMsg("plus|" + 1 / xt); //minus
            var center = n.viewport.getCenter();
            SendMsg("plus|" + newzoom + "|center#" + center.x + "#" + center.y);
        }
        */
    })
    var umove = $.support.touch ? "touchmove" : "mousemove";
    zoomIn.bind(umove, function () {

        $(".NavBar_zoomDrop").css("display", "block");
    })
    zoomOut.bind(umove, function () {

        $(".NavBar_zoomDrop").css("display", "block");
    })
    $(NavBar).append(zoomIn);

    $(NavBar).append(zoomOut);


    $(r.elmt).append(NavBar),
     function () {
         n.isOpen() && bl(),
        n.addEventListener("open", a),
        n.addEventListener("animation", bl)
     } ()
}

var NavBotton = function (n) {
    var u = $.support.touch ? "touchstart" : "click",
        f = $('<span><img id="navimg" src="assets/images/navshow.png" width="20px" style="cursor:pointer" ></span>');
    f.bind(u,
        function () {
            e = n.getNavMap();
            if ($(e.elmt).css("display") == "block") {
                e.setVisibility(0);
                $("#navimg").attr("src", "assets/images/navhidden.png");
            }
            else {
                $("#navimg").attr("src", "assets/images/navshow.png");
                e.setVisibility(!0);
            };
        });
    var r = this;
    this.elmt = document.createElement("div");
    $(r.elmt).css("position", "absolute");
    $(r.elmt).css("top", "2px");
    $(r.elmt).css("left", "0px");

    $(r.elmt).append(f);

}
var BottomPanel = function (n) {
    function i() {
        var u = $.support.touch ? "touchstart" : "click",
        f = $('<a ><span><img src="assets/images/Nav.png"></span></a>');
        f.bind(u,
        function () {
            e = n.getNavMap();
            if ($(e.elmt).css("display") == "block") {
                e.setVisibility(0);
            }
            else {
                e.setVisibility(!0);
            };
        });
        SlideSize = $('<div style="position:absolute;right:5px;bottom:7px"><img style="width:80px;height:82px;" src="image/bk_1.png" /><label id="bl"></label></div>');
        //        SlideSize = $('<input type="text" id="bl" readonly="readonly" />');
        SlideSize.bind("mouseover", function () {
            allx.style.display = "block";
            $("#myCanvas").show();
        });
        if (isMobile() == true) {
            SlideSize.bind(u, function () {
                if (allx.style.display == "none") {
                    allx.style.display = "block";
                    $("#myCanvas").show();
                }
                else {
                    allx.style.display = "none";
                    $("#myCanvas").hide();
                }
            });
        }
        allx = document.createElement("div");

        allx.style.position = "absolute";
        allx.style.display = "none";
        allx.id = "ysbl";
        var o;
        o = new multiple(tt, blu[0]);
        $(allx).append(o);
        o = new multiple(tt, blu[1]);
        $(allx).append(o);
        o = new multiple(tt, blu[2]);
        $(allx).append(o);
        o = new multiple(tt, blu[3]);
        $(allx).append(o);
        o = new multiple(tt, blu[4]);
        $(allx).append(o);
        o = new multiple(tt, blu[5]);
        $(allx).append(o);
        $(r.elmt).append(SlideSize, allx);
        multiple = "hide";
    }
    function multiple(fun, arry) {
        var isIE6 = !!window.ActiveXObject && !window.XMLHttpRequest;
        var x, image, right, bottom, u = $.support.touch ? "touchstart" : "click";
        if (isIE6 == true) {    //IE6 true 
            arry == "40" ? (image = "assets/image/bei4040.png", right = "150px", bottom = "0px") : arry == "20" ? (image = "assets/image/bei2020.png", right = "155px", bottom = "55px") : arry == "10" ? (image = "image/bei1010.png", right = "140px", bottom = "105px") : arry == "4" ? (image = "assets/image/bei444.png", right = "95px", bottom = "135px") : arry == "2" ? (image = "assets/image/bei222.png", right = "45px", bottom = "145px") : (image = "assets/image/bei111.png", right = "-5px", bottom = "125px");
            x = $('<a class="multipleHide"><span><img src="' + image + '" style="right:' + right + ';bottom:' + bottom + '" class="multiple"></span></a>');
        }
        else {
            arry == "40" ? (image = "assets/image/bei40.png", right = "150px", bottom = "0px") : arry == "20" ? (image = "assets/image/bei20.png", right = "155px", bottom = "55px") : arry == "10" ? (image = "image/bei10.png", right = "140px", bottom = "105px") : arry == "4" ? (image = "assets/image/bei4.png", right = "95px", bottom = "135px") : arry == "2" ? (image = "image/bei2.png", right = "45px", bottom = "145px") : (image = "assets/image/bei1.png", right = "-5px", bottom = "125px");
            x = $('<a class="multipleHide"><span><img src="' + image + '" style="right:' + right + ';bottom:' + bottom + '" class="multiple"></span></a>');
        }
        fun & x.bind(u, arry, fun)
        return x;
    }
    function bl() {
        var i = n.getCurrentImage(),
        t = n.getScale();
        i && t && $("#bl").html((i.Rate * t).toFixed(2) + "X")
        var d = (i.Rate * t).toFixed(2);
        Number(d) > Number(i.Rate) ? $("#bl").css('color', 'red') : $("#bl").css('color', 'black');
    }
    function a() {
        //        var i = n.getCurrentSlide(),
        t;
        //                i && f.setText(i.name),
        t = n.getCurrentImage(),
        t && g(t.Rate)
    }
    function tt(t) {
        n && n.zoomToObj(t.data)
    }
    function imageOp() {
        n.isOpen() && bl(),
        n.addEventListener("open", a),
        n.addEventListener("animation", bl)
    }
    var blu = [40, 20, 10, 4, 2, 1];
    var r = this, e;
    this.elmt = document.createElement("div"),
     canvas = $('<canvas id="myCanvas"  style="display:none;width:400px;height:200px;position:absolute;bottom:-10px;right:0px;border-color:#3A5FCD"></canvas>');
    $(r.elmt).append(canvas),
    function () {
        i()
        imageOp()
    } ()
};
var AnnotationMenu = function (SeaViewer) {
    function it(i) {
        for (var r, e, u = 0; u < t.length; u++) if (r = t[u], e = r.data == i.data, e) {
            $(ul).hide();
            $(oul).hide();
            switch (i.data.type) {
                case "hand":
                    SeaViewer.getShapeCanvas().setSelectedEnable(!1);
                    break;
                case "select":
                    SeaViewer.getShapeCanvas().setSelectedEnable(!0);
                    break;
                default:
                    SeaViewer.getShapeCanvas().setSelectedEnable(!0);
                    //SeaViewer.showMessage(SlideViewerStrings.getString("Annotations.Draw." + r.data.type));
                    SeaViewer.getShapeCanvas().setDrawAnnotationType(eval("AnnotationType." + i.data.type));
            }
        }
    }

    show = function () {
        var o;
        //        o = new LiButton("select", null, it, {
        //            type: "select",
        //            text: "选择"
        //        }, "select")
        //        t.push(o);
        if (isIElast()) {
            o = new LiButton("Line", null, it, {
                type: AnnotationType.Line,
                text: SlideViewerStrings.getString("Annotations.Draw.Line")
            }, "zx")
            t.push(o);
            o = new LiButton("Arrow", null, it, {
                type: AnnotationType.Arrow,
                text: SlideViewerStrings.getString("Annotations.Draw.Arrow")
            }, "jt")
            t.push(o);
            o = new LiButton("Rectangle", null, it, {
                type: AnnotationType.Rectangle,
                text: SlideViewerStrings.getString("Annotations.Draw.Rectangle")
            }, "jx")
            t.push(o);
            o = new LiButton("Ellipse", null, it, {
                type: AnnotationType.Ellipse,
                text: SlideViewerStrings.getString("Annotations.Draw.Ellipse")
            }, "ty")
            t.push(o);
            o = new LiButton("Curve", null, it, {
                type: AnnotationType.Curve,
                text: SlideViewerStrings.getString("Annotations.Draw.Curve")
            }, "pen")
            t.push(o);
            o = new LiButton("Position", null, it, {
                type: AnnotationType.Position,
                text: SlideViewerStrings.getString("Annotations.Draw.Position")
            }, "pin")
            t.push(o);
            o = new LiButton("Arrow", null, it, {
                type: AnnotationType.Arrow,
                text: SlideViewerStrings.getString("Annotations.Draw.Arrow")
            }, "jt")
            t.push(o);
            o = new LiButton(null, null, null, null, null)
            //編輯  注释管理
            if (isIElast()) {
                new LiButton("Edit", null, ShowEdit, {
                    text: SlideViewerStrings.getString("MainMenu.AnnotationOption")
                }, "edit");
            }
            //圖像信息
            new LiButton("ImageInfo", null, info, {
                text: SlideViewerStrings.getString("MainMenu.ImageInfo")
            }, "ImageInfo");
        }

        //調節圖像
        //        o = new LiButton("ImageAdjust", null, imageAdjust, {
        //            text: SlideViewerStrings.getString("ImageAdjustments.Title")
        //        }, "adjust");
        //                if (getQueryString("CanScreenShot") != "0") {
        //                    o = new LiButton("Screenshot", null, SaveImg, {
        //                        text: SlideViewerStrings.getString("MainMenu.ScreenShot")
        //                    }, "jt1")
        //                    o = new LiButton("Screenshot", null, ShotShow, {
        //                        text: SlideViewerStrings.getString("MainMenu.ShotList")
        //                    }, "jtlb")
        //                }
        //        if (isIElast()) {
        //            o = new LiButton(null, null, null, null, null)
        //        }
        o = new LiButton("other", null, ii, {
            text: SlideViewerStrings.getString("MainMenu.Others")
        }, "other")

        //        關於
        //                o = new LiButton("about", null, ShowVer, {
        //                    text: SlideViewerStrings.getString("MainMenu.Abouts")
        //                }, "about")
        //导航图
        new LiButton("NavMap", "other", NavMap, {
            text: SlideViewerStrings.getString("MainMenu.NavMap")
        }, "nav");

        //
        //        new LiButton("Tag", "other", Label, {
        //            text: SlideViewerStrings.getString("MainMenu.Tag")
        //        }, "label");
        /*
        new LiButton("Ruler", "other", Ruler, {
        text: SlideViewerStrings.getString("MainMenu.Ruler")
        }, "rule");
        */
        //        new LiButton("CaseInfo", "other", scase, {
        //            text: SlideViewerStrings.getString("MainMenu.CaseInfo")
        //        }, "caseinfo");

        new LiButton("ZEdit", "right", ShowEdit, {
            text: SlideViewerStrings.getString("Buttons.Edit")
        }, "Edit");
        new LiButton("Clear", "right", delAnnotation, {
            text: SlideViewerStrings.getString("Buttons.Delete")
        }, "sc");
        $(div.elmt).append(ul, oul, rul);

    };
    function IniDialog() {
        //        b = new ImageAdjustmentDialog(SeaViewer);
        slideinfo = new SlideInfo(SeaViewer);
        annotation = new AnnotationOption(SeaViewer);
        slidecase = new SlideCase(SeaViewer);
        //ShotList = new ShotList(SeaViewer);
        demo = new Demo(SeaViewer);
        ver = new WebVersion(SeaViewer);

    }
    SeaI = SeaViewer;
    var b, slideinfo, annotation, slidecase, demo, rul, ver;
    var div = this, e, s,
    t = [];
    this.elmt = document.createElement("div"),
    this.elmt.id = "MSlide",
ul = document.createElement("ul"),
    oul = document.createElement("ul"),
    rul = document.createElement("ul"),
    rul.id = "RightUl"
    ul.id = "MainUl",
    oul.id = "OtherUl",
    function () {
        show();
        //        otherDiv();
        IniDialog();
    } ();
    $(rul).addClass("dropdown-menu");
    $(ul).addClass("dropdown-menu");
    $(oul).addClass("dropdown-menu");
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return unescape(r[2]);
        return null;
    }
    function imageAdjust() {
        s
        demo.show(),
      hide();
    }
    function delAnnotation() {
        var u = SeaViewer.getShapeCanvas();
        u.deleteAnnotation();
        hide();

    }
    function ShowVer() {
        ver.show();
        hide();
    }
    function SaveImg() {
        showLoading();
        var CurrentImage = SeaViewer.getCurrentImage();
        var WindowHeight = document.body.clientHeight;
        var WindowWidth = document.body.clientWidth;
        var n = SeaViewer.getScale();
        var Nav = SeaViewer.getNav();
        var NavWidth = Nav.Width;
        var NavHeight = Nav.Height;
        var rect = SeaViewer.getRectPoint();
        var Xzoom = (CurrentImage.Rate * n).toFixed(2);
        var rectX = (((CurrentImage.Width / CurrentImage.Rate) * Xzoom) / NavWidth) * rect.topX;
        var rectY = (((CurrentImage.Height / CurrentImage.Rate) * Xzoom) / NavHeight) * rect.topY;

        var WebServerPath;
        var host = window.location.host;
        var ProxyIP = getQueryString("ProxyIP");


        if (ProxyIP != "")
            ProxyIP = "&ProxyIP=" + ProxyIP;
        WebServerPath = "CaptureImgHandler.ashx";
        var data = "CaseNo=" + CurrentImage.CaseNo + "&Left=" + rectX + "&Top=" + rectY + "&Width=" + CurrentImage.Width + "&Height=" + CurrentImage.Height + "&ViewWidth=" + WindowWidth + "&ViewHeight=" + WindowHeight + ""
        + "&scale=" + Xzoom + "&SlideID=" + CurrentImage.ID + "&Slidezoom=" + CurrentImage.Rate + "&TileSize=" + CurrentImage.TileSize + "&slidepath=" + CurrentImage.DigitalSlidePath + ProxyIP;
        $.ajax({
            type: "POST",
            url: WebServerPath,
            data: data,
            cache: false,
            //            contentType: 'text/xml; charset="utf-8"',
            dataType: 'text',
            success: function (v) {
                Ajax(CurrentImage);
                hideLoading();
            }
            //complete: Ajax(CurrentImage)
        });
        hide();
    }


    function saveImg() {
        showLoading();
        var CurrentImage = SeaViewer.getCurrentImage();
        var WindowHeight = document.body.clientHeight;
        var WindowWidth = document.body.clientWidth;
        var n = SeaViewer.getScale();
        var Nav = SeaViewer.getNav();
        var NavWidth = Nav.Width;
        var NavHeight = Nav.Height;
        var rect = SeaViewer.getRectPoint();
        var Xzoom = (CurrentImage.Rate * n).toFixed(2);
        var rectX = (((CurrentImage.Width / CurrentImage.Rate) * Xzoom) / NavWidth) * rect.topX;
        var rectY = (((CurrentImage.Height / CurrentImage.Rate) * Xzoom) / NavHeight) * rect.topY;
        var WebServerPath;
        //var host = window.location.host;
        //var herf = window.location.href;
        var host = "192.168.1.104/qiepian";
        var herf = "192.168.1.104/qiepian";
        var url = herf.split('/')
        //WebServerPath = "http://" + host + "/Viewer/WebService.asmx";
        WebServerPath = "http://" + host + "/Viewer/WebService.ashx";
        var u = [WebServerPath, "?op=ScreenShot"].join("");
        var para = '<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'
             + '<soap:Body>'
             + '<ScreenShot xmlns="http://tempuri.org/">'
             + '<Address>' + CurrentImage.SlideAddress + '</Address>'
             + '<ConsultID>' + getQueryString("ConsultID") + '</ConsultID>'
             + '<Left>' + rectX + '</Left>'
             + '<Top>' + rectY + '</Top>'
             + '<Width>' + CurrentImage.Width + '</Width>'
             + '<Height>' + CurrentImage.Height + '</Height>'
             + '<ViewWidth>' + WindowWidth + '</ViewWidth>'
             + '<ViewHeight>' + WindowHeight + '</ViewHeight>'
             + '<scale>' + Xzoom + '</scale>'
             + '<Slide_ID>' + CurrentImage.ID + '</Slide_ID>'
             + '<remark>' + 1 + '</remark>'
             + '<X_left>' + 1 + '</X_left>'
             + '<X_top>' + 1 + '</X_top>'
             + '<Name>' + 1 + '</Name>'
             + '<Uid>' + CurrentImage.UserID + '</Uid>'
             + '<Xzoom>' + CurrentImage.Rate + '</Xzoom>'
             + '<TileSize>' + CurrentImage.TileSize + '</TileSize>'
             + '</ScreenShot>'
             + '</soap:Body>'
             + '</soap:Envelope>';
        $.ajax({
            type: "POST",
            url: u,
            data: para,
            cache: false,
            contentType: 'text/xml; charset="utf-8"',
            dataType: 'xml',
            complete: ShotShow
        });
        hide()
        //        var mycanvas = document.getElementById("slide");
        //                var data = mycanvas.toDataRUL("image/png");
        //                var w = window.open('about:blank', 'image from canvas');
        //                w.document.write("<img src='" +data + "' alt='from canvas'/>");
        //                var b64 = data.substring(22);
        //                $.post("Save.aspx", { data: b64, name: 'XXXXX' }, function () {
        //                    alert("1");
        //                });
        //        var image = mycanvas.toDataURL("image/png");
    }


    function Delete() {

    }
    function Close() {
        var canvas = document.getElementById("drawCanvas");
        var context = canvas.getContext("2d");
        context.clear();
    }
    function ShotShow() {
        ShotList.show();
        hide();
        hideLoading();
    }
    function ii() {
        $(oul).show();
    }
    function Ruler() {
        $("#slideRuler").toggle();
        document.getElementById("slideRuler").style.display == "none" ? SlideViewerConfig.showRuler = !1 : SlideViewerConfig.showRuler = !0;
        hide()
    }
    function ShowEdit() {
        annotation.showEdit();
        hide();
    }
    function NavMap() {
        e = SeaViewer.getNavMap();
        if ($(e.elmt).css("display") == "block") {
            e.setVisibility(0);
        }
        else {
            e.setVisibility(!0);
        };
        hide()
    }
    function Option() {
        annotation.show();
        hide()
    }
    function info() {
        slideinfo.show();
        slideinfo.text();
        hide()
    }
    function scase() {
        slidecase.show();
        hide()
    }
    function hide() {
        $(ul).hide();
        $(oul).hide();
        $(rul).hide();
    }
    function Label() {
        if ($("#label").css("display") == "block") {
            $("#label").hide();
        } else {
            //            var url, r;
            //            r = SeaViewer.getCurrentImage();
            //            url = "../LabelHandler.ashx?ID=" + r.ID;
            //            $("#labelImgnone").attr('id') == "labelImgnone" ? ($("#labelImgnone").attr('src', url), $("#labelImgnone").attr('id', 'labelImg')) : !0;
            $("#label").show();
        };
        $(oul).hide();
        $(ul).hide();
    }


    function LiButton(name, t, fun, data, img) {
        function event() {
            fun ? $(li).bind(u, data, fun) : !0;
            if (isIElast()) {
                url = "assets/image/" + img + ".png";
                sj = "assets/image/sj.png";
            }
            else {
                url = "assets/image/" + img + ".gif";
                sj = "assets/image/sj.gif";
            }
            t ? t == "right" ? ($(li).append("<img src='" + url + "' style='width:35px;height:35px'><a tabindex='-1'>" + data.text + "</a>"), $(rul).append(li)) : ($(li).append("<img src='" + url + "' style='width:35px;height:35px'><a tabindex='-1'>" + data.text + "</a>"), $(oul).append(li)) : name ? name == "other" ? ($(li).append("<img src='" + sj + "' style='float:right'><img src='" + url + "' style='width:35px;height:35px;'><a tabindex='-1' >" + data.text + "</a>"), $(ul).append(li)) : ($(li).append("<img  src='" + url + "' style='width:35px;height:35px;'><a tabindex='-1'>" + data.text + "</a>"), $(ul).append(li), $(li).bind("mouseover", isHide)) : ($(li).addClass("divider"), $(ul).append(li));

        }
        function isHide() {
            $(oul).hide();
        }
        li = document.createElement("li");
        var url, sj;
        if (name == "other") {
            u = "mouseover";
        }
        else {
            u = $.support.touch ? "touchstart" : "click";
        }
        this.data = data,
        function () {
            if (img == "zx")
                $("#img_zx").bind(u, data, fun)
            if (img == "jx")
                $("#img_jx").bind(u, data, fun)
            if (img == "jt")
                $("#img_jt").bind(u, data, fun)
            if (img == "ty")
                $("#img_ty").bind(u, data, fun)
            if (img == "pen")
                $("#img_pen").bind(u, data, fun)
            if (img == "pin")
                $("#img_pin").bind(u, data, fun)
            if (img == "adjust")
            //调节图像
                $("#img_process").bind(u, data, fun)
            if (img == "ImageInfo")

                $("#img_info").bind(u, data, fun)
            if (img == "sc") {
                $("#btn_delete").bind(u, data, fun)
            }
            if (img == "Edit")
                $("#btn_edit").bind(u, data, fun)

            event();
        } ();
    };
};
//var SlideRuler = function (SeaViewer) {
//    var ruler = this
//    this.elmt = document.createElement("div");
//    ruler.elmt.style.position = "absolute"
//    div = $("<div id='slideRuler'  style='position:absolute;left:60px;bottom:20px;display:none;border:0;background-color:black;height:5px;color:black;line-height:5px;z-index:1111'></div>")
//    $(ruler.elmt).append(div);
//};
var SlideRuler = function (SeaViewer) {
    var ruler = this
    this.elmt = document.createElement("div");
    ruler.elmt.style.position = "absolute";
    isIElast() ? div = $("<div id='slideRuler'  style='position:absolute;left:20px;bottom:20px;display:inline'><hr  style='border:0;background-color:black;height:5px;color:black;'/><div  id='rulerHeight1' style='left: 0px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label   style='position: absolute;top:10px;color:black'>0</label></div><div id='rulerHeight2' style='left: 70px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label  id='rulerNum1' style='position: absolute;top:10px;color:black'>1</label></div><div id='rulerHeight3' style='left: 135px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label id='rulerNum2' style='position: absolute;top:10px;color:black'>2</label></div><div id='rulerHeight4' style='left: 200px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label id='rulerNum3' style='position: absolute;top:10px;color:black'>3</label></div><div id='rulerHeight5' style='left: 265px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label id='rulerNum4' style='position: absolute;top:10px;color:black'>4</label></div><div id='rulerHeight6' style='left: 325px; width: 5px; height: 15px; bottom: 6px; position: absolute; background-color: black;'><label id='rulerNum5' style='position: absolute;top:10px;color:black'>5</label></div></div>") :
    div = $("<div id='slideRuler'  style='position:absolute;left:60px;bottom:20px;display:inline'><hr  style='border:0;background-color:black;height:5px;color:black'/><div  id='rulerHeight1' style='left: 0px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label   style='position: absolute;top:15px;left:-2px'>0</label></div><div id='rulerHeight2' style='left: 70px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label  id='rulerNum1' style='position: absolute;top:15px;left:-2px'>1</label></div><div id='rulerHeight3' style='left: 135px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label id='rulerNum2' style='position: absolute;top:15px;left:-2px'>2</label></div><div id='rulerHeight4' style='left: 200px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label id='rulerNum3' style='position: absolute;top:15px;left:-2px'>3</label></div><div id='rulerHeight5' style='left: 265px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label id='rulerNum4' style='position: absolute;top:15px;left:-2px'>4</label></div><div id='rulerHeight6' style='left: 325px; width: 5px; height: 15px; bottom: 14px; position: absolute; background-color: black;'><label id='rulerNum5' style='position: absolute;top:15px;left:-2px'>5</label></div></div>")
    $(ruler.elmt).append(div);
};
var SlideTag = function (SeaViewer) {
    var host = window.location.host;
    var herf = window.location.href;
    var file = herf.split('/')
    var id = getQueryString("SlideID");
    var rdiv = this;
    this.elmt = document.createElement("div");
    var adiv = document.createElement("div"), tag, url, r;
    adiv.style.display = "block";
    adiv.style.position = "absolute";
    adiv.id = "label"
    //url = "http://" + host + "/K-RMCS.SlideViewer/Viewer/LabelHandler.ashx?ID=" + id;   //url
    adiv.style.left = "25px"; adiv.style.top = "25px";
    tag = $('<a><span><img id=\"labelImage\"  alt=""  style="width:180px;height:180px"/></span></a>');
    $(adiv).append(tag);
    $(rdiv.elmt).append(adiv);
};
var MainButton = function (seaViewer) {
    function i() {
        var u = $.support.touch ? "touchstart" : "click",
        f = $('<a class="zoom-button toolbtn-icon-in toolbtn-icon-menu" title="菜单"><span></span></a>'),
        i;
        f.bind(u,
        function () {
            var ul = document.getElementById("MainUl"), oul = document.getElementById("OtherUl");
            $("#MainUl").toggle();
            ul.style.left = (w * 0.75) + "px"; ul.style.top = (h * 0.75) + "px";

        }),
        $(r.elmt).addClass("panel-menu").append(f)
    }
    var r = this,
    t, h = document.body.clientHeight, w = document.body.clientWidth;
    this.elmt = document.createElement("div"),
    function () {
        i()
    } ()
};

function SaveImgs() {
    SeaViewer = SeaI;
    showLoading();
    /*
    alert("center.x=" + center.x);
    alert("center.y="+center.y);
    var ContainerSize = SeaViewer.viewport.getContainerSize()//当前视图的宽度和高度
    alert("ContainerSize.x=" + ContainerSize.x);
    alert("ContainerSize.y=" + ContainerSize.y);
    var getZoom = SeaViewer.viewport.getZoom()
    alert("getZoom=" + getZoom);
    */
    var center = SeaViewer.viewport.getCenter();
    var centerX = "&centerx=" + center.x;
    var centerY = "&centery=" + center.y;
    var CurrentImage = SeaViewer.getCurrentImage();
    var WindowHeight = document.body.clientHeight;//屏幕的宽度
    var WindowWidth = document.body.clientWidth; //屏幕的高度
    var n = SeaViewer.getScale(); //0.05, 0.1, 0.25, 0.5, 1
    var Nav = SeaViewer.getNav();
    var NavWidth = Nav.Width; //导航图的宽度
    var NavHeight = (NavWidth * CurrentImage.Height) / CurrentImage.Width; //  Nav.Height; //导航图的高度, modified by harry at 2015-12-18 解决截图误差的问题
    //var NavHeight = Nav.Height; //导航图的高度, modified by harry at 2015-12-18 解决截图误差的问题

    var rect = SeaViewer.getRectPoint(); //导航图中缩放框的左上角坐标
    /* rectX除以200后，和silverlight的值相当
    alert("rectX=" + rect.topX);
    alert("rectY=" + rect.topY);
    */

    //CurrentImage.Rate 图像的扫描倍数，20，40
    var Xzoom = (CurrentImage.Rate * n).toFixed(2);//当前的放大倍数
    //Xzoom：在切片浏览器上看到的放大倍数

    //rectX和rectY表示导航图中缩放框左上角的位置在实际的原图中的坐标
    //var rectY = (((CurrentImage.Height / CurrentImage.Rate) * Xzoom) / NavHeight) * (rect.topY - 0.38);//与Silverlight相当
    var rectX = (((CurrentImage.Width / CurrentImage.Rate) * Xzoom) / NavWidth) * (rect.topX);
    var rectY = (((CurrentImage.Height / CurrentImage.Rate) * Xzoom) / NavHeight) * (rect.topY);
    var WebServerPath;
    var host = window.location.host;
    var level = "&level=" + mCurrentLevel;
    var zjslideid = "";
    if (getQueryString("zjslideid"))
        zjslideid = "&zjslideid=" + getQueryString("zjslideid");
    var ViewportOrigin = "&viewportX=" + ((rect.topX / 200) + 0.0019) + "&viewportY=" + (rect.topY / 200);
    WebServerPath = WebServerUrl + "CaptureImgHandler.ashx";
    var data = "CaseNo=" + CurrentImage.CaseNo + "&Left=" + rectX + "&Top=" + rectY + "&Width=" + CurrentImage.Width + "&Height=" + CurrentImage.Height + "&ViewWidth=" + WindowWidth + "&ViewHeight=" + WindowHeight + ""
        + "&scale=" + Xzoom + "&SlideID=" + CurrentImage.ID + "&Slidezoom=" + CurrentImage.Rate + "&TileSize=" + CurrentImage.TileSize + "&slidepath=" + CurrentImage.DigitalSlidePath + ViewportOrigin + level + centerX + centerY + zjslideid;
    $.ajax({
        type: "POST",
        url: WebServerPath,
        data: data,
        cache: false,
        dataType: 'text',
        success: function (v) {
            Ajax(CurrentImage);//加载截图列表
            hideLoading();
        }
        //complete: Ajax(CurrentImage)
    });
}

function Ajax(a) {

    var CaseNo;
    var ShotListPath = WebServerUrl + "ShotListHandler.ashx";
    if (a.CaseNo != null) {
        CaseNo = a.CaseNo;
    }
    else {
        CaseNo = getQueryString("caseno");
    }
    var zjslideid = "";
    if (getQueryString("zjslideid"))
        zjslideid = "&zjslideid=" + getQueryString("zjslideid");
    var div = "";
    ShotListPath = ShotListPath + '?CaseNo=' + CaseNo + zjslideid;
    $.ajax({
        url: ShotListPath,
        dataType: 'text',
        type: 'POST',
        data: '', //'CaseNo=' + CaseNo + zjslideid
        success: function (v) {
            $("#newshot").html("");
            var ShotPath = "";
            var Path = v.split("#");
            for (var i = 0; i < Path.length; i++) {
                if (Path[i] != "" && Path[i] != undefined) {
                    var ShotItemArr = Path[i].split('|');
                    var idx = ShotItemArr[0].indexOf('http://');
                    if (idx > -1)
                        ShotPath = ShotItemArr[0] + "?id=" + Math.random(0, 9999);
                    else
                        ShotPath = WebServerShotUrl + ShotItemArr[0] + "?id=" + Math.random(0, 9999);

                    div += "<div style=\"width:60px;height:50px;float:left;margin:2px\" ><div  style=\"position: absolute;\"><img alt='" + ShotItemArr[1] + "' src=\"" + ShotPath + "\"  style=\"width:60px;height:50px;\"></div>";
                    if (getQueryString("CanScreenShot") == 1) {
                        div += "<div style=\"position: absolute;cursor:pointer; margin-left:40px\" title=\"删除\"><img src=\"assets/image/shotdelete.png\" width=\"20px\"  onclick=\"DelAjax('" + ShotItemArr[2] + "','" + ShotItemArr[0] + "')\"/></div>";
                        div += "<div style=\"position: absolute;cursor:pointer; margin-left:40px; margin-top:30px\" title=\"定位('"  + ShotItemArr[5] + "','" + ShotItemArr[6] + "','" + ShotItemArr[7] + "')\"><img src=\"assets/image/shotlocation.png\" height=\"20px\" width=\"20px\"  onclick=\"ShotScreenLocation('" + ShotItemArr[4] + "','" + ShotItemArr[5] + "','" + ShotItemArr[6] + "','" + ShotItemArr[7] + "')\"/></div>";
                        
                    }
                    div += "<div style=\"position: absolute;font-weight:bold\">" + (i + 1) + "</div>";
                    div += "</div>";
                }

            }

            if (Path == "") {

                div += "<div style=\"margin-top:40px; margin-left:25px\">无截图</div>";

            }
            //$("#ShotLists")[0].innerHTML = div;

            $("#newshot").html(div);
        }
    });
}

function DelAjax(a, s) {
    var deleteurl = WebServerUrl + "DeleteShotHandler.ashx?sysid=" + a + "&imgurl=" + s;
    $.ajax({
        url: deleteurl,
        dataType: 'text',
        type: 'POST',
        success: function (v) {
            Ajax(v);
        }
    });
}

function ShotScreenLocation(id,scale,x,y) {
    if (scale != null && x != null && y != null) {
        GotoSlide(id);
        var s = Number(scale);
        var xx = Number(x);
        var yy = Number(y);
        if (xx > 0 && yy > 0) {

            var timerLocation = setInterval(function () {
                if(viewer.viewport!=null){
                    var mpoint = new SeadragonPoint(xx, yy);
                    viewer.viewport && viewer.viewport.panTo(mpoint);
                    viewer.viewport && viewer.zoomToObj(s);
                    clearInterval(timerLocation);
                }
            }, 20); 

            
        }
    }
}

var ShotLists = function (seaViewer) {
    function i2() {
        div += "<div id=\"ShotLists\" style=\"position:absolute;left:10px;bottom:280px;width:300px;height:250px;max-height:250px;overflow:auto;overflow-y:auto;-webkit-overflow-y:auto;-webkit-overflow-scrolling:touch;border:2px solid #D7D2D2;/*background-color:white*/\">"
        div += "</div>";
        //div += "<span style=\"position:absolute;bottom:500px;left 5px;width:75px\">截图列表</span>";
        div += "<img id=\"jtlb\" src=\"image/jtlbss.png\" style=\"position:absolute;bottom:490px;left:-10px;width:75px\">";
        div += "<div id=\"shot\" style=\"position:absolute;left:310px;bottom:280px;background:white;border:2px solid #D7D2D2;border-left-width:0px\" onmouseover=\"MoveOver(this)\"  onmouseout=\"MoveOut(this)\" onclick=\"ck(this)\" ><img id=\"ShotImg\" style=\"width:21px;height:246px\" src=\"img/la_no.png\" /></div>"
        $(r.elmt).append(div);
        Ajax(seaViewer);
    }
    function i() {
        //        var div = '<div style="position:absolute;left:0px;bottom:2px;border:min-width:0px;max-width:140px;height:100px;">'
        //        + '<div id="ShotLists" style="position:absolute;height:100px;min-width:122px;max-width:140px;background:white;overflow-y:hidden;-webkit-overflow-y:hidden;border: 1px solid rgb(49, 157, 206)"> </div> '
        //        + '<div id=\"shot\" style="border: 1px solid rgb(49, 157, 206);position:absolute; margin-left:120px"  onclick=\"ShowShotImg(this)\" ><img id=\"ShotImg\" src=\"img/la_no.png\" style="height:100px" /></div>'
        //        + '<div  style="position:absolute;width:20px; height:20px;cursor: pointer;margin-left:120px" title="上" onclick="scrollup()" id="divscrollup" ></div>'
        //        + '<div  style="position:absolute; margin-top:80px;width:20px; height:20px;cursor: pointer;margin-left:120px" title="下" onclick="scrolldown()" id="divscrolldown" >'
        //        + '</div><div>';
        //        $(r.elmt).append(div);
        Ajax(seaViewer);
    }
    var r = this, div = "";
    this.elmt = document.createElement("div"),
        function () {
            i()
        } ()
};

var SlideLists = function (seaViewer) {
    function i() {

        div += "<div id=\"SlideLists\" style=\"position:absolute;left:0px;bottom:110px;width:240px;height:115px;max-height:125px;overflow:hidden;overflow-y:auto;-webkit-overflow-y:auto;-webkit-overflow-scrolling:touch;border: 1px solid rgb(49, 157, 206);\" ><ul id=\"SlideUl\" style=\"margin:0px;padding:0px\">"
//        <div id="one" style="position: absolute; z-index: 999; bottom: 2px; left: 0px; opacity: 0.9; border: 1px solid rgb(49, 157, 206); width: 240px; height: 110px; display: block;" class="liteAccordion rounded basic">
//        div += "</ul></div><div id=\"slides\" style=\"position:absolute;left:247px;bottom:100px;background-color:white;border: 2px solid rgb(215, 210, 210);border-left-width:0px;\" onmouseover=\"MoveOver(this)\"  onmouseout=\"MoveOut(this)\" onclick=\"ck(this)\"><img id=\"SlideImg\" style=\"width:12px;height:121px\" src=\"assets/image/la_no.png\" /></div>";
        div += "</ul></div><div id=\"slides\" style=\"position:absolute;left:238px;bottom:110px;background-color:white;border: 2px solid rgb(49, 157, 206);border-left-width:0px;\" onclick=\"ck(this)\"><img id=\"SlideImg\"  src=\"assets/image/la_no.png\" /></div>";

//        <div style="position: absolute; z-index: 999; bottom: 2px; left: 238px; opacity: 0.9;" onclick="toolswitch(this)">
//        <img src="assets/image/la_no.png" id="toolimg">
//    </div>
        $(r.elmt).append(div);
    }
    var r = this, div = "";
    this.elmt = document.createElement("div"),
    function () {
        i()
    } ()
}
function ck(v) {
    var display = $("#SlideLists").css("display");
    if (display == "none") {
        $("#SlideLists").css("display", "block")
        $(v).css("left", "238px");
        $("#SlideImg").attr("src", "assets/image/la_no.png");
    }
    else {
        $("#SlideLists").css("display", "none")
        $(v).css("left", "0px");
        $("#SlideImg").attr("src", "assets/image/qiepianliebiao.png");

    }
}
function getcookie(name) {
    var cookie_start = document.cookie.indexOf(name);
    var cookie_end = document.cookie.indexOf(";", cookie_start);
    return cookie_start == -1 ? '' : unescape(document.cookie.substring(cookie_start + name.length + 1, (cookie_end > cookie_start ? cookie_end : document.cookie.length)));
}
var BtnShot = function (SeaViewer) {
    var r = this, div = "";
    this.elmt = document.createElement("div");
    div += "<div style=\"position:absolute;right:10px;top:260px\" ><button class=\" btn btn-primary \" style=\"width:60px;color:black; padding:2px;background:	#6CA6CD;\" id=\"shotinput\" onclick=\"SaveImgs()\">截图</button></div>";
    $(r.elmt).append(div);
}