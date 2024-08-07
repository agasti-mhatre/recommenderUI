package recommender.recommenderui.controller.view_controller.list_properties;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Main data structure used to store the list properties retrieved from the backend.
 * JSON data will be parsed into this data structure. Ultimately, this data structure
 * is a parcelable because it may be passed from to an activity/fragment via an intent.
 */
public class ListPropertiesImpl implements ListProperties {

    private final String name;
    private final List<String> eatery;

    /**
     * Initialize the ListProperties object with information about a specific list.
     *
     * @param name - The name of the list's category.
     * @param eatery - The rank of each eatery depending on
     *               its position in the list.
     */
    public ListPropertiesImpl(String name, List<String> eatery) {

        this.name = name;
        this.eatery = eatery;
    }

    /**
     * Return the name of the list's category.
     *
     * @return listName - The name of the list.
     */
    @Override
    public String getListName() {
        return name;
    }

    /**
     * Return the list that contains the
     * eatery for each eatery contained
     * within this list.
     *
     * @return eatery - The name of the eatery.
     */
    @Override
    public String getEatery(int i) {
        return eatery.get(i);
    }

    @Override
    public int size() {

        return eatery.size();
    }

    /**
     * Reinitializes the ListProperties object after it is passed through
     * to the intent.
     *
     * @param in - The parcel that ListProperties receives in order to
     *           reinitialize its objects.
     */
    protected ListPropertiesImpl(Parcel in) {

        name = in.readString();

        this.eatery = new ArrayList<>();
        in.readList(this.eatery, String.class.getClassLoader());
    }

    /**
     * Comes as part of the Parcelable interface.
     */
    public static final Creator<ListPropertiesImpl> CREATOR = new Creator<ListPropertiesImpl>() {
        @Override
        public ListPropertiesImpl createFromParcel(Parcel in) {
            return new ListPropertiesImpl(in);
        }

        @Override
        public ListPropertiesImpl[] newArray(int size) {
            return new ListPropertiesImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeList(eatery);
    }
}
