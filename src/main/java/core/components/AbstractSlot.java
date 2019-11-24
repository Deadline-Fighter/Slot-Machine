package core.components;

import javafx.scene.image.Image;

public abstract class AbstractSlot {
    private String name;
    private int odd;
    private String image;
    public AbstractSlot(String name, int odd,String image) {
        this.name = name;
        this.odd = odd;
        this.image=image;
    }

    public int getOdd() {
        return odd;
    }

    public String getName() {
        return name.toString();
    }

    public Image getImage() {
        return new Image(image);
    }

    public String getImageURL() {return image;}
}
