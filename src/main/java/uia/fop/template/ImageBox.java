package uia.fop.template;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import xml.xslfo.ExternalGraphic;

public final class ImageBox {

    private ImageBox() {
    }

    public static ExternalGraphic orig(File file) throws IOException {
        return orig(ImageIO.read(file));
    }

    public static ExternalGraphic orig(BufferedImage image) throws IOException {
        return fixedSize(image, image.getWidth(), image.getHeight());
    }

    public static ExternalGraphic fixedHeight(File file, int height) throws IOException {
        return fixedHeight(ImageIO.read(file), height);
    }

    public static ExternalGraphic fixedHeight(BufferedImage image, int height) throws IOException {
        int width = image.getWidth() * height / image.getHeight();
        return fixedSize(image, width, height);
    }

    public static ExternalGraphic fixedWidth(File file, int width) throws IOException {
        return fixedWidth(ImageIO.read(file), width);
    }

    public static ExternalGraphic fixedWidth(BufferedImage image, int width) throws IOException {
        int height = image.getHeight() * width / image.getWidth();
        return fixedSize(image, width, height);
    }

    public static ExternalGraphic fixedSize(BufferedImage orig, int width, int height) throws IOException {
        BufferedImage image = resize(orig, width, height);
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", bos);
            byte[] imageBytes = bos.toByteArray();

            String base64 = new Base64().encodeAsString(imageBytes);

            ExternalGraphic eg = new ExternalGraphic();
            eg.setSrc(String.format("url('data:%s;base64,%s')", "image/png", base64));
            eg.setWidth("" + width);
            eg.setHeight("" + height);
            return eg;
        }
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        if (img.getWidth() == newW && img.getHeight() == newH) {
            return img;
        }

        BufferedImage newImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newImg.createGraphics();
        g2d.drawImage(img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();

        return newImg;
    }
}
