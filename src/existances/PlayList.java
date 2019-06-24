package existances;

public class PlayList  extends BaseOfAlbumAndPlaylist {

    public PlayList(String name) {
        super(name);
    }
    public void remove(Music music){
        getListMusic().remove(music);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
