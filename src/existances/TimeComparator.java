package existances;
//import existances.Music;
import java.util.Comparator;
public class TimeComparator implements Comparator<Music>{
    @Override
    public int compare(Music m1 , Music m2){
        return m1.lastTime.compareTo(m2.lastTime);
    }
}
