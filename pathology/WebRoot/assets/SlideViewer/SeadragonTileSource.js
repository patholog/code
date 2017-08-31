var SeadragonLiYTileSource = function (width, height, tileSize, tileOverlap, tileFormat, slideKey, FileNum, ID, Provider, gamma, contrast, light, r, g, b, dslidePath) {

  SeadragonTileSource.apply(this, [width, height, tileSize, tileOverlap]);
  this.fileFormat = tileFormat;
  this.tileFormat = tileFormat;

  /**
   * 生成缩略图URL
   * 被SeadragonViewer.js中OpenImage()调用
   * 此方法会被重复调用已以显示不同位置图片
   */
  this.getTileUrl = function (level, x, y, gamma, contrast, light, r, g, b) {
    return Provider.getTileUrl(slideKey, level, x, y, FileNum, ID, tileSize, gamma, contrast, light, r, g, b, dslidePath);
  };
};