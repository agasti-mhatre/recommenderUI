package recommender.recommenderui.controller.view;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Main data structure used to store the list properties retrieved from the backend.
 * JSON data will be parsed into this data structure. Ultimately, this data structure
 * is a parcelable because it may be passed from to an activity/fragment via an intent.
 */
public class ListProperties implements Parcelable {

    private final String listName;
    private final Map<Integer, String> eatery;

    /**
     * Initialize the ListProperties object with information about a specific list.
     *
     * @param listName - The name of the list's category.
     * @param eatery - The eatery map represents the position in the list (rank)
     *               for each eatery that this list contains.
     */
    public ListProperties(String listName, Map<Integer, String> eatery) {

        this.listName = listName;
        this.eatery = eatery;
    }

    /**
     * Return the name of the list's category.
     *
     * @return listName
     */
    public String getListName() {
        return listName;
    }

    /**
     * Return the map that contains the position (Integer)
     * and the eatery for each eatery contained within
     * this list.
     *
     * @return eatery - The map containing position and eatery information for each eatery.
     */
    public Map<Integer, String> getEatery() {
        return eatery;
    }

    /**
     * Reinitializes the ListProperties object after it is passed through
     * to the intent.
     *
     * @param in - The parcel that ListProperties receives in order to
     *           reinitialize its objects.
     */
    protected ListProperties(Parcel in) {
        listName = in.readString();

        int numMaps = in.readInt();
        this.eatery = new HashMap<Integer, String>();
        for (int i = 0; i < numMaps; i += 1) {
            eatery.put(i, in.readString());
        }
    }

    /**
     * Comes as part of the Parcelable class.
     */
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
