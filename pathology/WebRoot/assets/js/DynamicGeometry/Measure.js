var Measure = function (n, t) {
    self = this,
    this.canvas = n,
    this.calibration = t,
    this.cellWidth = 800,
    this.CellWidth = 2500,
    this.minCellWidth = 48,
    this.MinCellWidth=200,
    this.maxCellWidth = 156,
    this.MaxCellWidth = 260,
    this.xs,
    this.MinlblV,
    this.k,
    this.k1,
    this.un,
    this.cavScale,
    this.cavOffset,
    this.autoAdjustCellWidth = !0,
    this.location = new Point(0, 0),
    this.defaultPadding = 20,
    this.containerSize,
    this.width = 1,
    this.color = "#363736",
    this.getContext = function () {
        return this.canvas.getContext("2d")
    },
    this.refresh = function (n, t) {
        this.cavScale = n,
        this.cavOffset = t
    },
    this.resetContainerSize = function (n, t) {
        this.containerSize = new Size(n, t)
    },
    this.draw = function () { }
};