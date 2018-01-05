package eu.woelflein.adventizr;

import android.content.Context;
import android.preference.PreferenceManager;

public enum Preference {

    API_BASE_URL("http://10.43.40.145:3000/api/v1/");

    private Object value;

    Preference(Object value) {
        this.value = value;
    }

    public String getString(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(this.name(), (String) this.value);
    }
}
