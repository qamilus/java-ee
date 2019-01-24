package pl.swislowski.kamil.javaee.javaFX.colorPicker;

import java.util.Comparator;

// Używam żeby po czyszczeniu przywrócić kolejność id na liście.
class ImageCropColorsIdComparator implements Comparator<ImageCropColors> {
    @Override
    public int compare(ImageCropColors o1, ImageCropColors o2) {
        if (o1.getId() == o2.getId()) return 0;
        return (o1.getId() < o2.getId()) ? -1 : 1;
    }
}