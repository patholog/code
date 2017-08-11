window.Seadragon || (window.Seadragon = {});
var Seadragon = window.Seadragon;
var SeadragonConfig = Seadragon.Config;
(function () {
    SeadragonConfig || (SeadragonConfig = Seadragon.Config = {
        debugMode: !1,
        animationTime: 1.5,
        blendTime: .5,
        alwaysBlend: !1,
        autoHideControls: !0,
        constrainDuringPan: !0,
        immediateRender: !1,
        logarithmicZoom: !0,
        wrapHorizontal: !1,
        wrapVertical: !1,
        wrapOverlays: !1,
        transformOverlays: !1,
        minZoomDimension: null,
        minZoomImageRatio: .8,
        maxZoomPixelRatio: 2,
        visibilityRatio: .8,
        springStiffness: 5,
        imageLoaderLimit: 2,
        clickTimeThreshold: 200,
        clickDistThreshold: 5,
        zoomPerClick: 2,
        zoomPerScroll: Math.pow(2, 1 / 3),
        zoomPerSecond: 2,
        proxyUrl: null,
        imagePath: "img/"
    })
})();
var SeadragonStrings = Seadragon.Strings;
(function () {
    SeadragonStrings || (SeadragonStrings = Seadragon.Strings = {
        Errors: {
            Failure: "Sorry, but Seadragon Ajax can't run on your browser!\nPlease try using IE 8 or Firefox 3.\n",
            Dzc: "Sorry, we don't support Deep Zoom Collections!",
            Dzi: "Hmm, this doesn't appear to be a valid Deep Zoom Image.",
            Xml: "Hmm, this doesn't appear to be a valid Deep Zoom Image.",
            Empty: "You asked us to open nothing, so we did just that.",
            ImageFormat: "Sorry, we don't support {0}-based Deep Zoom Images.",
            Security: "It looks like a security restriction stopped us from loading this Deep Zoom Image.",
            Status: "This space unintentionally left blank ({0} {1}).",
            Unknown: "Whoops, something inexplicably went wrong. Sorry!"
        },
        Messages: {
            Loading: "Loading..."
        },
        Tooltips: {
            FullPage: "Toggle full page",
            Home: "Go home",
            ZoomIn: "Zoom in (you can also use your mouse's scroll wheel)",
            ZoomOut: "Zoom out (you can also use your mouse's scroll wheel)"
        }
    }, SeadragonStrings.getString = function (n) {
        for (var u = n.split("."), t = SeadragonStrings, r, i = 0; i < u.length; i++) t = t[u[i]] || {};
        return typeof t != "string" && (t = ""), r = arguments, t.replace(/\{\d+\}/g, function (n) {
            var t = parseInt(n.match(/\d+/)) + 1;
            return t < r.length ? r[t] : ""
        })
    }, SeadragonStrings.setString = function (n, t) {
        for (var r = n.split("."), u = SeadragonStrings, i = 0; i < r.length - 1; i++) u[r[i]] || (u[r[i]] = {}), u = u[r[i]];
        u[r[i]] = t
    })
})();
var SeadragonDebug = function () {
    this.log = function (n, t) {
        var r = window.console || {},
				i = SeadragonConfig.debugMode;
        i && r.log ? r.log(n) : i && t && alert(n)
    }, this.error = function (n, t) {
        var r = window.console || {},
				i = SeadragonConfig.debugMode;
        if (i && r.error ? r.error(n) : i && alert(n), i) throw t || new Error(n);
    }, this.fail = function (n) {
        alert(SeadragonStrings.getString("Errors.Failure"));
        throw new Error(n);
    }
};
SeadragonDebug = Seadragon.Debug = new SeadragonDebug;
var SeadragonProfiler = Seadragon.Profiler = function () {
    var c = this,
			t = !1,
			n = 0,
			e = null,
			h = null,
			o = Infinity,
			r = 0,
			i = 0,
			f = Infinity,
			u = 0,
			s = 0;
    this.getAvgUpdateTime = function () {
        return r
    }, this.getMinUpdateTime = function () {
        return o
    }, this.getMaxUpdateTime = function () {
        return i
    }, this.getAvgIdleTime = function () {
        return u
    }, this.getMinIdleTime = function () {
        return f
    }, this.getMaxIdleTime = function () {
        return s
    }, this.isMidUpdate = function () {
        return t
    }, this.getNumUpdates = function () {
        return n
    }, this.beginUpdate = function () {
        if (t && c.endUpdate(), t = !0, e = +new Date, !(n < 1)) {
            var i = e - h;
            u = (u * (n - 1) + i) / n, i < f && (f = i), i > s && (s = i)
        }
    }, this.endUpdate = function () {
        if (t) {
            h = +new Date, t = !1;
            var u = h - e;
            n++, r = (r * (n - 1) + u) / n, u < o && (o = u), u > i && (i = u)
        }
    }, this.clearProfile = function () {
        t = !1, n = 0, e = null, h = null, o = Infinity, r = 0, i = 0, f = Infinity, u = 0, s = 0
    }
};
var SeadragonPoint = Seadragon.Point;
(function () {
    if (!SeadragonPoint) {
        SeadragonPoint = Seadragon.Point = function (n, t) {
            this.x = typeof n == "number" ? n : 0, this.y = typeof t == "number" ? t : 0
        };
        var n = SeadragonPoint.prototype;
        n.plus = function (n) {
            return new SeadragonPoint(this.x + n.x, this.y + n.y)
        }, n.minus = function (n) {
            return new SeadragonPoint(this.x - n.x, this.y - n.y)
        }, n.times = function (n) {
            return new SeadragonPoint(this.x * n, this.y * n)
        }, n.divide = function (n) {
            return new SeadragonPoint(this.x / n, this.y / n)
        }, n.negate = function () {
            return new SeadragonPoint(-this.x, -this.y)
        }, n.distanceTo = function (n) {
            return Math.sqrt(Math.pow(this.x - n.x, 2) + Math.pow(this.y - n.y, 2))
        }, n.apply = function (n) {
            return new SeadragonPoint(n(this.x), n(this.y))
        }, n.equals = function (n) {
            return n instanceof SeadragonPoint && this.x === n.x && this.y === n.y
        }, n.toString = function () {
            return "(" + this.x + "," + this.y + ")"
        }
    }
})();
var SeadragonRect = Seadragon.Rect;
(function () {
    if (!SeadragonRect) {
        SeadragonRect = Seadragon.Rect = function (n, t, i, r) {
            this.x = typeof n == "number" ? n : 0, this.y = typeof t == "number" ? t : 0, this.width = typeof i == "number" ? i : 0, this.height = typeof r == "number" ? r : 0
        };
        var n = SeadragonRect.prototype;
        n.getAspectRatio = function () {
            return this.width / this.height
        }, n.getTopLeft = function () {
            return new SeadragonPoint(this.x, this.y)
        }, n.getBottomRight = function () {
            return new SeadragonPoint(this.x + this.width, this.y + this.height)
        }, n.getCenter = function () {
            return new SeadragonPoint(this.x + this.width / 2, this.y + this.height / 2)
        }, n.getSize = function () {
            return new SeadragonPoint(this.width, this.height)
        }, n.equals = function (n) {
            return n instanceof SeadragonRect && this.x === n.x && this.y === n.y && this.width === n.width && this.height === n.height
        }, n.toString = function () {
            return "[" + this.x + "," + this.y + "," + this.width + "x" + this.height + "]"
        }
    }
})();
var SeadragonSpring = Seadragon.Spring = function (n) {
    function o(n) {
        var t = SeadragonConfig.springStiffness;
        return (1 - Math.exp(-n * t)) / (1 - Math.exp(-t))
    }
    var e = typeof n == "number" ? n : 0,
			f = e,
			t = e,
			i = +new Date,
			r = i,
			u = i;
    this.getCurrent = function () {
        return e
    }, this.getTarget = function () {
        return t
    }, this.resetTo = function (n) {
        t = n, u = i, f = t, r = u
    }, this.springTo = function (n) {
        f = e, r = i, t = n, u = r + 1e3 * SeadragonConfig.animationTime
    }, this.shiftBy = function (n) {
        f += n, t += n
    }, this.update = function () {
        i = +new Date, e = i >= u ? t : f + (t - f) * o((i - r) / (u - r))
    }
};
var SeadragonBrowser = Seadragon.Browser = {
    UNKNOWN: 0,
    IE: 1,
    FIREFOX: 2,
    SAFARI: 3,
    CHROME: 4,
    OPERA: 5
},
	SeadragonUtils = function () {
	    function r(n, t) {
	        return t && n != document.body ? document.body : n.offsetParent
	    }
	    var n = this,
			e = ["Msxml2.XMLHTTP", "Msxml3.XMLHTTP", "Microsoft.XMLHTTP"],
			o = {
			    bmp: !1,
			    jpeg: !0,
			    jpg: !0,
			    png: !0,
			    tif: !1,
			    wdp: !1
			},
			i = SeadragonBrowser.UNKNOWN,
			t = 0,
			f = !1,
			u = {};
	    (function () {
	        var h = navigator.appName,
				w = navigator.appVersion,
				n = navigator.userAgent,
				a, l, y, p, s, e, r, o;
	        if (h != "Microsoft Internet Explorer" || !window.attachEvent || !window.ActiveXObject) if (h != "Netscape" || !window.addEventListener) h != "Opera" || !window.opera || !window.attachEvent || (i = SeadragonBrowser.OPERA, t = parseFloat(w));
	        else {
	            var v = n.indexOf("Firefox"),
					c = n.indexOf("Safari"),
					b = n.indexOf("Chrome");
	            v >= 0 ? (i = SeadragonBrowser.FIREFOX, t = parseFloat(n.substring(v + 8))) : c >= 0 && (y = n.substring(0, c).lastIndexOf("/"), i = b >= 0 ? SeadragonBrowser.CHROME : SeadragonBrowser.SAFARI, t = parseFloat(n.substring(y + 1, c)))
	        } else a = n.indexOf("MSIE"), i = SeadragonBrowser.IE, t = parseFloat(n.substring(a + 5, n.indexOf(";", a))), l = document.documentMode, typeof l != "undefined" && (t = l);
	        for (p = window.location.search.substring(1), s = p.split("&"), e = 0; e < s.length; e++) r = s[e], o = r.indexOf("="), o > 0 && (u[r.substring(0, o)] = decodeURIComponent(r.substring(o + 1)));
	        f = i == SeadragonBrowser.IE && t < 9 || i == SeadragonBrowser.CHROME && t < 2
	    })(), this.getBrowser = function () {
	        return i
	    }, this.getBrowserVersion = function () {
	        return t
	    }, this.getElement = function (n) {
	        return typeof n == "string" && (n = document.getElementById(n)), n
	    }, this.getElementPosition = function (t) {
	        for (var t = n.getElement(t), i = new SeadragonPoint, u = n.getElementStyle(t).position == "fixed", f = r(t, u); f; ) i.x += t.offsetLeft, i.y += t.offsetTop, u && (i = i.plus(n.getPageScroll())), t = f, u = n.getElementStyle(t).position == "fixed", f = r(t, u);
	        return i
	    }, this.getElementSize = function (t) {
	        var t = n.getElement(t);
	        return new SeadragonPoint(t.clientWidth, t.clientHeight)
	    }, this.getElementStyle = function (t) {
	        var t = n.getElement(t);
	        if (t.currentStyle) return t.currentStyle;
	        if (window.getComputedStyle) return window.getComputedStyle(t, "");
	        SeadragonDebug.fail("Unknown element style, no known technique.")
	    }, this.getEvent = function (n) {
	        return n ? n : window.event
	    }, this.getMousePosition = function (r) {
	        var r = n.getEvent(r),
				u = new SeadragonPoint;
	        return r.type == "DOMMouseScroll" && i == SeadragonBrowser.FIREFOX && t < 3 ? (u.x = r.screenX, u.y = r.screenY) : typeof r.pageX == "number" ? (u.x = r.pageX, u.y = r.pageY) : typeof r.clientX == "number" ? (u.x = r.clientX + document.body.scrollLeft + document.documentElement.scrollLeft, u.y = r.clientY + document.body.scrollTop + document.documentElement.scrollTop) : SeadragonDebug.fail("Unknown event mouse position, no known technique."), u
	    }, this.getScroMousell = function (t) {
	        var t = n.getEvent(t),
              i = 0;
	        return typeof t.wheelDelta == "number" ? i = t.wheelDelta : typeof t.detail == "number" ? i = t.detail * -1 : SeadragonDebug.fail("Unknown event mouse scroll, no known technique."), i ? i / Math.abs(i) : 0
	    }, this.getPageScroll = function () {
	        var n = new SeadragonPoint,
				i = document.documentElement || {},
				t = document.body || {};
	        return typeof window.pageXOffset == "number" ? (n.x = window.pageXOffset, n.y = window.pageYOffset) : t.scrollLeft || t.scrollTop ? (n.x = t.scrollLeft, n.y = t.scrollTop) : (i.scrollLeft || i.scrollTop) && (n.x = i.scrollLeft, n.y = i.scrollTop), n
	    }, this.getWindowSize = function () {
	        var n = new SeadragonPoint,
				i = document.documentElement || {},
				t = document.body || {};
	        return typeof window.innerWidth == "number" ? (n.x = window.innerWidth, n.y = window.innerHeight) : i.clientWidth || i.clientHeight ? (n.x = i.clientWidth, n.y = i.clientHeight) : t.clientWidth || t.clientHeight ? (n.x = t.clientWidth, n.y = t.clientHeight) : SeadragonDebug.fail("Unknown window size, no known technique."), n
	    }, this.imageFormatSupported = function (n) {
	        var n = n ? n : "";
	        return !!o[n.toLowerCase()]
	    }, this.makeCenteredNode = function (t) {
	        var t = SeadragonUtils.getElement(t),
				r = n.makeNeutralElement("div"),
				i = [],
				f, u;
	        for (i.push('<div style="display:table; height:100%; width:100%;'), i.push("border:none; margin:0px; padding:0px;"), i.push('#position:relative; overflow:hidden; text-align:left;">'), i.push('<div style="#position:absolute; #top:50%; width:100%; '), i.push("border:none; margin:0px; padding:0px;"), i.push('display:table-cell; vertical-align:middle;">'), i.push('<div style="#position:relative; #top:-50%; width:100%; '), i.push("border:none; margin:0px; padding:0px;"), i.push('text-align:center;"></div></div></div>'), r.innerHTML = i.join(""), r = r.firstChild, f = r, u = r.getElementsByTagName("div"); u.length > 0; ) f = u[0], u = f.getElementsByTagName("div");
	        return f.appendChild(t), r
	    }, this.makeNeutralElement = function (n) {
	        var i = document.createElement(n),
				t = i.style;
	        return t.background = "transparent none", t.border = "none", t.margin = "0px", t.padding = "0px", t.position = "static", i
	    }, this.makeTransparentImage = function (r) {
	        var f = n.makeNeutralElement("img"),
				u = null;
	        return i == SeadragonBrowser.IE && t < 7 ? (u = n.makeNeutralElement("span"), u.style.display = "inline-block", f.onload = function () {
	            u.style.width = u.style.width || f.width + "px", u.style.height = u.style.height || f.height + "px", f.onload = null, f = null
	        }, f.src = r, u.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + r + "', sizingMethod='scale')") : (u = f, u.src = r), u
	    }, this.setElementOpacity = function (t, i, r) {
	        var t = n.getElement(t),
				o, e, u;
	        (r && f && (i = Math.round(i)), t.style.opacity = i < 1 ? i : "", o = t.style.filter || "", t.style.filter = o.replace(/[\s]*alpha\(.*?\)[\s]*/g, ""), i >= 1) || (e = Math.round(100 * i), u = " alpha(opacity=" + e + ") ", t.style.filter += u)
	    }, this.addEvent = function (t, i, r, u) {
	        var t = n.getElement(t);
	        t.addEventListener ? (i == "mousewheel" && t.addEventListener("DOMMouseScroll", r, u), t.addEventListener(i, r, u)) : t.attachEvent ? (t.attachEvent("on" + i, r), u && t.setCapture && t.setCapture()) : SeadragonDebug.fail("Unable to attach event handler, no known technique.")
	    }, this.removeEvent = function (t, i, r, u) {
	        var t = n.getElement(t);
	        t.removeEventListener ? (i == "mousewheel" && t.removeEventListener("DOMMouseScroll", r, u), t.removeEventListener(i, r, u)) : t.detachEvent ? (t.detachEvent("on" + i, r), u && t.releaseCapture && t.releaseCapture()) : SeadragonDebug.fail("Unable to detach event handler, no known technique.")
	    }, this.cancelEvent = function (t) {
	        var t = n.getEvent(t);
	        t.preventDefault && t.preventDefault(), t.cancel = !0, t.returnValue = !1
	    }, this.stopEvent = function (t) {
	        var t = n.getEvent(t);
	        t.stopPropagation && t.stopPropagation(), t.cancelBubble = !0
	    }, this.createCallback = function (n, t) {
	        for (var r = [], i = 2; i < arguments.length; i++) r.push(arguments[i]);
	        return function () {
	            for (var u = r.concat([]), i = 0; i < arguments.length; i++) u.push(arguments[i]);
	            return t.apply(n, u)
	        }
	    }, this.getUrlParameter = function (n) {
	        var t = u[n];
	        return t ? t : null
	    }, this.makeAjaxRequest = function (n, t) {
	        var r = typeof t == "function",
				i = null,
				f, t, u;
	        if (r && (f = t, t = function () {
	            window.setTimeout(SeadragonUtils.createCallback(null, f, i), 1)
	        }), window.ActiveXObject) for (u = 0; u < e.length; u++) try {
	            i = new ActiveXObject(e[u]);
	            break
	        } catch (o) {
	            continue
	        } else window.XMLHttpRequest && (i = new XMLHttpRequest);
	        i || SeadragonDebug.fail("Browser doesn't support XMLHttpRequest."), SeadragonConfig.proxyUrl && (n = SeadragonConfig.proxyUrl + n), r && (i.onreadystatechange = function () {
	            i.readyState == 4 && (i.onreadystatechange = new Function, t())
	        });
	        try {
	            i.open("GET", n, r), i.send(null)
	        } catch (o) {
	            SeadragonDebug.log(o.name + " while making AJAX request: " + o.message), i.onreadystatechange = null, i = null, r && t()
	        }
	        return r ? null : i
	    }, this.parseXml = function (n) {
	        var t = null,
				i;
	        if (window.ActiveXObject) try {
	            t = new ActiveXObject("Microsoft.XMLDOM"), t.async = !1, t.loadXML(n)
	        } catch (r) {
	            SeadragonDebug.log(r.name + " while parsing XML (ActiveX): " + r.message)
	        } else if (window.DOMParser) try {
	            i = new DOMParser, t = i.parseFromString(n, "text/xml")
	        } catch (r) {
	            SeadragonDebug.log(r.name + " while parsing XML (DOMParser): " + r.message)
	        } else SeadragonDebug.fail("Browser doesn't support XML DOM.");
	        return t
	    }
	};
SeadragonUtils = Seadragon.Utils = new SeadragonUtils;
var SeadragonMouseTracker = Seadragon.MouseTracker;
(function () {
    function o(n) {
        return SeadragonUtils.getMousePosition(n)    //获取鼠标位置
    }

    function n(n, t) {
        var r = SeadragonUtils.getMousePosition(n),
			i = SeadragonUtils.getElementPosition(t);
        return r.minus(i)
    }

    function r(n, t) {
        for (var i = document.body; t && n != t && i != t; ) try {
            t = t.parentNode
        } catch (r) {
            return !1
        }
        return n == t
    }

    function h() {
        u = !0
    }

    function s() {
        u = !1
    }
    if (!SeadragonMouseTracker) {
        var t = SeadragonUtils.getBrowser() == SeadragonBrowser.IE && SeadragonUtils.getBrowserVersion() < 9,
			u = !1,
			f = !1,
			e = {},
			i = [];
        (function () {
            t ? (SeadragonUtils.addEvent(document, "mousedown", h, !1), SeadragonUtils.addEvent(document, "mouseup", s, !1)) : (SeadragonUtils.addEvent(window, "mousedown", h, !0), SeadragonUtils.addEvent(window, "mouseup", s, !0))
        })(), SeadragonMouseTracker = Seadragon.MouseTracker = function (s) {
            function yt() {
                //y || (SeadragonUtils.addEvent(s, "mouseover", k, !1), SeadragonUtils.addEvent(s, "mouseout", g, !1), SeadragonUtils.addEvent(s, "mousedown", it, !1), SeadragonUtils.addEvent(s, "mouseup", l, !1), SeadragonUtils.addEvent(s, "mousewheel", st, !1), SeadragonUtils.addEvent(s, "click", ft, !1), y = !0, e[d] = p)
                y || (SeadragonUtils.addEvent(s, "mouseover", k, !1), SeadragonUtils.addEvent(s, "mouseleave", g, !1), SeadragonUtils.addEvent(s, "mousedown", it, !1), SeadragonUtils.addEvent(s, "mouseup", l, !1), SeadragonUtils.addEvent(s, "mousewheel", st, !1), SeadragonUtils.addEvent(s, "click", ft, !1), y = !0, e[d] = p)
            }

            function vt() {
                //y && (SeadragonUtils.removeEvent(s, "mouseover", k, !1), SeadragonUtils.removeEvent(s, "mouseout", g, !1), SeadragonUtils.removeEvent(s, "mousedown", it, !1), SeadragonUtils.removeEvent(s, "mouseup", l, !1), SeadragonUtils.removeEvent(s, "mousewheel", st, !1), SeadragonUtils.removeEvent(s, "click", ft, !1), b(), y = !1, delete e[d])
                y && (SeadragonUtils.removeEvent(s, "mouseover", k, !1), SeadragonUtils.removeEvent(s, "mouseleave", g, !1), SeadragonUtils.removeEvent(s, "mousedown", it, !1), SeadragonUtils.removeEvent(s, "mouseup", l, !1), SeadragonUtils.removeEvent(s, "mousewheel", st, !1), SeadragonUtils.removeEvent(s, "click", ft, !1), b(), y = !1, delete e[d])
            }

            function ct() {
                c || (t ? (SeadragonUtils.removeEvent(s, "mouseup", l, !1), SeadragonUtils.addEvent(s, "mouseup", ut, !0), SeadragonUtils.addEvent(s, "mousemove", tt, !0)) : (SeadragonUtils.addEvent(window, "mouseup", rt, !0),SeadragonUtils.addEvent(window, "mouseleave", rt, !0),SeadragonUtils.addEvent(window, "mousemove", nt, !0)), c = !0)
            }

            function b() {
                c && (t ? (SeadragonUtils.removeEvent(s, "mousemove", tt, !0), SeadragonUtils.removeEvent(s, "mouseup", ut, !0), SeadragonUtils.addEvent(s, "mouseup", l, !1)) : (SeadragonUtils.removeEvent(window, "mousemove", nt, !0), SeadragonUtils.removeEvent(window, "mouseup", rt, !0)), c = !1)
            }

            function ht(n, t) {
                var r = e,
					i;
                for (i in r) r.hasOwnProperty(i) && d != i && r[i][n](t)
            }

            function at() {
                return v
            }

            function k(i) {
                var i = SeadragonUtils.getEvent(i),
					e, f;
                if ((t && c && !r(i.srcElement, s) && ht("onMouseOver", i), e = i.target ? i.target : i.srcElement, f = i.relatedTarget ? i.relatedTarget : i.fromElement, r(s, e) && !r(s, f)) && (v = !0, typeof h.enterHandler == "function")) try {
                    h.enterHandler(h, n(i, s), a, u)
                } catch (o) {
                    SeadragonDebug.error(o.name + " while executing enter handler: " + o.message, o)
                }
            }

            function g(i) {
                var i = SeadragonUtils.getEvent(i),
					e, f;
                if ((t && c && !r(i.srcElement, s) && ht("onMouseOut", i), e = i.target ? i.target : i.srcElement, f = i.relatedTarget ? i.relatedTarget : i.toElement, r(s, e) && !r(s, f)) && (v = !1, typeof h.exitHandler == "function")) try {
                    h.exitHandler(h, n(i, s), a, u)
                } catch (o) {
                    SeadragonDebug.error(o.name + " while executing exit handler: " + o.message, o)
                }
            }

            function it(r) {
                var r = SeadragonUtils.getEvent(r);
                if (r.button != 2) {
                    if (a = !0, w = o(r), et = w, ot = +new Date, typeof h.pressHandler == "function") try {
                        h.pressHandler(h, n(r, s))
                    } catch (u) {
                        SeadragonDebug.error(u.name + " while executing press handler: " + u.message, u)
                    } (h.pressHandler || h.dragHandler) && SeadragonUtils.cancelEvent(r), t && f ? t && i.push(p) : (ct(), f = !0, i = [p])
                }
            }

            function l(t) {
                var t = SeadragonUtils.getEvent(t),
					r = a,
					i = v;
                if (t.button != 2) {
                    if (a = !1, typeof h.releaseHandler == "function") try {
                        h.releaseHandler(h, n(t, s), r, i)
                    } catch (u) {
                        SeadragonDebug.error(u.name + " while executing release handler: " + u.message, u)
                    }
                    r && i && lt(t)
                }
            }

            function ut(n) {
                var n = SeadragonUtils.getEvent(n),
					t, r;
                if (n.button != 2) {
                    for (t = 0; t < i.length; t++) if (r = i[t], !r.hasMouse()) r.onMouseUp(n);
                    b(), f = !1, n.srcElement.fireEvent("on" + n.type, document.createEventObject(n)), SeadragonUtils.stopEvent(n)
                }
            }

            function rt(n) {
                v || l(n), b()
            }

            function ft(n) {
                h.clickHandler && SeadragonUtils.cancelEvent(n)
            }

            function lt(t) {
                var t = SeadragonUtils.getEvent(t);
                if (t.button != 2) {
                    var u = +new Date - ot,
						f = o(t),
						i = et.distanceTo(f),
						r = u <= SeadragonConfig.clickTimeThreshold && i <= SeadragonConfig.clickDistThreshold;
                    if (typeof h.clickHandler == "function") try {
                        h.clickHandler(h, n(t, s), r, t.shiftKey)
                    } catch (e) {
                        SeadragonDebug.error(e.name + " while executing click handler: " + e.message, e)
                    }
                }
            }

            function nt(t) //鼠标的拖动事件 harry
            {
                var t = SeadragonUtils.getEvent(t),
					i = o(t),
					r = i.minus(w);
                if (w = i, typeof h.dragHandler == "function") {
                    try {
                        h.dragHandler(h, n(t, s), r, t.shiftKey)
                    } catch (u) {
                        SeadragonDebug.error(u.name + " while executing drag handler: " + u.message, u)
                    }
                    SeadragonUtils.cancelEvent(t)
                }
            }

            function tt(n) {
                for (var t = 0; t < i.length; t++) i[t].onMouseMove(n);
                SeadragonUtils.stopEvent(n)
            }

            function st(t) //鼠标的滚轮的滚动事件 harry
            {
                var t = SeadragonUtils.getEvent(t),
					i = SeadragonUtils.getMouseScroll(t);
                if (typeof h.scrollHandler == "function") {
                    if (i) try {
                        h.scrollHandler(h, n(t, s), i, t.shiftKey)
                    } catch (r) {
                        SeadragonDebug.error(r.name + " while executing scroll handler: " + r.message, r)
                    }
                    SeadragonUtils.cancelEvent(t)
                }
            }
            var h = this,
				p = null,
				d = Math.random(),
				s = SeadragonUtils.getElement(s),
				y = !1,
				c = !1,
				a = !1,
				v = !1,
				w = null,
				ot = null,
				et = null;
            this.target = s, this.enterHandler = null, this.exitHandler = null, this.pressHandler = null, this.releaseHandler = null, this.clickHandler = null, this.dragHandler = null, this.scrollHandler = null, function () {
                p = {
                    hasMouse: at,
                    onMouseOver: k,
                    onMouseOut: g,
                    onMouseUp: l,
                    onMouseMove: nt
                }
            } (), this.isTracking = function () {
                return y
            }, this.setTracking = function (n) {
                n ? yt() : vt()
            }
        }
    }
})();
var SeadragonEventManager = Seadragon.EventManager = function () {
    var n = {};
    this.addListener = function (t, i) {
        typeof i == "function" && (n[t] || (n[t] = []), n[t].push(i))
    }, this.removeListener = function (t, i) {
        var u = n[t],
				r;
        if (typeof i == "function" && u) for (r = 0; r < u.length; r++) if (i == u[r]) {
            u.splice(r, 1);
            return
        }
    }, this.clearListeners = function (t) {
        n[t] && delete n[t]
    }, this.trigger = function (t) {
        var r = n[t],
				u = [],
				i;
        if (r) {
            for (i = 1; i < arguments.length; i++) u.push(arguments[i]);
            for (i = 0; i < r.length; i++) try {
                r[i].apply(window, u)
            } catch (f) {
                SeadragonDebug.error(f.name + " while executing " + t + " handler: " + f.message, f)
            }
        }
    }
};
var SeadragonImageLoader;
(function () {
    function n(n, i) {
        function u(t) {
            r.onload = null, r.onabort = null, r.onerror = null, f && window.clearTimeout(f), window.setTimeout(function () {
                i(n, t ? r : null)
            }, 1)
        }
        var r = null,
			f = null;
        this.start = function () {
            r = new Image;
            var o = function () {
                u(!0)
            },
				i = function () {
				    u(!1)
				},
				e = function () {
				    SeadragonDebug.log("Image timed out: " + n), u(!1)
				};
            r.onload = o, r.onabort = i, r.onerror = i, f = window.setTimeout(e, t), r.src = n
        }
    }
    var t = 15e3;
    SeadragonImageLoader = Seadragon.ImageLoader = function () {
        function i(n, i, r) {
            if (t--, typeof n == "function") try {
                n(r)
            } catch (u) {
                SeadragonDebug.error(u.name + " while executing " + i + " callback: " + u.message, u)
            }
        }
        var t = 0;
        this.loadImage = function (r, u) {
            if (t >= SeadragonConfig.imageLoaderLimit) return !1;
            var e = SeadragonUtils.createCallback(null, i, u),
				f = new n(r, e);
            return t++, f.start(), !0
        }
    }
})();
var SeadragonButton, SeadragonButtonGroup;
(function () {
    var n = {
        REST: 0,
        GROUP: 1,
        HOVER: 2,
        DOWN: 3
    };
    SeadragonButton = Seadragon.Button = function (t, i, r, u, f, e, o, s, h, c) {
        function nt() {
            window.setTimeout(st, 20)
        }

        function st() {
            if (d) {
                var t = +new Date,
					i = t - it,
					n = 1 - i / ht;
                n = Math.min(1, n), n = Math.max(0, n), SeadragonUtils.setElementOpacity(b, n, !0), n > 0 && nt()
            }
        }

        function lt() {
            d = !0, it = +new Date + tt, window.setTimeout(nt, tt)
        }

        function ct() {
            d = !1, SeadragonUtils.setElementOpacity(b, 1, !0)
        }

        function y(t) {
            t >= n.GROUP && l == n.REST && (ct(), l = n.GROUP), t >= n.HOVER && l == n.GROUP && (k.style.visibility = "", l = n.HOVER), t >= n.DOWN && l == n.HOVER && (w.style.visibility = "", l = n.DOWN)
        }

        function p(t) {
            t <= n.HOVER && l == n.DOWN && (w.style.visibility = "hidden", l = n.HOVER), t <= n.GROUP && l == n.HOVER && (k.style.visibility = "hidden", l = n.GROUP), t <= n.REST && l == n.GROUP && (lt(), l = n.REST)
        }

        function ot(t, i, r, u) {
            r ? (y(n.DOWN), h && h()) : u || y(n.HOVER)
        }

        function et(t, i, r) {
            p(n.GROUP), r && c && c()
        }

        function ut() {
            y(n.DOWN), e && e()
        }

        function ft(t, i, r, u) {
            r && u ? (p(n.HOVER), o && o()) : r ? p(n.GROUP) : y(n.HOVER)
        }

        function rt(n, t, i) {
            s && i && s()
        }
        var a = SeadragonUtils.makeNeutralElement("span"),
			l = n.GROUP,
			v = new SeadragonMouseTracker(a),
			g = SeadragonUtils.makeTransparentImage(i),
			b = SeadragonUtils.makeTransparentImage(r),
			k = SeadragonUtils.makeTransparentImage(u),
			w = SeadragonUtils.makeTransparentImage(f),
			e = typeof e == "function" ? e : null,
			o = typeof o == "function" ? o : null,
			s = typeof s == "function" ? s : null,
			h = typeof h == "function" ? h : null,
			c = typeof c == "function" ? c : null,
			tt = 0,
			ht = 2e3,
			it = null,
			d = !1;
        this.elmt = a, this.notifyGroupEnter = function () {
            y(n.GROUP)
        }, this.notifyGroupExit = function () {
            p(n.REST)
        }, function () {
            a.style.display = "inline-block", a.style.position = "relative", a.title = t, a.appendChild(g), a.appendChild(b), a.appendChild(k), a.appendChild(w);
            var f = g.style,
				u = b.style,
				i = k.style,
				r = w.style;
            u.position = i.position = r.position = "absolute", u.top = i.top = r.top = "0px", u.left = i.left = r.left = "0px", i.visibility = r.visibility = "hidden", SeadragonUtils.getBrowser() == SeadragonBrowser.FIREFOX && SeadragonUtils.getBrowserVersion() < 3 && (u.top = i.top = r.top = ""), v.enterHandler = ot, v.exitHandler = et, v.pressHandler = ut, v.releaseHandler = ft, v.clickHandler = rt, v.setTracking(!0), p(n.REST)
        } ()
    }, SeadragonButtonGroup = Seadragon.ButtonGroup = function (n) {
        function u() {
            for (var f = 0; f < n.length; f++) n[f].notifyGroupEnter()
        }

        function r(t, i, r) {
            if (!r) for (var f = 0; f < n.length; f++) n[f].notifyGroupExit()
        }

        function f(t, i, r, u) {
            if (!u) for (var f = 0; f < n.length; f++) n[f].notifyGroupExit()
        }
        var i = SeadragonUtils.makeNeutralElement("span"),
			n = n.concat([]),
			t = new SeadragonMouseTracker(i);
        this.elmt = i, this.emulateEnter = function () {
            u()
        }, this.emulateExit = function () {
            r()
        }, function () {
            i.style.display = "inline-block";
            for (var e = 0; e < n.length; e++) i.appendChild(n[e].elmt);
            t.enterHandler = u, t.exitHandler = r, t.releaseHandler = f, t.setTracking(!0)
        } ()
    }
})();
var SeadragonBrowser = Seadragon.Browser = {
    UNKNOWN: 0,
    IE: 1,
    FIREFOX: 2,
    SAFARI: 3,
    CHROME: 4,
    OPERA: 5
},
	SeadragonUtils = function () {
	    function r(n, t) {
	        return t && n != document.body ? document.body : n.offsetParent
	    }
	    var n = this,
			e = ["Msxml2.XMLHTTP", "Msxml3.XMLHTTP", "Microsoft.XMLHTTP"],
			o = {
			    bmp: !1,
			    jpeg: !0,
			    jpg: !0,
			    png: !0,
			    tif: !1,
			    wdp: !1
			},
			i = SeadragonBrowser.UNKNOWN,
			t = 0,
			f = !1,
			u = {};
	    (function () {
	        var h = navigator.appName,
				w = navigator.appVersion,
				n = navigator.userAgent,
				a, l, y, p, s, e, r, o;
	        if (h != "Microsoft Internet Explorer" || !window.attachEvent || !window.ActiveXObject) if (h != "Netscape" || !window.addEventListener) h != "Opera" || !window.opera || !window.attachEvent || (i = SeadragonBrowser.OPERA, t = parseFloat(w));
	        else {
	            var v = n.indexOf("Firefox"),
					c = n.indexOf("Safari"),
					b = n.indexOf("Chrome");
	            v >= 0 ? (i = SeadragonBrowser.FIREFOX, t = parseFloat(n.substring(v + 8))) : c >= 0 && (y = n.substring(0, c).lastIndexOf("/"), i = b >= 0 ? SeadragonBrowser.CHROME : SeadragonBrowser.SAFARI, t = parseFloat(n.substring(y + 1, c)))
	        } else a = n.indexOf("MSIE"), i = SeadragonBrowser.IE, t = parseFloat(n.substring(a + 5, n.indexOf(";", a))), l = document.documentMode, typeof l != "undefined" && (t = l);
	        for (p = window.location.search.substring(1), s = p.split("&"), e = 0; e < s.length; e++) r = s[e], o = r.indexOf("="), o > 0 && (u[r.substring(0, o)] = decodeURIComponent(r.substring(o + 1)));
	        f = i == SeadragonBrowser.IE && t < 9 || i == SeadragonBrowser.CHROME && t < 2
	    })(), this.getBrowser = function () {
	        return i
	    }, this.getBrowserVersion = function () {
	        return t
	    }, this.getElement = function (n) {
	        return typeof n == "string" && (n = document.getElementById(n)), n
	    }, this.getElementPosition = function (t) {
	        for (var t = n.getElement(t), i = new SeadragonPoint, u = n.getElementStyle(t).position == "fixed", f = r(t, u); f; ) i.x += t.offsetLeft, i.y += t.offsetTop, u && (i = i.plus(n.getPageScroll())), t = f, u = n.getElementStyle(t).position == "fixed", f = r(t, u);
	        return i
	    }, this.getElementSize = function (t) {
	        var t = n.getElement(t);
	        return new SeadragonPoint(t.clientWidth, t.clientHeight)
	    }, this.getElementStyle = function (t) {
	        var t = n.getElement(t);
	        if (t.currentStyle) return t.currentStyle;
	        if (window.getComputedStyle) return window.getComputedStyle(t, "");
	        SeadragonDebug.fail("Unknown element style, no known technique.")
	    }, this.getEvent = function (n) {
	        return n ? n : window.event
	    }, this.getMousePosition = function (r) {   //当前event对象元素

	        var r = n.getEvent(r),
				u = new SeadragonPoint;
	        return r.type == "DOMMouseScroll" && i == SeadragonBrowser.FIREFOX && t < 3 ? (u.x = r.screenX, u.y = r.screenY) : typeof r.pageX == "number" ? (u.x = r.pageX, u.y = r.pageY) : typeof r.clientX == "number" ? (u.x = r.clientX + document.body.scrollLeft + document.documentElement.scrollLeft, u.y = r.clientY + document.body.scrollTop + document.documentElement.scrollTop) : SeadragonDebug.fail("Unknown event mouse position, no known technique."), u
	    }, this.getMouseScroll = function (t) {
	        var t = n.getEvent(t),
				i = 0;
	        return typeof t.wheelDelta == "number" ? i = t.wheelDelta : typeof t.detail == "number" ? i = t.detail * -1 : SeadragonDebug.fail("Unknown event mouse scroll, no known technique."), i ? i / Math.abs(i) : 0
	    }, this.getPageScroll = function () {
	        var n = new SeadragonPoint,
				i = document.documentElement || {},
				t = document.body || {};
	        return typeof window.pageXOffset == "number" ? (n.x = window.pageXOffset, n.y = window.pageYOffset) : t.scrollLeft || t.scrollTop ? (n.x = t.scrollLeft, n.y = t.scrollTop) : (i.scrollLeft || i.scrollTop) && (n.x = i.scrollLeft, n.y = i.scrollTop), n
	    }, this.getWindowSize = function () {
	        var n = new SeadragonPoint,
				i = document.documentElement || {},
				t = document.body || {};
	        return typeof window.innerWidth == "number" ? (n.x = window.innerWidth, n.y = window.innerHeight) : i.clientWidth || i.clientHeight ? (n.x = i.clientWidth, n.y = i.clientHeight) : t.clientWidth || t.clientHeight ? (n.x = t.clientWidth, n.y = t.clientHeight) : SeadragonDebug.fail("Unknown window size, no known technique."), n
	    }, this.imageFormatSupported = function (n) {
	        var n = n ? n : "";
	        return !!o[n.toLowerCase()]
	    }, this.makeCenteredNode = function (t) {
	        var t = SeadragonUtils.getElement(t),
				r = n.makeNeutralElement("div"),
				i = [],
				f, u;
	        for (i.push('<div style="display:table; height:100%; width:100%;'), i.push("border:none; margin:0px; padding:0px;"), i.push('#position:relative; overflow:hidden; text-align:left;">'), i.push('<div style="#position:absolute; #top:50%; width:100%; '), i.push("border:none; margin:0px; padding:0px;"), i.push('display:table-cell; vertical-align:middle;">'), i.push('<div style="#position:relative; #top:-50%; width:100%; '), i.push("border:none; margin:0px; padding:0px;"), i.push('text-align:center;"></div></div></div>'), r.innerHTML = i.join(""), r = r.firstChild, f = r, u = r.getElementsByTagName("div"); u.length > 0; ) f = u[0], u = f.getElementsByTagName("div");
	        return f.appendChild(t), r
	    }, this.makeNeutralElement = function (n) {  //n="div"
	        var i = document.createElement(n),
				t = i.style;
	        return t.background = "transparent none", t.border = "none", t.margin = "0px", t.padding = "0px", t.position = "static", i
	    }, this.makeTransparentImage = function (r) {
	        var f = n.makeNeutralElement("img"),
				u = null;
	        return i == SeadragonBrowser.IE && t < 7 ? (u = n.makeNeutralElement("span"), u.style.display = "inline-block", f.onload = function () {
	            u.style.width = u.style.width || f.width + "px", u.style.height = u.style.height || f.height + "px", f.onload = null, f = null
	        }, f.src = r, u.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + r + "', sizingMethod='scale')") : (u = f, u.src = r), u
	    }, this.setElementOpacity = function (t, i, r) {
	        var t = n.getElement(t),
				o, e, u;
	        (r && f && (i = Math.round(i)), t.style.opacity = i < 1 ? i : "", o = t.style.filter || "", t.style.filter = o.replace(/[\s]*alpha\(.*?\)[\s]*/g, ""), i >= 1) || (e = Math.round(100 * i), u = " alpha(opacity=" + e + ") ", t.style.filter += u)
	    }, this.addEvent = function (t, i, r, u) {
	        var t = n.getElement(t);
	        t.addEventListener ? (i == "mousewheel" && t.addEventListener("DOMMouseScroll", r, u), t.addEventListener(i, r, u)) : t.attachEvent ? (t.attachEvent("on" + i, r), u && t.setCapture && t.setCapture()) : SeadragonDebug.fail("Unable to attach event handler, no known technique.")
	    }, this.removeEvent = function (t, i, r, u) {
	        var t = n.getElement(t);
	        t.removeEventListener ? (i == "mousewheel" && t.removeEventListener("DOMMouseScroll", r, u), t.removeEventListener(i, r, u)) : t.detachEvent ? (t.detachEvent("on" + i, r), u && t.releaseCapture && t.releaseCapture()) : SeadragonDebug.fail("Unable to detach event handler, no known technique.")
	    }, this.cancelEvent = function (t) {
	        var t = n.getEvent(t);
	        t.preventDefault && t.preventDefault(), t.cancel = !0, t.returnValue = !1
	    }, this.stopEvent = function (t) {
	        var t = n.getEvent(t);
	        t.stopPropagation && t.stopPropagation(), t.cancelBubble = !0
	    }, this.createCallback = function (n, t) {
	        for (var r = [], i = 2; i < arguments.length; i++) r.push(arguments[i]);
	        return function () {
	            for (var u = r.concat([]), i = 0; i < arguments.length; i++) u.push(arguments[i]);
	            return t.apply(n, u)
	        }
	    }, this.getUrlParameter = function (n) {
	        var t = u[n];
	        return t ? t : null
	    }, this.makeAjaxRequest = function (n, t) {
	        var r = typeof t == "function",
				i = null,
				f, t, u;
	        if (r && (f = t, t = function () {
	            window.setTimeout(SeadragonUtils.createCallback(null, f, i), 1)
	        }), window.ActiveXObject) for (u = 0; u < e.length; u++) try {
	            i = new ActiveXObject(e[u]);
	            break
	        } catch (o) {
	            continue
	        } else window.XMLHttpRequest && (i = new XMLHttpRequest);
	        i || SeadragonDebug.fail("Browser doesn't support XMLHttpRequest."), SeadragonConfig.proxyUrl && (n = SeadragonConfig.proxyUrl + n), r && (i.onreadystatechange = function () {
	            i.readyState == 4 && (i.onreadystatechange = new Function, t())
	        });
	        try {
	            i.open("GET", n, r), i.send(null)
	        } catch (o) {
	            SeadragonDebug.log(o.name + " while making AJAX request: " + o.message), i.onreadystatechange = null, i = null, r && t()
	        }
	        return r ? null : i
	    }, this.parseXml = function (n) {
	        var t = null,
				i;
	        if (window.ActiveXObject) try {
	            t = new ActiveXObject("Microsoft.XMLDOM"), t.async = !1, t.loadXML(n)
	        } catch (r) {
	            SeadragonDebug.log(r.name + " while parsing XML (ActiveX): " + r.message)
	        } else if (window.DOMParser) try {
	            i = new DOMParser, t = i.parseFromString(n, "text/xml")
	        } catch (r) {
	            SeadragonDebug.log(r.name + " while parsing XML (DOMParser): " + r.message)
	        } else SeadragonDebug.fail("Browser doesn't support XML DOM.");
	        return t
	    }
	};
SeadragonUtils = Seadragon.Utils = new SeadragonUtils;     //显示图像的某一步
var SeadragonTileSource = Seadragon.TileSource = function (n, t, i, r, u, f) {
    var e = this,
			o = t / n;
    this.width = n, this.height = t, this.aspectRatio = n / t, this.dimensions = new SeadragonPoint(n, t), this.minLevel = u ? u : 0, this.maxLevel = f ? f : Math.ceil(Math.log(Math.max(n, t)) / Math.log(2)), this.tileSize = i ? i : 0, this.tileOverlap = r ? r : 0, this.getLevelScale = function (n) {
        return 1 / (1 << e.maxLevel - n)
    }, this.getNumTiles = function (i) {
        var r = e.getLevelScale(i),
				f = Math.ceil(r * n / e.tileSize),
				u = Math.ceil(r * t / e.tileSize);
        return new SeadragonPoint(f, u)
    }, this.getPixelRatio = function (n) {
        var t = e.dimensions.times(e.getLevelScale(n)),
				r = 1 / t.x,
				i = 1 / t.y;
        return new SeadragonPoint(r, i)
    }, this.getTileAtPoint = function (n, t) {
        var i = e.dimensions.times(e.getLevelScale(n)),
				r = t.times(i.x),
				f, u;
        return f = t.x >= 0 && t.x <= 1 ? Math.floor(r.x / e.tileSize) : Math.ceil(i.x / e.tileSize) * Math.floor(r.x / i.x) + Math.floor((i.x + r.x % i.x) % i.x / e.tileSize), u = t.y >= 0 && t.y <= o ? Math.floor(r.y / e.tileSize) : Math.ceil(i.y / e.tileSize) * Math.floor(r.y / i.y) + Math.floor((i.y + r.y % i.y) % i.y / e.tileSize), new SeadragonPoint(f, u)
    }, this.getTileBounds = function (n, t, i) {
        var o = e.dimensions.times(e.getLevelScale(n)),
				s = t === 0 ? 0 : e.tileSize * t - e.tileOverlap,
				h = i === 0 ? 0 : e.tileSize * i - e.tileOverlap,
				u = e.tileSize + (t === 0 ? 1 : 2) * e.tileOverlap,
				f = e.tileSize + (i === 0 ? 1 : 2) * e.tileOverlap,
				r;
        return u = Math.min(u, o.x - s), f = Math.min(f, o.y - h), r = 1 / o.x, new SeadragonRect(s * r, h * r, u * r, f * r)
    }, this.getTileUrl = function () {
        throw new Error("Method not implemented.");
    }, this.tileExists = function (n, t, i) {
        var r = e.getNumTiles(n);
        return n >= e.minLevel && n <= e.maxLevel && t >= 0 && i >= 0 && t < r.x && i < r.y
    }
};
var SeadragonDisplayRect = Seadragon.DisplayRect = function (n, t, i, r, u, f) {
    SeadragonRect.apply(this, arguments), this.minLevel = u, this.maxLevel = f
};
SeadragonDisplayRect.prototype = new SeadragonRect;
var SeadragonDziTileSource = Seadragon.DziTileSource = function (n, t, i, r, u, f, e) {
    SeadragonTileSource.apply(this, [n, t, i, r]);
    var s = this,
			o = {};
    this.fileFormat = f, this.tileFormat = f, this.displayRects = e, function () {
        var t, i, n;
        if (e) for (t = e.length - 1; t >= 0; t--) for (i = e[t], n = i.minLevel; n <= i.maxLevel; n++) o[n] || (o[n] = []), o[n].push(i)
    } (), this.getTileUrl = function (n, t, i) {
        return [u, n, "/", t, "_", i, ".", f].join("")
    }, this.tileExists = function (n, t, r) {
        var c = o[n],
				f, l, u;
        if (!c || !c.length) return !0;
        for (f = s.getLevelScale(n), l = c.length - 1; l >= 0; l--) if (u = c[l], !(n < u.minLevel) && !(n > u.maxLevel)) {
            var h = u.x * f,
					e = u.y * f,
					v = h + u.width * f,
					a = e + u.height * f;
            if (h = Math.floor(h / i), e = Math.floor(e / i), v = Math.ceil(v / i), a = Math.ceil(a / i), h <= t && t < v && e <= r && r < a) return !0
        }
        return !1
    }
};
SeadragonDziTileSource.prototype = new SeadragonTileSource, function () {
    function n(n) {
        Error.apply(this, arguments), this.message = n
    }

    function r(t) {
        return t instanceof n || (SeadragonDebug.error(t.name + " while creating DZI from XML: " + t.message), t = new n(SeadragonStrings.getString("Errors.Unknown"))), t
    }

    function i(n) {
        var t = n.split("/"),
			r = t[t.length - 1],
			i = r.lastIndexOf(".");
        return i > -1 && (t[t.length - 1] = r.slice(0, i)), t.join("/") + "_files/"
    }

    function u(i, r) {
        var f, e, u;
        if (i) {
            if (i.status !== 200 && i.status !== 0) {
                f = i.status, e = f == 404 ? "Not Found" : i.statusText;
                throw new n(SeadragonStrings.getString("Errors.Status", f, e));
            }
        } else throw new n(SeadragonStrings.getString("Errors.Security"));
        return u = null, i.responseXML && i.responseXML.documentElement ? u = i.responseXML : i.responseText && (u = SeadragonUtils.parseXml(i.responseText)), t(u, r)
    }

    function t(t, i) {
        var u, r, o;
        if (!t || !t.documentElement) throw new n(SeadragonStrings.getString("Errors.Xml"));
        if (u = t.documentElement, r = u.tagName, r == "Image") try {
            return e(u, i)
        } catch (s) {
            o = SeadragonStrings.getString("Errors.Dzi");
            throw s instanceof n ? s : new n(o);
        } else if (r == "Collection") throw new n(SeadragonStrings.getString("Errors.Dzc"));
        else if (r == "Error") return f(u);
        throw new n(SeadragonStrings.getString("Errors.Dzi"));
    }

    function e(t, i) {
        var e = t.getAttribute("Format"),
			u, f, r;
        if (!SeadragonUtils.imageFormatSupported(e)) throw new n(SeadragonStrings.getString("Errors.ImageFormat", e.toUpperCase()));
        var h = t.getElementsByTagName("Size")[0],
			s = t.getElementsByTagName("DisplayRect"),
			l = parseInt(h.getAttribute("Width"), 10),
			c = parseInt(h.getAttribute("Height"), 10),
			a = parseInt(t.getAttribute("TileSize")),
			v = parseInt(t.getAttribute("Overlap")),
			o = [];
        for (u = 0; u < s.length; u++) f = s[u], r = f.getElementsByTagName("Rect")[0], o.push(new SeadragonDisplayRect(parseInt(r.getAttribute("X"), 10), parseInt(r.getAttribute("Y"), 10), parseInt(r.getAttribute("Width"), 10), parseInt(r.getAttribute("Height"), 10), parseInt(f.getAttribute("MinLevel"), 10), parseInt(f.getAttribute("MaxLevel"), 10)));
        return new SeadragonDziTileSource(l, c, a, v, i, e, o)
    }

    function f(t) {
        var r = t.getElementsByTagName("Message")[0],
			i = r.firstChild.nodeValue;
        throw new n(i);
    }
    n.prototype = new Error, SeadragonDziTileSource.getTilesUrl = i, SeadragonDziTileSource.createFromJson = function (t, u) {
        var a = typeof u == "function",
			c, s, f = t,
			o, h, l, e;
        if (f && (f.url || f.tilesUrl)) try {
            if (o = f.displayRects, o && o.length) for (h = 0, l = o.length; h < l; h++) e = o[h], o[h] = new SeadragonDisplayRect(e.x || e[0], e.y || e[1], e.width || e[2], e.height || e[3], e.minLevel || e[4], e.maxLevel || e[5]);
            c = new SeadragonDziTileSource(f.width, f.height, f.tileSize, f.tileOverlap, f.tilesUrl || i(f.url), f.tileFormat, f.displayRects), c.xmlUrl = f.url
        } catch (v) {
            s = r(v)
        } else s = new n(SeadragonStrings.getString("Errors.Empty"));
        if (a) window.setTimeout(SeadragonUtils.createCallback(null, u, c, s && s.message), 1);
        else if (s) throw s;
        else return c
    }, SeadragonDziTileSource.createFromXml = function (f, e, o) {
        function h(n, t) {
            try {
                var i = n(t, l);
                return i.xmlUrl = f, i
            } catch (u) {
                if (c) return s = r(u).message, null;
                throw r(u);
            }
        }
        var c = typeof o == "function",
			s = null,
			l;
        if (!f) {
            if (s = SeadragonStrings.getString("Errors.Empty"), c) return window.setTimeout(function () {
                o(null, s)
            }, 1), null;
            throw new n(s);
        }
        return (l = i(f), c) ? (e ? window.setTimeout(function () {
            var n = h(t, SeadragonUtils.parseXml(e));
            o(n, s)
        }, 1) : SeadragonUtils.makeAjaxRequest(f, function (n) {
            var t = h(u, n);
            o(t, s)
        }), null) : e ? h(t, SeadragonUtils.parseXml(e)) : h(u, SeadragonUtils.makeAjaxRequest(f))
    }
} ();
var SeadragonViewport = Seadragon.Viewport = function (n, t) {
    function b() {
        i.goHome(!0), i.update()
    }

    function v(n) {
        return Math.log(n) / p
    }

    function y(n) {
        return Math.pow(2, n)
    }

    function h(n, t, i) {
        return Math.min(Math.max(n, t), i)
    }

    function w(n, t) {
        var u = n.x,
				f = n.y,
				i = h(u, t.x, t.x + t.width),
				r = h(f, t.y, t.y + t.height);
        return u === i && f === r ? n : new SeadragonPoint(i, r)
    }

    function c(n) {
        var c = i.getZoom(n),
				o = 1 / c,
				h = o / i.getAspectRatio(),
				e = SeadragonConfig.visibilityRatio,
				f = (e - .5) * o,
				u = (e - .5) * h,
				r = 1 - 2 * f,
				t = s - 2 * u;
        return r < 0 && (f += .5 * r, r = 0), t < 0 && (u += .5 * t, t = 0), new Seadragon.Rect(f, u, r, t)
    }
    var i = this,
			n = new SeadragonPoint(n.x, n.y),
			a = t.x / t.y,
			s = t.y / t.x,
			f = new SeadragonSpring(0),
			u = new SeadragonSpring(0),
			o = new SeadragonSpring(SeadragonConfig.logarithmicZoom ? 0 : 1),
			r = null,
			e = new SeadragonRect(0, 0, 1, s),
			l = e.getCenter(),
			p = Math.LN2;
    this.getHomeBounds = function () {
        var t = i.getAspectRatio(),
				n = new SeadragonRect(e.x, e.y, e.width, e.height);
        return a >= t ? (n.height = e.width / t, n.y = l.y - n.height / 2) : (n.width = e.height * t, n.x = l.x - n.width / 2), n
    }, this.getHomeCenter = function () {
        return l
    }, this.getHomeZoom = function () {
        var n = a / i.getAspectRatio();
        return n >= 1 ? 1 : n
    }, this.getMinCenter = function (n) {
        return c(n).getTopLeft()
    }, this.getMaxCenter = function (n) {
        return c(n).getBottomRight()
    }, this.getMinZoom = function () {
        var u = i.getHomeZoom(),
				r;
        return r = SeadragonConfig.minZoomDimension ? t.x <= t.y ? SeadragonConfig.minZoomDimension / n.x : SeadragonConfig.minZoomDimension / (n.x * s) : SeadragonConfig.minZoomImageRatio * u, Math.min(r, u)
    }, this.getMaxZoom = function () {
        var r = t.x * SeadragonConfig.maxZoomPixelRatio / n.x;
        //return Math.max(r, i.getHomeZoom())
        return Math.max(r / 2, i.getHomeZoom())//modified by harry at 2015-07-30

    }, this.getAspectRatio = function () {
        return n.x / n.y
    }, this.getContainerSize = function () {
        return new SeadragonPoint(n.x, n.y)
    }, this.getBounds = function (n) {
        var u = i.getCenter(n),
				t = 1 / i.getZoom(n),
				r = t / i.getAspectRatio();
        return new SeadragonRect(u.x - t / 2, u.y - r / 2, t, r)  //modify by Robin 20151218
    }, this.getCenter = function (t) {
        var o = new SeadragonPoint(f.getCurrent(), u.getCurrent()),
				c = new SeadragonPoint(f.getTarget(), u.getTarget());
        if (t) return o;
        if (!r) return c;
        var l = i.getZoom(),
				e = 1 / l,
				h = e / i.getAspectRatio(),
				s = new SeadragonRect(o.x - e / 2, o.y - h / 2, e, h),
				y = i.pixelFromPoint(r, !0),
				p = r.minus(s.getTopLeft()).times(n.x / s.width),
				a = p.minus(y),
				v = a.divide(n.x * l);
        return c.plus(v)
    }, this.getZoom = function (n) {
        var t;
        return n ? (t = o.getCurrent(), SeadragonConfig.logarithmicZoom ? y(t) : t) : (t = o.getTarget(), SeadragonConfig.logarithmicZoom ? y(t) : t)
    }, this.applyConstraints = function (n) {
        var s = i.getZoom(),
				o = h(s, i.getMinZoom(), i.getMaxZoom()),
				u, t, f, e;
        s != o && i.zoomTo(o, r, n), u = i.getCenter(), t = w(u, c()), SeadragonConfig.wrapHorizontal && (t.x = u.x), SeadragonConfig.wrapVertical && (t.y = u.y), u.equals(t) || (f = 1 / o, e = f / i.getAspectRatio(), i.fitBounds(new SeadragonRect(t.x - .5 * f, t.y - .5 * e, f, e), n))
    }, this.ensureVisible = function (n) {
        i.applyConstraints(n)
    }, this.fitBounds = function (t, r) {
        var o = i.getAspectRatio(),
				e = t.getCenter(),
				u = new SeadragonRect(t.x, t.y, t.width, t.height),
				h;
        u.getAspectRatio() >= o ? (u.height = t.width / o, u.y = e.y - u.height / 2) : (u.width = t.height * o, u.x = e.x - u.width / 2), i.panTo(i.getCenter(!0), !0), i.zoomTo(i.getZoom(!0), null, !0);
        var f = i.getBounds(),
				c = i.getZoom(),
				s = 1 / u.width;
        if (s == c || u.width == f.width) {
            i.panTo(e, r);
            return
        }
        h = f.getTopLeft().times(n.x / f.width).minus(u.getTopLeft().times(n.x / u.width)).divide(n.x / f.width - n.x / u.width), i.zoomTo(s, h, r)
    }, this.goHome = function (n) {
        var t = i.getCenter();
        SeadragonConfig.wrapHorizontal && (t.x = (1 + t.x % 1) % 1, f.resetTo(t.x), f.update()), SeadragonConfig.wrapVertical && (t.y = (s + t.y % s) % s, u.resetTo(t.y), u.update()), i.fitBounds(e, n)
    }, this.panBy = function (n, t) {
        i.panTo(i.getCenter().plus(n), t)
    }, this.panTo = function (t, e) {
        if (e) {
            f.resetTo(t.x), u.resetTo(t.y);
            return
        }
        if (!r) {
            f.springTo(t.x), u.springTo(t.y);
            return
        }
        var c = i.getZoom(),
				o = 1 / c,
				l = o / i.getAspectRatio(),
				s = new SeadragonRect(f.getCurrent() - o / 2, u.getCurrent() - l / 2, o, l),
				y = i.pixelFromPoint(r, !0),
				v = r.minus(s.getTopLeft()).times(n.x / s.width),
				p = v.minus(y),
				a = p.divide(n.x * c),
				h = t.minus(a);
        f.springTo(h.x), u.springTo(h.y)
    }, this.zoomBy = function (n, t, r) {
        i.zoomTo(i.getZoom() * n, t, r)
    }, this.zoomTo = function (n, t, i) {
        i ? o.resetTo(SeadragonConfig.logarithmicZoom ? v(n) : n) : o.springTo(SeadragonConfig.logarithmicZoom ? v(n) : n), r = t instanceof SeadragonPoint ? t : null
    }, this.resize = function (t, r) {
        var f = i.getBounds(),
				u = f,
				e = t.x / n.x;
        n = new SeadragonPoint(t.x, t.y), r && (u.width = f.width * e, u.height = u.width / i.getAspectRatio()), i.fitBounds(u, !0)
    }, this.update = function () {
        var h = f.getCurrent(),
				c = u.getCurrent(),
				n = o.getCurrent(),
				e;
        if (r && (e = i.pixelFromPoint(r, !0)), o.update(), r && o.getCurrent() != n) {
            var l = i.pixelFromPoint(r, !0),
					s = l.minus(e),
					t = i.deltaPointsFromPixels(s, !0);
            f.shiftBy(t.x), u.shiftBy(t.y)
        } else r = null;
        return f.update(), u.update(), f.getCurrent() != h || u.getCurrent() != c || o.getCurrent() != n
    }, this.deltaPixelsFromPoints = function (t, r) {
        return t.times(n.x * i.getZoom(r))
    }, this.deltaPointsFromPixels = function (t, r) {
        return t.divide(n.x * i.getZoom(r))
    }, this.pixelFromPoint = function (t, r) {
        var u = i.getBounds(r);
        return t.minus(u.getTopLeft()).times(n.x / u.width)
    }, this.pointFromPixel = function (t, r) {
        var u = i.getBounds(r);
        return t.divide(n.x / u.width).plus(u.getTopLeft())
    }, b()
};
var SeadragonDrawer, SeadragonOverlayPlacement;
(function () {
    function t(n, t, i, r, u, f) {
        this.level = n, this.x = t, this.y = i, this.bounds = r, this.exists = u, this.url = f, this.elmt = null, this.image = null, this.loaded = !1, this.loading = !1, this.style = null, this.position = null, this.size = null, this.blendStart = null, this.opacity = null, this.distance = null, this.visibility = null, this.beingDrawn = !1, this.lastDrawnTime = 0, this.lastTouchTime = 0
    }

    function s(n) {
        switch (n) {
            case SeadragonOverlayPlacement.TOP_LEFT:
                return function () { };
            case SeadragonOverlayPlacement.TOP:
                return function (n, t) {
                    n.x -= t.x / 2
                };
            case SeadragonOverlayPlacement.TOP_RIGHT:
                return function (n, t) {
                    n.x -= t.x
                };
            case SeadragonOverlayPlacement.RIGHT:
                return function (n, t) {
                    n.x -= t.x, n.y -= t.y / 2
                };
            case SeadragonOverlayPlacement.BOTTOM_RIGHT:
                return function (n, t) {
                    n.x -= t.x, n.y -= t.y
                };
            case SeadragonOverlayPlacement.BOTTOM:
                return function (n, t) {
                    n.x -= t.x / 2, n.y -= t.y
                };
            case SeadragonOverlayPlacement.BOTTOM_LEFT:
                return function (n, t) {
                    n.y -= t.y
                };
            case SeadragonOverlayPlacement.LEFT:
                return function (n, t) {
                    n.y -= t.y / 2
                };
            case SeadragonOverlayPlacement.CENTER:
            default:
                return function (n, t) {
                    n.x -= t.x / 2, n.y -= t.y / 2
                }
        }
    }

    function r(n, t, i) {
        this.elmt = n, this.scales = t instanceof SeadragonRect, this.bounds = new SeadragonRect(t.x, t.y, t.width, t.height), this.adjust = s(t instanceof SeadragonPoint ? i : SeadragonOverlayPlacement.TOP_LEFT), this.position = new SeadragonPoint(t.x, t.y), this.size = new SeadragonPoint(t.width, t.height), this.style = n.style, this.naturalSize = new SeadragonPoint(n.clientWidth, n.clientHeight)
    }
    for (var p = 100, h = .5, f = SeadragonUtils.getBrowser(), g = SeadragonUtils.getBrowserVersion(), nt = navigator.userAgent, b = !!document.createElement("canvas").getContext, w = document.documentElement || {}, l = w.style || {}, u = !1, d = ["msTransform", "WebkitTransform", "MozTransform"], n, e; n = d.shift(); ) if (typeof l[n] != "undefined") {
        u = !0, e = /webkit/i.test(n);
        break
    }
    var tt = "-webkit-transform",
		k = "WebkitTransition",
		ut = typeof l[k] != "undefined",
		a = "progid:DXImageTransform.Microsoft.Matrix",
		it = new RegExp(a + "\\(.*?\\)", "g"),
		rt = function () {
		    try {
		        return f == SeadragonBrowser.IE && !!document.documentElement.filters
		    } catch (n) {
		        return !1
		    }
		} (),
		v = f == SeadragonBrowser.SAFARI && g < 4,
		i = b && !v,
		o = !i && u,
		c = !1,
		y = typeof document.documentMode != "undefined" ? "bicubic" : "nearest-neighbor";
    t.prototype.toString = function () {
        return this.level + "/" + this.x + "_" + this.y
    }, t.prototype.drawHTML = function (t) {
        var f, s;
        if (!this.loaded) {
            SeadragonDebug.error("Attempting to draw tile " + this.toString() + " when it's not yet loaded.");
            return
        }
        this.elmt || (this.elmt = SeadragonUtils.makeNeutralElement("img"), this.elmt.src = this.url, this.style = this.elmt.style, this.style.position = "absolute", this.style.msInterpolationMode = y, o && (this.style[n + "Origin"] = "0px 0px"));
        var h = this.elmt,
			l = this.image,
			u = this.style,
			i = this.position,
			r = this.size;
        h.parentNode != t && t.appendChild(h), o ? u[n] = ["matrix(", (r.x / l.width).toFixed(8), ",0,0,", (r.y / l.height).toFixed(8), ",", i.x.toFixed(8), e ? "," : "px,", i.y.toFixed(8), e ? ")" : "px)"].join("") : c ? (f = t.clientWidth, s = t.clientHeight, u.width = f + "px", u.height = s + "px", u.filter = ["progid:DXImageTransform.Microsoft.Matrix(", "M11=", (r.x / f).toFixed(8), ",M22=", (r.y / s).toFixed(8), ",Dx=", i.x.toFixed(8), ",Dy=", i.y.toFixed(8), ")"].join("")) : (i = i.apply(Math.floor), r = r.apply(Math.ceil), u.left = i.x + "px", u.top = i.y + "px", u.width = r.x + "px", u.height = r.y + "px"), SeadragonUtils.setElementOpacity(h, this.opacity)
    }, t.prototype.drawCanvas = function (n) {
        if (!this.loaded) {
            SeadragonDebug.error("Attempting to draw tile " + this.toString() + " when it's not yet loaded.");
            return
        }
        var i = this.position,
			t = this.size;
        n.globalAlpha = this.opacity, n.drawImage(this.image, i.x, i.y, t.x, t.y)
    }, t.prototype.unload = function () {
        this.elmt && this.elmt.parentNode && this.elmt.parentNode.removeChild(this.elmt), this.elmt = null, this.image = null, this.loaded = !1, this.loading = !1
    }, SeadragonOverlayPlacement = Seadragon.OverlayPlacement = {
        CENTER: 0,
        TOP_LEFT: 1,
        TOP: 2,
        TOP_RIGHT: 3,
        RIGHT: 4,
        BOTTOM_RIGHT: 5,
        BOTTOM: 6,
        BOTTOM_LEFT: 7,
        LEFT: 8
    }, r.prototype.destroy = function () {
        var t = this.elmt,
			n = this.style;
        t.parentNode && t.parentNode.removeChild(t), n.top = "", n.left = "", n.position = "", this.scales && (n.width = "", n.height = "")
    }, r.prototype.drawHTML = function (t) {
        var e = this.elmt,
			i = this.style,
			l = this.scales,
			o = this.naturalSize,
			f, r, h, s;
        e.parentNode != t && (t.appendChild(e), i.position = "absolute", o.x = e.clientWidth, o.y = e.clientHeight), f = this.position, r = this.size, l || (r.x = o.x = o.x || e.clientWidth, r.y = o.y = o.y || e.clientHeight), this.adjust(f, r), SeadragonConfig.transformOverlays && u ? (i[n + "Origin"] = "0px 0px", i[n] = ["translate(", f.x.toFixed(8), "px,", f.y.toFixed(8), "px)"].join(""), l && (e.clientWidth || (i.width = "100%"), e.clientHeight || (i.height = "100%"), i[n] += [" scale(", (r.x / e.clientWidth).toFixed(8), ",", (r.y / e.clientHeight).toFixed(8), ")"].join(""))) : SeadragonConfig.transformOverlays && c ? (h = t.clientWidth, s = t.clientHeight, i.width = h + "px", i.height = s + "px", i.filter = ["progid:DXImageTransform.Microsoft.Matrix(", "M11=", (r.x / h).toFixed(8), ",M22=", (r.y / s).toFixed(8), ",Dx=", f.x.toFixed(8), ",Dy=", f.y.toFixed(8), ")"].join("")) : (f = f.apply(Math.floor), r = r.apply(Math.ceil), i.left = f.x + "px", i.top = f.y + "px", l && (i.width = r.x + "px", i.height = r.y + "px"))
    }, r.prototype.update = function (n, t) {
        this.scales = n instanceof SeadragonRect, this.bounds = new SeadragonRect(n.x, n.y, n.width, n.height), this.adjust = s(n instanceof SeadragonPoint ? t : SeadragonOverlayPlacement.TOP_LEFT)
    }, SeadragonDrawer = Seadragon.Drawer = function (n, u, e) {
        function dt(t) {
            return tt[t] || (tt[t] = n.getNumTiles(t)), tt[t]
        }

        function bt(t) {
            return b[t] || (b[t] = n.getPixelRatio(t)), b[t]
        }

        function kt(i, r, u, f, e, o) {
            var c;
            if (l[i] || (l[i] = {}), l[i][r] || (l[i][r] = {}), !l[i][r][u]) {
                var h = (e + r % e) % e,
					s = (o + u % o) % o,
					a = n.getTileBounds(i, h, s),
					v = n.tileExists(i, h, s),
					y = n.getTileUrl(i, h, s,gamma,contrast,light,rgbR,rgbG,rgbB);
                a.x += 1 * (r - h) / e, a.y += d * (u - s) / o, l[i][r][u] = new t(i, r, u, a, v, y)
            }
            return c = l[i][r][u], c.lastTouchTime = f, c
        }
        function ot(n, t) {
            n.loading = ni.loadImage(n.url, SeadragonUtils.createCallback(null, et, n, t))
        }

        function et(n, t, i) {
            var o, f, u;
            if (n.loading = !1, nt) {
                SeadragonDebug.error("Tile load ca    llback in middle of drawing routine.");
                return
            }
            if (i) {
                if (t < rt) {
                    SeadragonDebug.log("Ignoring tile " + n + " loaded before reset: " + n.url);
                    return
                }
            } else {
                SeadragonDebug.log("Tile " + n + " failed to load: " + n.url), n.exists = !1;
                return
            }
            if (n.loaded = !0, n.image = i, o = v.length, v.length >= p) {
                var y = Math.ceil(Math.log(yt) / Math.log(2)),
					r = null,
					e = -1;
                for (f = v.length - 1; f >= 0; f--) {
                    if (u = v[f], u.level <= y || u.beingDrawn) continue;
                    else if (!r) {
                        r = u, e = f;
                        continue
                    }
                    var h = u.lastTouchTime,
						s = r.lastTouchTime,
						a = u.level,
						l = r.level;
                    (h < s || h == s && a > l) && (r = u, e = f)
                }
                r && e >= 0 && (r.unload(), o = e)
            }
            v[o] = n, c = !0
        }

        function ut() {
            l = {}, v = []
        }

        function y(n, t, i) {
            var u, e, r, f;
            if (!o[n]) return !1;
            if (t === undefined || i === undefined) {
                u = o[n];
                for (e in u) if (u.hasOwnProperty(e)) {
                    r = u[e];
                    for (f in r) if (r.hasOwnProperty(f) && !r[f]) return !1
                }
                return !0
            }
            return o[n][t] === undefined || o[n][t][i] === undefined || o[n][t][i] === !0
        }

        function st(n, t, i) {
            return t === undefined || i === undefined ? y(n + 1) : y(n + 1, 2 * t, 2 * i) && y(n + 1, 2 * t, 2 * i + 1) && y(n + 1, 2 * t + 1, 2 * i) && y(n + 1, 2 * t + 1, 2 * i + 1)
        }

        function ht(n, t, i, r) {
            if (!o[n]) {
                SeadragonDebug.error("Setting coverage for a tile before its level's coverage has been reset: " + n);
                return
            }
            o[n][t] || (o[n][t] = {}), o[n][t][i] = r
        }

        function lt(n) {
            o[n] = {}
        }

        function ct(n, t) {
            return n ? t.visibility > n.visibility ? t : t.visibility == n.visibility && t.distance < n.distance ? t : n : t
        }

        function k(n) {
            for (var t = s.length - 1; t >= 0; t--) if (s[t].elmt == n) return t;
            return -1
        }

        function ft() {
            var r, oi, hi, e, o, rt, ci, ni, t, ki, l;
            c = !1;
            for (var ti = a, ar = vt, bu = w, yr = i, tt = gt; tt.length > 0; ) t = tt.pop(), t.beingDrawn = !1;
            var or = u.getContainerSize(),
				er = or.x,
				sr = or.y;
            yr ? (ti.width = er, ti.height = sr, ar.clearRect(0, 0, er, sr)) : ti.innerHTML = "";
            var cr = u.getBounds(!0),
				k = cr.getTopLeft(),
				b = cr.getBottomRight();
            if ((SeadragonConfig.wrapHorizontal || !(b.x < 0) && !(k.x > 1)) && (SeadragonConfig.wrapVertical || !(b.y < 0) && !(k.y > d))) {
                var pr = dt,
					fi = bt,
					kr = kt,
					br = st,
					ut = ht,
					ru = lt,
					lu = y,
					au = at,
					yu = it,
					vu = f === SeadragonBrowser.CHROME,
					pu = Math.abs,
					wu = Math.ceil,
					vi = Math.floor,
					ft = Math.log,
					yi = Math.max,
					v = Math.min,
					p = u.deltaPixelsFromPoints,
					et = u.pixelFromPoint,
					hr = n.getTileAtPoint,
					uu = SeadragonConfig.alwaysBlend,
					si = 1e3 * SeadragonConfig.blendTime,
					hu = SeadragonConfig.immediateRender,
					ei = SeadragonConfig.minZoomDimension,
					ku = SeadragonConfig.minImageRatio,
					li = SeadragonConfig.wrapHorizontal,
					ai = SeadragonConfig.wrapVertical,
					vr = SeadragonConfig.wrapOverlays;
                li || (k.x = yi(k.x, 0), b.x = v(b.x, 1)), ai || (k.y = yi(k.y, 0), b.y = v(b.y, d));
                var ui = null,
					ri = !1,
					g = +new Date,
					lr = u.getCenter(),
					ou = et(lr),
					nu = p(fi(0), !1).x,
					bi = hu ? 1 : nu;
                ei = ei || 64;
                var ii = yi(pt, vi(ft(ei) / ft(2))),
					su = p(fi(0), !0).x,
					wi = v(wt, vi(ft(su / h) / ft(2)));
                for (ii = v(ii, wi), r = wi; r >= ii; r--) {
                    if (oi = !1, hi = p(fi(r), !0).x, !ri && hi >= h || r == ii) oi = !0, ri = !0;
                    else if (!ri) continue;
                    ru(r);
                    var fu = v(1, (hi - .5) / .5),
						eu = p(fi(r), !1).x,
						cu = bi / pu(bi - eu),
						rr = hr(r, k),
						nt = hr(r, b),
						ir = pr(r),
						fr = ir.x,
						ur = ir.y;
                    for (li || (nt.x = v(nt.x, fr - 1)), ai || (nt.y = v(nt.y, ur - 1)), e = rr.x; e <= nt.x; e++) for (o = rr.y; o <= nt.y; o++) if ((t = kr(r, e, o, g, fr, ur), rt = oi, ut(r, e, o, !1), t.exists) && (ri && !rt && (br(r, e, o) ? ut(r, e, o, !0) : rt = !0), rt)) {
                        var tr = t.bounds.getTopLeft(),
							di = t.bounds.getSize(),
							wr = et(tr, !0),
							pi = p(di, !0);
                        au || (pi = pi.plus(new SeadragonPoint(1, 1)));
                        var dr = et(tr, !1),
							tu = p(di, !1),
							iu = dr.plus(tu.divide(2)),
							gr = ou.distanceTo(iu);
                        t.position = wr, t.size = pi, t.distance = gr, t.visibility = cu, t.loaded ? (t.blendStart || (t.blendStart = g), ci = g - t.blendStart, ni = si === 0 ? 1 : v(1, ci / si), uu && (ni *= fu), t.opacity = ni, tt.push(t), ni >= 1 ? (ut(r, e, o, !0), vu && t.lastDrawnTime !== yu && ut(r, e, o, !1)) : ci < si && (c = !0), t.lastDrawnTime = g) : t.loading || (ui = ct(ui, t))
                    }
                    if (lu(r)) break
                }
                for (l = tt.length - 1; l >= 0; l--) t = tt[l], yr ? t.drawCanvas(ar) : t.drawHTML(ti), t.beingDrawn = !0;
                for (ki = s.length, l = 0; l < ki; l++) {
                    var yt = s[l],
						nr = yt.bounds,
						gi = nr.getTopLeft();
                    vr && li && (gi.x += vi(lr.x)), vr && ai, yt.position = et(gi, !0), yt.size = p(nr.getSize(), !0), yt.drawHTML(w)
                }
                ui && (ot(ui, g), c = !0), it = g
            }
        }
        var w = SeadragonUtils.getElement(e),
			a = SeadragonUtils.makeNeutralElement(i ? "canvas" : "div"),
			vt = i ? a.getContext("2d") : null,
			ni = new SeadragonImageLoader,
			g = new SeadragonProfiler,
			pt = n.minLevel,
			wt = n.maxLevel,
			yt = n.tileSize,
			at = n.tileOverlap,
			d = n.height / n.width,
			tt = {},
			b = {},
			l = {},
			v = [],
			o = {},
			s = [],
			gt = [],
			it = 0,
			rt = 0,
			nt = !1,
			c = !0,
            gamma=1.5,contrast=1,light=0,rgbR=0,rgbG=0,rgbB=0;
            a.id="slide";

        this.elmt = w, this.profiler = g, function () {
            a.style.width = "100%", a.style.height = "100%", a.style.position = "absolute", w.style.textAlign = "left", w.appendChild(a)
        } (), this.addOverlay = function (n, t, i) {
            var n = SeadragonUtils.getElement(n);
            k(n) >= 0 || (s.push(new r(n, t, i)), c = !0)
        }, this.updateOverlay = function (n, t, i) {
            var n = SeadragonUtils.getElement(n),
				r = k(n);
            r >= 0 && (s[r].update(t, i), c = !0)
        }, this.removeOverlay = function (n) {
            var n = SeadragonUtils.getElement(n),
				t = k(n);
            t >= 0 && (s[t].destroy(), s.splice(t, 1), c = !0)
        }, this.clearOverlays = function () {
            while (s.length > 0) s.pop().destroy(), c = !0
        }, this.needsUpdate = function () {
            return c
        }, this.numTilesLoaded = function () {
            return v.length
        }, this.reset = function () {
            ut(), rt = +new Date, c = !0
        }, this.update = function () {
            g.beginUpdate(), nt = !0, ft(), nt = !1, g.endUpdate()
        }, this.idle = function () { }, this.useCanvas = function () {
            return i
        }, this.getCanvas = function () {
            return a
        },this.UpdateUrl=function(Gamma,Contrast,Light,RgbR,RgbG,RgbB){
        gamma=Gamma,contrast=Contrast,light=Light,rgbR=RgbR,rgbG=RgbG,rgbB=RgbB;
        }
    }
})();
var SeadragonViewer, SeadragonControlAnchor;
(function () {
    function c(n, t, i) {
        t == SeadragonControlAnchor.TOP_RIGHT || t == SeadragonControlAnchor.BOTTOM_RIGHT ? i.insertBefore(n, i.firstChild) : i.appendChild(n)
    }

    function n(n, t, i) {   //
        var r = SeadragonUtils.makeNeutralElement("span");
        this.elmt = n, this.anchor = t, this.container = i, this.wrapper = r, r.style.display = "inline-block", r.appendChild(n), t == SeadragonControlAnchor.NONE && (r.style.width = r.style.height = "100%"), c(r, t, i)
    }
    var h = "----seadragon----",
		l = SeadragonUtils.getBrowser();
    SeadragonControlAnchor = Seadragon.ControlAnchor = {
        NONE: 0,
        TOP_LEFT: 1,
        TOP_RIGHT: 2,
        BOTTOM_RIGHT: 3,
        BOTTOM_LEFT: 4
    }, n.prototype.destroy = function () {
        this.wrapper.removeChild(this.elmt), this.container.removeChild(this.wrapper)
    }, n.prototype.isVisible = function () {
        return this.wrapper.style.display != "none"
    }, n.prototype.setVisible = function (n) {
        this.wrapper.style.display = n ? "inline-block" : "none"
    }, n.prototype.setOpacity = function (n) {
        this.elmt[h] && l == SeadragonBrowser.IE ? SeadragonUtils.setElementOpacity(this.elmt, n, !0) : SeadragonUtils.setElementOpacity(this.wrapper, n, !0)
    };
    var o = "fullpage",
		e = "home",
		t = "zoomin",
		i = "zoomout",
		f = "_rest.png",
		u = "_grouphover.png",
		r = "_hover.png",
		s = "_pressed.png";
    SeadragonViewer = Seadragon.Viewer = function (t) {
        function ai() {
            var i = o.style,
				n = t.style,
				f = rt.style,
				e = ut.style,
				r = ft.style,
				u = it.style;
            n.width = "100%",
            n.height = "100%",
             n.position = "relative",
              n.left = "0px",
               n.top = "0px",
              n.textAlign = "left",
               i.width = "100%",
               i.height = "100%",
                i.overflow = "hidden",
                 i.position = "absolute",
                  i.top = "0px",
                  i.left = "0px",
                  f.position = e.position = r.position = u.position = "absolute",
                   f.top = e.top = "0px",
                   f.left = u.left = "0px",
                    e.right = r.right = "0px",
                     u.bottom = r.bottom = "0px",
                     s.clickHandler = hi,
                     s.pressHandler = ui,
                     s.dragHandler = fi, //鼠标拖动事件 harry
                      s.releaseHandler = si, //释放事件 harry
                      s.scrollHandler = oi, //鼠标滚动事件 harry
                      s.setTracking(!0),
                      d.enterHandler = lt,
                      d.exitHandler = ot,
                      d.releaseHandler = vi,
                       d.setTracking(!0),
                       window.setTimeout(b, 1),
                        t.appendChild(o),
                         t.appendChild(rt),
                          t.appendChild(ut),
                          t.appendChild(ft),
                           t.appendChild(it),
                            a.innerHTML = "",
                            a.appendChild(t)
        }

        function k(n) {
            var i = document.createTextNode(n),
				t;
            o.innerHTML = "",
            o.appendChild(SeadragonUtils.makeCenteredNode(i)),
            t = i.parentNode.style,
             t.fontFamily = "verdana",
             t.fontSize = "13px",
              t.fontSizeAdjust = "none",
              t.fontStyle = "normal",
               t.fontStretch = "normal",
               t.fontVariant = "normal",
                t.fontWeight = "normal",
                t.lineHeight = "1em",
                t.textAlign = "center",
                 t.textDecoration = "none"
        }

        function kt() {
            return e && st(), y = +new Date, window.setTimeout(function () {
                y > ri && k(SeadragonStrings.getString("Messages.Loading"))
            }, 2e3), y
        }

        function tt(n, u, s) {
            if (ri = +new Date, n < y) {
                SeadragonDebug.log("Ignoring out-of-date open."), f.trigger("ignore", r);
                return
            }
            if (!u) {
                k(s), f.trigger("error", r);
                return
            }
            if (o.innerHTML = "", h = SeadragonUtils.getElementSize(t), h.x === 0 || h.y === 0) {
                window.setTimeout(function () {
                    tt(n, u, s)
                }, 10);
                return
            }
            e = u, i = new SeadragonViewport(h, e.dimensions), l = new SeadragonDrawer(e, i, o), v = new SeadragonProfiler, r.source = e, r.viewport = i, r.drawer = l, r.profiler = v, c = !1, w = !0, at(li), f.trigger("open", r)
        }

        function st() {
            r.source = e = null, r.viewport = i = null, r.drawer = l = null, r.profiler = v = null, o.innerHTML = ""
        }

        function at(n, t) {
            if (c) return window.setTimeout(n, 1);
            var i = +new Date,
				t = t ? t : i,
				u = t + 1e3 / 60,
				r = Math.max(1, u - i);
            return window.setTimeout(n, r)
        }

        function vt() {
            var n, u;
            e && (v.beginUpdate(), n = SeadragonUtils.getElementSize(t), !n.equals(h) && n.x > 0 && n.y > 0 && (i.resize(n, !0), h = n, f.trigger("resize", r)), u = i.update(), !c && u && (f.trigger("animationstart", r), ct()), u ? (l.update(), f.trigger("animation", r)) : w || l.needsUpdate() ? (l.update(), w = !1, f.trigger("animation", r)) : l.idle(), c && !u && (f.trigger("animationfinish", r), p || b()), c = u, v.endUpdate())
        }

        function li() {
            if (e) {
                var n = +new Date;
                vt(), at(arguments.callee, n)
            }
        }

        function yt(n) {
            for (var t = u.length - 1; t >= 0; t--) if (u[t].elmt == n) return t;
            return -1
        }

        function ht() {
            window.setTimeout(ci, 20)
        }

        function ci() {
            var t;
            if (g) {
                var i = +new Date,
					r = i - ii,
					n = 1 - r / yi;
                for (n = Math.min(1, n), n = Math.max(0, n), t = u.length - 1; t >= 0; t--) u[t].setOpacity(n);
                n > 0 && ht()
            }
        }

        function ct() {
            g = !1;
            for (var n = u.length - 1; n >= 0; n--) u[n].setOpacity(1)
        }

        function b() {
            SeadragonConfig.autoHideControls && (g = !0, ii = +new Date + dt, window.setTimeout(ht, dt))
        }

        function lt() {
            p = !0, ct()
        }

        function ot(n, t, i) {
            i || (p = !1, c || b())
        }

        function vi(n, t, i, r) {
            r || (p = !1, c || b())
        }

        function hi(n, t, r, u) {
            if (i && r) {
                var f = SeadragonConfig.zoomPerClick,
					e = u ? 1 / f : f;
                i.zoomBy(e, i.pointFromPixel(t, !0)), i.applyConstraints()
            }
        }

        function ui(n, t) {
            i && (gt = t, ti = i.getCenter())
        }

        function fi(n, t, r) //鼠标拖动事件 harry
        {
            var cc;
            if (i) if (SeadragonConfig.constrainDuringPan) {
                var e = t.minus(gt),
					f = i.deltaPointsFromPixels(e.negate(), !0);
                //modified by harry
                cc = ti.plus(f);
                i.panTo(cc), i.applyConstraints();
                //i.panTo(ti.plus(f)), i.applyConstraints();

                //added by harry 不能使用，也拖动，客户端就跑到了左上角
                /*
                if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
                {
                    var currentZoom = ($("#xbl").text());
                    var msgcontent = "mousedrag|" + cc.x + ";" + cc.y  +"|"+SeadragonConfig.constrainDuringPan + "|czoom#" + currentZoom;
                    //alert("cc.x = " + cc.x);
                    SendMsg(msgcontent);
                }
                */
            } else //
            {
                //modified by harry
                cc = i.deltaPointsFromPixels(r.negate(), !0);
                i.panBy(cc);
                //i.panBy(i.deltaPointsFromPixels(r.negate(), !0));
            }

           
        }

        function si(n, t, r) //释放事件 harry
        {
            r && i && i.applyConstraints()
        }

        function oi(n, t, r) //滚动事件 harry
        {
            if (i) {
                var f = Math.pow(SeadragonConfig.zoomPerScroll, r);//Math.pow(底数,几次方)
                /*
                console.log("f = " + f);
                console.log("t = " + t);
                console.log("r = " + r);
                f：缩放的大小
                r：正向放大，值为1，反向缩小，值为-1
                t：滚动缩放时，鼠标的位置
                */
                i.zoomBy(f, i.pointFromPixel(t, !0)), i.applyConstraints();
                /*
                if (sign != null && sign == "1" && master != null && master == "1") //sign=使用同步功能，master=表示是否主控端
                {
                    var center = i.getCenter();
                    var WindowHeight = document.body.clientHeight;
                    var WindowWidth = document.body.clientWidth;
                    SendMsg("mousescroll|" + f + "|" + t.x/WindowWidth + "|" + t.y/WindowHeight + "|center#" + center.x + "#" + center.y);
                    //SendMsg("mousescroll|" + f + "|" + t.x/WindowWidth + "|" + t.y/WindowHeight);
                }
                */
            }
        }

        function et(n) {
            n = SeadragonUtils.getEvent(n), n.keyCode === 27 && r.setFullPage(!1)
        }
        var r = this,
			a = SeadragonUtils.getElement(t),  //a为 id为container_viewer的div
			t = SeadragonUtils.makeNeutralElement("div"),    //生成六个未命名的div
			o = SeadragonUtils.makeNeutralElement("div"),
			rt = SeadragonUtils.makeNeutralElement("div"),
			ut = SeadragonUtils.makeNeutralElement("div"),
			ft = SeadragonUtils.makeNeutralElement("div"),
			it = SeadragonUtils.makeNeutralElement("div"),
			e = null,
			l = null,
			i = null,
			v = null,
			f = new SeadragonEventManager, //事件管理
			s = new SeadragonMouseTracker(o), //鼠标事件跟踪
			d = new SeadragonMouseTracker(t), //鼠标事件跟踪
			u = [],
			g = !0,
			ii = null,
			ei = null,
			dt = 1e3,
			yi = 2e3,
			ii = null,
			g = !1,
			ni = document.body.style.width, //body的宽
			bt = document.body.style.height, //body的高
			pt = document.body.style.overflow, //body的滚轴
			wt = document.documentElement.style.overflow, //body元素的滚轴
			nt = new SeadragonPoint(1, 1), //定义个坐标（1,1）
			h = null,
			y = 0,
			ri = 0,
			gt = null,
			ti = null,
			c = !1,
			w = !1,
			p = !1;
        this.container = a, //显示容器
        this.elmt = t,
         this.source = null, //图片源
          this.drawer = null,
          this.viewport = null,
          this.profiler = null,
          this.tracker = s,
          this.isOpen = function () {
              return !!e
          },
         this.openDzi = function (n, t) {
             var r = kt(),
				i = SeadragonUtils.createCallback(null, tt, r);
             switch (typeof n) {
                 case "string":
                     SeadragonDziTileSource.createFromXml(n, t, i);
                     break;
                 default:
                     SeadragonDziTileSource.createFromJson(n, i)
             }
         },
         this.openTileSource = function (n) {   //n=new SeadragonLiYTileSource(Number(n.Width), Number(n.Height), Number(n.TileSize), 0, ".jpg", n.Rate, n.FileNum, n.ID, i.provider)
             var t = kt();
             window.setTimeout(function () {
                 tt(t, n)
             }, 1)
         },
         this.close = function () {
             e && st()
         },
        this.addControl = function (i, r) {
            var i = SeadragonUtils.getElement(i),
				f;
            if (!(yt(i) >= 0)) {
                f = null;
                switch (r) {
                    case SeadragonControlAnchor.TOP_RIGHT:
                        f = ut, i.style.position = "relative";
                        break;
                    case SeadragonControlAnchor.BOTTOM_RIGHT:
                        f = ft, i.style.position = "relative";
                        break;
                    case SeadragonControlAnchor.BOTTOM_LEFT:
                        f = it, i.style.position = "relative";
                        break;
                    case SeadragonControlAnchor.TOP_LEFT:
                        f = rt, i.style.position = "relative";
                        break;
                    case SeadragonControlAnchor.NONE:
                    default:
                        f = t, i.style.position = "absolute"
                }
                u.push(new n(i, r, f))    //
            }
        },
         this.removeControl = function (n) {
             var n = SeadragonUtils.getElement(n),
				t = yt(n);
             t >= 0 && (u[t].destroy(), u.splice(t, 1))
         },
        this.clearControls = function () {
            while (u.length > 0) u.pop().destroy()
        },
        this.getNavControl = function () {
            return ei
        },
         this.isDashboardEnabled = function () {
             for (var n = u.length - 1; n >= 0; n--) if (u[n].isVisible()) return !0;
             return !1
         },
         this.isFullPage = function () {
             return t.parentNode == document.body
         },
        this.isMouseNavEnabled = function () {
            return s.isTracking()
        },
        this.isVisible = function () {
            return t.style.visibility != "hidden"
        },
         this.setDashboardEnabled = function (n) {
             for (var t = u.length - 1; t >= 0; t--) u[t].setVisible(n)
         },
        this.setFullPage = function (n) {
            var l, c;
            if (n != r.isFullPage()) {
                var y = document.body,
					u = y.style,
					v = document.documentElement.style,
					e = t.style,
					s = o.style;
                n ? (pt = u.overflow, wt = v.overflow, u.overflow = "hidden", v.overflow = "hidden", ni = u.width, bt = u.height, u.width = "100%", u.height = "100%", s.backgroundColor = "black", s.color = "white", e.position = "fixed", e.zIndex = "99999999", y.appendChild(t), h = SeadragonUtils.getWindowSize(), SeadragonUtils.addEvent(document, "keydown", et), lt()) : (u.overflow = pt, v.overflow = wt, u.width = ni, u.height = bt, s.backgroundColor = "", s.color = "", e.position = "relative", e.zIndex = "", a.appendChild(t), h = SeadragonUtils.getElementSize(a), SeadragonUtils.removeEvent(document, "keydown", et), ot()), i && (l = i.getBounds(), i.resize(h), c = i.getBounds(), n ? nt = new SeadragonPoint(c.width / l.width, c.height / l.height) : (i.update(), i.zoomBy(Math.max(nt.x, nt.y), null, !0)), w = !0, f.trigger("resize", r), vt())
            }
        },
         this.setMouseNavEnabled = function (n) {
             s.setTracking(n)
         },
         this.setVisible = function (n) {
             t.style.visibility = n ? "" : "hidden"
         },
        this.showMessage = function (n, t) {
            if (!t) {
                k(n);
                return
            }
            window.setTimeout(function () {
                r.isOpen() || k(n)
            }, t)
        },
         this.addEventListener = function (n, t) {
             f.addListener(n, t)
         },
        this.removeEventListener = function (n, t) {
            f.removeListener(n, t)
        },
        this.trigger = function () {
            f.trigger.apply(r, arguments)
        },
        ai()
    }
})();