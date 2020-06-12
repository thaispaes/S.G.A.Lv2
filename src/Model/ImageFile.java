/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Samuel
 */
public class ImageFile extends File {

    private byte[] bytes;
    private int length = (int) this.length();
    private int lengthKB = length / 1024;
    private int lengthMB = lengthKB / 1024;
    private FileInputStream input;
    private FileOutputStream output;
    private ImageIcon imageSwing;
    private Image ImageFX;

    public ImageFile(String string) {
        super(string);

        start();
    }

    public ImageFile(String string, String string1) {
        super(string, string1);

        start();
    }

    public ImageFile(File file, String string) {
        super(file, string);

        start();
    }

    public ImageFile(URI uri) {
        super(uri);

        start();
    }

    private void start() {
        try {

            this.bytes = new byte[length];
            this.input = new FileInputStream(this);
            this.output = new FileOutputStream(this);

            input.read(bytes, 0, length);

            this.imageSwing = new ImageIcon(this.getAbsolutePath());
            this.ImageFX = new Image(this.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLengthKB() {
        return lengthKB;
    }

    public void setLengthKB(int lengthKB) {
        this.lengthKB = lengthKB;
    }

    public int getLengthMB() {
        return lengthMB;
    }

    public void setLengthMB(int lengthMB) {
        this.lengthMB = lengthMB;
    }

    public FileInputStream getInput() {
        return input;
    }

    public void setInput(FileInputStream input) {
        this.input = input;
    }

    public FileOutputStream getOutput() {
        return output;
    }

    public void setOutput(FileOutputStream output) {
        this.output = output;
    }

    public ImageIcon getImageSwing() {
        return imageSwing;
    }

    public void setImageSwing(ImageIcon imageSwing) {
        this.imageSwing = imageSwing;
    }

    public Image getImageFX() {
        return ImageFX;
    }

    public void setImageFX(Image ImageFX) {
        this.ImageFX = ImageFX;
    }

}
