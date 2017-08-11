//var Position;
//function () {
//    Position = function (n, t, i) {
//        Remark.apply(this, [n, t, i])
//    },
//    Position.prototype = new Remark;
//    var n = Position.prototype;
//    n.draw = function (n) {
//        var n = this.getContext();
//        n.beginPath(),
//        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
//        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
//        this.setCSS(this.rsPoint.x, this.rsPoint.y),
//        this.shapeMovePosition(),
//        this.isSelected || this.drawPositionIcon(this.rsPoint)
//    },
//    n.drawPositionIcon = function (n) {
//        if (n != null) {
//            var t = this.getContext(),
//            i = 6.5;
//            t.beginPath(),
//            t.lineWidth = 2,
//            t.arc(n.x, n.y, i, 0, Math.PI * 2, !1),
//            t.fillStyle = "rgba(255, 255, 255, 0.6)",
//            t.fill(),
//            t.strokeStyle = "#666465",
//            t.stroke(),
//            t.beginPath(),
//            t.lineWidth = 3,
//            t.strokeStyle = "#cfb569",
//            t.moveTo(n.x, n.y),
//            t.lineTo(n.x, n.y - i * 2.8),
//            t.stroke(),
//            t.lineTo(n.x + i * 1.6, n.y - i - 2),
//            t.lineTo(n.x, n.y - i - 2),
//            t.fillStyle = "#dd4f37",
//            t.fill()
//        }
//    }
//} ()


    Position = function (n, t, i) {
        Remark.apply(this, [n, t, i])
    },
    Position.prototype = new Remark;
    var n = Position.prototype,img, x, y, url;
    n.draw = function (n) {
        var n = this.getContext();
        n.beginPath();
        this.rsPoint = this.resetPoint(this.startPoint, this.cavScale, this.cavOffset),
        this.rePoint = this.resetPoint(this.endPoint, this.cavScale, this.cavOffset),
        //this.drawPositionIcon(this.rsPoint),

        // n.clearRect(x, y, img.width, img.height);
        img = new Image();
        x = this.rsPoint.x - 28;
        y = this.rsPoint.y - 51;
        url = this.getUrl();
        img.src = url;
        this.shapeMovePosition();
        this.isEndDrawing = true;
        this.active();
        n.drawImage(img, x, y);



        //this.setCSS(this.rsPoint.x, this.rsPoint.y),


    },
    n.getUrl = function () {
        var url;

        switch (this.imageindex) {
            case "1":
                url = "assets/image/pin_1.png";
                break;
            case "2":
                url = "assets/image/pin_2.png";
                break;
            case "3":
                url = "assets/image/pin_3.png";
                break;
            case "4":
                url = "assets/image/pin_4.png";
            default:
                url = "assets/image/pin_1.png";
                break;
        }
        SlideViewerConfig.PositionUrl = url;
        return url;
    }
    n.active = function () {
//        this.isDrawStart = false;
//        this.isEndDrawing = true;
//        this.isSelected = true;
////        this.drawThumb(this.rePoint);
////        this.drawThumb(this.rePoint);
//        this.drawMoveThumb(this.movePoint);
            (this.isEndDrawing || !this.isDrawStart) && this.isSelected && (this.drawThumb(this.rsPoint))
    },
    n.drawPositionIcon = function (n) {
        //        if (n != null) {
        var t = this.getContext()
        //                        i = 6.5;
        //                        t.beginPath(),
        //                        t.lineWidth = 2,
        //                        t.arc(n.x, n.y, i, 0, Math.PI * 2, !1),
        //                        t.fillStyle = "rgba(255, 255, 255, 0.6)",
        //                        t.fill(),
        //                        t.strokeStyle = "#666465",
        //                        t.stroke(),
        //                        t.beginPath(),
        //                        t.lineWidth = 3,
        //                        t.strokeStyle = "#cfb569",
        //                        t.moveTo(n.x, n.y),
        //                        t.lineTo(n.x, n.y - i * 2.8),
        //                        t.stroke(),
        //                        t.lineTo(n.x + i * 1.6, n.y - i - 2),
        //                        t.lineTo(n.x, n.y - i - 2),
        //                        t.fillStyle = "#dd4f37",
        //                        t.fill()

        //        }

    }
