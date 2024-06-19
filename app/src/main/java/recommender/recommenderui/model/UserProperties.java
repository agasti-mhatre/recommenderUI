package recommender.recommenderui.model;

public class UserProperties {

    private final String listName;
    private final int listPos;

    public UserProperties(String listName, int listPos) {

        this.listName = listName;
        this.listPos = listPos;
    }

    public String getListName() {
        return listName;
    }

    public int getListPos() {
        return listPos;
    }

}
