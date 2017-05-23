package gas.geny.com.companion;

/**
 * Created by garvi on 3/11/2017.
 */

public class group {
    String name;
    String uid;

    public group(){}
    public group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
class grpinfo{
    String posts;
    String uid;

    public grpinfo(String posts, String uid) {
        this.posts = posts;
        this.uid = uid;
    } }
