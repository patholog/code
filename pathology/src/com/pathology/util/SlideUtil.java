package com.pathology.util;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 切片工具类
 */
public class SlideUtil {

  private static Logger logger = Logger.getLogger(SlideUtil.class);

  private static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
  private static final String schemaName = "http://schemas.microsoft.com/deepzoom/2009";

  private static Boolean deleteExisting = true;
  private static String tileFormat = "jpg";

  // settings
  private static int tileSize = 256;
  private static int tileOverlap = 1;
  private static Boolean verboseMode = false;
  private static Boolean debugMode = false;

  public static void main(String[] args) {
    try {
      SlideUtil.processImageFile(new File("C:\\upload\\pptest\\2017\\09\\01\\122121240\\tjqb.jpg"), new File("C:\\upload\\pptest\\2017\\09\\01\\122121240"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void processImageFile(File inFile, File outputDir) throws IOException {
    logger.error("start to cut slide " + inFile.getName());
    if (verboseMode) {
      System.out.printf("Processing image file: %s\n", inFile);
    }
    String fileName = inFile.getName();
    String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
    String pathWithoutExtension = outputDir + File.separator + nameWithoutExtension;

    BufferedImage image = loadImage(inFile);

    int originalWidth = image.getWidth();
    int originalHeight = image.getHeight();

    double maxDim = Math.max(originalWidth, originalHeight);

    int nLevels = (int) Math.ceil(Math.log(maxDim) / Math.log(2));

    if (debugMode) {
      System.out.printf("nLevels=%d\n", nLevels);
    }
    // Delete any existing output files and folders for this image
    File descriptor = new File(pathWithoutExtension + ".xml");
    if (descriptor.exists()) {
      if (deleteExisting) {
        deleteFile(descriptor);
      } else {
        throw new IOException("File already exists in output dir: " + descriptor);
      }
    }

    File imgDir = new File(pathWithoutExtension);
    if (imgDir.exists()) {
      if (deleteExisting) {
        if (debugMode)
          System.out.printf("Deleting directory: %s\n", imgDir);
        deleteDir(imgDir);
      } else
        throw new IOException("Image directory already exists in output dir: " + imgDir);
    }

    // imgDir = createDir(outputDir, nameWithoutExtension.concat("_files"));
    imgDir = createDir(outputDir, "");

    double width = originalWidth;
    double height = originalHeight;

    for (int level = nLevels; level >= 0; level--) {
      int nCols = (int) Math.ceil(width / tileSize);
      int nRows = (int) Math.ceil(height / tileSize);
      if (debugMode)
        System.out.printf("level=%d w/h=%f/%f cols/rows=%d/%d\n",
            level, width, height, nCols, nRows);

      File dir = createDir(imgDir, Integer.toString(level));
      for (int col = 0; col < nCols; col++) {
        for (int row = 0; row < nRows; row++) {
          BufferedImage tile = getTile(image, row, col);
          saveImage(tile, dir + File.separator + col + '_' + row);
        }
      }

      // Scale down image for next level
      width = Math.ceil(width / 2);
      height = Math.ceil(height / 2);
      if (width > 10 && height > 10) {
        // resize in stages to improve quality
        image = resizeImage(image, width * 1.66, height * 1.66);
        image = resizeImage(image, width * 1.33, height * 1.33);
      }
      image = resizeImage(image, width, height);
    }

    saveImageDescriptor(originalWidth, originalHeight, descriptor);
    logger.error("start to create thumbnail");
    createMinThumbnail(loadImage(inFile), outputDir.getPath(), fileName);
    logger.error("cut slide ended");
  }

  private static void deleteFile(File file) throws IOException {
    if (!file.delete())
      throw new IOException("Failed to delete file: " + file);
  }

  private static void deleteDir(File dir) throws IOException {
    if (!dir.isDirectory())
      deleteFile(dir);
    else {
      for (File file : dir.listFiles()) {
        if (file.isDirectory())
          deleteDir(file);
        else
          deleteFile(file);
      }
      if (!dir.delete())
        throw new IOException("Failed to delete directory: " + dir);
    }
  }

  private static File createDir(File parent, String name) throws IOException {
    assert (parent.isDirectory());
    File result = new File(parent + File.separator + name);
    if (!result.exists() && !result.mkdirs())
      throw new IOException("Unable to create directory: " + result);
    return result;
  }

  public static BufferedImage loadImage(File file) throws IOException {
    BufferedImage result;
    try {
      result = ImageIO.read(file);
    } catch (Exception e) {
      throw new IOException("不受支持的图片类型");
    }
    return result;
  }

  private static BufferedImage getTile(BufferedImage img, int row, int col) {
    int x = col * tileSize - (col == 0 ? 0 : tileOverlap);
    int y = row * tileSize - (row == 0 ? 0 : tileOverlap);
    int w = tileSize + (col == 0 ? 1 : 2) * tileOverlap;
    int h = tileSize + (row == 0 ? 1 : 2) * tileOverlap;

    if (x + w > img.getWidth())
      w = img.getWidth() - x;
    if (y + h > img.getHeight())
      h = img.getHeight() - y;

    if (debugMode)
      System.out.printf("getTile: row=%d, col=%d, x=%d, y=%d, w=%d, h=%d\n",
          row, col, x, y, w, h);

    assert (w > 0);
    assert (h > 0);

    BufferedImage result = new BufferedImage(w, h, img.getType());
    Graphics2D g = result.createGraphics();
    g.drawImage(img, 0, 0, w, h, x, y, x + w, y + h, null);

    return result;
  }

  private static BufferedImage resizeImage(BufferedImage img, double width, double height) {
    int w = (int) width;
    int h = (int) height;
    BufferedImage result = new BufferedImage(w, h, img.getType());
    Graphics2D g = result.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g.drawImage(img, 0, 0, w, h, 0, 0, img.getWidth(), img.getHeight(), null);
    return result;
  }

  private static void saveImage(BufferedImage img, String path) throws IOException {
    File outputFile = new File(path + "." + tileFormat);
    try {
      ImageIO.write(img, tileFormat, outputFile);
    } catch (IOException e) {
      throw new IOException("Unable to save image file: " + outputFile);
    }
  }

  private static void saveImageDescriptor(int width, int height, File file) throws IOException {
    StringBuilder sb = new StringBuilder(256);
    sb.append(xmlHeader);
    sb.append("<Image TileSize=\"");
    sb.append(tileSize);
    sb.append("\" Overlap=\"");
    sb.append(tileOverlap);
    sb.append("\" Format=\"");
    sb.append(tileFormat);
    sb.append("\" ServerFormat=\"Default\" xmlns=\"");
    sb.append(schemaName);
    sb.append("\">");
    sb.append("<Size Width=\"");
    sb.append(width);
    sb.append("\" Height=\"");
    sb.append(height);
    sb.append("\" />");
    sb.append("</Image>");
    saveText(sb.toString().getBytes("UTF-8"), file);
  }

  private static void saveText(byte[] bytes, File file) throws IOException {
    try {
      //输出流
      FileOutputStream fos = new FileOutputStream(file);
      //从输出流中创建写通道
      FileChannel writeChannel = fos.getChannel();
      //将既有数组作为buffer内存空间
      ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
      //将buffer写到磁盘
      writeChannel.write(byteBuffer);

      writeChannel.close();
    } catch (IOException e) {
      throw new IOException("Unable to write to text file: " + file);
    }
  }

  /**
   * create thumbnail
   *
   * @param image
   * @param distDir
   * @param fileName
   */
  private static void createMinThumbnail(BufferedImage image, String distDir, String fileName) {
    try {
      int width = image.getWidth();
      int height = image.getHeight();
      int thumWidth = 0;
      int thumHeight = 0;
      if (width / 256 > height / 256) {
        thumWidth = 256;
        thumHeight = (int) Math.ceil(height * 256 / width);
      } else {
        thumWidth = (int) Math.ceil(width * 256 / height);
        thumHeight = 256;
      }
      BufferedImage tempImage = thumbnailImage(image, thumWidth, thumHeight);
      ImageIO.write(tempImage, "JPEG", new File(distDir + "/" + "thumb_" + fileName));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static BufferedImage thumbnailImage(BufferedImage image, int width, int height) {
    boolean flag1 = false;
    try {
      BufferedImage bfImage = new BufferedImage(width, height, 1);
      flag1 = bfImage.getGraphics().drawImage(image.getScaledInstance(width, height, 4), 0, 0, null);

      if (flag1) return bfImage;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
