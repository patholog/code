var Point;
(function () {
    Point = function (n, t) {
        this.x = typeof n == "number" ? n : n * 1,
        this.y = typeof t == "number" ? t : t * 1
    }
})();