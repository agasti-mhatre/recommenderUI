package recommender.recommenderui.controller.view;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListProperties implements Parcelable {

    private final String listName;
    private final List<Map<Integer, String>> eatery;

    public ListProperties(String listName, List<Map<Integer, String>> eatery) {

        this.listName = listName;
        this.eatery = eatery;
    }

    public String getListName() {
        return listName;
    }

    public List<Map<Integer, String>> getEatery() {
        return eatery;
    }

    protected ListProperties(Parcel in) {
        listName = in.readString();

        eatery = new ArrayList<Map<Integer, String>>();

        int numMaps = in.readInt();
        Map<Integer, String> temp = new HashMap<Integer, String>();
        for (int i = 0; i < numMaps; i += 1) {

            in.readMap(temp, Map.class.getClassLoader());
            eatery.add(temp);
        }
    }

    public static final Creator<ListProperties> CREATOR = new Creator<ListProperties>() {
        @Override
        public ListProperties createFromParcel(Parcel in) {
            return new ListProperties(in);
        }

        @Override
        public ListProperties[] newArray(int size) {
            return new ListProperties[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(listName);

        int numMaps = eatery.size();
        dest.writeInt(numMaps);
        for (int i = 0; i < numMaps; i += 1) {
            dest.writeMap(eatery.get(i));
        }
    }
}
