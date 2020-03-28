package org.telegram.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.UserConfig;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Components.RecyclerAnimationScrollHelper;

import java.util.HashSet;
import java.util.Set;

public class TerraDialogsActivity extends DialogsActivity {

    public static boolean[] dialogsLoaded = new boolean[UserConfig.MAX_ACCOUNT_COUNT];
    public static final int TERRA_DIALOGS = 101;
    private RecyclerAnimationScrollHelper scrollHelper;
    private DialogsRecyclerView listView;
    private LinearLayoutManager layoutManager;
    public static Set<Long> terraGroups = new HashSet<>();
    static  {
        terraGroups.add(Long.valueOf(-1001178187637L));
        terraGroups.add(Long.valueOf(-1001462611942L));
        terraGroups.add(Long.valueOf(-1001486411432L));
        terraGroups.add(Long.valueOf(-1001276288363L));
        terraGroups.add(Long.valueOf(-1001431863601L));
    }

    public TerraDialogsActivity(Bundle args) {
        super(args);
    }

    @Override
    public boolean onFragmentCreate() {
        this.dialogsType = TERRA_DIALOGS;
        return super.onFragmentCreate();
    }

    @Override
    public View createView(Context context) {
        ContentView contentView = new ContentView(context);
        fragmentView = contentView;
        AndroidUtilities.runOnUIThread(() -> Theme.createChatResources(context, false));
        this.createSideMenu(context);
        this.createDialogs(context, contentView);
        this.createTerraPanel(context, contentView);

        scrollHelper = new RecyclerAnimationScrollHelper(listView, layoutManager);

        return this.fragmentView;
    }
}
