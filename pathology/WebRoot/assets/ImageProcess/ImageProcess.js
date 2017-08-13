var ImageProcessing, ImageFilter, SharpnessFilter, ColorEnhancementFilter, IColorFilter, GammaCorrectionFilter, ColorAdjustmentFilter, ColorMappingFilter, ColorFilters;
(function () {
    function e(n) {
        var u, i, r;
        n && n.isChanged() && (u = t.drawer.getCanvas(), f(u, n))//, i = t.getNavMap(), r = i.getCanvas(), r && (i.refresh(), f(r, n)))
    }
    function f(t, i) {
        var e = t.getContext("2d"),
			f = e.getImageData(0, 0, t.width, t.height);
        n.reset(), i.isDefaultGamma() || n.setCorrectionValue(i.gamma, 0), i.isDefaultColorChannel() || n.setContrast(i.contrast, i.red, i.green,i.blue),i.isDefaultColorChannel()||n.setBrightness(i.Brightness,i.Brightness,i.Brightness),i.isDefaultContrast() || n.setGray(i.contrastMin, i.contrastMax), n.refreshLut(), n.filter(f), i.isDefaultSaturation() || (u.setCorrectionValue(i.saturation), u.filter(f)), i.isDefaultSharpness() || (r.setSharpness(i.sharpness), r.filter(f)), e.putImageData(f, 0, 0)
    }
    
    function o() {
        if (SlideViewerSupport.imageAdjustment && SlideViewerConfig.enableImageAdjustment) {
            var n = t.getCurrentImage(),
				i = t.drawer.useCanvas();
            n && n.imageAdjustment && i && n.imageAdjustment.isChanged() && e(n.imageAdjustment)
        }
    }
    var t, n, u, r, i,img;
    ImageProcessing || (ImageProcessing = function (n) {
        t = n
    }, i = ImageProcessing.prototype, i.start = function () {
        n || (n = new ColorFilters), u || (u = new ColorEnhancementFilter), r || (r = new SharpnessFilter), t.addEventListener("animation", o)
    }, i.stop = function () {
        t.removeEventListener("animation")
    }, i.adjust = e)    //},i.adjust=e)
})(), function () {
    if (!ImageFilter) {
        ImageFilter = function () { };
        var n = ImageFilter.prototype;
        n.filter = function () { }
    }
} (), function () {
    function n(n, t, i, r, u) {
        for (var f = 0, f = 0; f < u; f++) n[t + f] = i[r + f]
    }
    if (!SharpnessFilter) {
        SharpnessFilter = function () {
            this.level = 0, ImageFilter.apply(this)
        }, SharpnessFilter.prototype = new ImageFilter;
        var t = SharpnessFilter.prototype;
        t.setSharpness = function (n) {
            n < 0 ? this.level = 0 : n > 10 && (this.level = 10), this.level = n
        }, t.filter = function (t) {
            var o, b, h, r, c, f, e, s, y, v, g, nt, d = this.level,
				a = t.width,
				k = t.height,
				p = 4,
				u, w = 5,
				l = a * p,
				i = t.data;
            if (a < 4 || a > 8196 || k < 4 || k > 8196) return 1;
            for (d > 0 ? (s = -d, y = -s * 4 + 8, v = 3) : (s = -d, s > 8 && (s = 8), y = 32 - 4 * s, v = 5), u = new Array(l * w), n(u, 0, i, 0, l * w), o = 2; o < k - 2; o++) {
                for (h = (o - 1) * l + 7, r = o * l + 7, c = (o + 1) * l + 7, g = o % w * l, nt = (o - 2) % w * l, b = 2; b < a - 2; b++) h++, r++, c++, f = b * p + g, e = i[r] * y + (i[h] + i[c] + i[r - 8] + i[r + 8]) * s >> v, u[f] = e < 0 ? 0 : e > 255 ? 255 : e, h++, r++, c++, f++, e = i[r] * y + (i[h] + i[c] + i[r - 8] + i[r + 8]) * s >> v, u[f] = e < 0 ? 0 : e > 255 ? 255 : e, h++, r++, c++, f++, e = i[r] * y + (i[h] + i[c] + i[r - 8] + i[r + 8]) * s >> v, u[f] = e < 0 ? 0 : e > 255 ? 255 : e, h++, r++, c++, f++, u[f] = i[r];
                n(i, (o - 2) * a * p + 8, u, nt + 8, (a - 4) * p)
            }
            u = null
        }
    }
} (), function () {
    if (!ColorEnhancementFilter) {
        ColorEnhancementFilter = function () {
            this.v = 0, ImageFilter.apply(this)
        };
        var n = ColorEnhancementFilter.prototype;
        n.setCorrectionValue = function (n) {
            n < -10 && (n = -10), n > 10 && (n = 10), this.v = n
        }, n.filter = function (n) {
            var p = n.width,
				w = n.height,
				s = n.data,
				lt = !1,
				i = this.v * 1,
				h, o, v, c, a, d, b, k, st, ut, ot, ct, ht, et, rt, it, ft, g, tt;
            i < -10 && (i = -10), i > 10 && (i = 10);
            var t = new Array(9),
				e = new Array(2560),
				u, r, f, y, o, h, nt, l = 0;
            if (lt) {
                for (u = 0, r = 0, f = 0, y = 0, o = 0; o < w; o++) for (h = 0; h < p; h++) nt = (o * p + h) * 3, u = u + s[nt], r = r + s[nt + 1], f = f + s[nt + 2];
                u = u / (p * w), r = r / (p * w), f = f / (p * w), u < 1 && (u = 1), r < 1 && (r = 1), f < 1 && (f = 1), y = u > r ? u : r, y < f && (y = f), u = y / u, r = y / r, f = y / f
            } else u = 1, r = 1, f = 1;
            for (i < 0 && (i = (i + 10) / 10), i < 1 ? (t[1] = Math.floor(1024 * .587 * (1 - i)), t[2] = Math.floor(1024 * .114 * (1 - i)), t[3] = Math.floor(1024 * .299 * (1 - i)), t[5] = Math.floor(1024 * .114 * (1 - i)), t[6] = Math.floor(1024 * .299 * (1 - i)), t[7] = Math.floor(1024 * .587 * (1 - i)), t[0] = Math.floor(1024 * (.299 + .701 * i)), t[4] = Math.floor(1024 * (.587 + .413 * i)), t[8] = Math.floor(1024 * (.114 + .866 * i))) : (t[1] = Math.floor(1024 * (-i / 10) * r), t[2] = Math.floor(1024 * (-i / 50) * f), t[3] = Math.floor(1024 * (-i / 50) * u), t[5] = Math.floor(1024 * (-i / 20) * f), t[6] = Math.floor(1024 * (-i / 50) * u), t[7] = Math.floor(1024 * (-i / 50) * r), t[0] = Math.floor((1024 - t[1] - t[2]) * u), t[4] = Math.floor((1024 - t[3] - t[5]) * r), t[8] = Math.floor((1024 - t[6] - t[7]) * f)), h = 0; h < 9; h++) for (o = 0; o < 256; o++) e[h * 256 + o] = t[h] * o;
            for (st = 0, ut = 256, ot = 512, ct = 768, ht = 1024, et = 1280, rt = 1536, it = 1792, ft = 2048, g = 0; g < w; g++) for (l = g * p * 4, tt = 0; tt < p; tt++) d = s[l], b = s[l + 1], k = s[l + 2], v = e[st + d] + e[ut + b] + e[ot + k], c = e[ct + d] + e[ht + b] + e[et + k], a = e[rt + d] + e[it + b] + e[ft + k], v < 0 && (v = 0), c < 0 && (c = 0), a < 0 && (a = 0), v = v >> 10, c = c >> 10, a = a >> 10, v > 255 && (v = 255), c > 255 && (c = 255), a > 255 && (a = 255), s[l] = v, s[l + 1] = c, s[l + 2] = a, l += 4
        }
    }
} (), function () {
    IColorFilter || (IColorFilter = function () { }, IColorFilter.prototype.filter = function () { }, IColorFilter.prototype.reset = function () { })
} (), function () {
    if (!GammaCorrectionFilter) {
        GammaCorrectionFilter = function () {
            this.gamma = 1, this.shift = 0, IColorFilter.apply(this)
        };
        var n = GammaCorrectionFilter.prototype;
        n.reset = function () {
            this.gamma = 1, this.shift = 0
        }, n.setCorrectionValue = function (n, t) {
            this.gamma = n, this.shift = t
        }, n.filter = function (n, t, i) {  //图像调整伽马
            var o = new Array(256),
				u = new Array(256),
				s, f, e, r;
            if (this.gamma == 1) for (r = 0; r < 256; r++) o[r] = r;
            else for (r = 0; r < 256; r++) s = r / 256, f = Math.pow(s, this.gamma) * 256 + .0001, f > 255 ? f = 255 : f < 0 && (f = 0), o[r] = Math.floor(f);
            if (e = 255 - this.shift, this.gamma < 1) {
                for (r = 0, r = 0; r <= this.shift; r++) u[r] = 0;
                for (r = this.shift + 1; r < 256; r++) u[r] = Math.floor((r - this.shift) / (e * 1) * 255)
            } else {
                for (r = 255; r >= e; r--) u[r] = 255;
                for (r = e - 1; r >= 0; r--) u[r] = Math.floor(r * 255 / e)
            }
            for (r = 0; r < 256; r++) n[r] = u[o[n[r]]], t[r] = u[o[t[r]]], i[r] = u[o[i[r]]]
        }
    }
} (), function () {     //调整3原色
    if (!ColorAdjustmentFilter) { 
        ColorAdjustmentFilter = function () {
            this.contrasts=1,this.contrast = new Array(3), this.brightness = new Array(3), this.rt = new Array(256), this.gt = new Array(256), this.bt = new Array(256), this.re,this.gr,this.bl,this.co,IColorFilter.apply(this)
        };
        var n = ColorAdjustmentFilter.prototype;
        n.setContrast = function (a,n, t, i) {
            this.contrast[0] = n, this.contrast[1] = t, this.contrast[2] = i,this.contrasts=a
        }, n.setBrightness = function (n, t, i) {
            this.brightness[0] = n, this.brightness[1] = t, this.brightness[2] = i
        }, n.reset = function () {
            this.contrast[0] = 1, this.contrast[1] = 1, this.contrast[2] = 1, this.brightness[0] = 0, this.brightness[1] = 0, this.brightness[2] = 0,this.contrasts=1;
        }, n.filter = function (n, t, i) {
            //for (var f = Math.floor(this.contrast[0] * 256), e = Math.floor(this.contrast[1] * 256), o = Math.floor(this.contrast[2] * 256), u, r = 0; r < 256; r++)u = r, u = (r * o >> 8) + this.brightness[2], this.bt[r] = u < 0 ? 0 : u > 255 ? 255 : u, u = (r * e >> 8) + this.brightness[1], this.gt[r] = u < 0 ? 0 : u > 255 ? 255 : u, u = (r * f >> 8) + this.brightness[0], this.rt[r] = u < 0 ? 0 : u > 255 ? 255 : u;
            //for (r = 0; r < 256; r++) n[r] = this.rt[n[r]], t[r] = this.gt[t[r]], i[r] = this.bt[i[r]]  // u = r, u = (r * o >> 8) + this.brightness[2], this.bt[r] = u < 0 ? 0 : u > 255 ? 255 : u, u = (r * e >> 8) + this.brightness[1], this.gt[r] = u < 0 ? 0 : u > 255 ? 255 : u, u = (r * f >> 8) + this.brightness[0], this.rt[r] = u < 0 ? 0 : u > 255 ? 255 : u;
            this.re= Math.floor((this.contrast[0]-1) * 256+(this.brightness[0]-1)*256), this.gr = Math.floor((this.contrast[1]-1) * 256+(this.brightness[1]-1)*256), this.bl = Math.floor((this.contrast[2]-1) * 256+(this.brightness[2]-1)*256)
        }
    }
} (), function () {
    if (!ColorMappingFilter) {
        ColorMappingFilter = function () {
            this.minGray = 0, this.maxGray = 255,this,constrat=1,IColorFilter.apply(this)
        };
        var n = ColorMappingFilter.prototype;
        n.reset = function () {
            this.minGray = 0, this.maxGray = 255
        }, n.setGray = function (n, t) {
            n < 0 ? n = 0 : n > 255 && (n = 255), t < 0 ? t = 0 : t > 255 && (t = 255), n > t && (t = n), this.minGray = n, this.maxGray = t
        }, n.filter = function (n, t, i) {
            var f = this.minGray,
				e = this.maxGray,
				u = new Array(256),
				o = 0,
				r;
            for (e > f && (o = 255 / (e - f)), r = 0; r < f; r++) u[r] = 0;
            for (r = e; r < 256; r++) u[r] = 255;
            for (r = f; r < e; r++) u[r] = Math.floor((r - f) * o);
            for (r = 0; r < 256; r++) n[r] = u[n[r]], t[r] = u[t[r]], i[r] = u[i[r]]
        }
    }
} (), function () {      //图像调整
    if (!ColorFilters) {
        ColorFilters = function () {
            this.needFilter = !1, this.lutRed = new Array(256), this.lutGreen = new Array(256), this.lutBlue = new Array(256), this.filters = [], this.gammaFilter = new GammaCorrectionFilter, this.mappingFilter = new ColorMappingFilter, this.adjustFilter = new ColorAdjustmentFilter, this.filters.push(this.gammaFilter), this.filters.push(this.mappingFilter), this.filters.push(this.adjustFilter), ImageFilter.apply(this)
        };
        var n = ColorFilters.prototype;
        n.reset = function () {
            for (var n = 0; n < this.filters.length; n++) this.filters[n].reset()
        }, n.setCorrectionValue = function (n, t) {
            this.gammaFilter.setCorrectionValue(n, t)
        }, n.setContrast = function (a,n, t, i) {
            this.adjustFilter.setContrast(a,n, t, i)
        }, n.setBrightness = function (n, t, i) {
            this.adjustFilter.setBrightness(n, t, i)
        }, n.setGray = function (n, t) {
            this.mappingFilter.setGray(n, t)
        }, n.refreshLut = function () {
            for (var t, n = 0; n < 256; n++) this.lutRed[n] = n, this.lutGreen[n] = n, this.lutBlue[n] = n;
            for (t = this.filters.length, n = 0; n < t; n++) this.filters[n].filter(this.lutRed, this.lutGreen, this.lutBlue);
            for (this.needFilter = !1, n = 0; n < 256; n++)if(this.filters[2].re!=0||this.filters[2].gr!=0||this.filters[2].bl!=0||this.filters[2].contrasts!=1){ //if (this.lutRed[n] != n || this.lutGreen[n] != n || this.lutBlue[n] != n) {
                this.needFilter = !0;
                break
            }
        }, n.filter = function (n) {   
            var r;
            if (this.needFilter) {
                var i = n.data,
					u = i.length,
					t = 0;var gray ;
                //for (r = 0; r < u; r += 4) t = r, i[t] = this.lutRed[i[t]], t++, i[t] = this.lutGreen[i[t]], t++, i[t] = this.lutBlue[i[t]]
                
                var a=this.filters[2].re,b=this.filters[2].gr,c=this.filters[2].bl,d=this.filters[2].contrasts;
                for(r=0;r<u;r+=4) gray = .299 * i[t] + .587 * i[t+1] + .114 * i[t+2],t=r,i[t]=((i[t]+a)*d)<0?0:((i[t]+a)*d)>255?255:((i[t]+a)*d),t++,i[t]=((i[t]+b)*d)<0?0:((i[t]+b)*d)>255?255:((i[t]+b)*d),t++,i[t]=((i[t]+c)*d)<0?0:((i[t]+c)*d)>255?255:((i[t]+c)*d);

//                for(r=0;r<u;r+=4) gray = .299 * i[t] + .587 * i[t+1] + .114 * i[t+2],
//                t=r,

            }
        }
    }
} ();