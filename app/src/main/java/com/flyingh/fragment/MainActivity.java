package com.flyingh.fragment;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            HeadlinesFragment headlinesFragment = new HeadlinesFragment();
            headlinesFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.fragment_container, headlinesFragment).commit();
        }
    }

    @Override
    public void onHeadlineSelected(int position) {
        ArticleFragment articleFragment = (ArticleFragment) getFragmentManager().findFragmentById(R.id.fragment_article);
        if (articleFragment != null) {
            articleFragment.updateArticleView(position);
        } else {
            articleFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.POSITION, position);
            articleFragment.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, articleFragment).addToBackStack(null).commit();
        }
    }
}
