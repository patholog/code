//var ImageAdjustmentDialog = function (n) {
//    function d() {
//        i = $(rt),
//        $("[data-lang]", i).html(function () {
//            return SlideViewerStrings.getString($(this).attr("data-lang"))
//        }),
//        i.attr("title", SlideViewerStrings.getString("ImageAdjustments.Title")),
//        $(p, i).slider({
//            min: 1,
//            max: 100,
//            value: 50,
//            slide: function (n, r) {
//                var e = r.value,
//                f = h(e);
//                $(p + "Value", i).html(f.toFixed(2).toString()),
//                n.originalEvent && t.gamma != f && (t.gamma = f, u())
//            }
//        }),
//        $(b, i).slider({
//            min: 0,
//            max: 255,
//            value: 0,
//            slide: function (n, r) {
//                var f = r.value;
//                $(b + "Value", i).html(f.toString()),
//                n.originalEvent && t.contrastMin != f && (t.contrastMin = f, u())
//            }
//        }),
//                $(w, i).slider({
//                    min: 0,
//                    max: 255,
//                    value: 255,
//                    slide: function (n, r) {
//                        var f = r.value;
//                        $(w + "Value", i).html(f.toString()),
//                        n.originalEvent && t.contrastMax != f && (t.contrastMax = f, u())
//                    }
//                }),
//        $(w, i).slider({
//            min: 1,
//            max: 100,
//            value: 50,
//            slide: function (n, r) {
//                var l = r.value;
//                c = h(l);
//                $(w + "Value", i).html(c.toFixed(2).toString()),
//                n.originalEvent && t.contrast!=c && (t.red = c, t.green = t.blue = t.red, u())
//            }
//        }),
//                           $(co, i).slider({     //对比度
//                               min: 0,
//                               max: 100,
//                               value: 50,
//                               step: 0.5,
//                               slide: function (n, r) {
//                                   var l = r.value;
//                                   c = re(l);
//                                   $(co + "Value", i).html(c.toFixed(2).toString()),
//                n.originalEvent && t.contrast != c && (t.contrast = c, u())
//                               }
//                           }),
//                   $(light, i).slider({     //亮度
//                            min: 0,
//                            max: 100,
//                            value: 50,
//                            step:0.5,
//                            slide: function (n, r) {
//                                var l = r.value;
//                                c = re(l);
//                                $(light + "Value", i).html(c.toFixed(2).toString()),
//                n.originalEvent && t.Brightness!= c && (t.Brightness=c, u())
//                            }
//                        }),
//        $(o, i).slider({  //red
//            min: 0,
//            max: 100,
//            value: 50,
//            step: 0.5,
//            slide: function (n, r) {
//                var l = r.value,
//                c = re(l)
//                var at = (Math.round(c * 100)) + "%";
//                $(o + "Value", i).html(at),
//                n.originalEvent && c != t.red && (t.red = c, u()); //(t.red = c, s && (t.green = t.blue = t.red, $(f, i).slider("value", l), $(e, i).slider("value", l)), u())
//            }
//        }),
//        $(f, i).slider({    //green
//            min: 0,
//            max: 100,
//            value: 50,
//            slide: function (n, r) {
//                var l = r.value,
//                c = re(l);
//                var at = (Math.round(c * 100)) + "%";
//                $(f + "Value", i).html(at),
//                n.originalEvent && c != t.green && (t.green = c, u()); //(t.green = c, s && (t.red = t.blue = t.green, $(o, i).slider("value", l), $(e, i).slider("value", l)), u())
//            }
//        }),
//        $(e, i).slider({    //blue
//            min: 0,
//            max: 100,
//            value: 50,
//            slide: function (n, r) {
//                var l = r.value,
//                c = re(l);
//                var at = (Math.round(c * 100)) + "%";
//                $(e + "Value", i).html(at),
//                n.originalEvent && c != t.blue && (t.blue = c, u()); //(t.blue = c, s && (t.red = t.green = t.blue, $(f, i).slider("value", l), $(o, i).slider("value", l)), u())
//            }
//        }),
//                $(a, i).slider({
//                    min: 0,
//                    max: 10,
//                    value: 0,
//                    slide: function (n, r) {
//                        var f = r.value;
//                        $(a + "Value", i).html(f.toString()),
//                        n.originalEvent && t.saturation != f && (t.saturation = f, u())
//                    }
//                }),
//                $(l, i).slider({
//                    min: 0,
//                    max: 10,
//                    value: 0,
//                    slide: function (n, r) {
//                        var f = r.value;
//                        $(l + "Value", i).html(f.toString()),
//                        n.originalEvent && t.sharpness != f && (t.sharpness = f, u())
//                    }
//                }),
//                $(it, i).change(function () {
//                    if (s = $(this).attr("checked") === "checked", s) {
//                        t.green = t.blue = t.red;
//                        var n = c(t.red);
//                        $(f, i).slider("value", n),
//                        $(e, i).slider("value", n)
//                    }
//                }),
//        i.appendTo($("body")).dialog({
//            open: nt,
//            autoOpen: !1,
//            resizable: !1,
//            width: "600",
//            modal: !0,
//            buttons: [{
//                text: "比较"
//            },
//            {
//                text: "应用",
//                click: function () {
//                    r && !t.isEquals(y) && (r.imageAdjustment = t, n.canWrite() && saveImageAdjustment()),
//                    $(this).dialog("close")
//                }
//            },
//            {
//                text: SlideViewerStrings.getString("Buttons.Cancel"),
//                click: function () {
//                    r && (t = y, r.imageAdjustment = t),
//                    u(),
//                    $(this).dialog("close")
//                }
//            },
//            {
//                text: SlideViewerStrings.getString("Buttons.Reset"),
//                click: function () {
//                    t.reset(),
//                    u(),
//                    k()
//                }
//            }]
//        })
//    }
//    function u() {
//        v || (v = n.getImageProcessing()),
//        v && (n.update(), v.adjust(t))
//    }
//    function tt() {
//        r = n.getCurrentImage(),
//        r && r.imageAdjustment ? (t = r.imageAdjustment, y = t.clone()) : (t = new ImageAdjustment, y = null),
//        k()
//    }
//    function k() {
//        var r = g(t.gamma),
//        n, at;
//        $(p, i).slider("value", r),
//        $(p + "Value").html(t.gamma.toFixed(2).toString()),
//        $(b, i).slider("value", t.contrastMin),
//        $(b + "Value").html(t.contrastMin.toString()),
//        $(w, i).slider("value", t.contrastMax),
//        $(w + "Value").html(t.contrastMax.toString()),
//         n = c(t.red),
//        at = (Math.round(t.red * 100)) + "%";
//        n = hx(t.red),
//        $(o, i).slider("value", n),
//        $(o + "Value").html(at),
//        n = c(t.green),
//        at = (Math.round(t.green * 100)) + "%";
//        n = hx(t.green),
//        $(f, i).slider("value", n),
//        $(f + "Value").html(at),
//        n = c(t.blue),
//                at = (Math.round(t.blue * 100)) + "%";
//        n = hx(t.blue),
//        $(e, i).slider("value", n),
//        $(e + "Value").html(at)
//                $(a, i).slider("value", t.saturation),
//                $(a + "Value").html(t.saturation.toString()),
//                $(l, i).slider("value", t.sharpness),
//                $(l + "Value").html(t.sharpness.toString())
//    }
//    function nt() {
//        tt()
//    }
//    function g(n) {
//        var t = 50;
//        return n < 1 ? t = n * 50 + .5 : n > 1 && (t = 50 + (n - 1) * 50 / 8.82 + .5),
//        t
//    }
//    function c(n) {
//        var t = 50;
//        return n < 1 ? t = 50 * (n - .05) : n > 1 && (t = (n - 1) * 12.5 + 50),
//        t
//    }
//    function h(n) {
//        var t = 1;
//        return n < 50 ? t = .05 + n / 50 : n > 50 && (t = 1 + (n - 50) / 12.5),
//        t
//    }
//    function hx(n) {
//        var t = 50;
//        return n < 1 ? t = 50 * n : n > 50 && (t = n * 50),t
//    }
//    function re(n) {
//        var t = 1;
//        return n < 50 ? t = n / 50 : n > 50 && (t = (n / 50)),
//        t
//    }
//    var ft = this,
//    r, t, y, v, s = !1,
//    light = "#Brightness",
//    co = "#Contrast",
//    p = "#gamma",
//    b = "#min",
//    w = "#max",
//    o = "#red",
//    f = "#green",
//    e = "#blue",
//    a = "#saturation",
//    l = "#sharpness",
//    it = "#chkAllChannels",
//    ut = "#btnOk",
//    ht = "#btnCancel",
//    st = "#btnReset",
//    ot = "#btnSave",
//    i, et = "#imageAdjustment",
//   rt = '<div id="imageAdjustment" title="Adjust Image"> \t\t<fieldset> \t\t\t\t<legend data-lang="ImageAdjustments.Gamma">Gamma</legend> \t\t\t\t<div data-role="fieldcontain"> \t\t\t\t\t<label class="adjustment-slider-text" for="gamma" data-lang="ImageAdjustments.Factor">Factor</label> \t\t\t\t\t<div id="gamma" class="adjustment-slider" data-role="slider"></div> \t\t\t\t\t<label id="gammaValue" class="adjustment-slider-value">1</label> \t\t\t\t</div> \t\t</fieldset> \t\t<fieldset> \t\t\t<legend data-lang="ImageAdjustments.Contrast">Contrast</legend> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="min" data-lang="ImageAdjustments.MinInput">Min Input</label> \t\t\t\t<div id="min" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="minValue" class="adjustment-slider-value">0</label> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="max" data-lang="ImageAdjustments.MaxInput">Max Input</label> \t\t\t\t<div id="max" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="maxValue" class="adjustment-slider-value">255</label> \t\t\t</div> <div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="min" data-lang="ImageAdjustments.Contrast">Min Input</label> \t\t\t\t<div id="Contrast" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="ContrastValue" class="adjustment-slider-value">0</label> \t\t\t</div></fieldset>\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="min" data-lang="ImageAdjustments.Brightness">Min Input</label> \t\t\t\t<div id="Brightness" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="BrightnessValue" class="adjustment-slider-value">0</label> \t\t\t</div></fieldset> \t\t<fieldset> \t\t\t<legend data-lang="ImageAdjustments.Channels">Channels</legend> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="red" data-lang="ImageAdjustments.Red">Red</label> \t\t\t\t<div id="red" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="redValue" class="adjustment-slider-value">1</label> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="green" data-lang="ImageAdjustments.Green">Green</label> \t\t\t\t<div id="green" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="greenValue" class="adjustment-slider-value">1</label> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="adjustment-slider-text" for="blue" data-lang="ImageAdjustments.Blue">Blue</label> \t\t\t\t<div id="blue" class="adjustment-slider" data-role="slider"></div> \t\t\t\t<label id="blueValue" class="adjustment-slider-value">1</label> \t\t\t</div> \t\t\t \t\t</fieldset> \t</div>';
//    (function () {
//        d()
//    })(),
//    this.show = function () {
//        i.dialog("open")
//    },
//    saveImageAdjustment = function () {
//        function t(t) {
//            t.success ? n.showMessage(SlideViewerStrings.getString("Messages.SaveAdjustmentSuccess")) : n.showMessage(SlideViewerStrings.getString("Messages.SaveAdjustmentFailed"))
//        }
//        if (n.provider) {
//            var i = n.getCurrentSlide();
//            n.provider.updateImageAdjustment(i.id, r.id, r.imageAdjustment, t)
//        }
//    }
//};
var AnnotationDialog = function (n) {
    function h() {
        t = $(s),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", SlideViewerStrings.getString("Annotations.Dialog.Title")),
        t.appendTo($("body")).dialog({
            open: f,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: "480",
            height: "430",
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.Ok"),
                click: function () {
                    o(),
                    r.showImageAnnotations(),
                    $(this).dialog("close")
                }
            },
            {
                text: SlideViewerStrings.getString("Buttons.Cancel"),
                click: function () {
                    i = r.getActiveShape();
                    //r.deleteAnnotation();//harry removed
                    //del()
                    $(this).dialog("close")
                }
            }],
            close: function (event, ui) {

            }
        }), $('#picker').colpick({
            layout: 'hex',
            submit: 0,
            colorScheme: 'dark',
            onChange: function (hsb, hex, rgb, el, bySetColor) {
                $(el).css('border-color', '#' + hex);
                // Fill the text box just if the color was set using the picker, and not the colpickSetColor function.
                if (!bySetColor) $(el).val(hex);
            }
        }).keyup(function () {
            $(this).colpickSetColor(this.value)
        });

        //        $("#colorpicker", t).farbtastic("#color"),
        //        u = $.farbtastic("#colorpicker")
    }
    function f() {
        r = n.getShapeCanvas(),
        i = r.getActiveShape(),
        $(i).attr("viewer", n),
        isDisabled();
        e()
    }

    function isDisabled() {
        var input = $('input[name="identity"]');
        var t = r.getActiveShape();
        for (var i = 0; i < input.length; i++) {
            if (t.type != "Position")
                input[i].disabled = true;
            else
                input[i].disabled = false;
        }
    }
    function e() {
        var Anno = r.getAnnotation();
        var name;
        for (var j = 0; j < Anno.length; j++) {
            name = SlideViewerStrings.getString("Annotations.Draw." + i.type + "") + "" + (Anno.length) + "";
        }
        $("#chkAutoShow", t).attr("checked", SlideViewerConfig.autoShowAnnoDialog);
        $("#lineWidth", t).val(i.width);
        $("#picker", t).val(i.color);
        $("#annoName", t).val(name);

        $("#annoDesc", t).val(i.description);
    }
    function del() {
        var obj = document.getElementById("AnnoName");
        var index = obj.selectedIndex;
        obj.options.remove(index) && anno.pop(index)
    }
    function o() {

        ShapeDefaultConfig.defaultColor = $("#picker", t).val(),
        ShapeDefaultConfig.lineWidth = $("#lineWidth", t).val(),
        SlideViewerConfig.autoShowAnnoDialog = $("#chkAutoShow", t).attr("checked") === "checked",
        i && (i.width = ShapeDefaultConfig.lineWidth, i.color = ShapeDefaultConfig.defaultColor, i.name = $("#annoName", t).val(), i.description = $("#annoDesc", t).val(), i.isMeasurementChanged = !0, r.dirtyCanvas(), i.imageindex = $('input[name="identity"]:checked').val())

    }
    var c = "#annotationDialog",
    t, u, r, i, s = '<div id="annotationDialog"     \t data-role="dialog" \t\t data-overlay-theme="e"          title="Edit Annotation"          class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="c"> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label for="lineWidth" class="ui-item-label" data-lang="Annotations.Dialog.LineWidth">Line Width:</label> \t\t\t\t<select id="lineWidth" class="ui-item-field" > \t\t\t\t\t<option value="1">1</option> \t\t\t\t\t<option value="2">2</option> \t\t\t\t\t<option value="5" selected="selected">5</option> \t\t\t\t\t<option value="10">10</option> \t\t\t\t\t<option value="20">20</option> \t\t\t\t</select> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label for="annoName" class="ui-item-label" data-lang="Annotations.Dialog.Name">Name:</label> \t\t\t\t<input type="text" id="annoName" class="ui-item-field" /> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label for="annoDesc" class="ui-item-label" data-lang="Annotations.Dialog.Description">Description:</label> \t\t\t\t<textarea id="annoDesc" class="ui-item-field" rows="2"></textarea> \t\t\t</div> \t\t\t<div data-role="fieldcontain" id="Color"> \t\t\t\t<label for="color" class="ui-item-label" data-lang="Annotations.Dialog.Color">Color:</label> \t\t\t\t<input type="text" id="picker" /> \t\t\t\t</div>             <div data-role="fieldcontain">         <label for="chkAutoShow" data-inline="true" data-lang="Buttons.AutoShow" style="width:27%">Show Automatically</label><input type="checkbox" id="chkAutoShow"/>             </div> <div data-role="fieldcontain"><table><tr><td style="width:30%"><label>定位图标选择：</label></td><td><input type="radio" name="identity" value="1"  checked="checked"/><img src="assets/image/pin_1.png"  alt=""></td><td><input type="radio" name="identity" value="2"/><img src="assets/image/pin_2.png"></td><td><input type="radio" name="identity" value="3"/><img src="assets/image/pin_3.png"  alt=""></td><td><input type="radio" name="identity" value="4"/><img src="assets/image/pin_4.png"  alt=""></td></tr></table></div>\t\t</div> \t</div>';
    (function () {
        h()
    })(),
    this.show = function () {
        t.dialog("open")
    }
};
var AnnotationSaveDialog = function (n) {
    function u() {
        t = $(r),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", SlideViewerStrings.getString("Annotations.AskSave.Title")),
        t.appendTo($("body")).dialog({
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.Yes"),
                click: function () {
                    n.saveAnnotations(),
                    $(this).dialog("close"),
                    i.closeDialog && i.closeDialog()
                }
            },
            {
                text: SlideViewerStrings.getString("Buttons.No"),
                click: function () {
                    n.resumeAnnotations(),
                    $(this).dialog("close"),
                    i.closeDialog && i.closeDialog()
                }
            }]
        })
    }
    var t, f = "#annotationSaveDialog",
    i = this,
    r = '<div id="annotationSaveDialog" data-role="dialog"> \t\t<div data-role="content" data-theme="c" data-mini="true"> \t\t\t<p data-lang="Annotations.AskSave.Message">Annotations have been changed, do you want to save?</p> \t\t</div> \t</div>';
    (function () {
        u()
    })(),
    this.closeDialog,
    this.show = function () {
        t.dialog("open")
    }
};
var anno = [];
var OptionsDialog = function (n) {
    function o() {
        t = $(s),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", SlideViewerStrings.getString("Options.Title")),
        $(".option-item-radio", t).buttonset(),
        SlideViewerSupport.canvas || $("[data-show='canvas']", t).hide(),
        t.appendTo($("body")).dialog({
            open: h,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.Ok"),
                click: function () {
                    var h = $(f + "on", t).attr("checked") === "checked",
                    c,
                    l,
                    s,
                    o;
                    SlideViewerConfig.showNavMap(h),
                    c = $(e + "on", t).attr("checked") === "checked",
                    SlideViewerConfig.compactBrowsing(c),
                    l = $(i + "on", t).attr("checked") === "checked",
                    SlideViewerConfig.showRulers(l),
                    s = $(r + "on", t).attr("checked") === "checked",
                    SlideViewerConfig.showGrid(s),
                    o = $(u + "on", t).attr("checked") === "checked",
                    SlideViewerConfig.showLabel(o),
                    n.getSlideLabel().setVisibility(o),
                    n.getNavMap().setVisibility(h),
                    n.update(),
                    $(this).dialog("close")
                }
            },
            {
                text: SlideViewerStrings.getString("Buttons.Cancel"),
                click: function () {
                    $(this).dialog("close")
                }
            }]
        })
    }
    function h() {
        var n = SlideViewerConfig.showNavMap();
        n ? $(f + "on", t).attr("checked", "checked").button("refresh") : $(f + "off", t).attr("checked", "checked").button("refresh"),
        n = SlideViewerConfig.compactBrowsing(),
        n ? $(e + "on", t).attr("checked", "checked").button("refresh") : $(e + "off", t).attr("checked", "checked").button("refresh"),
        n = SlideViewerConfig.showRulers(),
        n ? $(i + "on", t).attr("checked", "checked").button("refresh") : $(i + "off", t).attr("checked", "checked").button("refresh"),
        n = SlideViewerConfig.showGrid(),
        n ? $(r + "on", t).attr("checked", "checked").button("refresh") : $(r + "off", t).attr("checked", "checked").button("refresh"),
        n = SlideViewerConfig.showLabel(),
        n ? $(u + "on", t).attr("checked", "checked").button("refresh") : $(u + "off", t).attr("checked", "checked").button("refresh")
    }
    var c = "#optionsDialog",
    t, f = "#flip-navmap-",
    e = "#flip-compact-",
    i = "#flip-ruler-",
    r = "#flip-grid-",
    u = "#flip-label-",
    s = '<div id="optionsDialog" title="Options" data-role="dialog">         <div data-role="fieldcontain" class="option-item">             <label for="flip-navmap" class="option-item-label" data-lang="Options.NavMap">                 Nav Map:</label>             <div id="flip-navmap" class="option-item-radio">                 <input type="radio" id="flip-navmap-on" name="navmap" value="on" />                 <label for="flip-navmap-on" data-lang="Buttons.On">On</label>                 <input type="radio" id="flip-navmap-off" name="navmap" checked="checked" value="off" />                 <label for="flip-navmap-off" data-lang="Buttons.Off">Off</label>             </div>         </div>         <div data-role="fieldcontain" class="option-item">             <label for="flip-label" class="option-item-label" data-lang="Options.Label">Label:</label>             <div id="flip-label" class="option-item-radio">                 <input type="radio" id="flip-label-on" name="label" value="on"/>                 <label for="flip-label-on" data-lang="Buttons.On">On</label>                 <input type="radio" id="flip-label-off" name="label" value="off" />                 <label for="flip-label-off" data-lang="Buttons.Off">Off</label>             </div>         </div>         <div data-role="fieldcontain" class="option-item">             <label for="flip-compact" class="option-item-label" data-lang="Options.Compact">Compact:</label>             <div id="flip-compact" class="option-item-radio">                 <input type="radio" id="flip-compact-on" name="compact" value="on"/>                 <label for="flip-compact-on" data-lang="Buttons.On">On</label>                 <input type="radio" id="flip-compact-off" name="compact" value="off" />                 <label for="flip-compact-off" data-lang="Buttons.Off">Off</label>             </div>         </div>         <div data-role="fieldcontain" class="option-item" data-show="canvas">             <label for="flip-ruler" class="option-item-label" data-lang="Options.Ruler">Ruler:</label>             <div id="flip-ruler" class="option-item-radio">                 <input type="radio" id="flip-ruler-on" name="ruler" value="on" />                 <label for="flip-ruler-on" data-lang="Buttons.On">On</label>                 <input type="radio" id="flip-ruler-off" name="ruler" value="off" />                 <label for="flip-ruler-off" data-lang="Buttons.Off">Off</label>             </div>         </div>         <div data-role="fieldcontain" class="option-item" data-show="canvas">             <label for="flip-grid" class="option-item-label" data-lang="Options.Grid">Grid:</label>             <div id="flip-grid" class="option-item-radio">                 <input type="radio" id="flip-grid-on" name="grid" value="on" />                 <label for="flip-grid-on" data-lang="Buttons.On">On</label>                 <input type="radio" id="flip-grid-off" name="grid" value="off" />                 <label for="flip-grid-off" data-lang="Buttons.Off">Off</label>             </div>         </div>     </div>';
    (function () {
        o()
    })(),
    this.show = function () {
        t.dialog("open")
    }
};
var NotSupportedDialog = function () {
    function i() {
        n = $(t),
        $("[data-lang]", n).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        n.attr("title", SlideViewerStrings.getString("NotSupported.Title")),
        n.appendTo($("body")).dialog({
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: 500,
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.Ok"),
                click: function () {
                    $(this).dialog("close")
                }
            }]
        })
    }
    var r = "#notSupportedDialog",
    n, t = '<div id="notSupportedDialog" data-role="dialog" class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="c" data-mini="true">             <p data-lang="NotSupported.Message">It seems this function is not supported well on your browser.                Please use the latest <a href="https://www.google.com/chrome" target="_blank">Chrome</a>,                <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> or                <a href="http://www.apple.com/safari/" target="_blank">Safari</a> for a better browsing experience.</p> \t\t</div>     </div>';
    (function () {
        i()
    })(),
    this.show = function () {
        n.dialog("open")
    }
},
CompactDialog = function () {
    function i() {
        n = $(t),
        $("[data-lang]", n).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        n.attr("title", SlideViewerStrings.getString("Compact.Title")),
        n.appendTo($("body")).dialog({
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: 500,
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.Ok"),
                click: function () {
                    $(this).dialog("close")
                }
            }]
        })
    }
    var r = "#compactDialog",
    n, t = '<div id="compactDialog" data-role="dialog" class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="c" data-mini="true"> \t\t\t<p data-lang="Compact.Message">You are now in compact browsing. You can go to [Options] to turn it off.</p> \t\t</div> \t</div>';
    (function () {
        i()
    })(),
    this.show = function () {
        n.dialog("open")
    }
};
var SlideInfo = function (SeaViewer) {
    function h() {
        t = $(s);
        t.appendTo($("body")).dialog({
            open: f,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: "520",
            height: "550"
        })
    }
    function f() {
        c = SeaViewer.getShapeCanvas();
    }
    //    var r = "slideDialog",
    //t, c, img, s = '<div id="slideDialog"     \t data-role="dialog" \t\t data-overlay-theme="e"          title="切片信息"          class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="b"> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="ui-item-label" >文件名:</label>\t\t\t <label  id="filename"></label> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >文件大小:</label> \t\t\t\t<label id="filesize" ></label> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >图像像素:</label> \t\t\t\t<label id="imgpixel" ></label>  \t\t\t</div> \t\t\t<div data-role="fieldcontain" > \t\t\t\t<label  class="ui-item-label" >扫描倍率:</label> \t\t\t\t <label id="multiple" ></label> \t\t\t\t</div>    <div data-role="fieldcontain"> \t\t\t\t<label class="ui-item-label" >扫描时刻:</label>\t\t\t <label  id="ScanTime"></label> \t\t\t</div><div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >扫描时间:</label>\t\t\t <label  id="SpeedTime"></label> \t\t\t</div>  <div data-role="fieldcontain"> \t\t\t\t<label class="ui-item-label" >扫描机器:</label>\t\t\t <lablel id="ScanMac"></label> \t\t\t</div>\t\t <div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >预览图:</label>\t\t\t   </br><img id="labelImg" style="width:180px;height:180px"/><img id="slideImg" style=" height:180px;width:280px" />\t\t\t</div>\t  </div> \t</div>';
    var r = "slideDialog",
    t, c, img, s = '<div id="slideDialog"     \t data-role="dialog" \t\t data-overlay-theme="e"          title="切片信息"          class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="b"> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label class="ui-item-label" >文件名:</label>\t\t\t <label  id="filename"></label> \t\t\t</div> \t\t\t\t\t\t<div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >图像像素:</label> \t\t\t\t\t\t\t\t<label id="imgpixel" ></label>  \t\t\t</div> \t\t\t<div data-role="fieldcontain" > \t\t\t\t<label  class="ui-item-label" >扫描倍率:</label> \t\t\t\t <label id="multiple" ></label> \t\t\t\t</div>     <div data-role="fieldcontain"> \t\t\t\t<label class="ui-item-label" >扫描机器:</label>\t\t\t <lablel id="ScanMac"></label> \t\t\t</div>\t\t <div data-role="fieldcontain"> \t\t\t\t<label  class="ui-item-label" >预览图:</label>\t</br></br><img id="labelImg" style="width:180px;height:280px"/><img id="slideImg" style=" height:180px;width:430px" />\t</div></div> \t</div>';
    (function () {
        h();
    })(),
    this.show = function () {
        t.dialog("open");
    },
    this.text = function () {
        var host = window.location.host;
        var herf = window.location.href;
        var file = herf.split('/')
        var context = SeaViewer.getCurrentImage();
        var filesize = context.FileSize + "MB"
        var url = "";
        var fn = context.DigitalSlidePath.split('filename=');
        var filename = "";
        if (fn.length == 2)
            filename = fn[1];
        else
            filename = fn[0];
        var a = document.getElementById("filesize");
        // document.getElementById("filesize").innerText = filesize;
        url = context.DigitalSlidePath.toLowerCase().replace("decodetile.aspx", "GetFileName.aspx");
        url = url.split('filename=')[0] + 'filename=' + filename;
        $.ajax({
            type: "POST",
            url: url,
            data: "",
            cache: false,
            async: true,
            dataType: "text",
            success: function (result) {
                document.getElementById("filename").innerText = result + ".TMAP";
            }
        });
        document.getElementById("imgpixel").innerText = "" + context.Width + "Pixel×" + context.Height + "";
        document.getElementById("multiple").innerText = "" + context.Rate + "×";
        // document.getElementById("ScanTime").innerText = "" + context.ScanTime + "";
        // document.getElementById("SpeedTime").innerText = "" + context.SpeedTime + "";
        document.getElementById("ScanMac").innerText = "" + context.ScanMac + "";
        // $("#labelImg").attr("src", url);
        $("#labelImg").css("display", "none");
        url = context.DigitalSlidePath.toLowerCase().replace("decodetile.aspx", "getqiepianimg.aspx");
        url = url.split('filename=')[0] + 'filename=' + filename;
        $("#slideImg").attr("src", url);
    }
};
var AnnotationOption = function (n) {
    function h() {
        var height = 620;
        if ($(window).height() < height) {
            height = $(window).height();
        }

        t = $(s),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", SlideViewerStrings.getString("Annotations.Dialog.Title")),
        t.appendTo($("body")).dialog({
            open: f,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: "500",
            height: height,
            buttons: [{
                text: "应用", //SlideViewerStrings.getString("Buttons.Ok"),
                click: function () {
                    o(),
                    r.showImageAnnotations()
                    $(this).dialog("close")
                }
            },
            {
                text: SlideViewerStrings.getString("Buttons.Cancel"),
                click: function () {

                    $(this).dialog("close")
                }
            }],
            close: function (event, ui) {
                r.isSelectedEnable = !0;
                var obj = document.getElementById("AnnoName"); var index = obj.selectedIndex;
                if (index > -1) {
                    obj.options.remove(index), $("#linewidth").val("5"), $("#Picker").val(null), $("#annoname").val(""), $("#annodesc").val(""), $("#Measurement").html("")
                }
            }
        })
        , $('#Picker').colpick({
            layout: 'hex',
            submit: 0,
            colorScheme: 'dark',
            onChange: function (hsb, hex, rgb, el, bySetColor) {
                $(el).css('border-color', '#' + hex);
                // Fill the text box just if the color was set using the picker, and not the colpickSetColor function.
                if (!bySetColor) $(el).val(hex);
            }
        }).keyup(function () {
            $(this).colpickSetColor(this.value)
        });

    }
    function f() {

        r = n.getShapeCanvas();

        anno = Anno;
        select();

    }
    function openChoose() {

        r = n.getShapeCanvas();
        i = r.getActiveShape();
        //var text = a.options[a.selectedIndex].text;
        for (var j = 0; j < Anno.length; j++) {
            if (Anno[j].isSelected) {
                i = Anno[j];
                //a.value = j;
                break;
            }
            if (i == null)
                i = Anno[0];
        }
        if (i == null)
            return;
        isDisabled(i);
        r.setSelectedEnable(!1);
        r.getActiveShape(i);
        $("#linewidth").val(i.width);
        $("#Picker").val(i.color);
        var index = Number(Anno.indexOf(i));
        $("#AnnoName").val(index);
        $("#annoname").val(i.name);
        $("#annodesc").val(i.description);
        $("#Measurement").html($(i.txtElmt).html().split("描述")[0]);
        i.isSelected = true;
        r.showImageAnnotations();
    }

    function o() {

        i = r.getActiveShape();
        if (i == null)
            return;
        i.imageindex = $('input[name="identitys"]:checked').val();
        $("#chkautoShow", t).attr("checked") === "checked" ? i.txtElmt.style.display = "block" : null;
        i.width = $("#linewidth").val();
        i.color = $("#Picker").val();
        i.name = $("#annoname").val();
        i.description = $("#annodesc").val();
        i.isMeasurementChanged = !0, r.dirtyCanvas();
    }
    function hide() {
        $("#ahide").bind("click", function () {
            SlideViewerConfig.enableAnnotation == true ? SlideViewerConfig.enableAnnotation = false : SlideViewerConfig.enableAnnotation = true;
            if (SlideViewerConfig.enableAnnotation) {
                document.getElementById("ahide").src = "assets/image/qT_hidd.png";
                document.getElementById("hide").src = "assets/image/T_hidd.png";
            }
            else {
                document.getElementById("ahide").src = "assets/image/qT_hidd1.png";
                document.getElementById("hide").src = "assets/image/T_hidd1.png";
            }
            r.showImageAnnotations(SlideViewerConfig.enableAnnotation);
        });
        $("#delete").bind("click", function () {
            var obj = document.getElementById("AnnoName");
            var index = obj.selectedIndex;
            i = r.getActiveShape();
            i != null && (r.deleteAnnotation(), obj.options.remove(index), (anno != null ? anno.pop(index) : null), $("#linewidth").val("2"), $("#Picker").val(null), $("#annoname").val(""), $("#annodesc").val(""), $("#Measurement").html(""));
        });
        $("#hide").bind("click", function () {
            var a = document.getElementById("ahide");
            if (document.getElementById("ahide").nameProp == "qT_hidd1.png")
            { }
            else {
                i = r.getActiveShape();
                SlideViewerConfig.enableOne[0] == true ? SlideViewerConfig.enableOne[0] = false : SlideViewerConfig.enableOne[0] = true;
                if (i != null) {
                    if (SlideViewerConfig.enableOne[0]) {
                        document.getElementById("hide").src = "assets/image/T_hidd.png";
                    }
                    else {
                        document.getElementById("hide").src = "assets/image/T_hidd1.png";
                    }
                    (SlideViewerConfig.enableOne[1] = i.name, r.showImageAnnotations(SlideViewerConfig.enableOne))
                }
            }
        });
        $("#AnnoName").bind("change", function () {

            r = n.getShapeCanvas();

            isDisabled(i);
            var index = $("#AnnoName").val();

            // var r = i.viewer.getShapeCanvas();
            var Anno = r.getAnnotation();
            i = Anno[index];
            r.setSelectedEnable(!1);
            r.getActiveShape(i);
            $("#linewidth").val(i.width);
            $("#Picker").val(i.color);
            $("#annoname").val(i.name);


            $("#annodesc").val(i.description);
            $("#Measurement").html($(i.txtElmt).html().split("描述")[0]);
            i.isSelected = true;
            r.showImageAnnotations();

        })
    }


    function select() {

        var td = $("#AnnoName", t);
        Anno = r.getAnnotation();
        var data = r.getActiveShape();
        var input = $('input[name="identitys"]');

        if (data != null && data.imageindex != undefined && data.imageindex != null) {
            for (var i = 0; i < input.length; i++) {
                if (data.imageindex == input[i].value)
                    input[i].checked = true;
            }
        }
        $("#AnnoName").html("");

        for (var i = 0; i < Anno.length; i++) {
            var op = '<option  value="' + i + '"  >' + Anno[i].name + '</option>';
            td.append(op);
        }
    }
    var c = "#annotationoption", ct = 0, Anno,
    t, u, r, i, s = '<div id="annotationoption"     \t data-role="dialog" \t\t data-overlay-theme="e"          title="Edit Annotation"          class="ui-dialog-topright"> \t\t<div data-role="content" data-theme="c"> \t\t\t<div data-role="fieldcontain">\t\t\t <label class="ui-item-label">注释名称：</label>\t\t\t\t<select id="AnnoName" class="ui-item-field"  ></select>\t\t\t\t</div>\t\t\t\t<div data-role="fieldcontain">\t\t\t<label style="margin-left:35px">删除：</label><img style="width:32px;height:32px;margin-right:35px;" src="assets/image/sc.png" id="delete"/>\t\t\t\t<label >隐藏：</label><img src="assets/image/T_hidd.png" id="hide" style="margin-right:35px"/>\t\t\t\t<label >全部隐藏：</label><img src="assets/image/qT_hidd.png"  style="margin-right:35px" id="ahide"/>\t\t\t\t\t  </div>  <div data-role="fieldcontain"> \t\t\t\t<label for="lineWidth" class="ui-item-label" data-lang="Annotations.Dialog.LineWidth">Line Width:</label> \t\t\t\t<select id="linewidth" class="ui-item-field" > \t\t\t\t\t<option value="1">1</option> \t\t\t\t\t<option value="2">2</option> \t\t\t\t\t<option value="5" selected="selected">5</option> \t\t\t\t\t<option value="10">10</option> \t\t\t\t\t<option value="20">20</option> \t\t\t\t</select> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label for="annoName" class="ui-item-label" data-lang="Annotations.Dialog.Name">Name:</label> \t\t\t\t<input type="text" id="annoname" class="ui-item-field" /> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<label for="annoDesc" class="ui-item-label" data-lang="Annotations.Dialog.Description">Description:</label> \t\t\t\t<textarea id="annodesc" class="ui-item-field" rows="2"></textarea> \t\t\t</div> \t\t\t<div data-role="fieldcontain" id="color"> \t\t\t\t<label for="color" class="ui-item-label" data-lang="Annotations.Dialog.Color">Color:</label> \t\t\t\t<input type="text" id="Picker"  /> \t\t\t\t</div>             <div data-role="fieldcontain">       <label for="chkAutoShow" data-inline="true" data-lang="Buttons.AutoShow">Show Automatically</label>     <input type="checkbox" id="chkautoShow"/>        </div><div data-role="fieldcontain"><table><tr><td style="width:30%"><label>定位图标选择：</label></td><td><input type="radio" name="identitys" value="1"  checked="checked"/><img src="assets/image/pin_1.png"  alt=""></td><td><input type="radio" name="identitys" value="2"/><img src="assets/image/pin_2.png"></td><td><input type="radio" name="identitys" value="3" /><img src="assets/image/pin_3.png"  alt=""></td><td><input type="radio" name="identitys" value="4"/><img src="assets/image/pin_4.png"  alt=""></td></tr></table></div>     <div data-role="fieldcontain" ><div class="ui-item-label" style="height:120px;line-height:120px;display:block;overflow:hidden;float:left">测量信息：</div><div   id="Measurement" style="padding:5px 0;;overflow:hidden;float:left;display:inline"></label><div></div>       \t\t</div> \t</div>';
    (function () {
        h()
        hide()
    })(),
    this.show = function () {
        t.dialog("open")
        choose();
    }
    this.showEdit = function () {
        t.dialog("open");
        openChoose();
    }

};
var SlideCase = function (n) {
    function h() {
        t = $(s),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", "病例信息"),
        t.appendTo($("body")).dialog({
            //            open: f,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: "500",
            minHeight: "500"
            //            buttons: [{
            //                text: SlideViewerStrings.getString("Buttons.Ok"),
            //                click: function () {
            //                    $(this).dialog("close")
            //                }
            //            },
            //            {
            //                text: SlideViewerStrings.getString("Buttons.Cancel"),
            //                click: function () {

            //                    $(this).dialog("close")
            //                }
            //            }]
        });
    };
    var c = "#slidecase",
    t, u, r, i, s = '<div id="slidecase"  ></div>';
    (function () {
        h();
    })(),
    this.show = function () {
        t.dialog("open")
    }
};
var ShotList = function (n) {
    function h() {
        t = $(div),
        $("[data-lang]", t).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        t.attr("title", "截图列表"),
        t.appendTo($("body")).dialog({
            open: ShotList,
            autoOpen: !1,
            resizable: !1,
            modal: !1,
            width: "440",
            height: "600"
        });
    };
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    function getcookie(name) {
        var cookie_start = document.cookie.indexOf(name);
        var cookie_end = document.cookie.indexOf(";", cookie_start);
        return cookie_start == -1 ? '' : unescape(document.cookie.substring(cookie_start + name.length + 1, (cookie_end > cookie_start ? cookie_end : document.cookie.length)));
    }
    function ShotList() {
        r = n.getCurrentImage();
        data = r.ID
        var uid = getcookie("UserID"), ConsultID = getQueryString("ConsultID");
        uid = r.UserID;
        url = "http://" + host + "/HTML5/ShotList.ashx";
        var obj;
        $.ajax({
            type: 'get',
            url: url,
            data: 'ID=' + data + '&UserID=' + uid + '&ram=' + Math.random() * 10000 + 1,
            success: function (response) {
                obj = eval("(" + response + ")");
                document.getElementById("ShotList").innerHTML = "";
                document.getElementById("ShotList").innerHTML = obj.div;
                var Shot = $("#ShotLists");
                Shot[0].innerHTML = "";
                Shot[0].innerHTML = obj.Sdiv;

            },
            Error: function (ex) {
                alert(ex);
            }
        });
    }
    var id = "#ShotList", host = window.location.host, data,
t, u, r, i, div = '<div id="ShotList"></div>', url;
    (function () {
        h();
    })(),
    this.show = function () {
        ShotList()
        t.dialog("open");
    }
}
var Demo = function (n) {
    function t() {
        var it, ttt;
        i = $(div),
        $("[data-lang]", i).html(function () {
            return SlideViewerStrings.getString($(this).attr("data-lang"))
        }),
        i.attr("title", SlideViewerStrings.getString("ImageAdjustments.Title")),
        $(a, i).slider({
            min: 0,
            max: 300,
            value: gb(gamma),
            step: 1,
            slide: function (n, r) {
                gamma = g(r.value);
                $(a + "Value").html(gamma);
            },
            change: function () {
                if (gamma != ga) {
                    OpenImg();
                    ga = gamma;
                }

            }
        }),
           $(b, i).slider({
               min: 0,
               max: 100,
               value: 50,
               slide: function (n, r) {
                   contrast = con(r.value);
                   var num = Math.round((r.value / 100).toFixed(2).toString() * 200)
                   $(b + "Value").html(num + "%");
               },
               change: function () {
                   if (contrast != co) {
                       OpenImg();
                       co = contrast;
                   }
               }
           }),
            $(w, i).slider({
                min: 0,
                max: 100,
                value: 50,
                slide: function (n, r) {
                    light = rgb(r.value);
                    var num = Math.round((r.value / 100).toFixed(2).toString() * 200)
                    $(w + "Value").html(num + "%");
                },
                change: function () {
                    if (light != li) {
                        OpenImg();
                        li = light;
                    }

                }
            }),
        $(rgb_r, i).slider({
            min: 0,
            max: 100,
            value: 50,
            slide: function (n, r) {
                rgbR = rgb(r.value);
                var num = Math.round((r.value / 100).toFixed(2).toString() * 200)
                $(rgb_r + "Value").html(num + "%");
            },
            change: function () {
                if (rgbR != rr) {
                    rr = rgbR;
                    OpenImg();

                }
            }
        }),
        $(rgb_g, i).slider({
            min: 0,
            max: 100,
            value: 50,
            slide: function (n, r) {
                rgbG = rgb(r.value);
                var num = Math.round((r.value / 100).toFixed(2).toString() * 200)
                $(rgb_g + "Value").html(num + "%");
            },
            change: function () {
                if (rgbG != rg) {
                    OpenImg();
                    rg = rgbG;
                }
            }
        }),
        $(rgb_b, i).slider({
            min: 0,
            max: 100,
            value: 50,
            slide: function (n, r) {
                rgbB = rgb(r.value);
                var num = Math.round((r.value / 100).toFixed(2).toString() * 200)
                $(rgb_b + "Value").html(num + "%");
            },
            change: function () {
                if (rgbB != rbb) {
                    OpenImg();
                    rbb = rgbB;
                }
            }
        }),
        i.appendTo($("body")).dialog({
            open: tt,
            autoOpen: !1,
            resizable: !1,
            width: "500",
            modal: !1,
            buttons: [{
                text: SlideViewerStrings.getString("Buttons.compare"),
                mousedown: function () {
                    if (gamma != Color.gamma || contrast != Color.contrast || light != Color.light || rgbR != Color.rgbR || rgbG != Color.rgbG || rgbB != Color.rgbB) {
                        Compare.gamma = gamma, Compare.contrast = contrast, Compare.light = light, Compare.rgbR = rgbR, Compare.rgbG = rgbG, Compare.rgbB = rgbB;
                        gamma = Color.gamma, contrast = Color.contrast, light = Color.light, rgbR = Color.rgbR, rgbG = Color.rgbG, rgbB = Color.rgbB;
                        Num();
                    }
                },
                click: function () {
                    if (gamma != Compare.gamma || contrast != Compare.contrast || light != Compare.light || rgbR != Compare.rgbR || rgbG != Compare.rgbG || rgbB != Compare.rgbB) {
                        gamma = Compare.gamma, contrast = Compare.contrast, light = Compare.light, rgbR = Compare.rgbR, rgbG = Compare.rgbG, rgbB = Compare.rgbB;
                        Num();
                    }
                }
            },
              {
                  text: SlideViewerStrings.getString("Buttons.Reset"),
                  click: function () {
                      if (gamma != 1.5 || contrast != 1 || light != 0 || rgbR != 0 || rgbG != 0 || rgbB != 0) {
                          gamma = 1.5, contrast = 1, light = 0, rgbR = 0, rgbG = 0, rgbB = 0;
                          Num();
                      }
                  }
              },
            {
                text: SlideViewerStrings.getString("Buttons.apply"),
                click: function () {
                    Compare.gamma = gamma, Compare.contrast = contrast, Compare.light = light, Compare.rgbR = rgbR, Compare.rgbG = rgbG, Compare.rgbB = rgbB;
                    $(this).dialog("close")
                }
            },
            {
                text: SlideViewerStrings.getString("Buttons.Cancel"),
                click: function () {
                    if (gamma != Color.gamma || contrast != Color.contrast || light != Color.light || rgbR != Color.rgbR || rgbG != Color.rgbG || rgbB != Color.rgbB) {
                        gamma = Color.gamma, contrast = Color.contrast, light = Color.light, rgbR = Color.rgbR, rgbG = Color.rgbG, rgbB = Color.rgbB;
                        Num();
                        $(this).dialog("close")
                    }
                    else {
                        $(this).dialog("close")
                    }
                }
            }]
        })
    }
    function tt() {
        r = n.getCurrentImage()
        Num();
        NowRGB();
    }
    function OpenImg() {
        n.drawer.UpdateUrl(gamma, contrast, light, rgbR, rgbG, rgbB)
        n.drawer.reset();
        n.drawer.update()
    }
    function rgb(n) {
        var t = 0;
        return t = (.02 * n) - 1,
    t
    }
    function g(n) {
        var t = 2;
        return t = (0.5 + (n * .01)).toFixed(2),
        t
    }
    function con(n) {
        var t = 1;
        return t = n * .02,
        t
    }
    function gb(n) {
        var t
        return t = (n - 0.5) / .01,
    t
    }
    function rb(n) {
        var t = 50;
        return t = (n + 1) / .02,
    t
    }
    function cb(n) {
        var t = 50;
        return t = n / .02,
    t
    }
    function NowRGB() {
        return Color = { gamma: gamma, contrast: contrast, light: light, rgbR: rgbR, rgbG: rgbG, rgbB: rgbB };   //打开图像调节时的图像数据
    }
    function Num() {
        var g = gb(gamma),
         c = cb(contrast);
        var n;
        $(a, i).slider({ value: g }),
        $(a + "Value").html(gamma),
        $(b, i).slider({ value: c }),
        $(b + "Value").html(Math.round((c / 100) * 200) + "%"),
        n = rb(light),
        $(w, i).slider({ value: n }),
        $(w + "Value").html(Math.round((n / 100) * 200) + "%"),
        n = rb(rgbR),
        $(rgb_r, i).slider({ value: n }),
        $(rgb_r + "Value").html(Math.round((n / 100) * 200) + "%"),
        n = rb(rgbG),
        $(rgb_g, i).slider({ value: n }),
        $(rgb_g + "Value").html(Math.round((n / 100) * 200) + "%"),
        n = rb(rgbB),
        $(rgb_b, i).slider({ value: n }),
        $(rgb_b + "Value").html(Math.round((n / 100) * 200) + "%");
    }

    var config = getGamma(), gamma = config.Gamma, contrast = config.Contrast, light = config.Light, rgbR = config.RgbR, rgbG = config.RgbG, rgbB = config.RgbB, i, ga = 1.5, co = 1, li = 0, rr = 0, rg = 0, rbb = 0;
    var id = "#demo", v, Color, Compare = { gamma: 1.5, contrast: 1, light: 0, rgbR: 0, rgbG: 0, rgbB: 0 }, //初始的图像数据
    a = "#gamma",
    rgb_r = "#red",
    rgb_g = "#green",
    rgb_b = "#blue",
    b = "#min",
    w = "#max",
     div = '<div id="demo" title="Adjust Image"> \t\t<fieldset> \t\t\t\t<legend data-lang="ImageAdjustments.Gamma">Gamma</legend> \t\t\t\t<div data-role="fieldcontain"> \t\t\t\t\t<table class="adjustment-table" ><tr><td class="adjust-td-text" ><label class="adjustment-slider-text" for="gamma" data-lang="ImageAdjustments.Factor">Factor</label></td> \t\t\t\t\t<td  class="adjustment-td-slider"><div id="gamma" class="adjustment-slider" data-role="slider"></div></td>\t\t\t\t\t<td class="adjustment-td-value" ><label id="gammaValue" class="adjustment-slider-value">1</label></td></tr></table> \t\t\t\t</div> \t\t</fieldset> \t\t<fieldset> \t\t\t<legend data-lang="ImageAdjustments.Contrast">Contrast</legend> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<table class="adjustment-table"><tr><td class="adjust-td-text"><label class="adjustment-slider-text" for="min" data-lang="ImageAdjustments.Contrast">对比度</label></td> \t\t\t\t<td class="adjustment-td-slider"><div id="min" class="adjustment-slider" data-role="slider"></div></td> \t\t\t\t<td class="adjustment-td-value"><label id="minValue" class="adjustment-slider-value">100%</label></td></tr></table> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<table class="adjustment-table"><tr><td class="adjust-td-text"><label class="adjustment-slider-text" for="max" data-lang="ImageAdjustments.Brightness">亮度</label></td> \t\t\t\t<td class="adjustment-td-slider"><div id="max" class="adjustment-slider" data-role="slider"></div></td> \t\t\t\t<td class="adjustment-td-value"><label id="maxValue" class="adjustment-slider-value">100%</label></td></tr></table> \t\t\t</div> \t\t</fieldset> \t\t<fieldset> \t\t\t<legend data-lang="ImageAdjustments.Channels">Channels</legend> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<table class="adjustment-table"><tr><td class="adjust-td-text"><label class="adjustment-slider-text" for="red" data-lang="ImageAdjustments.Red">Red</label></td> \t\t\t\t<td class="adjustment-td-slider"><div id="red" class="adjustment-slider" data-role="slider"></div></td> \t\t\t\t<td class="adjustment-td-value"><label id="redValue" class="adjustment-slider-value">50%</label></td></tr></table> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<table class="adjustment-table"><tr><td class="adjust-td-text"><label class="adjustment-slider-text" for="green" data-lang="ImageAdjustments.Green">Green</label></td> \t\t\t\t<td class="adjustment-td-slider"><div id="green" class="adjustment-slider" data-role="slider"></div></td> \t\t\t\t<td class="adjustment-td-value"><label id="greenValue" class="adjustment-slider-value">1</label></td></tr></table> \t\t\t</div> \t\t\t<div data-role="fieldcontain"> \t\t\t\t<table class="adjustment-table"><tr><td class="adjust-td-text"><label class="adjustment-slider-text" for="blue" data-lang="ImageAdjustments.Blue">Blue</label></td> \t\t\t\t<td class="adjustment-td-slider"><div id="blue" class="adjustment-slider" data-role="slider"></div></td> \t\t\t\t<td class="adjustment-td-value"><label id="blueValue" class="adjustment-slider-value">1</label></td></tr></table> \t\t\t</div> \t\t\t \t\t\ \t\t</fieldset> \t</div>';
    (function () {
        t();
    })(),
    this.show = function () {
        i.dialog("open");
    }
},
WebVersion = function (n) {
    function h() {
        t = $(div),
        t.appendTo($("body")).dialog({
            open: f,
            autoOpen: !1,
            resizable: !1,
            modal: !0,
            width: "600",
            height: "400"
        });
    };
    function f() {
        var a = $(".ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix");
        $(".ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix").hide();
    }
    var t, ver = getVer(), div = '<div id="Version" ><fieldset><div style="position:relative" ><img style="margin-top:15%" src="assets/image/web.png" alt=""><img src="assets/image/scanner.jpg" alt=""  style="width:300px;height:250px;float:right;margin-right:10px"/><label style="position:absolute;bottom:-100px;left:50px">Version ' + ver + '</label></div></fieldset><fieldset><div class="bj-jb"  style="margin-top:10px;height:60px;background-assets/image:url(assets/image/bjd.png);position:relative" ><img style="height:42px;width:115px;margin:15px;" src="assets/image/logo4.png"  alt="" /><label style="position:absolute;top:15px;right:10px;font-size:small;font-weight:normal;font-color:gray">北京优纳科技 科技因你而生</label><label style="position:absolute; bottom:2px;right:10px;font-size:small;font-weight:normal;font-color:gray"></label></div></fieldset></div>';
    (function () {
        h();
    })(),
this.show = function () {
    t.dialog("open");
}
}