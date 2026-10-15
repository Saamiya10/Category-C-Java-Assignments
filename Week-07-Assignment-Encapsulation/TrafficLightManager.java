class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        switch (color) {
            case "RED": color = "GREEN"; break;
            case "GREEN": color = "YELLOW"; break;
            case "YELLOW": color = "RED"; break;
        }
        return color;
    }

    public String getColor() { return color; }
}

public class TrafficLightManager {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Next: " + t.next());
    }
}