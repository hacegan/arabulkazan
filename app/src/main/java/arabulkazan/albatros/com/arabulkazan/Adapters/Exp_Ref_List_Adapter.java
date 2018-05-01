package arabulkazan.albatros.com.arabulkazan.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.R;

import static arabulkazan.albatros.com.arabulkazan.Fragments.SizeOzel.ref_childListMap;
import static arabulkazan.albatros.com.arabulkazan.Fragments.SizeOzel.ref_groupList;

public class Exp_Ref_List_Adapter implements ExpandableListAdapter {
    Context context;


    public Exp_Ref_List_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getGroupCount() {
        return ref_groupList.size();
    }

    @Override
    public int getChildrenCount(int groupIndex) {
        String group = ref_groupList.get(groupIndex);
        List<String> childInfoList = ref_childListMap.get(group);
        return childInfoList.size();
    }

    @Override
    public Object getGroup(int groupIndex) {
        return ref_groupList.get(groupIndex);
    }

    @Override
    public Object getChild(int groupIndex, int childIndex) {
        String group = ref_groupList.get(groupIndex);
        List<String> childInfoList = ref_childListMap.get(group);
        return childInfoList.get(childIndex);
    }

    @Override
    public long getGroupId(int groupIndex) {
        return groupIndex;
    }

    @Override
    public long getChildId(int groupIndex, int childIndex) {
        return childIndex;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    // This method will return a View object displayed in group list item.
    @Override
    public View getGroupView(int groupIndex, boolean isExpanded, View view, ViewGroup viewGroup) {
        // Create the group view object.
        LinearLayout groupLayoutView = new LinearLayout(context);
        groupLayoutView.setOrientation(LinearLayout.HORIZONTAL);





        // Create and add a textview in returned group view.
        String groupText = ref_groupList.get(groupIndex);
        TextView groupTextView = new TextView(context);
        groupTextView.setText(groupText);
        groupTextView.setTextSize(30);
        groupLayoutView.addView(groupTextView);

        return groupLayoutView;
    }

    // This method will return a View object displayed in child list item.
    @Override
    public View getChildView(int groupIndex, int childIndex, boolean isLastChild, View view, ViewGroup viewGroup) {
        // First get child text/
        Object childObj = this.getChild(groupIndex, childIndex);
        String childText = (String)childObj;

        // Create a TextView to display child text.
        TextView childTextView = new TextView(context);
        childTextView.setText(childText);
        childTextView.setTextSize(20);
       // childTextView.setBackgroundColor(Color.GREEN);



        // Set child textview offset left. Then it will align to the right of the group image.
        childTextView.setPadding(15,0,0,0);

        return childTextView;
    }

    @Override
    public boolean isChildSelectable(int groupIndex, int childIndex) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupIndex) {

    }

    @Override
    public void onGroupCollapsed(int groupIndex) {


    }

    @Override
    public long getCombinedChildId(long groupIndex, long childIndex) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupIndex) {
        return 0;
    }
}
