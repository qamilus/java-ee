package pl.swislowski.kamil.javaee.javaFX.colorPicker;

import javafx.scene.image.ImageView;

class ImageCropColors implements Comparable<ImageCropColors> {

    private int id;
    private ImageView imageView;
    private double redColor;

    public ImageCropColors() {
    }

    public ImageCropColors(int id, ImageView imageView, double redColor) {
        this.id = id;
        this.imageView = imageView;
        this.redColor = redColor;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getRedColor() {
        return redColor;
    }

    public void setRedColor(double redColor) {
        this.redColor = redColor;
    }

    @Override
    public int compareTo(ImageCropColors o) {
        if (this.redColor == o.getRedColor()) return 0;
        return (this.redColor > o.getRedColor()) ? -1 : 1;
    }

    @Override
    public String toString() {
        return "ImageCropColors{" +
                "id=" + id +
//                ", imageView=" + imageView +
                ", redColor=" + redColor +
                '}';
    }
}