import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String songTitle) {
        if (songTitle == null || songTitle.trim().isEmpty() || count >= songs.length) return;
        songs[count++] = songTitle.trim();
    }

    public String[] getSongs() { return Arrays.copyOf(songs, count); }
    public int getSongCount() { return count; }
}

public class PlaylistManager {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        System.out.println("Songs: " + Arrays.toString(p.getSongs()));
    }
}