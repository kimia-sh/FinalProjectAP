package existances;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BaseOfAlbumAndPlaylist implements Serializable {
        private String name;

        private ArrayList<Music> listMusic ;
        private int current;
        public BaseOfAlbumAndPlaylist(String name){
                this.name=name;
                listMusic = new ArrayList<Music>();
                current = 0;
        }
        public void previous(){
                listMusic.get(current).close();
                current--;
                listMusic.get(current).play();
        }

        public void next(){
                listMusic.get(current).close();
                current ++;
                listMusic.get(current).play();
        }

        public void add(Music music){
                listMusic.add(music);

        }

        public ArrayList<Music> getListMusic() {
                return listMusic;
        }

        protected void setName(String name) {
                this.name = name;
        }

        public abstract void save();

        public String getName() {
                return name;
        }
}