import java.util.Scanner;
import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class PlaylistProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum playlist size: ");
        int maxSize = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(maxSize);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song: ");
            String song = sc.nextLine();
            p.addSong(song);
        }

        System.out.println("Song count: " + p.getSongCount());

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (String song : copy) {
            System.out.println(song);
        }

        sc.close();
    }
}
