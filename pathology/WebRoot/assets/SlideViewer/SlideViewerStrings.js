var SlideViewerStrings;
(function () {
    function t() {
        var t = SlideViewerConfig.language,
        i;
        return n[t] ? n[t] : ((t === undefined || t === null || t === "" || t === "auto") && (t = window.navigator.userLanguage || window.navigator.language), i = t.split("-"), t = i[0], n[t] || (t = "en"), SlideViewerConfig.language = t, n[t])
    }
    if (!SlideViewerStrings) {
        SlideViewerStrings = {};
        var n = {
            en: {
                Buttons: {
                    Annotation: "Annotations",
                    ImageAdjustment: "Adjust Image",
                    Options: "Options",
                    Edit: "Edit",
                    Delete: "Delete",
                    AnnotationList: "List",
                    Back: "Back",
                    Ok: "Ok",
                    Cancel: "Cancel",
                    Yes: "Yes",
                    No: "No",
                    Reset: "Reset",
                    Finish: "Finish",
                    Save: "Save",
                    On: "On",
                    Off: "Off",
                    AutoShow: "Show Automatically",
                    apply:"apply",
                    compare:"compare"
                },
                Labels: {
                    AnnotationType: "Annotations:"
                },
                Tooltips: {
                    BtnBackToBase: "Back to base image",
                    BtnHome: "Fit to view window",
                    ZoomIn: "Zoom In",
                    ZoomOut: "Zoom Out"
                },
                Messages: {
                    SaveSuccess: "Save Successfully.",
                    SaveFailed: "Save Failed.",
                    ExitConfirm: "The slide's data has been changed, do you want to exit without saving ?",
                    SaveAdjustmentSuccess: "Save image adjustment successfully.",
                    SaveAdjustmentFailed: "Save image adjustment failed.",
                    SaveAnnotationSuccess: "Save annotations successfully.",
                    SaveAnnotationFailed: "Save annotations failed."
                },
                ImageAdjustments: {
                    Title: "Adjust Image",
                    Gamma: "Gamma",
                    Factor: "Factor",
                    MinInput: "Min Input",
                    MaxInput: "MaxInput",
                    Contrast: "Contrast",
                    Channels: "Color",
                    Red: "Red",
                    Green: "Green",
                    Blue: "Blue",
                    AllChannels: "All Channels",
                    SS: "Sharpness & Saturation",
                    Saturation: "Saturation",
                    Sharpness: "Sharpness"
                },
                Annotations: {
                    Draw: {
                        Line: "Draw Line",
                        Arrow: "Draw Arrow",
                        Rectangle: "Draw Rectangle",
                        Ellipse: "Draw Ellipse",
                        Remark: "Add Remark",
                        Position: "Add Position",
                        CurveRounded: "Draw Closed Curve",
                        Curve: "Draw Curve",
                        Angle: "Draw Angle by 3 Points",
                        Circle: "Draw Circle",
                        CircleThreePoints: "Draw Circle by 3 points",
                        Arc: "Draw Arc by 3 points",
                        Polygon: "Draw Polygon"
                    },
                    Dialog: {
                        Title: "Edit Annotation",
                        LineWidth: "Line Width:",
                        Name: "Name:",
                        Description: "Description:",
                        Color: "Color:"
                    },
                    Measurement: {
                        TxtLength: "Length:",
                        TxtWidth: "Width:",
                        TxtHeight: "Height:",
                        TxtAngle: "Angle:",
                        TxtArcLength: "Arc Length:",
                        TxtArea: "Area:",
                        TxtMajorhalfaxis: "Major half axis:",
                        TxtMinorhalfaxis: "Minor half axis:",
                        TxtPerimeter: "Perimeter:",
                        TxtRadius: "Radius:",
                        TxtDescription: "Description:",
                        TxtUnit: " um",
                        TxtAreaUnit: " squm",
                        TxtDeg: " Deg"
                    },
                    Default: {
                        Name: "New Annotation",
                        Description: "Description"
                    },
                    AskSave: {
                        Title: "Save Annotations",
                        Message: "Annotations have been changed, do you want to save ?"
                    }
                },
                Options: {
                    Title: "Options",
                    NavMap: "Nav Map:",
                    Compact: "Compact:",
                    Ruler: "Ruler:",
                    Grid: "Grid:",
                    Label: "Label:"
                },
                Compact: {
                    Title: "Compact Browsing",
                    Message: "This function is disabled in compact browsing. You can go to [Options] to turn it off."
                },
                NotSupported: {
                    Title: "Not Supported",
                    Message: 'It seems this function is not supported well on your browser. Please use the latest <a href="https://www.google.com/chrome" target="_blank">Chrome</a>, <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> or <a href="http://www.apple.com/safari/" target="_blank">Safari</a> for a better browsing experience.'
                }
            },
            zh: {
                Buttons: {
                    Annotation: "\u6807\u6ce8",
                    ImageAdjustment: "\u56fe\u50cf\u8c03\u8282",
                    Options: "\u9009\u9879",
                    Edit: "\u7f16\u8f91",
                    Delete: "\u5220\u9664",
                    AnnotationList: "\u6807\u6ce8\u5217\u8868",
                    Back: "\u8fd4\u56de",
                    Ok: "\u786e\u5b9a",
                    Cancel: "\u53d6\u6d88",
                    Yes: "\u662f",
                    No: "\u5426",
                    Reset: "\u91cd\u7f6e",
                    Finish: "\u5b8c\u6210",
                    Save: "\u4fdd\u5b58",
                    On: "\u5f00",
                    Off: "\u5173",
                    AutoShow: "\u81ea\u52a8\u663e\u793a\u003a",
                    apply:"\u5e94\u7528",
                    compare:"\u6bd4\u8f83"
                },
                Labels: {
                    AnnotationType: "\u6807\u6ce8\u7c7b\u578b\uff1a"
                },
                Tooltips: {
                    BtnBackToBase: "\u8fd4\u56de\u9996\u9875",
                    BtnHome: "\u81ea\u9002\u5e94\u7a97\u53e3",
                    ZoomIn: "\u653e\u5927",
                    ZoomOut: "\u7f29\u5c0f"
                },
                Messages: {
                    SaveSuccess: "\u4fdd\u5b58\u6210\u529f\u3002",
                    SaveFailed: "\u4fdd\u5b58\u5931\u8d25\uff01",
                    ExitConfirm: "\u5207\u7247\u7684\u6570\u636e\u5df2\u7ecf\u6539\u53d8\uff0c\u662f\u5426\u76f4\u63a5\u9000\u51fa\uff1f",
                    SaveAdjustmentSuccess: "\u56fe\u50cf\u8c03\u8282\u4fdd\u5b58\u6210\u529f\u3002",
                    SaveAdjustmentFailed: "\u56fe\u50cf\u8c03\u8282\u4fdd\u5b58\u5931\u8d25\u3002",
                    SaveAnnotationSuccess: "\u6807\u6ce8\u4fdd\u5b58\u6210\u529f\u3002",
                    SaveAnnotationFailed: "\u6807\u6ce8\u4fdd\u5b58\u5931\u8d25\u3002"
                },
                ImageAdjustments: {
                    Title: "\u8c03\u8282\u56fe\u50cf",
                    Gamma: "\u4f3d\u9a6c\u56e0\u5b50",
                    Factor: "\u4f3d\u9a6c\u56e0\u5b50",
                    Contrast: "\u5bf9\u6bd4\u5ea6",
                    MinInput: "\u6700\u5c0f\u503c",
                    MaxInput: "\u6700\u5927\u503c",
                    Channels: "\u989c\u8272\u901a\u9053",
                    Red: "\u7ea2",
                    Green: "\u7eff",
                    Blue: "\u84dd",
                    AllChannels: "\u6240\u6709\u901a\u9053",
                    SS: "\u9510\u5ea6\u548c\u9971\u548c\u5ea6",
                    Saturation: "\u9971\u548c\u5ea6",
                    Sharpness: "\u9510\u5ea6",
                    Brightness:"\u4eae\u5ea6",
                    Contrast:"\u5bf9\u6bd4\u5ea6"

                },
                Annotations: {
                    Draw: {
                        Line: "\u76f4\u7ebf",            //\u7ed8\u5236\u76f4\u7ebf
                        Arrow: "\u7bad\u5934",
                        Rectangle: "\u77e9\u5f62",
                        Ellipse: "\u692d\u5706",
                        Remark: "\u6587\u672c\u6ce8\u91ca",
                        Position: "\u6807\u8bb0",
                        CurveRounded: "\u7ed8\u5236\u95ed\u5408\u66f2\u7ebf",
                        Curve: "\u66f2\u7ebf",
                        Angle: "\u4e09\u70b9\u753b\u89d2\u5ea6",
                        Circle: "\u7ed8\u5236\u5706",
                        CircleThreePoints: "\u4e09\u70b9\u753b\u5706",
                        Arc: "\u4e09\u70b9\u753b\u5f27",
                        Polygon: "\u7ed8\u5236\u591a\u8fb9\u5f62"
                    },
                    Dialog: {
                        Title: "\u7f16\u8f91\u6807\u6ce8",
                        LineWidth: "\u7ebf\u6761\u5bbd\u5ea6\uff1a",
                        Name: "\u540d\u79f0\uff1a",
                        Description: "\u63cf\u8ff0\uff1a",
                        Color: "\u989c\u8272\uff1a"
                    },
                    Measurement: {
                        TxtLength: "\u957f\u5ea6\uff1a",
                        TxtWidth: "\u5bbd\uff1a",
                        TxtHeight: "\u9ad8\uff1a",
                        TxtAngle: "\u89d2\u5ea6\uff1a",
                        TxtArcLength: "\u5f27\u957f\uff1a",
                       TxtArea: "\u9762\u79ef\uff1a",
                        TxtMajorhalfaxis: "\u957f\u534a\u8f74\uff1a",
                        TxtMinorhalfaxis: "\u77ed\u534a\u8f74\uff1a",
                        TxtPerimeter: "\u5468\u957f\uff1a",
                        TxtRadius: "\u534a\u5f84\uff1a",
                        TxtDescription: "\u63cf\u8ff0\uff1a",
                        TxtUnit: " \u5fae\u7c73",
                        TxtAreaUnit: " \u5e73\u65b9\u5fae\u7c73",
                        TxtDeg: " \u5ea6"
                    },
                    Default: {
                        Name: "\u65b0\u6807\u6ce8",
                        Description: "\u8bf7\u8f93\u5165"
                    },
                    AskSave: {
                        Title: "\u4fdd\u5b58\u6807\u6ce8",
                        Message: "\u6807\u6ce8\u5df2\u7ecf\u6539\u53d8\uff0c\u662f\u5426\u4fdd\u5b58\uff1f"
                    }
                },
                Options: {
                    Title: "\u9009\u9879",
                    NavMap: "\u5bfc\u822a\u56fe\uff1a",
                    Compact: "\u7cbe\u7b80\u6a21\u5f0f\uff1a",
                    Ruler: "\u6807\u5c3a\uff1a",
                    Grid: "\u7f51\u683c\uff1a",
                    Label: "\u6807\u7b7e\uff1a"
                },
                Compact: {
                    Title: "\u7cbe\u7b80\u6a21\u5f0f",
                    Message: "\u7cbe\u7b80\u6a21\u5f0f\u4e0b\u8be5\u529f\u80fd\u662f\u5173\u95ed\u7684\u3002\u60a8\u53ef\u4ee5\u5230 \u3010\u9009\u9879\u3011 \u5173\u95ed\u7cbe\u7b80\u6a21\u5f0f\u3002"
                },
                NotSupported: {
                    Title: "\u4e0d\u652f\u6301",
                    Message: '\u60a8\u7684\u6d4f\u89c8\u5668\u8fd8\u4e0d\u80fd\u5f88\u597d\u7684\u652f\u6301\u6b64\u529f\u80fd\uff0c\u8bf7\u4f7f\u7528\u6700\u65b0\u7684 <a href="https://www.google.com/chrome" target="_blank">Chrome</a>, <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> \u6216 <a href="http://www.apple.com/safari/" target="_blank">Safari</a> \u6d4f\u89c8\u5668\u4ee5\u83b7\u5f97\u66f4\u597d\u7684\u4f53\u9a8c\u3002'
                },
                MainMenu:{
                ScreenShot:"\u622a\u56fe",
                ShotList:"\u622a\u56fe\u5217\u8868",
                Others:"\u9690\u85cf",//隐藏
                Abouts:"\u5173\u4e8e",               
               NavMap:"\u5bfc\u822a\u56fe",//导航图
                Tag:"\u6807\u7b7e",//标签
                Ruler:"\u6bd4\u4f8b\u5c3a",//比例尺
                CaseInfo:"\u75c5\u4f8b\u4fe1\u606f",//病例信息
                AnnotationOption:"\u6ce8\u91ca\u7ba1\u7406",//注释管理
                ImageInfo:"\u56fe\u50cf\u4fe1\u606f"//图像信息
                }
                
            }
        };
        SlideViewerStrings.getString = function (n) {
            for (var f = n.split("."), i = t(), u, r = 0; r < f.length; r++) i = i[f[r]] || {};
            return typeof i != "string" && (i = ""),
            u = arguments,
            i.replace(/\{\d+\}/g,
            function (n) {
                var t = parseInt(n.match(/\d+/)) + 1;
                return t < u.length ? u[t] : ""
            })
        }
//        SlideViewerStrings.getSwitchCut=function(name)
//        {
//        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
//        var r = window.location.search.substr(1).match(reg);
//        if (r != null)
//        return unescape(r[2]);
//        return null;
//        }
    }
})();