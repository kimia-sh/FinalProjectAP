package existances;

import java.io.Serializable;

public class Album extends BaseOfAlbumAndPlaylist implements Serializable {

    public Album(String name) {
        super(name);
    }

    @Override
    public void save() {

    }
}
