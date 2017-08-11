var SeadragonLiYTileSource = function (width, height, tileSize, tileOverlap, tileFormat, slideKey, FileNum, ID, Provider, gamma, contrast, light, r, g, b, dslidePath) {

    SeadragonTileSource.apply(this, [width, height, tileSize, tileOverlap]);
    this.fileFormat = tileFormat;
    this.tileFormat = tileFormat;


    this.getTileUrl = function (level, x, y, gamma, contrast, light, r, g, b) {
        return Provider.getTileUrl(slideKey, level, x, y, FileNum, ID, tileSize, gamma, contrast, light, r, g, b, dslidePath);
    };
};