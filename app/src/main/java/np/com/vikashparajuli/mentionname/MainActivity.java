package np.com.vikashparajuli.mentionname;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import np.com.vikashparajuli.mentionname.adapter.NameAdapter;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener,
        NameAdapter.RecyclerVisibilityListener {

    private Activity mActivity;
    private RecyclerView rcView;
    private EditText etName;
    private RelativeLayout rlRoot;

    private ArrayList<String> userNames;
    private NameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        rcView = (RecyclerView) findViewById(R.id.rcView);
        etName = (EditText) findViewById(R.id.etName);
        rlRoot = (RelativeLayout) findViewById(R.id.rlRoot);

        userNames = new ArrayList<>();
        userNames.add("Vikash Parajuli");
        userNames.add("Yemuna DKGN");
        userNames.add("Shubheksha Gautam");
        userNames.add("Sagar Pokhrel");
        userNames.add("Chandra Adhikari");
        userNames.add("Bikash Ghimire");
        userNames.add("Suvash Pokhrel");
        userNames.add("Prakash Silwal");
        userNames.add("Sajan Pokhrel");
        userNames.add("Ram Kumar Adhikari");
        userNames.add("Bijesh Shrestha");
        userNames.add("Pankaj Kharel");
        userNames.add("Suresh Bashnet");

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rcView.setLayoutManager(mLayoutManager);
        rcView.setItemAnimator(new DefaultItemAnimator());

        etName.addTextChangedListener(this);
        rlRoot.setOnClickListener(this);

        adapter = new NameAdapter(mActivity, userNames);
        rcView.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        listOperation(s.toString());
    }

    private void listOperation(String s) {
        if (rcView.getVisibility() == View.GONE)
            rcView.setVisibility(View.VISIBLE);
        adapter.filter(s);

        ViewGroup.LayoutParams params = rcView.getLayoutParams();
        if (params.height > 300)
            params.height = 300;
        rcView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        rcView.setVisibility(View.GONE);
    }

    @Override
    public void setVisibility(boolean bool) {
        if (bool)
            rcView.setVisibility(View.VISIBLE);
        else rcView.setVisibility(View.GONE);
    }
}
