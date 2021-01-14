import java.util.LinkedList;
import java.util.List;

public class DataElement {

    private List<String> info;

    public DataElement() {
        info = new LinkedList<>();
    }

    public void addToInfo( String tag ) {
        info.add(tag);
    }

    @Override
    public String toString() {
        return "DataElement{" +
                "info=" + info +
                '}';
    }
}
