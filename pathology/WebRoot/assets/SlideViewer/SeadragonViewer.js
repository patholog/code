var SlideSeadragonViewer = function (n, t) {
  function lt(SlideId) {
    function rrBack(n) {

      OpenImage(n);
      r = n;

    }

    i.provider = new SlideViewerProvider,
        i.provider.GetImageInfo(SlideId, rrBack);
  }

  function OpenImage(n) {
    var source = new SeadragonLiYTileSource(Number(n.Width), Number(n.Height), Number(n.TileSize), 0, ".jpg", n.Rate, n.FileNum, n.ID, i.provider, 1.5, 1, 0, 0, 0, 0, String(n.DigitalSlidePath));
    i.openTileSource(source)
  }

  var w;
  //[n] = container_viewer
  SeadragonViewer.apply(this, [n]);
  //        ShapeCanvas.apply(this, arguments);
  var i = this,
      ct, f, r, kt, e, h, y, v, u, c, RectPoint, NavWH, s = 0,
      t, a, o, bt = [], label;
  f = document.createElement("div");
  f.id = "Thumbnail";
  //    u = i;

  this.provider,
      function () {

        if (i.addEventListener("open", Open), i.addEventListener("animation", Animation), $.support.touch) {
          i.setMouseNavEnabled(!1);
          var t = $("#" + n);
          t.bind("touchstart", touchstart),
              t.bind("touchmove", touchmove),
              t.bind("touchend", touchend),
              t.bind("gesturestart", gesturestart),
              t.bind("gesturechange", gesturechange)
        }

        window.onorientationchange = function () {
          setTimeout(scrollTo, 0, 0, 0);
          UpdateView();
        }
        window.onresize = function () {
          UpdateView();
        }
        IsAndroid(),
            //CreateSliderPanel(),
            CreateViewerToolbar(),
            CreateNavButton(),
            CreateMenu();

        var handstyle = new Hammer(document.getElementById(n));
        if (SlideViewerSupport.isAndroid) {
          handstyle.get('pinch').set({enable: true});
        }
        handstyle.on("pinch", function (ev) {

          t;
          t = w * ev.scale;

          if (i.viewport && t <= i.viewport.getMinZoom()) {
            t = i.viewport.getMinZoom()
          }
          if (i.viewport && t >= i.viewport.getMaxZoom()) {
            t = i.viewport.getMaxZoom()
          }
          i.viewport.zoomTo(t);

        });
        handstyle.on("pinchstart", function (ev) {

          w = i.viewport.getZoom(!0);


        });

      }();

  function UpdateView() {
    //        var n = $("#container_toolbar").height() || 45;
    var n = $("#container_toolbar").height()
    $("#container").height($(window).height());
    $("#container_viewer").height($("#container").height() - n);
    //$("#container_viewer").height($(window).height());
  }

  function Open() {
    //                pt();
    ShowImageProcess();
    //        ShowLabel();
    //                 b();
    ShowNavMap();
    at();
    isIElast() ? null : u.showrulers();
    //        wt()
  }

  function pt() {
    i.provider.getSlidePermission(f.id,
        function (n) {
          s = n,
          (s & 2) > 0 && u && u.isShapeChanged && t.tbMain.setSaveButton(!0)
        })
  }

  function wt() {
    if (r && r.tierCount > 1) {
      var n = Math.floor(r.tierCount / 2),
          i = -n,
          t = r.tierCount - n - 1;
      o.setData(i, t, 0, 1),
          o.show()
    } else o.hide()
  }

  function b() {
    var e, u;
    if (i.drawer.clearOverlays(), r.id < 0 && f.ROIs.length > 0) for (e = f.baseImage.height / f.baseImage.width, u = 0; u < f.ROIs.length; u++) {
      var t = f.ROIs[u],
          h = t.x / f.baseImage.width,
          c = t.y / f.baseImage.height * e,
          l = t.width / f.baseImage.width,
          o = t.height / f.baseImage.height * e,
          n = document.createElement("div"),
          s = document.createTextNode(t.scanObjective + "x");
      n.appendChild(s),
          n.style.backgroundColor = t.hasImage ? "#006400" : "#A0A000",
          n.style.opacity = .4,
          n.style.filter = "alpha(opacity=40)",
          $(n).dblclick(t, nt),
          $(n).hover(function () {
                this.style.border = "medium solid Blue"
              },
              function () {
                this.style.border = ""
              }),
          i.drawer.addOverlay(n, new Seadragon.Rect(h, c, l, o))
    }
  }

  function ShowImageProcess() {
    a = new ImageProcessing(i),
        a.start()
  }

  function at() {
    function n(n) {
      if (n.error) {
        error = new MdsError(n.error);
        return
      }
      r.hasAnnotations = !0,
          r.annotations = n.annotations,
          u.initImageAnnotationsShape(n.annotations),
          u.showImageAnnotations()
    }

    (u || (u = new ShapeCanvas(i)), u.createShapeCanvas()) && (u.onShapeDrawEnd = function () {
      t.tbAnnotation.resetAnnotationButtons(),
          //            t.resetAnnotationButtons(),
      SlideViewerConfig.autoShowAnnoDialog && t.tbAnnotation.showAnnotationDialog();  //t.Ashow()
    },
        u.onShapeChanged = function () {
          (s & 2) > 0 && t.tbAnnotation.setSaveButton(!0)
        },
        u.setOpenImage(r, f.id), SlideViewerConfig.enableAnnotation && !r.hasAnnotations ? (u.clearShapeArray(), i.provider.getAnnotation(f.id, r.ID, n)) : (u.initImageAnnotationsShape(r.annotations), u.showImageAnnotations()))
  }

  function ShowLabel() {
    if (r && !h) {
      var n = i.provider.getLabelUrl(f.id, r.ID);
      h = new SlideLabel(n),
          h.setVisibility(SlideViewerConfig.showLabel()),
          i.addControl(h.elmt, Seadragon.ControlAnchor.TOP_RIGHT)
    }
  }

  function ShowNavMap(n) {
    var t, n, u;
    r && (Number(r.Width) > Number(r.Height) ? (t = 200, n = Math.floor(t * r.Height / r.Width), NavWH = {
      Width: t,
      Height: n
    }) : (n = 200, t = Math.floor(n * r.Width / r.Height), NavWH = {Width: t, Height: n}),
        u = i.provider.getThumbnailUrl(r.Rate, r.FileNum, r.ID, r.TileSize, 1, 1, 0, 0, 0, 0, r.DigitalSlidePath),
        e = new NavigationView(u, t, n),
        e.onUserMove = function (n, t) //用户用鼠标移动导航图中的缩放框时更新图像，harry
        {
          //n，t分别是缩放框的中心位置
          i.viewport && i.viewport.panTo(new SeadragonPoint(n, t));
          /*
          if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
          {
          //alert("SendMsg=" + SendMsg);
          var currentZoom = ($("#xbl").text());
          SendMsg("usermove|" + n + "|" + t + "|czoom#" + currentZoom);
          }
          */
        },
        e.setVisibility(SlideViewerConfig.showRulers()),
        e.setVisibility(SlideViewerConfig.showNavMap()), i.addControl(e.elmt, Seadragon.ControlAnchor.TOP_LEFT), Animation());

    /*定位的时候执行一次，用户主动在点击的时候不会执行下面的事件 harry
    var mnn = 0.643618279072254;
    var mtt = 0.36650399059224964;
    i.viewport && i.viewport.panTo(new SeadragonPoint(mnn, mtt));
    console.log("tsssssss = " + mnn);
    */
  }

  function Animation() {
    var u, n;
    if (i.viewport) {
      var f = i.viewport.getZoom(!0),
          o = i.viewport.getContainerSize(),
          t = i.viewport.getBounds(),
          s = i.viewport.getAspectRatio();

      var mzoom = 2.8853125000000004;
      var mtx = 0.40071843748871805;
      var mty = 0.736967038521246;
      var ms = 2.0447284345047922;

      c = o.x * f / r.Width,
          u = {
            viewportWidth: f,
            containerSize: o,
            bounds: t,
            aspectRatio: s,
            scale: c
          },
          i.trigger("viewportchanged", u),
          //下面这行代码是更新导航图中缩放框的位置的，如果测试效果，可以把等号及后面的两行代码删除即可，harry
          //这里是控制切片跳转位置的，harry
          /*
          console.log("i.viewport.getZoom() = " + i.viewport.getZoom());
          console.log("t.x = " + t.x);
          console.log("t.y = " + t.y);
          console.log("s = " + s);
          console.log("o = " + o);
          */
          RectPoint = e.UpdateViewRect(i.viewport.getZoom(), t.x, t.y, s),
      e && (e.UpdateViewRect(i.viewport.getZoom(), t.x, t.y, s), n = Seadragon.Utils.getElementPosition(e.elmt), e.isOnDragging() || e.UpdateThumbnailOrigin(n.x, n.y))

      //            console.log("i.viewport.getZoom()=" + i.viewport.getZoom());
      /*
      RectPoint = e.UpdateViewRect(mzoom, mtx, mty, ms),
      e && (e.UpdateViewRect(mzoom, mtx, mty, ms), n = Seadragon.Utils.getElementPosition(e.elmt), e.isOnDragging() || e.UpdateThumbnailOrigin(n.x, n.y));
      i.viewport.panTo(new SeadragonPoint(mtx, mty));
      */
    }

  }

  function touchstart(n) {
    var t = n.originalEvent;
    y = t.targetTouches[0].clientX,
        v = t.targetTouches[0].clientY
  }

  function touchmove(n) {
    var t = n.originalEvent,
        f, e, r, u;
    t.preventDefault(),
    i.viewport && t.targetTouches.length === 1 && (f = y - t.targetTouches[0].clientX, e = v - t.targetTouches[0].clientY, y = t.targetTouches[0].clientX, v = t.targetTouches[0].clientY, r = new SeadragonPoint(f, e), u = i.viewport.deltaPointsFromPixels(r), i.viewport.panBy(u))
  }

  function touchend() {
  }

  function gesturestart() {
    w = i.viewport.getZoom(!0)
  }

  function gesturechange(n) {
    var r = n.originalEvent,
        t;
    r.preventDefault();
    t = w * r.scale;

    if (i.viewport && t <= i.viewport.getMinZoom()) {
      t = i.viewport.getMinZoom()
    }
    if (i.viewport && t >= i.viewport.getMaxZoom()) {
      t = i.viewport.getMaxZoom()
    }
    i.viewport.zoomTo(t)
  }

  function IsAndroid() {
    //SlideViewerSupport.isAndroid && (i.addControl(new ZoomPanel(i).elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT), i.addControl(new MainButton(i).elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT))
  }

  function CreateSliderPanel() {
    o = new SliderPanel(1, 100, 1, 10),
        i.addControl(o.elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT),
        o.change(function () {
          var u = Math.floor(r.tierCount / 2);
          i.source.tierIndex = u + o.val(),
              i.drawer.reset(),
              i.drawer.update()
        })
  }

  function CreateNavButton() {

    //SlideViewerSupport.isAndroid || i.addControl(new BottomPanel(i).elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT);    //倍率
    // i.addControl(button.elmt, Seadragon.ControlAnchor.BOTTOM_RIGHT);
  }

  function isMoblie() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if ((bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM)) {
      return true
    }
    else {
      return false;
    }
  }

  function CreateMenu() {
    i.addControl(new AnnotationMenu(i).elmt, Seadragon.ControlAnchor.NONE);
    // i.addControl(new NavBotton(i).elmt, Seadragon.ControlAnchor.NONE)
    i.addControl(new ZoomBotton(i).elmt, Seadragon.ControlAnchor.NONE)
    i.addControl(new ShotLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT)
    if (getQueryString("CanScreenShot") == "1") {

      i.addControl(new BtnShot(i).elmt, Seadragon.ControlAnchor.TOP_RIGHT);

    }
    //alert(n);
    //  i.addControl(new xxBotton(i).elmt, Seadragon.ControlAnchor.NONE)
    //i.addControl(new SlideLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT)//removed by harry at 2015-12-08
    i.addControl(new SlideRuler(i).elmt, Seadragon.ControlAnchor.TOP);


    if (isMoblie() == true) {
      // i.addControl(new AnnotationMenu(i).elmt, Seadragon.ControlAnchor.NONE),
      //i.addControl(new SlideTag(i).elmt, Seadragon.ControlAnchor.TOP_LEFT),
      // i.addControl(new SlideRuler(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT);
      //            if (getQueryString("CanScreenShot") == "1") {
      //                i.addControl(new ShotLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT),
      //                i.addControl(new BtnShot(i).elmt, Seadragon.ControlAnchor.TOP_RIGHT);
      //
      //            }
      // i.addControl(new SlideLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT)

    }
    else {
      //            i.addControl(new AnnotationMenu(i).elmt, Seadragon.ControlAnchor.NONE);
      //            i.addControl(new SlideTag(i).elmt, Seadragon.ControlAnchor.TOP_LEFT);
      //            i.addControl(new SlideRuler(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEF);
      //            i.addControl(new SlideLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT); /*, i.addControl(new AnnexLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT)*/;
      //            if (getQueryString("CanScreenShot") == "1") {
      //                i.addControl(new ShotLists(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT),
      //                 i.addControl(new BtnShot(i).elmt, Seadragon.ControlAnchor.TOP_RIGHT);
      //            }
    }
    //        //browser == "Microsoft Internet Explorer" ? trim_Version == "MSIE6.0" ? null : trim_Version == "MSIE7.0" ? null : trim_Version == "MSIE8.0" ? null : (i.addControl(new AnnotationMenu(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT), i.addControl(new SlideTag(i).elmt, Seadragon.ControlAnchor.TOP_LEFT), i.addControl(new SlideRuler(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT)) : SlideViewerSupport.isAndroid ? null : (i.addControl(new AnnotationMenu(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT), i.addControl(new SlideTag(i).elmt, Seadragon.ControlAnchor.TOP_LEFT), i.addControl(new SlideRuler(i).elmt, Seadragon.ControlAnchor.BOTTOM_LEFT));
    //        var sUserAgent = navigator.userAgent.toLowerCase();
    //        var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    //        var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    //        var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    //        var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    //        var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    //        var bIsAndroid = sUserAgent.match(/android/i) == "android";
    //        var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    //        var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    //        if (!(bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM)) {
    //


    //        }
    //        else {
    //            //t.tbMain.show()

    //        }
  }

  //        function CreateViewerToolbar() {
  //            t = new AnnotationMenu(i);
  //        }
  function CreateViewerToolbar() {
    t = new ViewerToolbar(i, t)//i=this t//tool-ID
  }

  this.getShapeCanvas = function () {
    return u;
  },
      this.getRectPoint = function () {
        return RectPoint;
      },
      this.getNav = function () {
        return NavWH;
      },
      this.getNavMap = function () {
        return e
      },
      this.getSlideLabel = function () {
        return h
      },
      this.getCurrentImage = function () {
        return r
      },
      this.getCurrentSlide = function () {
        return f
      },
      this.canWrite = function () {
        return (s & 2) > 0
      },
      this.getScale = function () {
        return c
      },
      this.getImageProcessing = function () {
        return a
      },
      this.openMds = function (n) {
        // ct = ot(n),
        lt(n)
      },
      this.zoomToObj = function (n) {
        var f = n / r.Rate * r.Width,    //该倍率下的切片宽度
            u = i.viewport.getContainerSize(),   //窗口宽高
            ui = i.getShapeCanvas(),   //ShapeCanvas
            t = f / u.x;    //切片宽度与窗口宽度的比值
        isIElast() ? null : SlideViewerConfig.showRuler === !1 ? null : ui.showrulers()
        i.viewport.zoomTo(t)
      },
      this.dataChanged = function () {   //return !1
        if (u) return u.isShapeChanged
      },
      this.saveAnnotations = function () {    //保存注释是否成功
        u && u.updateImageAnnotations(function (n) {
          n.success ? i.showMessage(SlideViewerStrings.getString("Messages.SaveAnnotationSuccess")) : i.showMessage(SlideViewerStrings.getString("Messages.SaveAnnotationFailed"))
        })
      },
      this.resumeAnnotations = function () {
        u && (u.resumeBackUpShapes(), t.tbAnnotation.setSaveButton(!1))
      },
      this.update = function () {
        u && (u.clearShapeCanvas(!0), u.showImageAnnotations(!0)),
            i.drawer.update(),
            e.refresh()
      },
      this.showMessage = function (n, t) {
        var r, u, e, f;
        t == null && (t = 1500),
            r = $("<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h1>" + n + "</h1></div>"),
            r.appendTo("body"),
            u = i.viewport == null ? new Seadragon.Point($(window).width(), $(window).height()) : i.viewport.getContainerSize(),
            e = (u.x - r.width()) / 2 + "px",
            f = (u.y - r.height()) / 2 + "px",
            r.css({
              top: f,
              left: e,
              filter: "alpha(opacity=90)",
              opacity: "0.9",
              position: "absolute",
              display: "block",
              "padding-left": "12px",
              "padding-right": "12px"
            }),
            r.delay(t).fadeOut(400,
                function () {
                  $(this).remove()
                })
      },
      this.openImage = function (n) {
        OpenImage(n)
      }
}