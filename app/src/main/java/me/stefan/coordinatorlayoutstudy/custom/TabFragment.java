package me.stefan.coordinatorlayoutstudy.custom;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import me.stefan.coordinatorlayoutstudy.R;
import me.stefan.coordinatorlayoutstudy.adapter.SimpleStringAdapter;

/**
 * Author:  andy.xwt
 * Date:    2018/8/8 15:29
 * Description:
 */

public class TabFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private String mText;

    public static Fragment newInstance(String text) {
        Bundle args = new Bundle();
        TabFragment fragment = new TabFragment();
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mText = getArguments().getString("text");
        initView(view);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new SimpleStringAdapter(initStrings(), getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    private List<String> initStrings() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(mText);
        }
        return list;
    }
}
