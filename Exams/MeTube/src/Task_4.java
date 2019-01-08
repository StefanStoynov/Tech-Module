import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Song> songs = new ArrayList<>();

        String line;
        while (true) {
            if ("stats time".equals(line = reader.readLine())) {
                line = reader.readLine();
                if ("by likes".equals(line)){
                    songs.stream().sorted(Comparator.comparing(Song::getLikes).reversed()).forEach(s-> System.out.println(s.toString()));
                }else {
                    songs.stream().sorted(Comparator.comparing(Song::getViews).reversed()).forEach(s-> System.out.println(s.toString()));
                }
                break;
            }
            String[] input = line.split("-|:");

            switch (input[0]) {
                case "like":
                    String songName = input[1];
                    if (!findByName(songs, songName)) {
                        break;
                    }
                    for (Song song : songs) {
                        if (song.getSongName().equals(songName)) {
                            int oldLikes = song.getLikes();
                            int newLikes = oldLikes + 1;
                            song.setLikes(newLikes);
                        }
                    }
                    break;
                case "dislike":
                    String songsName = input[1];
                    if (!findByName(songs, songsName)) {
                        break;
                    }
                    for (Song song : songs) {
                        if (song.getSongName().equals(songsName)) {
                            int oldLikes = song.getLikes();
                            int newLikes = oldLikes - 1;
                            song.setLikes(newLikes);
                        }
                    }
                    break;
                default:
                    String name = input[0];
                    int views = Integer.parseInt(input[1]);


                    if (!findByName(songs, name)) {
                        Song song = new Song(name);
                        song.setViews(views);
                        songs.add(song);
                        break;
                    }
                    Song song = findSong(songs,name);
                    int oldViews = song.getViews();
                    int newViews = oldViews + views;
                    song.setViews(newViews);

            }

        }


    }

    public static boolean findByName(List<Song> songs, String name) {
        return songs.stream().anyMatch(s -> s.getSongName().equals(name));
    }
    public static Song findSong(List<Song> songs, String name) {
       Optional<Song> song = songs.stream().filter(s-> s.getSongName().equals(name)).findFirst();
       return song.orElse(null);
    }


    public static class Song {
        private String songName;
        private int views;
        private int likes;

        public Song(String songName) {
            this.songName = songName;
            this.views = 0;
            this.likes = 0;
        }

        public String getSongName() {
            return this.songName;
        }

        public int getViews() {
            return this.views;
        }

        public int getLikes() {
            return this.likes;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        @Override
        public String toString() {
            return String.format("%s - %d views - %d likes",this.songName, this.views, this.likes);
        }
    }
}


