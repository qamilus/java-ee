package pl.swislowski.kamil.javaee.javaFX.colorPicker;

import java.util.Comparator;

class ImageCropColorsComparator implements Comparator<ImageCropColors> {
    @Override
    public int compare(ImageCropColors o1, ImageCropColors o2) {
        if (o1.getRedColor() == o2.getRedColor()) return 0;
        return (o1.getRedColor() > o2.getRedColor()) ? -1 : 1;
    }
}