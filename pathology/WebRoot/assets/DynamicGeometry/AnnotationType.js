ClickResult = function () {
    this.isIn = !1,
    this.length = 0,
    this.activeMove,
    this.pIndex
};
Measurement = {},
AnnotationType = {
    NONE: "NONE",
    Line: "Line",  //直线
    Arrow: "Arrow",  //带箭头的直线
    Rectangle: "Rectangle",  //绘制矩形
    Ellipse: "Ellipse",  //绘制椭圆
    Remark: "Remark",  //绘制文本注释
    Position: "Position",  //标记位置
    CurveRounded: "RoundedCurve",  //绘制闭合曲线
    Curve: "Curve",  //绘制自由曲线FreeRoundedCurve 
    Angle: "Angle",  //三点画角度
    Circle: "Circle",  //绘制圆
    CircleThreePoints: "CircleThreePoints",  //三点画圆
    Arc: "Arc",  //3点画弧
    Polygon: "Polygon"  //绘制多边形
};