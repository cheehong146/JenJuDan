package com.itparadise.jenjudan.user.fragment.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.itparadise.jenjudan.R;
import com.itparadise.jenjudan.databinding.ActivityHomepageBinding;
import com.itparadise.jenjudan.user.adapter.Category.AdapterCategory;
import com.itparadise.jenjudan.user.adapter.Features.AdapterFeatures;
import com.itparadise.jenjudan.user.base.BaseFragment;

import java.util.ArrayList;
/*
import com.itparadise.jenjudan.user.adapter.Home.event.EventHappeningAdapter;
import com.itparadise.jenjudan.user.adapter.Home.happening.HomeHappeningAdapter;
import com.itparadise.jenjudan.user.adapter.Home.speaker.SpeakerAdapter;
import com.itparadise.jenjudan.user.base.helper.ListFilterHelper;
import com.itparadise.jenjudan.databinding.ActivityHomepageBinding;
import com.itparadise.jenjudan.user.fragment.home.events.EventDetailsFragment;
import com.itparadise.jenjudan.user.fragment.home.events.HomeAllEventFragment;
import com.itparadise.jenjudan.user.fragment.home.happenings.HappeningTimelineFragment;
import com.itparadise.jenjudan.user.fragment.home.merchandise.HomeAllMerchandiseFragment;
import com.itparadise.jenjudan.user.fragment.home.merchandise.MerchandiseAdapter;
import com.itparadise.jenjudan.user.fragment.home.merchandise.MerchandiseDetailsFragment;
import com.itparadise.jenjudan.user.fragment.home.speakers.HomeAllSpeakerFragment;
import com.itparadise.jenjudan.user.fragment.home.speakers.SpeakerDetailsFragment;
import com.itparadise.jenjudan.user.model.event.EventDetailed;
import com.itparadise.jenjudan.user.model.favourite.FavouriteList;
import com.itparadise.jenjudan.user.model.happening.lastestHappening.Happening;
import com.itparadise.jenjudan.user.model.mechandise.Merchandise;
import com.itparadise.jenjudan.user.model.speaker.SpeakerDetailed;
*/

/**
 * Created by IT Paradise on 21/8/2019
 **/

public class FragmentHome extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    protected ActivityHomepageBinding binding;

    private static final String TAG = "MainActivity";

    private ArrayList<String> featureNames = new ArrayList<>();
    private ArrayList<String> featureImageUrls = new ArrayList<>();
    private ArrayList<String> categName = new ArrayList<>();
    private ArrayList<String> categLocation = new ArrayList<>();
    private ArrayList<String> categImageUrl = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavouriteFragment.
     */
    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        initFeatureContent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.activity_homepage, container, false);

        uiHelper.setStatusBarTransparent(true);
        uiHelper.setPaddingTopBelowStatusBar(binding.homeImg);

        binding.swipeRefresh.setOnRefreshListener(this);

        LinearLayoutManager lm_feature = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rvFeature = binding.rvFeature;
        rvFeature.setLayoutManager(lm_feature);
        AdapterFeatures adapterFeatures = new AdapterFeatures(featureNames, featureImageUrls, getContext());
        rvFeature.setAdapter(adapterFeatures);

        LinearLayoutManager lm_category = new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL, false);
        //lm_category = new GridLayoutManager(getContext(),12);
        RecyclerView rvCategory = binding.rvCategory;
        rvCategory.setLayoutManager(lm_category);
        AdapterCategory adapterCategory = new AdapterCategory(categName,categLocation, categImageUrl, getContext());
        rvCategory.setAdapter(adapterCategory);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.location, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerCategory.setAdapter(adapter);
        binding.spinnerLocation.setAdapter(adapter2);
        binding.spinnerLocation.setVisibility(View.INVISIBLE);
        binding.spinnerCategory.setVisibility(View.INVISIBLE);
        binding.homeBtnCateg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.spinnerCategory.performClick();
            }
        });

        binding.homeBtnLocat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.spinnerLocation.performClick();
            }
        });


        //setupListener();

        return binding.getRoot();

    }

@Override
public void setupListener() {

}

    /**
     * listener related
     */
    ClickListener listener;

    public void setupListener(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public interface ClickListener {
        void goToFragment(Fragment fragment);

        void fetchHomeApiData();

        void goBack();
    }

    private void initFeatureContent(){
        Log.d(TAG, "initFeatureContent");

        featureImageUrls.add("https://pickledplum.com/wp-content/uploads/2019/02/homemade-bubble-tea-4OPTM.jpg");
        featureNames.add("French Tea With Red Bean");

        featureImageUrls.add("https://images.says.com/uploads/story_source/source_image/696069/0a76.jpg");
        featureNames.add("Extreme Bubble");

        featureImageUrls.add("https://ichef.bbci.co.uk/news/660/cpsprodpb/17872/production/_107407369_tea.png");
        featureNames.add("Sugarless Tea");

        featureImageUrls.add("https://www.vitamix.com/media/other/images/500xNxIced-Matcha-Bubble-Tea-470-449.jpg.pagespeed.ic.20R5IQCOGA.jpg");
        featureNames.add("Diet Set");

        categImageUrl.add("https://hoodline.imgix.net/uploads/story/image/34081/17523251_1418625778201394_279125323341231461_n.jpg");
        categLocation.add("Jalan Lolok");
        categName.add("Fantasy Treasure");

        categImageUrl.add("https://sc01.alicdn.com/kf/HTB1WzZsLpXXXXaUXVXXq6xXFXXXs/2014-Hot-Sale-3D-Design-Bubble-Tea.jpg");
        categLocation.add("Parkson Hill");
        categName.add("Matcha Expert");

        categImageUrl.add("https://i.pinimg.com/originals/48/81/8e/48818e2f765c9281d9ce7db017997f9c.jpg");
        categLocation.add("MidValley Level 3");
        categName.add("Latte Catte");

        categImageUrl.add("https://business-asset.com/watermark/salebiz/59f01d16a0821.jpg");
        categLocation.add("MidValley Level 2");
        categName.add("Matcha Lotcha");

        categImageUrl.add("https://trademe.tmcdn.co.nz/photoserver/plus/933715986.jpg");
        categLocation.add("MidValley Level 1");
        categName.add("No Joke");

        categImageUrl.add("https://d1dxs113ar9ebd.cloudfront.net/225batonrouge/2019/01/43-Teatery-1024x683.jpg");
        categLocation.add("MidValley Level LG");
        categName.add("Gossim");

        categImageUrl.add("https://cdn.styleblueprint.com/wp-content/uploads/2016/01/SB-Atlanta-bubbletea-honeybubble-counter-800x541.jpg");
        categLocation.add("MidValley Level G");
        categName.add("BlackBubble");

        categImageUrl.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/eaeeb211497827.560f8a57c31f2.jpg");
        categLocation.add("MidValley Level 2");
        categName.add("Fantasy Drink");

        categImageUrl.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/eaeeb211497827.560f8a57c31f2.jpg");
        categLocation.add("MidValley Level 2 Juga");
        categName.add("Fantasy Drink Dua");
    }

}

