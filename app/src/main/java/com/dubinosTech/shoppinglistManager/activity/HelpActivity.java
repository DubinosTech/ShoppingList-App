package com.dubinosTech.shoppinglistManager.activity;
/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.dubinosTech.shoppinglistManager.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        TextView textView = findViewById(R.id.help_text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(("HELP - Use Guide")));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("1->* To create a new List: Click on the three vertical points on the home screen and click Create new list"));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("2->* To delete a list: choose the list you want to delete from the list menu on the home page, " +
                "then Click on the three vertical points on the home screen and click delete"));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("3->* To add an item to the list: click on the plus button, " +
                "give a name and a quantity and click on he check button in the left"));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("4->* To modify an item: click and hold the item"));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("5->* To check an item: click on the item"));
        textView.append("\n");
        textView.append("\n");
        textView.append(Html.fromHtml("6->* To delete an item: swipe to the right"));
    }
}
