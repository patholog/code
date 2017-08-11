
function GetSlideList(caseno, SlideId)   //i=rrBack
{
    WebServerPath = WebServerUrl + "OpenSlideHandler.ashx";
    e = typeof i == "function" ? i : null;
    var SlideIDs = "";
    var Case_No = "";
    var SlideDID = "";
    SlideIDs = SlideId; // getQueryString("SlideID");
    Case_No = caseno; // getQueryString("caseno");
    //SlideDID = getQueryString("SlideDID");
    if (Case_No != "" && Case_No != null) {
        Case_No = "&CaseNo=" + Case_No;
    }
    if (SlideIDs != "" && SlideIDs != null) {
        SlideIDs = "&SlideID=" + SlideIDs;
    }
    var SlidePath = getQueryString("SlidePath");
    if (SlidePath != "")
        SlidePath = "&SlidePath=" + escape(SlidePath);
    var u = WebServerPath + "?type=unic" + Case_No + SlidePath+SlideIDs;
    $.ajax({
        type: "POST",
        url: u,
        data: "",
        cache: false,
        async: true,
        dataType: "text",
        success: function (result) {
            ParseSlideInfo(result);
        }
    });
}

function ParseSlideInfo(result) {
    if (result == "") {
        //alert("无数字切片");
        return;
    }
    /*
    */
    var SlideGroupArr = result.split('$');
    var SlideInfoList = null;
    if (SlideGroupArr.length == 2)
        SlideInfoList = SlideGroupArr[1];
    else {
        //alert("无数字切片");
        return;
    }

    var SlideGroup = "";
    //var CurrentSlideInfoArr = result.split('#');
    var CurrentSlideInfoArr = SlideInfoList.split('#');
    for (var j = 0; j < CurrentSlideInfoArr.length; j++) {
        if (CurrentSlideInfoArr[j] != "") {
            var slide = CurrentSlideInfoArr[j].split('|');
            SlideGroup += slide[0] + "|" + slide[9] + '#';
        }
    }
    if (SlideGroup.length > 0) {
        SlideGroup = SlideGroup.substr(0, SlideGroup.length - 1);
    }
    SlideBind(SlideGroup);
}

function SlideBind(SeaViewer) {
    var Slidelists = SeaViewer.split("#");
    var ThumnailUrl, LabelUrl;
    var ClickourTouch = "";
    if (Slidelists.length == 1) {
        if (document.getElementById("SlideLists"))
            document.getElementById("SlideLists").style.display = "none";
        if (document.getElementById("slides"))
            document.getElementById("slides").style.display = "none";
    }
    else {
        if (document.getElementById("SlideLists")) {
            document.getElementById("SlideLists").style.display = "inline";
        }
        if (document.getElementById("slides")) {
            document.getElementById("slides").style.display = "inline";
        }
    }
    for (var i = 0; i < Slidelists.length; i++) {
        var thumnailarr = Slidelists[i].split('|');
        if (thumnailarr.length == 2) {
            if (isMobile() == true) {
                ClickourTouch = "href=\"JavaScript:void(0)\" ontouchstart=\"GotoSlide('" + thumnailarr[0] + "');\"";
            } else {
                ClickourTouch = "onclick=\"GotoSlide('" + thumnailarr[0] + "');\"";
            }
            ThumnailUrl = thumnailarr[1] + "&level=0&xpos=0&ypos=0";
            var port = window.location.port;
            if (port != null && port != '' && port != "80") {

            }
            else {
                if (WebReLocation != '' && document.location.href.indexOf('/unic/') > 0) {
                    tt = ThumnailUrl.split('decodetile.aspx');
                    ThumnailUrl = "http://" + window.location.host + "/unic/decodetile/decodetile.aspx" + tt[1];
                }
            }

            var fileNames = thumnailarr[1];
            var fileN = thumnailarr[1].split('filename=');
            if (fileN.length == 2) {
                fileNames = fileN[1];
            }
            // 
            div = "<li class=\"dataItem-img\" style=\"position:relative;\"><a " + ClickourTouch + " title='" + fileNames+"("+thumnailarr[0] + ")'><img id='slide" + thumnailarr[0] + "' alt='" + thumnailarr[1] + "' style=\"margin-top:5px;\" src=\"" + ThumnailUrl + "\"  />";
            div += "<div style=\"position: absolute; background:rgba(0,0,0,0.3);width:67px;height:20px;left:0;bottom:6px;z-index:999\">";
            div += "<div style=\" text-align:center;line-height:20px; color:#fff;font-size:16px; display:block;font-weight:bold;\">" + (i + 1) + "/" + Slidelists.length + "</div>";
            div += "</div>";

            div += "</a></li>";
            $("#SlideUl").append(div);
        }
    }
};
