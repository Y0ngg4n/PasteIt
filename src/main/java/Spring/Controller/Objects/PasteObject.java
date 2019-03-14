package Spring.Controller.Objects;

public class PasteObject {
    private String text;

    private String uuid;

    public PasteObject(){}

    public PasteObject(String text, String uuid){
        this.text = text;
        this.uuid = uuid;
    }

    public PasteObject(String uuid){
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
