package org.telegram.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class TerraDialogsActivity extends DialogsActivity {
    public TerraDialogsActivity(Bundle args) {
        super(args);
    }

    @Override
    public View createView(Context context) {
        ContentView contentView = new ContentView(context);
        fragmentView = contentView;
        this.createTerraPanel(context,contentView);
        return this.fragmentView;
    }
}
