package com.example.lenovo.androidtest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.*;

public class test4 extends AppCompatActivity{
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4xml2);
        listView=(ListView)findViewById(R.id.lv);
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.test4xml1,new String[]{"pic","text"},new int[]{R.id.iv,R.id.tv});
        listView.setAdapter(simpleAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                mode.setTitle(listView.getCheckedItemCount()+" selected");
            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.i1:
                        //deleteSelectedItems();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.test4, menu);
                return true;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
    }
    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String,Object> map=new HashMap<String, Object>() ;
        map.put("pic",R.mipmap.ic_launcher_round);
        map.put("text","One");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.mipmap.ic_launcher_round);
        map.put("text","Two");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.mipmap.ic_launcher_round);
        map.put("text","Three");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.mipmap.ic_launcher_round);
        map.put("text","Four");
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("pic",R.mipmap.ic_launcher_round);
        map.put("text","Five");
        list.add(map);
        return list;
    }
}

