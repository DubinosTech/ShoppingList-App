

package com.dubinosTech.shoppinglistManager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.dubinosTech.shoppinglistManager.R;

/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView textView = findViewById(R.id.about_text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(getString(R.string.about_title)));
        textView.append(Html.fromHtml("SEG 3125 FINAL PROJECT"));
        textView.append("\n");
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("Made by DubinosTech"));
        textView.append("\n");
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("Brahim Kanouche"));
        textView.append("\n");
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("Emmanuel Asinyo"));
        textView.append("\n");
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("For feedbacks, suggestions or more information: bkano020@uottawa.ca")); }

}
