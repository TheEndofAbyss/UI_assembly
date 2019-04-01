一、实验内容

（1）Android ListView的用法.

（2）创建自定义布局的AlertDialog.

（3）使用XML定义菜单.

（4）创建上下文操作模式(ActionMode)的上下文菜单.

二、具体实验代码及效果截图

总体架构：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190401135223999.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMzA0MjY3,size_16,color_FFFFFF,t_70)

我们通过一个按钮跳转界面Main实现跳转到具体某个实验小题：

**效果截图：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190401135528640.png)

（1）

主要代码：

**test1.java：**

public class test1 extends AppCompatActivity {
   
    private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "elephant"};
  
    private int[] image = new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};
  
    @Override

    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
      
        requestWindowFeature(Window.FEATURE_NO_TITLE);
      
        setContentView(R.layout.test1xml1);
       
        final int color1 = 0xFF0000;
      
        final int color2 = 0xFFFFFFFF;
      
        List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
      
        for (int i = 0; i < names.length; i++) {
           
            Map<String, Object> listItem = new HashMap<String, Object>();
       
            listItem.put("header", names[i]);
       
            listItem.put("images", image[i]);
        
            ListItems.add(listItem);
       
        }
     
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.test1xml2, new String[]{"header", "images"}, new int[]{R.id.header, R.id.images});
    
        final ListView list = (ListView) findViewById(R.id.mylist);
   
        list.setAdapter(simpleAdapter);
    
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          
                int flag = 0;
              
                System.out.println(names[position] + position + "被单击");
              
                switch (flag) {
                  
                    case 0:
                   
                        view.setSelected(true);
                    
                        CharSequence text = names[position];
                    
                        int duration = Toast.LENGTH_SHORT;
                    
                        Toast toast = Toast.makeText(test1.this, text, duration);
                    
                        toast.show();
                    
                        flag = 1;
                    
                        break;
                
                    case 1:
                   
                        view.setSelected(false);
                 
                        CharSequence text1 = names[position];
                 
                        int duration1 = Toast.LENGTH_SHORT;
                 
                        Toast toast1 = Toast.makeText(test1.this, text1, duration1);
                  
                        toast1.show();
                    
                        flag = 0;
                    
                        break;
         
                }
          
            }
        
        });
      
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          
                System.out.println(names[position] + "选中");
          
            }
          
            public void onNothingSelected(AdapterView<?> parent) {
           
            }
       
        });
  
    }

}

**结果截图：**


![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040113555315.png)

（2）

**主要代码：**

**.test2.java：**

public class test2 extends AppCompatActivity {
  
    @Override
 
    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.test2xml1);
   
    }
  
    public void click(View view){
       
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(R.layout.test2xml2).
         
                setNegativeButton("Cancel", null).
          
                setPositiveButton("Sign in", null).create();
      
        alertDialog.show();
   
    }

}

**test2xml1.xml：**

<?xml version="1.0" encoding="utf-8"?>

<android.support.constraint.ConstraintLayout 

xmlns:android="http://schemas.android.com/apk/res/android"
   
    xmlns:app="http://schemas.android.com/apk/res-auto"
   
    xmlns:tools="http://schemas.android.com/tools"
    
    android:layout_width="match_parent"
    
    android:layout_height="match_parent"
   
    tools:context=".test2">
   
    <Button
        
        android:layout_width="100dp"
        
        android:layout_height="60dp"
        
        android:text="Alert"
        
        app:layout_constraintTop_toTopOf="parent"
       
        app:layout_constraintLeft_toLeftOf="parent"
      
        app:layout_constraintRight_toRightOf="parent"
      
        android:onClick="click"/>

</android.support.constraint.ConstraintLayout>

**test2xml2：**

<?xml version="1.0" encoding="utf-8"?>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
  
    android:layout_width="match_parent"
  
    android:layout_height="match_parent"
   
    android:orientation="vertical">
  
    <ImageView
      
        android:layout_width="match_parent"
      
        android:layout_height="wrap_content"
       
        />
   
    <EditText
      
        android:layout_width="match_parent"
       
        android:layout_height="50dp"
      
        android:hint="Username"
       
        android:maxLines="1"/>
   
    <EditText
      
        android:layout_width="match_parent"
        
        android:layout_height="50dp"
      
        android:hint="Password"
     
        android:maxLines="1"
     
        />

</LinearLayout>

**结果截图：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190401140005898.png)

（3）

**主要代码：**

**test3.java：**

public class test3 extends AppCompatActivity {
 
    private TextView txt;
 
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.test3xml1);
    
    }
   
    public boolean onCreateOptionsMenu(Menu menu)//开发选项菜单重写的方法
  
    {
      
        MenuInflater inflater = new MenuInflater(this);//菜单动态加载类
      
        inflater.inflate(R.menu.test3,menu);//调用inflate方法解析菜单文件
      
        super.onCreateOptionsMenu(menu);
       
        return true;
    
    }
  
    public boolean onOptionsItemSelected(MenuItem mi){
       
        txt = (TextView)findViewById(R.id.txt);
        
        switch (mi.getItemId()){
         
            case R.id.font_10:
              
                txt.setTextSize(20);
              
                break;
          
            case R.id.font_16:
             
                txt.setTextSize(32);
              
                break;
        
            case R.id.font_20:
              
                txt.setTextSize(40);
              
                break;
           
            case R.id.red_font:
               
                txt.setTextColor(Color.RED);
                
                break;
          
            case R.id.black_font:
             
                txt.setTextColor(Color.BLACK);
             
                break;
            
            case R.id.plain_item:
            
                Toast toast =Toast.makeText(test3.this,"这是普通单击项",Toast.LENGTH_SHORT);
  
                toast.show();

                break;
  
        }
  
        return true;

    }

}

**结果截图：**

**颜色（以红色为例）：**


![在这里插入图片描述](https://img-blog.csdnimg.cn/20190401140324618.png)

（4）

**主要代码：**

**test4.java:**

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
      
                      mode.setTitle(listView.getCheckedItemCount()+" selected");
    
            }
     
            @Override
     
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

               switch (item.getItemId()) {
             
                    case R.id.i1:

                      mode.finish(); 
            
                        return true;
          
                    default:
         
                        return false;
       
                }
    
            }

            @Override
    
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            
               MenuInflater inflater = mode.getMenuInflater();
      
                inflater.inflate(R.menu.test4, menu);
         
                return true;
        
            }
        
            @Override
        
            public void onDestroyActionMode(ActionMode mode) {

            }
    
            @Override
    
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

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

**结果截图：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190401140459966.png)


















































