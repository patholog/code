var OpenSlideResult = function () {
    this.error,
    this.resultCode = -1,
    this.webSiteUrl,
    this.slide
},
AnnotationResult = function () {
    this.error,
    this.resultCode = -1,
    this.webSiteUrl,
    this.annotations = []
},
ReadImageAdjustmentResult = function () {
    this.error,
    this.resultCode = -1,
    this.webSiteUrl,
    this.adjustment
},
UpdateResult = function () {
    this.error,
    this.success = !1
},
SlideInfo = function () {
    this.id = 0,
    this.guid = "",
    this.barcode = "",
    this.name = "unknown",
    this.baseImage = new SlideImage,
    this.ROIs = []
},
ROI = function () {
    this.id = -1,
    this.scanObjective = 0,
    this.x = 0,
    this.y = 0,
    this.width = 0,
    this.height = 0,
    this.hasImage = !1,
    this.image
},
SlideImage = function () {
    this.id,
    this.scanObjective,
    this.calibration = -1,
    this.width = 0,
    this.height = 0,
    this.tileSize = 256,
    this.annotations = [],
    this.hasAnnotations = !1,
    this.imageAdjustment,
    this.tierCount = 1,
    this.tierSpacing = 0
},
AnnotationInfo = function () {
    this.imageId,
    this.guid,
    this.name,
    this.description,
    this.scale,
    this.width,
    this.type,
    this.region,
    this.fontUnderLine,
    this.fontSize,
    this.fontFamily,
    this.fontItalic,
    this.fontBold,
    this.visible,
    this.color,
    this.measurement,
    this.radius,
    this.arcLength,
    this.angle,
    this.points = []
},
ImageAdjustment;
(function () {
    ImageAdjustment = function () {
        this.gamma = 1,
        this.contrastMin = 0,
        this.contrastMax = 255,
        this.contrast=1,
        this.red = 1,
        this.green = 1,
        this.blue = 1,
        this.Brightness=1,
        this.saturation = 0,
        this.sharpness = 0
    },
    ImageAdjustment.prototype.isChanged = function () {
        return !this.isDefaultColorChannel() || !this.isDefaultContrast() || !this.isDefaultGamma() || !this.isDefaultSaturation() || !this.isDefaultSharpness()
    },
    ImageAdjustment.prototype.isDefaultGamma = function () {
        return this.gamma == 1
    },
    ImageAdjustment.prototype.isDefaultContrast = function () {
        return this.contrastMin == 0 && this.contrastMax == 255
    },
    ImageAdjustment.prototype.isDefaultColorChannel = function () {
        return this.red == 1 && this.green == 1 && this.blue == 1&&this.Brightness==1&&this.contrast==1
    },
    ImageAdjustment.prototype.isDefaultSaturation = function () {
        return this.saturation == 0
    },
    ImageAdjustment.prototype.isDefaultSharpness = function () {
        return this.sharpness == 0
    },
    ImageAdjustment.prototype.clone = function () {
        var n = new ImageAdjustment;
        return n.gamma = this.gamma,
        n.contrastMin = this.contrastMin,
        n.contrastMax = this.contrastMax,
        n.red = this.red,
        n.green = this.green,
        n.blue = this.blue,
        n.saturation = this.saturation,
        n.sharpness = this.sharpness,
        n
    },
    ImageAdjustment.prototype.reset = function () {
        this.gamma = 1,
        this.contrastMin = 0,
        this.contrastMax = 255,
        this.red = 1,
        this.green = 1,
        this.blue = 1,
        this.saturation = 0,
        this.sharpness = 0
    },
    ImageAdjustment.prototype.isEquals = function (n) {
        return n ? this.gamma == n.gamma && this.contrastMin == n.contrastMin && this.contrastMax == n.contrastMax && this.red == n.red && this.green == n.green && this.blue == n.blue && this.saturation == n.saturation && this.sharpness == n.sharpness : !1
    }
})();