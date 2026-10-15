class NameTag {
    private final String nickname;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        this.nickname = parts[0] + " " + parts[parts.length - 1].substring(0, 1).toUpperCase() + ".";
    }

    public String getNickname() { return nickname; }
}

public class NameTagManager {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}