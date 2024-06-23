package recommender.recommenderui.controller.view;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ListProperties implements Parcelable {

    private final String listName;
    private final Map<Integer, String> eatery;

    public ListProperties(String listName, Map<Integer, String> eatery) {

        this.listName = listName;
        this.eatery = eatery;
    }

    public String getListName() {
        return listName;
    }

    public Map<Integer, String> getEatery() {
        return eatery;
    }

    protected ListProperties(Parcel in) {
        listName = in.readString();

        int numMaps = in.readInt();
        this.eatery = new HashMap<Integer, String>();
        for (int i = 0; i < numMaps; i += 1) {
            eatery.put(i, in.readString());
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
            dest.writeString(eatery.get(i));
        }
    }
}
