public class Training {
    private String name;
    private int duration;
    private String[] contents;

    public Training(String name, int duration, String[] contents) {
        this.name = name;
        this.duration = duration;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getContents() {
        return contents;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }
}
