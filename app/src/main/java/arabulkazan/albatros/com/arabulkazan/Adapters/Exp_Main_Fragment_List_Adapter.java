package arabulkazan.albatros.com.arabulkazan.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import arabulkazan.albatros.com.arabulkazan.R;

import static arabulkazan.albatros.com.arabulkazan.Fragments.Main.childListMap;
import static arabulkazan.albatros.com.arabulkazan.Fragments.Main.groupList;


public class Exp_Main_Fragment_List_Adapter implements ExpandableListAdapter {
    Context context;


    public Exp_Main_Fragment_List_Adapter(Context context) {
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
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupIndex) {
        String group = groupList.get(groupIndex);
        List<String> childInfoList = childListMap.get(group);
        return childInfoList.size();
    }

    @Override
    public Object getGroup(int groupIndex) {
        return groupList.get(groupIndex);
    }

    @Override
    public Object getChild(int groupIndex, int childIndex) {
        String group = groupList.get(groupIndex);
        List<String> childInfoList = childListMap.get(group);
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
        String groupText = groupList.get(groupIndex);
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
       // String childText = (String)childObj;
        ImageView childImage= (ImageView) this.getChild(groupIndex,childIndex);


        // Create a TextView to display child text.
       // TextView childTextView = new TextView(context);
       // childTextView.setText(childText);
       // childTextView.setTextSize(20);
        // childTextView.setBackgroundColor(Color.GREEN);

        ImageView imageView=new ImageView(context);
        Drawable drawable=childImage.getDrawable();
        imageView.setImageDrawable(drawable);


        // Set child textview offset left. Then it will align to the right of the group image.
       // childTextView.setPadding(15,0,0,0);

        return imageView;
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
