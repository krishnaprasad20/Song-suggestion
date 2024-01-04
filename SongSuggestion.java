import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    String title;
    String artist;
    String genre;
    String mood;

    Song(String title, String artist, String genre, String mood) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.mood = mood;
    }
}

public class SongSuggestion {

    static List<Song> songs = new ArrayList<>();

    static {
        // Hardcoded song database
        songs.add(new Song("Song 1", "Artist A", "Pop", "Happy"));
        songs.add(new Song("Song 2", "Artist B", "Rock", "Energetic"));
        songs.add(new Song("Song 3", "Artist C", "Hip-hop", "Chill"));
        songs.add(new Song("Song 4", "Artist D", "Pop", "Sad"));
        songs.add(new Song("Song 5", "Artist E", "Electronic", "Energetic"));
        // Add more songs with different attributes
    }

    public static List<Song> suggestSongs(String genre, String mood) {
        List<Song> suggestedSongs = new ArrayList<>();
        for (Song song : songs) {
            if ((genre.equalsIgnoreCase(song.genre) || "Any".equalsIgnoreCase(genre))
                    && (mood.equalsIgnoreCase(song.mood) || "Any".equalsIgnoreCase(mood))) {
                suggestedSongs.add(song);
            }
        }
        return suggestedSongs;
    }

    public static void gatherFeedback(List<Song> suggestedSongs) {
        // In a real system, user feedback would be used to update learning models.
        // For simplicity, we'll assume the user liked all suggested songs.
        // In Java, this could be done using a database or data structure to store user feedback.
        for (Song song : suggestedSongs) {
            // Assuming the user liked the song (update the database or learning model here)
            System.out.println("User liked: " + song.title);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Song Suggestion Program!");
        System.out.println("Please provide your preferences.");

        System.out.print("Enter preferred genre (Pop, Rock, Hip-hop, Electronic, Any): ");
        String preferredGenre = scanner.nextLine();

        System.out.print("Enter current mood (Happy, Sad, Energetic, Chill, Any): ");
        String currentMood = scanner.nextLine();

        List<Song> suggestedSongs = suggestSongs(preferredGenre, currentMood);

        if (!suggestedSongs.isEmpty()) {
            System.out.println("Suggested songs:");
            for (Song song : suggestedSongs) {
                System.out.println(song.title + " by " + song.artist + " (" + song.genre + ", " + song.mood + ")");
            }

            // Simulate user feedback (user liked the suggested songs)
            gatherFeedback(suggestedSongs);

            // The user feedback collection and learning process would be more complex in reality
        } else {
            System.out.println("No songs match your preferences. Please try different preferences.");
        }

        scanner.close();
    }
}
