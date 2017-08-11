var Ruler = function (n, t, i, r) {
    Measure.apply(this, [n, t]),
    this.divisionMark = 5,
    this.divisionMajorMark = this.defaultPadding,
    this.divisionNum = 5,
    this.containerSize = new Size(i, r),
    this.zeroPoint,
    this.draw = function (n, t) {
        var o, f, e;
        if (this.refresh(n, t), o = this.cellWidth * this.cavScale / this.calibration, this.autoAdjustCellWidth) {
            if (o < this.minCellWidth) {
                this.cellWidth *= 2,
                this.draw(n, t);
                return
            }
            if (o > this.maxCellWidth) {
                this.cellWidth /= 2,
                this.draw(n, t);
                return
            }
        }
        this.zeroPoint = new Point(this.cavOffset.x, this.cavOffset.y);
        var h = o / this.divisionNum,
        s = 0,
        i = this.getContext();
        i.beginPath(),
                i.fillStyle = "#ffffff",
        i.fillRect(this.location.x, this.location.y, this.containerSize.width, this.divisionMajorMark),
        i.fillRect(this.location.x, this.location.y, this.divisionMajorMark, this.containerSize.height),
        i.font = "12px Microsoft Sans Serif,\u5b8b\u4f53",
                i.fillStyle = this.color;
        var r = this.location.x + this.divisionMajorMark,
        u = this.location.y + this.divisionMajorMark,
        t = new Point(r + this.cavOffset.x, u + this.cavOffset.y),
        l = t.x % o - r,
        c = t.y % o - u;
        for (i.moveTo(r, u), i.lineTo(this.location.x + this.containerSize.width, u), f = l; f < this.containerSize.width; f += h) {
            if (f < r) {
                s++;
                continue
            }
            s % this.divisionNum == 0 ? (i.moveTo(f, u), i.lineTo(f, u - this.divisionMajorMark), i.fillText(floatRound((f - this.zeroPoint.x) * this.cellWidth / o), f + 2, u / 1.5)) : (i.moveTo(f, u), i.lineTo(f, u - this.divisionMark)),
            s++
        }
        for (i.moveTo(r, u), i.lineTo(r, this.location.y + this.containerSize.height), s = 0, e = c; e < this.containerSize.height; e += h) {
            if (e < u) {
                s++;
                continue
            }
            s % this.divisionNum == 0 ? (i.moveTo(r, e), i.lineTo(r - this.divisionMajorMark, e), i.rotate(Math.PI * 3 / 2), str = floatRound((e - this.zeroPoint.y) * this.cellWidth / o).toString(), i.fillText(str, -(e + str.length * 8), r / 1.5), i.rotate(Math.PI / 2)) : (i.moveTo(r, e), i.lineTo(r - this.divisionMark, e)),
            s++
        }
        i.lineWidth = this.width,
        i.strokeStyle = this.color,
        i.stroke()
    }

    this.draws = function (n, t) {
        this.refresh(n, t);
        var h, cm, cellCm;
        var Param = 1 / this.cavScale, a;
        if (Param <= 1) {
            a = 1;
        }
        else if (Param > 1 && Param < 2) {
            a = 1;
        }
        else {
            a = Param - (Param % 2);
        }
        this.MinlblV = 100 * a;
        if (this.MinlblV < 1000) {
            if (this.MinlblV % 5 != 0) {
                this.MinlblV = this.MinlblV + (this.MinlblV - this.MinlblV % 5);
            }
        }
        else {
            if (this.MinlblV % 5000 != 0) {
                if (this.MinlblV < 5000) {
                    this.MinlblV = 5000;
                }
                else {
                    this.MinlblV = this.MinlblV + (this.MinlblV / 5000 - this.MinlblV % 5000);
                }
            }
        }
        this.xs = this.MinlblV / (Param * this.calibration);
        this.CheckLimtRule(this.xs, this.MinlblV);
        this.UpRuleLayout(this.xs, this.MinlblV)
        
        //        if (this.refresh(n, t), o = this.CellWidth * this.cavScale / this.calibration, this.autoAdjustCellWidth) {
        //            if (o < this.MinCellWidth) {
        //                this.CellWidth *= 2,
        //                this.draws(n, t);
        //                return
        //            }
        //            if (o > this.MaxCellWidth) {
        //                this.CellWidth /= 2,
        //                this.draws(n, t);
        //                return
        //            }
        //        }

        //        h = (o) / this.divisionNum
        //        $("#rulerHeight2").css("left", h + 5)
        //        $("#rulerHeight3").css("left", (h + 5) * 2)
        //        $("#rulerHeight4").css("left", (h + 5) * 3)
        //        $("#rulerHeight5").css("left", (h + 5) * 4)
        //        $("#rulerHeight6").css("left", (h + 5) * 5)
        //        cellCm = (this.CellWidth / 5000);
        //        $("#rulerNum1").text(cellCm * 1)
        //        $("#rulerNum2").text(cellCm * 2)
        //        $("#rulerNum3").text(cellCm * 3)
        //        $("#rulerNum4").text(cellCm * 4)
        //        $("#rulerNum5").text(cellCm * 5)
    }
    this.CheckLimtRule = function () {
        if (this.xs>= this.MinCellWidth + this.MinCellWidth / 2) {
            this.xs = this.xs / 2;
            this.MinlblV = this.MinlblV / 2;
            this.CheckLimtRule()
        }
        if (this.xs < 150) {
            this.xs =this.xs * 2;
            this.MinlblV = this.MinlblV * 2;
        }
    }
    this.UpRuleLayout = function () {
        var k, k1, un;
        if (this.MinlblV >= 1000) {
            k = Math.round(this.MinlblV / 5000*100)/100
            un = "mm";
        }
        else {
            k = this.MinlblV / 5;
            un = "μm";
        }
        k1 = this.xs / 5;
        $("#slideRuler").css("width", this.xs+5);
                $("#rulerHeight2").css("left", k1)
                $("#rulerHeight3").css("left", k1*2)
                $("#rulerHeight4").css("left", k1*3)
                $("#rulerHeight5").css("left", k1*4)
                $("#rulerHeight6").css("left", k1*5)

        $("#rulerNum1").text((k * 1))
        $("#rulerNum2").text((k * 2))
        $("#rulerNum3").text((k * 3))
        $("#rulerNum4").text((k * 4))
        $("#rulerNum5").text((k * 5) + un)
    }
};

