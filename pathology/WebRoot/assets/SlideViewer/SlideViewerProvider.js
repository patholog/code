SlideResult = function () {
  this.Address, this.Width, this.Height, this.Rate, this.ID, this.DigitalSlidePath, this.FileNum, this.SlideAddress,
      this.TileSize, this.FileSize, this.ConsultID, this.UserID, this.CaseNo
};
var mCurrentSlideID = "";
var SlideViewerProvider;
(function () {
  SlideViewerProvider = function () {
    var e, WebServerPath, TileUrl;
    /*
    */
    var m_LevelCols = new Array();
    var m_LevelRows = new Array();

    function GetLevelTileNumbers(quotient, tileNumbers) {
      if (quotient > 1) {
        GetLevelTileNumbers(Math.ceil(quotient / 2.0), tileNumbers);
      }

      tileNumbers.push(quotient);
    }

    function CalLevelTiles(imageWidth, imageHeight) {
      GetLevelTileNumbers(Math.ceil(imageWidth * 1.0 / 256), m_LevelCols);
      GetLevelTileNumbers(Math.ceil(imageHeight * 1.0 / 256), m_LevelRows);

      var dif = m_LevelCols.length - m_LevelRows.length;

      if (dif > 0) {
        for (i = 0; i < dif; i++) {
          m_LevelRows.unshift(1);
        }
      } else if (dif < 0) {
        for (i = 0; i > dif; i--) {
          levelCols.unshift(1);
        }
      }

    }

    function ConvertToGroupNumber(level, x, y) {
      if (level < 0 || x < 0 || y < 0) {
        return 0;
      }

      var count = 0;

      for (i = 0; i < level; i++) {
        count += m_LevelCols[i] * m_LevelRows[i];
      }

      count += m_LevelCols[level] * y + (x + 1);
      var TileGroup = ((count - 1) / 256);
      return Math.floor(((count - 1) / 256));
    }

    //===============================================================================================================================

    function v(result, status) {
      i = new SlideResult;
      if (status === 'success') {
        if (result.responseText === "") {
          alert("无数字切片");
          return;
        }
        var SlideGroupArr = result.responseText.split('$');
        var SlideInfo = null;
        if (SlideGroupArr.length === 2) {
          SlideInfo = SlideGroupArr[0].split('|');
        } else {
          alert("无数字切片");
          return;
        }
        //alert(result.responseText);
        i.DigitalSlidePath = SlideInfo[9];
        i.Width = SlideInfo[1];
        i.Height = SlideInfo[2];
        i.Rate = SlideInfo[3];
        i.ID = SlideInfo[0];
        mCurrentSlideID = i.ID;

        TagBind(SlideInfo[0]);//harry 貌似没用哦

        var filemaxlength = Math.max(SlideInfo[1], SlideInfo[2]);
        var FileNum = Math.log(filemaxlength) % Math.log(2) == 0 ? parseInt(Math.log(filemaxlength) / Math.log(2)) : parseInt(Math.log(filemaxlength) / Math.log(2)) + 1;
        i.FileNum = FileNum;
        i.SlideAddress = "";

        i.TileSize = SlideInfo[4];
        i.FileSize = SlideInfo[7];
        i.ScanTime = SlideInfo[5];
        i.SpeedTime = SlideInfo[6];
        i.ScanMac = SlideInfo[8];
        //i.DigitalSlidePath = SlideInfo[9];
        i.ConsultID = "";
        if (SlideInfo[3] === "20")
          i.calibration = "0.5";
        else
          i.calibration = "0.2439";
        i.UserID = getcookie("UserID");
        i.CaseNo = getQueryString("caseId");
        var url = getthumbnail(i);//[i.DigitalSlidePath,"/TileGroup0/0-0-0.jpg"].join("");
        //var url = i.DigitalSlidePath.toLowerCase().replace("decodetile.aspx", "getqiepianimg.aspx");
        $("#xinxi").attr("src", url + "&zoom=01&PositionX=0&PositionY=0");

        var SlideGroup = "";
        //for (var j = 10; j < SlideInfo.length; j++) { //modified by harry at 20150713
        var CurrentSlideInfoArr = SlideGroupArr[1].split('#');
        for (var j = 0; j < CurrentSlideInfoArr.length; j++) {
          if (CurrentSlideInfoArr[j] !== "") {
            var slide = CurrentSlideInfoArr[j].split('|');
            SlideGroup += slide[0] + "|" + slide[9] + '#';
            var a1 = document.getElementById("slide" + slide[0]);
            if (a1)
              a1.setAttribute('style', 'margin-top:5px;');
          }
        }
        var a2 = document.getElementById("slide" + mCurrentSlideID);
        if (a2)
          a2.setAttribute('style', 'border: 1px solid red;margin-top:5px;');
        //if (SlideGroup.length > 0) {
        //    SlideGroup = SlideGroup.substr(0, SlideGroup.length - 1);
        //}
        //SlideBind(SlideGroup);
        if (typeof e === "function") {
          //e=rrBack
          e(i);
        }
      }

    }

    function getthumbnail(i) {
      var url = i.DigitalSlidePath;
      if (url) {
        url = url.toLowerCase();
        if (url.indexOf("filename=") >= 0) {
          url = i.DigitalSlidePath;
          var port = window.location.port;
          if (port !== null && port !== '' && port !== "80") {
          } else {
            if (WebReLocation !== '' && document.location.href.indexOf('/unic/') > 0) {
              tt = i.DigitalSlidePath.split('decodetile.aspx');
              url = "http://" + window.location.host + "/unic/decodetile/decodetile.aspx" + tt[1];
            }
          }
          return url.replace("decodetile.aspx", "getqiepianimg.aspx");
        } else {
          CalLevelTiles(i.Width, i.Height);
          return [url, "/TileGroup0/0-0-0.jpg"].join("");
        }
      } else {
        return "";
      }
    }

    function getcookie(name) {
      var cookie_start = document.cookie.indexOf(name);
      var cookie_end = document.cookie.indexOf(";", cookie_start);
      return cookie_start === -1 ? '' : unescape(document.cookie.substring(cookie_start + name.length + 1, (cookie_end > cookie_start ? cookie_end : document.cookie.length)));
    }

    function TagBind(id) {

      var host = window.location.host;
      var ProxyIP = getQueryString("ProxyIP");
      var SlidePath = getQueryString("SlidePath");
      if (ProxyIP !== "") {
        ProxyIP = "&ProxyIP=" + ProxyIP;
      }
      url = "../LabelHandler.ashx?ID=" + id + ProxyIP;   //url

      if (document.getElementById("labelImage")) {
        document.getElementById("labelImage").src = url;
      }
    }

    function SlideBind(SeaViewer) {
      var Slidelists = SeaViewer.split("#");
      var ThumnailUrl, LabelUrl;
      var ClickourTouch = "";
      if (Slidelists.length === 1) {
        if (document.getElementById("SlideLists"))
          document.getElementById("SlideLists").style.display = "none";
        if (document.getElementById("slides"))
          document.getElementById("slides").style.display = "none";
        //harry at 201507
//                                if (document.getElementById("ShotLists") != null) {
//                                    document.getElementById("ShotLists").style.bottom = "55px";
//                                 
//                                    if(document.getElementById("jtlb"))
//                                       document.getElementById("jtlb").style.bottom = "265px"; 
//                                            if(document.getElementById("shot"))
//                                    document.getElementById("shot").style.bottom = "55px";
//                                }
      } else {
        if (document.getElementById("SlideLists")) {
          document.getElementById("SlideLists").style.display = "inline";
        }
        if (document.getElementById("slides")) {
          document.getElementById("slides").style.display = "inline";
        }
//                                if (document.getElementById("ShotLists"))
//                                    document.getElementById("ShotLists").style.bottom = "480px";
//                                if (document.getElementById("jtlb"))
//                                    document.getElementById("jtlb").style.bottom = "490px";
//                                if (document.getElementById("shot"))
//                                    document.getElementById("shot").style.bottom = "280px";
      }
      for (var i = 0; i < Slidelists.length; i++) {
//                var path = "";
//                path = Slidelists[i].replace(new RegExp(/(\\)/g), '\\\\');
//                if (isMobile() == true) {
//                    ClickourTouch = "href=\"JavaScript:void(0)\" ontouchstart=\"Frms('" + path + "') \"";
//                } else {
//                    ClickourTouch = "onclick=\"Frms('" + path + "') \"";
//                }
//                var ProxyIP = getQueryString("ProxyIP");
//                if (ProxyIP != "") {
//                    ProxyIP = "&ProxyIP=" + ProxyIP;
//                }
        var thumnailarr = Slidelists[i].split('|');
        if (thumnailarr.length === 2) {
          if (isMobile() === true) {
            ClickourTouch = "href=\"JavaScript:void(0)\" ontouchstart=\"Frms('" + thumnailarr[0] + "') \"";
          } else {
            ClickourTouch = "onclick=\"Frms('" + thumnailarr[0] + "') \"";
          }
          ThumnailUrl = thumnailarr[1] + "&level=0&xpos=0&ypos=0";
          var fileNames = thumnailarr[1];
          var fileN = thumnailarr[1].split('filename=');
          if (fileN.length === 2) {
            fileNames = fileN[1];
          }
          div = "<li class=\"dataItem-img\"><a " + ClickourTouch + " title='" + fileNames + "'><img alt='" + thumnailarr[1] + "' style=\"margin-top:5px;\" src=\"" + ThumnailUrl + "\"  /></a></li>";
          $("#SlideUl").append(div);
        }
      }
    }

    this.GetImageInfo = function (SlideId, i) {
      // i=rrBack
      WebServerPath = WebServerUrl + "OpenSlideHandler";
      e = typeof i === "function" ? i : null;
      var SlideIDs = "";
      var Case_No = "";
      var SlideDID = "";
      SlideIDs = SlideId;//getQueryString("SlideID");
      Case_No = getQueryString("caseId");
      SlideDID = getQueryString("SlideDID");
      if (Case_No !== "" && Case_No !== null) {
        Case_No = "&caseId=" + Case_No;
      }
      if (SlideIDs !== "" && SlideIDs !== null) {
        SlideIDs = "&SlideID=" + SlideIDs;
      }
      if (SlideDID !== "" && SlideDID !== null) {
        SlideDID = "&SlideDID=" + SlideDID;
      }

      var ProxyIP = getQueryString("ProxyIP");
      if (ProxyIP !== "") {
        ProxyIP = "&ProxyIP=" + ProxyIP;
      }
      var SlidePath = getQueryString("SlidePath");
      if (SlidePath !== "") {
        SlidePath = "&SlidePath=" + escape(SlidePath);
      }

      var u = WebServerPath + "?type=unic" + Case_No + SlideIDs + SlideDID + ProxyIP + SlidePath;
      $.ajax({
        type: "POST",
        url: u,
        data: "",
        cache: false,
        async: true,
        dataType: "text",
        complete: v
      });
    };
    this.updateImageAdjustment = function (n, i, r, u) {
      function e(n, t) {
        var i = new UpdateResult;
        t === "success" ? i.success = !0 : i.error = t,
        f && f(i)
      }

      var f = typeof u === "function" ? u : null,
          s = [t, "?op=UpdateImageAdjustmentDocument"].join(""),
          o = '<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">                                 <soap:Body>                                     <UpdateImageAdjustmentDocument xmlns="http://www.motic.com/">                                         <slideId>' + n + "</slideId>                                          <imgId>" + i + "</imgId>                                          <doc>" + c(r) + "</doc>                                     </UpdateImageAdjustmentDocument>                                 </soap:Body>                                 </soap:Envelope>";
      $.ajax({
        url: s,
        type: "POST",
        dataType: "xml",
        data: o,
        complete: e,
        contentType: 'text/xml; charset="utf-8"'
      })
    };
    /**
     * 获取缩放图片
     * 被SeadragonLiYTileSource.js调用
     */
    this.getTileUrl = function (slideKey, level, PositionX, PositionY, FileNum, ID, TileSize, gamma, contrast, light, r, g, b, DigitalSlidePath) {
      var str0 = [DigitalSlidePath, "/TileGroup", group, "/", mlevel, "-", PositionX, "-", PositionY, ".jpg"].join("");
      //str0 = [DigitalSlidePath, "&level=", level - 8, "&xpos=", PositionX, "&ypos=", PositionY].join("");
      //http://121.8.170.75:5597/decodetile/decodetile.aspx?filename=201533575-1-2_20151204-085321&level=0&xpos=0&ypos=0
      var url = DigitalSlidePath.toLowerCase();
      if (url.indexOf("filename=") >= 0) {
        url = DigitalSlidePath;
        var port = window.location.port;
        if (port !== null && port !== '' && port !== "80") {
        } else {
          if (WebReLocation !== '' && document.location.href.indexOf('/unic/') > 0) {
            tt = DigitalSlidePath.split('decodetile.aspx');
            url = "http://" + window.location.host + "/unic/decodetile/decodetile.aspx" + tt[1];
          }
        }
        mCurrentLevel = level - 8;
        var zoom;
        if (level < 10) {
          zoom = '0' + level;
        } else {
          zoom = level;
        }
        str0 = [url, "&zoom=", zoom, '&level=', mCurrentLevel, "&PositionX=", PositionX, "&PositionY=", PositionY].join("");
      } else {
        var mlevel = level > 8 ? level - 8 : 0;
        if (level > 6 && mlevel < m_LevelCols.Length) {
        }
        var group = ConvertToGroupNumber(mlevel, PositionX, PositionY);
        str0 = [url, "/TileGroup", group, "/", mlevel, "-", PositionX, "-", PositionY, ".jpg"].join("");
      }

      return str0;
    };
    /**
     * 获取缩略图（左上角）
     */
    this.getThumbnailUrl = function (slideKey, FileNum, ID, TileSize, gamma, contrast, light, r, g, b, DigitalSlidePath) {
      var str0 = [DigitalSlidePath, "/TileGroup0/0-0-0.jpg"].join("");
      //var str0 = [DigitalSlidePath, "&level=", 0, "&xpos=", 0, "&ypos=", 0].join("");

      var url = DigitalSlidePath.toLowerCase();
      if (url.indexOf("filename=") >= 0) {
        url = DigitalSlidePath;
        var port = window.location.port;
        if (port !== null && port !== '' && port !== "80") {
        } else {
          if (WebReLocation !== '' && document.location.href.indexOf('/unic/') > 0) {
            tt = DigitalSlidePath.split('decodetile.aspx');
            url = "http://" + window.location.host + "/unic/decodetile/decodetile.aspx" + tt[1];
          }
        }

        url = url.toLowerCase().replace("decodetile.aspx", "getqiepianimg.aspx");

        str0 = [url, "&zoom=01&PositionX=0&PositionY=0&type=", 2].join("");
      } else {
        str0 = [url, "/TileGroup0/0-0-0.jpg"].join("");
      }
      return str0;
    };
    this.getLabelUrl = function (t, i) {
      return [n, "SlideImage.ashx?", "ID=", t, "&ImageId=", i, "&Type=Label"].join("")
    };

  }
})();